# Unit 1: Generative AI — Fundamentals, Autoencoders, GANs, Attention & Transformers

> **Course:** Prompt Engineering for Generative AI (CI72) · **Unit I**
> **Base:** `Unit1_Generative_AI_Fundamentals_Autoencoders_GANs_Attention_Transformers.md`
> **Merged with:** `GenAI_U1.md` (Ramya slides) — off-syllabus extras removed
> **Texts:** *Large Language Models: Concepts, Techniques and Applications* — Atkinson & Abutridy (CRC, 2025); *Hands-On Large Language Models* — Alammar & Grootendorst (O'Reilly, 2024).

---

## 1. Definition and Fundamentals of Generative AI

### 1.1 What is Generative AI?
- **Generative AI (GenAI)** is a branch of artificial intelligence that focuses on **creating new content** — text, images, audio, video, computer programs, designs, and synthetic data — by **learning patterns and relationships from existing data**.
- **Traditional AI** is generally designed to **analyze, classify, predict, or make decisions**; Generative AI goes further and **produces new outputs that resemble the data on which it was trained**.

### 1.2 Traditional AI vs Generative AI (examples)
- Traditional AI determines whether an email is **spam / not spam**; Generative AI **writes a new email** from a user's instructions.
- A traditional computer-vision model **classifies an image as a cat**; a Generative AI model **creates a new image of a cat** that did not previously exist.

### 1.3 Case study — learning patterns
A model trained on thousands of handwritten-digit images learns characteristics such as **shapes, curves, strokes, positions, and the relationships between pixels**. After learning these patterns it can **generate a new handwritten digit**.
```
Training Data → Learning Patterns → Generative Model → New Content
```

### 1.4 Generative vs Discriminative models
- A **discriminative model** approximates `P(y | x)` where `x` is the input and `y` is the class/target — it learns the **decision boundary or relationship**.
- A **generative model** attempts to learn the **underlying data distribution**: `P(x)`, or for conditional generation `P(x | y)`.

### 1.5 Traditional AI → Generative AI (history & evolution)
- Early AI: rule-based "expert systems", symbolic reasoning, hand-crafted features.
- Modern: ML classifiers → deep learning → **generative models** that create new content.
- **Traditional flow:** `X → AI Model → Y` (decision / classification / prediction).
  Example — disease detection: `Medical Image → CNN → Disease / No Disease`. The model **does not create** a new medical image; it predicts a class.
- **Generative flow:** `X → Generative Model → New Content`.
  Examples — `Prompt → LLM → Generated Text`; `Text Prompt → Generative Model → Generated Image`. The generated output **may not have existed in the training dataset**.
- Generative deep learning used architectures such as **autoencoders** (and their probabilistic extension **VAEs**), **GANs**, and **transformers** to generate new data.

---

## 2. Autoencoders: The Information Bottleneck

An **autoencoder** is a neural network trained to **encode** input data into a compressed representation (encoding) and then **decode** it back to a reconstruction that resembles the original input.

### 2.1 The Information Bottleneck
- **Concept:** compress the volume of information flowing through the network so that only the most relevant information/features survive.
- Reduces dimensionality and complexity; **irrelevant noise is dropped**; only features key to general concepts remain.
- Think of squeezing data through a bottleneck — what passes through is the essential "information".

### 2.2 Latent Variables
- A **latent variable z** is a hidden variable that shapes the data distribution and is **much lower-dimensional** than the input (the compressed form).
- Latent variables **enable a generative model**:
```
Generate:  z ~ p(z)  →  x ~ p(x | z)
```
Sample a latent `z` from its distribution `p(z)`, then draw a new observation `x` from the conditional distribution `p(x | z)`.

### 2.3 Autoencoder Architecture (three components)
1. **Encoder** — stacked layers with fewer and fewer neurons → compresses the input into the latent code.
2. **Latent space (bottleneck)** — the minimal space holding the compressed representation.
3. **Decoder** — decompresses/reconstructs the output, which is compared with the true input.

```
Input (x) → Encoder → Latent Space (z) → Decoder → Reconstructed Input (x̂)
```
```
Loss = Reconstruction loss L(x, x̂) + Regularizer
```
- The reconstruction term keeps the model **sensitive to inputs** (accurate reconstructions).
- The regularizer **discourages memorization / overfitting**.
- A **scaling parameter tunes the trade-off** — the model must be sensitive enough to reconstruct accurately, yet not so sensitive that it memorizes.

### 2.4 Types of Autoencoders

**Incomplete (Undercomplete) Autoencoder**
- Limits the number of hidden nodes to restrict information flow; penalized by reconstruction error.
- Non-linear generalization of **PCA** — learns a curved surface, not just a hyperplane.
- The bottleneck (latent) layer has **fewer neurons than the input**, forcing compression and learning only the most important features.

**Sparse Autoencoder**
- Limits active neurons via a **sparsity penalty** in the loss (different inputs activate different nodes).
- Curbs memorization while keeping feature extraction.
- Penalties: **L1 regularization** or **KL divergence**.

**Denoising Autoencoder (DAE)**
- Input is corrupted with noise (e.g., Gaussian); the **clean data is the target**.
- Learns a vector field pulling inputs to a low-dimensional region; works well near the training data.
- Trained with a squared-error criterion to map `X̃ → X` (noisy → clean); learns robust features that capture underlying structure, not the noise.
- Noise types: **Gaussian** (add small random values), **masking** (set some input values to zero), **salt-and-pepper** (set some pixels to 0 or 1).
```python
import torch
import torch.nn as nn

def add_noise(inputs, noise_factor=0.3):            # Add Gaussian noise
    noisy = inputs + noise_factor * torch.randn_like(inputs)
    return torch.clip(noisy, 0., 1.)

class DenoisingAutoencoder(nn.Module):
    def __init__(self):
        super().__init__()
        self.encoder = nn.Sequential(
            nn.Linear(784, 256), nn.ReLU(),
            nn.Linear(256, 64))
        self.decoder = nn.Sequential(
            nn.Linear(64, 256), nn.ReLU(),
            nn.Linear(256, 784), nn.Sigmoid())
    def forward(self, x):
        return self.decoder(self.encoder(x))
```

**Variational Autoencoder (VAE)**
- A **generative** model with a **continuous latent space** → easy sampling & interpolation.
- The encoder outputs a mean `μ` and standard deviation `σ`; the code is **sampled from that Gaussian** and passed to the decoder.
- A **KL-divergence loss** pushes `μ → 0` and `σ → 1`, spreading codes evenly around the latent-space centre.

> **Comparison trick:** *incomplete bounds capacity by width, sparse bounds by active neurons, denoising by corruption, variational by distributional regularisation.*

---

## 3. Generative Adversarial Networks (GANs)

### 3.1 Idea
- **GANs** perform generative modeling via **unsupervised learning** using two competing neural networks — a **generator** and a **discriminator** — in a **game-theoretic** min-max competition.
- The generator creates samples while the discriminator distinguishes **real from fake**.
- Beyond synthesis, GANs act as a **data-augmentation** technique, reducing generalization error.

### 3.2 The Generative Model (Generator)
- Input: a **random fixed-length vector from a Gaussian distribution** (noise).
- Output: a **sample in the problem domain** (e.g., an image crafted by a CNN).
- Its vector space is a **compressed representation with latent variables**.
- This is the **model we keep after training**; its feature-extraction layers can be **reused for transfer learning**.

### 3.3 The Discriminative Model (Discriminator)
- Input: a **real or generated example**.
- Output: a **binary label — real or fake** (a standard classification model).
- Its role **ends after training**.

### 3.4 GAN flow
```
Random noise (z) → Generator (CNN) → Generated sample (fake)
                                         ↓
Real samples ───────────────→ Discriminator (classifier) → Real / Fake (binary label)
```

---

## 4. Attention Models

### 4.1 Motivation — the "cocktail party problem"
- Humans focus attention on one activity while filtering distractions; the brain uses **attention + short-term memory**.
- In NLP we want to focus on the **most relevant words** (e.g., for translation) rather than squash an entire sentence into one vector.

### 4.2 Problem with the plain encoder-decoder (Seq2Seq)
- Traditional NLP used an RNN/LSTM encoder-decoder that compressed the whole input into a single **fixed-length context vector** (the last hidden state).
- **Long-range dependence problem:** on long sentences the model "forgets" earlier parts and translation quality drops.

### 4.3 The attention idea
- At each decoding step the model **searches the encoder's hidden states** for the positions most relevant to the next output word.
- **Attentional weights** quantify how much each input position matters for the current output.
- Example (Atkinson): predicting "Croatian" in *"Despite being from Italy, since he was raised in Croatia, he feels more comfortable speaking ___"* — "raised" and "Croatia" get high weights, "Italy" low.

### 4.4 Encoder-Decoder Paradigm
- General family: transform domain A → domain B in two stages: `encoder z = f(x)` (compress to latent) and `decoder y = g(z)` (predict output).
- Built from RNNs/LSTMs for **Seq2Seq** (machine translation, image captioning).
- Advantage: encoder & decoder are **separate** → support **varying sequence lengths**.
- Limitation: relies only on the *final* encoder representation → **attention fixes this**.

### 4.5 Attention with Query, Key, Value (Q/K/V)
- Attention is essentially **weighted embeddings** — "smart", more contextualized embeddings (an advanced form of word2vec) using a specific matrix formula.
- Each input token is transformed into three vectors:
  - **Query (Q)** — "What information am I looking for?"
  - **Key (K)** — "What kind of information do I offer?"
  - **Value (V)** — "What actual information do I carry?"
- It works like a matchmaking system between words: compare a word's **Query** against the **Keys** of every other word; strong matches receive closer attention; then combine the **Values** by those weights.

**Attention steps**
| Step | Action |
|---|---|
| 1 | Each word creates its **Q, K, V** vectors |
| 2 | Compute attention scores (`Q × Kᵗ`) — dot product between words |
| 3 | Apply **softmax** to normalise scores into attention weights (their sum = 1) |
| 4 | Use the weights to **combine the Value vectors (V)** → output `Y` |
| 5 | Pass `Y` as input to the next layer |

**Scaled attention formula**
```
Attention(Q, K, V) = softmax( Q·Kᵗ / √dk ) · V
```
- `Q·Kᵗ` measures similarity between queries and keys.
- `dk` is the scaling factor = dimension (number of elements) of each Key vector; it prevents very large dot-product values.
- **Softmax** converts scores into probabilities; multiply by `V` to get a weighted sum of the values.
- **Trainable parameters:** multiplying by the weight matrices `W_Q`, `W_K`, `W_V` is equivalent to adding a linear layer; these are learned from the error signal during training.

### 4.6 Self-, Masked, and Cross (Inter) Attention
| Type | Purpose / behaviour | Where used |
|---|---|---|
| **Self-attention** | Each word attends to every other word in the *same* sentence (incl. itself) | Encoder and decoder |
| **Masked self-attention** | Prevents a token from seeing **future** tokens (keeps the decoder autoregressive) | Decoder (during training) |
| **Cross- (Inter-) attention** | Decoder attends to **encoder outputs**; `Q` from the decoder, `K` & `V` from the encoder | Encoder-decoder models (e.g., translation) |

- **Encoder layer:** self-attention → focuses on **all** input tokens.
- **Decoder layer:** masked self-attention → looks only at **past outputs**; cross-attention → focuses on encoder outputs for translation.

### 4.7 Multi-head Attention
- Instead of one attention system, run **several attention blocks in parallel** — these are **heads**.
- Each head can specialise (e.g., grammar, semantics, position, references).
- Example: the word **"bank"** has several sub-contexts — *credit-card bank*, *bank shares*, *river bank* — each captured by a different head.
- Outputs are **concatenated** and passed through a **linear layer** (`W_O`):
```
MultiHead(Q, K, V) = concat(H₁, H₂, …, H_h) · W_O
where  H_i = Attention(Q·W_i^Q,  K·W_i^K,  V·W_i^V)
```
- **Single-head vs multi-head:** single-head can create one embedding for "bank" per context; multi-head assigns different embeddings for different sub-contexts, even within the same context.

### 4.8 Masked Attention (why masking?)
- The decoder must not "see the future". While predicting the word at time *t*, it may use only words up to time *t−1*.
- At test time future words are unavailable, so decoder attention is **masked from future words**.
- Encoder self-attention needs **no** such masking (it sees the whole input at once).
- Example (English→Spanish): while translating *"A nearly perfect photo"* → *"Una foto casi perfecta"*, attention for "casi" may only consider words seen so far.

---

## 5. Transformers

### 5.1 Why transformers?
- CNNs/RNNs are **inefficient** and struggle with **very long sequences** (translation, QA).
- The **Transformer** (Vaswani et al., 2017 — *"Attention is all you need"*) is an attention-based **encoder-decoder** architecture.
- **Key advantage — parallelism:** unlike RNNs (sequential tokens), transformers process **all tokens in parallel**; each word attends to every other word to build a **contextualised representation**.
- Faster training, better on long-range dependencies.

### 5.2 High-level view
- Input: sequence of words → **embeddings + positional encoding** → **encoder stack** → continuous representation → **decoder stack** (shifted right, predicting one token at a time) → output probabilities.
- Three parts: **encoder, decoder, and residual connections** carrying information between sublayers.

### 5.3 Encoder Layer
- Receives a fixed-size token list (a hyperparameter, e.g., 512 tokens; longest sentence in the training set).
- Each encoder block = **self-attention layer → feed-forward neural network (FFN)**, with **residual connections + layer normalization**.
- Paths run **in parallel** except at the attention layer, which interconnects positions.
- Output: **contextual embeddings** for each input token (a rich representation of the source sequence); feeds the next encoder in the stack.

**Feed-forward Network (FFN)**
```
Input (per token) → Linear → ReLU → Linear → Output (same token)
FFN(x) = max(0, x·W1 + b1)·W2 + b2
```
- Applied independently to each position; adds non-linearity and capacity beyond the linear attention mechanism.

### 5.4 Positional Encoding (PE)
- Multi-head attention cannot distinguish word order; a bag of words has no position notion.
  - *"Dog bites man."* vs *"Man bites dog."* — same words, different meaning.
  - *"the food was good, not bad"* vs *"the food was bad, not good"* — self-attention alone treats them the same; order matters.
- → **Add a positional-encoding vector to each input embedding** before processing (transformers add position information to every word).
- **Why not just index 0,1,2…?** indices grow unbounded for long sequences, and normalizing by length breaks relative positions.
- **Sinusoidal (static) encoding** — introduced in Vaswani et al. (2017); uses sine and cosine of different frequencies; no learned parameters:
```
PE(pos, 2i)   = sin( pos / 10000^(2i / d) )
PE(pos, 2i+1) = cos( pos / 10000^(2i / d) )
```
- **Even dimensions → sine, odd dimensions → cosine**; different dimensions = different frequencies.
- Interpretation: each position is a **"clock with many hands"** at different speeds; relative positions become linearly learnable.
- **Worked example:** for *"the food was good not bad"* with positions `pos = 0…5` and `d = 4` (i runs 0…3), each position gets its own fixed PE vector (e.g., `PE(0,0)=sin(0)=0`, `PE(1,1)=sin(1/10000^0.5)≈0.10`, …). The PE vector is **added** to the word embedding, so the two sentences above end up with **different** position-updated embeddings.
- Both word2vec (word representation) and positional encoding (position representation) are vectors; they are **added** and passed to the encoder. (Modern LLMs use variants like **RoPE**.)

### 5.5 Residual Connections & Layer Norm
- Each sub-layer (self-attention, FFN) is wrapped with a **residual connection** (input added to output) followed by **layer normalization**:
```
Output = Sublayer(x) + x
```
- **Why residual connections?**
  - Prevent the **vanishing-gradient** problem (provide a "shortcut" for gradient flow).
  - Preserve information (the original input `x` still passes forward).
  - Enable deep architectures and stabilise training (with layer norm).
- **Layer normalization** normalises activations across the features of each token (per sample/token), preventing the mean and standard deviation from drifting and keeping training stable and fast.

### 5.6 Decoder Layer (autoregressive generation)
- Each decoder block: **masked self-attention → encoder-decoder (cross) attention → FFN**, plus residual connections and layer norm. The decoder computes source-target attention between the input-sentence embeddings and the (partial) output-sentence embeddings.
- **Masked self-attention:** masks future positions (with `−∞` before SoftMax, so their attention scores become 0) → keeps the model **autoregressive** (predict the next token given only the past).
- **Encoder-decoder attention:** `Q` from the decoder layer below; `K` and `V` from the top of the encoder stack → the decoder focuses on relevant *input positions* while generating.
- Starts with a `<start>` token; generation stops on an end token.
- The transformer assumes no recurrence/convolution, so it works for **any sequence data** (e.g., image patches as sequences, states/actions/rewards in RL).

### 5.7 Linear Layer & SoftMax
- The final FNN output goes to a **linear classifier layer** whose size = **vocabulary size** (e.g., 10,000 → 10,000 **logits**).
- **SoftMax** converts logits into a probability distribution (0–1).
- The highest-probability token is the predicted word; it is appended to the decoder input and decoding continues.

### 5.8 Training
- Data = (**input sequence, target sequence**) pairs.
- Flow: input embeddings + PE → encoder → decoder (fed target embeddings + PE) → output layer → loss vs. target → backprop.
- Encoder/decoder blocks can be **stacked (N×)** for more power; training cost rises. All encoders share structure but **do not share weights**.
- Loss compares the output distribution with the target via **cross-entropy / KL divergence** (see §5.10).

### 5.9 Inference
- Only the input sequence is available (no target).
- Start the decoder with an empty sequence + `<start>`; predict a token, append it to the decoder input, re-feed; repeat until the end token.
- The encoder runs **once**; only the decoder input grows each step (we re-feed the entire output sequence so far).

### 5.10 Loss Function
- The loss measures how different the predicted output is from the correct target; it is used during backpropagation to update the weights.
- **Language modelling loss — cross-entropy:** if the input is `"The cat is"` and the model predicts the next word with probabilities

| Word | Predicted probability |
|---|---|
| sleeping | 0.60 |
| running | 0.20 |
| eating | 0.15 |
| jumping | 0.05 |

and the actual next word is "sleeping", then
```
L = −log( P(correct word) ) = −log(0.60) ≈ 0.511
```
A higher probability for the correct word → lower loss.

- **Training loop:** Input Tokens → Embedding + Positional Information → Transformer Layers (Attention + FFN) → Logits → SoftMax → Predicted Probabilities → compare with Actual Target → Cross-Entropy Loss → Backpropagation → update weights → repeat until loss is minimised.
- Example (translation "merci" → "thank you"): compare the output distribution with the target distribution via cross-entropy; backprop updates the weights.

---

## 6. Lab / Pedagogy
- **Demonstration of the attention mechanism** — the "LLM from scratch" attention lab:
  `https://github.com/soloshun/llm-from-scratch/blob/master/src/part06_attention_mechanism.py`
- Hands-on LLM chapters: `https://github.com/rasbt/LLMs-from-scratch`

---

## 7. Quick Revision & Exam Strategy

**Likely exam questions**
1. Define Generative AI; differentiate traditional vs generative AI.
2. Explain the information bottleneck & latent variables in autoencoders. (10 marks)
3. Explain the three components of an autoencoder and the loss `L(x, x̂) + regularizer`.
4. Compare the generator and discriminator in a GAN.
5. Why is attention needed? Explain the encoder-decoder paradigm and the long-range-dependence problem.
6. Explain attention with Q/K/V, scores, softmax, and multi-head attention.
7. Draw & explain the transformer architecture: encoder layer, positional encoding, residual connections, decoder layer (masking), linear + SoftMax.
8. Explain transformer **training vs inference** flow (the "merci → thank you" example).
9. Write the scaled attention formula and explain each term.

**Tips & tricks**
- Always **draw the transformer block** (encoder: attention → norm → FFN → norm; decoder: masked-attn → cross-attn → FFN).
- Quote the **PE clock analogy** and the sine/cosine rule (even → sin, odd → cos).
- The **cocktail-party problem** is the required hook for any "attention" answer.
- For "why positional encoding?", use the ordering counter-example (*"Dog bites man"* vs *"Man bites dog"*).
- Know the glossary: latent variable, embedding, context vector, logits, SoftMax, autoregressive, masked self-attention, Q/K/V, information bottleneck.
- Connect Unit 1 → Unit 2: *transformers give contextualised token representations → LLM tokenizers/embeddings build on exactly these.*

---

*Sources: syllabus.txt (Unit I); Unit1_Generative_AI_Fundamentals_Autoencoders_GANs_Attention_Transformers.md; GenAI_U1.md (Ramya slides).*
