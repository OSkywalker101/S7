# Exam Tips & Quick Revision — Prompt Engineering for Generative AI (CI72)

A consolidated revision sheet to sweep after studying the five unit notes.

---

## 1. Master Memory Hooks

| Concept | Hook |
|---|---|
| AI ⊃ ML ⊃ Deep Learning ⊃ NLP/Language AI | **The shrinking pyramid** |
| Autoencoder | **Encoder → Bottleneck (latent z) → Decoder** = compress & reconstruct |
| VAE constraint | Encoder outputs **μ and σ**, not a fixed z; **KL loss** keeps them N(0,1) |
| GAN | **Generator vs Discriminator** — a *min–max game*; keep the **generator**, throw away the discriminator |
| Attention need | **Cocktail-party problem** — focus on what matters, filter the rest |
| Positional encoding | A position is a **clock with many hands** (different frequencies) |
| Masking | Future positions get **−∞ before SoftMax** ⇒ their attention becomes 0 |
| BERT | **Encoder-only**, bidirectional; **MLM** (15% masked) + **NSP**; `[CLS]`/`[SEP]` |
| GPT | **Decoder-only**, **masked self-attention**, autoregressive = *G*enerative *P*re-trained *T*ransformer |
| RLHF | **S → R → P**: Supervised fine-tune → Reward model → **PPO** |
| "bank" | One word, two meanings ⇒ static embeddings fail ⇒ need **contextual** ones |
| Prompt ingredients | **I · C · I · O** → Instruction, Context, Input, Output format (+ Persona, + Examples) |
| CoT | "**Think step by step**" before answering |
| ToT | **4% → 74%** on Game of 24 (GPT-4, CoT → CoT+ToT) |
| MIRACL gain | Reranking lifts **nDCG@10 36.5 → 62.8** |
| AP intuition | 1 relevant doc at **rank 1 ⇒ AP = 1**; at **rank 3 ⇒ AP ≈ 0.33** |
| RAG | **Retrieve → Augment (context) → Generate** |
| Text splitting | The **retrieval ceiling** — bad chunks break RAG even with a perfect LLM |
| LangChain tenets | **Data awareness** + **Agency** |
| LCEL | `prompt \| model \| parser` — the **pipe** operator, order matters |
| LangChain memory | **B**uffer, **W**indow, **S**ummary, **S**ummary**B**uffer, **T**oken |

---

## 2. Numbers, Names & Facts Worth Quoting

| Fact | Value |
|---|---|
| GPT-2 parameters | **1.5B** (10× GPT's 117M), 48 layers, 1600-dim, **50,257** vocab, 1024 context |
| GPT-3 parameters | **175B** |
| Llama-2 vocab size | **32,000** |
| Google `text-embedding-ada-002` | **1,536** dimensions |
| `all-MiniLM-L6-v2` | **384** dimensions |
| BERT max input length | **512** tokens |
| BERT MLM corruption rate | **15%** → 80% `[MASK]`, 10% random, 10% unchanged |
| ToT on Game of 24 | **4% (CoT) → 74% (ToT)** |
| Reranking on MIRACL | nDCG@10 **36.5 → 62.8** |
| ADA-002 embedding cost | ≈ **$0.0004 / 1K tokens** (King James Bible ≈ $1.60) |
| Cross-encoder relevance output | score **0–1** (classification) |
| Transformer paper | Vaswani et al. (2017) — *"Attention Is All You Need"* |
| RAG paper | Lewis et al. (2020) — *"Retrieval-Augmented Generation for Knowledge-Intensive NLP Tasks"* |
| Few-shot LM paper | *"Language Models are Few-Shot Learners"* (2020) |
| ReAct | **Re**ason + **Act** |
| Ragas / LLM-as-a-judge | Automates RAG evaluation |

---

## 3. Formulas to Reproduce from Memory

**Positional encoding**
```
PE(pos, 2i)   = sin( pos / 10000^(2i / d_model) )
PE(pos, 2i+1) = cos( pos / 10000^(2i / d_model) )
```

**Scaled dot-product attention**
```
Attention(Q, K, V) = softmax( Q Kᵀ / √d_k ) V
```
`√d_k` scaling prevents softmax saturation when dot products grow large.

**Autoencoder objective**
```
Loss = Reconstruction Loss (x, x̂) + λ · Regularizer
```

**Transformer training loss (cross-entropy)**
```
Loss = − Σ log P( target_i | target_<i , source )
```

**SoftMax**
```
softmax(z_i) = exp(z_i) / Σ_j exp(z_j)
```

**Cosine similarity (used by vector stores)**
```
sim(a, b) = (a · b) / (‖a‖ ‖b‖)
```

**Precision@k / Average Precision / MAP**
```
Precision@k = relevant in top-k / k
AP  = Σ (precision at each relevant hit) / (number of relevant docs)
MAP = (1/Q) Σ_q AP(q)
```

---

## 4. Diagrams You Must Be Able to Draw

1. **Transformer architecture** — encoder stack (self-attn → add & norm → FFN → add & norm) × N, decoder stack (masked self-attn → cross-attn → FFN) × N, then linear → SoftMax.
2. **Encoder–decoder with attention** — show the alignment/attention weights between input positions and output steps.
3. **Attention worked example** — a matrix of attention scores (rows = queries, columns = keys), e.g. the "Croatia/Italy" example.
4. **GAN training loop** — noise → Generator → fake sample → Discriminator vs Real samples.
5. **LangChain module map** — Model I/O, Retrieval, Chains, Agents, Memory, Callbacks.
6. **Function-calling loop** — user message → model → `tool_calls` → execute → `role:"function"` result → model → final answer.
7. **RAG architecture** — documents → chunk → embed → vector DB → top-k retrieval → context assembly → LLM → grounded answer.
8. **Few-shot vs zero-shot prompt** — side-by-side layout.
9. **CoT vs Self-Consistency vs ToT** — single linear chain vs multiple sampled chains + majority vote vs a branching tree with backtracking.
10. **The AI ⊃ ML ⊃ DL pyramid.**

---

## 5. Distinctions Examiners Love (Comparison Questions)

| Ask for… | Contrast |
|---|---|
| Traditional vs Generative AI | **Discriminative** (predict a label) vs **Generative** (model p(x), sample) |
| Autoencoder vs GAN | Reconstruct input vs generate novel samples |
| Word vs Subword vs Character vs Byte tokens | Vocab size vs OOV handling vs sequence length |
| Static vs Contextual embeddings | word2vec (one vector per word) vs BERT/GPT (vector per occurrence) |
| BERT vs GPT | Encoder-only bidirectional + MLM/NSP vs Decoder-only causal + next-token |
| Zero-shot vs Few-shot | Instruction alone vs Instruction + demonstrations |
| CoT vs Self-Consistency vs ToT | 1 reasoning chain vs N chains + **majority vote** vs branching tree + **self-evaluation & backtracking** |
| CoT vs ReAct | Reasoning only vs **Reason + Act + Observe** loop |
| Output parsers vs Function calling vs Grammar sampling | Post-hoc parsing vs model-chosen tool invocation vs **constrained decoding** |
| Dense retrieval vs Reranking vs RAG | Nearest neighbours vs **score & reorder a shortlist** vs retrieve + generate |
| RAG vs Fine-tuning vs In-context | No weight change (fresh) vs weight update (expensive) vs examples in prompt |
| Few-shot limitations (3) | Context-window cost · **bias/anchoring** to examples · **spurious patterns** |
| Local vs Hosted vector DBs | FAISS / Chroma (control, free) vs Pinecone / Weaviate Cloud (managed, SLA, lock-in) |

---

## 6. Cross-Unit Links (High-Scoring Pointers)

- **Unit 1 → 2:** transformers give **contextualized token representations**; tokenizers/embeddings build directly on this.
- **Unit 2 → 5:** **text embeddings** are the input to vector databases and dense retrieval; **cosine similarity** is what makes "search by meaning" possible.
- **Unit 2 → 3:** **GPT-3's in-context learning** is the very mechanism prompt engineering exploits — no gradient updates.
- **Unit 2 → 3:** **RLHF** is *why* system-message instructions are obeyed so reliably.
- **Unit 3 → 4:** **chain prompting** becomes **LCEL pipelines**; **grammar-constrained sampling** becomes **output parsers / `with_structured_output`**; **output verification** becomes **LangChain Evals**.
- **Unit 3 → 5:** **CoT** reduces hallucinations; **RAG** grounds them. Both target the same failure mode.
- **Unit 4 → 5:** the RAG chain is just `retriever | prompt | model | StrOutputParser()` — `RunnablePassthrough` supplies the raw question.
- **Everything → CO5:** tokenization (U2), few-shot (U3/U4), fine-tuning/RLHF (U2), evaluation (U3/U4/U5).

---

## 7. The Three "Show Me a Number" Moments

If an answer feels vague, drop in one of these — concrete figures signal mastery:

1. **ToT: 4% → 74%** on Game of 24 (GPT-4).
2. **Reranking: nDCG@10 36.5 → 62.8** on MIRACL.
3. **AP: 1.0 vs 0.33** for the same single relevant document placed at rank 1 vs rank 3.

---

## 8. Answer-Writing Templates

**"Explain X" (10 marks)**
> Definition (1–2 marks) → Why it matters / problem it solves (2) → Architecture or mechanism with a **diagram** (3–4) → **Worked example** (2) → Limitations or comparison (1–2)

**"Compare A and B"**
> Shared context → A's mechanism → B's mechanism → **table** of 5+ contrasts → one sentence on when to prefer each

**"Implement / Demonstrate"**
> Minimal compilable code → line-by-line explanation → the output it produces → one variation

**"List challenges"**
> Never a bare list — pair **every** challenge with its **mitigation**.

---

## 9. Last-Minute Checklist

- [ ] Transformer encoder + decoder block drawn from memory
- [ ] Positional encoding formula written with *even → sin, odd → cos*
- [ ] Positional-encoding ordering counter-example (*"John took it away from a dog"* vs *"A dog took it away from John"*)
- [ ] Autoencoder types table (incomplete / sparse / denoising / variational)
- [ ] BERT vs GPT contrast table
- [ ] RLHF three-step pipeline (SFT → reward model → PPO)
- [ ] Token-level comparison table (word / subword / character / byte)
- [ ] `Attention(Q,K,V) = softmax(QKᵀ/√d_k)V` written out
- [ ] Prompt ingredients template with a filled example
- [ ] CoT vs Self-Consistency vs ToT with the **4% → 74%** figure
- [ ] Function-calling loop drawn
- [ ] LangChain six modules + memory types
- [ ] RAG architecture diagram + the *"answer only from the provided context"* grounding prompt
- [ ] The three-category search ladder (dense retrieval → reranking → RAG)
- [ ] Precision@k / AP / MAP definitions
- [ ] At least one real **code snippet** per Unit 4 and Unit 5 concept

---

## 10. Common Traps

| Trap | Correction |
|---|---|
| "GAN is an autoencoder variant" | ❌ Different objectives: adversarial vs reconstruction |
| "BERT can generate text" | ❌ Encoder-only, MLM — it produces **representations**, not free text |
| "More dimensions in embeddings = always better" | ⚠ More dimensions capture finer distinctions but cost more storage/search time |
| "RAG eliminates hallucinations" | ❌ It **reduces** them — the model can still ignore context or invent when context is absent |
| "Few-shot always beats zero-shot" | ❌ It can **overfit to example patterns** and bias toward the example distribution |
| "ToT is just CoT run several times" | ❌ That is **Self-Consistency**; ToT *branches and backtracks with evaluation* |
| "Reranking trains the search index" | ❌ It **re-orders a shortlist** produced by an earlier retrieval stage |
| "RAG means fine-tuning the model" | ❌ No weights change — it augments the **prompt** at inference time |
| "Positional encoding replaces the token embedding" | ❌ They are **added** together |
| "Decoder self-attention sees the whole sequence" | ❌ It is **masked** — future positions are blocked |

---

*Companion to `Unit1`–`Unit5` notes. Built strictly from `syllabus.txt` and the five prescribed textbooks.*
