# Numericals — Prompt Engineering for Generative AI (CI72)

> **Course:** Prompt Engineering for Generative AI (CI72)
> **Scope:** All calculable / numeric problems across **Unit I (attention, transformers, autoencoders), Unit II (tokenization, embeddings, GPT scale), Unit III (prompt cost, CoT/self-consistency/ToT)**, plus a short retrieval numerics appendix (Unit V).
> **References:** *Large Language Models: Concepts, Techniques and Applications* — Atkinson & Abutridy (CRC, 2025); *Hands-On Large Language Models* — Alammar & Grootendorst (O'Reilly, 2024).
> **How to use:** every problem gives the **formula → worked solution → final answer**. Practise by covering the solution.

---

## 0. Master Formula Sheet

| Quantity | Formula |
|---|---|
| Transformer attention | `Attention(Q,K,V) = softmax(QKᵗ / √dₖ) · V` |
| Softmax | `softmax(zᵢ) = e^{zᵢ} / Σⱼ e^{zⱼ}` |
| Scaled score | `score = (q · k) / √dₖ` |
| Cross-entropy loss | `L = −log P(correct token)` (natural log) |
| Perplexity | `PPL = e^L` (inverse of geometric-mean probability) |
| Positional encoding | `PE(pos,2i) = sin(pos / 10000^{2i/d})`, `PE(pos,2i+1) = cos(pos / 10000^{2i/d})` |
| Layer normalisation | `y = (x − μ) / √(σ² + ε) · γ + β` |
| Reconstruction loss (MSE) | `L = (1/n) Σ (xᵢ − x̂ᵢ)²` |
| VAE KL divergence | `KL = −½ Σ (1 + log σᵢ² − μᵢ² − σᵢ²)` |
| Cosine similarity | `cos(a,b) = (a·b) / (‖a‖ ‖b‖)` |
| Euclidean distance | `d(a,b) = √(Σ(aᵢ − bᵢ)²)` |
| Dot-product similarity | `a·b = Σ aᵢbᵢ` |
| Embedding-matrix params | `params = vocab_size × d_model` |
| Dense-layer params | `params = (in × out) + out` (weights + bias) |
| Multi-head dims | `dₖ = dᵥ = d_model / h` |
| Sliding window count | `N_windows = floor((N − L)/stride) + 1` |
| Token cost | `cost = (tokens / 1000) × price_per_1K` |
| Self-consistency majority | `P(≥r of n correct) = Σ_{k=r}^{n} C(n,k) pᵏ(1−p)^{n−k}` |
| UTF-8 byte count | sum of bytes of each character (ASCII = 1, many non-Latin = 2–4) |

---

# PART A — TOKENIZATION (Unit II)

## A1. Counting tokens at each granularity
**Q.** Tokenize `"playing"` at four levels and give the token count.
**Solution.**
- **Word-level:** `["playing"]` → **1 token** (large vocabulary problem: play, playing, played… all separate).
- **Character-level:** `["p","l","a","y","i","n","g"]` → **7 tokens** (tiny vocabulary).
- **Subword (BPE):** `["play", "ing"]` → **2 tokens** (best balance).
- **Byte-level:** bytes of `playing` → **7 bytes** (each ASCII char = 1 byte).
**Answer:** Word 1 · Character 7 · Subword 2 · Byte 7.

## A2. Byte count of arbitrary Unicode text
**Q.** How many bytes (and hence how many tokens in a byte-level tokenizer, worst case) does the string `"café ☕"` need?
**Solution.** `c`=1, `a`=1, `f`=1, `é`=2 (UTF-8), space=1, `☕`=3 (U+2615) → 1+1+1+2+1+3 = **9 bytes**.
**Answer:** 9 bytes → up to 9 byte-tokens (a learned byte-tokenizer would usually merge these into fewer tokens).

## A3. Embedding-matrix parameter count
**Q.** GPT-2 has a vocabulary of **50,257** and an embedding dimension of **1600**. How many parameters does the token-embedding matrix hold?
**Solution.** `params = vocab × d_model = 50,257 × 1600`.
`50,257 × 1600 = 80,411,200`.
**Answer:** **80,411,200 ≈ 80.4 M parameters** (this is one of the largest single matrices in the model).

## A4. Embedding matrix of a fine-tuned model
**Q.** A model uses vocab size **32,000** (Llama-2) and hidden size **4096**. Size the embedding matrix.
**Solution.** `32,000 × 4096 = 131,072,000`.
**Answer:** **≈131.07 M parameters**.

## A5. BPE merge step (worked)
**Q.** Corpus symbols with pair frequencies: `(e,s)=9`, `(s,t)=6`, `(t,e)=6`, `(e,r)=3`. Apply one Byte-Pair-Encoding merge.
**Solution.** BPE merges the **most frequent adjacent pair** → `(e,s)` with frequency 9 → new token **`es`** added to the vocabulary.
**Answer:** Merge `e+s → es`. (Repeat iteratively; each merge adds one vocabulary entry.)

## A6. Sliding window / stride (from the slides)
**Q.** Given token IDs `[1,2,3,4,5,6,7,8,9,10]`, `max_length = 4`, `stride = 2`. How many overlapping windows, and what are they?
**Solution.** `N_windows = floor((N − L)/stride) + 1 = floor((10 − 4)/2) + 1 = 3 + 1 = 4`.
Windows: `[1,2,3,4]`, `[3,4,5,6]`, `[5,6,7,8]`, `[7,8,9,10]`.
**Answer:** **4 windows** (50 % overlap).

## A7. Batch tensor size
**Q.** `batch_size = 4`, `max_length = 256`. How many tokens are processed per batch?
**Solution.** `4 × 256 = 1024`.
**Answer:** **1024 tokens per batch**.

## A8. Tokenizer vocabulary choice
**Q.** A tokenizer with vocab 30,000 vs 50,000 — which gives shorter sequences and which needs a bigger embedding matrix? Quantify with d_model = 768.
**Solution.** Embedding params: `30,000 × 768 = 23,040,000` (23.04 M) vs `50,000 × 768 = 38,400,000` (38.4 M).
**Answer:** The **50 K** vocab needs **+15.36 M** params but typically yields **fewer tokens per sentence** (better token efficiency, shorter sequences).

---

# PART B — EMBEDDINGS & SIMILARITY (Units II & V)

## B1. Cosine similarity
**Q.** Compute cosine similarity between `a = [1,2,3]` and `b = [2,1,0]`.
**Solution.**
`a·b = 1·2 + 2·1 + 3·0 = 4`
`‖a‖ = √(1+4+9) = √14 = 3.7417`
`‖b‖ = √(4+1+0) = √5 = 2.2361`
`cos = 4 / (3.7417 × 2.2361) = 4 / 8.3666 = 0.4781`.
**Answer:** **cos ≈ 0.478** (≈ 61.4° angle) → moderately similar.

## B2. Euclidean distance
**Q.** Distance between the same `a` and `b`.
**Solution.** `√((1−2)² + (2−1)² + (3−0)²) = √(1+1+9) = √11`.
**Answer:** **d = 3.3166**.

## B3. Dot-product similarity
**Q.** Using raw dot product, which of `b = [2,1,0]` or `c = [0,0,4]` is closer to `a = [1,2,3]`?
**Solution.** `a·b = 4`; `a·c = 12`. Raw dot product prefers `c`.
**Answer:** `c` (12) > `b` (4). *Note:* dot product is unnormalised, so long vectors score higher — cosine similarity is preferred for meaning.

## B4. Similarity as angle (attention link)
**Q.** Atkinson defines the attention alignment score as a scaled dot product that "measures the cosine similarity" between states. If `s·h = 8`, `‖s‖ = 4`, `‖h‖ = 2`, find the cosine similarity and the angle.
**Solution.** `cos = 8 / (4×2) = 1.0` → angle = `cos⁻¹(1) = 0°`.
**Answer:** **cos = 1.0 (perfectly aligned).**

## B5. Nearest-neighbour retrieval
**Q.** Query vector `q = [1,1]`. Stored embeddings: `A = [1,0]`, `B = [0,1]`, `C = [1,1]`, `D = [−1,−1]`. Rank by cosine similarity, top-2.
**Solution.** `cos(q,A)=1/√2=0.707`; `cos(q,B)=0.707`; `cos(q,C)=2/2=1.0`; `cos(q,D)=−2/2=−1.0`.
Ranking: **C (1.0) > A = B (0.707) > D (−1.0)**. Top-2 = {C, A} (or C, B).
**Answer:** **C first; A and B tie for second.** (Real tie-break uses secondary metric or index order.)

## B6. Vector-database storage
**Q.** A RAG store holds **10,000** chunk embeddings of dimension **1536**, stored as 4-byte floats. Storage?
**Solution.** `10,000 × 1536 × 4 bytes = 61,440,000 bytes`.
**Answer:** **≈ 61.44 MB** (58.6 MiB).

## B7. Chunking a document
**Q.** A PDF has **10,000 tokens**. Chunk size = 500, overlap = 50. How many chunks?
**Solution.** `stride = 500 − 50 = 450`; `N = floor((10,000 − 500)/450) + 1 = floor(21.11) + 1 = 21 + 1 = 22`.
**Answer:** **22 chunks**.

## B8. nDCG (retrieval ranking)
**Q.** Relevant docs are at ranks **1 and 3**; system returns 4 docs. Compute DCG@4, IDCG@4 and nDCG@4 using `rel/log₂(rank+1)` with binary relevance.
**Solution.**
`DCG = 1/log₂2 + 0 + 1/log₂4 + 0 = 1 + 0 + 0.5 = 1.5`
Ideal order puts the two relevant docs at ranks 1,2: `IDCG = 1/log₂2 + 1/log₂3 = 1 + 0.6309 = 1.6309`
`nDCG = 1.5 / 1.6309 = 0.9197`.
**Answer:** **nDCG ≈ 0.920.**

---

# PART C — ATTENTION (Unit I)

## C1. Scaled dot-product scores
**Q.** `q = [2,0,1]`, keys `k₁=[1,0,0]`, `k₂=[0,1,0]`, `k₃=[0,0,1]`, `dₖ = 3`. Compute the scaled scores.
**Solution.** Raw dots: `q·k₁=2`, `q·k₂=0`, `q·k₃=1`. Scale by `√3 = 1.732`:
`2/1.732 = 1.155`, `0/1.732 = 0`, `1/1.732 = 0.577`.
**Answer:** **scaled scores = [1.155, 0, 0.577]**.

## C2. Softmax over attention scores
**Q.** Continue C1: convert the scaled scores into attention weights.
**Solution.** `e^{1.155}=3.174`, `e^{0}=1.000`, `e^{0.577}=1.781`; sum `= 5.955`.
Weights: `3.174/5.955 = 0.533`; `1.000/5.955 = 0.168`; `1.781/5.955 = 0.299`.
Check: `0.533 + 0.168 + 0.299 = 1.000`.
**Answer:** **weights ≈ [0.533, 0.168, 0.299]** (token 1 gets the most attention).

## C3. Weighted-sum output (context vector)
**Q.** Using weights from C2 and values `v₁=[1,0]`, `v₂=[0,1]`, `v₃=[1,1]`, compute the output `Z`.
**Solution.**
`Z = 0.533·[1,0] + 0.168·[0,1] + 0.299·[1,1]`
`Z_x = 0.533 + 0 + 0.299 = 0.832`
`Z_y = 0 + 0.168 + 0.299 = 0.467`.
**Answer:** **Z = [0.832, 0.467]**.

## C4. "John bought a book" (Atkinson Fig. 2.38) — output for "book"
**Q.** The softmax attention row for **book** is `[0.2, 0.1, 0.1, 0.6]` over (John, bought, a, book). With
`v_John=[1,0]`, `v_bought=[0,1]`, `v_a=[1,1]`, `v_book=[2,0]`, find the self-attention output for "book".
**Solution.**
`x = 0.2·1 + 0.1·0 + 0.1·1 + 0.6·2 = 0.2 + 0 + 0.1 + 1.2 = 1.5`
`y = 0.2·0 + 0.1·1 + 0.1·1 + 0.6·0 = 0 + 0.1 + 0.1 + 0 = 0.2`
**Answer:** **output = [1.5, 0.2]** (dominated by the word's own value, then "John").

## C5. Referent of "he" (Atkinson Table 2.1)
**Q.** Scores for `he` over (A, boy, bought, books, he) are `[0.3, 0.5, 0.001, 0.001, 0.19]`. Verify normality and interpret.
**Solution.** `0.3 + 0.5 + 0.001 + 0.001 + 0.19 = 0.992 ≈ 1`. (Textbook rounds; exact softmax sums to 1.)
**Answer:** **50 % attention to "boy", 30 % to "A", 19 % to "he"** — the pronoun links to "A boy".

## C6. Multi-head dimensions
**Q.** `d_model = 512`, `h = 8` heads. Find `dₖ = dᵥ` per head and the total.
**Solution.** `dₖ = dᵥ = d_model / h = 512 / 8 = 64`.
**Answer:** each head is **64-dimensional**; concatenating 8 heads rebuilds **512**.

## C7. Multi-head output projection
**Q.** 8 heads each output `[·]_{64}`. After concatenation the vector is length 512 and is projected by `W_O` of shape 512×512. Output dim and params of `W_O`?
**Solution.** Output dim = 512. `W_O` params (no bias) = `512 × 512 = 262,144`.
**Answer:** **512-dim output; 262,144 params.**

## C8. BERT-Base vs proposed scaled model
**Q.** BERT-Base = 12 layers, hidden 768, 12 heads. A model triples hidden size to 2304 with 12 heads. New `dₖ`?
**Solution.** `dₖ = 2304 / 12 = 192`.
**Answer:** **192 per head** (×3 larger; attention cost scales with dₖ²).

## C9. Attention-matrix size (memory)
**Q.** Sequence length `n = 512`, 12 heads, 4-byte floats. Memory for one attention-score matrix (all heads)?
**Solution.** Per head: `512 × 512 × 4 = 1,048,576 bytes = 1 MiB`. For 12 heads: `12 × 1 MiB = 12 MiB`.
**Answer:** **≈ 12 MiB** per layer per batch item (this is why attention is memory-hungry; scales as `n²`).

## C10. Causal mask sanity
**Q.** For a 4-token sentence, how many of the 16 attention entries are **blocked** by the causal mask?
**Solution.** Blocked = strictly-upper-triangle entries = `n(n−1)/2 = 4×3/2 = 6`.
**Answer:** **6 of 16 blocked**; 10 are allowed (including the diagonal).

---

# PART D — SOFTMAX, LOSS & PERPLEXITY (Units I & II)

## D1. Softmax of logits
**Q.** Logits `z = [2.0, 1.0, 0.1]`. Compute softmax probabilities.
**Solution.** `e^{2.0}=7.389`, `e^{1.0}=2.718`, `e^{0.1}=1.105`; sum `=11.212`.
`p = [7.389/11.212, 2.718/11.212, 1.105/11.212] = [0.659, 0.242, 0.0986]`.
**Answer:** **p ≈ [0.659, 0.242, 0.099]** (sums to 1).

## D2. Cross-entropy loss
**Q.** The model outputs the probabilities from D1 for `["Paris","London","Rome"]` and the correct next word is **Paris**. Compute the loss.
**Solution.** `L = −ln(0.659) = 0.417`.
**Answer:** **L ≈ 0.417 nats.**

## D3. Loss for a weak prediction
**Q.** If `P(correct) = 0.05`, find `L`.
**Solution.** `L = −ln(0.05) = 2.996`.
**Answer:** **L ≈ 2.996** (high loss — the model was wrong/unsure).

## D4. Perplexity
**Q.** Compute perplexity for `L = 0.417` and for a uniform model over `V = 30,000` tokens.
**Solution.** `PPL = e^{0.417} = 1.517`. Uniform: `L = ln(30,000) = 10.309`, `PPL = e^{10.309} = 30,000`.
**Answer:** **PPL ≈ 1.52** (good) vs **30,000** (pure guessing). Perplexity = "effective vocabulary the model is choosing among".

## D5. Average loss over a batch
**Q.** Losses for 4 next-token predictions: `0.2, 0.5, 1.0, 0.3`. Find mean loss and perplexity.
**Solution.** Mean `= (0.2+0.5+1.0+0.3)/4 = 2.0/4 = 0.5`. `PPL = e^{0.5} = 1.649`.
**Answer:** **loss 0.5, PPL ≈ 1.65.**

## D6. KL-divergence penalty note
**Q.** A target distribution is one-hot on token A; the model assigns `[0.7, 0.2, 0.1]`. Is cross-entropy = `−ln(0.7)`? 
**Solution.** For a one-hot target, `KL(target‖model) = cross-entropy − entropy(target) = −ln(0.7) − 0 = 0.357`.
**Answer:** **Yes — cross-entropy = 0.357 nats** (entropy of a one-hot target is 0).

---

# PART E — POSITIONAL ENCODING (Unit I)

## E1. Compute PE for `pos = 1`, `d = 4`
**Q.** Using sinusoidal PE with `d = 4`, compute the PE vector at position `pos = 1` (i = 0, 1).
**Solution.** `i=0`: `2i/d = 0` → `10000⁰ = 1`.
`PE(1,0) = sin(1/1) = 0.8415`, `PE(1,1) = cos(1) = 0.5403`.
`i=1`: `2i/d = 0.5` → `10000^{0.5} = 100`.
`PE(1,2) = sin(1/100) = sin(0.01) = 0.0100`, `PE(1,3) = cos(0.01) = 0.99995`.
**Answer:** **PE(1) = [0.8415, 0.5403, 0.0100, 0.99995]**.

## E2. PE for `pos = 0`
**Q.** Compute `PE(0)` for `d = 4`.
**Solution.** `sin(0)=0`, `cos(0)=1` for every frequency; `PE(0,2)=sin(0)=0`, `PE(0,3)=cos(0)=1`.
**Answer:** **PE(0) = [0, 1, 0, 1]**.

## E3. Adding PE to a word embedding
**Q.** Word embedding `x = [0.2, −0.1, 0.5, 0.3]` at position 1. Form the encoder input.
**Solution.** `x + PE(1) = [0.2+0.8415, −0.1+0.5403, 0.5+0.0100, 0.3+0.99995]`.
**Answer:** **encoder input = [1.0415, 0.4403, 0.5100, 1.29995]**.

## E4. Why the frequencies differ (conceptual number check)
**Q.** At `pos = 100`, compare the smallest-frequency dimension (`i=0`, denominator 1) and largest (`i=1`, denominator 100).
**Solution.** `PE(100,0)=sin(100)=−0.5064`; `PE(100,2)=sin(100/100)=sin(1)=0.8415`.
**Answer:** different dimensions give different values at the same position → the pair (pos, i) is distinguishable. This is the "clock with many hands at different speeds".

## E5. Position count memory
**Q.** A 512-token sequence with `d_model = 768`. Size of the PE table for the whole sequence (one copy, 4-byte floats).
**Solution.** `512 × 768 × 4 = 1,572,864 bytes`.
**Answer:** **≈ 1.5 MiB** (and the same PE matrix is reused for every sequence).

---

# PART F — LAYER NORMALIZATION & FFN (Unit I)

## F1. Layer normalisation
**Q.** Normalise `x = [1, 2, 3, 4]` with `ε = 0`, `γ = 1`, `β = 0`.
**Solution.** `μ = 2.5`; variance `= ((1−2.5)²+(2−2.5)²+(3−2.5)²+(4−2.5)²)/4 = (2.25+0.25+0.25+2.25)/4 = 1.25`; `σ=√1.25=1.1180`.
Normalised: `[(1−2.5)/1.1180, (2−2.5)/1.1180, (3−2.5)/1.1180, (4−2.5)/1.1180]`.
**Answer:** **[−1.342, −0.447, 0.447, 1.342]** (mean 0, variance 1).

## F2. FFN parameter count
**Q.** Transformer FFN: `d_model = 512`, inner dimension `d_ff = 2048`. Count parameters (both linear layers, with bias).
**Solution.** Layer 1: `512 × 2048 + 2048 = 1,048,576 + 2048 = 1,050,624`.
Layer 2: `2048 × 512 + 512 = 1,048,576 + 512 = 1,049,088`.
Total `= 1,050,624 + 1,049,088 = 2,099,712`.
**Answer:** **≈ 2.10 M parameters per FFN** (usually 2×–4× the attention block).

## F3. Whole encoder-layer parameter estimate
**Q.** Using C7 (`W_O` 262,144) and roughly `W_Q,W_K,W_V` of 512×512 each (no bias), plus F2, estimate one encoder layer's parameters.
**Solution.** Attention projections: `4 × 262,144 = 1,048,576`. Add FFN 2,099,712 → total `= 3,148,288`.
**Answer:** **≈ 3.15 M params per layer**; ×12 layers ≈ **37.8 M** (BERT-Base order of magnitude).

---

# PART G — AUTOENCODERS & VAE (Unit I)

## G1. Bottleneck dimensions
**Q.** Encoder: `784 → 512 → 256 → 128 → 32`. Decoder mirrors back to 784. State the compression ratio.
**Solution.** `32/784 = 0.0408` → reduction to **4.08 %** of the input dimensions; compression factor `784/32 = 24.5×`.
**Answer:** **24.5× compression** (latent of 32 vs 784 input).

## G2. Parameter count of the encoder
**Q.** Count encoder parameters for `784→512→256→128→32` (bias included).
**Solution.**
`784×512 + 512 = 401,920`
`512×256 + 256 = 131,328`
`256×128 + 128 = 32,896`
`128×32 + 32 = 4,128`
Total `= 401,920 + 131,328 + 32,896 + 4,128 = 570,272`.
**Answer:** **570,272 encoder params.** (A mirror-image decoder adds another ≈571,024 → ≈1.14 M total.)

## G3. Reconstruction loss (MSE)
**Q.** Input `x = [1,0,1,0]`, reconstruction `x̂ = [0.8,0.1,0.9,0.2]`. Compute MSE.
**Solution.** Errors² = `(0.2)²=0.04`, `(0.1)²=0.01`, `(0.1)²=0.01`, `(0.2)²=0.04`; sum `=0.10`.
`MSE = 0.10/4 = 0.025`.
**Answer:** **MSE = 0.025.**

## G4. VAE KL divergence
**Q.** Encoder outputs `μ = [0, 1]`, `σ = [1, 0.5]`. Compute `KL = −½ Σ(1 + log σᵢ² − μᵢ² − σᵢ²)`.
**Solution.** `σ² = [1, 0.25]`.
i=1: `1 + ln 1 − 0² − 1 = 1 + 0 − 0 − 1 = 0`.
i=2: `1 + ln 0.25 − 1² − 0.25 = 1 − 1.3863 − 1 − 0.25 = −1.6363`.
Sum `= −1.6363`; `KL = −½(−1.6363) = 0.8182`.
**Answer:** **KL ≈ 0.818.**

## G5. Reparameterisation sampling
**Q.** VAE with `μ = 0.5`, `σ = 0.2`; sample `ε = 1.0` from `N(0,1)`. Give `z`.
**Solution.** `z = μ + σ·ε = 0.5 + 0.2×1.0 = 0.7`.
**Answer:** **z = 0.7** (this keeps sampling differentiable for backprop).

---

# PART H — GPT SCALE & TRAINING (Unit II)

## H1. GPT-2 scale-up
**Q.** GPT-1 had **117 M** parameters; GPT-2 (largest) has **1.5 B**. State the factor.
**Solution.** `1.5 × 10⁹ / 117 × 10⁶ = 12.82`.
**Answer:** **≈ 12.8× larger** (commonly quoted as "10×").

## H2. Layers × heads (attention patterns)
**Q.** GPT-2 uses 12 layers × 12 heads. How many attention patterns?
**Solution.** `12 × 12 = 144`.
**Answer:** **144 attention maps.**

## H3. Context-window budget
**Q.** GPT-2 has a 1024-token context. A prompt uses 900 tokens. How many tokens remain for the answer?
**Solution.** `1024 − 900 = 124`.
**Answer:** **124 tokens** of generation budget left.

## H4. Approximate parameter count from embedding + attention
**Q.** Estimate the embedding parameters for vocab 50,257, `d_model = 1600` (with weight tying to the output layer, count once).
**Solution.** `50,257 × 1600 = 80,411,200`.
**Answer:** **≈ 80.4 M** — the single biggest matrix; much of GPT-2's 1.5 B lives in the 48 transformer blocks.

---

# PART I — PROMPT ENGINEERING NUMERICS (Unit III)

## I1. Prompt token cost (zero-shot)
**Q.** A prompt has **11 tokens** (instruction + question). Price = **$0.01 per 1000 tokens**. Cost per call? Cost for **10,000** calls?
**Solution.** Per call `= (11/1000) × 0.01 = $0.00011`.
10,000 calls `= 10,000 × 0.00011 = $1.10`.
**Answer:** **$0.00011 per call; $1.10 for 10,000 calls.**

## I2. Few-shot token cost & scaling
**Q.** Add `k` few-shot examples of **40 tokens** each to a 31-token prompt. Compute prompt tokens and cost (at $0.01/1K) for `k = 0, 5, 50`.
**Solution.** `tokens = 31 + 40k`.
`k=0`: 31 → `$0.00031`
`k=5`: 231 → `$0.00231`
`k=50`: 2,031 → `$0.02031`
**Answer:** cost grows **linearly with k**; 50 examples cost **~65×** the zero-shot prompt — the "few-shot scales poorly with context" drawback.

## I3. Context-window overflow
**Q.** Context = 4096 tokens; 30 examples × 100 tokens each. Are the examples + a 200-token question within budget?
**Solution.** Examples `= 3000`; with the 200-token question total `= 3200 ≤ 4096`. Remaining `= 896`.
If examples grew to 45: `4500 + 200 = 4700 > 4096` → **overflow**; must drop examples.
**Answer:** **30 examples fit (3200/4096); 45 do not.**

## I4. Self-consistency majority vote
**Q.** Each CoT sample is correct with `p = 0.6`, independent. With `n = 5` samples and majority rule (≥3 correct), find the success probability.
**Solution.** `P = C(5,3)p³(1−p)² + C(5,4)p⁴(1−p) + C(5,5)p⁵`
`= 10(0.216)(0.16) + 5(0.1296)(0.4) + 0.07776`
`= 0.3456 + 0.2592 + 0.07776 = 0.68256`.
**Answer:** **≈ 68.3 %** (vs 60 % for a single sample). Self-consistency prices accuracy for **n× the inference tokens**.

## I5. Cost of self-consistency
**Q.** Single CoT answer costs 300 tokens. Self-consistency with `n = 5` — token cost and multiplier?
**Solution.** `5 × 300 = 1500` tokens → **5×** cost.
**Answer:** **1500 tokens; 5× multiplier.**

## I6. CoT accuracy gain
**Q.** Arithmetic accuracy rises from **55 %** to **65 %** with CoT. Give the absolute and relative improvement.
**Solution.** Absolute `= 65 − 55 = 10` percentage points. Relative `= (65−55)/55 = 18.2 %`.
**Answer:** **+10 pp, +18.2 % relative.**

## I7. Tree-of-Thoughts on Game of 24
**Q.** GPT-4 + CoT solves **4 %**; GPT-4 + ToT solves **74 %**. Find the absolute gain, multiple, and relative gain.
**Solution.** Absolute `= 70` pp. Multiple `= 74/4 = 18.5×`. Relative `= (74−4)/4 = 1750 %`.
**Answer:** **+70 pp, 18.5×, +1750 %.**

## I8. Example-distribution bias
**Q.** A classifier prompt has 10 negative and 2 positive examples. If the model simply copies the example distribution, what base rate does it infer for "negative"?
**Solution.** `10/(10+2) = 0.833`.
**Answer:** **≈ 83.3 % "negative"** — the anchoring/oversampling pitfall; balanced examples (e.g., 6/6) fix it.

## I9. Token-efficiency comparison
**Q.** Two prompts encode the same content. Prompt A: 480 tokens; Prompt B (subword-optimised): 320 tokens. Percentage saving and cost saving at $0.01/1K for 1 M calls?
**Solution.** Saving `= (480−320)/480 = 33.3 %`. Cost A `= 1,000,000 × 480/1000 × 0.01 = $4,800`; Cost B `= $3,200`.
**Answer:** **33.3 % fewer tokens; $1,600 saved per 1 M calls.**

## I10. Temperature / sampling (probability split)
**Q.** Logits `[2.0, 0.5]` at `T = 1`. Compute probabilities; then at `T = 0.5`.
**Solution.**
`T=1`: `e²=7.389`, `e^{0.5}=1.649`; sum `=9.038`; `p=[0.817, 0.183]`.
`T=0.5`: divide logits by 0.5 → `[4.0, 1.0]`; `e⁴=54.60`, `e¹=2.718`; sum `=57.32`; `p=[0.953, 0.047]`.
**Answer:** **Lower temperature sharpens the distribution** ([0.817,0.183] → [0.953,0.047]); `T→0` ≈ greedy.

---

# PART J — APPENDIX: RETRIEVAL-AUGMENTED GENERATION NUMERICS (Unit V)

## J1. Retrieval top-k selection
**Q.** Query embedding has cosine scores `[0.91, 0.88, 0.42, 0.85, 0.30]` against 5 chunks. List top-3.
**Solution.** Sorted: `0.91 > 0.88 > 0.85 > 0.42 > 0.30`.
**Answer:** **chunks 1, 2, 4** (scores 0.91, 0.88, 0.85).

## J2. RAG prompt budget
**Q.** Context window 8192. Retrieved context = 5 chunks × 400 tokens = 2000; instruction 50; question 30. Tokens free for the answer?
**Solution.** Used `= 2000 + 50 + 30 = 2080`; free `= 8192 − 2080 = 6112`.
**Answer:** **6112 tokens.**

## J3. Embedding dimension vs index size
**Q.** 1 M chunks, dim 768, 4-byte floats. Flat index size, and the same at dim 1536.
**Solution.** `10⁶ × 768 × 4 = 3.072×10⁹ bytes ≈ 3.07 GB`. At 1536: `≈ 6.14 GB`.
**Answer:** **≈ 3.07 GB (768-d); ≈ 6.14 GB (1536-d)** — doubling dimension doubles the index.

---

## Final quick-answer key
| Q | Answer | Q | Answer |
|---|---|---|---|
| A1 | 1 / 7 / 2 / 7 | E1 | [0.8415,0.5403,0.0100,0.99995] |
| A3 | 80,411,200 | F1 | [−1.342,−0.447,0.447,1.342] |
| A6 | 4 windows | G3 | 0.025 |
| B1 | 0.478 | G4 | 0.818 |
| B7 | 22 chunks | H2 | 144 |
| C2 | [0.533,0.168,0.299] | I4 | 68.3 % |
| C4 | [1.5,0.2] | I7 | +70 pp / 18.5× |
| D1 | [0.659,0.242,0.099] | I9 | 33.3 % |
| D4 | 1.52 | J2 | 6112 tokens |

---

*Sources: syllabus.txt (Units I–III, V); Large Language Models ConceptsAtkinson.md (Fig. 2.38, Table 2.1, §2.11 PE, BERT dims); Hands-On_Large_Language_Models.md (§4 embeddings/cosine, §1 tokenization, perplexity); GenAI_U1.md and Unit-2 PEGENAI.md (Ramya slides — attention matmul, PE d=4, sliding windows, 784→32 encoder).*
