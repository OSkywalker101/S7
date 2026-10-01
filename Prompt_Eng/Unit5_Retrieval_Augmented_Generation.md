# Unit 5: Retrieval Augmented Generation (RAG)

> Course: Prompt Engineering for Generative AI (CI72) | Sources: `dokumen.pub_prompt-engineering-for-generative-ai-9781098153434.md` (Ch.5/6 — RAG, vector databases, RAG-with-LangChain), `Prompt Engineering LLMsBerryman.md` (RAG chapter), `Large Language Models ConceptsAtkinson.md` (vectors/QA with Chroma)

---

## 1. Why RAG? — The Hallucination Problem (motivation)

- LLMs generate from **statistical patterns** (Unit II) and **hallucinate** when asked about facts beyond training data / context window.
- Two limits of a plain LLM:
  1. **Stale/no knowledge** — training cutoff.
  2. **No external memory** beyond the context window.
- **RAG (Lewis et al., 2020)** = *retrieve* relevant documents from an external source **at query time**, and *augment* the prompt with them, *then generate*.
- Berryman: *"RAG is a pattern of prompting in which the application first retrieves relevant context and then asks the LLM to generate based on it."*
- It is the **standard antidote to hallucinations** and enables grounded, current, verifiable answers.

> **Example (Phoenix):** a chatbot told *"My name is Mike"* and later asked *"What is my name?"*: if 3,000 messages ago, the name is outside the context window → without RAG it hallucinates; with a **vector search** it retrieves the top-3 most similar past messages and answers correctly.

---

## 2. Key Concepts and Components

### 2.1 The RAG triad
1. **Ingestion (indexing)** — process external documents into a searchable index.
2. **Retrieval** — given the user query, fetch the **most relevant** text chunks.
3. **Generation** — give the LLM a prompt = query + retrieved context → grounded answer.

### 2.2 RAG vs memory vs fine-tuning (know the contrast)
| Approach | What changes | Cost / freshness |
|---|---|---|
| **RAG** | Adds retrieved context at inference (no weight change) | Cheap, **always fresh**, auditable |
| **Fine-tuning** | Updates model weights on domain data | Expensive, stale, risks overfit/hallucination |
| **In-context (few-shot)** | Teaches format/examples only | Limited by context window |
- RAG "augments" rather than "re-trains" — best of both for **knowledge-heavy QA**.

---

## 3. How RAG Improves Question Answering

1. **Grounds answers** in retrieved evidence → fewer hallucinations.
2. **Answers current questions** (not frozen at training cutoff).
3. **Citations/verifiability** — the source text is right in the prompt.
4. **Private/corporate data** can be queried without exposing it in training.
5. **Scales**: only the most relevant tokens enter the context — **stays within the context window** and **avoids wasted token cost** from irrelevant documents (Phoenix).

---

## 4. RAG Architecture (4 production steps — MEMORIZE, Phoenix)

```
Document(s)
   ↓ (1) Break into chunks of text            [chunking / text splitting]
   ↓ (2) Index chunks in a vector database     [embeddings + vector store]
User query
   ↓ (3) Search by vector for similar records  [semantic similarity]
   ↓ (4) Insert records into the prompt as context [→ LLM → grounded answer]
```

```
         ┌────────────┐      ┌───────────┐     ┌────────────┐
 queries │  Retriever │─────▶│  Context  │────▶│  Generator │
   ─────▶│  (embed +  │      │  assembly │     │   (LLM)    │──▶ Answer
         │   search)  │      │ (prompt)  │     │            │
         └────────────┘      └───────────┘     └────────────┘
```

### 4.1 Components
- **Embedding model** — converts text into dense vectors (Unit II text embeddings).
- **Vector database / index** — stores vectors + supports **k-NN similarity search**.
- **Retriever** — query lookup returning the **top-k** most similar chunks.
- **Prompt template** — "Answer based only on the following context …" (grounding instruction).
- **LLM (generator)** — produces the grounded answer (Optionally: reranker, citations).

---

## 5. Building the Retrieval System: Embeddings & Vector Databases

### 5.1 Embeddings
- **Embedding** = vector representation of a text returned by a pretrained model; semantic meaning ⇒ nearby vectors.
- Standard embedding models: **OpenAI `text-embedding-ada-002`** (1,536 dimensions), Hugging Face **`sentence-transformers/all-MiniLM-L6-v2`** (384-d), etc.
- More dimensions ⇒ deeper semantic capture (2-D separates cats/dogs; 300-D captures breeds/colors).
- **Cost note (Phoenix):** ada-002 ≈ $0.0004 / 1k tokens — e.g., King James Bible (~4M tokens) ≈ $1.60 to embed entirely.

### 5.2 Vector databases
- **Open-source / local:** **FAISS** (efficient similarity search), **ChromaDB**, (also Weaviate self-hosted).
- **Hosted:** **Pinecone**, Weaviate Cloud, Chroma Cloud; DBs adding vectors (Supabase `pgvector`).
- Hosted advantages: **no maintenance, automatic scaling, reliability (SLA+backups), optimized performance, support, security/compliance** (encryption, access control, GDPR).
- Trade-offs: **cost / overspending risk, vendor lock-in, third-party privacy**.
- **Self-querying vector store:** model rewrites the query into structured filters before the vector search (`SelfQueryRetriever`).
- Query flow: embed the user query → cosine/dot similarity vs all vectors → top-k chunk IDs → fetch text.

---

## 6. RAG Data Ingestion Pipeline

### 6.1 Preprocessing documents (esp. PDFs)
- **PDF preprocessing steps:**
  1. Extract text (document loaders: `PyPDFLoader`, `Unstructured`, `AsyncHtmlLoader` for webpages).
  2. **Clean** text (remove headers/footers, page numbers, broken tables).
  3. **Chunk / split** into semantically coherent pieces (see §8 — critical!).
  4. (Optional) metadata: source, page, section, date — enables filtering/citation.
- Goals: preserve semantics, keep chunks within the embedding model's limit, minimize noise.

### 6.2 Data ingestion pipeline implementation (LangChain)
```python
from langchain.document_loaders.unstructured import …   # load PDFs/docs/web
from langchain.text_splitter import CharacterTextSplitter / RecursiveCharacterTextSplitter
from langchain.embeddings import OpenAIEmbeddings
from langchain.vectorstores import Chroma / FAISS
loader   → docs
splitter → chunks
embedder → vectors
vectorstore = Chroma.from_documents(chunks, embeddings)   # index chunks
retriever = vectorstore.as_retriever()                    # ready for queries
```
- Atkinson's worked QA example uses exactly this stack (unstructured loader → `CharacterTextSplitter` → `OpenAIEmbeddings` → **Chroma** → `RetrievalQA`).

### 6.3 Generation component implementation (LCEL chain — Phoenix)
```python
from langchain_community.vectorstores.faiss import FAISS
from langchain_core.output_parsers import StrOutputParser
from langchain_core.prompts import ChatPromptTemplate
from langchain_core.runnables import RunnablePassthrough
from langchain_openai import ChatOpenAI, OpenAIEmbeddings

vectorstore = FAISS.from_texts(documents, embedding=OpenAIEmbeddings())
retriever   = vectorstore.as_retriever()
prompt = ChatPromptTemplate.from_template(
    "Answer the question based ONLY on the following context:\n"
    "---\nContext: {context}\n---\nQuestion: {question}\n")
model = ChatOpenAI()

chain = ({"context": retriever, "question": RunnablePassthrough()}
         | prompt | model | StrOutputParser())

chain.invoke("What is data engineering?")
```
- `retriever` feeds top-k docs into `{context}`; `RunnablePassthrough` forwards the raw question.
- **Grounding effect:** `"What is the president of the US?"` → *"I don't know"* — because it's **not in the retrieved context** and the prompt bans external knowledge!

---

## 7. Impact of Text Splitting on RAG (exam-hot topic)

Why split at all? Large documents exceed the embedding/context limits and match poorly.

| Splitting choice | Effect |
|---|---|
| **Chunk size (tokens)** | Too large → diluted semantics, more tokens/cost, distant context noise; too small → fragment meanings, weak matches |
| **Overlap** | Overlapping chunks keep context continuity across splits |
| **Splitter type** | Recursive (on `\n\n`, `\n`, spaces, chars — structural boundaries) vs fixed character count vs semantic heading-based |
| **Sentences/paragraphs** | Semantic units make better matches than arbitrary cuts |
- Poor splitting ⇒ retrieved context **irrelevant or broken** ⇒ RAG fails even with a perfect encoder & LLM.
- Practical rules: chunk ~300–800 tokens; recursive on natural boundaries; attach metadata; consider **hybrid (keyword+vector) retrieval** and **rerankers** to polish top-k.

---

## 7.1 Semantic Search: the Three Building Blocks

Before RAG there is **semantic search** — searching *by meaning* rather than keyword matching. Alammar & Grootendorst (Hands-On LLMs, Ch.8) classify LM-based search into **three** categories; this taxonomy is a very common exam question.

| Category | Input | Output | Core idea |
|---|---|---|---|
| **1. Dense retrieval** | query | relevant docs | Embed query & docs; return **nearest neighbours** in embedding space |
| **2. Reranking** | query **+ a set of candidate results** | reordered results | Score each candidate's relevance to the query; re-order |
| **3. RAG** | query | generated answer (+ citations) | Retrieval **then** grounded generation by an LLM |

### 7.1.1 Dense retrieval — how it works
- Each text becomes a **point in space**; *similar meaning ⇒ close together* (Unit II text embeddings).
- Query is embedded into the **same space** as the archive → find the nearest documents → those are the results.
- **BM25** = the leading **lexical/keyword** search baseline; **dense retrieval** beats it when the query shares *no* keywords with the answer.
  - Worked example: query *"how precise was the science"* → BM25's top hit was the sentence containing the literal word "science" but **not** the answer; dense retrieval correctly returned *"praise from many astronomers for its scientific accuracy…"*.
- Indexes: **FAISS** / **Annoy** for approximate nearest-neighbour search at millions-of-vectors scale; **vector DBs** (Pinecone, Weaviate) add/delete vectors without rebuilding the index and support **metadata filtering** beyond pure distance.
- **Caveats:** (a) always returns *something*, even when the answer is absent → set a **max-distance threshold**; (b) poor at **exact-phrase** matches → use **hybrid search**; (c) degrades **out of domain** (trained on web → weak on legal text); (d) questions spanning multiple sentences expose chunking as a key design parameter.
- **Fine-tuning embeddings for retrieval:** build training pairs from *queries + relevant results*, plus **negative examples**; the objective pulls relevant queries closer to the document and pushes irrelevant ones farther.

### 7.1.2 Reranking
- A **second-stage** model scores a **shortlist** (e.g. 100–1000) from a first-stage retriever (keyword, dense, or hybrid).
- **How it works:** present the **query and each document together** as a **cross-encoder**, output a relevance score 0–1 → effectively a **classification** problem (*monoBERT*; "Multi-stage document ranking with BERT"). Documents are batched but evaluated **independently** against the query.
- Massive gains: on the multilingual **MIRACL** benchmark a reranker lifts **nDCG@10 from 36.5 → 62.8**.
- 💡 **Exam line:** *Reranking is cheap to adopt (no re-training of the index, plug at the end of an existing pipeline) and dramatically reorders results — this is exactly what Microsoft Bing did with BERT-like models.*

### 7.1.3 Chunking long texts — why and how
- Transformers have a **limited context size**, so long documents cannot be embedded whole.
- **One vector per document:** (a) embed only a representative part (title/opening — fast, but leaves information **unindexed**); (b) chunk → embed chunks → **average** into one vector (highly compressed, loses information). Both are inferior.
- **Multiple vectors per document (preferred):** chunk, embed each chunk → full coverage, vectors capture **individual concepts**.
- Chunking options: **each sentence** (too granular, loses context) · **each paragraph** (or every 3–8 sentences) · add the **document title** to each chunk · **overlapping chunks** (text before/after appears in adjacent chunks) to prevent loss of context. Modern systems may even use an **LLM to split text dynamically**.

---

## 7.2 Evaluating Retrieval Systems

Evaluating search needs **three** components: a **text archive**, a **set of queries**, and **relevance judgements** (which documents are relevant per query).

**Counting relevant hits is not enough** — *position* matters. A relevant result at rank 1 is worth far more than at rank 3.

| Metric | Definition | Notes |
|---|---|---|
| **Precision@k** | relevant results in the top *k* ÷ *k* | denominator is the *position currently being examined* |
| **Average Precision (AP)** | average of precision at each position where a **relevant** result appears; **non-relevant results are ignored** (not penalised further) | 1 relevant doc at rank 1 ⇒ **AP = 1**; same doc at rank 3 ⇒ **AP ≈ 0.33** |
| **Mean Average Precision (MAP)** | mean of AP over **all** queries in the test suite | single number to compare two systems (Lewis et al., 2020) |
| **nDCG** | handles **graded** (non-binary) relevance via log-discounted gain | standard for reranking evaluation (see MIRACL above) |

> **Memory hook:** *Precision = "how good is what I showed"; AP = "how good *and* how early"; MAP = "average that over the whole test set".*

---

## 7.3 Advanced RAG Techniques

Each technique fixes a specific weakness of the basic pipeline. Learn them as **problem → fix** pairs.

| Technique | Problem it solves | How |
|---|---|---|
| **Query rewriting** | verbose questions, or questions referring to earlier turns ("*We have an essay due… I love penguins… let's do dolphins. Where do they live?*") | LLM rewrites into a standalone query → *"Where do dolphins live"* |
| **Multi-query RAG** | one question may need **several** distinct searches | generate N queries (e.g. *"Nvidia 2020 financial results"*, *"Nvidia 2023…"*), retrieve for each, merge top results |
| **Multi-hop RAG** | answers requiring **sequential dependent** searches | Step 1: *"largest car manufacturers 2023"* → results (Toyota, VW, Hyundai) → Step 2: one follow-up query per result |
| **Query routing** | relevant data lives in **multiple different sources** | model picks the source: HR questions → Notion; customer data → Salesforce CRM |
| **Agentic RAG** | complex problems needing the model to **decide what information it needs** | the LLM itself gauges information needs, uses multiple sources, and treats sources as **tools** (search *and* write) — i.e. the model starts behaving like an **agent** |

- 📈 **The trend:** each technique delegates *more* responsibility to the LLM — basic RAG (fixed pipeline) → query rewriting (LLM reformulates) → multi-query/multi-hop (LLM plans searches) → **agentic RAG** (LLM autonomously decides and acts). Modern managed models (e.g. Command R+) can attempt this behaviour.

---

## 7.4 RAG Evaluation — the Four Axes

Human evaluation is preferred, but **LLM-as-a-judge** automates it (the **Ragas** library scores these):

| Axis | Question it answers |
|---|---|
| **Fluency** | Is the generated text fluent and cohesive? |
| **Perceived utility** | Is the answer helpful and informative? |
| **Citation recall** | Are generated statements about the world **fully supported** by their citations? |
| **Citation precision** | Do the citations **actually support** the statements they are attached to? |

Ragas adds two more: **Faithfulness** (is the answer consistent with the provided context?) and **Answer relevance** (how relevant is the answer to the question?).

---

## 8. Challenges of RAG (list for exam)

1. **Chunking quality** — the retrieval ceiling (§7).
2. **Retrieval relevance** — wrong/partial top-k → misleading grounded answers; needs reranking & hybrid search.
3. **Latency & cost** — embedding + vector search + LLM generation; token spend grows with context.
4. **Data freshness & ingestion pipeline** — update/reindex strategy for changing source data.
5. **Hallucination persists** — model may ignore context, or hallucinate when context is **absent** ("I don't know" is the desired behaviour, needs prompting discipline).
6. **Security & privacy** — sensitive documents in hosted vector DBs; access control, compliance.
7. **Evaluation** — answer groundedness, faithfulness to the context, retrieval precision/recall (LangChain evals).
8. **Multi-modal & scale** — PDFs with tables/images, billion-record indexes.

---

## 9. Quick Revision & Exam Strategy

### One-liners
- RAG = Retrieve → Augment (context in prompt) → Generate.
- Fixes hallucinations, staleness, and context-window limits; enables verifiable grounding.
- Pipeline: chunk → index(embeddings) → semantic search top-k → prompt with **only** those chunks → LLM.
- Vector DBs: FAISS/Chroma (local) vs Pinecone/Weaviate (hosted).
- Text splitting is the **retrieval ceiling**; use recursive semantic chunks + metadata.
- **Three search categories:** dense retrieval (nearest neighbours) → **reranking** (score & reorder a shortlist; MIRACL 36.5→62.8) → **RAG** (retrieve, then generate).
- Retrieval metrics: **precision@k → AP → MAP**; **nDCG** for graded relevance.
- Advanced RAG ladder: query rewriting → multi-query → multi-hop → query routing → **agentic RAG**.
- Grounding instruction: *"Answer based only on the provided context"* → model says "I don't know" when absent.

### Likely exam questions
1. Explain RAG: key concepts, components, and how it improves QA. (10 marks)
2. Draw and explain the RAG architecture (ingestion, retrieval, generation).
3. Explain embeddings and vector databases with examples (open-source vs hosted).
4. Implement a RAG ingestion pipeline in LangChain (loader → splitter → embeddings → vectorstore → retriever).
5. Write the LCEL RAG chain; explain why out-of-context questions get "I don't know".
6. How does text splitting impact RAG? Discuss chunk size/overlap/splitter choice.
7. Enumerate the challenges of RAG and their mitigations.
8. Differentiate **dense retrieval, reranking and RAG**. Explain how a reranker works (cross-encoder) and why it helps. (10 marks)
9. Explain **precision@k, average precision and MAP** with an example; why is MAP needed when counting relevant hits is not enough?
10. Explain the advanced RAG techniques — query rewriting, multi-query, multi-hop, query routing and agentic RAG — with one example each.

### Tips & Tricks
- **Always draw the RAG architecture diagram** (document→chunks→vector DB→top-k→prompt→LLM→answer) — instant marks.
- Quote the **Mike-name example** (3,000 messages ago) to motivate retrieval & the "I don't know" result to prove grounding.
- Pair each RAG **challenge** with a **mitigation** (chunking→recursive splitter; relevance→rerank/hybrid; hallu→"answer only from context"; privacy→hosted vs self-hosted trade-off).
- Cross-link: embeddings (Unit II), prompt templates & LCEL/output parsers (Unit IV), evals (Unit IV), hallucination (Unit II).
- The course link (`rag_from_scratch` notebooks 10–11) walks the full end-to-end pipeline — lab answers mirror the 4 production steps in §4.
- **Draw the 3-category ladder** (dense retrieval → reranking → RAG) whenever "semantic search" is asked — it maps directly onto the syllabus line *"Building the Retrieval System"*.
- For reranking, always give the **cross-encoder = classification** framing and the **36.5 → 62.8 nDCG@10** figure on MIRACL.
- For MAP, use the *"1 relevant doc at rank 1 ⇒ AP=1, at rank 3 ⇒ AP≈0.33"* contrast — it demonstrates you understand why *rank* matters, which is the whole point of the metric.
- Present advanced RAG as a **ladder of increasing LLM autonomy** — examiners reward the trend narrative, not just the list.

---
*Sources: syllabus.txt (Unit V); dokumen.pub Ch.5/6 (RAG, embeddings, FAISS/Pinecone, RAG-with-LangChain); Prompt Engineering LLMsBerryman.md (RAG pattern); Large Language Models ConceptsAtkinson.md (vector-database QA workflow); Alammar & Grootendorst, Hands-On Large Language Models Ch.8 (semantic search, dense retrieval, reranking, chunking, retrieval evaluation metrics, advanced RAG techniques, RAG evaluation).*