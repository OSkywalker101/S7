# Unit 1: Generative AI — Fundamentals, Autoencoders, GANs, Attention & Transformers

> Course: Prompt Engineering for Generative AI (CI72) | Text: *Large Language Models: Concepts, Techniques and Applications* — Atkinson & Abutridy (CRC Press, 2025); *Hands-On Large Language Models* — Alammar & Grootendorst (O'Reilly, 2024) | Sources: `Large Language Models ConceptsAtkinson.md`, `LLM.md`

---

## 1. Definition and Fundamentals of Generative AI

### 1.1 What is Artificial Intelligence?
- **AI** = *"the science and engineering of making intelligent machines, especially intelligent computer programs"* — John McCarthy (2007).
- AI is related to understanding human intelligence using computers, but **does not have to confine itself to biologically observable methods**.

### 1.2 Three-tier relationship (draw the pyramid!)
```
Artificial Intelligence      →  methods capable of imitating human behavior
  └── Machine Learning       →  methods capable of automatically learning from data
        └── Deep Learning    →  use of deep neural networks
```
- **Deep Learning** is a subset of Machine Learning; ML is a subset of AI.
- **AI Application Domains:** Natural Language Processing (NLP), Computer Vision, speech, robotics, etc.

### 1.3 What is Natural Language Processing (NLP)?
- **Language AI / NLP** = subfield of AI developing technologies capable of **understanding, processing, and generating human language**.
- "Language AI" and "NLP" are used interchangeably.
- Today's language AI is dominated by **Large Language Models (LLMs)** built on transformers.

### 1.4 Traditional AI → Generative AI (history & evolution)
- Early AI: rule-based ("expert systems"), symbolic reasoning, hand-crafted features.
- Modern: from ML classifiers → deep learning → **generative models** that *create new content* (text, images, audio, code) rather than only classifying/predicting.
- **Focus areas of Generative AI (Atkinson 1.1.2):** content generation (text/image/audio/video), code synthesis, translation, summarization, dialog systems.
- **Applications (1.1.3):** chatbots & virtual assistants, machine translation, text summarization, image/art generation (DALL·E, Stable Diffusion), code generation (GitHub Copilot), data augmentation, creative writing.

> **Key exam contrast — Traditional vs Generative AI:**
> Traditional AI: *predicts a label / decision (discriminative)*. Generative AI: *models the data distribution p(x) and samples new data points*.

---

## 2. Autoencoders: The Information Bottleneck

### 2.1 Why autoencoders? — Representation Learning (RL)
- For many tasks it's impossible to hand-pick which features to extract; instead we present raw data and let the network **autonomously learn the representation** (representation learning).
- Representation learning transforms **high-dimensional data into low-dimensional representations** to:
  1. simplify detection of patterns/anomalies,
  2. enhance comprehension of data behaviour,
  3. reduce complexity & filter noise.
- A good representation must remove two data-distribution factors:
  1. **Variance** — sensitivity leading to dramatic output variation (model must be resilient).
  2. **Entanglement** — embeddings correlating with each other (want disentangled, simpler variables).

### 2.2 The Information Bottleneck
- Concept: **compressing the volume of information** that can traverse the network forces extraction of the most relevant information.
- Like squeezing data through a bottleneck: only the features most pertinent to general concepts remain; irrelevant noisy details are eliminated.

### 2.3 Latent Variables
- A **latent variable z** is a random variable **hidden from direct observation** but pivotal in determining the data distribution.
- We define a low-dimensional **conditionaldistribution p(x|z)**; models using latent variables enable a *generative process* mirroring data generation:
  - sample `z ~ p(z)`, then draw observation `x ~ p(x|z)`.
- Autoencoders are the **foundational concept for transformer architectures** and are used in dimensionality reduction, feature learning, and as generative models.

### 2.4 Autoencoder Architecture (three components — MEMORIZE)
1. **Encoder** — compresses input by stacking layers with **fewer and fewer neurons**; produces embedding.
2. **Latent space ("Information Bottleneck")** — minimal space where information is encoded (the compressed representation).
3. **Decoder** — decompresses/reconstructs the original input from the latent representation; output compared with the true input.

- **Loss = reconstruction loss ＋ regularizer:**
  `L(x, x̂) + regularizer`
  - Reconstruction term → model must be **sensitive to inputs** (accurate reconstructions).
  - Regularizer → model must be **insensitive to overfitting/memorization**.
  - A scaling parameter tunes the trade-off.
- Think: `encoder: z = f(x)`, `decoder: x̂ = g(z)`.

### 2.5 Types of Autoencoders (comparison table — exam favourite)

| Type | Constraint imposed | Idea | Notes |
|---|---|---|---|
| **Incomplete autoencoder** | Fewer hidden nodes | Force compression → learn most important features | ≈ non-linear generalization of **PCA**; learns a nonlinear surface in low-dim space |
| **Sparse autoencoder** | Sparsity constraint on hidden-layer activations | Only a few neurons active per input | Uses **L1 regularization or KL divergence** to penalize excessive activation; limits memorization, keeps feature extraction |
| **Denoising autoencoder** | Add random (Gaussian) noise to input; target = uncorrupted input | Learn robust features by reconstructing clean data from noisy data | Learns a vector field; performs well only near training distribution |
| **Variational autoencoder (VAE)** | Latent restricted to a distribution (encoder outputs mean μ and std σ) | Generative model with **continuous latent space** → sample/interpolate | Decoder samples from Gaussian ⇒ synthetic data close to real; KL-divergence loss keeps encodings centred (μ→0, σ→1) |

> **Trick:** For "compare autoencoders" questions say: *incomplete bounds capacity by width, sparse bounds by active neurons, denoising by corruption, variational by distributional regularisation.*

---

## 3. Generative Adversarial Networks (GANs)

### 3.1 Idea
- While autoencoders compress & reconstruct, **GANs generate realistic data indistinguishable from real samples** — increasing diversity/augmenting training data.
- GAN (Bengio/I. Goodfellow 2014) — **unsupervised generative modeling** via two competing neural networks: **generator** and **discriminator** (**game-theoretic min-max**).

### 3.2 The Generative Model (Generator)
- Takes **random noise vector (fixed length, from a Gaussian)** as input → generates a sample in the target domain (e.g., an image crafted by a CNN).
- Maps noise-space points into the problem domain — a **compressed representation of the data distribution**; the latent vector space holds hidden variables.

### 3.3 The Discriminative Model (Discriminator)
- Takes a sample (real **or** generated) and predicts a **binary label: real vs fake**.
- Acts as a conventional classifier.
- After training, the discriminator is discarded; we keep the **generator**. The generator's feature-extraction layers can be reused for **transfer learning**.

### 3.4 GAN vs Autoencoder (memorize the contrast)
| Aspect | Autoencoder | GAN |
|---|---|---|
| Goal | Compress + reconstruct input | Generate *new*, realistic samples |
| Learning | Unsupervised, reconstruction loss | Adversarial generator vs discriminator |
| Realism | Outputs close to training data | Captures underlying distribution; high-quality, diverse samples |
| Typical use | Dimensionality reduction, features | Text & image generation, data augmentation |

> **Exam trap:** GANs are *not* used for NLP transformers per se (Atkinson notes GANs are mainly for generating realistic synthetic data like images, not translation/QA). Attention + transformers are the NLP path.

---

## 4. Attention Models

### 4.1 Motivation — the "cocktail party problem"
- Humans focus attention on one activity while filtering distractions; our brain uses **attention + short-term memory**.
- In NLP, we want to focus on the **most relevant words** (e.g., in translation) rather than squash an entire sentence into one vector.

### 4.2 Problem with plain encoder-decoder (Seq2Seq)
- Traditional NLP used RNN/LSTM encoder-decoder; encoder compresses the whole input into a single **fixed-length context vector** (last hidden state).
- **Long-range dependence problem:** for long sentences the model "forgets" earlier parts and translation quality drops.

### 4.3 The attention idea
- At each decoding step, the model **searches the encoder's hidden states** for positions containing the most relevant information for the next output word.
- Weights ("attentional weights") quantify how much each input position matters for the current output.
- Example (Atkinson): predicting "Croatian" in *"Despite being from Italy, since he was raised in Croatia, he feels more comfortable speaking ___"* — the words "raised" & "Croatia" should get high weights, "Italy" low.

### 4.4 Types of attention
- **Self-attention:** inter-dependencies among input elements (word attends to all words incl. itself).
- **General (cross) attention:** attention between input and output elements.
- Attention built **fixed-length** representations cheaply and catalyzed **transformers** → BERT, GPT.

### 4.5 Encoder-Decoder Paradigm
- General family: transform domain A → domain B in two stages:
  - `encoder z = f(x)` (compress to latent) and `decoder y = g(z)` (predict output).
- Built from RNNs/LSTMs for **Seq2Seq** (machine translation, image captioning).
- Advantage: encoder & decoder are **separate** → support **varying sequence lengths**.
- Limitation: relies only on the *final* encoder representation → attention fixes this.

---

## 5. Transformers

### 5.1 Why transformers?
- CNNs/RNNs are **inefficient** and struggle with **very long sequences** (translation, QA).
- **Transformer** (Vaswani et al., 2017 — "Attention is all you need") is an attention-based **encoder-decoder** architecture.
- **Key advantage: parallelism** — unlike RNNs (sequential tokens), transformers process all tokens **in parallel** via self-attention; each word attends to itself + every other word to compute a **contextualised representation**.
- Faster training, better on long-range dependencies.

### 5.2 High-level view
- Input: sequence of words → embeddings + positional encoding → **encoder stack** → continuous representation → **decoder stack** → (shifted right, predicting one token at a time, always the most probable) → output probabilities.
- Three parts: **encoder, decoder, residual connections** carrying information between sublayers.

### 5.3 Encoder Layer
- Receives fixed-size token list (hyperparameter, e.g., 512 tokens; longest sentence in training set).
- Each encoder block = **self-attention layer → feed-forward neural network (FNN)**.
- Paths are independent except at the **attention layer** which interconnects positions ⇒ routes run **in parallel** through the FNN.
- Output feeds the next encoder in the stack.

### 5.4 Positional Encoding (PE)
- Multi-head attention cannot distinguish word order; a bag of words has no position notion (e.g., *"John took it away from a dog"* vs *"A dog took it away from John"*).
- → Add a **positional encoding vector to each input embedding**.
- Why not just index 0,1,2…? indices grow unbounded for long sequences; normalizing by length breaks relative positions.
- Formula (sine / cosine):
```
PE(pos, i) = sin(pos / 10000^(i/d_model))      if i even (0)
PE(pos, i) = cos(pos / 10000^((i−1)/d_model))  if i odd
```
- Even dims → sine, odd dims → cosine. Different dimensions = different frequencies.
- Interpretation: each position = a **"clock" with many hands** at different speeds; relative positions are linearly learnable.
- (Modern LLMs use variants like **RoPE** — rotary position embeddings — LLM.md.)

### 5.5 Residual Connections & Layer Norm
- Each sublayer has a **residual connection** (add input back to output) followed by **layer normalization**.
- Residuals let **gradients flow directly** through the network during training.
- Layer norm **stabilizes** training and reduces time.
- The normalized output passes through an FNN: **two linear layers with ReLU** in between.

### 5.6 Decoder Layer (autoregressive generation)
- Each decoder block: masked self-attention → encoder-decoder attention → FNN + residuals + layer norm.
- **Masked self-attention:** prevents the decoder from attending to **future tokens** by masking positions with `−∞` before SoftMax (so future-token attention scores become 0). This keeps the model autoregressive (predict next token given only the past).
- **Encoder-decoder attention:** queries (Q) come from the decoder layer below; keys & values (K, V) come from the top of the **encoder stack** → decoder focuses on relevant *input positions* while generating.
- Starts with a `<start>` token; stops on an end token.

### 5.7 Linear Layer & SoftMax
- Final FNN output → **linear classifier layer**, sized = vocabulary size (e.g., 10,000 classes → 10,000 **logits**).
- → **SoftMax** converts logits to probability distribution (0–1).
- Highest-probability token is the predicted word; token appended to decoder input and decoding continues.

### 5.8 Training
- Data = (**input sequence, target sequence**) pairs.
- Flow: input embeddings+PE → encoder → decoder (fed target embeddings+PE) → output layer → loss vs. target → backprop.
- Can **stack encoder/decoder blocks (Nx)** for more power — but training cost rises.
- All encoders identical in structure but **do not share weights**.
- Loss compares output distribution vs target via **cross-entropy or KL divergence** (later §5.10).

### 5.9 Inference
- Only input sequence available (no target).
- Start decoder with empty sequence + `<start>`; predict token, append to decoder input, re-feed; repeat until end token.
- Encoder runs **once**; only the decoder input grows each step (unlike classic Seq2Seq, we re-feed the *entire* output sequence so far).

### 5.10 Loss Function
- Example: translating "merci" → "thank you" — model outputs a probability distribution over the vocabulary; compare to the target distribution via **cross-entropy / KL divergence**, backprop updates weights.

### 5.11 Attention mechanism computation (LLM.md recap)
- Steps of attention: (1) **score** relevance of each previous token to the current token; (2) combine positions into a single output vector using the scores.
- **Query, Key, Value** projection matrices (learned).
- Compares the current token's query with all previous keys → attention scores → weighted sum of values.

---

## 6. Recent Improvements & Multimodal LLMs (foundation for Unit II)

- **Local/sparse attention** (reduced cost), **multi-query & grouped-query attention** (share KV across heads), **RoPE** positional embeddings.
- **Multimodal LLMs** — connect text + images:
  - **CLIP** (Contrastive Language-Image Pre-training): aligns image & text embeddings → zero-shot classification, clustering, search, generation.
  - **BLIP-2**: bridges vision & language with a **Q-Former** connecting a frozen image encoder and a frozen LLM; trained on (1) image-text **contrastive** learning, (2) **image-text matching**, (3) **image-grounded text generation**.
- These set the stage for tokenization & LLMs in Unit II.

---

## 7. Quick Revision & Exam Strategy

### Likely exam questions
1. Define Generative AI; differentiate traditional vs generative AI.
2. Explain the information bottleneck & latent variables in autoencoders. (10 marks)
3. Compare autoencoder vs GAN; generator vs discriminator.
4. Why is attention needed? Explain the encoder-decoder paradigm and its long-range-dependence problem.
5. Draw & explain transformer architecture: encoder layer, positional encoding, residual connections, decoder layer (masking), linear + SoftMax.
6. Explain transformer training vs inference flow (with the "merci→thank you" example).
7. Explain self-attention with Q/K/V (from the pedagogy link — the soloshun attention lab).

### Tips & Tricks
- Always **draw the transformer block** (encoder: attention→norm→FNN→norm; decoder: masked-attn → cross-attn → FNN) — worth half the marks.
- Quote the **PE clock analogy** and the sine/cosine rule (even→sin, odd→cos) verbatim; include the "John bought a book" example.
- The **cocktail-party problem** intro is the required hook for any "attention" answer.
- For "why positional encoding?" give the two-sentence ordering counter-example (*"John took it away from a dog" vs "A dog took it away from John"*).
- Connect Unit 1 → Unit 2: *transformers give us contextualized token representations → LLM tokenizers/embeddings build on exactly these* (this cross-link scores extra marks).
- Know the glossary: latent variable, embedding, context vector, logits, SoftMax, autoregressive, masked self-attention, Q/K/V.

---
*Sources: syllabus.txt (Unit I); Large Language Models ConceptsAtkinson.md §1, §2.8–2.11; LLM.md (Alammar slides).*