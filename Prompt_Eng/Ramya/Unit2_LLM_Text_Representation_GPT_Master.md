# Unit 2: LLM, Text Representation and GPT Models

> **Course:** Prompt Engineering for Generative AI (CI72) · **Unit II**
> **Base:** `Unit2_LLM_Text_Representation_and_GPT_Models.md`
> **Merged with:** `Unit-2 PEGENAI.md` (Ramya slides) — off-syllabus extras removed
> **Texts:** *Large Language Models: Concepts, Techniques and Applications* — Atkinson & Abutridy (CRC, 2025); *Hands-On Large Language Models* — Alammar & Grootendorst (O'Reilly, 2024); *Prompt Engineering for LLMs* — Berryman & Ziegler (O'Reilly, 2025).

---

## 1. Introduction to Large Language Models (LLMs)

### 1.1 What are LLMs?
- A **Large Language Model (LLM)** is a **neural network trained on a very large collection of text data** and containing a **very large number of parameters**.
- It learns **relationships between tokens** and can perform tasks such as:
  - **Text generation**, **Question answering**, **Summarization**, **Translation**, **Classification**, **Code generation**, **Information extraction**, **Conversational interaction**.
- Operationally, an LLM is a large-scale **transformer** pre-trained to **predict the next token** (autoregressive) or to **fill masked tokens**.
- An LLM does **not** store a dictionary of sentences. During training it learns **numerical parameters that capture patterns and relationships in language**.

### 1.2 Why are LLMs called "Large"? (MEMORIZE)
The word *large* refers to several aspects:
1. **Large training datasets** — models are trained on enormous collections of text.
2. **Large number of parameters** — parameters are numerical values learned during training.

- **Large computational requirements:** training modern LLMs requires substantial **GPU/TPU computation**, **memory**, **storage**, and **training time**.
- **Large vocabulary:** LLMs can process a very large number of tokens representing different languages and text patterns.

**Model capability by size (rule of thumb from the slides):**

| Tier | Parameters | Capabilities |
|---|---|---|
| Small | 8B–13B | Basic arithmetic, code debugging, reading comprehension, basic language operations (stories, essays, poetry) |
| Medium | 64B–175B | Language puzzles, college-admission tests, physical intuition, logical deduction, metaphors |
| Large | 70B–540B | Geometric shapes, phonetic alphabet, causality, elementary mathematics, code explanation |
| Extra-large | ~1T | Spatial reasoning, creativity, app construction, picture handling, thematic test performance |

- "Large" also means **model size**: GPT-2 1.5B, GPT-3 175B, LLaMA 7–65B, PaLM 540B.
- Popular LLM families: **GPT, BERT, PaLM, LLaMA, LaMDA, Megatron** (Atkinson Ch. 3).

### 1.3 How does an LLM learn? (next-token training loop)
Example target: *The capital of France is ___* → expected **Paris**.
```
Input:    The capital of France is
Expected: Paris

Initial prediction (probability over vocabulary):
  Paris  → 0.20
  London → 0.15
  Rome   → 0.10
  Berlin → 0.05

Text → Prediction → Calculate Loss → Backpropagation
     → Update Parameters → Better Prediction
```
- The model calculates a **loss** between its prediction and the correct answer.
- The parameters are updated with **backpropagation + gradient descent**, repeated over enormous amounts of training data.

### 1.4 How do LLMs "see" the world?
- LLMs **do not see the world the way humans do**. They primarily process **numerical representations of tokens** and do **not directly experience reality** — they learn **patterns** from the data they were trained on.
- They have **no continuous interaction with the world** — only the knowledge encoded at training time.
```
Human: "The dog is running."
LLM:   "The" → token ID, "dog" → token ID, "is" → token ID, "running" → token ID
       → Numerical vectors → Transformer computations
```
- Consequence: **hallucinations** — confident, fluent, but **false or made-up** content (see §3).

### 1.5 Applications of LLMs (MEMORIZE list)
- Text generation, summarization, question answering, translation, code generation, sentiment analysis, **information extraction**, classification, named-entity recognition, conversational interaction / chatbots, semantic search / RAG pipelines, instruction following & agents.

### 1.6 Emergent skills & corpora (Atkinson 3.1.1–3.1.3)
- **Emergent skills:** reasoning, in-context learning, and instruction following that appear only at large scale.
- **Corpora:** massive unlabelled text (books, web, GitHub, Wikipedia); quality-filtered for pre-training (GPT-2 used Reddit-curated pages).
- Training types: **self-supervised pre-training** → **supervised fine-tuning** → **RLHF** (see §9).

---

## 2. How LLMs Process Text

- Computers do not directly process words as humans do. Raw text must be converted into numerical information:
```
Raw Text → Tokenization → Token IDs → Embedding → Transformer → Output probabilities
```
- Example: *"I love machine learning."*
```
["I", "love", "machine", "learning", "."]  →  [45, 982, 721, ...]  →  Embedding vectors  →  Transformer
```
- **Tokenization** is the process of dividing text into smaller units called **tokens**.
  - `"I love machine learning."` → `["I", "love", "machine", "learning", "."]`
  - Modern LLMs generally use **subword tokenization**, so the result may differ.
  - `"Unhappiness"` → `["un", "happiness"]` or `["un", "happi", "ness"]`.
- **Why do we need tokenization?** Computers need numerical input: `Text → Tokens → Token IDs → Vectors → Neural Network`.

---

## 3. How LLMs "See" the World: Hallucinations

### 3.1 What is a hallucination?
- An **LLM hallucination** occurs when a model generates information that **appears plausible but is incorrect, unsupported, or fabricated**.
```
User: Who invented the XYZ algorithm?
LLM:  The XYZ algorithm was invented by Professor ABC in 1987.   ← if ABC/XYZ don't exist → hallucination
```

### 3.2 Why do hallucinations occur?
- A generative language model is fundamentally **trained to predict likely tokens** — it is **not automatically a fact-checking system**.
- For *"The capital of France is"* the model has strong statistical evidence for *Paris*; but for an obscure question like *"The winner of the 1873 XYZ competition was"* it may still generate a **plausible continuation**.
- **Fluent language does not guarantee factual correctness.**

### 3.3 Causes of hallucination
- Insufficient training information
- Ambiguous prompts
- Outdated knowledge
- Conflicting training information
- Poorly specified questions
- Model tendency to generate plausible continuations
- Lack of external verification

### 3.4 Reducing hallucinations
```
Better Prompt + Grounded Information + Retrieval-Augmented Generation (RAG)
+ Tool Use + Fact Verification + Human Review
```
- Berryman's distinction: hallucinations are **confabulation** — the model interpolates patterns; there is **no intent to deceive**. The best antidote is **RAG** (Unit V).

---

## 4. LLM Tokenization

- **Tokens** are the **atomic units** of text for an LLM. A text fragment → sequence of vocabulary items (**tokens**) → **token IDs** (unique indices).
- Tokenization **depends on the level of granularity desired** in a task.
- **How tokenizers prepare inputs:** (1) break text into tokens; (2) map to IDs; (3) add **special tokens** — typically **BOS** (begin-of-sequence), **EOS** (end-of-sequence), **[MASK]** (masked LM), and **padding** tokens.

### 4.1 Word-Level Tokenization
- Each **word** becomes a token: `I love AI` → `["I", "love", "AI"]`.
- **Advantages:** easy to understand; tokens are meaningful linguistic units.
- **Disadvantage:** `play, playing, played, player, playful` each become **separate tokens** → **very large vocabulary**.
- Common with earlier methods like **word2vec**; being used less in NLP (still used in recommendation systems).
- Also **cannot handle new/unknown words** that appear after tokenizer training (OOV).

### 4.2 Character-Level Tokenization
- Each **character** becomes a token.
- **Advantages:** very small vocabulary; can handle unknown words; works well with unusual words.
- **Disadvantages:** a **long sequence of characters** is needed to represent normal text; weaker semantics.

### 4.3 Subword Tokenization
- Divides words into **frequently occurring pieces**: `un + happi + ness`.
- The exact segmentation depends on the tokenizer.
- Handles unknown/rare words; **manageable vocabulary**; more efficient than character-level; represents related words via common pieces.
- Modern LLM tokenizers commonly use **subword / byte-level** approaches.
- Resolves the word-token problem: a token for `apolog` plus common suffix tokens (`-y`, `-ize`, `-etic`, `-ist`) gives a more expressive vocabulary than storing `apology, apologize, apologetic, apologist` separately.

### 4.4 Byte-Level Tokenization
- Starts from **bytes** rather than complete words: text is represented using **byte values** and then tokenized into learned units.
- Bytes provide a mechanism for representing **essentially arbitrary text** — helps with:
  - Unknown words, misspellings, special symbols, multiple languages, emojis.
- Papers: *"CANINE: Pre-training an efficient tokenization-free encoder"* and *"ByT5: Towards a token-free future with pre-trained byte-to-byte models."*

### 4.5 Word vs Subword vs Character vs Byte tokens (comparison — exam favourite)

| Level | Vocabulary = | Example "playing" | Pros | Cons |
|---|---|---|---|---|
| **Word** | all words of the language | `playing` | Short sequences, rich semantics | Huge vocab; **cannot handle new/unknown words** (OOV) |
| **Character** | alphabet + punctuation | `p l a y i n g` | Tiny vocab, handles any word | Very long sequences, weaker semantics |
| **Subword** | common segments + single chars | `play + ing` | **Best balance**: handles OOV, reasonable vocab size | Needs careful merging rules (BPE) |
| **Byte** | byte values (0–255) | bytes of UTF-8 | Handles **any** UNICODE script | Longer sequences; less linguistically meaningful |

| Method | Example "playing" | Vocabulary | Sequence Length |
|---|---|---|---|
| Word | `playing` | Large | Short |
| Character | `p l a y i n g` | Very small | Long |
| Subword | `play + ing` | Medium | Medium |
| Byte | `Byte/subunits` | Small / base-level | Variable |

### 4.6 Subword tokenization algorithms
- **Byte-Pair Encoding (BPE):** iteratively **merge the most frequent adjacent pairs** of symbols into new tokens — widely used by the **GPT** family.
- **WordPiece:** merges to maximize the likelihood of the training data — used by **BERT**.
- **Unigram / SentencePiece:** language-model-based; handles subwords + whitespace — used by **LLaMA/PaLM**.
- Common words stay as single tokens; rare words split into known subwords; **single characters guarantee every word is expressible**.

---

## 5. How Tokenizers Prepare Inputs to the Language Model

- Ready pipeline:
```
Human Text → Tokenization → Tokens → Token IDs → Special Tokens
           → Padding / Truncation → Attention Mask → Embedding Layer → Language Model
```
- In a tokenized sequence:
  - The first token may be a **special token** (e.g., `<s>` / `[CLS]`) indicating the beginning of the text.
  - Some tokens are **complete words**; some are **parts of words**.
  - **Punctuation characters** are their own token.

**Special tokens (MEMORIZE):**

| Token | Meaning | Purpose |
|---|---|---|
| `[CLS]` | Classification | Represents the complete sequence |
| `[SEP]` | Separator | Separates sentences / segments |
| `[MASK]` | Masking | Hides a token during training |
| `[PAD]` | Padding | Makes sequences equal length |
| `[UNK]` | Unknown | Represents an unknown token |

- `[MASK]` = "Hide this token and ask the model to predict it."
```
Original: I love machine learning.
Masked:   I love [MASK] learning.
Prediction: [MASK] → machine
```

---

## 6. How Does the Tokenizer Break Down Text? (three major factors)

1. **The tokenization method** (chosen at model design time).
   - Popular methods: **BPE** (widely used by GPT) and **WordPiece** (used by BERT).
   - They are similar in that they aim to optimize an efficient set of tokens to represent a text dataset, but they arrive at it in **different ways**.
2. **Tokenizer design choices / parameters** — e.g., vocabulary size and which special tokens to use.
3. **The dataset the tokenizer is trained on.** Even with the same method and parameters, a tokenizer trained on English text differs from one trained on **code** or a **multilingual** dataset.

---

## 7. Comparing Trained LLM Tokenizers & Tokenizer Properties

- Different models → different vocabulary and **tokenization behavior** (Berryman).
- **Tokenization pitfalls** affect prompt token count and even output quality:
  - Curse words or names may split oddly; token boundaries shift with spelling (Berryman's `"STRA"+"NGE"+" NEW"+"WORLDS"` example).
  - **Cost:** each token costs money → prompt length matters.

### 7.1 Tokenizer properties
1. **Tokenization methods** — BPE, WordPiece, Unigram/SentencePiece; each outlines an algorithm to choose an appropriate token set.
2. **Tokenizer parameters:**
   - **Vocabulary size** — how many tokens to keep. **30K and 50K** are common; larger sizes like **100K** are increasingly used (GPT-2: 50,257; Llama-2: 32,000).
   - **Special tokens** — `<CLS>` (beginning of text), end-of-text, padding, unknown, masking.
   - **Capitalization** (case handling).
3. **The domain of the data** — behavior differs by the dataset the tokenizer was trained on (before model training even begins).

### 7.2 Three important tokenizer properties for LLMs
1. **Vocabulary size** — a larger vocabulary can represent more words directly but requires a **larger embedding matrix**.
2. **Token efficiency** — a good tokenizer represents text using a **reasonable number of tokens**, e.g. `"unhappiness"` → `["un", "happiness"]` instead of many individual characters.
3. **Special-token support** — LLMs use special tokens to control processing: `[CLS]`, `[SEP]`, `[MASK]`, `[PAD]`, `[UNK]`.

- A pre-trained language model is **linked with its tokenizer** and **cannot use a different tokenizer without (re)training**.
- The model holds an **embedding vector for each token** in the tokenizer vocabulary; the **embeddings matrix** is part of the downloaded model. It is randomly initialized before training, then training assigns useful values.

---

## 8. Embeddings — From Words to Meaning

### 8.1 Bag-of-Words (what we leave behind)
- BOW ignores word **order and semantic meaning** — sparse, high-dimensional one-hot counts.

### 8.2 Dense vector embeddings
- **Embeddings** = dense vector representations that **capture meaning** (semantics), not just counts.
- **Word2vec** — one of the first successes: static, downloadable word vectors; captures analogies (`king − man + woman ≈ queen`). **GloVe** is another static example.

### 8.3 Word vs Token vs Text Embeddings (clarify once and for all)

| Feature | Word Embedding | Token Embedding | Text Embedding |
|---|---|---|---|
| Represents | Word | Token | Sentence / document / text |
| Example | `cat` | `cat`, `ing` | `"The cat is sleeping"` |
| Number of vectors | One per word | One per token | Usually one per text |
| Typical models | Word2Vec, GloVe | BERT, GPT, LLMs | Sentence Transformers, embedding models |
| Subwords | Usually no | Yes | Not applicable at output level |
| Main use | Word meaning | Transformer input | Semantic similarity / search |
| Context-dependent? | Usually no | Can become contextual | Usually designed to capture whole-text meaning |

- **Word embedding** = vector for a *word* from a pretrained model (word2vec `bank` → vector).
- **Token embedding** = vector for a *subword token* (a learned lookup table, plus positional info) — e.g. the GPT embedding matrix.
- **Text/document embedding** = a single vector for a sentence/paragraph/document, used for **semantic similarity search** — e.g. `text-embedding-ada-002` (1536-d), MiniLM (384-d).

### 8.4 Static vs Contextual embeddings (crucial)

| Feature | Static Embedding | Contextual Embedding |
|---|---|---|
| Example models | Word2Vec, GloVe | BERT, RoBERTa |
| Representation | Fixed | Context-dependent |
| "bank" in different sentences | Same vector | Different vectors |
| Handles ambiguity | Limited | Better |
| Uses surrounding words | No | Yes |
| Generated by Transformer | No | Yes |

- **Contextual embedding** = a numerical vector representation of a word/token whose **meaning is determined by the surrounding context**.
- Word2vec is **static**: "bank" has one vector though it means *financial bank* or *river bank*.
- Context **changes meaning** → need contextual embeddings where each token's vector depends on the words around it.
- **BERT** produces contextual embeddings (bidirectional, masked-language-model pretraining).
- Modern LLMs produce **contextual token embeddings** at the last hidden layer — these power semantic search, retrieval and RAG.

> **Trick:** For embedding questions give the **bank example** (financial vs river) — it proves you understand contextualisation.

---

## 9. GPT Models

### 9.1 GPT = Generative Pre-trained Transformer
- **GPT is a type of LLM.** It is a **Transformer-based autoregressive language model** pre-trained to **predict the next token**, and can therefore generate coherent sequences of text.
- **Decoder-only** transformer using **masked self-attention** (no looking ahead).
- Name decomposition (MEMORIZE):
  - **G**enerative — trained to predict/generate the next token (self-supervised).
  - **Pre-trained** — huge corpus → reusable for many tasks without training from scratch.
  - **T**ransformer — encoder-decoder + attention architecture.
- **Autoregressive loop:** after each token is generated it is appended to the input, then the model predicts the next, and so on.
- The evolution of GPT models represents a transition from **large-scale language generation** to **multimodal reasoning and agentic intelligence**. Earlier models focused on language understanding/generation; newer ones integrate advanced reasoning, long-context processing, tool use, coding, computer interaction, and autonomous multi-step task execution.

### 9.2 Training and alignment (RLHF + PPO)
- **PPO (Proximal Policy Optimization)** has been used to train GPT-style models, particularly in **RLHF (Reinforcement Learning from Human Feedback)**.
- GPT can be considered a **policy** in reinforcement learning:
  - **State** → prompt / context
  - **Action** → next token generated
  - **Policy** → GPT model
  - **Reward** → reward model's evaluation
  - **Objective** → generate responses that receive higher rewards
- **RLHF pipeline:**
  1. **Supervised fine-tuning (SFT):** fine-tune on human-written instruction-following pairs.
  2. **Reward model:** train a model to rank/score responses by human preference.
  3. **RL optimization (PPO):** optimize the policy to maximize the reward model's score (with a KL penalty).
  - Result: models that **follow instructions**, are more helpful/honest, and less harmful (*InstructGPT*).
  - RLHF models are **especially good at following explicit instructions** (system-prompt obedience) and at **few-shot prompting**.

### 9.3 GPT-1 → GPT-2 (three innovations — exam favourite)
1. **Task conditioning:** reformulate the training objective `P(output | input)` → `P(output | input, task)` so the same model performs multiple tasks (via prompts/examples in the input) — basis of **zero-shot task transfer**.
2. **Zero-shot learning & task transfer:** format inputs to indicate the task — e.g. English → French: *"english: <sentence> french:"* → model returns the translation without task-specific fine-tuning.
3. **Architecture scaling:** GPT-2 = **1.5B params** (10× GPT's 117M), 48 layers, 1600-dim embeddings, **50,257-token vocab**, 1024-token context, layer-norm after the final self-attention block.
- **GPT-2 facts to quote:** trained on **40 GB** of internet text curated by humans (Reddit links); performs QA, comprehension, summarization and translation **without** task-specific training data; **144 attention patterns** via 12 layers × 12 heads.

### 9.4 Masked self-attention in GPT (decoder-only)
- The attention mask blocks tokens **to the right**: only present and previous tokens are attended.
- Implemented as an **attention mask** array; e.g. for "John bought a book" the row for "bought" has zeros for "a"/"book".
- This produces an **autoregressive** LM: the output at time *t* feeds the input at time *t+1*.
```
Causal mask (1 = allowed to attend, 0 = blocked):
          I   love machine learning
I         1   1    1       1
love      0   1    1       1
machine   0   0    1       1
learning  0   0    0       1
```
- **This is extremely important for GPT: the model must not look into the future.**

### 9.5 GPT-3 (175B)
- Dramatically larger scale + **in-context learning**: few-shot prompting (paper *"Language Models are Few-Shot Learners"*, 2020).
- No gradient updates needed at task time; the prompt itself (with a few examples) **conditions** the model.

### 9.6 GPT-4 / GPT-4o
- **GPT-4:** multimodal-capable, instruction-tuned, higher alignment & reasoning; improved safety.
- **GPT-4o:** text, image & audio generation — multimodal interaction; high reasoning, fast, large context.

### 9.7 Comparative analysis of GPT models

| Model | Generation | Main strength | Reasoning | Speed | Context | Typical applications |
|---|---|---|---|---|---|---|
| **GPT-3.5** | GPT-3 | Basic language generation | Low–Moderate | Fast | Smaller | Chatbots, simple Q&A, text generation |
| **GPT-4** | GPT-4 | Strong reasoning & language understanding | High | Moderate | Large | Complex Q&A, analysis, coding |
| **GPT-4o** | GPT-4 | Text, image, audio generation | High | Fast | Large | Multimodal interaction, real-time interaction |
| **GPT-5** | GPT-5 | Advanced reasoning | Very High | Moderate–Fast | Very large | Research, coding, analysis, agents |

### 9.8 GPT concept tree
```
GPT
├── Architecture
│   └── Transformer
│       ├── Self-Attention
│       ├── Feed-Forward Network
│       ├── Layer Normalization
│       └── Residual Connections
├── Input
│   ├── Tokenization
│   ├── Token Embeddings
│   └── Positional Information
└── Training
    ├── Pre-training
    │   └── Next Token Prediction
    ├── Supervised Fine-Tuning
    └── Alignment
        └── RLHF
            └── PPO
```

---

## 10. BERT (contrast model — Atkinson 3.2)
- **BERT = Bidirectional Encoder Representations from Transformers** — **encoder-only** transformer.
- **Bidirectional:** reads left + right context simultaneously → deeper sense of context/language flow than unidirectional LMs.
- Pre-training tasks (MEMORIZE):
  - **Masked Language Modeling (MLM):** 15% tokens randomly masked; of those, 80% → `[MASK]`, 10% → random token, 10% unchanged; model predicts the masked words from context ("fill in the blank": *"John bought a ___ at the corner store"* → *eggs* 80%, *vehicle* 20%).
  - **Next Sentence Prediction (NSP):** given sentence pair A+B, predict `IsNext` / `NotNext`.
- Input: `[CLS]` + sentence A + `[SEP]` + sentence B + `[SEP]`, with token + segment + positional embeddings.
- **Limitations:** NOT generative; fixed input (512); needs fine-tuning for tasks — motivation for **GPT**.
- **Contrast:** BERT = encoder-only, bidirectional, MLM+NSP (understanding); GPT = decoder-only, causal mask, next-token (generation).

---

## 11. Quick Revision & Exam Strategy

### One-liners
- LLM = neural network (transformer) trained to predict the next token on huge corpora; "large" = big data + many parameters + big compute + large vocabulary.
- Tokenization: character / word / subword / byte; subword (BPE) is the sweet spot; special tokens `[CLS] [SEP] [MASK] [PAD] [UNK]`.
- Embeddings: dense semantic vectors; **word** (word2vec/GloVe, static) vs **token** (BERT/GPT) vs **text** (sentence transformers) vs **contextual** (BERT/GPT hidden states).
- BERT = encoder-only + MLM + NSP; GPT = decoder-only + masked self-attention (autoregressive).
- GPT-2: 1.5B params, zero-shot task transfer; GPT-3: in-context (few-shot) learning; GPT-4/4o: aligned + multimodal.
- RLHF: SFT → reward model → PPO; GPT as RL policy (state=prompt, action=next token, reward=reward model).
- Hallucinations = fluent falsehoods; causes: insufficient/outdated/conflicting data, ambiguous prompts, no external verification; antidotes: better prompt, grounding, RAG, tool use, fact verification, human review.

### Likely exam questions
1. What is an LLM? Why is it called "large"? Enumerate applications.
2. Explain how LLMs "see the world" and what a **hallucination** is. State its causes and how to reduce them. (10 marks)
3. Explain tokenization and compare word vs subword vs character vs byte tokens.
4. How does the tokenizer prepare the model input? What are `[CLS]`/`[SEP]`/`[MASK]`/`[PAD]`/`[UNK]` tokens?
5. What three factors dictate how a tokenizer breaks down text? Explain tokenizer properties.
6. Distinguish static (word2vec) vs contextual embeddings; explain the "bank" example.
7. Distinguish word, token and text embeddings.
8. Compare BERT and GPT (architecture, pre-training objectives, generative ability).
9. Explain GPT-2's three innovations (task conditioning, zero-shot transfer, architecture scaling).
10. Explain the RLHF pipeline (and PPO) for instruction-following LLMs.

### Tips & tricks
- Use the **drawing contrast**: BERT (encoder-only, bidirectional) vs GPT (decoder-only, causal mask) — one diagram answers half the exam.
- For tokenizer questions, present the **BPE merge idea** and the **word/char/subword/byte table** — practical demonstration scores well.
- Quote **GPT-2's exact numbers** (1.5B, 48 layers, 1600-dim, 50,257 vocab, 1024 context) — examiners reward precision.
- Organize "applications" into four buckets: **generation / comprehension / retrieval / agentic**.
- Always attach a **hallucination mitigation** (RAG / grounding / verification) even when not explicitly asked.
- For embedding questions, always give the **"bank" (financial vs river)** example.

---

*Sources: syllabus.txt (Unit II); Unit2_LLM_Text_Representation_and_GPT_Models.md; Unit-2 PEGENAI.md (Ramya slides); Large Language Models ConceptsAtkinson.md §3; Prompt Engineering LLMsBerryman.md.*
