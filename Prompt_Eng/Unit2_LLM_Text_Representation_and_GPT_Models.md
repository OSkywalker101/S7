# Unit 2: LLM, Text Representation and GPT Models

> Course: Prompt Engineering for Generative AI (CI72) | Sources: `Large Language Models ConceptsAtkinson.md` (§3), `LLM.md` (Alammar slides), `Prompt Engineering LLMsBerryman.md`

---

## 1. Introduction to Large Language Models (LLMs)

### 1.1 What are LLMs?
- **Large Language Model** = a large-scale neural network (transformer) pre-trained on **very large text corpora** to **predict the next token** (autoregressive) or to fill masked tokens.
- "Large" refers to **model size** (billions of parameters: GPT-2 1.5B, GPT-3 175B, LLaMA 7–65B, PaLM 540B) **and** enormous training data.
- Built on the **transformer** (Unit I). Popular types: **GPT, BERT, PaLM, LLaMA, LaMDA, Megatron** (Atkinson Ch.3).

### 1.2 How do LLMs "see the world"?
- LLMs learn **statistical patterns over tokens**, not real-world understanding. They have **no continuous interaction with the world** — only the knowledge encoded at training time.
- Consequence: **hallucinations** — confident, fluent, but **false or made-up** content (invented references, facts, names).
- Berryman analogy: a model trained on {"Paris is the capital of France"} interpolates that *Paris is* the capital — but if the fact isn't in training it will **confabulate** (not intentionally lie).

> **Trick for answers — hallucination vs lie:** *"Hallucinations don't differ from other completions — they are just completions of confabulated patterns. There is no intent to deceive."* Quote: *"The best antidote to hallucinations is ... retrieval-augmented generation (RAG)"* (Unit V).

### 1.3 Applications of LLMs (MEMORIZE list)
- Chatbots & conversational agents (ChatGPT-like), text summarization, machine translation, question answering, code generation, content creation, sentiment analysis, classification, named-entity recognition, information extraction, semantic search / RAG pipelines, instruction following & agents.

### 1.4 Emergent skills & corpora (Atkinson 3.1.1–3.1.3)
- **Emergent skills:** reasoning, in-context learning, instruction following that appear only at large scale.
- **Corpora:** massive unlabelled text (books, web, GitHub, Wikipedia); quality-filtered for pre-training (GPT-2 used Reddit-curated pages).
- Types of training/learning: **self-supervised pre-training**, then **supervised fine-tuning**, and **RLHF** — all discussed below.

---

## 2. How LLMs Process Text — Tokenization

### 2.1 LLM tokenization
- Tokens are the **atomic units** of text for an LLM. A text fragment → sequence of vocabulary items called **tokens**, then → **token IDs** (unique indices).
- **How tokenizers prepare inputs:** (1) break text into tokens; (2) map to IDs; (3) add **special tokens** — typically **BOS** (begin-of-sequence), **EOS** (end-of-sequence), **[MASK]** (masked LM), padding tokens.

### 2.2 Word vs Subword vs Character vs Byte tokens (comparison — exam favourite)
| Level | Vocabulary = | Example "We want a complete pre-report" | Pros | Cons |
|---|---|---|---|---|
| **Character** | alphabet + punctuation | ~31 tokens (`Q`,`u`,` `, …) | Tiny vocab, handles any word | Very long sequences, weaker semantics |
| **Word** | all words of the language | 4–5 tokens | Short sequences, rich semantics | Huge vocab; **cannot handle new/unknown words** (OOV) |
| **Subword** | common segments + single chars | "pre-report" → pre/report… | **Best balance**: handles OOV, reasonable vocab size | Needs careful merging rules (BPE) |
| **Byte** | byte values (0–255) | bytes of UTF-8 | Handles **any** UNICODE script | Longer sequences; less linguistically meaningful |

### 2.3 Subword tokenization algorithms (BPE & friends)
- **Byte-Pair Encoding (BPE):** iteratively merge the most frequent adjacent pairs of symbols into new tokens (used by GPT family).
- Others: **WordPiece** (BERT — merges to maximize likelihood), **Unigram / SentencePiece** (language-model-based, handles subwords + whitespace; used by LLaMA/PaLM).
- Common words stay as single tokens; rare words split into known subwords; single characters **guarantee every word is expressible**.

### 2.4 Comparing trained LLM tokenizers (exam discussion points)
- Different models → different vocab & **tokenization behavior** (Berryman).
- **Tokenization pitfalls affect the prompt token count & even output quality:**
  - e.g., curse words or names may split oddly; token boundaries shift with spelling ("STRA"+"NGE"+" NEW"+"WORLDS" example from Berryman).
  - Cost: **each token ~ costs money** → prompt length matters.
- **Tokenizer properties to know:** vocab size (GPT-2: 50,257; Llama-2: 32,000), case handling, whitespace handling, digit tokens, merge rules, unknown-token fallback.

### 2.5 Why tokenization *matters* for prompting
- Counting/limiting tokens (context window), formatting few-shot snippets, avoiding unpredictable splits of identifiers — all relate to how the tokenizer cuts text, so the *prompt engineer* must design for tokens, not characters.

---

## 3. Embeddings — From Words to Meaning

### 3.1 Bag-of-Words (what we leave behind)
- BOW ignores word **order and semantic meaning** — sparse, high-dimensional one-hot counts.

### 3.2 Dense vector embeddings
- **Embeddings** = dense vector representations that **capture meaning** (semantics), not just counts.
- **Word2vec** — one of the first successes: static, downloadable word vectors; captures analogies (king – man + woman ≈ queen).

### 3.3 Static vs Contextual embeddings (crucial)
- Word2vec is **static**: "bank" has ONE vector though it means *financial bank* or *river bank*.
- Context **changes meaning** → need contextual embeddings where each token's vector depends on the words around it.
- **BERT** produces contextual embeddings (bidirectional, masked-language-model pretraining). (Atkinson 3.2)
- Modern LLMs produce **contextual token embeddings** at the last hidden layer — these power semantic search, retrieval and RAG.

> **Trick:** For embedding questions give the **bank example** (financial vs river) — it's used in both Alammar's slides and Atkinson, and instantly proves you understand contextualization.

---

## 4. The LLM Landscape — BERT & GPT Family (Atkinson 3.2, 3.3)

### 4.1 BERT (Bidirectional Encoder Representations from Transformers)
- **Encoder-only** transformer (uses only encoder stack).
- **Bidirectional:** reads left + right context simultaneously.
- Pre-training tasks (MEMORIZE):
  - **Masked Language Modeling (MLM):** 15% tokens randomly masked; of those, 80% → `[MASK]`, 10% → random token, 10% unchanged; model predicts masked words from context.
  - **Next Sentence Prediction (NSP):** given sentence pair A+B, predict `IsNext` / `NotNext`.
- Input: `[CLS]` + sentence A + `[SEP]` + sentence B + `[SEP]`, with token + segment + positional embeddings.
- **Limitations:** NOT generative; fixed input (512); needs fine-tuning for tasks; unidirectional attention — motivation for GPT.

### 4.2 GPT = Generative Pre-trained Transformer
- **Decoder-only** transformer using **masked self-attention** (no looking ahead).
- Name decomposition (MEMORIZE):
  - **G**enerative — trained to predict/generate the next token (unsupervised, self-supervised).
  - **Pre-trained** — huge corpus → reusable for many tasks without training from scratch.
  - **Transformer** — encoder-decoder + attention architecture.
- Autoregressive loop: after each token is generated it is appended to the input, then the model predicts the next, etc.

### 4.3 GPT-1 → GPT-2 (three innovations — exam favourite)
1. **Task conditioning:** reformulate training objective `P(output|input)` → `P(output|input, task)` so the same model performs multiple tasks (via prompts/examples in the input). Basis of **zero-shot task transfer**.
2. **Zero-shot learning & task transfer:** format inputs to indicate task — e.g., English → French: *"english: <sentence> french:"* → model returns the translation without task-specific fine-tuning.
3. **Architecture scaling:** GPT-2 = **1.5B params** (10× GPT's 117M), 48 layers, 1600-dim embeddings, **50,257-token vocab**, 1024-token context, layer-norm after final self-attention block.

- **GPT-2 facts to quote:** trained on 40 GB of internet text curated by humans (Reddit links); performs QA, comprehension, summarization, and translation **without** task-specific training data; 144 attention patterns via 12 layers × 12 heads.

### 4.4 Masked self-attention in GPT (decoder-only)
- The attention mask blocks tokens **to the right**: only present and previous tokens are attended.
- Implemented as an **attention mask** array; e.g., for "John bought a book" the row for "bought" has zeros for "a"/"book".
- This produces an **autoregressive** LM: output at time t feeds input at time t+1.

### 4.5 GPT-3 (175B)
- Dramatically larger scale + **in-context learning**: few-shot prompting (a.k.a. "Language Models are Few-Shot Learners", 2020 paper).
- No gradient updates needed at task time; the prompt itself (with a few examples) conditions the model.

### 4.6 GPT-4
- Multimodal-capable, instruction-tuned, higher alignment & reasoning; improved safety.

### 4.7 RLHF (Reinforcement Learning from Human Feedback) — the align step
1. **Supervised fine-tuning (SFT):** fine-tune on human-written instruction-following pairs.
2. **Reward model:** train a model to rank/score responses by human preference.
3. **RL optimization (PPO):** optimize the policy to maximize the reward model's score (with KL penalty).
- Result: models that **follow instructions**, are more helpful/honest, and less harmful. (Recall: OpenAI's *InstructGPT*.)
- Berryman notes RLHF models are **especially good at following explicit instructions** (system prompt obedience) and at **few-shot prompting**.

---

## 5. Hallucinations — How LLMs "see" the world (Berryman + Atkinson)

- Definition: model **inventing non-existent or erroneous facts** (Atkinson 3.x) — confident, grammatical, but wrong.
- Causes:
  - Training objective optimizes likelihood, **not truth** (a "truth bias" does not exist natively);
  - model has **no access to the ground truth** or up-to-date world state;
  - prompts that imply/reference nonexistent contexts **induce** hallucination;
  - **confabulation** (interpolating patterns), not deliberate deception;
  - counterfactual/hypothetical situations nudge the model to invent.
- Mitigations (preview): provide background/reference in prompt; **chain-of-thought** (reasoning reduces false leaps); **RAG** (ground generation in retrieved docs — Unit V); evaluation + verification loops (Unit III).
- Ethical dimension: hallucinations → misinformation, legal/medical risk, eroded trust (ties to AI ethics!).

---

## 6. Token Embeddings vs Text Embeddings vs Word Embeddings (clarify once and for all)

| Term | Level | Meaning | Example |
|---|---|---|---|
| **Word embedding** | Word | Vector for a *word* from a pretrained model | word2vec `bank`→vector |
| **Token embedding** | Token (subword) | Vector for a *subword token* (learned lookup table, plus positional info) | GPT embedding matrix |
| **Text/document embedding** | Whole text | Single vector for a sentence/paragraph/document; used for **semantic similarity search** | `text-embedding-ada-002` (1536-d), MiniLM (384-d) |
| **Contextual embedding** | In-context token | Per-token vector **differing by context** (BERT/GPT hidden states) | "bank" in financial vs river sentence |

- Text embeddings power **vector databases** (Unit V): similar meaning ⇒ nearby vectors (cosine similarity).

---

## 7. Quick Revision & Exam Strategy

### One-liners
- LLM = transformer trained to predict next token on huge corpora.
- Tokenization: character/word/subword/byte; subword (BPE) is the sweet spot; special tokens BOS/EOS/MASK.
- Embeddings: dense semantic vectors; static (word2vec) vs contextual (BERT/GPT).
- BERT = encoder-only + MLM + NSP; GPT = decoder-only + masked self-attention (autoregressive).
- GPT-2: 1.5B params, zero-shot task transfer; GPT-3: in-context (few-shot) learning; GPT-4: aligned + multimodal.
- RLHF: SFT → reward model → PPO.
- Hallucinations = fluent falsehoods; antidotes: references, CoT, RAG.

### Likely exam questions
1. What is an LLM? Enumerate applications and explain how LLMs "see the world" (hallucinations).
2. Explain tokenization and compare word vs subword vs character vs byte tokens. (10 marks)
3. How does the tokenizer prepare the model input? What are BOS/EOS/mask tokens?
4. Distinguish static (word2vec) vs contextual embeddings; explain the "bank" example.
5. Compare BERT and GPT (architecture, pre-training objectives, generative ability).
6. Explain GPT-2's three innovations (task conditioning, zero-shot transfer, architecture scaling).
7. Explain RLHF pipeline for instruction-following LLMs.
8. Explain hallucinations: causes and prevention techniques.

### Tips & Tricks
- Use the **pyramid/architecture contrast**: BERT (encoder-only, bidirectional) vs GPT (decoder-only, causal mask) vs T5/transformer (encoder-decoder) — one line of the drawing answers half the exam.
- For tokenizer questions, present the **BPE merge example**: "low lower newest" → "low/low/er/new/est" merging frequent pairs — practical BPE demonstration scores well.
- Quote GPT-2's exact numbers (1.5B, 48 layers, 1600-dim, 50,257 vocab, 1024 context) — examiners reward precision.
- When "applications" is asked, organize as: generation / comprehension / retrieval / agentic four buckets.
- Always attach a **hallucination mitigation** (RAG/CoT/references) even when not explicitly asked — shows command of the *whole syllabus*.

---
*Sources: syllabus.txt (Unit II); Large Language Models ConceptsAtkinson.md §3; LLM.md; Prompt Engineering LLMsBerryman.md (tokenization pitfalls, hallucination, RLHF).*