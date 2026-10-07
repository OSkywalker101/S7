Prompt Engineering for GenAI
23CI72
| Dr.   | A N | Ramya      | Shree  |
| ----- | --- | ---------- | ------ |
| Dept. | of  | CSE(AI&ML) |        |

What is Generative AI?
• Generative Artificial Intelligence (Generative AI) is a branch
of artificial intelligence that focuses on creating new content
| such          | as  | text,   | images,   |            | audio, |          | video,  |          | computer   |          | programs, |           |      |     |
| ------------- | --- | ------- | --------- | ---------- | ------ | -------- | ------- | -------- | ---------- | -------- | --------- | --------- | ---- | --- |
| designs,      |     | and     | synthetic |            | data   |          | by      | learning |            | patterns |           |           | from |     |
| existing      |     | data.   |           |            |        |          |         |          |            |          |           |           |      |     |
| • Traditional |     | AI      | is        | generally  |        | designed |         |          | to         | analyze, |           | classify, |      |     |
| predict,      |     | or make |           | decisions, |        |          | whereas |          | Generative |          |           | AI        | can  |     |
| produce       |     | new     | outputs   |            | that   | resemble |         |          | the        | data     | on        | which     |      | it  |
| was trained.  |     |         |           |            |        |          |         |          |            |          |           |           |      |     |

Example
• A traditional AI model may determine whether an email is spam or
not spam.
• A Generative AI model can write a new email based on a user's
instructions.
• A traditional computer vision model may classify an image as a cat.
• A Generative AI model can create a new image of a cat that did not
previously exist

Case Study
Generative AI learns the underlying patterns and relationships in a dataset.
Suppose a model is trained using thousands of images of handwritten digits.
It learns characteristics such as:
• shapes
• curves
• strokes
• positions
• relationships between pixels
After learning these patterns, the model can generate a new handwritten
digit.

Generative AI Representation
Training Data
Learning Patterns
Generative Model
New Content

| • A           | discriminative |             | model  |            | approximately |          | learns: |            |            |      |
| ------------- | -------------- | ----------- | ------ | ---------- | ------------- | -------- | ------- | ---------- | ---------- | ---- |
| • P(y∣x)      | where          | x           | is the | input      | and           | y is the | class   | or target. |            |      |
| • A           | generative     |             | model  |            | attempts      | to       | learn   | the        | underlying | data |
| distribution, |                | represented |        |            | as:           |          |         |            |            |      |
| • P(x)        | or, in         | conditional |        | generation |               | P(x∣y)   |         |            |            |      |

Generative vs. Discriminative AI
| Aspect       | Discriminative            | AI  | Generative | AI         |
| ------------ | ------------------------- | --- | ---------- | ---------- |
| Main purpose | Classification/prediction |     | Content    | generation |
Learns Decision boundary or relationship Data distribution/patterns
| Output  | Label/value    |     | New content |            |
| ------- | -------------- | --- | ----------- | ---------- |
| Example | Spam detection |     | Email       | generation |
Image application Cat vs. dog classification Creating a new cat image
Common models Logistic Regression, SVM, CNN GAN, VAE, Transformer, Diffusion

Traditional AI to Generative AI
The transition from traditional AI to Generative AI represents a shift from
"understanding and predicting existing information" toward "creating new
information."
Traditional AI
Traditional AI generally receives an input and produces a decision, classification,
prediction, or recommendation.
For example:
X→ AI Model → Y
Consider a disease-detection system:
Disease
Medical Image →CNN →
No Disease
​ The model does not normally create a new medical image.
It predicts a class.

Generative AI
Generative AI learns patterns in the training data and
Text Prompt
uses
↓
those patterns to generate new content.
Generative Model
| X→ Generative |     | Model →New | Content  |     |
| ------------- | --- | ---------- | -------- | --- |
↓
For example:
New Cat Image
| • Prompt→ LLM→ Generated |                     |     | Text              |       |
| ------------------------ | ------------------- | --- | ----------------- | ----- |
| • Text                   | Prompt → Generative |     | Model → Generated | Image |
The generated image may not have existed in the training dataset

History of Generative AI

Generative Deep Learning
Deep learning was used not only to recognize data but also to generate new
| data. | Important |     | generative | architectures | included: |
| ----- | --------- | --- | ---------- | ------------- | --------- |
Autoencoders: Autoencoders learn compressed representations of data.
x→Encoder→z→Decoder→x^
where:
| • x  | = original      | input          |        |     |     |
| ---- | --------------- | -------------- | ------ | --- | --- |
| • z  | = latent        | representation |        |     |     |
| • x^ | = reconstructed |                | output |     |     |
• Variational Autoencoders (VAEs) extended this idea to probabilistic
generation.

Autoencoders
An autoencoder is a type of neural network that is trained to encode input data into a compressed
representation (encoding) and then decode it back to a reconstruction that resembles the original
input.
Structure of Autoencoders
1️. Encoder: Compresses the input into a lower-dimensional space (latent space)
2️. Bottleneck/Latent Space: The compressed, encoded representation (most informative features).
3️ Decoder: Reconstructs the original input from the latent space.
The network is trained to minimize reconstruction error.
̂̂
Input (x) → Encoder → Latent Space (z) → Decoder → Reconstructed Input (x̂̂)

Why Autoencoders?
•
| Dimensionality |     |     | Reduction: |          |     | They   | can      | learn |            | a compact  |     |
| -------------- | --- | --- | ---------- | -------- | --- | ------ | -------- | ----- | ---------- | ---------- | --- |
| representation |     | of  | data       | (similar |     | to PCA | but more |       | flexible). |            |     |
| • Denoising:   |     | Can |            | remove   |     | noise  | from     |       | data       | (denoising |     |
autoencoders).
| • Anomaly      | Detection: |       |     |     | If         | trained | on  | normal |     | data, | high |
| -------------- | ---------- | ----- | --- | --- | ---------- | ------- | --- | ------ | --- | ----- | ---- |
| reconstruction |            | error |     | for | anomalies. |         |     |        |     |       |      |
• Pretraining: Used to pretrain deep networks before fine-tuning.

Representation Learning
• Noisy or inconsistent data hurts ML models with shallow understanding
• Solution: let the machine learn an abstract representation itself
• Turns high-dimensional data (e.g., text) into low-dimensional form
Benefits Two things to remove
• Easier pattern & anomaly detection • Variance: output sensitivity; models must be
resilient
• Better grasp of data behavior
• Entanglement: embeddings correlated with
• Filters noise – helps supervised learning
each other, hard to decipher

Information Bottleneck & Latent Variables
Information Bottleneck Latent Variables (z)
• Compress the information flowing through the • Hidden variables that shape the data
network distribution
• Reduces dimensionality and complexity • Much lower dimension than the input →
compressed form
• Irrelevant noise dropped; only features key to
general concepts remain • Enable a generative model
Generate: z ~ p(z) → x ~ p(x | z)
Sample a latent z, then draw a new observation x from the conditional distribution

Autoencoder Architecture
Encoder Latent Space Decoder
Stacked layers, fewer neurons Minimal "bottleneck" holding the Decompresses and reconstructs;
→ →
each; compresses input compressed code compared with true values
Loss = Reconstruction loss L(x, x̂̂) + Regularizer
Sensitive enough to reconstruct accurately, yet not so sensitive that it memorizes or overfits. A scaling parameter
tunes the trade-off.

Types of Autoencoders
Incomplete Sparse
• Limits the number of hidden nodes to restrict • Limits active neurons via a sparsity penalty in
information flow the loss
• Penalized by reconstruction error • Different inputs activate different nodes
• Nonlinear generalization of PCA – learns a • Curbs memorization, keeps feature extraction
curved surface, not just a hyperplane
• Penalties: L1 regularization or KL divergence

Types of Autoencoders
Denoising Variational (VAE)
• Input corrupted with Gaussian noise; clean data • Generative; latent space is continuous → easy
is the target sampling & interpolation
• Learns a vector field pulling inputs to a low- • Encoder outputs mean μ and std-dev σ; the
dimensional region code is sampled from that Gaussian
• Works well near training data; error can be large • KL loss pushes μ→0, σ→1️, spreading codes
far from it evenly around the origin

VAE: KL Divergence Loss
KL loss = Σ ( σi² + μi² − log(σi) − 1 ), i = 1 … n
Xi ~ N(μi, σi²) vs. standard normal N(0, 1)
• KL divergence measures how different two probability distributions are
• Sum of KL divergences between each Xi and the standard normal
• Minimized when μi = 0 and σi = 1️
• Pushes encodings evenly around the latent-space center; penalizes clustering far from the
origin

Generative process
• z: hidden latent variable, far lower-dimensional than x
z ~ p(z)
• p(z): distribution we sample z from
x ~ p(x | z)
• p(x | z): conditional distribution of data given z
• Sample z first, then draw a new x
Autoencoder loss
• L(x, x)̂ : reconstruction loss – input x vs. output x;̂ keeps the
model responsive to inputs
Loss = L(x, x̂) + regularizer
• Regularizer: discourages memorization / overfitting
• A scaling parameter tunes the trade-off

VAE encoding
• Encoder outputs vectors μ (means) and σ (std. deviations), each
of size n
Xi ~ N(μi, σi²)
• μi centers the encoding; σi sets how far it may deviate
• Code is sampled from this Gaussian, then passed to the
decoder
KL divergence loss
• Measures distance of each N(μi, σi²) from standard normal N(0, 1️)
KL = Σ ( σi² + μi² − log σi − 1 )
• Minimum at μi = 0, σi = 1️
i = 1 … n
• Spreads encodings evenly around the latent-space center

Types of Autoencoders
•
| Vanilla       | Autoencoder: |              |       | Simple   |         | encoder-decoder |     |               | structure. |            |
| ------------- | ------------ | ------------ | ----- | -------- | ------- | --------------- | --- | ------------- | ---------- | ---------- |
| • Denoising   |              | Autoencoder: |       |          | Trained |                 | to  | remove        | noise.     |            |
| • Sparse      | Autoencoder: |              |       | Enforces |         | sparsity        |     | in hidden     |            | units.     |
| • Variational |              | Autoencoder  |       |          |         | (VAE):          |     | Probabilistic |            | framework, |
| generates     |              | new          | data. |          |         |                 |     |               |            |            |

| • Input: | Each |      | image | (28x28) |     | is  | flattened |     | into | a   |
| -------- | ---- | ---- | ----- | ------- | --- | --- | --------- | --- | ---- | --- |
| vector   | of   | size | 784.  |         |     |     |           |     |      |     |
•
| Encoder:      |      | Compresses   |         |            | from | 784     | →   | 3 dimensions. |     |     |
| ------------- | ---- | ------------ | ------- | ---------- | ---- | ------- | --- | ------------- | --- | --- |
| • Decoder:    |      | Reconstructs |         |            | back | to      | 784 | dimensions.   |     |     |
| • Loss:       | Mean |              | Squared | Error      |      | between |     | original      |     | and |
| reconstructed |      |              | input.  |            |      |         |     |               |     |     |
| • Training:   |      | Uses         | Adam    | optimizer. |      |         |     |               |     |     |

A simple fully connected (dense) autoencoder
• Encoder:Linear (784 → 256) + ReLULinear (256 → 64) + ReLU
• Decoder:Linear (64 → 256) + ReLULinear (256 → 784) + Sigmoid
(for pixel normalization to [0,1])
• Input: Flattened 28×28=784 vectors
• Output: Reconstructed flattened images

Undercomplete Autoencoder
| • An     | undercomplete |       |      |     | autoencoder |         |     | is designed |           | with   | a bottleneck |
| -------- | ------------- | ----- | ---- | --- | ----------- | ------- | --- | ----------- | --------- | ------ | ------------ |
| (latent) |               | layer | that | has | fewer       | neurons |     | than        | the input | layer. |              |
• This forces the model to learn compressed and essential features of
| the     | input           | data.   |                |     |        |       |         |     |         |     |        |
| ------- | --------------- | ------- | -------------- | --- | ------ | ----- | ------- | --- | ------- | --- | ------ |
| • Input | →               | Encoder |                | →   | Latent | Space | (small) | →   | Decoder | →   | Output |
| Goal:   | Minimize        |         | reconstruction |     |        | error |         |     |         |     |        |
| • X =   | Original        |         | input          |     |        |       |         |     |         |     |        |
| • 𝑋^    | = Reconstructed |         |                |     | output |       |         |     |         |     |        |

• The bottleneck in an undercomplete autoencoder is the central hidden
layer in the neural network that has a smaller number of neurons than the
| input | and output | layers. |
| ----- | ---------- | ------- |
• The bottleneck is the latent space representation that forces the model to
| compress | the input | data. |
| -------- | --------- | ----- |
• This compression makes the network learn only the most important
features needed to reconstruct the input, acting like an information filter.

• Forces the network to learn useful low-dimensional features.
• Acts as a dimensionality reduction technique, similar to PCA.
• Common in tasks like denoising, compression, or anomaly detection.
| • Simple   | and effective | for feature      | learning. |
| ---------- | ------------- | ---------------- | --------- |
| • Prevents | overfitting   | by architectural | design.   |
• Might not capture all important structures if the bottleneck is too
small.

Structure of an Undercomplete Autoencoder
• Input Layer → 100 features
• Hidden Layers → 64 → 32 → **Bottleneck (10 neurons)**
• Decoder Layers → 32 → 64
• Output Layer → 100 features (same as input)

• If your input is a 28x28 image (784 features), and the bottleneck layer
is of size 32, the model learns to represent each image with just 32
| numbers    | that | capture | the most | relevant |            | information. |
| ---------- | ---- | ------- | -------- | -------- | ---------- | ------------ |
| • Encoder: | 784  | → 128   | → 64 →   | 32 ←     | Bottleneck |              |
| • Decoder: | 32   | → 64 →  | 128 →    | 784      |            |              |

Layer Size
• The layer size and depth of an autoencoder's architecture are critical for
how well it learns useful representations and reconstructs input data.
• They directly influence the capacity, compression, and generalization ability
| of  | the model. |     |     |     |     |     |     |
| --- | ---------- | --- | --- | --- | --- | --- | --- |
• Layer size refers to the number of neurons (units) in each layer of the
autoencoder.
| Input  | Layer:  | Matches      | the number |        | of features | in the | data.    |
| ------ | ------- | ------------ | ---------- | ------ | ----------- | ------ | -------- |
| Hidden | Layers: | Intermediate |            | layers | in encoder  | and    | decoder. |
Latent Layer (Bottleneck): Central compressed representation (latent code).
The size usually decreases toward the bottleneck and then increases
| symmetrically |     | in the | decoder. |     |     |     |     |
| ------------- | --- | ------ | -------- | --- | --- | --- | --- |

Layer Size (for 784-dim input)
Input 784
Hidden (1) 256
Hidden (2) 64
Latent Code 16 or 32
Decoder (1) 64
Decoder (2) 256
Output 784

Depth
| Depth      |              | refers       |              | to the |        | number  |          |         | of   | layers |           | in the      | network.  |
| ---------- | ------------ | ------------ | ------------ | ------ | ------ | ------- | -------- | ------- | ---- | ------ | --------- | ----------- | --------- |
| Shallow    |              | Autoencoder: |              |        |        |         |          |         |      |        |           |             |           |
| One        | hidden       |              | layer        |        | in     | encoder |          |         | and  | One    |           | in decoder. |           |
| Fast       | to           | train        | but          |        | may    | miss    |          | complex |      |        | patterns. |             |           |
| Deep       | Autoencoder: |              |              |        |        |         |          |         |      |        |           |             |           |
| • Multiple |              |              | hidden       |        | layers |         | in       | encoder |      |        | and       | decoder.    |           |
| • Can      | learn        |              | hierarchical |        |        |         | and      |         | more |        | abstract  |             | features. |
| • Needs    |              | more         |              | data   | and    |         | training |         |      | time.  |           |             |           |

Sparsity
• A sparse autoencoder is simply an autoencoder whose training criterion
| involves | a sparsity | penalty. |     |     |     |
| -------- | ---------- | -------- | --- | --- | --- |
• The intuition behind this method is that, for example, if a man claims to be
an expert in mathematics, computer science, psychology, and classical
music, he might be just learning some quite shallow knowledge in these
subjects. If he only claims to be devoted to mathematics, we would like to
| anticipate | some | useful | insights | from | him. |
| ---------- | ---- | ------ | -------- | ---- | ---- |
• It’s the same for autoencoders we’re training — fewer nodes activating
while still keeping its performance would guarantee that the autoencoder
is actually learning latent representations instead of redundant
| information | in  | our input | data. |     |     |
| ----------- | --- | --------- | ----- | --- | --- |

| • Consider     |     | that    |                   | we have       |     | two   | loss  |     |
| -------------- | --- | ------- | ----------------- | ------------- | --- | ----- | ----- | --- |
| functions      |     |         | L1                | and           | L2  | which |       |     |
| represent      |     |         | L1 regularization |               |     | and   |       | L2  |
| regularization |     |         |                   | respectively. |     |       |       |     |
| Gradient       |     | descent |                   | is always     |     | used  |       | in  |
| optimizing     |     | neural  |                   | networks.     |     | If we | plot  |     |
| these          | two |         | loss              | functions     |     | and   | their |     |
| derivatives,   |     |         | it looks          | like this:    |     |       |       |     |

• We can notice that for L1 regularization, the gradient is either 1 or -1
except when w=0, which means that L1 regularization will always
move w towards zero with same step size (1 or -1) regardless of the
value of w.
• And when w=0, the gradient becomes zero and no update will be
made anymore. However, for L2 regularization things are different.
• L2 regularization will also move w towards zero but the step size
becomes smaller and smaller which means that w will never reach
zero.
This is the intuition behind L1 regularization’s sparsity.

Shallow Autoencoder
• Input (784) → Hidden (128) → Latent (32) → Hidden (128) → Output
(784)
Deep Autoencoder
• Input (784) → 512 → 256 → 128 → Latent (32) → 128 → 256 → 512
→ Output (784)

Regularized Autoencoders
• Instead of relying on bottleneck size, regularized autoencoders
introduce constraints or penalties to enforce meaningful feature
learning
Sparse Autoencoder
• Adds a sparsity constraint (L1 penalty) on activations in the hidden
layers.
• Only a few neurons fire per input → useful for sparse representation.

Denoising Autoencoder
A Denoising Autoencoder is a type of regularized Autoencoder that
learns to reconstruct the original clean input from a corrupted (noisy)
| version      | of the | input. |       |          |        |     |     |
| ------------ | ------ | ------ | ----- | -------- | ------ | --- | --- |
| • Real-world |        | data   | often | contains | noise. |     |     |
• Denoising autoencoders help learn robust representations that
capture the underlying structure of the data rather than memorizing
| the noise. |     |             |     |           |      |         |          |
| ---------- | --- | ----------- | --- | --------- | ---- | ------- | -------- |
| • Trained  | to  | reconstruct |     | the input | from | a noisy | version. |
• Learns robust features that capture underlying structure, not noise.
Training with squared error criterion

• Noise regularization involves corrupting the input data (adding
| Gaussian    |        | noise | or masking) |            | and    | training |          | the | autoencoder | to  |
| ----------- | ------ | ----- | ----------- | ---------- | ------ | -------- | -------- | --- | ----------- | --- |
| reconstruct |        | the   | original    | clean      | input. |          |          |     |             |     |
| • Original  | Image: |       | Electron    | microscope |        | image    | of brain |     | tissue.     |     |
• Mask: A grayscale or color image where white pixels represent cells,
| black | represents |     | background. |     |     |     |     |     |     |     |
| ----- | ---------- | --- | ----------- | --- | --- | --- | --- | --- | --- | --- |

• Instead of training the autoencoder with 𝑋 we corrupt the input 𝑋 to get a noisy
version 𝑋~, and train the model to map:𝑋~→𝑋.
• The latent code (latent representation, embedding, or bottleneck features) is the
compressed vector produced by the encoder part of an Autoencoder.
Clean Input (X) → Add Noise → Noisy Input (𝑋~)
↓ ↓
Encoder Encoder
↓ ↓
Latent Code Latent Code
↓ ↓
Decoder Decoder
↓ ↓
Reconstructed X̂ (output) ← compare with original X

• The encoder compresses the input data (an image ).
• The latent code is the output of the encoder, representing the most
important features of the input.
• The decoder then tries to reconstruct the input from this latent code.
• Encoder: 784 → 1️2️8 → 64 → **3️2️** ← latent code
• For a 28×28 image (784 features), encoder outputs a latent code of 32
features. So each image is now represented as a vector of length 32.
• The latent code is the core representation learned by an autoencoder.
It's compact, meaningful, and useful for many tasks.

• Loss Function:The objective is to minimize reconstruction error.
• Gaussian noise: Add small random values to pixels.
• Masking noise: Randomly set some input values to zero.
• Salt-and-pepper noise: Randomly set some pixels to 0 or 1.
Denoising autoencoder (DAE) is an autoencoder that receives a corrupted
data point as input and is trained to predict the original, uncorrupted data
point as its output.

import torch # Add Gaussian noise
import torch.nn as nn def add_noise(inputs, noise_factor=0.3):
import torch.nn.functional as F noisy = inputs + noise_factor * torch.randn_like(inputs)
return torch.clip(noisy, 0., 1.)
class DenoisingAutoencoder(nn.Module):
def __init__(self):
super().__init__()
self.encoder = nn.Sequential(
nn.Linear(784, 256),
nn.ReLU(),
nn.Linear(256, 64)
)
self.decoder = nn.Sequential(
nn.Linear(64, 256),
nn.ReLU(),
nn.Linear(256, 784),
nn.Sigmoid()
)
def forward(self, x):
encoded = self.encoder(x)
decoded = self.decoder(encoded)
return decoded

Deterministic encoder
A deterministic encoder is a function fθ(x) that maps input data x to a latent
vector z without any randomness:
z=fθ(x)
θ - parameters (weights) of the encoder neural network.
Encoder compresses input 𝑥 to a latent vector 𝑧
Decoder reconstructs 𝑥 from 𝑧
There is no sampling, no probability distribution, and no noise involved in
this encoding process.

Stochastic encoder
A stochastic encoder maps input data x to a distribution over latent
variables z, instead of a single point.
• Deterministic Encoder: z=f(x)
• Stochastic Encoder: z∼q(z∣x)
Even if you input the same image multiple times, the latent vector 𝑧
will be different each time, because it's sampled from a distribution.
A latent vector is a numerical representation of input data in a compressed,
abstract form

• z: the latent vector
• 𝜇(𝑥): the mean of the distribution for a given input 𝑥
• 𝜎2(𝑥): the variance for that input
• 𝑁: normal (Gaussian) distribution
So, rather than encoding an input 𝑥 into a single deterministic latent
vector, encode it into a probability distribution, and sample 𝑧 from that
distribution.

Latent vector
A latent vector (latent representation) is a compressed,
abstract numerical representation of the original input data,
capturing its essential features while discarding unnecessary
details.
It's often used in autoencoders, where it acts as an input to
generate new data samples or compress existing ones.
Compression: Latent vectors reduce the dimensionality of data,
making it easier to work with and potentially removing noise.
Abstraction: They capture high-level features and patterns, allowing
models to generate or reconstruct data based on these underlying
characteristics.

Generative Models: In Generative Adversarial Networks (GANs), a latent vector is fed
| into the | generator |     |     | to produce |     | new | data | instances. |     |     |     |     |     |     |     |
| -------- | --------- | --- | --- | ---------- | --- | --- | ---- | ---------- | --- | --- | --- | --- | --- | --- | --- |
Autoencoders: In autoencoders, the latent vector represents the compressed form of
| the input | data | after |     | it has | been |     | processed |     | by  | the | encoder. |     |     |     |     |
| --------- | ---- | ----- | --- | ------ | ---- | --- | --------- | --- | --- | --- | -------- | --- | --- | --- | --- |
The decoder then reconstructs the data from this latent representation.
Latent Space: The space where these latent vectors reside is called the latent space.
Example: Imagine you have a dataset of faces.
A latent vector could represent the underlying features of those faces (shape of the nose, the
| curve | of the | lips, | etc.) | in  | a compact |     | numerical |     |     | form. |     |     |     |     |     |
| ----- | ------ | ----- | ----- | --- | --------- | --- | --------- | --- | --- | ----- | --- | --- | --- | --- | --- |
This latent vector can then be used to generate new, unique faces that share similar
characteristics.
| Encoder      |     | and |         | decoder |      |     | are   | both |     | feed |          | forward | networks, | they | can |
| ------------ | --- | --- | ------- | ------- | ---- | --- | ----- | ---- | --- | ---- | -------- | ------- | --------- | ---- | --- |
| individually |     |     | benefit |         | from |     | depth |      | or  | as   | a whole. |         |           |      |     |

Encoding: The process of converting data into a latent vector.
Decoding: The process of reconstructing data from a latent vector.
Dimensionality Reduction: The act of reducing the number of variables
needed to represent data.
Feature Extraction: Identifying and representing the most important
characteristics of data.

The latent vectors are a powerful tool for working with complex data, allowing for
efficient representation, generation, and manipulation of data in various machine
learning applications.
Mainly used in:
• Dimensionality reduction-makes computation faster.
• Feature extraction.
• Data generation (decoder can reconstruct images from latent space)

Predictive Sparse Decomposition
Predictive Sparse Decomposition (PSD) is a feature learning method that
extends sparse coding by introducing a predictive model that can quickly infer
sparse codes for new data, without the need to solve a costly optimization
problem every time. Training Proceeds by minimizing
x Input data
Decoder output
g(x)
(reconstructed input)
f(x) Encoder output (latent code)
h Target latent representation
Possibly an intermediate or
h1
first hidden layer (regularized)
Regularization hyper
λ lambda, γ gamma
parameters (weights)

Reconstruction Loss:
•∥x−g(x)∥2: Measures how well the autoencoder reconstructs input x.
•Lower is better.
Regularization Term:
𝜆∥ℎ1∥Penalizes large weights or activations in layer ℎ1
Encourages sparsity or smoothness depending on norm used (L2 or L1).
Latent Alignment Term: Encourages the learned latent representation 𝑓(𝑥) to be close
to some desired representation ℎ.

• During training, h is controlled by the optimization algorithm.
• The training alternates between minimization with respect to h and
| minimization |             | respect |              | to the | model   | parameters. |        |           |
| ------------ | ----------- | ------- | ------------ | ------ | ------- | ----------- | ------ | --------- |
| • The        | interactive |         | optimization |        | is used | only        | during | training. |
• The parametric encoder f is used to compute the learned feature
| when | the | model | is deployed. |     |     |     |     |     |
| ---- | --- | ----- | ------------ | --- | --- | --- | --- | --- |
• PSD models maybe stacked and used to initialize a deep network to
| be  | trained | with | another | criterion. |     |     |     |     |
| --- | ------- | ---- | ------- | ---------- | --- | --- | --- | --- |

Applications
Dimensionality Reduction: Feature extraction-Reduce high-dimensional
| data | (like | images) |     | to  | a compact |     | latent | vector. |     |
| ---- | ----- | ------- | --- | --- | --------- | --- | ------ | ------- | --- |
Denoising: Denoising autoencoders-Remove noise from images, audio, or
| signals | by  | learning |     | clean |     | representations. |     |     |     |
| ------- | --- | -------- | --- | ----- | --- | ---------------- | --- | --- | --- |
Anomaly Detection: Fraud, intrusion, defect detection, Train on normal
| data | → large |     | reconstruction |     |     | error | indicates |     | anomalies. |
| ---- | ------- | --- | -------------- | --- | --- | ----- | --------- | --- | ---------- |
Data Compression: Use encoder-decoder structure for compressing and
| reconstructing |     |     | data. |     |     |     |     |     |     |
| -------------- | --- | --- | ----- | --- | --- | --- | --- | --- | --- |
Pretraining: Weight initialization-Use unsupervised pretraining to initialize
| deep | networks, |     | especially |     |     | useful | in low-data |     | settings. |
| ---- | --------- | --- | ---------- | --- | --- | ------ | ----------- | --- | --------- |

Generative Adversarial Network (GAN)
• GANs belong to the formidable realm of neural networks and are employed for
generative modeling through unsupervised learning, as highlighted by key
references such as Bengio (2014) and Babcock and Bali (2021).
• At its core, a GAN consists of a dynamic interplay between two neural network
models engaged in a competitive dance, capable of comprehending, capturing,
| and | replicating | variations | within | a dataset. |     |
| --- | ----------- | ---------- | ------ | ---------- | --- |
• These two networks assume the roles of the generator and the discriminator,
| each | with its | own unique | function. |     |     |
| ---- | -------- | ---------- | --------- | --- | --- |
• The generator, typically implemented as a CNN, takes random noise as input and
| crafts | an image | that aligns | with | the desired | domain. |
| ------ | -------- | ----------- | ---- | ----------- | ------- |
• In contrast, the discriminator’s role is to discern whether the generated data,
such as an image, is authentic or not. In other words, it evaluates whether the
output genuinely belongs to the intended distribution or not.

• This framework not only facilitates the generation of synthetic data but
also enhances the performance of learning models as a data augmentation
| technique, |     | reducing | generalization |     | errors. |     |
| ---------- | --- | -------- | -------------- | --- | ------- | --- |
• It achieves this by generating new, artificial yet plausible examples from the
| input | problem | domain |     | on which | the model | is trained. |
| ----- | ------- | ------ | --- | -------- | --------- | ----------- |
•
In theory, GANs operate within a framework rooted in game theory.
• Within this frame work, a generating neural network engages in a strategic
| competition |     | with | an adversarial |     | network. |     |
| ----------- | --- | ---- | -------------- | --- | -------- | --- |
• The role of the generator network is to produce samples directly, while its
counterpart, the discriminative network, strives to distinguish between
samples originating from the training data and those generated by the
generator.

Generative Adversarial Networks (GANs)
• Neural networks for generative modeling via unsupervised learning
• Two networks compete: a generator and a discriminator
• Game-theory framework: generator creates samples, discriminator tells real from fake
• Also used for data augmentation, reducing generalization error
Random noise Generator Generated sample Discriminator Real or Fake?
|     | →   |     | →   |      | →   |            | →   |              |
| --- | --- | --- | --- | ---- | --- | ---------- | --- | ------------ |
| z   |     | CNN |     | fake |     | classifier |     | binary label |
Real samples from the training data also feed the discriminator

GAN Components
Generator (generative model) Discriminator (discriminative model)
• Input: random fixed-length vector from a • Input: real or generated example
Gaussian distribution
• Predicts binary label: real or fake
• Output: a sample in the problem domain
• A standard classification model
• Vector space = compressed representation with
• Role ends after training; generator layers can be
latent variables
reused for transfer learning
• The model we keep after training

GANs vs Autoencoders
Autoencoders GANs
• Results often closely aligned with the training • Generate high-quality, realistic content
data
• Adversarial setup teaches the generator to
• Learn compressed representations (encoder → mimic training patterns
latent → decoder)
• Capture the underlying distribution of the
original dataset
• Suited to text and image generation

• GANs introduced an adversarial approach involving two neural
| networks: | Generator | and Discriminator |     |     |     |
| --------- | --------- | ----------------- | --- | --- | --- |
• The generator creates synthetic data, while the discriminator
| attempts | to distinguish | real data | from | generated | data. |
| -------- | -------------- | --------- | ---- | --------- | ----- |

Random Noise
↓
Generator
↓
Generated Data
↓
Discriminator
↙ ↘
Real Fake

Transformers
• Transformers rely on four major components working together: self-
attention, multi-head attention, positional encoding, and feed-
| forward | networks. |     |
| ------- | --------- | --- |
• Together, these components allow modern AI systems to understand
relationships, context, meaning, and structure far more effectively
| than | older | AI architectures. |
| ---- | ----- | ----------------- |

Self-attention
• The most important idea in the Transformer architecture is self-
attention.
• Self-attention allows every word in a sentence to look at every other
word and decide which ones matter most. That is the heart of the
| attention |         | mechanism. |       |     |     |
| --------- | ------- | ---------- | ----- | --- | --- |
| "The      | cat sat | on the     | mat." |     |     |
• When processing the word "cat," the model does not look only at
| nearby | words.    |            |     |          |                 |
| ------ | --------- | ---------- | --- | -------- | --------------- |
| • It   | evaluates | the entire |     | sentence | simultaneously. |

Transformer asks three questions for every word.
• Query: "What information am I looking for?"
| • Key:   | "What kind of information do I offer?" |     |
| -------- | -------------------------------------- | --- |
| • Value: | "What actual information do I carry?"  |     |
• A matchmaking system between words.
| • For | the word | "cat," |
| ----- | -------- | ------ |
• the Query asks what relationships matter, the model compares the
query against the Keys of every other word, and strong matches
| receive | closer | attention. |
| ------- | ------ | ---------- |

"cat" might strongly attend to "sat" (action relationship) and
"mat" (location relationship), and weakly attend to smaller
function words like "the" and "on," which still matter but less
strongly.
The result is that the model creates a richer understanding of
"cat," not as an isolated word, but as "the cat that sat on the
mat."
Self-attention solved several major problems at once:
• Every word can directly connect to every other word
• Long-distance relationships are preserved
• Processing happens in parallel
• Context understanding improves dramatically.

Multi-head attention
• Instead of using one attention system, Transformers run multiple attention
| mechanisms |            | simultaneously. |        |     |     |
| ---------- | ---------- | --------------- | ------ | --- | --- |
| • These    | are called | attention       | heads. |     |     |
• You can think of them as multiple specialists analyzing the same sentence
| from | different | perspectives. |     |     |     |
| ---- | --------- | ------------- | --- | --- | --- |
• One head might focus on grammar: subjects, verbs, and sentence
structure.
• Another focuses on semantic meaning: "cat" as an animal, "mat" as an
object.
• Another focuses on position: which words appear earlier or later.
| • Another | focuses | on references: |     | "it" referring | to "cat." |
| --------- | ------- | -------------- | --- | -------------- | --------- |

Positional encoding
There was one major challenge with parallel processing. If Transformers
process all words simultaneously, how do they know word order?
| Consider: |     | "Dog | bites |     | man." | and | "Man |     | bites |     | dog." |     |     |
| --------- | --- | ---- | ----- | --- | ----- | --- | ---- | --- | ----- | --- | ----- | --- | --- |
• These contain the same words but completely different meanings.
| • This         | is where |          | positional |          |            | encoding |             | comes |     | in. |          |      |        |
| -------------- | -------- | -------- | ---------- | -------- | ---------- | -------- | ----------- | ----- | --- | --- | -------- | ---- | ------ |
| • Transformers |          |          |            | add      | position   |          | information |       |     |     | to every | word | before |
| processing     |          | begins.  |            |          |            |          |             |       |     |     |          |      |        |
| • Word         | 1        | receives |            | one      | positional |          | signal      |       |     |     |          |      |        |
| • word         | 2        | receives |            | another, |            | and      | so on.      |       |     |     |          |      |        |
•
This allows the model to preserve sequence information while still
| processing |     | everything |     |     | in  | parallel. |     |     |     |     |     |     |     |
| ---------- | --- | ---------- | --- | --- | --- | --------- | --- | --- | --- | --- | --- | --- | --- |

Feed-forward network
• After attention gathers context, the Transformer still needs to refine and
| strengthen  |     | its understanding.  |                |     |     |
| ----------- | --- | ------------------- | -------------- | --- | --- |
| • Polishing |     | the interpretation. |                |     |     |
| • Attention |     | identifies          | relationships. |     |     |
• Feed-forward layers help transform those relationships into richer internal
representations.
• The model repeatedly improves its understanding of what each word
| represents |     | in context. |     |     |     |
| ---------- | --- | ----------- | --- | --- | --- |
• This refinement process helps Transformers become better at prediction,
| reasoning, |       | classification, |      | generation, | and summarization. |
| ---------- | ----- | --------------- | ---- | ----------- | ------------------ |
| • Every    | layer | adds            | more | contextual  | depth.             |

Three Reasons Transformers Beat RNNs
1. Parallel Processing Makes Transformers Much Faster
2. Transformers Understand Long-Range Context Better
3. Transformers Scale Extremely Well

Modern Generative AI
Modern Generative AI can work with multiple modalities:
• Text→Text
• Text→Image
• Text→Audio
• Text→Video
• Text + Image + Audio + Video → Integrated

Attention

| Attention |       | = Weighted |       |        | embeddings |      |      |       |      |      |
| --------- | ----- | ---------- | ----- | ------ | ---------- | ---- | ---- | ----- | ---- | ---- |
|           | -29.0 | -18.5      | -30.9 | -8.9   | 2.8        |      |      | -84.5 |      |      |
|           | 4.4   | 30.8       | 16.4  | 29.5   | -7.0       |      |      | 74.0  |      |      |
|           | 16.0  | -9.2       | -16.4 | -1.5   | 2.1        |      |      | -9.0  |      |      |
|           | 46.5  | 10.3       | 67.3  | 47.2   | 16.9       |      |      | 188.1 |      |      |
|           |       |            |       |        |            | I    | -2   | 0.3   | 1.1  | 3.2  |
|           |       |            |       |        |            | can  | -1.8 | 3     | -0.9 | 1    |
|           | 14.52 | 10.27      | 18.20 | -14.75 | -7.03      | bear | -1.7 | 0.9   | -0.9 | 3.7  |
|           |       |            |       |        |            | the  | 0.6  | -2    | 0.1  | -3.2 |
|           |       |            |       |        |            | pain | -0.4 | 1     | -0.3 | -2.4 |
|           | I     | can        | bear  | the    | pain       |      |      |       |      |      |
|           | -2    | -1.8       | -1.7  | 0.6    | -0.4       |      |      |       |      |      |
|           | 0.3   | 3          | 0.9   | -2     | 1          |      |      |       |      |      |
|           | 1.1   | -0.9       | -0.9  | 0.1    | -0.3       |      |      |       |      |      |
|           | 3.2   | 1          | 3.7   | -3.2   | -2.4       |      |      |       |      |      |

Attention Terminology
|     |     |     |     |     |     |     | These     | vectors | in this    |
| --- | --- | --- | --- | --- | --- | --- | --------- | ------- | ---------- |
|     |     |     |     |     |     |     | operation | are     | called as  |
Queries(Q)
| 14.52 | 10.27 | 18.20 | -14.75 | -7.03 | bear | -1.7 | 0.9 | -0.9 | 3.7 |
| ----- | ----- | ----- | ------ | ----- | ---- | ---- | --- | ---- | --- |
| I     | can   | bear  | the    | pain  |      |      |     |      |     |
| -2    | -1.8  | -1.7  | 0.6    | -0.4  |      |      |     |      |     |
| 0.3   | 3     | 0.9   | -2     | 1     |      |      |     |      |     |
| 1.1   | -0.9  | -0.9  | 0.1    | -0.3  |      |      |     |      |     |
| 3.2   | 1     | 3.7   | -3.2   | -2.4  |      |      |     |      |     |

Attention Terminology
|     |     |     |     |     |     |     | These     | vectors | in this    |
| --- | --- | --- | --- | --- | --- | --- | --------- | ------- | ---------- |
|     |     |     |     |     |     |     | operation | are     | called as  |
Queries(Q)
| 14.52 | 10.27 | 18.20 | -14.75 | -7.03 | bear | -1.7      | 0.9     | -0.9       | 3.7 |
| ----- | ----- | ----- | ------ | ----- | ---- | --------- | ------- | ---------- | --- |
| I     | can   | bear  | the    | pain  |      |           |         |            |     |
|       |       |       |        |       |      | These     | vectors | in this    |     |
| -2    | -1.8  | -1.7  | 0.6    | -0.4  |      |           |         |            |     |
|       |       |       |        |       |      | operation | are     | called as  |     |
| 0.3   | 3     | 0.9   | -2     | 1     |      |           |         |            |     |
| 1.1   | -0.9  | -0.9  | 0.1    | -0.3  |      |           | keys(K) |            |     |
| 3.2   | 1     | 3.7   | -3.2   | -2.4  |      |           |         |            |     |

Attention Scores
| This    | is the dot | product |     |     |     |     |           |         |     |          |     |
| ------- | ---------- | ------- | --- | --- | --- | --- | --------- | ------- | --- | -------- | --- |
|         |            |         |     |     |     |     | These     | vectors |     | in this  |     |
| between | the        | words.  |     |     |     |     |           |         |     |          |     |
|         |            |         |     |     |     |     | operation |         | are | called   | as  |
| These   | are known  | as      |     |     |     |     |           |         |     |          |     |
Queries(Q)
| attention | scores |       |        |       |      |           |         |          |     |     |     |
| --------- | ------ | ----- | ------ | ----- | ---- | --------- | ------- | -------- | --- | --- | --- |
| 14.52     | 10.27  | 18.20 | -14.75 | -7.03 | bear | -1.7      | 0.9     | -0.9     |     | 3.7 |     |
| I         | can    | bear  | the    | pain  |      |           |         |          |     |     |     |
|           |        |       |        |       |      | These     | vectors | in this  |     |     |     |
| -2        | -1.8   | -1.7  | 0.6    | -0.4  |      |           |         |          |     |     |     |
|           |        |       |        |       |      | operation | are     | called   | as  |     |     |
| 0.3       | 3      | 0.9   | -2     | 1     |      |           |         |          |     |     |     |
| 1.1       | -0.9   | -0.9  | 0.1    | -0.3  |      |           | keys(K) |          |     |     |     |
| 3.2       | 1      | 3.7   | -3.2   | -2.4  |      |           |         |          |     |     |     |

| Attention |       | Terminology |       |        |       | We   | multiply  | weights     | again      | with | the        |
| --------- | ----- | ----------- | ----- | ------ | ----- | ---- | --------- | ----------- | ---------- | ---- | ---------- |
|           |       |             |       |        |       |      | Vector(V) | embeddings. |            |      |            |
|           | -29.0 | -18.5       | -30.9 | -8.9   | 2.8   |      |           |             |            |      |            |
|           | 4.4   | 30.8        | 16.4  | 29.5   | -7.0  |      |           | These       | vectors    |      | in this    |
|           | 16.0  | -9.2        | -16.4 | -1.5   | 2.1   |      |           | operation   |            | are  | called as  |
|           | 46.5  | 10.3        | 67.3  | 47.2   | 16.9  |      |           |             | Queries(Q) |      |            |
|           |       |             |       |        |       | bear | -1.7      | 0.9         | -0.9       |      | 3.7        |
|           | 14.52 | 10.27       | 18.20 | -14.75 | -7.03 |      |           |             |            |      |            |
|           | I     | can         | bear  | the    | pain  |      |           |             |            |      |            |
|           |       |             |       |        |       |      | These     | vectors     | in this    |      |            |
|           | -2    | -1.8        | -1.7  | 0.6    | -0.4  |      |           |             |            |      |            |
|           |       |             |       |        |       |      | operation | are         | called     | as   |            |
|           | 0.3   | 3           | 0.9   | -2     | 1     |      |           |             |            |      |            |
keys(K)
|     | 1.1 | -0.9 | -0.9 | 0.1  | -0.3 |     |     |     |     |     |     |
| --- | --- | ---- | ---- | ---- | ---- | --- | --- | --- | --- | --- | --- |
|     | 3.2 | 1    | 3.7  | -3.2 | -2.4 |     |     |     |     |     |     |

| Attention  |     |           | Terminology |         |       |        |       | We   | multiply  | weights |             | again      | with | the      |     |
| ---------- | --- | --------- | ----------- | ------- | ----- | ------ | ----- | ---- | --------- | ------- | ----------- | ---------- | ---- | -------- | --- |
|            |     |           |             |         |       |        |       |      | Vector(V) |         | embeddings. |            |      |          |     |
|            |     | -29.0     | -18.5       |         | -30.9 | -8.9   | 2.8   |      | -84.5     |         |             |            |      |          |     |
|            |     | 4.4       | 30.8        |         | 16.4  | 29.5   | -7.0  |      | 74.0      |         | These       | vectors    |      | in this  |     |
|            |     | 16.0      | -9.2        |         | -16.4 | -1.5   | 2.1   |      | -9.0      |         | operation   |            | are  | called   | as  |
|            |     | 46.5      | 10.3        |         | 67.3  | 47.2   | 16.9  |      | 188.1     |         |             | Queries(Q) |      |          |     |
| These      | are | called    | scores.     | Scores  | are   |        |       |      |           |         |             |            |      |          |     |
| normalized |     | and their | sum         | is made | as    | 1.     |       |      |           |         |             |            |      |          |     |
|            |     |           |             |         |       |        |       | bear | -1.7      | 0.9     |             | -0.9       |      | 3.7      |     |
|            |     | 14.52     | 10.27       |         | 18.20 | -14.75 | -7.03 |      |           |         |             |            |      |          |     |
|            |     | I         | can         |         | bear  | the    | pain  |      |           |         |             |            |      |          |     |
|            |     |           |             |         |       |        |       |      | These     | vectors |             | in this    |      |          |     |
|            |     | -2        | -1.8        |         | -1.7  | 0.6    | -0.4  |      |           |         |             |            |      |          |     |
|            |     |           |             |         |       |        |       |      | operation |         | are         | called     | as   |          |     |
|            |     | 0.3       | 3           |         | 0.9   | -2     | 1     |      |           |         |             |            |      |          |     |
keys(K)
|     |     | 1.1 | -0.9 |     | -0.9 | 0.1  | -0.3 |     |     |     |     |     |     |     |     |
| --- | --- | --- | ---- | --- | ---- | ---- | ---- | --- | --- | --- | --- | --- | --- | --- | --- |
|     |     | 3.2 | 1    |     | 3.7  | -3.2 | -2.4 |     |     |     |     |     |     |     |     |

| Attention |           |     | Terminology |
| --------- | --------- | --- | ----------- |
| I         | can bear  | the | pain        |
| -2        | -1.8 -1.7 | 0.6 | -0.4        |
| 0.3       | 3 0.9     | -2  | 1           |
V , V ,V3,….V
1 2 n
| 1.1 | -0.9 -0.9 | 0.1  | -0.3 |
| --- | --------- | ---- | ---- |
| 3.2 | 1 3.7     | -3.2 | -2.4 |

Attention Terminology
| bear | -1.7 | 0.9 -0.9 | 3.7 |
| ---- | ---- | -------- | --- |
Q
V , V ,V3,….V
1 2 n

| Attention |     |     | Terminology |      |      |          |     |
| --------- | --- | --- | ----------- | ---- | ---- | -------- | --- |
|           |     |     |             | bear | -1.7 | 0.9 -0.9 | 3.7 |
Q K
| I   | can bear  | the | pain |     |     |     |     |
| --- | --------- | --- | ---- | --- | --- | --- | --- |
| -2  | -1.8 -1.7 | 0.6 | -0.4 |     |     |     |     |
| 0.3 | 3 0.9     | -2  | 1    |     |     |     |     |
V , V ,V3,….V
1 2 n
| 1.1 | -0.9 -0.9 | 0.1  | -0.3 |     |     |     |     |
| --- | --------- | ---- | ---- | --- | --- | --- | --- |
| 3.2 | 1 3.7     | -3.2 | -2.4 |     |     |     |     |

| Attention |     |     |     | Terminology |     |     |     |     |
| --------- | --- | --- | --- | ----------- | --- | --- | --- | --- |
Matrix multiplication
|     | Attention | scores |     |     |     |     |     |     |
| --- | --------- | ------ | --- | --- | --- | --- | --- | --- |
matmul
|       |       |       |        |       | bear | -1.7 | 0.9 -0.9 | 3.7 |
| ----- | ----- | ----- | ------ | ----- | ---- | ---- | -------- | --- |
| 14.52 | 10.27 | 18.20 | -14.75 | -7.03 |      |      |          |     |
Q K
| I   | can  | bear | the | pain |     |     |     |     |
| --- | ---- | ---- | --- | ---- | --- | --- | --- | --- |
| -2  | -1.8 | -1.7 | 0.6 | -0.4 |     |     |     |     |
| 0.3 | 3    | 0.9  | -2  | 1    |     |     |     |     |
V , V ,V3,….V
1 2 n
| 1.1 | -0.9 | -0.9 | 0.1  | -0.3 |     |     |     |     |
| --- | ---- | ---- | ---- | ---- | --- | --- | --- | --- |
| 3.2 | 1    | 3.7  | -3.2 | -2.4 |     |     |     |     |

|       | Attention |       |      | Terminology |     |     |     |     |
| ----- | --------- | ----- | ---- | ----------- | --- | --- | --- | --- |
| -29.0 | -18.5     | -30.9 | -8.9 | 2.8         |     |     |     |     |
| 4.4   | 30.8      | 16.4  | 29.5 | -7.0        |     |     |     |     |
| 16.0  | -9.2      | -16.4 | -1.5 | 2.1         |     |     |     |     |
| 46.5  | 10.3      | 67.3  | 47.2 | 16.9        |     |     |     |     |
normalize matmul
matmul
|       |       |       |        |       | bear | -1.7 | 0.9 -0.9 | 3.7 |
| ----- | ----- | ----- | ------ | ----- | ---- | ---- | -------- | --- |
| 14.52 | 10.27 | 18.20 | -14.75 | -7.03 |      |      |          |     |
Q K
V
| I   | can  | bear | the | pain |     |     |     |     |
| --- | ---- | ---- | --- | ---- | --- | --- | --- | --- |
| -2  | -1.8 | -1.7 | 0.6 | -0.4 |     |     |     |     |
| 0.3 | 3    | 0.9  | -2  | 1    |     |     |     |     |
V , V ,V3,….V
1 2 n
| 1.1 | -0.9 | -0.9 | 0.1  | -0.3 |     |     |     |     |
| --- | ---- | ---- | ---- | ---- | --- | --- | --- | --- |
| 3.2 | 1    | 3.7  | -3.2 | -2.4 |     |     |     |     |

|     |     |     |     |     |     |     | Only one | vector | Y calculation |     | is shown  |     |
| --- | --- | --- | --- | --- | --- | --- | -------- | ------ | ------------- | --- | --------- | --- |
k
|       |       |       |      |      |     |       | We can | do the    | same for | all ‘n’ | vectors |         |
| ----- | ----- | ----- | ---- | ---- | --- | ----- | ------ | --------- | -------- | ------- | ------- | ------- |
| -29.0 | -18.5 | -30.9 | -8.9 | 2.8  |     | -84.5 |        |           |          |         |         |         |
|       |       |       |      |      |     |       |        |           |          |         | Y , Y   | ,Y3,….Y |
| 4.4   | 30.8  | 16.4  | 29.5 | -7.0 |     | 74.0  |        |           |          |         |         |         |
|       |       |       |      |      |     |       |        |           |          |         | 1       | 2 n     |
| 16.0  | -9.2  | -16.4 | -1.5 | 2.1  |     | -9.0  |        |           |          |         |         |         |
| 46.5  | 10.3  | 67.3  | 47.2 | 16.9 |     | 188.1 |        | normalize |          |         | matmul  |         |
matmul
|       |       |       |        |       | bear -1.7 | 0.9 -0.9 | 3.7 |     |       |         |     |     |
| ----- | ----- | ----- | ------ | ----- | --------- | -------- | --- | --- | ----- | ------- | --- | --- |
| 14.52 | 10.27 | 18.20 | -14.75 | -7.03 |           |          |     |     |       |         |     |     |
|       |       |       |        |       |           |          |     | Q   |       | K       |     | V   |
| I     | can   | bear  | the    | pain  |           |          |     |     |       |         |     |     |
| -2    | -1.8  | -1.7  | 0.6    | -0.4  |           |          |     |     |       |         |     |     |
| 0.3   | 3     | 0.9   | -2     | 1     |           |          |     |     |       |         |     |     |
|       |       |       |        |       |           |          |     |     | V , V | ,V3,….V |     |     |
|       |       |       |        |       |           |          |     |     | 1     | 2       | n   |     |
| 1.1   | -0.9  | -0.9  | 0.1    | -0.3  |           |          |     |     |       |         |     |     |
| 3.2   | 1     | 3.7   | -3.2   | -2.4  |           |          |     |     |       |         |     |     |

| Attention |     | - Block |     |     |     |     |
| --------- | --- | ------- | --- | --- | --- | --- |
Y , Y ,Y3,….Y
1 2 n
|                |        |      |            | normalize | matmul |     |
| -------------- | ------ | ---- | ---------- | --------- | ------ | --- |
| Attention      | block, | more | specially  |           |        |     |
| self-attention | block  |      |            |           |        |     |
matmul
|     |     |     |     | Q   | K   | V   |
| --- | --- | --- | --- | --- | --- | --- |
V , V ,V3,….V
1 2 n

•Attention is the key mechanism that allows Transformers to focus on relevant
parts of the input when processing each token. It helps the model learn
relationships between words, regardless of their distance in the sentence.
•Attention tells the model what to look at when making decisions for each
word."Instead of processing words one by one (like RNNs), attention allows every
word to interact with every other word in the sentence, in parallel.
•"The cat sat on the mat.“ When processing the word "sat", attention might focus
| on:   | "cat" | (subject) |       | "mat"      | (object) |            |                |
| ----- | ----- | --------- | ----- | ---------- | -------- | ---------- | -------------- |
| •This | helps | the       | model | understand |          | contextual | relationships. |
•Each input token is transformed into three vectors:Query (Q)Key (K)Value (V)
•Attention
| • Is       | nothing        | but weighted |        | embeddings  |     | only     |     |
| ---------- | -------------- | ------------ | ------ | ----------- | --- | -------- | --- |
| • Smart    | embeddings     |              |        |             |     |          |     |
| • Advanced |                | version      | of     | word2vec    |     |          |     |
| • More     | contextualized |              |        | embeddings  |     |          |     |
| • With     | a different    |              | matrix | calculation |     | formula. |     |

| Attention        | Score: |                                    |         |     |            |       |     |
| ---------------- | ------ | ---------------------------------- | ------- | --- | ---------- | ----- | --- |
| 𝑄𝐾𝑇 : Measures   |        | similarity                         | between |     | queriesand | keys. |     |
| 𝑑 :Scalingfactor |        | (preventslargedot-productvalues).  |         |     |            |       |     |
𝑘
dkis the dimension (number of elements) in each Key vector.
| Softmax:Converts  |                | scores        | into    | probabilities. |             |       |                  |
| ----------------- | -------------- | ------------- | ------- | -------------- | ----------- | ----- | ---------------- |
| MultiplybyV:Getsa |                | weightedsumof |         |                | the values. |       |                  |
| Encoder           | Layer:         |               |         |                |             |       |                  |
| Self-attention    |                | →             | Focuses |                | on all      | input | tokens.          |
| Decoder           | Layer:         |               |         |                |             |       |                  |
| Masked            | self-attention |               |         | →              | Looks       | only  | at past outputs. |
Cross-attention → Focuses on encoder outputs for translation.

| Attention       |                |         |           | steps      |               |           |          |        |         |             |         |        |                    |        |             |
| --------------- | -------------- | ------- | --------- | ---------- | ------------- | --------- | -------- | ------ | ------- | ----------- | ------- | ------ | ------------------ | ------ | ----------- |
| Step            | Action         |         |           |            |               |           |          |        |         |             |         |        |                    |        |             |
| 1.              | Each           | word    | creates   |            | Q, K,         | V vectors |          |        |         |             |         |        |                    |        |             |
| 2.              | Compute        |         | attention |            | scores        | (Q        | × Kᵗ)    |        |         |             |         |        |                    |        |             |
| 3.              | Apply          | softmax |           | to         | get attention |           | weights  |        |         |             |         |        |                    |        |             |
| 4.              | Use            | weights |           | to combine |               | value     | vectors  | (V)    |         |             |         |        |                    |        |             |
| 5.              | Use            | this    | as input  |            | for next      | layers    |          |        |         |             |         |        |                    |        |             |
| Attention       |                | Type    |           |            |               |           | Purpose  |        |         |             |         | Usage  |                    |        |             |
|                 |                |         |           |            |               |           | Each     | word   | attends | to every    | other   |        |                    |        |             |
| Self-Attention  |                |         |           |            |               |           |          |        |         |             |         | Used   | in both encoder    |        | and decoder |
|                 |                |         |           |            |               |           | word     | in the | same    | sentence    |         |        |                    |        |             |
|                 |                |         |           |            |               |           |          |        |         |             |         | Used   | in encoder-decoder |        | models      |
| Cross-Attention |                |         |           |            |               |           | Decoder  |        | attends | to encoder  | outputs |        |                    |        |             |
|                 |                |         |           |            |               |           |          |        |         |             |         | (e.g., | translation)       |        |             |
|                 |                |         |           |            |               |           | Prevents |        | a token | from seeing | future  |        |                    |        |             |
| Masked          | Self-Attention |         |           |            |               |           |          |        |         |             |         | Used   | in decoder         | during | training    |
tokens

| Code | - Self | Attention | Practice |
| ---- | ------ | --------- | -------- |

| Code | - Self | Attention | Practice |
| ---- | ------ | --------- | -------- |

| Code | - Self | Attention | Practice |
| ---- | ------ | --------- | -------- |

| Code | - Self | Attention | Practice |
| ---- | ------ | --------- | -------- |

| Add         | Trainable |          | Parameters |        |     |     |     |     |
| ----------- | --------- | -------- | ---------- | ------ | --- | --- | --- | --- |
| Multiplying | with      | weight   | matrix     | is     |     |     |     |     |
| same        | as adding | a linear | layer      | in NN  |     |     |     |     |
terminology
|     |     |     |     |     |     |     | Y , Y | ,Y ,….Y |
| --- | --- | --- | --- | --- | --- | --- | ----- | ------- |
|     |     |     |     |     |     |     | 1     | 2 3 n   |
normalize matmul
matmul
|     |     |     | W   | Q   | W        | K    | W   | V   |
| --- | --- | --- | --- | --- | -------- | ---- | --- | --- |
|     |     |     | Q   |     | K        |      | V   |     |
|     |     |     |     |     | V , V ,V | ,….V |     |     |
|     |     |     |     |     | 1 2      | 3 n  |     |     |

| Add        | Trainable |            | Parameters     |           |     |     |        |         |
| ---------- | --------- | ---------- | -------------- | --------- | --- | --- | ------ | ------- |
| While      | training  | the model, | we can         |           |     |     |        |         |
| consider   | this as   | attention  | block          | as a      |     |     |        |         |
| linear     | embedding | layer,     | and train      | the       |     |     |        |         |
|            |           |            |                |           |     |     | Y , Y  | ,Y ,….Y |
| parameters | based     | on the     | error signals. |           |     |     | 1      | 2 3 n   |
|            |           |            |                | normalize |     |     | matmul |         |
matmul
|     |     |     | W   | Q   | W        | K    | W   | V   |
| --- | --- | --- | --- | --- | -------- | ---- | --- | --- |
|     |     |     | Q   |     | K        |      | V   |     |
|     |     |     |     |     | V , V ,V | ,….V |     |     |
|     |     |     |     |     | 1 2      | 3 n  |     |     |

Attention formula
| 𝐴𝑡𝑡𝑒𝑛𝑡𝑖𝑜𝑛 |           | 𝑄, 𝐾, | 𝑉 = | 𝑠𝑜𝑓𝑡𝑚𝑎𝑥 | 𝑄𝐾𝑇     | V   |
| --------- | --------- | ----- | --- | ------- | ------- | --- |
|           |           |       |     | Y , Y   | ,Y ,….Y |     |
|           |           |       |     | 1       | 2 3 n   |     |
|           | normalize |       |     | matmul  |         |     |
matmul
| W   | Q   | W     | K       | W   | V   |     |
| --- | --- | ----- | ------- | --- | --- | --- |
| Q   |     | K     |         | V   |     |     |
|     |     | V , V | ,V ,….V |     |     |     |
|     |     | 1     | 2 3     | n   |     |     |

Multi-head attention

Single Context
• The bank offers various credit cards for diverse customer needs.
• The river bank showcases stunning flowers in full, colorful bloom.
•Savings bank vs River bank - We can distinguish both by using attention mechanism.

| Several |     | parallel |     | contexts |     |     |     |     |
| ------- | --- | -------- | --- | -------- | --- | --- | --- | --- |
• The bank offers various credit cards for diverse customer needs.
• Bank shares experienced a stock price decline during this quarter.
• The bank sponsors a football tournament to expand its customer base.
• The river bank showcases stunning flowers in full, colorful bloom.
• Ancient cities formed along river banks during human evolutionary history.
•
| The | river | bank | is  | steep, | so we | must | be careful. |     |
| --- | ----- | ---- | --- | ------ | ----- | ---- | ----------- | --- |
•Savings bank vs River bank - We can distinguish both by using attention
mechanism.
•But, what if, bank itself has several sub contexts like bank credit cards,
| bank | shares, | bank    | sponsorship? |         |          |     |          |     |
| ---- | ------- | ------- | ------------ | ------- | -------- | --- | -------- | --- |
| •How | can we  | capture |              | several | parallel |     | contexts | ?   |

| Multi-head |     |     | attention |     |     |     |
| ---------- | --- | --- | --------- | --- | --- | --- |
• The bank offers various credit cards for diverse customer needs.
• Bank shares experienced a stock price decline during this quarter.
• The bank sponsors a football tournament to expand its customer base.
• The river bank showcases stunning flowers in full, colorful bloom.
• Ancient cities formed along river banks during human evolutionary history.
•
| The | river | bank | is steep, | so we | must | be careful. |
| --- | ----- | ---- | --------- | ----- | ---- | ----------- |
•But, what if, bank itself has several sub contexts like bank credit
| cards, | bank | shares, | bank | sponsorship? |     |     |
| ------ | ---- | ------- | ---- | ------------ | --- | --- |
•How can we capture several parallel contexts ? – We can use multiple
| self attention |     | blocks | in  | parallel. |     |     |
| -------------- | --- | ------ | --- | --------- | --- | --- |

| Single |     |           | Head | Attention. |        |         |     |        |     |           |     |     |     |          |     |           |           |      |     |
| ------ | --- | --------- | ---- | ---------- | ------ | ------- | --- | ------ | --- | --------- | --- | --- | --- | -------- | --- | --------- | --------- | ---- | --- |
|        |     |           |      |            |        |         | •   | Until  |     | now,      |     | we  |     | have     |     | discussed |           |      | a   |
|        |     |           |      |            | Y , Y  | ,Y ,….Y |     |        |     |           |     |     |     |          |     |           |           |      |     |
|        |     |           |      |            | 1      | 2 3 n   |     |        |     |           |     |     |     |          |     |           |           |      |     |
|        |     |           |      |            |        |         |     | single |     | attention |     |     |     | stack    |     | either    |           | with |     |
|        |     |           |      |            |        |         |     | single |     | block     |     | or  |     | multiple |     |           | attention |      |     |
|        |     | normalize |      |            | matmul |         |     |        |     |           |     |     |     |          |     |           |           |      |     |
blocks.
|     |     |        |     |     |     |     | •   | At   | the | end      |     | we  | will |        | have    |      | a single  |     |     |
| --- | --- | ------ | --- | --- | --- | --- | --- | ---- | --- | -------- | --- | --- | ---- | ------ | ------- | ---- | --------- | --- | --- |
|     |     | matmul |     |     |     |     |     | set  | of  | vectors  |     |     | [Y   | , Y    | ,Y3,….Y |      |           | ]   |     |
|     |     |        |     |     |     |     |     |      |     |          |     |     |      | 1      | 2       |      |           | n   |     |
|     |     |        |     |     |     |     | •   | This |     | is known |     |     | as   | single |         | head |           |     |     |
attention.
| W   | Q   |     | W   | K   | W   | V   |     |           |     |       |         |     |     |          |       |          |           |     |     |
| --- | --- | --- | --- | --- | --- | --- | --- | --------- | --- | ----- | ------- | --- | --- | -------- | ----- | -------- | --------- | --- | --- |
| Q   |     |     | K   |     | V   |     | •   | For       | a   | large |         | and |     | diverse  |       | dataset, |           |     | we  |
|     |     |     |     |     |     |     |     | may       |     | have  | several |     |     | parallel |       |          | contexts. |     |     |
|     |     |     |     |     |     |     | •   | We        | may |       | have    |     | to  | include  |       |          | parallel  |     |     |
|     |     |     |     |     |     |     |     | attention |     |       | stacks  |     |     | to       | learn |          | parallel  |     |     |
contexts
|     |     |     | V , V ,V3,….V |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |
| --- | --- | --- | ------------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
|     |     |     | 1 2           | n   |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |

| Attention- | with | two | heads |
| ---------- | ---- | --- | ----- |

Multi-head Attention.
| The bank | offers  |        | Bank shares  |          | The bank | sponsors   | a   |
| -------- | ------- | ------ | ------------ | -------- | -------- | ---------- | --- |
|          |         |        | experienced  | a stock  | football | tournament | to  |
| various  | credit  | cards  |              |          |          |            |     |
for diverse customer  price decline during  expand its customer base.
| needs. |     |     | this quarter. |     |     |     |     |
| ------ | --- | --- | ------------- | --- | --- | --- | --- |

| Single-head |     | vs Multi-head | Attention. |
| ----------- | --- | ------------- | ---------- |
•Single-head attention can create unique embeddings for the word "bank,"
depending on its use in phrases like "river bank" or "savings bank."
•Multi-head attention takes this further by assigning the word "bank" different
embeddings for its roles in different sub-contexts, even within a larger
| context | like "savings | bank." |     |
| ------- | ------------- | ------ | --- |

| Adding | a liner     | layer | is simply |
| ------ | ----------- | ----- | --------- |
|        | multiplying |       | the       |
Multi-head Attention.
| concatenated |     | vector | with  |
| ------------ | --- | ------ | ----- |
Linear Layer
|     | output | weights | W   |
| --- | ------ | ------- | --- |
O
Concatenate

| 𝑀𝑢𝑙𝑡𝑖𝐻𝑒𝑎𝑑 | 𝐴𝑡𝑡𝑒𝑛𝑡𝑖𝑜𝑛 |     | 𝑄, 𝐾, 𝑉 | = 𝑐𝑜𝑛𝑐𝑎𝑡 | 𝐻 ,𝐻 | ,. . , 𝐻ℎ W |
| --------- | --------- | --- | ------- | -------- | ---- | ----------- |
1 2 o
|     | 𝑤ℎ𝑒𝑟𝑒 | 𝐻𝑖 = 𝐴𝑡𝑡𝑒𝑛𝑡𝑖𝑜𝑛 |     | 𝑄𝑊  | , 𝐾𝑊𝑖𝑘,𝑉𝑊𝑖𝑣 |     |
| --- | ----- | -------------- | --- | --- | ----------- | --- |
𝑖𝑄
|     |     |     | Linear | Layer |     |     |
| --- | --- | --- | ------ | ----- | --- | --- |
Concatenate

| Multi-head |        | Attention | –                           |
| ---------- | ------ | --------- | --------------------------- |
| Actual     | figure | from the  | paper-Attention is all you  |
need

| Multi-head | Attention |           | visualization |          |          | - Example |
| ---------- | --------- | --------- | ------------- | -------- | -------- | --------- |
|            |           | Two       | attention     | heads    | focusing | on two    |
|            |           | different |               | contexts | w.r.t    | a word    |

| Multi-head |           | Attention |       | visualization |           | - Example |
| ---------- | --------- | --------- | ----- | ------------- | --------- | --------- |
|            | Three     | attention | heads | focusing      | on three  |           |
|            | different | contexts  | w.r.t | the same      | word      |           |

Multi-Head Attention + Encoder and
Decoder
y y
1 … t
Masked Multi-Head
Multi-Head Attention
Attention
Thought Vector
Output embeddings
Input embeddings
y , y ,y ,….y
1 2 3 t-1
X , X ,X ,….X
1 2 3 n

| Masked     |       | Attention  |          |           |            |
| ---------- | ----- | ---------- | -------- | --------- | ---------- |
| •Attention |       | in decoder | is known | as masked | attention. |
| •Why       | is it | masked     | ?        |           |            |

| What |     |        | is      | Masked |           |     | Multi-Head |     |     | Attention? |     |         |      |           |          |     |     |
| ---- | --- | ------ | ------- | ------ | --------- | --- | ---------- | --- | --- | ---------- | --- | ------- | ---- | --------- | -------- | --- | --- |
|      |     |        | English |        | - Encoder |     |            |     |     |            |     | Spanish |      | - Decoder |          |     |     |
|      | A   | nearly |         |        | perfect   |     | photo      |     |     | Una        |     | foto    | casi |           | perfecta |     |     |
Inside encoder self attention, while  Inside decoder self attention, while calculating
| •   |     |     |     |     |     |     |     | •   |     |     |     |     |     |     |     |     |     |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
calculating the attention for the word  the attention for the word “casi”
| “nearly” |     |          |     |     |     |      |               | • can | we  | consider |     | all | the | rest | of the | words? |     |
| -------- | --- | -------- | --- | --- | --- | ---- | ------------- | ----- | --- | -------- | --- | --- | --- | ---- | ------ | ------ | --- |
| • do     | we  | consider |     | all | the | rest | of the words? |       |     |          |     |     |     |      |        |        |     |
• We get all the input in one shot. • We can use only words until now, for the
|     |     |     |     |     |     |     |     | prediction. |     |      | While |     | predicting |      | word   | at time-t   | we  |
| --- | --- | --- | --- | --- | --- | --- | --- | ----------- | --- | ---- | ----- | --- | ---------- | ---- | ------ | ----------- | --- |
|     |     |     |     |     |     |     |     | can         | use | only | words |     | until      | time | t-1 in | the decoder |     |
• At the training and test time we have • At the test time, we will NOT have access to
| access |     | to  | all the |     | words. |     |     | future |     | words. |     |     |     |     |     |     |     |
| ------ | --- | --- | ------- | --- | ------ | --- | --- | ------ | --- | ------ | --- | --- | --- | --- | --- | --- | --- |
• Encoder self attention doesn’t have any • DecoderAttention calculation need to be
| special |     | changes |     |     |     |     |     | masked |     | from |     | the | future | words. |     |     |     |
| ------- | --- | ------- | --- | --- | --- | --- | --- | ------ | --- | ---- | --- | --- | ------ | ------ | --- | --- | --- |

| Multi-Head |     |     | Attention |     | + Encoder | and  |     |
| ---------- | --- | --- | --------- | --- | --------- | ---- | --- |
Decoder
|     |     |     |     |     |     | y   | y   |
| --- | --- | --- | --- | --- | --- | --- | --- |
…
|     | Thought     | vector | may fail  | to  |     | 1   | t   |
| --- | ----------- | ------ | --------- | --- | --- | --- | --- |
|     | pass        | on the | complete  |     |     |     |     |
|     | information | from   | encoder   |     |     |     |     |
to decoder
Masked Multi-Head
Multi-Head
Attention
Attention
Thought Vector
Output embeddings
Input embeddings
y , y ,y ,….y
1 2 3 t-1
|     | X , X ,X ,….X |     |     |     |     |     |     |
| --- | ------------- | --- | --- | --- | --- | --- | --- |
|     | 1 2 3         | n   |     |     |     |     |     |

| Inter | Attention |     |
| ----- | --------- | --- |
•The decoder should not only use its own context but also get context
| from | the encoder. |     |
| ---- | ------------ | --- |
•This can be done by using inter-attention between the encoder and
decoder.
•Here, the importance (weights) of each decoder word depends on the
| words | from | the encoder. |
| ----- | ---- | ------------ |

| The | Third | Attention |     | – “Inter- | Attention” |
| --- | ----- | --------- | --- | --------- | ---------- |
•To solve sequence to sequence models, we need to add three different
| type | of attentions. |     |     |     |     |
| ---- | -------------- | --- | --- | --- | --- |
•For example we are building a machine translation model from English
to Spanish.
• We need an attention mechanism in the input language(English) to understand the
| contexts | in English. |     |     |     |     |
| -------- | ----------- | --- | --- | --- | --- |
• We need an attention mechanism in the output language(Spanish) to understand the
| word | relations | in Spanish |     |     |     |
| ---- | --------- | ---------- | --- | --- | --- |
• The third attention is the most important one, the word relations and contextual
| relevance | from | English | to Spanish. |     |     |
| --------- | ---- | ------- | ----------- | --- | --- |

| The | Third | Attention | – “Inter- | Attention” |     |     |
| --- | ----- | --------- | --------- | ---------- | --- | --- |
y y
…
1 t
|     |     |     |     | Encoder | to Decoder | Attention |
| --- | --- | --- | --- | ------- | ---------- | --------- |
Masked Multi-Head
Multi-Head
Attention
Attention
Output embeddings
Input embeddings
y , y ,y ,….y
1 2 3 t-1
|     | X , X ,X ,….X |     |     |     |     |     |
| --- | ------------- | --- | --- | --- | --- | --- |
|     | 1 2 3         | n   |     |     |     |     |

| Attention |           | + Encoder |               | and  | Decoder |          |      |
| --------- | --------- | --------- | ------------- | ---- | ------- | -------- | ---- |
|           | This      | is also   | a Multi-Head  |      |         | y , y ,y | ,….y |
|           |           |           |               |      |         | 1 2      | 3 t  |
|           | attention | with      | a different   | set  |         |          |      |
|           | of        | Queries   | and Values    |      |         |          |      |
Multi-Head
Attention
|     |     |     |     |     |     | Masked | Multi-Head  |
| --- | --- | --- | --- | --- | --- | ------ | ----------- |
Multi-Head
Attention
Attention
|     |     |     |     |     |     | Output embeddings |     |
| --- | --- | --- | --- | --- | --- | ----------------- | --- |
Input embeddings
|     |          |      |     |     |     | y , y | ,y ,….y |
| --- | -------- | ---- | --- | --- | --- | ----- | ------- |
|     |          |      |     |     |     | 1 2   | 3 t-1   |
|     | X , X ,X | ,….X |     |     |     |       |         |
|     | 1 2      | 3 n  |     |     |     |       |         |

| Q,  | K, V | for | Self(Intra) |     | Attention |     |     |     |     |     |     |     |
| --- | ---- | --- | ----------- | --- | --------- | --- | --- | --- | --- | --- | --- | --- |
(V)
|     |      |        |         |       |     |     |       |     | Q, K | and V     | are considered |        |
| --- | ---- | ------ | ------- | ----- | --- | --- | ----- | --- | ---- | --------- | -------------- | ------ |
|     | A    | nearly | perfect | photo |     |     |       |     |      |           |                |        |
|     |      |        |         |       |     |     |       |     | from | a same    | set in         | a self |
|     | -1.1 | -1.2   | 0.1     | -2.3  |     |     | -4.54 |     |      |           |                |        |
|     |      |        |         |       |     |     |       |     |      | attention | block          |        |
|     | -2.6 | -6.5   | -0.1    | -3.1  |     |     |       |     |      |           |                |        |
-12.29
|     | -1.7 | -3.4 | -0.4 | -10.5 |     |     | -15.90 | (Q) |     |     |     |     |
| --- | ---- | ---- | ---- | ----- | --- | --- | ------ | --- | --- | --- | --- | --- |
|     | 0.9  | 7.4  | 0.0  | 2.0   |     |     |        |     |     |     |     |     |
10.29
|     |      |        |         |       |         | A   | -0.7 | 0.3  | 0.2  | 0.6  |     |     |
| --- | ---- | ------ | ------- | ----- | ------- | --- | ---- | ---- | ---- | ---- | --- | --- |
|     |      |        |         |       | nearly  |     | -1.5 | 1.5  | -0.2 | 0.8  |     |     |
|     | 1.72 | -4.43  | 0.42    | -3.77 | perfect |     | -1.0 | 0.8  | -0.8 | 2.8  |     |     |
|     |      |        |         |       | photo   |     | 0.5  | -1.7 | 0.0  | -0.5 |     |     |
|     | A    | nearly | perfect | photo |         |     | (K)  |      |      |      |     |     |
|     | -0.7 | 0.3    | 0.2     | 0.6   |         |     |      |      |      |      |     |     |
|     | -1.5 | 1.5    | -0.2    | 0.8   |         |     |      |      |      |      |     |     |
|     | -1.0 | 0.8    | -0.8    | 2.8   |         |     |      |      |      |      |     |     |
|     | 0.5  | -1.7   | 0.0     | -0.5  |         |     |      |      |      |      |     |     |

| Attention |     | / Inter- | Attention |     |     |     |
| --------- | --- | -------- | --------- | --- | --- | --- |
• For example, when we are translating from English to Spanish
• Inter attention inside the decoder captures the word relation between
| decoder  | and       | encoder. |      |         |           |           |
| -------- | --------- | -------- | ---- | ------- | --------- | --------- |
| • Q      | – Queries | will be  | from | Spanish | (Decoder) |           |
| • K-Keys | and       | V-Values | will | be from | English   | (Encoder) |

| Attention |     | / Inter- |     | Attention |     | - Calculation |     |     |     |     |     |
| --------- | --- | -------- | --- | --------- | --- | ------------- | --- | --- | --- | --- | --- |
(V)
| A    | nearly | perfect | photo |     |     |     |     |     | Queries-Q are from |     |     |
| ---- | ------ | ------- | ----- | --- | --- | --- | --- | --- | ------------------ | --- | --- |
| -0.1 | 0.4    | 0.0     | 0.0   |     |     |     |     |     | decoder            |     |     |
0.39
| 0.4   | -1.4   | 0.1     | 0.1   |     |          | -0.79 |      |      |        |              |     |
| ----- | ------ | ------- | ----- | --- | -------- | ----- | ---- | ---- | ------ | ------------ | --- |
|       |        |         |       |     |          |       |      |      | Keys-K | and Values-V | are |
| 0.2   | -1.2   | -0.2    | 0.2   |     |          | -0.90 | (Q)  |      |        |              |     |
|       |        |         |       |     |          |       |      |      | from   | encoder      |     |
| -0.1  | 1.3    | -0.1    | 0.0   |     |          | 1.09  |      |      |        |              |     |
|       |        |         |       |     | Una      | -0.1  | 0.0  | 0.0  | 0.5    |              |     |
|       |        |         |       |     | foto     | -0.6  | 0.7  | -0.1 | 0.8    |              |     |
| -0.15 | -0.66  | 0.12    | 0.07  |     | casi     | -0.5  | 0.4  | -0.2 | 0.8    |              |     |
|       |        |         |       |     | perfecta | 0.1   | -0.8 | 0.0  | -0.2   |              |     |
| A     | nearly | perfect | photo |     |          |       |      |      |        |              |     |
(K )
| 0.3  | -0.6 | 0.1  | 0.2  |     |     |     |     |     |     |     |     |
| ---- | ---- | ---- | ---- | --- | --- | --- | --- | --- | --- | --- | --- |
| -2.3 | 2.1  | 0.8  | 1.6  |     |     |     |     |     |     |     |     |
| -1.6 | 1.8  | -1.3 | 2.4  |     |     |     |     |     |     |     |     |
| 0.9  | -2.0 | -0.5 | -0.1 |     |     |     |     |     |     |     |     |

Seq-to-Seq model with
Attention
y , y ,y ,….y
1 2 3 t
Multi-Head
Attention
Masked Multi-Head
Multi-Head Attention
Attention
Output embeddings
Input embeddings
y , y ,y ,….y
1 2 3 t-1
X , X ,X ,….X
1 2 3 n

| Attention |      | +       | Dense    | Layers |           | for | learning |
| --------- | ---- | ------- | -------- | ------ | --------- | --- | -------- |
| •Until    | now, | we have | included | only   | attention |     | blocks.  |
•But eventually, these attention blocks will give us just better
| embeddings |     | only. |     |     |     |     |     |
| ---------- | --- | ----- | --- | --- | --- | --- | --- |
•We need to add at least a couple of dense layers on top of these
| intelligent |     | embeddings. |     |     |     |     |     |
| ----------- | --- | ----------- | --- | --- | --- | --- | --- |
•These dense layers will help us in learning all the patterns in the data.
•Dense layers are also known as hidden layers or feed forward layers

| Final | Seq-to-Seq |     | model  |        |       |             |         |
| ----- | ---------- | --- | ------ | ------ | ----- | ----------- | ------- |
|       |            |     |        |        | y     | , y ,y ,….y |         |
|       |            |     |        |        | 1     | 2 3         | t       |
| with  | Attention  |     |        |        |       |             |         |
|       |            |     |        | Output | Layer | with        | SoftMax |
|       |            |     |        |        | Dense | Layer       |         |
Multi-Head
Attention
|     | Dense            | Layer |     |        |        |             |     |
| --- | ---------------- | ----- | --- | ------ | ------ | ----------- | --- |
|     | Multi-Head       |       |     |        | Masked | Multi-Head  |     |
|     | Attention        |       |     |        |        | Attention   |     |
|     | Input embeddings |       |     | Output |        | embeddings  |     |
|     | X , X ,X         | ,….X  |     |        | y ,    | y ,y ,….y   |     |
|     | 1 2              | 3 n   |     |        | 1      | 2 3         | t-1 |

| Preserving |     |     | the | sequential |     |     | order |     |     |
| ---------- | --- | --- | --- | ---------- | --- | --- | ----- | --- | --- |
•Questions: In word2vec do we preserve the sequential order? In
| attention |       | are we | preserving |      | the     | sequential | order? |       |         |
| --------- | ----- | ------ | ---------- | ---- | ------- | ---------- | ------ | ----- | ------- |
| •Answer:  | Nope, |        | we are     | not. | Context | is decided |        | based | on the  |
surrounding words, not necessarily by retaining the sequence.
| 1. “the | food | was | good, | not | bad”  |     |     |     |     |
| ------- | ---- | --- | ----- | --- | ----- | --- | --- | --- | --- |
| 2. “the | food | was | bad,  | not | good” |     |     |     |     |
Self attention treats both the sentences the same way. The order and
| the position |     | of “good” |     | and | “bad” | are very | important |     | in NLP. |
| ------------ | --- | --------- | --- | --- | ----- | -------- | --------- | --- | ------- |

| Positional |     |     | encodings |     |     |
| ---------- | --- | --- | --------- | --- | --- |
•How do we include the information about the sequential order or the
| position  |     | of the      | sentence? |            |     |
| --------- | --- | ----------- | --------- | ---------- | --- |
| •By using |     | “Positional |           | encodings” |     |
•It is a very simple concept. We will create a new vector based on the
| relative |     | position | of  | the word | in a sentence. |
| -------- | --- | -------- | --- | -------- | -------------- |
•We will now add the positional information to the embeddings and
| pass | it on | as input |     |     |     |
| ---- | ----- | -------- | --- | --- | --- |

| Positional |     | encodings |     |     |
| ---------- | --- | --------- | --- | --- |
• In models like Transformers, there's no inherent notion of sequence order (unlike RNNs or
CNNs).
• To let the model understand the order of elements in a sequence (like words in a sentence),
| we use | positional | encodings. |     |     |
| ------ | ---------- | ---------- | --- | --- |
• Transformers process all tokens in parallel—they don’t know which word comes first or last.
| So, we       | inject positional | information | into the | input embedding's. |
| ------------ | ----------------- | ----------- | -------- | ------------------ |
| • Sinusoidal | Positional        | Encoding    | (Static) |                    |
Introduced in the original Vaswani et al. (2017) Transformer paper. It uses sine and cosine
functions of different frequencies. No additional parameters are learned and purely
mathematical.

| Simple | Positional | encodings |     |     |
| ------ | ---------- | --------- | --- | --- |
• In the first sentence, good has value-3 and bad has value-5
• In the second sentence, good has value-5 and bad has value-3
|     |     | the food | was good | not bad  |
| --- | --- | -------- | -------- | -------- |
|     |     | 0 1      | 2 3      | 4 5      |
|     |     | the food | was bad  | not good |
|     |     | 0 1      | 2 3      | 4 5      |
• We can add this extra information to input embeddings and pass it on as the input for
| attention calculation |     |     |     |     |
| --------------------- | --- | --- | --- | --- |

| Adding | Positional |     |     | encodings |     | - idea |     |     |
| ------ | ---------- | --- | --- | --------- | --- | ------ | --- | --- |
Embeddings
|      |      | the  | food was  | good | not bad   |     |      |       |
| ---- | ---- | ---- | --------- | ---- | --------- | --- | ---- | ----- |
|      |      | -0.2 | -0.2 -1.1 | 3.2  | -0.2 -0.3 |     |      |       |
|      |      | -1.7 | 0.9 -0.9  | 3.7  | -0.5 1.0  |     |      |       |
|      |      | -0.2 | -0.5 0.3  | 2.6  | 0.3 -2.2  |     |      |       |
|      |      | -1.3 | -0.8 0.1  | 2.5  | 2.6 -1.5  |     |      |       |
| the  | food |      | was       |      | good      |     | not  | bad   |
| -0.2 | -0.2 |      | -1.1      |      | 3.2       |     | -0.2 | -0.30 |
| -1.7 | 0.9  |      | -0.9      |      | 3.7       |     | -0.5 | 1.00  |
| -0.2 | -0.5 |      | 0.3       |      | 2.6       |     | 0.3  | -2.20 |
| -1.3 | -0.8 |      | 0.1       |      | 2.5       |     | 2.6  | -1.50 |

| Adding | Positional |     |     | encodings |     |     | - idea |     |     |
| ------ | ---------- | --- | --- | --------- | --- | --- | ------ | --- | --- |
Positional index
|      |      | the  | food | was  | good | not bad   |     |      |       |
| ---- | ---- | ---- | ---- | ---- | ---- | --------- | --- | ---- | ----- |
|      | pos  | 0    | 1    | 2    | 3    | 4 5       |     |      |       |
|      |      | -0.2 | -0.2 | -1.1 | 3.2  | -0.2 -0.3 |     |      |       |
|      |      | -1.7 | 0.9  | -0.9 | 3.7  | -0.5 1.0  |     |      |       |
|      |      | -0.2 | -0.5 | 0.3  | 2.6  | 0.3 -2.2  |     |      |       |
|      |      | -1.3 | -0.8 | 0.1  | 2.5  | 2.6 -1.5  |     |      |       |
| the  | food |      |      | was  |      | good      |     | not  | bad   |
| -0.2 | -0.2 |      |      | -1.1 |      | 3.2       |     | -0.2 | -0.30 |
| -1.7 | 0.9  |      |      | -0.9 |      | 3.7       |     | -0.5 | 1.00  |
| -0.2 | -0.5 |      |      | 0.3  |      | 2.6       |     | 0.3  | -2.20 |
| -1.3 | -0.8 |      |      | 0.1  |      | 2.5       |     | 2.6  | -1.50 |

| Adding |     | Positional |      |      | encodings |      |      |      | - idea |     |                |     |         |
| ------ | --- | ---------- | ---- | ---- | --------- | ---- | ---- | ---- | ------ | --- | -------------- | --- | ------- |
|        |     |            | the  | food | was       | good | not  | bad  |        |     |                |     |         |
|        |     | pos        | 0    | 1    | 2         | 3    | 4    | 5    |        |     |                |     |         |
|        |     |            | -0.2 | -0.2 | -1.1      | 3.2  | -0.2 | -0.3 |        |     |                |     |         |
|        |     |            | -1.7 | 0.9  | -0.9      | 3.7  | -0.5 | 1.0  |        |     |                |     |         |
|        |     |            |      |      |           |      |      |      |        |     | Add positional |     | index   |
|        |     |            | -0.2 | -0.5 | 0.3       | 2.6  | 0.3  | -2.2 |        |     |                |     |         |
|        |     |            |      |      |           |      |      |      |        |     | to embeddings  |     | to get  |
|        |     |            | -1.3 | -0.8 | 0.1       | 2.5  | 2.6  | -1.5 |        |     |                |     |         |
|        |     |            |      |      |           |      |      |      |        |     | new position   |     | based   |
embeddings
| the  |      | food |     |     | was  |     |     | good |     | not  |     | bad   |     |
| ---- | ---- | ---- | --- | --- | ---- | --- | --- | ---- | --- | ---- | --- | ----- | --- |
|      | +0   |      | +1  |     |      | +2  |     |      | +3  |      | +4  |       | +5  |
| -0.2 | -0.2 | -0.2 | 0.8 |     | -1.1 | 0.9 |     | 3.2  | 6.2 | -0.2 | 3.8 | -0.30 | 4.7 |
| -1.7 | -1.7 | 0.9  | 1.9 |     | -0.9 | 1.1 |     | 3.7  | 6.7 | -0.5 | 3.5 | 1.00  | 6.0 |
| -0.2 | -0.2 | -0.5 | 0.5 |     | 0.3  | 2.3 |     | 2.6  | 5.6 | 0.3  | 4.3 | -2.20 | 2.8 |
| -1.3 | -1.3 | -0.8 | 0.2 |     | 0.1  | 2.1 |     | 2.5  | 5.5 | 2.6  | 6.6 | -1.50 | 3.5 |

| Adding |     | Positional |      |      | encodings |      |      |      | - idea |     |          |        |          |          |        |       |     |            |        |     |
| ------ | --- | ---------- | ---- | ---- | --------- | ---- | ---- | ---- | ------ | --- | -------- | ------ | -------- | -------- | ------ | ----- | --- | ---------- | ------ | --- |
|        |     |            |      |      |           |      |      |      |        | •   | This     | method |          | doesn’t  |        | work. |     |            |        |     |
|        |     |            |      |      |           |      |      |      |        | •   | If the   | number |          | of       | words  |       | are | too        | many   |     |
|        |     |            | the  | food | was       | good | not  | bad  |        |     |          |        |          |          |        |       |     |            |        |     |
|        |     |            |      |      |           |      |      |      |        |     | inside   | a      | sequence |          | then   |       | we  | will       | have   |     |
|        |     |            | 0    | 1    | 2         | 3    | 4    | 5    |        |     | very     | large  | values.  |          |        |       |     |            |        |     |
|        |     |            |      |      |           |      |      |      |        | •   | If there |        | are      | 50 words |        | in    | a   | sentence,  |        |     |
|        |     |            | -0.2 | -0.2 | -1.1      | 3.2  | -0.2 | -0.3 |        |     |          |        |          |          |        |       |     |            |        |     |
|        |     |            |      |      |           |      |      |      |        |     | then     | we     | will     | be       | adding |       | 50  | to the     | final  |     |
|        |     |            | -1.7 | 0.9  | -0.9      | 3.7  | -0.5 | 1.0  |        |     |          |        |          |          |        |       |     |            |        |     |
word.
|      |      |      | -0.2 | -0.5 | 0.3  | 2.6 | 0.3 | -2.2 |     |     |            |      |            |     |          |     |     |          |     |      |
| ---- | ---- | ---- | ---- | ---- | ---- | --- | --- | ---- | --- | --- | ---------- | ---- | ---------- | --- | -------- | --- | --- | -------- | --- | ---- |
|      |      |      |      |      |      |     |     |      |     | •   | We         | need | a slightly |     | modified |     |     | function |     | for  |
|      |      |      | -1.3 | -0.8 | 0.1  | 2.5 | 2.6 | -1.5 |     |     |            |      |            |     |          |     |     |          |     |      |
|      |      |      |      |      |      |     |     |      |     |     | positional |      | encodings. |     |          |     |     |          |     |      |
| the  |      | food |      |      | was  |     |     | good |     |     | not        |      |            |     |          | bad |     |          |     |      |
|      | +0   |      | +1   |      |      | +2  |     |      | +3  |     |            | +4   |            |     |          |     | +5  |          |     |      |
| -0.2 | -0.2 | -0.2 | 0.8  |      | -1.1 | 0.9 |     | 3.2  | 6.2 |     | -0.2       | 3.8  |            |     | -0.30    |     | 4.7 |          |     |      |
| -1.7 | -1.7 | 0.9  | 1.9  |      | -0.9 | 1.1 |     | 3.7  | 6.7 |     | -0.5       | 3.5  |            |     | 1.00     |     | 6.0 |          |     |      |
| -0.2 | -0.2 | -0.5 | 0.5  |      | 0.3  | 2.3 |     | 2.6  | 5.6 |     | 0.3        | 4.3  |            |     | -2.20    |     | 2.8 |          |     |      |
| -1.3 | -1.3 | -0.8 | 0.2  |      | 0.1  | 2.1 |     | 2.5  | 5.5 |     | 2.6        | 6.6  |            |     | -1.50    |     | 3.5 |          |     |      |

| New | formula |     |      | Positional |      |      |      | encodings |     |     |            |          |     |     |
| --- | ------- | --- | ---- | ---------- | ---- | ---- | ---- | --------- | --- | --- | ---------- | -------- | --- | --- |
|     |         |     | the  | food       | was  | good | not  | bad       |     |     |            |          |     |     |
|     |         |     |      |            |      |      |      |           |     |     | 𝑃𝑜𝑠𝑖𝑡𝑖𝑜𝑛𝑎𝑙 | 𝐸𝑛𝑐𝑜𝑑𝑖𝑛𝑔 |     |     |
|     |         | pos | 0    | 1          | 2    | 3    | 4    | 5         |     |     |            |          | 𝑝𝑜𝑠 |     |
|     |         |     |      |            |      |      |      |           |     | 𝑃𝐸  | 𝑝𝑜𝑠,2𝑖     | = sin    |     |     |
|     |         |     | -0.2 | -0.2       | -1.1 | 3.2  | -0.2 | -0.3      |     |     |            |          |     | 2𝑖  |
10000
𝑑
|      |     |      | -1.7 | 0.9  | -0.9 | 3.7 | -0.5 | 1.0  |     |      |     |       |     |     |
| ---- | --- | ---- | ---- | ---- | ---- | --- | ---- | ---- | --- | ---- | --- | ----- | --- | --- |
|      |     |      | -0.2 | -0.5 | 0.3  | 2.6 | 0.3  | -2.2 |     |      |     |       |     |     |
|      |     |      | -1.3 | -0.8 | 0.1  | 2.5 | 2.6  | -1.5 |     |      |     |       |     |     |
| the  |     | food |      |      | was  |     |      | good |     | not  |     | bad   |     |     |
| -0.2 | ?   | -0.2 | ?    |      | -1.1 | ?   |      | 3.2  | ?   | -0.2 | ?   | -0.30 | ?   |     |
| -1.7 | ?   | 0.9  | ?    |      | -0.9 | ?   |      | 3.7  | ?   | -0.5 | ?   | 1.00  | ?   |     |
| -0.2 | ?   | -0.5 | ?    |      | 0.3  | ?   |      | 2.6  | ?   | 0.3  | ?   | -2.20 | ?   |     |
| -1.3 | ?   | -0.8 | ?    |      | 0.1  | ?   |      | 2.5  | ?   | 2.6  | ?   | -1.50 | ?   |     |

| New | formula |     |      | Positional |      |      |      | encodings |     |     |            |          |     |     |
| --- | ------- | --- | ---- | ---------- | ---- | ---- | ---- | --------- | --- | --- | ---------- | -------- | --- | --- |
|     |         |     | the  | food       | was  | good | not  | bad       |     |     |            |          |     |     |
|     |         |     |      |            |      |      |      |           |     |     | 𝑃𝑜𝑠𝑖𝑡𝑖𝑜𝑛𝑎𝑙 | 𝐸𝑛𝑐𝑜𝑑𝑖𝑛𝑔 |     |     |
|     |         | pos | 0    | 1          | 2    | 3    | 4    | 5         |     |     |            |          | 𝑝𝑜𝑠 |     |
|     |         |     |      |            |      |      |      |           |     | 𝑃𝐸  | 𝑝𝑜𝑠,2𝑖     | = sin    |     |     |
|     |         |     | -0.2 | -0.2       | -1.1 | 3.2  | -0.2 | -0.3      |     |     |            |          |     | 2𝑖  |
10000
𝑑
|      |     |      | -1.7 | 0.9  | -0.9 | 3.7 | -0.5 | 1.0  |     |      |     |       |     |     |
| ---- | --- | ---- | ---- | ---- | ---- | --- | ---- | ---- | --- | ---- | --- | ----- | --- | --- |
|      |     |      | -0.2 | -0.5 | 0.3  | 2.6 | 0.3  | -2.2 |     |      |     |       |     |     |
|      |     |      | -1.3 | -0.8 | 0.1  | 2.5 | 2.6  | -1.5 |     |      |     |       |     |     |
| the  |     | food |      |      | was  |     |      | good |     | not  |     | bad   |     |     |
| -0.2 | ?   | -0.2 | ?    |      | -1.1 | ?   |      | 3.2  | ?   | -0.2 | ?   | -0.30 | ?   |     |
| -1.7 | ?   | 0.9  | ?    |      | -0.9 | ?   |      | 3.7  | ?   | -0.5 | ?   | 1.00  | ?   |     |
| -0.2 | ?   | -0.5 | ?    |      | 0.3  | ?   |      | 2.6  | ?   | 0.3  | ?   | -2.20 | ?   |     |
| -1.3 | ?   | -0.8 | ?    |      | 0.1  | ?   |      | 2.5  | ?   | 2.6  | ?   | -1.50 | ?   |     |

| New | formula |     |     | Positional |     |     |     | encodings |     |     |            |     |     |          |     |
| --- | ------- | --- | --- | ---------- | --- | --- | --- | --------- | --- | --- | ---------- | --- | --- | -------- | --- |
|     |         |     |     |            |     |     |     |           |     |     | 𝑃𝑜𝑠𝑖𝑡𝑖𝑜𝑛𝑎𝑙 |     |     | 𝐸𝑛𝑐𝑜𝑑𝑖𝑛𝑔 |     |
𝑝𝑜𝑠
|     |     |     |     |     |     |     |     |     |     |     | 𝑃𝐸 𝑝𝑜𝑠, | 2𝑖  | =   | sin |     |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ------- | --- | --- | --- | --- |
2𝑖
|      |     |      | the  | food | was  | good | not  | bad  |     |        |             |                |        |       |         |
| ---- | --- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | --- | ------ | ----------- | -------------- | ------ | ----- | ------- |
|      |     |      |      |      |      |      |      |      |     |        |             |                |        | 10000 | 𝑑       |
|      |     | pos  | 0    | 1    | 2    | 3    | 4    | 5    |     |        |             |                |        |       |         |
|      |     |      |      |      |      |      |      |      |     | In our | example     |                |        |       |         |
|      |     | i=0  | -0.2 | -0.2 | -1.1 | 3.2  | -0.2 | -0.3 |     |        |             |                |        |       |         |
|      |     |      |      |      |      |      |      |      |     | •      | 𝑑 – is the  | dimensionality |        |       | of the  |
|      |     | i=1  | -1.7 | 0.9  | -0.9 | 3.7  | -0.5 | 1.0  |     |        |             |                |        |       |         |
|      |     |      |      |      |      |      |      |      |     |        | embeddings  |                | ; d=4  | here  |         |
|      |     | i=2  | -0.2 | -0.5 | 0.3  | 2.6  | 0.3  | -2.2 |     |        |             |                |        |       |         |
|      |     |      |      |      |      |      |      |      |     | •      | 𝑖 – runs    | from           | 0 to   | 3     |         |
|      |     | i=3  | -1.3 | -0.8 | 0.1  | 2.5  | 2.6  | -1.5 |     |        |             |                |        |       |         |
|      |     |      |      |      |      |      |      |      |     | •      | 𝑝𝑜𝑠 – Takes |                | values | 0 to  | 5       |
| the  |     | food |      |      | was  |      |      | good |     | not    |             |                | bad    |       |         |
| -0.2 | ?   | -0.2 | ?    |      | -1.1 | ?    |      | 3.2  | ?   | -0.2   | ?           |                | -0.30  | ?     |         |
| -1.7 | ?   | 0.9  | ?    |      | -0.9 | ?    |      | 3.7  | ?   | -0.5   | ?           |                | 1.00   | ?     |         |
| -0.2 | ?   | -0.5 | ?    |      | 0.3  | ?    |      | 2.6  | ?   | 0.3    | ?           |                | -2.20  | ?     |         |
| -1.3 | ?   | -0.8 | ?    |      | 0.1  | ?    |      | 2.5  | ?   | 2.6    | ?           |                | -1.50  | ?     |         |

|     | Positional |     |         |     |     | encodings |     |     |     | -   | Calculation |     |     |     |     |            |     |     |          |     |     |
| --- | ---------- | --- | ------- | --- | --- | --------- | --- | --- | --- | --- | ----------- | --- | --- | --- | --- | ---------- | --- | --- | -------- | --- | --- |
|     | 𝑝𝑜𝑠 =      | 0   | ; 𝑖 = 0 | ; 𝑑 | = 4 |           |     |     |     |     |             |     |     |     |     |            |     |     |          |     |     |
|     |            |     |         |     |     |           |     |     |     |     |             |     |     |     |     | 𝑃𝑜𝑠𝑖𝑡𝑖𝑜𝑛𝑎𝑙 |     |     | 𝐸𝑛𝑐𝑜𝑑𝑖𝑛𝑔 |     |     |
0
| 𝑃𝐸(0,0) |     | =   | sin |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     | 𝑝𝑜𝑠 |
| ------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
2∗0
|     |     |     |       |     |     |     |      |      |      |      |      |      |     |     |     | 𝑃𝐸 𝑝𝑜𝑠,  | 2𝑖             | =   | sin |       |         |
| --- | --- | --- | ----- | --- | --- | --- | ---- | ---- | ---- | ---- | ---- | ---- | --- | --- | --- | -------- | -------------- | --- | --- | ----- | ------- |
|     |     |     | 10000 |     | 4   |     |      |      |      |      |      |      |     |     |     |          |                |     |     |       | 2𝑖      |
|     |     |     |       |     |     |     | the  | food | was  | good | not  | bad  |     |     |     |          |                |     |     |       |         |
|     |     |     |       |     |     |     |      |      |      |      |      |      |     |     |     |          |                |     |     | 10000 | 𝑑       |
|     |     |     |       |     | pos |     | 0    | 1    | 2    | 3    | 4    | 5    |     |     |     |          |                |     |     |       |         |
|     |     |     |       |     |     |     |      |      |      |      |      |      |     | In  | our | example  |                |     |     |       |         |
|     |     |     |       |     | i=0 |     | -0.2 | -0.2 | -1.1 | 3.2  | -0.2 | -0.3 |     |     |     |          |                |     |     |       |         |
|     |     |     |       |     |     |     |      |      |      |      |      |      |     | •   | 𝑑   | – is the | dimensionality |     |     |       | of the  |
i=1
|     |     |     |     |     |     |     | -1.7 | 0.9 | -0.9 | 3.7 | -0.5 | 1.0 |     |     |            |     |     |     |          |     |     |
| --- | --- | --- | --- | --- | --- | --- | ---- | --- | ---- | --- | ---- | --- | --- | --- | ---------- | --- | --- | --- | -------- | --- | --- |
|     |     |     |     |     |     |     |      |     |      |     |      |     |     |     | embeddings |     |     | ;   | d=4 here |     |     |
i=2
|     |      |     |     |     |      |     | -0.2 | -0.5 | 0.3  | 2.6 | 0.3 | -2.2 |     |     |      |         |      |        |       |     |     |
| --- | ---- | --- | --- | --- | ---- | --- | ---- | ---- | ---- | --- | --- | ---- | --- | --- | ---- | ------- | ---- | ------ | ----- | --- | --- |
|     |      |     |     |     |      |     |      |      |      |     |     |      |     | •   | 𝑖    | – runs  | from | 0      | to 3  |     |     |
|     |      |     |     |     | i=3  |     | -1.3 | -0.8 | 0.1  | 2.5 | 2.6 | -1.5 |     |     |      |         |      |        |       |     |     |
|     |      |     |     |     |      |     |      |      |      |     |     |      |     | •   | 𝑝𝑜𝑠  | – Takes |      | values | 0     | to  | 5   |
|     | the  |     |     |     | food |     |      |      | was  |     |     | good |     |     | not  |         |      |        | bad   |     |     |
|     | -0.2 |     | 0   |     | -0.2 |     | ?    |      | -1.1 | ?   |     | 3.2  | ?   |     | -0.2 | ?       |      |        | -0.30 | ?   |     |
|     | -1.7 |     |     |     | 0.9  |     | ?    |      | -0.9 | ?   |     | 3.7  | ?   |     | -0.5 | ?       |      |        | 1.00  | ?   |     |
|     | -0.2 |     |     |     | -0.5 |     | ?    |      | 0.3  | ?   |     | 2.6  | ?   |     | 0.3  | ?       |      |        | -2.20 | ?   |     |
|     | -1.3 |     |     |     | -0.8 |     | ?    |      | 0.1  | ?   |     | 2.5  | ?   |     | 2.6  | ?       |      |        | -1.50 | ?   |     |

|     | Positional |     |         |     |     | encodings |     |     |     | -   | Calculation |     |     |     |     |            |     |     |          |     |     |
| --- | ---------- | --- | ------- | --- | --- | --------- | --- | --- | --- | --- | ----------- | --- | --- | --- | --- | ---------- | --- | --- | -------- | --- | --- |
|     | 𝑝𝑜𝑠        | = 0 | ; 𝑖 = 1 | ; 𝑑 | = 4 |           |     |     |     |     |             |     |     |     |     |            |     |     |          |     |     |
|     |            |     |         |     |     |           |     |     |     |     |             |     |     |     |     | 𝑃𝑜𝑠𝑖𝑡𝑖𝑜𝑛𝑎𝑙 |     |     | 𝐸𝑛𝑐𝑜𝑑𝑖𝑛𝑔 |     |     |
0
| 𝑃𝐸(0,1) |     | =   | sin |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     | 𝑝𝑜𝑠 |
| ------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
2∗0.5
|     |     |     |       |     |     |     |      |      |      |      |      |      |     |     |     | 𝑃𝐸 𝑝𝑜𝑠,  | 2𝑖             | =   | sin |       |         |
| --- | --- | --- | ----- | --- | --- | --- | ---- | ---- | ---- | ---- | ---- | ---- | --- | --- | --- | -------- | -------------- | --- | --- | ----- | ------- |
|     |     |     | 10000 |     | 4   |     |      |      |      |      |      |      |     |     |     |          |                |     |     |       | 2𝑖      |
|     |     |     |       |     |     |     | the  | food | was  | good | not  | bad  |     |     |     |          |                |     |     |       |         |
|     |     |     |       |     |     |     |      |      |      |      |      |      |     |     |     |          |                |     |     | 10000 | 𝑑       |
|     |     |     |       |     | pos |     | 0    | 1    | 2    | 3    | 4    | 5    |     |     |     |          |                |     |     |       |         |
|     |     |     |       |     |     |     |      |      |      |      |      |      |     | In  | our | example  |                |     |     |       |         |
|     |     |     |       |     | i=0 |     | -0.2 | -0.2 | -1.1 | 3.2  | -0.2 | -0.3 |     |     |     |          |                |     |     |       |         |
|     |     |     |       |     |     |     |      |      |      |      |      |      |     | •   | 𝑑   | – is the | dimensionality |     |     |       | of the  |
i=1
|     |     |     |     |     |     |     | -1.7 | 0.9 | -0.9 | 3.7 | -0.5 | 1.0 |     |     |            |     |     |     |          |     |     |
| --- | --- | --- | --- | --- | --- | --- | ---- | --- | ---- | --- | ---- | --- | --- | --- | ---------- | --- | --- | --- | -------- | --- | --- |
|     |     |     |     |     |     |     |      |     |      |     |      |     |     |     | embeddings |     |     | ;   | d=4 here |     |     |
i=2
|     |      |     |     |     |      |     | -0.2 | -0.5 | 0.3  | 2.6 | 0.3 | -2.2 |     |     |      |         |      |        |       |     |     |
| --- | ---- | --- | --- | --- | ---- | --- | ---- | ---- | ---- | --- | --- | ---- | --- | --- | ---- | ------- | ---- | ------ | ----- | --- | --- |
|     |      |     |     |     |      |     |      |      |      |     |     |      |     | •   | 𝑖    | – runs  | from | 0      | to 3  |     |     |
|     |      |     |     |     | i=3  |     | -1.3 | -0.8 | 0.1  | 2.5 | 2.6 | -1.5 |     |     |      |         |      |        |       |     |     |
|     |      |     |     |     |      |     |      |      |      |     |     |      |     | •   | 𝑝𝑜𝑠  | – Takes |      | values | 0     | to  | 5   |
|     | the  |     |     |     | food |     |      |      | was  |     |     | good |     |     | not  |         |      |        | bad   |     |     |
|     | -0.2 |     | 0   |     | -0.2 |     | ?    |      | -1.1 | ?   |     | 3.2  | ?   |     | -0.2 | ?       |      |        | -0.30 | ?   |     |
|     | -1.7 |     | 0   |     | 0.9  |     | ?    |      | -0.9 | ?   |     | 3.7  | ?   |     | -0.5 | ?       |      |        | 1.00  | ?   |     |
|     | -0.2 |     |     |     | -0.5 |     | ?    |      | 0.3  | ?   |     | 2.6  | ?   |     | 0.3  | ?       |      |        | -2.20 | ?   |     |
|     | -1.3 |     |     |     | -0.8 |     | ?    |      | 0.1  | ?   |     | 2.5  | ?   |     | 2.6  | ?       |      |        | -1.50 | ?   |     |

| Positional |           |     |     | encodings |     |     |     | -   | Calculation |     |     |     |     |            |     |     |          |     |     |
| ---------- | --------- | --- | --- | --------- | --- | --- | --- | --- | ----------- | --- | --- | --- | --- | ---------- | --- | --- | -------- | --- | --- |
| 𝑝𝑜𝑠 =      | 1 ; 𝑖 = 0 | ; 𝑑 | = 4 |           |     |     |     |     |             |     |     |     |     |            |     |     |          |     |     |
|            |           |     |     |           |     |     |     |     |             |     |     |     |     | 𝑃𝑜𝑠𝑖𝑡𝑖𝑜𝑛𝑎𝑙 |     |     | 𝐸𝑛𝑐𝑜𝑑𝑖𝑛𝑔 |     |     |
1
| 𝑃𝐸(1,0) | = sin |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     | 𝑝𝑜𝑠 |
| ------- | ----- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
0
|     |     |        |     |      |      |      |      |      |      |      |     |        | 𝑃𝐸         | 𝑝𝑜𝑠,    | 2𝑖             | =     | sin  |       |         |
| --- | --- | ------ | --- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | --- | ------ | ---------- | ------- | -------------- | ----- | ---- | ----- | ------- |
|     |     | 100004 |     |      |      |      |      |      |      |      |     |        |            |         |                |       |      |       | 2𝑖      |
|     |     |        |     |      | the  | food | was  | good | not  | bad  |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     |        |            |         |                |       |      | 10000 | 𝑑       |
|     |     |        | pos |      | 0    | 1    | 2    | 3    | 4    | 5    |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     | In our |            | example |                |       |      |       |         |
|     |     |        |     | i=0  | -0.2 | -0.2 | -1.1 | 3.2  | -0.2 | -0.3 |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     | •      | 𝑑 –        | is the  | dimensionality |       |      |       | of the  |
|     |     |        |     | i=1  | -1.7 | 0.9  | -0.9 | 3.7  | -0.5 | 1.0  |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     |        | embeddings |         |                | ; d=4 | here |       |         |
|     |     |        |     |      | -0.2 | -0.5 | 0.3  | 2.6  | 0.3  | -2.2 |     |        |            |         |                |       |      |       |         |
i=2
|      |     |     |      |     |      |      |      |     |     |      |     | •    | 𝑖 – runs |         | from | 0 to   | 3   |     |     |
| ---- | --- | --- | ---- | --- | ---- | ---- | ---- | --- | --- | ---- | --- | ---- | -------- | ------- | ---- | ------ | --- | --- | --- |
|      |     |     |      | i=3 | -1.3 | -0.8 | 0.1  | 2.5 | 2.6 | -1.5 |     |      |          |         |      |        |     |     |     |
|      |     |     |      |     |      |      |      |     |     |      |     | •    | 𝑝𝑜𝑠      | – Takes |      | values | 0   | to  | 5   |
| the  |     |     | food |     |      |      | was  |     |     | good |     | not  |          |         |      | bad    |     |     |     |
| -0.2 | 0   |     | -0.2 |     | 0.84 |      | -1.1 | ?   |     | 3.2  | ?   | -0.2 |          | ?       |      | -0.30  |     | ?   |     |
| -1.7 | 0   |     | 0.9  |     | ?    |      | -0.9 | ?   |     | 3.7  | ?   | -0.5 |          | ?       |      | 1.00   |     | ?   |     |
| -0.2 | 0   |     | -0.5 |     | ?    |      | 0.3  | ?   |     | 2.6  | ?   | 0.3  |          | ?       |      | -2.20  |     | ?   |     |
| -1.3 | 0   |     | -0.8 |     | ?    |      | 0.1  | ?   |     | 2.5  | ?   | 2.6  |          | ?       |      | -1.50  |     | ?   |     |

| Positional |           |     |     | encodings |     |     |     | -   | Calculation |     |     |     |     |            |     |     |          |     |     |
| ---------- | --------- | --- | --- | --------- | --- | --- | --- | --- | ----------- | --- | --- | --- | --- | ---------- | --- | --- | -------- | --- | --- |
| 𝑝𝑜𝑠 =      | 1 ; 𝑖 = 1 | ; 𝑑 | = 4 |           |     |     |     |     |             |     |     |     |     |            |     |     |          |     |     |
|            |           |     |     |           |     |     |     |     |             |     |     |     |     | 𝑃𝑜𝑠𝑖𝑡𝑖𝑜𝑛𝑎𝑙 |     |     | 𝐸𝑛𝑐𝑜𝑑𝑖𝑛𝑔 |     |     |
1
| 𝑃𝐸(1,1) | = sin |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     | 𝑝𝑜𝑠 |
| ------- | ----- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
1
|     |     |        |     |      |      |      |      |      |      |      |     |        | 𝑃𝐸         | 𝑝𝑜𝑠,    | 2𝑖             | =     | sin  |       |         |
| --- | --- | ------ | --- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | --- | ------ | ---------- | ------- | -------------- | ----- | ---- | ----- | ------- |
|     |     | 100004 |     |      |      |      |      |      |      |      |     |        |            |         |                |       |      |       | 2𝑖      |
|     |     |        |     |      | the  | food | was  | good | not  | bad  |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     |        |            |         |                |       |      | 10000 | 𝑑       |
|     |     |        | pos |      | 0    | 1    | 2    | 3    | 4    | 5    |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     | In our |            | example |                |       |      |       |         |
|     |     |        |     | i=0  | -0.2 | -0.2 | -1.1 | 3.2  | -0.2 | -0.3 |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     | •      | 𝑑 –        | is the  | dimensionality |       |      |       | of the  |
|     |     |        |     | i=1  | -1.7 | 0.9  | -0.9 | 3.7  | -0.5 | 1.0  |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     |        | embeddings |         |                | ; d=4 | here |       |         |
|     |     |        |     |      | -0.2 | -0.5 | 0.3  | 2.6  | 0.3  | -2.2 |     |        |            |         |                |       |      |       |         |
i=2
|      |     |     |      |     |      |      |      |     |     |      |     | •    | 𝑖 – runs |         | from | 0 to   | 3   |     |     |
| ---- | --- | --- | ---- | --- | ---- | ---- | ---- | --- | --- | ---- | --- | ---- | -------- | ------- | ---- | ------ | --- | --- | --- |
|      |     |     |      | i=3 | -1.3 | -0.8 | 0.1  | 2.5 | 2.6 | -1.5 |     |      |          |         |      |        |     |     |     |
|      |     |     |      |     |      |      |      |     |     |      |     | •    | 𝑝𝑜𝑠      | – Takes |      | values | 0   | to  | 5   |
| the  |     |     | food |     |      |      | was  |     |     | good |     | not  |          |         |      | bad    |     |     |     |
| -0.2 | 0   |     | -0.2 |     | 0.84 |      | -1.1 | ?   |     | 3.2  | ?   | -0.2 |          | ?       |      | -0.30  |     | ?   |     |
| -1.7 | 0   |     | 0.9  |     | 0.10 |      | -0.9 | ?   |     | 3.7  | ?   | -0.5 |          | ?       |      | 1.00   |     | ?   |     |
| -0.2 | 0   |     | -0.5 |     | ?    |      | 0.3  | ?   |     | 2.6  | ?   | 0.3  |          | ?       |      | -2.20  |     | ?   |     |
| -1.3 | 0   |     | -0.8 |     | ?    |      | 0.1  | ?   |     | 2.5  | ?   | 2.6  |          | ?       |      | -1.50  |     | ?   |     |

| Positional |           |     |     | encodings |     |     |     | -   | Calculation |     |     |     |     |            |     |     |          |     |     |
| ---------- | --------- | --- | --- | --------- | --- | --- | --- | --- | ----------- | --- | --- | --- | --- | ---------- | --- | --- | -------- | --- | --- |
| 𝑝𝑜𝑠 =      | 1 ; 𝑖 = 2 | ; 𝑑 | = 4 |           |     |     |     |     |             |     |     |     |     |            |     |     |          |     |     |
|            |           |     |     |           |     |     |     |     |             |     |     |     |     | 𝑃𝑜𝑠𝑖𝑡𝑖𝑜𝑛𝑎𝑙 |     |     | 𝐸𝑛𝑐𝑜𝑑𝑖𝑛𝑔 |     |     |
1
| 𝑃𝐸(1,2) | = sin |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     | 𝑝𝑜𝑠 |
| ------- | ----- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
2
|     |     |        |     |      |      |      |      |      |      |      |     |        | 𝑃𝐸         | 𝑝𝑜𝑠,    | 2𝑖             | =     | sin  |       |         |
| --- | --- | ------ | --- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | --- | ------ | ---------- | ------- | -------------- | ----- | ---- | ----- | ------- |
|     |     | 100004 |     |      |      |      |      |      |      |      |     |        |            |         |                |       |      |       | 2𝑖      |
|     |     |        |     |      | the  | food | was  | good | not  | bad  |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     |        |            |         |                |       |      | 10000 | 𝑑       |
|     |     |        | pos |      | 0    | 1    | 2    | 3    | 4    | 5    |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     | In our |            | example |                |       |      |       |         |
|     |     |        |     | i=0  | -0.2 | -0.2 | -1.1 | 3.2  | -0.2 | -0.3 |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     | •      | 𝑑 –        | is the  | dimensionality |       |      |       | of the  |
|     |     |        |     | i=1  | -1.7 | 0.9  | -0.9 | 3.7  | -0.5 | 1.0  |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     |        | embeddings |         |                | ; d=4 | here |       |         |
|     |     |        |     |      | -0.2 | -0.5 | 0.3  | 2.6  | 0.3  | -2.2 |     |        |            |         |                |       |      |       |         |
i=2
|      |     |     |      |     |      |      |      |     |     |      |     | •    | 𝑖 – runs |         | from | 0 to   | 3   |     |     |
| ---- | --- | --- | ---- | --- | ---- | ---- | ---- | --- | --- | ---- | --- | ---- | -------- | ------- | ---- | ------ | --- | --- | --- |
|      |     |     |      | i=3 | -1.3 | -0.8 | 0.1  | 2.5 | 2.6 | -1.5 |     |      |          |         |      |        |     |     |     |
|      |     |     |      |     |      |      |      |     |     |      |     | •    | 𝑝𝑜𝑠      | – Takes |      | values | 0   | to  | 5   |
| the  |     |     | food |     |      |      | was  |     |     | good |     | not  |          |         |      | bad    |     |     |     |
| -0.2 | 0   |     | -0.2 |     | 0.84 |      | -1.1 | ?   |     | 3.2  | ?   | -0.2 |          | ?       |      | -0.30  |     | ?   |     |
| -1.7 | 0   |     |      | 0.9 | 0.10 |      | -0.9 | ?   |     | 3.7  | ?   | -0.5 |          | ?       |      | 1.00   |     | ?   |     |
| -0.2 | 0   |     | -0.5 |     | 0.01 |      | 0.3  | ?   |     | 2.6  | ?   | 0.3  |          | ?       |      | -2.20  |     | ?   |     |
| -1.3 | 0   |     |      |     |      |      | 0.1  | ?   |     | 2.5  | ?   | 2.6  |          | ?       |      | -1.50  |     | ?   |     |
-0.8

| Positional |           |     |     | encodings |     |     |     | -   | Calculation |     |     |     |     |            |     |     |          |     |     |
| ---------- | --------- | --- | --- | --------- | --- | --- | --- | --- | ----------- | --- | --- | --- | --- | ---------- | --- | --- | -------- | --- | --- |
| 𝑝𝑜𝑠 =      | 1 ; 𝑖 = 2 | ; 𝑑 | = 4 |           |     |     |     |     |             |     |     |     |     |            |     |     |          |     |     |
|            |           |     |     |           |     |     |     |     |             |     |     |     |     | 𝑃𝑜𝑠𝑖𝑡𝑖𝑜𝑛𝑎𝑙 |     |     | 𝐸𝑛𝑐𝑜𝑑𝑖𝑛𝑔 |     |     |
1
| 𝑃𝐸(1,2) | = sin |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     | 𝑝𝑜𝑠 |
| ------- | ----- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
2
|     |     |        |     |      |      |      |      |      |      |      |     |        | 𝑃𝐸         | 𝑝𝑜𝑠,    | 2𝑖             | =     | sin  |       |         |
| --- | --- | ------ | --- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | --- | ------ | ---------- | ------- | -------------- | ----- | ---- | ----- | ------- |
|     |     | 100004 |     |      |      |      |      |      |      |      |     |        |            |         |                |       |      |       | 2𝑖      |
|     |     |        |     |      | the  | food | was  | good | not  | bad  |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     |        |            |         |                |       |      | 10000 | 𝑑       |
|     |     |        | pos |      | 0    | 1    | 2    | 3    | 4    | 5    |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     | In our |            | example |                |       |      |       |         |
|     |     |        |     | i=0  | -0.2 | -0.2 | -1.1 | 3.2  | -0.2 | -0.3 |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     | •      | 𝑑 –        | is the  | dimensionality |       |      |       | of the  |
|     |     |        |     | i=1  | -1.7 | 0.9  | -0.9 | 3.7  | -0.5 | 1.0  |     |        |            |         |                |       |      |       |         |
|     |     |        |     |      |      |      |      |      |      |      |     |        | embeddings |         |                | ; d=4 | here |       |         |
|     |     |        |     |      | -0.2 | -0.5 | 0.3  | 2.6  | 0.3  | -2.2 |     |        |            |         |                |       |      |       |         |
i=2
|      |     |     |      |     |      |      |      |     |     |      |     | •    | 𝑖 – runs |         | from | 0 to   | 3   |     |     |
| ---- | --- | --- | ---- | --- | ---- | ---- | ---- | --- | --- | ---- | --- | ---- | -------- | ------- | ---- | ------ | --- | --- | --- |
|      |     |     |      | i=3 | -1.3 | -0.8 | 0.1  | 2.5 | 2.6 | -1.5 |     |      |          |         |      |        |     |     |     |
|      |     |     |      |     |      |      |      |     |     |      |     | •    | 𝑝𝑜𝑠      | – Takes |      | values | 0   | to  | 5   |
| the  |     |     | food |     |      |      | was  |     |     | good |     | not  |          |         |      | bad    |     |     |     |
| -0.2 | 0   |     | -0.2 |     | 0.84 |      | -1.1 | ?   |     | 3.2  | ?   | -0.2 |          | ?       |      | -0.30  |     | ?   |     |
| -1.7 | 0   |     |      | 0.9 | 0.10 |      | -0.9 | ?   |     | 3.7  | ?   | -0.5 |          | ?       |      | 1.00   |     | ?   |     |
| -0.2 | 0   |     | -0.5 |     | 0.01 |      | 0.3  | ?   |     | 2.6  | ?   | 0.3  |          | ?       |      | -2.20  |     | ?   |     |
| -1.3 | 0   |     |      |     |      |      | 0.1  | ?   |     | 2.5  | ?   | 2.6  |          | ?       |      | -1.50  |     | ?   |     |
-0.8

|      | Positional |      |      | encodings |      |     | - Calculation |     |     |            |           |      |
| ---- | ---------- | ---- | ---- | --------- | ---- | --- | ------------- | --- | --- | ---------- | --------- | ---- |
| the  | food       | was  | good | not       | bad  |     |               |     |     |            |           |      |
|      |            |      |      |           |      |     |               |     |     | Positional | encodings | for  |
| -0.2 | -0.2       | -1.1 | 3.2  | -0.2      | -0.3 |     |               |     |     |            |           |      |
|      |            |      |      |           |      |     |               |     |     | all the    | words     | in   |
| -1.7 | 0.9        | -0.9 | 3.7  | -0.5      | 1.0  |     |               |     |     |            |           |      |
sentence-1
| -0.2 | -0.5 | 0.3 | 2.6  | 0.3 | -2.2 |     |     |      |     |     |     |     |
| ---- | ---- | --- | ---- | --- | ---- | --- | --- | ---- | --- | --- | --- | --- |
| -1.3 | -0.8 | 0.1 | 2.5  | 2.6 | -1.5 |     |     |      |     |     |     |     |
| the  |      |     | food |     |      | was |     | good | not |     | bad |     |
-0.2 0 -0.2 0.84 -1.1 0.909 3.2 0.141 -0.2 -0.288 -0.30 0.913
| -1.7 | 0   |     | 0.9 | 0.100 |     | -0.9 0.199 |     | 3.7 0.296 | -0.5 | 0.002 | 1.00 | 0.002 |
| ---- | --- | --- | --- | ----- | --- | ---------- | --- | --------- | ---- | ----- | ---- | ----- |
0
| -0.2 |     |     | -0.5 | 0.010 |     | 0.3 0.020 |     | 2.6 0.030 | 0.3 | 0.000 | -2.20 | 0.000 |
| ---- | --- | --- | ---- | ----- | --- | --------- | --- | --------- | --- | ----- | ----- | ----- |
0
| -1.3 |     |     | -0.8 | 0.001 |     | 0.1 0.002 |     | 2.5 0.003 | 2.6 | 0.000 | -1.50 | 0.000 |
| ---- | --- | --- | ---- | ----- | --- | --------- | --- | --------- | --- | ----- | ----- | ----- |

|     | Embeddings |     |      |     | +   | Positional | encodings |     |      |     |      |     |     |     |
| --- | ---------- | --- | ---- | --- | --- | ---------- | --------- | --- | ---- | --- | ---- | --- | --- | --- |
| the | food       | was | good | not | bad |            |           | the | food | was | good | not | bad |     |
| 0   | 1          | 2   | 3    | 4   | 5   |            |           | 0   | 1    | 2   | 3    | 4   | 5   |     |
-0.2 -0.2 -1.1 3.2 -0.2 -0.3 Embeddings  -0.2 0.6 -0.2 3.3 -0.5 0.6
updated with
| -1.7 | 0.9 | -0.9 | 3.7 | -0.5 | 1.0 |     |     | -1.7 | 1.0 | -0.7 | 4.0 | -0.5 | 1.0 |     |
| ---- | --- | ---- | --- | ---- | --- | --- | --- | ---- | --- | ---- | --- | ---- | --- | --- |
positional
| -0.2 | -0.5 | 0.3 | 2.6 | 0.3 | -2.2 |     |     | -0.2 | -0.5 | 0.3 | 2.6 | 0.3 | -2.2 |     |
| ---- | ---- | --- | --- | --- | ---- | --- | --- | ---- | ---- | --- | --- | --- | ---- | --- |
encoders
| -1.3 | -0.8 | 0.1 | 2.5  | 2.6 | -1.5 |     |      | -1.3 | -0.8 | 0.1 | 2.5 | 2.6 | -1.5 |     |
| ---- | ---- | --- | ---- | --- | ---- | --- | ---- | ---- | ---- | --- | --- | --- | ---- | --- |
| the  |      |     | food |     |      | was | good |      |      | not |     |     | bad  |     |
-0.2 0 -0.2 0.84 -1.1 0.909 3.2 0.141 -0.2 -0.288 -0.30 0.913
| -1.7 | 0   |     | 0.9 | 0.100 |     | -0.9 0.199 | 3.7 | 0.296 |     | -0.5 | 0.002 |     | 1.00 | 0.002 |
| ---- | --- | --- | --- | ----- | --- | ---------- | --- | ----- | --- | ---- | ----- | --- | ---- | ----- |
0
| -0.2 |     |     | -0.5 | 0.010 |     | 0.3 0.020 | 2.6 | 0.030 |     | 0.3 | 0.000 |     | -2.20 | 0.000 |
| ---- | --- | --- | ---- | ----- | --- | --------- | --- | ----- | --- | --- | ----- | --- | ----- | ----- |
0
| -1.3 |     |     | -0.8 | 0.001 |     | 0.1 0.002 | 2.5 | 0.003 |     | 2.6 | 0.000 |     | -1.50 | 0.000 |
| ---- | --- | --- | ---- | ----- | --- | --------- | --- | ----- | --- | --- | ----- | --- | ----- | ----- |

Sentence-2
| the  | food | was  | bad  | not  | good |     |     | the  | food | was  | bad  | not  | good |
| ---- | ---- | ---- | ---- | ---- | ---- | --- | --- | ---- | ---- | ---- | ---- | ---- | ---- |
| 0    | 1    | 2    | 3    | 4    | 5    |     |     | 0    | 1    | 2    | 3    | 4    | 5    |
| -0.2 | -0.2 | -1.1 | -0.3 | -0.2 | 3.2  |     |     | -0.2 | 0.6  | -0.2 | -0.2 | -0.5 | 4.1  |
| -1.7 | 0.9  | -0.9 | 1.0  | -0.5 | 3.7  |     |     | -1.7 | 1.0  | -0.7 | 1.3  | -0.5 | 3.7  |
| -0.2 | -0.5 | 0.3  | -2.2 | 0.3  | 2.6  |     |     | -0.2 | -0.5 | 0.3  | -2.2 | 0.3  | 2.6  |
| -1.3 | -0.8 | 0.1  | -1.5 | 2.6  | 2.5  |     |     | -1.3 | -0.8 | 0.1  | -1.5 | 2.6  | 2.5  |
| the  |      |      | food |      |      | was | bad |      |      | not  |      |      | good |
-0.2 0.0 -0.2 0.84 -1.1 0.909 -0.3 0.141 -0.2 -0.288 3.2 0.913
| -1.7 | 0.0 |     | 0.9  | 0.100 |     | -0.9 0.199 | 1.0  | 0.296 |     | -0.5 | 0.002 |     | 3.7 0.002 |
| ---- | --- | --- | ---- | ----- | --- | ---------- | ---- | ----- | --- | ---- | ----- | --- | --------- |
| -0.2 | 0.0 |     | -0.5 | 0.010 |     | 0.3 0.020  | -2.2 | 0.030 |     | 0.3  | 0.000 |     | 2.6 0.000 |
| -1.3 | 0.0 |     | -0.8 | 0.001 |     | 0.1 0.002  | -1.5 | 0.003 |     | 2.6  | 0.000 |     | 2.5 0.000 |

| Sentence-1 |     |     |     | vs  | Sentence-2 |     | with | positional |     |     |     |     |     |
| ---------- | --- | --- | --- | --- | ---------- | --- | ---- | ---------- | --- | --- | --- | --- | --- |
encodings
|     |     |     |     |     |     |     | Have | you noticed |     | the difference? |     |     |     |
| --- | --- | --- | --- | --- | --- | --- | ---- | ----------- | --- | --------------- | --- | --- | --- |
Sentence-1
Sentence-2
|     | the  | food | was  | good | not  | bad  |     |      |      |      |      |      |      |
| --- | ---- | ---- | ---- | ---- | ---- | ---- | --- | ---- | ---- | ---- | ---- | ---- | ---- |
|     |      |      |      |      |      |      |     | the  | food | was  | bad  | not  | good |
|     | 0    | 1    | 2    | 3    | 4    | 5    |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | 0    | 1    | 2    | 3    | 4    | 5    |
|     | -0.2 | 0.6  | -0.2 | 3.3  | -0.5 | 0.6  |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | -0.2 | 0.6  | -0.2 | -0.2 | -0.5 | 4.1  |
|     | -1.9 | 1.0  | -0.7 | 4.0  | -0.5 | 1.0  |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | -1.9 | 1.0  | -0.7 | 1.3  | -0.5 | 3.7  |
|     | -1.2 | -0.5 | 0.3  | 2.6  | 0.3  | -2.2 |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | -1.2 | -0.5 | 0.3  | -2.2 | 0.3  | 2.6  |
|     | -1.5 | -0.8 | 0.1  | 2.5  | 2.6  | -1.5 |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | -1.5 | -0.8 | 0.1  | -1.5 | 2.6  | 2.5  |

| Sentence-1 |     |     |     | vs  | Sentence-2 |     | with | positional  |     |     |     |     |     |
| ---------- | --- | --- | --- | --- | ---------- | --- | ---- | ----------- | --- | --- | --- | --- | --- |
encodings
Sentence-1
Sentence-2
|     | the  | food | was  | good | not  | bad  |     |      |      |      |      |      |      |
| --- | ---- | ---- | ---- | ---- | ---- | ---- | --- | ---- | ---- | ---- | ---- | ---- | ---- |
|     |      |      |      |      |      |      |     | the  | food | was  | bad  | not  | good |
|     | 0    | 1    | 2    | 3    | 4    | 5    |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | 0    | 1    | 2    | 3    | 4    | 5    |
|     | -0.2 | 0.6  | -0.2 | 3.3  | -0.5 | 0.6  |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | -0.2 | 0.6  | -0.2 | -0.2 | -0.5 | 4.1  |
|     | -1.9 | 1.0  | -0.7 | 4.0  | -0.5 | 1.0  |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | -1.9 | 1.0  | -0.7 | 1.3  | -0.5 | 3.7  |
|     | -1.2 | -0.5 | 0.3  | 2.6  | 0.3  | -2.2 |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | -1.2 | -0.5 | 0.3  | -2.2 | 0.3  | 2.6  |
|     | -1.5 | -0.8 | 0.1  | 2.5  | 2.6  | -1.5 |     |      |      |      |      |      |      |
|     |      |      |      |      |      |      |     | -1.5 | -0.8 | 0.1  | -1.5 | 2.6  | 2.5  |

| Positional |     |     | encodings |                | - Conclusion |        |       |
| ---------- | --- | --- | --------- | -------------- | ------------ | ------ | ----- |
| •Word2vec  |     |    | numerical | representation |              | of the | words |
•Positional encodings  a numerical representation of the position of
| the | word | in the | original | sentence. |     |     |     |
| --- | ---- | ------ | -------- | --------- | --- | --- | --- |
•Positional encodings – An extra vector to capture the position
| •Both  | Word2Vec |         | and Positional |       | encodings  | are vectors. |         |
| ------ | -------- | ------- | -------------- | ----- | ---------- | ------------ | ------- |
| •These | two      | vectors | are            | added | and passed | on to        | encoder |

| Updated | Seq-to-Seq  |           |        |               |         |
| ------- | ----------- | --------- | ------ | ------------- | ------- |
|         |             |           |        | y , y ,y ,….y |         |
|         |             |           |        | 1 2 3         | t       |
| model   | with        | Attention |        |               |         |
|         |             |           | Output | Layer with    | SoftMax |
|         |             |           |        | Dense Layer   |         |
Multi-Head
Attention
Dense Layer
Multi-Head
Masked Multi-Head
Attention
Attention
Input embeddings
|     |     |     | Output | embeddings |     |
| --- | --- | --- | ------ | ---------- | --- |
X , X ,X ,….X
|     |       |     |     | y , y ,y ,….y |     |
| --- | ----- | --- | --- | ------------- | --- |
| 1   | 2 3 n |     |     |               |     |
|     |       |     |     | 1 2 3         | t-1 |

| Updated | Seq-to-Seq  |           |        |               |         |
| ------- | ----------- | --------- | ------ | ------------- | ------- |
|         |             |           |        | y , y ,y ,….y |         |
|         |             |           |        | 1 2 3         | t       |
| model   | with        | Attention |        |               |         |
|         |             |           | Output | Layer with    | SoftMax |
|         |             |           |        | Dense Layer   |         |
Multi-Head
Attention
Dense Layer
Multi-Head
Masked Multi-Head
Positional
Attention
Attention
encodings
Input embeddings
|     |     |     | Output | embeddings |     |
| --- | --- | --- | ------ | ---------- | --- |
X , X ,X ,….X
|     |       |     |     | y , y ,y ,….y |     |
| --- | ----- | --- | --- | ------------- | --- |
| 1   | 2 3 n |     |     |               |     |
|     |       |     |     | 1 2 3         | t-1 |

| Few    | more |     | practical |         |     | issues | – The | high | risk  |
| ------ | ---- | --- | --------- | ------- | --- | ------ | ----- | ---- | ----- |
| points |      | in  | the       | network |     |        |       |      |       |
•While solving practical problems, DL models would like to have the
| weights |     | near | to zero, |     | both positive |     | and negative. |     |     |
| ------- | --- | ---- | -------- | --- | ------------- | --- | ------------- | --- | --- |
•If not, we have multiple problems like unstable training, vanishing
| gradients, |     | etc., |     |     |     |     |     |     |     |
| ---------- | --- | ----- | --- | --- | --- | --- | --- | --- | --- |
•There are some layers in the that network that may cause significant
| impact |      | on the | gradient |       | calculation. |         |     |     |     |
| ------ | ---- | ------ | -------- | ----- | ------------ | ------- | --- | --- | --- |
| •Lets  | call | them   | the      | “high | risk         | points” |     |     |     |

|         |           |             |        |          |         |        | y , y ,y ,….y |         |
| ------- | --------- | ----------- | ------ | -------- | ------- | ------ | ------------- | ------- |
|         |           |             |        |          |         |        | 1 2 3         | t       |
| The     | high      | risk        | points |          |         |        |               |         |
| • These | are risky | areas       |        |          |         | Output | Layer with    | SoftMax |
| • We    | will have | huge impact | on the | gradient | values  |        |               |         |
Here
| based | on the | calculations | at these | places |     |     |             |     |
| ----- | ------ | ------------ | -------- | ------ | --- | --- | ----------- | --- |
|       |        |              |          |        |     |     | Dense Layer |     |
Here
Here
Multi-Head
Attention
|     | Dense | Layer |     |     |     |     |     |     |
| --- | ----- | ----- | --- | --- | --- | --- | --- | --- |
Here
Here
Multi-Head
Masked Multi-Head
Attention
Attention
|     | Input embeddings |      |     |     |     |        |               |     |
| --- | ---------------- | ---- | --- | --- | --- | ------ | ------------- | --- |
|     |                  |      |     |     |     | Output | embeddings    |     |
|     | X , X ,X         | ,….X |     |     |     |        |               |     |
|     |                  |      |     |     |     |        | y , y ,y ,….y |     |
|     | 1 2              | 3 n  |     |     |     |        |               |     |
|     |                  |      |     |     |     |        | 1 2 3         | t-1 |

| Fixing | the | practical |     | issues |     | – Two |     | steps |
| ------ | --- | --------- | --- | ------ | --- | ----- | --- | ----- |
•We will now add two extra elements to our model seq-to-seq model
architecture to keep the gradient flow smooth and to make the model
| mathematically |                     | convenient | to     | solve | large  | data    | problems. |        |
| -------------- | ------------------- | ---------- | ------ | ----- | ------ | ------- | --------- | ------ |
| 1)             | Residual connection |            |        |       |        |         |           |        |
| 2)             | Normalization       |            |        |       |        |         |           |        |
| •It’s          | a common            | practice   | to use | them  | in any | complex |           | model. |

Encoder
•Input: Token embeddings (with positional encoding).Consists of N stacked layers . Each layer contains:
•Multi-Head Self-Attention: Each token attends to all others, learning dependencies.
•Feedforward Network (FFN): Adds non-linearity and transforms embeddings.
•Residual Connections + Layer Normalization: Preserve information and stabilize training.
•Output: Contextual embeddings for each input token (a rich representation of the source sequence).

| Feedforward |     |     | Network |     | (FFN) |
| ----------- | --- | --- | ------- | --- | ----- |
Input (per token) ─▶ Linear Layer ─▶ ReLU ─▶ Linear Layer ─▶ Output (same token)
• It applies non-linear transformations to each position (token) independently.
• It increases the model’s capacity to capture complex relationships beyond
| linear | attention | mechanisms. |     |     |     |
| ------ | --------- | ----------- | --- | --- | --- |
The FFN is a simple two-layer fully connected feed forward network with a ReLU activation in between.
x
| FFN(x)=max(0, |     | W1+b1)W2+b2 |     |     |     |
| ------------- | --- | ----------- | --- | --- | --- |
W1 and W2 are the weight matrices for the first and second linear layers, respectively.
| b1 and | b2 are | the biases | for these | layers. |     |
| ------ | ------ | ---------- | --------- | ------- | --- |
The ReLU activation is applied element-wise after the first linear transformation.
The output of the FFN provides a refined representation of each input position,
which combines the contextual embeddings adjusted for potential non-linear
| relationships |     | within | the data. |     |     |
| ------------- | --- | ------ | --------- | --- | --- |

| Residual |     | Connections |     |
| -------- | --- | ----------- | --- |
A residual connection adds the input of a layer directly to its output.
Output=Layer(x)+x
Each sub-layer (self-attention, feedforward network) in the Transformer is
| wrapped | with | a residual | connection: |
| ------- | ---- | ---------- | ----------- |
For Self-Attention:
| For Feedforward |     | Network: |     |
| --------------- | --- | -------- | --- |

• Residual connections carry over the previous embeddings to the subsequent
layers.
• As such, the encoder blocks enrich the embedding vectors with additional
information obtained from the multi-head self-attention calculations and
| position-wise | feed-forward | networks. |
| ------------- | ------------ | --------- |

| Why | are | residual |     | connections |     | important? |
| --- | --- | -------- | --- | ----------- | --- | ---------- |
Prevent Vanishing Gradient Problem: In deep networks, gradients can shrink as they
backpropagate, causing learning to stall. Residual connections ensure gradient flow is
| preserved | by  | providing | a "shortcut" | through | the network. |     |
| --------- | --- | --------- | ------------ | ------- | ------------ | --- |
Preserve Information: Even if intermediate layers distort the input, the original input 𝑥
| is still | passed | forward. |     |     |     |     |
| -------- | ------ | -------- | --- | --- | --- | --- |
Enable Deep Architectures: Transformers use multiple stacked layers. Without residual
connections, it would be much harder to train such deep models effectively.
Stabilize Training: Combined with Layer Normalization, residual connections contribute
| to smoother |     | learning | and better | convergence. |     |     |
| ----------- | --- | -------- | ---------- | ------------ | --- | --- |

| Layer | Normalization |     |     |
| ----- | ------------- | --- | --- |
Layer Normalization normalizes the activations of a layer across the features of each individual input.
For each token (or position) in a sequence, it normalizes its vector of features:
| For an    | input vector | x of dimension | d:  |
| --------- | ------------ | -------------- | --- |
| 1.Compute | Mean (μ):    |                |     |
| 2.Compute | Variance     | (σ2):          |     |
3.Normalize:
| 4.Scale | and Shift | (learnable | parameters): |
| ------- | --------- | ---------- | ------------ |

In Transformers, Layer Normalization is usually applied after adding the residual connection.
It works independently per sample/token (normalizes across features).
Layer Normalization prevents the mean and standard deviation of embedding vector elements from moving
| around, | which makes | training | unstable | and slow . |
| ------- | ----------- | -------- | -------- | ---------- |

Decoder
The decoder block is similar to the encoder block, except it calculates the source-target attention.
The source-target attention is another multi-head attention that calculates the attention values between the
features (embeddings) from the input sentence and the features from the output (yet partial) sentence.

• The transformer architecture assumes no recurrence or convolution pattern when
| processing | input | data. |     |
| ---------- | ----- | ----- | --- |
• As such, the transformer architecture is suitable for any sequence data.
• As long as we can express our input as sequence data, we can apply the same approach,
including computer vision (sequences of image patches) and reinforcement learning
| (sequences | of states, | actions, | and rewards). |
| ---------- | ---------- | -------- | ------------- |

| This | paper | is all  |
| ---- | ----- | ------- |
| you  | need  |         |

Loss Functions
• In a Transformer, the loss function measures how different the
model's predicted output is from the correct target output.
• The loss is then used during backpropagation to update the
model's weights.
1. Language modeling: Cross-Entropy Loss
For most Transformer language models such as GPT, the primary loss is
cross-entropy loss.
Suppose the input is:" The cat is“
The model predicts probabilities for the next word:

Word Predicted probability
sleeping 0.60
running 0.20
eating 0.15
jumping 0.05
If the actual next word is "sleeping", the loss is:
L=−log(P(correct word))
L=−log(0.60)
L≈0.511
A higher probability for the correct word → lower loss.

2. General Formula
| For a vocabulary of V |             |          |       | words:   |     |
| --------------------- | ----------- | -------- | ----- | -------- | --- |
| The                   | loss        | function |       | tells    | the |
| Transformer           |             | how      | wrong |          | its |
| predictions           |             | are,     | and   | training |     |
| tries                 | to minimize |          | this  | loss     |     |

Input Tokens
↓
Embedding + Positional Information
↓
Transformer Layers (Attention + FFN)
↓
Logits
↓
Softmax
↓
Predicted Probabilities
↓
Compare with Actual Target
↓
Cross-Entropy Loss
↓
Backpropagation
↓
Update Weights
↓
Repeat until Loss is minimized