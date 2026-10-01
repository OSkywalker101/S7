# Prompt Engineering for Generative AI (CI72) — Complete Notes

**Course:** Prompt Engineering for Generative AI | **Code:** CI72 | **Credits:** 2:1:0 | **Contact Hours:** 28L + 14T
**Coordinators:** Dr. A N Ramya Shree, Dr. Nithya N

Notes built **strictly from `syllabus.txt`**, using the prescribed textbooks. Each unit file ends with a *Quick Revision & Exam Strategy* section containing one-liners, likely exam questions and tips & tricks.

---

## Unit Notes

| # | File | Covers |
|---|---|---|
| 1 | [`Unit1_Generative_AI_Fundamentals_Autoencoders_GANs_Attention_Transformers.md`](Unit1_Generative_AI_Fundamentals_Autoencoders_GANs_Attention_Transformers.md) | GenAI definition & fundamentals; history & evolution from AI to GenAI; traditional vs generative AI; autoencoders (information bottleneck, latent variables, architecture, types); GAN (generative & discriminative models); attention models (encoder–decoder paradigm, attention to sequence models); transformers (encoder layer, positional encoding, residual connections, decoder layer, linear layer + SoftMax, training, inference, loss function) |
| 2 | [`Unit2_LLM_Text_Representation_and_GPT_Models.md`](Unit2_LLM_Text_Representation_and_GPT_Models.md) | LLMs (introduction, what are LLMs, applications); how LLMs see the world (hallucinations); how LLMs process text; LLM tokenization; how tokenizers prepare inputs; how the tokenizer breaks down text; word vs subword vs character vs byte tokens; comparing trained LLM tokenizers; tokenizer properties; token embeddings; text embeddings; word embeddings — plus the BERT / GPT / RLHF landscape |
| 3 | [`Unit3_Prompt_Engineering.md`](Unit3_Prompt_Engineering.md) | Introduction; basic ingredients of a prompt; instruction-based prompting; advanced prompt engineering; potential complexity of a prompt; in-context learning (providing examples); chain prompting; reasoning with generative models; chain-of-thought; self-consistency; tree-of-thought; output verification; grammar-constrained sampling; prompt design & optimization |
| 4 | [`Unit4_LangChain.md`](Unit4_LangChain.md) | Introduction to LangChain; chat models; streaming chat models; creating multiple LLM generations; prompt templates; LCEL; PromptTemplate with chat models; output parsers; LangChain Evals; OpenAI function calling; parallel function calling; function calling in LangChain; extracting data; query planning; few-shot prompt templates; limitations with few-shot examples; saving & loading prompts; prompt chaining; reasoning with language agents |
| 5 | [`Unit5_Retrieval_Augmented_Generation.md`](Unit5_Retrieval_Augmented_Generation.md) | RAG key concepts & components; how RAG improves QA; RAG architecture; building the retrieval system (dense retrieval, reranking); embeddings & vector databases; RAG data ingestion pipeline; pipeline implementation (PDF preprocessing, ingestion, generation component); impact of text splitting on RAG; advanced RAG techniques; retrieval & RAG evaluation; challenges of RAG |
| — | [`Exam_Tips.md`](Exam_Tips.md) | Consolidated revision sheet: memory hooks, formulas, key numbers, cross-unit links, and a question bank |

---

## Textbooks (as prescribed in the syllabus)

1. John Atkinson and Abutridy, *Large Language Models: Concepts, Techniques and Applications*, CRC Press, 2025.
2. John Berryman and Albert Ziegler, *Prompt Engineering for LLMs — The Art and Science of Building Large Language Model–Based Applications*, O'Reilly, 2025.
3. James Phoenix and Mike Taylor, *Prompt Engineering for Generative AI — Future-Proof Inputs for Reliable AI Outputs at Scale*, O'Reilly, 2024.
4. Alammar & Maarten Grootendorst, *Hands-On Large Language Models — Language Understanding and Generation*, O'Reilly, 2024.
5. Mehdi Allahyari, Angelina Yang, *A Practical Approach to Retrieval Augmented Generation Systems*, Maven, 2023.

### Source material available in this folder

| File | Notes |
|---|---|
| `Large Language Models ConceptsAtkinson.pdf` / `.md` | Textbooks 1 — theoretical depth for Units 1, 2, 4 |
| `Prompt Engineering LLMsBerryman.pdf` / `.md` | Textbook 2 — Units 2, 3, 5 |
| `dokumen.pub_prompt-engineering-for-generative-ai-9781098153434.pdf` / `.md` | Textbook 3 — Units 3, 4, 5 |
| `Hands-On_Large_Language_Models.pdf` | Textbook 4 — Ch.2 (tokenization/embeddings), Ch.6 (prompting), Ch.7 (LangChain), Ch.8 (semantic search & RAG) |
| `LLM.pdf` / `.md` | Alammar & Grootendorst slide companion — Unit 1 & 2 diagrams, attention mechanism |
| `Ramya/` | Original PDFs supplied for the course |

---

## Syllabus Pedagogy Links

| Unit | Topic | Link |
|---|---|---|
| 1 | Demonstration of attention mechanism | `https://github.com/soloshun/llm-from-scratch/blob/master/src/part06_attention_mechanism.py` |
| 2 | Demonstration of LLM, applications | `https://github.com/rasbt/LLMs-from-scratch/tree/main/ch04` |
| 3 | Experiment with prompts | `https://www.promptingguide.ai/introduction/basics` |
| 4 | Demonstration of LangChain applications | `https://github.com/benman1/generative_ai_with_langchain` |
| 5 | Building RAG application | `https://github.com/langchain-ai/rag-from-scratch/blob/main/rag_from_scratch_10_and_11.ipynb` |

---

## Course Outcomes → Unit mapping

| CO | Outcome | Primary units |
|---|---|---|
| **CO1** | Understand fundamental concepts, architecture, tokenization mechanisms, embeddings, and operational principles of LLMs | 1, 2 |
| **CO2** | Analyse pre-processing techniques, token representations, embedding methods, and contextual language representations in NLP | 2, 5 |
| **CO3** | Apply prompt engineering strategies and reasoning techniques to control, optimize and evaluate text generation | 3, 4 |
| **CO4** | Design and develop LLM applications using LangChain — prompt templates, function calling, document processing, retrieval, workflow orchestration | 4, 5 |
| **CO5** | Evaluate and implement fine-tuning, instruction tuning, few-shot learning, NER and performance evaluation techniques | 2, 3, 4 |

---

## Suggested revision order

1. **Unit 1** — establishes the transformer that everything else builds on. Draw the encoder/decoder block from memory.
2. **Unit 2** — tokenization + embeddings. These are used again in Unit 5 (embeddings for retrieval).
3. **Unit 3** — the core exam unit. Master CoT / Self-Consistency / ToT distinctions with the published numbers.
4. **Unit 4** — LangChain; largely code-flavoured, so write short snippets for each concept.
5. **Unit 5** — RAG; ties Units 2 (embeddings) + 3 (prompting) + 4 (LCEL chains) together.
6. **`Exam_Tips.md`** — final sweep one or two days before the exam.
