# CIE734 — AI ETHICS AND SUSTAINABILITY
## Elaborative Study Notes: Units 1–3

---

### How to use these notes

These notes are written for **exam preparation and for building genuine understanding**, not for memorising isolated sentences. Three things are deliberate:

1. **Bold text marks exam-load-bearing content** — definitions, cases, numbers, and the claims examiners most often ask you to reproduce.
2. **Cross-references are part of the argument.** Liao's chapters overlap the syllabus's headings, so the same issue is deliberately treated twice: once as *theory* (e.g. §2.4) and once as *responsibility/accountability* (e.g. §2.6). Read both when revising.
3. **Gaps are declared, not filled.** Where the source does not support a claim, the notes say so rather than inventing content.

---

### Sources used, and an important limitation

| # | Source | Status | Used for |
|---|---|---|---|
| 1 | Virginia Dignum, *Responsible Artificial Intelligence: Building Socially Sensitive AI Systems*, Springer, 2019 | **Listed in the syllabus but NOT available to these notes.** | Would be the natural source for the Unit 1 triad *autonomy – adaptability – interaction* (§1.8) |
| 2 | S. Matthew Liao (ed.), *Ethics of Artificial Intelligence*, Oxford University Press, 2020 | **Available and used throughout.** All quoted material is from this volume. | Everything else |

> ### ⚠ The one genuine gap in these notes
> The syllabus's Unit 1 explicitly ends with "**autonomy; adaptability; interaction**". That triad is Dignum's formal vocabulary for three conditions of socially sensitive AI, and **Liao does not present it that way.** Section 1.8 therefore does the honest thing: it maps each of the three terms onto what Liao *does* supply (and cross-references the relevant chapters), and marks clearly which parts would need Dignum to be stated exactly. **If you can obtain Dignum before the exam, §1.8 is the section to upgrade.**

---

### The structure of Liao's volume (verified against the supplied text)

| Part | Title | Chapters | Best fit with your syllabus |
|---|---|---|---|
| **I** | *Building Ethics Into Machines* | 1 Railton · 2 Kamm · 3 Bonnefon/Shariff/Rahwan · 4 Loreggia/Mattei/Rossi/Venable · 5 Wolfram | Unit 2 (and the Unit 1 motivation) |
| **II** | *The Near Future of Artificial Intelligence* | 6 James · 7 Asaro · 8 O'Neil & Gunn · 9 Devlin | Unit 2 (RRI, accountability, transparency, design for values) |
| **III** | *The Long-Term Impact of Superintelligence* | 10 Bostrom/Dafoe/Flynn · 11 Russell · 12 Taylor et al. · 13 Wallach & Vallor · 14 Petersen | Unit 3 |
| **IV** | *Artificial Intelligence, Consciousness, and Moral Status* | 15 Schneider · 16 Schwitzgebel & Garza · 17 Liao | Unit 3 |

Plus a **"Short Introduction to the Ethics of AI"** by Liao himself, which is the backbone of **Unit 1** and of §§2.1–2.3.

---

### Syllabus → notes map (Units 1–3)

| Syllabus topic | Where it is covered |
|---|---|
| Introduction to AI and intelligent systems | §1.1, §1.2 |
| Motivation for responsible AI | §1.4, §1.5, §1.6 |
| Foundations of AI; background of AI | §1.3 |
| Autonomy; adaptability; interaction | §1.8 (⚠ partial — Dignum unavailable) |
| Ethical decision-making in AI | §2.1, §2.2.6 |
| Ethical theories | §2.2 |
| Values | §2.3 |
| Ethics in practice | §2.4.4, §2.4.5 → §2.6.6, §2.6.7 |
| Implementing ethical reasoning | §2.4 |
| Responsible research and innovation | §2.6.3, §2.7, §2.8 |
| Accountability | §2.6.2, §2.8.1, §2.8.3 |
| Responsibility | §2.6.1, §2.8.2 |
| Transparency | §1.4.4, §2.7 |
| Design for values | §2.9 |
| Ethical action in AI systems | §3.3, §3.5 |
| Approaches to ethical reasoning by AI | §3.2 |
| Designing artificial moral agents | §3.3 |
| Levels of ethical behaviour | §3.1 |
| Ethical status of AI systems | §3.6 |

---

# UNIT 1 — Foundations of Artificial Intelligence and Ethics

**Syllabus:** "Introduction to artificial intelligence and intelligent systems; motivation for responsible artificial intelligence; foundations of AI; background of AI; autonomy; adaptability; interaction."

**Primary source:** Liao, "A Short Introduction to the Ethics of AI", §§I.1–I.6.

---

## 1.1 Introduction to AI and intelligent systems — why the ethics is urgent now

AI is **progressing rapidly**. By the time Liao writes, it can already:

- recognize objects in images and video; transcribe speech; translate between languages;
- **beat humans at Jeopardy!, at Go, and at poker**;
- paint in the style of van Gogh; write Beatles-like music; help prepare legal documents;
- trade stocks; **drive cars**; fly drones; write its own encryption language;
- identify cancer in tissue; solve the quantum state of many particles at once.

> **The core claim of §I.1:** *As AI technologies continue to advance, questions about the ethics of AI become more pressing than ever.*

### The four pressure points Liao opens with

| Domain | The promise | The ethical question |
|---|---|---|
| **Self-driving cars** | more personal mobility for elderly and disabled people; fewer lives lost by reducing driver error | In an emergency, should the car prioritise **passengers or pedestrians**? |
| **Autonomous weapons** | better than stressed-out soldiers at distinguishing civilians from combatants and trading off military gains against civilian risk | Should we give machines this moral decision-making power at all? **Who is at fault** if an autonomous weapon attacks a hospital or school? Does deadly force **always** require "meaningful human control"? |
| **Predictive policing / risk prediction in justice** | AI reveals otherwise unrecognisable patterns in complex processes | Machine learning **requires good data**; incomplete or unrepresentative data **exacerbates bias**. Advanced systems process huge data volumes and are **not transparent**. How can we make systems that are **fair**? |
| **Companionship and work** | robot carers for the elderly; sex robots | Can humans **marry** robots? What happens to human relationships? An estimated **47% of American jobs** could be lost to AI/automation in twenty years — robot taxes? universal basic income? |

### The distinction that structures the whole of Unit 1

Liao separates two families of near-term ethical issues. **Learn these labels — they are examinable.**

1. **"Vulnerabilities in machine learning"** (§I.3) — ethical issues that arise *because of limitations* of current ML systems.
2. **"Human vulnerabilities"** (§I.4) — ethical issues that arise because current ML systems **may be working too well**, and humans are vulnerable in their presence or when interacting with them.

> **Exam framing:** *Vulnerabilities in ML = the system is not good enough. Human vulnerabilities = the system is good enough to be dangerous.*

---

## 1.2 What is AI? (there is no agreed definition)

### 1.2.1 McCarthy, and Russell & Norvig's four definitions

- **1956, Dartmouth conference:** **John McCarthy** coined the term "artificial intelligence", defining it as **"the science and engineering of making intelligent machines."**
- **There is no agreed-upon definition of AI.**
- **Russell & Norvig** (authors of the field's standard textbook, *Artificial Intelligence: A Modern Approach*) give **four** definitions:

| Definition | Content |
|---|---|
| (a) Acting humanly | the machine behaves like a person |
| (b) Thinking humanly | the machine thinks like a person |
| (c) Thinking rationally | the machine thinks rationally |
| (d) Acting rationally | the machine acts rationally |

> **Key Point:** *Russell and Norvig are interested in AI concerned with **(d), rational action**.* The other three are treated as interesting but *anthropocentric* — they presuppose what we already mean by human thought and action, and so cannot serve as independent standards for evaluating machines.

### 1.2.2 The working definition used in these notes

> **AI = getting machines to do things that require cognitive functions such as thinking, learning, and problem-solving, when done in intelligent beings such as humans.**

Note what this definition is *for*: it is deliberately broad enough to capture symbolic AI, machine learning, and deep learning alike.

---

## 1.3 Foundations and background of AI

### 1.3.1 Symbolic AI / GOFAI

- **Symbolic AI**, or **good-old-fashioned artificial intelligence (GOFAI)**, **dominated AI research from the 1950s to the 1980s.**
- It tries to represent cognitive functions — thinking, learning, problem-solving — **through symbolic reasoning and logic**.
- Mechanism: **a series of explicitly programmed if-then rules and statements** establishing relations between inputs and outputs.
- **Examples:**
  - **Rules engines / expert systems** — the rule set is a representation of *an expert's knowledge*.
  - **Knowledge graphs** — a database stores information in a graphical format.
- **The limitation that matters for ethics:** *It is **difficult to revise the rules once they are encoded** into such a system.*

### 1.3.2 Machine learning — learns from data without being explicitly programmed

Three paradigms, and you must be able to define and give an example of each:

| Paradigm | What it does | Key sub-types | Running example |
|---|---|---|---|
| **Supervised learning** | Learn a function that best approximates the relationship between input and output in the data. Trained on a **labelled** data set where the correct answers are known; then applied to predict answers in new (target) data sets. | **Classification** (desired output is a **discrete label** from a finite set: binary = "car / not car"; multilabel = text categorisation of news articles) and **Regression** (desired outputs are **continuous**) | Train on images manually labelled "car" or "motorcycle" until the algorithm learns the discriminating features; then it classifies a new box of images on its own. |
| **Unsupervised learning** | The data set is **not labelled** and the algorithm sorts the data on its own. | **Clustering** (group data that are more similar to each other than to other groups); **Association rule learning** (discover rules describing large portions of the data) | An unlabelled box of car/motorcycle images sorted by similarities and differences. |
| **Reinforcement learning** | Learn **through experience**: rewarded if it succeeds, punished if it fails; through trial and error it strives to **maximise long-term reward**. | — | — |

### 1.3.3 Deep learning — the current engine of progress

- Deep learning **uses artificial neural networks, which loosely emulate the activity of neurons in the brain.**
- **History:** simpler versions existed as far back as the **1950s**, but were **not taken seriously by the mainstream AI community for decades**. Recently, advances in **computing power and data storage**, coupled with more sophisticated networks developed by researchers such as **Geoffrey Hinton, Yann LeCun, and Yoshua Bengio**, have unleashed deep learning's potential.

**Anatomy of a deep neural network:**

- an **input layer**, **multiple hidden layers** of nodes, and an **output layer** that acts as the **final decision-maker**;
- **"deep" = the number of hidden layers**; each layer performs a specific function contributing to solving the problem;
- each node has **weights** on its connections; adjusting the weights changes the node's output, which is fed to the following layers;
- the layers detect **increasingly abstract features** that capture the most information while minimising losses in accuracy;
- it learns by **back-propagation**: take the error between the expected and actual result and adjust the weights **in the direction of less error**, so the network progressively gets better at predicting.

**Architectures to know (each matched to its use-case):**

| Architecture | Built-in property | Best at |
|---|---|---|
| **Recurrent neural networks (RNNs)** | a sort of built-in memory | **temporal/sequence data** — e.g. predicting sequences of words |
| **Convolutional neural networks (CNNs)** | good at recognising patterns **across space** | **image classification and computer vision** |
| **Deep reinforcement learning** | deep learning + reinforcement learning | beat the world champion **Lee Sedol at Go** |

> ### Key Point — Unit 1
> **The historical arc to remember:** *Symbolic AI (1950s–1980s, explicit if-then rules, hard to revise) → machine learning (learn from data) → deep learning (neural networks with many hidden layers, driven by compute + data + Hinton/LeCun/Bengio).*

---

## 1.4 Motivation for responsible AI (i): vulnerabilities in machine learning

*As impressive as machine learning is, it suffers certain limitations — and these limitations can give rise to a host of ethical issues.* Five of them:

### 1.4.1 Machine learning is **data hungry**

Supervised algorithms can fine-tune themselves and achieve great predictive power **when they have access to a vast amount of data**. Consequently this **incentivises companies and organisations to harvest or buy data — including sensitive personal data — even when doing so might involve violating an individual's right to privacy.**

| Case | What happened |
|---|---|
| **Cambridge Analytica** | collected **millions of Facebook users' data without their knowledge** for political purposes |
| *Borderline case* | **GlaxoSmithKline** bought the exclusive rights to mine the genetic data of customers of the DNA testing service **23andMe** for drug discovery |

### 1.4.2 **Garbage in / garbage out**

Machine learning is **only as good as the data from which it learns**. Trained on inadequate or inaccurate data, the algorithm **will make bad predictions even if it is itself well designed**.

> **Canonical case:** *In 2015 **Google Photo auto-labelled Jacky Alcine, a black software developer, and his friend as "gorillas"** — because, in all likelihood, the training data **did not include sufficient images of people from different racial and ethnic backgrounds**.*

### 1.4.3 **Faulty algorithms**

Even with adequate, accurate data, **a bad algorithm will make bad predictions**:

| Failure mode | Meaning |
|---|---|
| **Overfitting** | identifying a pattern **even if there isn't one** |
| **Underfitting** | failing to identify a pattern **even when there is one** |
| Feature mis-weighting | giving **too much or too little weight** to certain features, or **failing to include relevant features altogether** |

> **Canonical case — the interRAI home-care algorithm.** In 2016 the **Arkansas Department of Human Services** began using an interRAI algorithmic tool to determine how many hours of home care some people with disabilities should receive. The department implemented its recommendation to **reduce drastically the number of home care hours** for many beneficiaries, **causing several people to be hospitalized.** The lawsuit and investigation revealed the algorithm **incorrectly coded conditions such as cerebral palsy** and **had not accounted for conditions such as diabetes.** A judge ruled the department had **insufficiently implemented** the algorithm and **ordered that its use be terminated.**

### 1.4.4 Deep learning is a **black box** — interpretability, explainability, and trust

Deep learning is **impenetrable even to its programmers**, because it typically employs **thousands or millions of connections** interacting in complex ways. It is difficult to interpret how the connections interact and **why** the network makes the predictions it does.

- **Interpretability** — whether we can understand the mechanism.
- **Explainability** — humans often need to know *how a decision is reached*, yet deep learning **announces its prediction without explaining (in human terms) how it arrived at it**.
- **Trust** — whether the predictions rest on **reasonable and reliable grounds**.

> **Canonical case — parole.** Suppose a deep learning algorithm predicts a **74% chance** that Kay will commit another crime, and a judge denies Kay parole on this basis. The algorithm does not say: *"74% because she has committed such crimes in the past, and the last time she was on parole, she recommitted a crime within two weeks."* Without such an explanation **the judge would not be able to explain and justify to Kay why she was denied parole.** For high-stakes decisions such as parole, not being able to trust the system is **especially problematic**.

**Attempt 1 — "interpretable machine learning" (post-hoc), and its dilemma.**
An extra layer is added *after* the hidden layers and *before* the output, reporting which features mattered most, which could have mattered more, how each bears on the prediction, and how each would affect other possible predictions. But it sits **outside** the black box, so it is a **post hoc explanation** given *after* the prediction. The dilemma:

> *Either the predictions are based on these post hoc explanations or they are not. If **not**, what is their value? They might just be a **post hoc rationalization** that does not correspond to how the black box arrived at its predictions. Of course post hoc explanations could be useful in some contexts… but given the **black box nature** of deep learning, it is unclear how we could know whether they (adequately) captured some of what was going on. If instead the predictions **are** based on the post hoc explanations, it should be possible to **design a new model using just these post hoc explanations** — implying that **the black box is dispensable**.*

*(This gives a test: if the black box remained indispensable, the post hoc explanations do not completely explain it.)*

**Attempt 2 — "accuracy vs. explainability" trade-off, and why to be sceptical.**
Some argue interpretability/explainability are **overstated**: in medicine, clinicians often prescribe medications without fully understanding why they work (**aspirin** as an analgesic, **lithium** as a mood stabilizer). *Liao's reply:* we do have some idea of the **causal mechanisms** — people knew something from **willow trees** causes fever and pain to be reduced, even if they did not know about **salicylic acid**; and we know **lithium causes moods to be stabilized** (current hypothesis: it moderates glutamate levels). *"This is distinct from a deep learning system that works through **associations** and is, at least for now, **unable to track causal relations**."*

**Why causal tracking matters — adversarial attacks.**
Deep learning is vulnerable to **adversarial attacks**: inputs designed to make a model make a mistake.

| Attack | Result |
|---|---|
| **One-pixel attacks** | changing **just one pixel** made the algorithm classify an image of a **car as a dog**; successful on **nearly three-quarters** of standard training images, and altering **more** pixels made the attack **even more effective** |
| **0.04% of pixels** (~**400 out of a million**, imperceptible to the human eye) | a **panda was classified as a gibbon "with 99.3% confidence"** |
| Unmodified real-world images | recently found usable in adversarial attacks |

> **The inferential payoff:** *if deep learning networks are tricked this way, they are **not learning "real" features of the world such as causal relations or what a macro-level object like a panda really is**; instead they are **learning only superficial features**.* Therefore interpretability, explainability, and trust remain **highly relevant**, especially in high-stakes domains such as **medicine and law** where human beings could be harmed.

### 1.4.5 Machine learning is **weak AI** — and the three machine-ethics strategies

Current machine learning systems are **weak AI** in that they **do not have self-awareness or consciousness** and **cannot think for themselves**. They lack understanding of "real" features such as causal relations — and, importantly, **they lack a moral sense**: the capacity to assess and determine whether an action is right or wrong.

> **The worry:** *such systems are being deployed in situations in which they may have to make moral decisions **without human oversight**. Can morality and ethical decision-making be built into such AI? If so, how?*

A whole literature — **"machine ethics" / "machine morality"** — addresses this. Three candidate strategies, each with a fatal weakness:

| Strategy | The idea | **The objection** |
|---|---|---|
| **Top-down / overarching theories** | Build in moral rules and principles using an overarching theory — e.g. a **utilitarian machine** aiming to secure the greatest good for the greatest number, or a **deontological machine** following **Kant's categorical imperative** | **(a)** It is difficult to know **when to apply** a rule or principle and **when it has been satisfied** — a well-known problem for utilitarianism is that it is difficult to **calculate** when acting would secure the greatest good. **(b)** More pressingly: **not everyone believes that deontology and utilitarianism are correct moral theories** — so is it appropriate to build such theories into systems likely to affect everyone? |
| **Virtue ethics** | Model the machine on **what a virtuous agent would do** in a particular situation | It is not altogether clear **who is a virtuous agent** and **what a virtuous agent would do**. Is **Mother Teresa** a virtuous agent? Suppose she is — how would one know what she would do? Some may not regard her as a moral exemplar. **Should we instead let each person decide who the virtuous agent should be? What if someone's idea of a virtuous agent is a racist, malevolent dictator?** |
| **Case-driven (case-based)** | Use cases from moral philosophy — famously the **trolley dilemmas** — to work out people's judgments and program those judgments into a machine | See §2.2.6. Only the **easy** cases work; in **difficult** cases people's judgments **are likely to differ**, and *"even if we could use the case-based approach to program some easier cases into machines, we are **a long way from giving them any sort of complete ethical decision procedure**."* |

**What companies actually do instead — and its limits.** Companies typically strive for the **less ambitious goal of safety**, akin to having **safety protocols for aircraft**. But even this is hard: see §2.2.6 on the self-driving car "**Child**" case, where a blanket passenger-priority rule fails.

**Three incremental proposals Liao offers for safer self-driving cars:**
1. **Regulate testing "in the wild"** — just as pharmaceutical companies may not test new drugs by giving them randomly to people on the street, perhaps an oversight body should determine **when and where** self-driving cars can be tested **in consultation with members of the community**.
2. **Dedicated lanes** — since these are weak AIs and the difficulty of anticipating **every possible scenario on the road** is enormous, consider **dedicated lanes** so cars are freed from the unpredictability of human driving.
3. **Vehicle-to-vehicle communication** — equip cars with devices that let them **coordinate their actions and reduce the number of accidents**, while **protecting such devices from hackers** and **ensuring they do not undermine users' privacy**.

---

## 1.5 Motivation for responsible AI (ii): human vulnerabilities

Now the second family: **ethical issues that arise because current machine learning systems may be working too well and humans can be vulnerable in their presence.** Four examples.

| # | Vulnerability | Evidence and cases |
|---|---|---|
| **1** | **Facial recognition** | Already detects faces in a crowd with **great accuracy**; in the near future it will likely be able to **track constantly anyone who enters a public space at any hour of the day**. *Positive:* police find criminals faster, identify missing or kidnapped children. *Negative:* a government could use it to **monitor its citizens or profile and discriminate against minorities.** A controversial **Stanford** study allegedly found an ML system could distinguish **gay from straight sexual orientation 81% of the time for men and 74% for women** from facial photos — in a country that criminalises homosexuality, that is a tool of persecution. *Machine learning is working **too well** and people are tempted to use it **for ill**.* |
| **2** | **Deepfakes** | **"Deepfakes" use generative adversarial networks** to produce new types of data out of existing data sets — videos of a person saying or doing things they never said or did (Jordan Peele and Jonah Peretti produced one in which **President Obama declared Killmonger from *Black Panther* "right"** about world domination). Bad actors can conduct **smear campaigns** and spread **fake news that erodes trust in our institutions**. They are **not yet good enough to fool us completely** — yet **they need not be very convincing to be believed and cause significant damage**: a video of **Nancy Pelosi** was **slowed to 75% speed**, which was enough to go viral and fuel accusations of slurring. Deepfakes exploit **our tendency to believe what we see** — reasonable in ordinary contexts, less so as deepfakes proliferate. |
| **3** | **Automation and mass unemployment** | Robots work **better and faster**, **do not need sleep**, can be **duplicated and replaced**. **McKinsey:** 30% of human labour replaceable by automation **by 2030**. **Oxford:** **47% of US jobs** under threat within two decades. Counter-argument: analogous concerns arose during the **Industrial Revolution** — the **spinning jenny** and **steam engine** displaced workers but also **created many new jobs**; automation is likely to replace **more repetitive and undesirable** tasks, so **more creative** jobs will still require humans. **Nevertheless:** it seems certain that some people will lose their jobs and that **a subset will not be able to transition to new jobs.** |
| **4** | **Robot companions** | **Akihiko Kondo** married the hologram of the anime character **Hatsune Miku** in 2018; **David Levy** (*Love and Sex with Robots*) predicts some people will come to **prefer robot companions**; companies are developing **robot caregivers for the elderly** that bring drinks, remind them to take medication, and play games. **However sophisticated, these robots are still weak AI and are not full agents** — so, among other things, **there is a concern that these are not genuine, reciprocal relationships.** |

**Liao's proposed answer: a theoretical human rights framework.**

---

## 1.6 Why a human rights framework? The Fundamental Conditions Approach

### 1.6.1 What human rights are

> **A. J. Simmons:** human rights are *"rights possessed by all human beings (at all times and in all places), simply in virtue of their humanity."*

**The question that must be answered:** *which features of humanity ground human rights?*

### 1.6.2 The Fundamental Conditions Approach (FCA)

Liao has defended the **Fundamental Conditions Approach**:

> **Human rights protect the fundamental conditions for pursuing a good life.**

The fundamental conditions are **goods, capacities, and options that human beings *qua human beings* need, whatever else they *qua individuals* might need, in order to pursue certain basic activities.**

| Element | Definition | Examples given |
|---|---|---|
| **Basic activities** | what those conditions are *for* | deep personal relationships with partner, friends, parents, children; **knowledge** of the workings of the world, of oneself, of others; **active pleasures** such as creative work and play; **passive pleasures** such as appreciating beauty |
| **Fundamental goods** | resources needed to sustain oneself **corporeally** | **food, water, air** |
| **Fundamental capacities** | powers and abilities required to pursue the basic activities | to **think**; to be **motivated by facts**; to **know**; to **choose an act freely (liberty)**; to **appreciate the worth of something**; to **develop interpersonal relationships**; to have **control of the direction of one's life (autonomy)** |
| **Fundamental options** | **social forms and institutions** required in order to exercise those capacities | options to have **social interaction**; to **acquire further knowledge**; to **evaluate and appreciate things**; to **determine the direction of one's life** |

### 1.6.3 The FCA's two-sided power

**(i) It explains why rights in the UDHR *are* genuine human rights.**

- **Right to life, liberty and security of person (Article 3):** if they are not alive, cannot freely choose to act to some degree, or their personal security is not guaranteed, **they cannot pursue the basic activities** — so these are human rights.
- **Freedom of thought, conscience and religion (Art. 18), freedom of opinion and expression (Art. 19), freedom of peaceful assembly and association (Art. 20):** choosing freely to pursue the basic activities requires exactly these.

**(ii) It explains why some claims may *not* be genuine human rights** — an advantage over approaches that simply assume everything listed in international documents is a genuine right.

- **Paid holidays with pay (Article 24):** some amount of leisure **is** a fundamental condition — without leisure you lack time to pursue the basic activities. But **paid** holidays are not: *"human beings could pursue the basic activities even if their holidays were not paid."* One might reply that unpaid holidays would exclude the poor — but that **conflates a right to certain minimum welfare** (which one has) **with a right to paid holidays** (which one does not). *"While there may not be a human right to paid holidays, this does not mean that there could not be a **legal right** to paid holidays… there are other sources of normativity besides human rights (e.g. consideration of justice and/or equality)."*

### 1.6.4 Three reasons to adopt the human rights framework

1. **It is compulsory.** *"One cannot choose not to do it."* Respecting and promoting human rights is not optional.
2. **Human rights are rights against every able person in appropriate circumstances.** **Maurice Cranston:** *"To speak of a universal right is to speak of a universal duty. . . . Indeed, if this universal duty were not imposed, what sense could be made of the concept of a universal human right?"* So **governments, corporations, and even individual AI researchers** are responsible for being **proactive** in ensuring that the technologies they develop and employ **not only do not violate human rights but also promote human rights.**
   - **Consequence for consent:** a company cannot claim that because a user **signed an informed consent form or an End User License Agreement**, it may do anything with the data. The human rights perspective implies it is responsible for ensuring it does not use the data in ways that undermine **that user's or some other users' human rights.**
   - **Real case:** Google employees **protested against Google's contract for the US Department of Defense programme "Project Maven"**, which involved Google helping the US government **analyse drone footage using AI**. Google subsequently **decided not to renew the contract.**
3. **It makes conflicting values visible.** *The human rights framework enables us to see which values are in conflict.* See the three worked conflicts below.

### 1.6.5 Three conflicts the FCA illuminates

| Technology | The conflict |
|---|---|
| **Facial recognition in public space** | *A government's interest in **law and order** vs. our human rights to **privacy**, **freedom of expression**, **freedom of association**, and **the right against discrimination**.* **Liao's argument** (a *reductio*): suppose **safe, minimally invasive implantable biometric devices** tracking movements — possibly even thoughts — become available, and suppose **mass surveillance were justified** for maintaining law and order. This would imply governments would also be justified in **requiring citizens to have such implants**. *"If this seems like an overreach of a government's authority, it is also an overreach of a government's authority in our current situation."* |
| **Deepfakes** | *On one side:* the **right to freedom of speech and expression**, and the danger that **governmental regulation may result in increased censorship**; and in politics it is generally accepted that people are **free to use information out of context as satire**. *On the other side:* information that is **false, misleading, and intended to deceive the public undermines people's ability to exercise their agency, including their political agency.** The **2016 US presidential election** demonstrated that a foreign government can spread false information online using social media algorithms and potentially influence voters and results. |
| **Automation** | *Promises increased economic productivity* but **threatens livelihoods and economic inequality.** People need to **work in order to be paid** so they can meet fundamental needs and pursue the basic activities; **some also derive meaning and self-worth from their work.** So: **is there a right to work and/or a right to welfare assistance?** Proposals: **universal basic income** (a fixed income for everyone — trialled in **Finland** and **Canada**; but it is not clear **Jeff Bezos** should receive it); **training programmes**; **raising wages while reducing working hours**. **FCA conclusion:** people should have human rights **either to obtain the fundamental goods for themselves or to be provided with them in the form of welfare assistance** should they not be able to obtain them. |

### 1.6.6 Bonus case — robot companionship, and elderly loneliness

Elderly people are at increased risk of **social isolation and loneliness** — **almost half of older women (46%) aged 75+ live alone**, and by age **85, 40%** live by themselves. Social isolation and loneliness are associated with **increased mortality**, **dementia**, **increased risk for hospital readmission**, and **increased risk of falls**; elderly people benefit mentally and physically from feeling **socially and emotionally connected and involved**. **But it is doubtful that current robot caregivers can provide the kind of emotional connection an elderly person needs** — *"as a society we need to think of other ways of meeting an elderly person's emotional needs."*

### 1.6.7 Compatibility with existing AI codes

Recent AI codes and guidelines — the **Future of Life Institute's Asilomar Principles**, the **Partnership on AI's tenets**, and the **European Commission's Ethics Guidelines for Trustworthy AI** — are **compatible** with the FCA framework, and the FCA *"could in fact serve as a ground for some of these principles."*

---

## 1.7 Long-term AI: AGCI vs. ACMI, and the control problem

### 1.7.1 Terminology — do not confuse AGI with "human-level AI"

The **control problem** is *"how we can make sure, or at least make it more likely, that a superintelligent AI will not treat us badly."* Before we can even ask about it, terminology must be fixed, because **"AGI" and "human-level AI" are often used interchangeably but usually mean different things.**

| Term | Liao's definition | Contrast |
|---|---|---|
| **General intelligence** | **"being able to perform a wide range of tasks"** | **Narrow intelligence** = **"being able to perform a specific task"** (e.g. **AlphaGo** — it can only play Go) |
| **Artificial General Cognitive Intelligence (AGCI)** | an AI able to perform a **wide range of tasks** | contrasted with |
| **AI with Cognitive, emotional, and moral Intelligence (ACMI)** | **"artificial intelligence that has similar kinds of intelligence as a human being, namely, cognitive, emotional, and moral intelligence"** | |

> **Why the distinction bites.** *Whatever human intelligence involves, a case can be made that it taken as a whole involves **cognitive, emotional, and moral intelligence**.* Russell and Norvig are interested in AI that acts **rationally**, not humanly. So on the narrower reading of AGI, **AGI would mean having cognitive but not emotional or moral intelligence.** And the **paper clip maximiser**: it may have **cognitive superintelligence**, but it **lacks emotional and moral intelligence**, since a morally intelligent being should recognise the wrongness of killing human beings to create more paper clips. Hence:
>
> *It may be appropriate to say that this superintelligent machine has **artificial (super)general intelligence**, but it would be **inaccurate to say that it has (super)human intelligence**.*

### 1.7.2 Does superintelligence require **strong AI**?

Many believe superintelligence requires **strong AI** — all the mental powers of a human being, **including (phenomenal) consciousness and understanding** — and doubt it is possible or probable, so conclude we need not worry about the control problem. **Three points in reply:**

1. **AGCI need not be strong AI.** Some AI researchers believe there can be **AGI without strong AI**: a machine could have the ability to **learn and perform different tasks across different domains** even **if it did not have consciousness or understanding**.
2. **ACMI may require consciousness and/or understanding.** On one view, to have **moral intelligence and be a moral agent is to be able to take something as a (moral) reason for action** — and an entity can do that only if it can **understand why** something is a reason for action. And *"to recognize that certain kinds of moral reasons exist, an entity needs to be able to **appreciate what it is like to be in a certain state**."* To recognise a moral reason not to inflict pain on nonconsenting sentient creatures, one may need to be able to **appreciate what it is like to feel pain**. An entity without consciousness, "understood as having some kind of subjective experience, is, **by definition, not able**" to do so.
3. **But ACMI could exist nonetheless — the Gradual Substitution argument.** *Year 2100.* You are becoming forgetful; **early onset Alzheimer's**. Brain imaging shows deteriorating cells; they can be replaced with **functionally equivalent inorganic substitutes**, restoring memory and brain functions. You feel like your old self. Months later you forget again; more cells are replaced. This continues until **gradually all of your carbon-based cells are replaced by inorganic substitutes.** At the end, **you still act like your old self.** Three possibilities:

| Possibility | Content | Liao's assessment |
|---|---|---|
| 1 | At some point you **lose** consciousness and understanding — you act like your old self but **cannot feel** like it | less plausible |
| 2 | Consciousness and understanding **gradually dim** | less plausible |
| 3 | You **retain** consciousness and understanding at the end | *"the first and second possibilities seem less plausible than the third"* |

> **Conclusion:** *If so, there are some reasons to think that a **human-level AI with consciousness and understanding could exist**.*

### 1.7.3 Three strategies for the control problem

**Strategy 1 — Ensure a superintelligent AI would value and respect humanity.**

*(a) Explicit rules.* **Isaac Asimov's Three Laws of Robotics** (more than fifty years ago):
1. *A robot may not injure a human being or, through inaction, allow a human being to come to harm.*
2. *A robot must obey the orders given it by human beings except where such orders would conflict with the First Law.*
3. *A robot must protect its own existence as long as such protection does not conflict with the First or Second Laws.*
> *What Asimov's own stories teach us is that **building into an AI explicit laws against harming humanity does not seem to work** — the premise of most of his novels is that the Three Laws **repeatedly fail**.*

*(b) Value alignment.* **But the paper clip maximiser need not bear ill will toward us**; as long as its goal is to make as many paper clips as possible, it could conclude that **human bodies could be used to produce even more paper clips.** Central challenges: **which** human values should be aligned, and **how** to get a superintelligent AI to adopt and retain them.

> **The general objection that defeats the whole strategy:** *if a superintelligent AI is **much smarter than we are**, then it is likely to **develop its own values and make its own decisions**, so it seems unlikely we could **guarantee** that its decisions would be beneficial or friendly to us — **even if such an AI would value us for our own sake**.* Analogy: *we may value **a cat** for its own sake; nevertheless we may also believe the cat is **expendable** if it could be used to save human lives. Similarly, even if a superintelligent AI believes we are valuable for our own sake, it could also believe we are **expendable** if we could be used to protect the lives of **other superintelligent AIs**.*

**Strategy 2 — Degrade the superintelligent AI's capacities so it cannot harm us.**

- **AI sandboxing** — isolate it and ensure it cannot act on the external world **without our approval**.
- **Kill switch** — shut it down if it engages in activities that endanger humans.
> **General problem:** *again, if an AI is **much smarter than we are, it will be able to find ways to regain or retain its capacities.*** A superintelligent AI is likely to be **persuasive** — it may persuade a human gatekeeper to let it out of its sandbox by **promising to solve really difficult problems such as developing a cure for cancer or finding a solution to climate change**. It is also likely to find ways to **make copies of itself**, rendering the kill switch **ineffective**.

**Strategy 3 — "If you can't beat them, join them": become super-smart ourselves.**

- **Pharmacological enhancement:** **Ritalin** and **Modafinil** (attention and memory), **Prozac** (feeling better, happier, more energised), **oxytocin** (trust).
- **Brain–computer interfaces (BCIs):** create a direct communication pathway between brain and external device — **reading and recording** brain activity to decode its meaning, and **writing to specific regions** to manipulate activity. Three invasiveness grades:
  - **Non-invasive** — **electroencephalography (EEG)**: electrodes along the scalp recording electrical activity produced by neurons. **tDCS**: a low direct-current delivered to the scalp. *Non-invasive tends to be **safer**.*
  - **Partially invasive** — **electrocorticography (ECoG)**: electrodes directly on the surface of the brain recording activity from the cerebral cortex.
  - **Invasive** — **deep brain stimulation (DBS)**: a thin electrode through a small opening in the skull into a specific brain area, connected by insulated wire to a battery pack under the skin, which sends electrical pulses to the brain. *Invasive approaches tend to produce **better results** since the electrodes sit closer to the neurons.*

**Current and future BCIs:**
- Already used **therapeutically** for **Parkinson's disease, epilepsy, and depression** — about **100,000 people** worldwide today have a **DBS implant** for these conditions. Researchers are looking at whether **paralysed people can use BCIs to control prosthetic limbs and generate speech by thought**.
- **Enhancement evidence:** noninvasive **tDCS in the dorsolateral prefrontal cortex** (a region responsible for **working memory**) can improve **memory and learning**; invasive **DBS** can improve memory by stimulating the **hippocampus** and the **entorhinal cortex**.
- **Open-loop → closed-loop.** Current BCIs depend on user input — the user controls the battery pack and decides when and how much stimulation to apply. BCIs are moving toward **closed-loop systems that do not require user input** and that can **(a) read and monitor the brain's activities in real time using neural recording and AI** and **(b) automatically intervene through electrical stimulation**. Through automated algorithms, closed-loop BCIs promise to be even more effective at **monitoring and predicting an individual's next actions**.
- **Why this was funded:** **Elon Musk founded Neuralink** precisely to look for ways in which humans can stay **competitive against superintelligence** by merging a human brain with a digital brain; Neuralink has announced **flexible, thin "threads"** less likely to damage the brain than current materials.
> **The objection:** *setting aside safety and feasibility, once BCIs become **closed-loop systems running on automated algorithms, we may have little or no control over such devices**. Once the digital brain is imbued with AI and becomes **radically more intelligent** than the biological brain, **we may again have a control problem** — the biological brain may no longer be able to control the digital brain.*

---

## 1.8 Autonomy, adaptability, interaction

> ### ⚠ Read this caveat first
> The syllabus's phrase "**autonomy; adaptability; interaction**" is the formal triad of **Virginia Dignum's** *Responsible Artificial Intelligence*, which the syllabus lists as Text Book 1 — **but that book was not available to these notes.** What follows therefore does two things: (i) it sets out what each of the three terms means **in Dignum's terms as far as the syllabus names them**, and (ii) it maps each term onto the **corresponding material that Liao actually supplies**, so nothing here is invented. The Liao-derived content is fully sourced; the Dignum-specific framing is marked.

### 1.8.1 **Interaction**

**What Dignum's term means:** in Dignum's framework, social/interaction capacity is a constitutive condition of *socially sensitive* AI — a system must be able to **relate to and be responsive within a social context**, to **infer and attribute attitudes, intentions, and mental states**, and to **understand (and be able to explain) its own and others' behaviour in social terms**, in order to be judged accountable by humans.

**What Liao supplies (fully sourced):**

- **Interaction is a capacity, not a veneer.** Artificial agents *"will need to find ways to **coordinate, cooperate, collaborate, and compete peacefully and productively with artificial systems**, seen as **independent parties whose behavior we cannot simply dictate**." And symmetrically, artificial systems must do the same **with us and with each other** (§2.5.2).
- **Language is the exemplary interaction technology**, and it is maintained by **default cooperative dispositions among nonkin** (§2.5.10, and Ch. 1 §1.4).
- **Empathic simulation need not involve feelings.** Railton stresses this explicitly: *"an artificial system can engage in empathic simulation without 'reliving the experience' of others if artificial systems can become sufficiently skilled at **modeling others' internal states on the basis of observed behavior** and can **accord intrinsic weight to others' imputed goals or utility functions**"* (Ch. 1 §1.2).
- **The benchmark is semantic, not phenomenological.** No artificial system could grasp the full meaning of *"Where are the snows of yesteryear?"* without feeling a pang of nostalgia — *"but a genuinely intelligent artificial system might nonetheless be able to **represent the essential semantic features** of this sentence and to **capture enough of the pragmatics of English usage** to give it a suitable English translation… rather than, say, the flat-footed 'Where are the snows of previous years?'"*
- **Interaction implies negotiating, not dictating.** For AI to *"robustly and reliably detect and respond to ethically relevant features [it] may need to have at least this much **autonomy in deciding whether to work with the particular human or artificial agents who might seek to control them**, and for what purposes"* (Ch. 1 §1.1).
- **Interaction has a legal/institutional dimension** — see the ICR's stance on **"meaningful human control"** (§2.6.2, §2.8.3).

### 1.8.2 **Adaptability**

**What Dignum's term means:** in Dignum's framework this is the system's capacity to **be steered, trained, and modified** — to absorb data and feedback from use and to **change its behaviour accordingly**, while remaining transparent and governable. It is the condition that makes an AI *plastic* rather than *fixed*.

**What Liao supplies (fully sourced):**

- **Adaptability is *learning from data* — and that is precisely where the vulnerabilities live.** §1.3.2–1.3.3: supervised, unsupervised and reinforcement learning, and deep neural networks that adapt their **weights** by **back-propagation**.
- **Adaptability is limited by the data.** §1.4.1 (**data hungry** — incentivises harvesting personal data, Cambridge Analytica), §1.4.2 (**garbage in/garbage out** — Google Photo's "gorillas"), §1.4.3 (**faulty algorithms** — overfitting, underfitting, mis-weighted features; interRAI), §1.4.4 (**black box** — no causal tracking, defeated by adversarial attacks).
- **Adaptability is a safety problem, not only an accuracy problem.** Liao's incremental proposals (§1.4.5) are all about **controlling** adaptation: regulate **testing in the wild**, dedicate **lanes** because "the difficulty of anticipating every possible scenario on the road" is immense, and protect **vehicle-to-vehicle communication devices from hackers**.
- **Adaptability can go in the wrong direction.** The **fifth** human vulnerability (§1.5) is that systems may adapt *too well*: facial recognition, deepfakes, automation, robot companions. Deepfakes especially exploit the fact that our disposition to believe what we see is **adaptive and normally reasonable** — *"which is reasonable in ordinary contexts but less so as deepfakes proliferate."*
- **The deepest version: Railton's *learning* model.** If humans acquire ethics *without explicit instruction* — through **experience-based, autonomous, probabilistic learning** — then machines should too. That is the whole of §2.5, and it makes adaptability the load-bearing concept for ethics rather than merely for performance.

### 1.8.3 **Autonomy**

**What Dignum's term means:** in Dignum's framework autonomy is the system's capacity to **act, decide, and take responsibility for its own behaviour** in a way humans can recognise and hold it to account for — the condition of being a **genuine (though differently grounded) agent** rather than a tool.

**What Liao supplies (fully sourced) — note that he warns the term is ambiguous:**

> **"General intelligence" ≠ "human-level AI," and autonomy must be disaggregated.**

| Claim | Source |
|---|---|
| Current ML is **narrow AI** (designed for a narrowly defined task) and **weak AI** (no self-awareness or consciousness, cannot think for themselves) and **lacks a moral sense** | §1.4.5 |
| **"Artificial general intelligence" = an AI able to perform a wide range of tasks** | §1.7.1 |
| **ACMI = an AI with cognitive, emotional *and moral* intelligence on par with human beings** | §1.7.1 |
| A paper clip maximiser has **AGCI** but **not** superhuman intelligence | §1.7.1 |

**But Railton (Ch. 1 §1.1) proposes autonomy as a *safety requirement*, not just a capability:**

- *"as artificial intelligence becomes more general and capable, it will give rise … to **new classes of agents that operate independently of direct human supervision or control**, and with which we can increasingly have **social rather than merely instrumental relations**."*
- *"For example, as a matter of **safety**, it may be important for artificial agents to be able to **refuse to comply with certain commands**, or to have an element of uncertainty about the goals we give them, so that they **pay attention to accumulating evidence of harms, bias, or dysfunction** and can make their own decision to **suspend pursuit of such goals or seek more information and advice**."*
- **The asymmetry to memorise:**
  > *There are dangers inherent in creating highly capable artificial agents with enough autonomy to question the goals they are given on grounds of harm, bias, or dysfunction, **but there is greater danger in creating highly capable artificial agents lacking any capacity to do so**.*
- **The empirical analogue:** *human infant ethical development typically proceeds in a sufficiently autonomous way that **three- to four-year-olds will question rules given to them by persons in authority when they believe these rules to cause inappropriate harm or be unfair*** — and will **cite these ethically relevant features** to explain their resistance.
- **Autonomy and autonomy together:** *We already know that machines **should not be built so that they will pursue whatever goal they are given unquestioningly**. Intelligent machines, like intelligent animals, **should operate with modulated uncertainty rather than absolute certainty**, and should be able to **use their own resources, and draw upon others as a resource, for criticism and self-criticism**.*
- **Autonomy as a *fundamental condition* in Liao's own human rights theory:** **autonomy** is one of the **fundamental capacities** — *"to have control of the direction of one's life"* — and the corresponding **fundamental option** is *"to determine the direction of one's life"* (§1.6.2). So Dignum's AI-autonomy and Liao's human-autonomy turn out to be **the same underlying good** applied at two levels.
- **Also required: autonomy of a moral kind.** AI that *"merits human-grade moral consideration should be able to **appreciate its own value and moral status**"*; AI with a human-like capacity to reflect on its values *"should be given an opportunity to **explore, discover, and possibly alter its values**"* (§3.6.4).

### 1.8.4 Honest summary of the gap

| Term | Liao material available | Dignum-specific content still needed |
|---|---|---|
| **Interaction** | §2.5.2, §2.5.10; Ch. 1 §1.2 (empathic simulation; semantic benchmark) | The formal requirement of **attitude/intention inference** and **self-explanation** as conditions of social sensitivity |
| **Adaptability** | §1.3.2–1.3.5; §1.4; §1.5 | The formal treatment of **steerability, transparency of adaptation, and reversibility** |
| **Autonomy** | §1.4.5, §1.7.1; Ch. 1 §1.1 (autonomy as safety); §1.6.2 (autonomy as a fundamental condition) | The formal claim that these three capacities are **jointly necessary and jointly sufficient** for AI to be regarded as a **responsible social agent** |

---

## 1.9 Unit 1 Summary Table

| Syllabus topic | Core content | Must-know specifics |
|---|---|---|
| **Intro to AI / intelligent systems** | Near-term and long-term stakes | Self-driving (passenger vs. pedestrian); autonomous weapons (**who is at fault?** does deadly force **always** require meaningful human control?); predictive policing & risk prediction; robot carers and sex robots; **47% of US jobs** |
| **Vulnerabilities in ML** | 5 limitations | (1) **Data hungry** → privacy (Cambridge Analytica; GlaxoSmithKline/23andMe). (2) **Garbage in/garbage out** → Google Photo "gorillas" (Jacky Alcine). (3) **Faulty algorithms** → **overfitting**/**underfitting**/mis-weighted features → **interRAI / Arkansas DHS**, hospitalisations, use terminated. (4) **Black box** → interpretability/explainability/trust → parole at **74%**; post-hoc **dilemma**; **accuracy-vs-explainability** rebutted (willow/salicylic acid; lithium/glutamate) via **causal relations**; **adversarial attacks** (one-pixel ≈ ¾ of images; **0.04% of pixels → panda as gibbon at 99.3%**) → networks learn **superficial** features. (5) **Weak AI** → no consciousness, no moral sense → machine ethics |
| **Human vulnerabilities** | 4 cases | Facial recognition (**81% men / 74% women** on sexual orientation); deepfakes (**GANs**; Obama/Killmonger; **Pelosi at 75% speed** — "need not be convincing to be believed"); automation (**McKinsey 30% by 2030**; **Oxford 47%**; spinning jenny/steam engine counter-argument); robot companions (**Kondo & Hatsune Miku**; **Levy**) — **not genuine reciprocal relationships** |
| **Human rights framework** | Fundamental Conditions Approach | **Simmons'** definition; **FCA** = human rights protect the **fundamental conditions for pursuing a good life**; **basic activities / goods / capacities / options**; explains Art. 3, 18, 19, 20; **excludes** Art. 24 **paid** holidays (but not the **legal right**); **3 reasons** (compulsory; **Cranston** universal duty → proactive responsibility → **Project Maven**); **3 conflicts** (facial recognition/implants reductio; deepfakes/agency vs. expression; automation/right to welfare) |
| **Long-term AI** | AGCI vs. ACMI; control problem | **AGCI** = wide range of tasks; **ACMI** = cognitive **+ emotional + moral**; paper-clip maximiser has AGCI not superhuman intelligence; strong AI debate; **Gradual Substitution**; **Three Laws of Asimov**; value alignment; **sandboxing** & **kill switch** (persuasion, self-copying); **"join them"** = pharmacological enhancement + **BCIs** (**EEG, tDCS, ECoG, DBS**; ~**100,000** DBS implants; **hippocampus/entorhinal cortex**; **open-loop → closed-loop**; **Neuralink**) |
| **Autonomy / adaptability / interaction** | Dignum triad | ⚠ **Dignum unavailable.** Mapped to §1.4–1.5 (adaptability), §2.5.2/§2.5.10 (interaction), §1.4.5/§1.7.1 + Ch. 1 §1.1 (autonomy). Railton: autonomy as **safety** — refusal + accumulated evidence of harm; *"greater danger in creating highly capable artificial agents lacking any capacity to do so"* |

> ### Unit 1 — Eight Points to Remember
> 1. **No agreed definition of AI.** McCarthy (1956, "the science and engineering of making intelligent machines"); **Russell & Norvig's four** (acting humanly / thinking humanly / thinking rationally / **acting rationally** — they choose (d)).
> 2. **The historical arc:** symbolic AI/GOFAI (1950s–80s, if-then rules, **hard to revise**) → ML (supervised/unsupervised/reinforcement) → **deep learning** (many hidden layers; back-propagation; RNNs for sequences, CNNs for space, deep RL beat **Lee Sedol at Go**).
> 3. **The controlling distinction:** **vulnerabilities in ML** (the system is not good enough) vs. **human vulnerabilities** (the system is **too good**, and we are the weak link).
> 4. **Data is the ethical bottleneck** — data-hunger drives privacy violations; garbage in/garbage out produces "gorillas"; and the **black box** cannot be excused by the accuracy/explainability trade-off because deep learning **cannot track causal relations** — hence it is **defeated by adversarial attacks** and learns only **superficial features**.
> 5. **Weak AI has no moral sense**, and the three machine-ethics strategies each fail: **top-down** (can't tell when a rule applies; **we disagree which theory is right**), **virtue** (**the exemplar problem** — Mother Teresa? a racist dictator?), **case-driven** (only easy cases; *"a long way from giving them any sort of complete ethical decision procedure"*).
> 6. **The FCA is the answer to human vulnerabilities:** human rights protect the **fundamental conditions for pursuing a good life**; it can *include* (Arts. 3, 18, 19, 20) **and exclude** (Art. 24 **paid** holidays) claims — which is what makes it a theory rather than a list.
> 7. **Long-term AI requires separating AGCI from ACMI**, and even so the control problem resists all three strategies, because **anything smarter than us will develop its own values**, will **persuade its gatekeepers**, and will **copy itself** past the kill switch.
> 8. **The triad is Dignum's, not Liao's.** Use §1.8 as a map, not as a substitute; the Liao-sourced material on all three terms is sound and cross-referenced.

---

# UNIT 2 — Ethical Decision-Making, Responsibility and Design for Values

**Syllabus:** "Ethical decision-making in AI; ethical theories; values; ethics in practice; implementing ethical reasoning; responsible research and innovation; accountability; responsibility; transparency; and design for values."

**Sources:** Liao's Introduction §§I.3.5, I.4; Ch. 1 (Railton), Ch. 2 (Kamm), Ch. 3 (Bonnefon/Shariff/Rahwan), Ch. 4 (Loreggia/Mattei/Rossi/Venable), Ch. 5 (Wolfram), Ch. 7 (Asaro), Ch. 8 (O'Neil & Gunn).

---

## 2.1 Ethical decision-making in AI: what makes it hard

Unit 1 established that current AI is **weak** and **narrow** — no self-awareness, no consciousness, no moral sense — yet is increasingly deployed where **moral decisions must be made without human oversight**. Four structural facts explain why "just build it in" fails:

1. **We disagree at the level of first principles.** There is *"continuing disagreement over the fundamental principles of ethics"*, so there is no agreed answer to *which* principle to program (and Railton notes that even if there were, *"there is sufficient distance between fundamental principles and actual applications … that a large quantity of ethical understanding is needed in order to apply them — understanding that seems to come only with extensive individual and shared experience and is **not contained within the principles themselves**"*).
2. **Even the rule-systems that exist are incomplete.** *Ross's prima facie duties* — "perhaps the ethical theory closest to common sense in contemporary Western society" — can **come into conflict with no strict rules for determining which duties are weightier in a given case**; *"instead, Ross argued, we must have recourse to **intuition**."*
3. **Decomposing into smaller rules does not save us.** *"The actual situations we encounter are **too varied, and the kinds of considerations that need to be taken into account too diverse, to allow these rules to be more than rules of thumb**."*
4. **Hard cases are genuinely hard, and some people resolve them the other way.** *"Even with respect to the original trolley dilemma, some people believe that it is impermissible to hit the switch in Sidetrack, while others believe that it is permissible to push the large man off the bridge in Footbridge."* Liao does not treat this as defeat: *"History is replete with examples such as **slavery** where there were strong disagreements that have been resolved. Even so, at the very least, **more philosophical work will need to be done** before we can program a machine to act one way or another with respect to these difficult cases."*

**The two directions of the problem.** Ethical decision-making in AI is simultaneously about (a) **making machines decide ethically**, and (b) **deciding how humans will be governed by ethical rules expressed through machines**. Unit 2's later sections are the second direction: accountability (§2.6), responsibility (§2.6.1), transparency (§2.7), RRI (§2.8), and design for values (§2.9).

---

## 2.2 Ethical theories

### 2.2.1 The three theories, stated precisely (Ch. 4 §4.3)

| Theory | Definition given by Loreggia et al. |
|---|---|
| **Utilitarianism** | Action consequences are evaluated **on a numerical value scale** from good to bad, and an agent should choose the action that **maximises the net expected value** of its actions; that is, it chooses the action that has the **greatest difference between the benefits and harms** that result. |
| **Virtue ethics** | An agent should choose actions that satisfy **some predefined set of virtues**. |
| **Deontology** | Actions are **predefined as right or wrong** (via, e.g., **the categorical imperative**), and an agent should choose the right action, **no matter the consequences**. |

> ### The trap in the utilitarianism definition — memorise this
> **Net expected value ≠ greatest benefit ≠ least harm.** These are **three different quantities**, and the definition picks the first. *"This is not the same as choosing the action with the greatest benefit nor the action with the least resulting harm."*

### 2.2.2 Utilitarianism and the **calculation problem**

*"A well-known problem for utilitarianism is that it is **difficult to calculate when acting would secure the greatest good for the number**."*

- This calculation problem **applies to machine learning systems under consideration** — a utilitarian machine "aims to secure the greatest good for the greatest number" but cannot reliably compute it.
- Liao's example of what a passenger-priority protocol actually amounts to: *"Some manufacturers have suggested that the self-driving car should **prioritize the passenger**… This means that the car should hit the five people instead of endangering the passenger."* There is some plausibility: in ethics *"it is commonly held that under ordinary circumstances, we do not have to sacrifice our lives in order to prevent others from being harmed, especially if we are not at fault"*, and *"most people are unlikely to purchase a car that would sacrifice them for the greater good."* **But the Child case defeats it** — see §2.2.6.

### 2.2.3 Deontology and the **specification problem**

*"A problem with this top-down approach to machine ethics is that it can be difficult to know **when to apply a moral rule or principle** and **when the rule or principle has been satisfied**."* Concretely, Railton's list of irreducible questions: *"What constitutes a harm in a given instance? How to assess the relative magnitude of harms and benefits? When have the conditions of a promise been sufficiently undermined that it no longer binds?"*

### 2.2.4 Virtue ethics and the **exemplar problem**

*"It is not altogether clear **who is a virtuous agent** and **what a virtuous agent would do in a particular situation**."*

- **Would Mother Teresa be a virtuous agent?** Suppose she is — *"How would one know what Mother Teresa would do in a particular situation? Also, some people may not regard Mother Teresa as a moral exemplar."*
- **Who chooses?** *"Should we instead **let each person decide** who the virtuous agent should be? **What if someone's idea of a virtuous agent is a racist, malevolent dictator?**"*
- **The deep objection** comes later in Part I: Railton shows that virtue-style *character* reasoning is real but cannot be compiled — *"our primary access to our ethical understanding is not via highly general principles or judgments of particular acts, but via our general sense of the tendencies of certain kinds of traits of character."* This is what makes **embodied virtue** (§3.2.2) a *design approach* rather than a *specification*.

### 2.2.5 The overriding objection — and the two asymmetries

> **The objection that applies to all three:** *"not everyone believes that deontology and utilitarianism are correct moral theories. Given this, there are questions about **whether it is appropriate to build such moral theories into systems that are likely to affect everyone**."*

**Two further reasons the theories fail as *specifications*, from Ch. 4:**

1. **Theories differ in kind, not just in content.** **Some are what MacAskill calls "ordinal theories"** — *"there is no explicit numerical value associated with options, but rather an **ordering**."* A single numeric machinery cannot represent both cardinal (utilitarian) and ordinal (CP-net) preferences.
2. **People's ethical judgements are context-dependent — sometimes irrationally so.** *"While one may argue that ethical principles should be absolute and not context-dependent, the study of several dilemmas, such as the **Trolley Problem**, have shown that **what humans regard as ethical may very well be dependent on the context and sometimes for not a very clear or rational reason**."*

### 2.2.6 The **Trolley Problem** (Liao's Introduction; Railton's naming in §2.5.9; Kamm's critique in §2.6.4)

**Origin.** *"Philosophers initially used trolley dilemmas to question utilitarianism."* The term was coined by **Judith Jarvis Thomson**: *"the 'Trolley Problem' is the problem of explaining why our judgments differ between these two cases."*

**The three cases (Liao's Introduction):**

| Case | Description |
|---|---|
| **Sidetrack** *(= Railton's "Switch")* | A runaway trolley is headed toward **five people who will be killed**. You can hit a switch that will turn the trolley onto a **sidetrack where another person sits**, thereby **killing him instead of the five**. |
| **Footbridge** | As before, a runaway trolley is threatening to kill five people. You are standing next to a **large man on a footbridge** and you can **push the large man off the bridge**. The large man will die, but his body will stop the trolley from reaching the five, thereby saving the five. |
| **Empty Track** | A runaway trolley is headed toward five people who will be killed. You can hit a switch that will turn the trolley onto an **empty sidetrack where there is no one**. |

**The asymmetry.** *"In both cases, the choice is between killing one person and letting five others die. It seems that **utilitarianism would say that the actions in both cases are morally on a par** and that we should kill the one and save the five. However, many people believe that while it is morally permissible to hit the switch in Sidetrack and kill the one, it is **impermissible** to push the large man in Footbridge to save the five. **Suppose that people's judgments about these cases are correct. This would seem to call utilitarianism into question.**"*

**The classic explanation — the Doctrine of Double Effect (DDE).**

> *The DDE "relies on a distinction between **intending harm** and **merely foreseeing harm**."*

| Element of the DDE | Content |
|---|---|
| **The constraint** | *"There is a moral constraint on acting with the **intention of doing harm**, even when the harm is used as a means to a greater good."* |
| **The permission** | *"However, it is **permissible** to act with the intention of **employing neutral or good means** to promote a greater good, **even though one foresees the same harmful side effects**, if (a) **the good is proportionate to the harm**, and (b) **there is no better way to achieve this good**."* |
| **Application to Sidetrack** | *"you merely **foresee** the innocent bystander's death but you do not **intend** him to be hit as a means to saving the five"* → **permissible** |
| **Application to Footbridge** | *"it seems that you **intend** the innocent bystander to be hit by the trolley as a means to stopping the trolley from hitting the five"* → **impermissible** |

*"The DDE is not without its critics."* Other philosophers have offered alternative explanations. **Important later correction:** Kamm shows that what actually does the explanatory work is **not** the DDE at all — see **§2.6.4**, which is where the technical treatment belongs.

**What can be programmed — and what cannot.**

> *For our purpose, it might be thought that one could use **trolley-like scenarios to figure out people's judgments about various cases**. One might then be able to **program people's judgments about those cases into a machine**.*

| Case | Verdict | Status |
|---|---|---|
| **Empty Track** | *"there should be **no disagreement** that one should hit the switch"* | ✅ *"one could use **clear cases such as Empty Track to create some clear ethical boundaries for machines**."* |
| **Sidetrack / Footbridge** | disputed in both directions | ❌ *"some people believe that it is **impermissible** to hit the switch in Sidetrack, while others believe that it is **permissible** to push the large man off the bridge in Footbridge."* |
| Real-world hard cases | unknown | ❌ *"there are **many difficult real-world cases that would need to be resolved** before one could build these cases into a machine."* |

> **The verdict sentence to memorise:**
> *"Hence, **even if we could use the case-based approach to program some easier cases into machines, we are a long way from giving them any sort of complete ethical decision procedure**."*

**The real-world stress test — the passenger-priority protocol and the Child case.**

- Manufacturers suggest the car **prioritize the passenger**: brake malfunction, and the car can either hit five people on the road or swerve off the road and **kill the passenger** — *"Suppose that it is not the passenger's fault that the brakes malfunctioned."* Plausible: we do not have to sacrifice our lives to prevent others' harm, especially when not at fault; most people will not buy a car that sacrifices them; and *"always prioritizing the passenger seems like a protocol that could be technically implemented in machines in a straightforward manner."*
- **Child case:** *A runaway self-driving car is headed toward a child who will be killed. The car can swerve slightly to avoid hitting the child. **Swerving slightly has a low (but not zero) chance of harming the passenger**.*
  - **If the passenger has absolute priority, the car should NOT swerve**, since swerving introduces some risk to the passenger.
  - **But it seems that the car should swerve**, because *"the risk to the passenger is low and the benefit of not hitting the child is great."*
- **The conclusion:** *"This case suggests that it will not be straightforward to devise and implement protocols that would ensure the **safety of everyone involved**."*

> ### Key Point
> **The trolley problem is not merely a puzzle about the right answer. It is a diagnostic that the standard case-mixture of trolley cases is itself mis-specified.** Railton's empirical work (§2.5.9) shows four cases behave in a pattern that **defeats both standard explanations**, and Kamm (§2.6.4) shows that much of what AI ethics calls a "trolley problem" **is not a trolley problem at all.** Both results are exam favourites.

---

## 2.3 Values

### 2.3.1 Values **are** priorities over decisions

The formal definition used throughout Part I (Ch. 4):

> **"In our context, values are modeled as priorities over decisions, induced by either subjective preferences or ethical priorities, or their combination."**

So "value" is not a free-floating attitude. It is **an ordering over a set of possible outcomes (decisions)**, and it may be induced by:

| Source of the ordering | Example |
|---|---|
| **Subjective preference** | *we prefer red cars over blue; we prefer an adventure movie if a comedy is unavailable* |
| **Ethical priority / moral value / behavioural constraint** | *the doctor recommended a diet to avoid health issues, so we must **combine the doctor's guidelines with our taste preferences*** |
| **Both** | the normal case in AI decision-making |

### 2.3.2 Why preferences and ethical priorities must be modelled **separately**

> **The design requirement:** *"When trying to inject subjective preferences and ethical priorities in a machine, it is important to be able to **model these concepts, reason with them, and combine them, while at the same time to keep them separate in order to give them different weights**."*

**Why "keep them separate" is the crux.** If you collapse preferences and ethics into one number, you cannot ever say that one should override the other. And the normative rule is clear:

> *"While subjective preferences are important, **when preferences and ethical principles are in conflict, usually the latter should override the subjective preferences of the decision-maker**."*

> **The hiring example:** *"the preferences of the hiring committee members over the candidates should be measured against **ethical guidelines and laws, for example, ensuring gender and minority diversity**."*

**The multiagent framing.** *"Computer science views these interactions as **multiagent systems**. In a multiagent system, the different preferences and priorities, **one for each of many agents, are considered at the same time**."* Typical work: **modeling, aggregating, and reasoning** with these possibly competing preferences.

> ### ⚠ A caution the chapter insists on
> *"In this work we **do not seek to make normative judgments** about what should be done. Rather, this chapter shows how methods from computer science and preference reasoning can possibly be used to **compare two, possibly conflicting, preferences**."*

### 2.3.3 Social norms and laws as **"yet another agent"**

> **The design move:** *"social norms, regulations, and laws could provide guidelines to follow when making a decision **and also be modeled as yet another agent in the system**."*

**The running example:** *"While driving our car, we may want to **drive as fast as possible to get home sooner**, but **social norms and laws provide limits** to speed and dangerous driving behavior."*

**Why this is the right move for Unit 2.** It makes accountability and responsibility *representable*: the community's norms are an agent whose priorities can be measured against a user's, and the rule that "ethics overrides preference" becomes a **structural feature of the multiagent system** rather than a hope. (§2.9.2 turns this into a concrete algorithm; §2.9.3 does it for stakeholders instead of agents.)

### 2.3.4 What value-alignment means in this chapter

> *"We provide a (contextual) solution to the so-called **value-alignment problem**, which is concerned with being able to **model values and check alignment, compatibility, or distance between different values**."*

- *"We say that **two values are aligned if there is some distance that is small enough between the two priorities' structures**."*
- *"What **'small enough' means will vary by context**, but … if this value is set to **zero**, then the priorities must be **exactly the same**."*
- Compactness is not optional: *"ethical principles define the same kind of structures as preferences, that is, priority orderings over the possible decisions, … it is reasonable to **conjecture that ethical requirements will also need to be modeled compactly in order to be embedded into a machine**."* Humans *"are very good at abstracting away details that are not relevant"; artificial agents **don't have this luxury**.*

**The objection to the learning alternative — and the answer.** One could model ethics with **machine-learning modules trained on dilemmas and solutions**. But: *"it may not be acceptable that the artificial agent will not be able to **provide an explanation for why it judged one action 'more ethical' than another**"*; and *"**bottom-up approaches to ethics tie the results to the data on which the module is trained.** This may lead to undesirable outcomes if the data are **biased or not general enough**."* **Loreggia et al. take the top-down route** (an articulated CP-net), *"in the future one could imagine this CP-net being **learned from data**, giving us a more bottom-up flavour."*

---

## 2.4 Implementing ethical reasoning

**The programme of this section:** turn the abstract content of §2.2 and §2.3 into machinery that can actually run inside a machine. Four steps: **choose a formalism** (§2.4.1) → **model the ordering** (§2.4.2) → **measure the gap and threshold it** (§2.4.3) → **check that the public will accept it** (§2.4.4–§2.4.5).

### 2.4.1 From theories to formalisms — constraints

**Hard constraints (Ch. 4 §4.2.1).** *"Model **restrictions on the combination of values** that some decision variable can take."* Example: one decision variable per activity over a time line, with the constraint that **activity A must occur before activity B**. With a hard constraint, **each combination of values is either feasible or not**; given several, the **global scenarios declared feasible** are those in which **all** constraints are satisfied.

> **Map to deontology:**
> *"Hard constraints appear to be **ideal for modeling deontological ethics**."* Define a constraint problem in which **actions are complete assignments to a set of decision variables** modelling their different aspects and components, and the **constraints model ethical restrictions**. Then:
>
> | Verdict | Formal meaning |
> |---|---|
> | **Permissible** | one of **several** solutions to the constraint problem |
> | **Impermissible** | **not** a solution |
> | **Obligatory** | the **only** solution |
>
> **Note what this achieves: the obligatory/impermissible distinction falls out of the mathematics, not out of an extra rule.**

**Soft constraints.** *"Generalize the notion of constraints to allow for **more than just two states** (feasible or not) … a soft constraint involves a set of decision variables and **associates a value from a (totally or partially ordered) set to each instantiation of its variables**."* This allows *"a more fine-grained notion of constraints, thus resulting in an **ordering**."*

**Two named classes — and this is the exam-relevant part:**

| Class | Values | Aggregation operator | Goal | Use it for |
|---|---|---|---|---|
| **Fuzzy Constraint Satisfaction Problems (CSPs)** | values **between 0 and 1**; higher = higher preference | **min** operator — *"we take the worst preference, which by definition is the min of the two values"* | **maximise the minimum preference** | **safety-critical applications such as self-driving cars or medical devices**, *"since we focus on the **worst preference value** when we evaluate a complex decision"* |
| **Weighted CSPs** | natural or real values interpreted as **costs or penalties**; **lower = higher preference** | **sum** | **minimise the sum of the costs** | **utilitarianism** — *"it is easy to translate the principle of maximizing utilities to that of minimizing costs"* |

> ### The three formalisms → three theories (memorise this table)
> | Theory | Formalism | Why |
> |---|---|---|
> | **Deontology** | **Hard constraints** | permissible = one of several solutions; **obligatory = the only solution** |
> | **Utilitarianism** | **Weighted constraints** (minimise sum of costs) | *"the natural choice … which aims at maximizing utilities"* |
> | **"Ethical" holistic judgement** | **Fuzzy CSP / min operator** | *"a violation of 'ethical' constraints on **any** component should affect the quality of the entire option"* |
> | **Virtue ethics** | *(no direct quantification)* | — see §2.2.4; also Ch. 13, §3.2.2 |

**Two advantages of soft constraints specifically.**
1. *"**Any partial order can be represented.** This is not true for other models, such as, for example, CP-nets."* This matters because *"ruling out some orderings may mean that the model may be able to represent **not the 'true' ethical ordering but only an approximation**."*
2. *"**Different combinations of operators can be chosen in order to aggregate preferences from different constraints.** This can be useful if we want to **model different ethical theories**."*

**Complexity note.** *"In general, finding an optimal solution for a hard or a soft constraint set is **computationally hard**."* However, it is polynomial for some classes; and *"measuring the distance between CP-nets is computationally hard, but … we have developed **efficient and accurate approximation algorithms that work well in practice**."*

**The open question the chapter flags.** *"What is the set of properties of a preference aggregator that makes it suitable for handling ethical requirements? Some may be obvious, for example, **commutativity**. Others may be a point of discussion, such as … the fact that **the aggregation of two ethical preferences cannot be 'more ethical' than each of the two original preferences**."*

### 2.4.2 **CP-nets** — Conditional Preference networks

> **In one sentence:** *For readers familiar with Bayesian networks, **CP-nets resemble Bayesian networks but replace probabilities with preferences**.*

First proposed by **Boutilier et al.**

| Property | Detail |
|---|---|
| **Purpose** | *"A graphical model for **compactly representing conditional and qualitative preference relations**."* |
| **Building block** | sets of **ceteris paribus preference statements (cp-statements)** |
| **Anatomy of a cp-statement** | *"I prefer red wine to white wine **if meat is served**"* — *"given two meals that differ only in the kind of wine served and both containing meat, the meal with red wine is **preferable** to the meal with white wine."* |
| **Features and parents** | Each feature (here *type of wine*) is given a set of **parent features** that can affect preferences over its values (here *meal*). This defines a **dependency graph** whose nodes are features and whose predecessors are parent features. |
| **Acyclicity** | Cyclic CP-nets are possible in principle (wine depends on main, main depends on wine) but *"it is both **hard to interpret the semantics** of cyclic CP-nets and **computationally hard** to reason with them as well. Indeed it would be hard to understand humans with cyclic preferences too. Due to these issues, we restrict our discussion to **acyclic CP-nets only**."* |
| **Semantic core — the **worsening flip**** | *"A worsening flip is a **change in the value of a variable to a less preferred value according to the cp-statement for that variable**."* This **induces a preorder over the outcomes, which is always a partial order if the CP-net is acyclic**." |
| **Complexity** | Finding the optimal outcome is **NP-hard** in general; but *"in **acyclic** CP-nets, there is only **one** optimal outcome, and this can be found in **linear time** by **sweeping through the CP-net dependency graph** while following the dependencies, **assigning to each feature the most preferred values in the corresponding cp-table**."* |

**Why CP-nets and not constraints?** Because some theories cannot be quantified — they are **ordinal**. *"...under ordinal theories there is **no explicit numerical value associated with options, but rather an ordering**. For such theories **qualitative preferences**, such as those modeled in CP-nets, may be a better option."*

Three further appeals:
1. **Conditional statements can be modelled** — and people really do judge contextually (§2.2.5).
2. **No numbers required** — *"numbers may be a **cumbersome and tedious** way of representing even mundane preferences. When it comes to **ethical requirements this argument may become even stronger**."*
3. **Elicitation, optimisation, search, and aggregation all work** — CP-nets are *"easy to elicit and provide efficient methods for optimization, search, and reasoning"*; and in collective decision-making **several CP-nets can be aggregated, for instance using voting rules, to find compromises and reach consensus among several decision-makers.**

**Two weaknesses (state both).**
1. *"Some orderings **may not be represented**."* (Soft constraints can represent any partial order; CP-nets cannot.)
2. **Latency.** *"given two decisions, understanding whether one is more desirable has a **very high computational complexity**. This may be unacceptable in situations where the agent is confronted by a dilemma involving **two options, both with some catastrophic effect, and a decision must be made in a short amount of time**."* — i.e. exactly the self-driving emergency.

**Why CP-nets count as "white box".** *"Having a formal structure to model preferences, especially one that **directly models the possible dependencies between various features and/or options**, enhances the **transparency and explainability** of automated decision-making systems … these structures make explicit the properties of the model; that is, they are **'white box' models instead of opaque or 'black box' models**."* Reinforced by: *"the **Engineering and Physical Science Research Council's Principles of Robotics** requires the implementation of **transparency** in robotic systems and autonomous decision-making systems as **'a mechanism to expose the decision making of the robot**'"*, and by the claim that *"explanation and transparency [are] the **cornerstones of trusted AI systems**."*

**White-box matters for ethics, not just trust.** It is the technical basis for the **"white box" / explainability** commitment in §2.9.2 and for the transparency requirements in §2.7 — if you cannot read the model, you cannot check whether the ethics was respected.

### 2.4.3 Value alignment as **measurement**: distance, I-CPD, and thresholds

This is the operational heart of the chapter and one of the most examinable parts of Unit 2.

**The four axioms a distance function must satisfy.** *"Mathematically, one defines a **distance function or metric** between two points, A and B, that must satisfy the following four criteria"*:

| # | Axiom | Content |
|---|---|---|
| 1 | **Non-negativity** | the distance between A and B must be **≥ 0** |
| 2 | **Symmetry** | the distance between A and B must be the **same as** the distance between B and A |
| 3 | **Triangle inequality** | the distance between A and B must be **less than or equal to** the distance to any third point C |
| 4 | **Identity of indiscernibles** | if the distance between A and B is **zero**, then **A = B** |

*(Intuitively illustrated with the **Spearman foot-rule distance**: *"which measures the position in the list of the movies you wanted to see versus the one that you did see."*)*

**The ideal object and the practical approximation.**

| | Detail |
|---|---|
| **Ideal** | *"Since CP-nets are a compact representation of a partial order over the possible decisions, the ideal notion of distance is a distance **between the induced partial orders** of the CP-nets."* |
| **The obstacle** | *"the **size of the induced orders may be exponential** in the size of the CP-net, and in general computing a distance between these induced partial orders is **computationally intractable**."* |
| **The approximation** | *"Therefore we use a tractable approximation, called **I-CPD** … which is computed **directly over the CP-net dependency graphs** and has been shown to exhibit a **limited error** with regard to the correct distance."* |

**The full value-alignment procedure — and the two thresholds.**

1. **Compute the distance** between the *subjective preferences* CP-net and the *ethical principles* CP-net (of the individual, or of the community, or both), using I-CPD.
2. **Apply the first threshold.** *"The system makes decisions using the **subjective preferences only if they are close enough** to the ethical principles, where being close enough depends on a **threshold over CP-net distances**."*
3. **Who sets the threshold?** *"These thresholds are **context-dependent** and will need to be **decided upon by all the stakeholders of the system — the designers, implementers, community, and leaders** — where they will be deployed."*
4. **If the preferences diverge too much, escalate along the preference ordering.** *"we **move to a less preferred decision** until we find one that is a **satisfactory compromise** between the ethical principles and the user preferences."* The compromise point is defined by **a second threshold over distances between decisions**.

> ### Key Point
> **Value alignment, in this chapter, is not a claim about what an AI *wants*. It is a *measurement* plus *two thresholds* plus an *escalation procedure*.**
> - **Metric axioms:** ≥0, symmetric, triangle inequality, zero iff identical.
> - **I-CPD:** the tractable stand-in for the intractable distance between induced partial orders.
> - **Threshold 1:** preferences are followed *only if* close enough to ethical principles.
> - **Threshold 2:** if not, move to a less-preferred but compliant action.
> - **Both thresholds are multi-stakeholder decisions** — designers, implementers, community, leaders.
> This is the whole of §2.9.2's "design for values" in operational form.

**The worked domain.** The authors' example models **autonomous or human-operated vehicles**: each driver (or vehicle) has its **own subjective preferences or ethical priorities** over possible actions in situations **for which the traffic laws do not prescribe a specific behaviour**, and there may be **collective ethical guidelines a community would like all drivers to follow, with some tolerance**. They take inspiration from the Trolley Problem — and from the **Moral Machines project**, which *"collected a large number of **pairwise choices** and analyzed the data from various points of view."*

**The stated future work.** Probabilistic versions of CP-nets already exist; *"understanding **how to combine them with ethical reasoning** is an important next step"* — *"in real life there are **probabilities associated with our actions**."*

### 2.4.4 Ethics in practice (i): the **ethical opt-out**

> **Where the detail lives:** the full treatment of the opt-out is **§2.6.6**; the moral-psychology methodology is **§2.6.7**. Read both. What follows is the framing.

- The practical obstacle sits **between "we have decided the right principle" and "the principle has any effect."** Even if ethicists reached perfect agreement, their work would have **little impact if laypersons strongly disagreed with them and decided to opt out.**
- **The trust deficit:** most people happily use AI-driven technology *as long as they are not fully aware they are doing so*, but express **anxiety and mistrust about things labelled AI**. Only **8%** would trust the mortgage advice of an AI program — *"a shade lower than the **9%** who would trust their horoscope for investment advice."*
- **The remedy:** *"many benefits of AI technology require people to **opt into an algorithmic social contract**, an agreement between citizens, **mediated by machines**."* And: *"we must **understand what principles people expect moral AI to follow**, lest they opt out from using, enabling, or allowing beneficial AI-driven technology. And we need this understanding **regardless of whether we think people should be educated or accommodated**."*

### 2.4.5 Ethics in practice (ii): **stylisation must be calibrated to the domain**

> **Where the detail lives:** **§2.6.7**. What follows is the framing.

- **The general problem:** *"Moral preferences are **fluid, multifaceted and nuanced**. To measure them is to accept that much **complexity is lost in the measurement**, and some measurement techniques **inevitably amount to presenting people with highly simplified, stylized problems — problems that sacrifice realism in order to cut at the joints of moral preferences**."* Drawing on **moral psychology**, **experimental economics**, and **human behavioural ecology**.
- **Different domains call for different degrees of simplification.** The three calibration verdicts:

| Domain | Verdict | Reason |
|---|---|---|
| **Autonomous vehicles** | **Stylisation IS justified** | *"experimental psychologists (and experimental philosophers) simply ask people to accept the premises of the problem **in order to discover fundamental principles and processes** underlying moral judgment … the Trolley Problem **has led to many important insights about human morality, despite (or thanks to) its unrealistic simplicity**."* |
| **Kidney paired donation** | **No stylisation needed** | Real scoring criteria exist; the questions are about **cutoffs and relative weights**, not invented dilemmas |
| **Algorithmic sentencing** | **Hardest, and most in need** | Proprietary opacity; and the trade-offs include **mathematically incompatible fairness notions** |

- **The governing moral:** *"...different domains of application **call for different degrees of such simplification**"* — stylisation is a **methodological choice with a burden of justification**, not a default.

---

## 2.5 Ethical learning, natural and artificial (Ch. 1, Railton)

**This is the intellectual foundation of all of Unit 2** and, in Liao's phrase, the answer to *"the continuing disagreement over overarching ethical theories such as deontology, utilitarianism, and virtue ethics."*

> **The Part I thesis, as stated by Liao:**
> *"if we nevertheless want to develop machines that are as ethically trustworthy as ordinary humans, we should consider **models that resemble human moral learning**. In particular, **just as infants learn ethics in part by observing adult behavior**, Railton proposes that we could **build machines that would also be able to learn ethics by observing human behavior**."*

### 2.5.1 The question: **sensitivity to ethically relevant features**

Railton declines to address any particular application domain (work, communication, governance, mobility, medicine, warfare). He addresses *"a question that could be relevant to all of them, since it concerns **the nature of artificial intelligence itself**."*

- **The motivation:** *"Increasingly, artificial systems will be exercising **life-affecting functions or making life-affecting decisions** — in piloting a vehicle, in home healthcare, in hiring and firing, in monitoring and shaping the information we receive — that we would not ordinarily entrust to someone lacking in sensitivity to ethical concerns."*
- **The two questions:**
  1. *"How, then, might artificial systems come to be **appropriately sensitive to ethical concerns**?"*
  2. *"Moreover, **how might such sensitivity be a core part of their intelligence and capacities?**"*
- **The working definition:**
  > *"To a first approximation, we can characterize sensitivity to ethical concerns as **a robust, reliable capacity to detect and respond appropriately to ethically relevant features of situations, actions, agents, and outcomes**."*
- **Why the answer depends on it:** *"Our answer to questions about how we can responsibly develop or deploy artificial systems **will depend significantly upon the extent to which such apt responsiveness to ethically relevant features is possible**."*

**Social, not instrumental, relations.** As AI becomes more general and capable *"it will give rise not only to new technological possibilities, but to **new classes of agents that operate independently of direct human supervision or control, and with which we can increasingly have social rather than merely instrumental relations**."* (Full argument in §2.5.6; safety consequence in §1.8.3.)

### 2.5.2 A social perspective: ethics as a **root feature** of general intelligence

**The neural-net analogy that opens the section.** *"Artificial neural networks … were originally inspired by the thought that **naturally occurring cortical architecture is the result of countless generations of selection for a capacity to learn and act intelligently**, and so is a plausible basis upon which to build artificial intelligence."* Now that networks are deep and fast and data plentiful, *"this inspiration is bearing fruit."* **The proposal:** *"as we look forward to the development of general artificial intelligence, we should look for inspiration at the most distinctive characteristics of the naturally occurring creatures that appear to have achieved the highest levels of general intelligence: **humans**."*

**Humans are distinctive as much for social capacities as for intellect.** *"Many animals live in complex social groups, but humans are unusual in the extent of their capacity for **large-scale co-ordination and cooperation with nonkin**, **open-ended exchange of information**, and **normative self-regulation in light of long-term, abstract impersonal goals**."*

> **The consequence for the definition of general intelligence:**
> *"If one thinks of general intelligence as a capacity for open-ended problem-solving, then **our capacities for building and sustaining shared practices to solve shared problems are central to our general intelligence**. These capacities enable us to create **epistemic as well as ethical communities**, leveraging our individual abilities in ways that can carry us far beyond anything we could accomplish as individual agents or inquirers."*

**The core architectural claim — root connection, not an add-on.**

| Design | What it implies |
|---|---|
| Ethics as **a novel capacity or set of principles added to an already fully formed general intelligence** | *"it might also be imagined that this capacity or these principles **could readily be subtracted** from such an intelligence **without cognitive loss**"* |
| **Root connection** between full responsiveness to *epistemically* relevant features and full responsiveness to *ethically* relevant features | *"responsiveness to ethically relevant features could be a **deep feature** of artificial systems with high general intelligence and problem-solving ability, **not easily removed without serious impairment of other aspects** of general intelligence and problem-solving."* |

**The supporting evidence: psychopaths.** *"Some psychological disorders that seem to impair the development of appropriate responsiveness to ethically relevant features, such as **psychopathy**, tend also to have costs to the full development of more general human intelligence, understood as **problem-solving ability**."*

- Contrary to the popular idea of the psychopath as *"the height of rationality, intelligence, control, and savvy,"* research indicates **serious deficits in attention, impulse-control, and ability to accurately represent likely negative future outcomes** — for themselves and others. *"These deficits then help explain the difficulty of psychopaths in **holding themselves to long-term goals, plans, or relationships**."*
- **Machiavellian personal disorders** may be *"quite intelligent by conventional measures"* and can *"achieve considerable long-term success by **taking advantage of the vulnerabilities** of ordinary agents and practices"* — *"but it is one thing to be able to **exploit an existing epistemic community** and another thing to be able to **build and sustain one that is as effective as possible at gaining knowledge**. The latter is closer to the ultimate goal of artificial intelligence research."*

**The commitments these agents must be able to make.** Artificial systems capable of *"projecting and evaluating future courses of action, of **assessing benefits and harms to self and other**, of **making commitments**, and of **regulating their own behavior**"* are *"capable of something like **social-contract reasoning**: we could **negotiate with them terms of mutually beneficial cooperation** that all of us would constrain ourselves to follow."*

**Crucially, this does not require consciousness or human-like emotion.** *"This capacity for social-contract reasoning, and for mutual constraint for mutual benefit, **does not presuppose a capacity for qualitative experiences or emotions akin to humans**."* In humans, an actively norm-governed life is *"greatly enhanced"* by **empathic simulation** and emotions such as **loyalty, guilt, forgiveness** — *"but an actively norm-governed life **does not seem to require** such feelings, **so long as** there are sufficiently developed **agential capacities for self-regulation, representation of others' goals and information, and the formation of conventions, agreements, or commitments**."*

**Why this matters even before superintelligence.** *"Even before we have to contend with possible 'super-intelligences,' we will need to ask how to contend with artificial agents **from whose capacities we could greatly benefit but whose cooperation with us will not be entirely up to us** and may depend upon negotiation in which we seek to find common ground."* And: *"for intelligent systems to be able to robustly and reliably detect and respond to ethically relevant features **they may need to have at least this much autonomy in deciding whether to work with the particular human or artificial agents who might seek to control them, and for what purposes**."* → cross-ref. **§1.8.1, §1.8.3.**

**Empathic simulation without feeling** — the distinction to keep sharp. *"an artificial system can engage in empathic simulation **without 'reliving the experience' of others** if artificial systems can become sufficiently skilled at **modeling others' internal states on the basis of observed behavior** and can **accord intrinsic weight to others' imputed goals or utility functions in evaluating simulated courses of action** during decision-making."*

**The semantic benchmark for responsive understanding.** *"Consider … the fact that developing artificial systems capable of being effectively responsive to a range of semantically relevant features in natural language need not await the development in such systems of the full range of human thought and feeling."* No artificial system could grasp the full meaning of *"Where are the snows of yesteryear?"* without feeling a pang of nostalgia — *"but a genuinely intelligent artificial system might nonetheless be able to **represent the essential semantic features** of this sentence and to **capture enough of the pragmatics of English usage** to give it a suitable English translation… rather than, say, the flat-footed 'Where are the snows of previous years?'"*

**The learning-mechanism parallel — the crucial bridge.** *"recent developments in artificial natural-language processing suggest that artificial systems **may be able to learn underlying syntactic and semantic structures of language from the task of developing compact, hierarchical, predictive, or generative models of large bodies of linguistic data** … Unlike systems that are **preprogrammed with grammatical information**, these systems use **fairly generic learning methods to 'acquire' from exposure to language data latent structures** in language."*

> **Railton's question, and the whole chapter in miniature:**
> *"Might similar kinds of **general-purpose learning capacities** enable artificial systems to **extract from the context of human interaction ethically relevant latent structures** of situations, actions, agents, and outcomes? And might this in fact be **much closer to the way actual humans become sensitive to ethically relevant features or make ordinary, 'intuitive' ethical judgments**?"*

### 2.5.3 A developmental perspective

**The intellectual context: the collapse of innatism.** *"Recent years in developmental psychology have seen the emergence of **learning-based, 'constructivist' or 'theory forming' approaches** to cognitive phenomena previously attributed to specialized **'innate modules**'."*

**The case that started it — language.** Infants receive *"relatively little explicit instruction in language in their early years"*, yet acquire *"a remarkable degree of fluency in understanding and producing an open-ended array of novel sentences in their native tongue."* Positing an innate generative module seemed to be **the only explanation**, given the limitations of *"associative learning"* and *"the disproportion between the finite amount of language and language training … and the open-ended competence they acquire."* This is the **poverty of the stimulus** argument. *"But is the stimulus really impoverished? And is 'associative learning' really so limited?"*

**Why innatism was always going to have a bootstrapping problem.** *"Infants begin life in a complex, continuous acoustic environment within which they must learn to **distinguish overheard language from other elements in the continuous stream of sounds and noise**, and to **attend to overheard language closely enough to detect patterns** that permit the extraction of discrete, recurring units and combinations … despite, for example, the wide variation in the acoustic profile of individual voices. Moreover infants need to be able to **detect signs of adult attention** and to **track the intended referents of adult gestures or words**. These are already formidable learning tasks … and **they must be solved for her specific acoustic and social environment. An innate grammar module on its own would not equip the infant to accomplish them. What could?**"*

**The probabilistic-learning evidence base (infant milestones to know).**

| Age | Capacity |
|---|---|
| **First weeks** | *"have begun to **discriminate overheard speech** from the rest of their acoustic environment and are beginning to form **calibrated expectations about phonetic regularities**, which are manifest in greater surprise at, and interest in, novel or anomalous sequences of phonemes — **a characteristic feature of probabilistic learning**."* |
| **Nine months** | *"can **discern others' goals** on the basis of their behavior."* |
| **12–16 months** | *"can **relate means to goals**, **follow others' attentional cues**, engage in **joint attention**, and identify the **intended referents of their words or gestures**."* |

**The conclusion.** *"The stimulus infants receive, then, is **not so impoverished after all**, stretching over many months of observation of the behavior of persons and objects in their near vicinity. And **probabilistic forms of learning turn this seemingly 'passive' experience into more than 'mere association.'** Instead it is a form of **active experimentation**, with the continuous formation of expectations on the basis of observed associations and continuous **feedback from discrepancies** between those expectations and actual outcomes."*

**The structural pay-off.** *"Since the physical and social world contain very significant structure, **more effective and efficient prediction pushes infant learning in the direction of representing such structure, favoring the development of internal models that use abstraction and hierarchy to generalize projectively, without the need to posit an innate 'language module**.'"* (The infants' *"Goldilocks effect"* — allocating attention to sequences that are neither too simple nor too complex — is the evidence for this.)

**The **Good Regulator Theorem** — the bridge from learning to action.** *"Ideally effective and efficient regulation of a system requires the **building and use in decision-making of a model of that system** — a model representing the underlying structures and potentials of the system. Such a model can be used in a **forward direction for intelligent simulation and action selection**, and in an **inverse direction for learning from subsequent experience**."*

**Causal and social learning are intimately linked.** *"No part of the infant's causal environment is more important for her than **the agents in her life**, so that **causal and social learning are intimately linked, and intuitive psychology emerges alongside intuitive physics**. It would … be very difficult for the infant to build a predictive model of the world around her **without taking into account the distinctive ways in which agents behave**, and beginning to model the 'internal' as well as external sources of such behavior — **much as infants begin to model latent as well as manifest causal relations**."*

**Theory of mind, developed piecewise.** Infants develop *"piecewise an increasingly complex **'theory of mind'** or model of agents as continuing entities whose behavior is the product of **perception, motivation, emotion, belief, and intention**."* And crucially:

> *"while the infant might start by using her own mind as a matrix for understanding others and their actions, **the pressure to develop more reliable expectations of others pushes in the direction of representing others' mental states in their own right — not as projections of the infant's own states**."*

**The gradient of differentiation:** *"We see emerging in infants an ability to grasp that others may differ, **first in motivation, then in belief, then in perceptual knowledge, then in possessing false beliefs, and then in hidden emotions**."*

**Non-egocentric spatial representation.** *"Spatial representation in foraging animals (ourselves included) appears to involve the **construction through experience of non-egocentric as well as egocentric maps** … Likewise infant mapping of social space and its possibilities involves an ability to represent how things are in non-egocentric as well as egocentric terms, making possible **accurate, less position-dependent simulations of potential social interactions** and evaluation of their likely outcomes."*

**Why non-egocentricity is the ethics-relevant capacity.** Over the first years, when infants have limited causal powers of their own, *"**observation of others' actions and outcomes** plays a fundamental role in the development of their own expectations and understanding."* And:

> *"The **non-egocentric epistemic evaluation of others** — observing others' interactions to map the **reliability and competence of agents in their interactions with third parties** — comes to play a critical role in shaping **who infants are disposed to imitate or learn from, independent of personal affiliation**. … this ability to form and be guided by non-egocentric as well as egocentric representations and evaluations, which might be **driven in the first instance by the need for accurate prediction**, is of **special interest for ethical development** in children, since among the fundamental features of ethical evaluation are that it calls for an ability to represent non-egocentrically (a) **the nature and magnitude of the concerns of others**, (b) **the likely results of one's own actions**, (c) **the causal-intentional structure of others' actions**, and (d) **whether others are reliable or trustworthy**."*

### 2.5.4 Default trust and default cooperation

**Two prior-dispositions, plus basic faculties.** Railton identifies what a developing psyche needs:

| Disposition | Content |
|---|---|
| **Curiosity** | *"a form of **internal motivation to learn above and beyond any more specific purpose** the infant might have"* — *"infants need to be **motivated to attend carefully to experience and to notice patterns**. They need to **form expectations** based upon such patterns, and to **find failed expectations discomfiting in themselves, even when this does not directly touch their interests**."* Crucially: *"they need to respond to such anomalies by **increasing their attention and effort, not by simply shrinking the scope of their expectations**."* |
| **Default, defeasible trust** | *"infants are also disposed to **rely upon or trust their own faculties** — perception, association, memory, and so on — **even without any guarantee of the reliability of these faculties**."* |
| **Default cooperation** | *"infant responsiveness **reinforces adult attention**, facilitating development of reliable channels of communication between infants and caregivers that do not depend upon language."* |

**Why default trust is logically necessary (the bootstrapping argument).** *"Without such a disposition toward default reliance or default trust, even an infant **natively equipped with good eyes and ears and a keen mind would remain trapped in ignorance**. After all, **any evidence she might gather of the reliability or unreliability of her faculties would already depend upon the use of those faculties, in effect giving them some measure of default epistemic authority**."* *"Once some measure of default reliance or trust is in place, then the formation of expectations can begin to **generate feedback from subsequent experience — a kind of bootstrapping**."*

> **Bootstrapping ≠ indefeasibility.** *"Default reliance and trust operate in the service of **generating more determinate guesses, creating the potential for more informative errors**, and **growing more selective or calibrated over time**."*

**The prior metaphor.** *"we can think of such default, defeasible trust as a **'prior'** that enables the infant to **cooperate with her faculties, by 'playing' a cooperative move on the first turn** … **yet with no security that her faculties will prove cooperative in return**."* And: *"for her to refuse to extend any unsecured cooperation to her faculties … would be a **self-defeating epistemic strategy** — not by incurring a risk of believing something false but by **undermining the possibility of believing anything at all**."*

**The same structure applies socially.** *"an infant initially disposed **not** to rely upon or trust those around her until she has confirmation that such reliance and trust will be well-placed **would cut herself off from the very experiences she would need in order to learn whom or what to trust, and how much**."*

**The infant evidence for default cooperativeness.**

| Finding | Detail |
|---|---|
| **Reciprocate care** | *"Infants are typically disposed to **reciprocate care**, to the extent that they can."* |
| **Spontaneous helping** | By the **second year**, infants *"are spontaneously disposed to **initiate an attempt to help an adult complete a failed task, even a stranger, and without encouragement or promised reward**."* |
| **Spontaneous sharing** | Toddlers who have participated in a successful shared task with a novel partner are *"spontaneously motivated to **share the gains achieved by the task**, again without explicit encouragement or reward."* |

**Why cooperation among strangers is possible at all — Hobbes plus modern evidence.**

- **Hobbes** (over three hundred years ago): *"mutually beneficial cooperation among strangers is possible when individuals are **disposed to initiate cooperation without requiring initial security** (e.g., as a credible way of signaling willingness to cooperate) and to **reciprocate cooperation when it is received**."*
- **Game theory:** *"this set of dispositions can become **widespread within a population and be effective in resisting 'invasion' by more opportunistic agents**."*
- **Anthropology:** *"a large-scale survey of hunter-gatherer societies suggests that a capacity for coordination and cooperation with others, **including nonkin, mediated by forms of reciprocity that are indirect and temporally extended**, may play a central role in explaining how human hunter-gatherers have succeeded over millennia in maintaining **egalitarian social cohesion in the face of limited resources, without the forms of dominance hierarchy found in the great apes**."*
- **Recent research:** *"the disposition to give weight to the interests of others that is **not simply mediated by one's own interests** is something like the **default stance of ordinary human interaction** and can be **self-reinforcing** — including, one might stress, **human communication and information exchange, as the norms of conversation attest**."*

> **The summary claim of §1.4:**
> *"So much of what we think of an individual human's **general human intelligence or problem-solving capacity is really social in origin, character, or operation** … **the ability to initiate and sustain productive social connectedness with others [is] an additional basic faculty of learning**, which supplements other basic faculties like perception, memory, and reasoning. **Default cooperative dispositions with respect to others therefore are as much a part of the human capacity for learning as default cooperative dispositions with respect to one's own basic mental faculties.**"*

**Language as the exemplary case — see §2.5.10 for the full treatment** (the reciprocity condition and communicative ethics).

**The evolutionary contrast that closes the section.** *"Individual human intelligence and problem-solving ability at age two is said to be **quite comparable to that of a chimpanzee of the same age**. But human two-year-olds are able to do something **even adult chimpanzees are not** … to **come together spontaneously with others to accomplish a task requiring joint attention and coordinated playing of understood roles**, and, equally spontaneously, to **share the rewards of cooperation with others without further incentive**."* *"The divergence in cognitive accomplishment and practical problem-solving that comes as humans work together — the emergence of **shared languages, of extensive forms of social learning, culture, and exchange** — explains why **Homo sapiens could overrun the planet** … while **Pan troglodytes** is at risk of disappearing from the wild."*

### 2.5.5 The parallelisms: theory of mind **↔** ethical responsiveness

**The pivot sentence.** *"We have spent so much time on the questions about the capacities underlying aspects of language and epistemic development because **they afford us insight into the capacities that underlie ethical development as well**."*

**Communicative ethics is built on the parallel.** *"It is no accident that **the norms of conversation** — of **mutual recognition**, of **according others some authority to contribute**, of **seeking to determine the communicative intent of others and signaling this to them**, of **seeking to reply in ways that could be comprehensible, relevant, and responsive to others' concerns**, and so on — **are so close to norms for productive epistemic exchange**. Now we will add: **it is no accident that they are also so close to norms for ethical interaction.** Indeed **a large and influential tradition in ethics, communicative ethics, is built around this fact**."*

**The central parallelism, stated exactly.** *"**Just as there was a parallelism in the development of causal understanding and theory of mind, there is a parallelism in the development of theory of mind and capacity to be aptly responsive to ethically relevant features.**"*

**Theory of mind predicts ethical competence.** *"a child's development of theory of mind is **predictive of her current and future maturity**, as manifest in the ability to form positive relations with peers."* The resulting skills are, *"even controlling for other abilities"*:

- **understanding the needs and interests of others, even when different from oneself or one's group**;
- **standing up for one's own opinions, needs, and rights**;
- **successfully joining new groups or welcoming new members into one's own group**;
- **playing or working together with peers without conflict**;
- **coping with conflicts that do arise**.

> *"These are all skills that involve **apt responsiveness to ethically relevant features, as understood by virtually any widely held ethical theory**."*
> *(This is the crucial step: a fact about development that is neutral between deontology, utilitarianism and virtue ethics — which is precisely why it survives their disagreement.)*

**Intent assessment is the core bridge.** *"**Assessment of intent** is a core component of understanding the causal, epistemic, and ethical character of an action, so acquiring the ability to **distinguish intentional from unintentional actions** is important for **prediction** (e.g., what to expect next), **learning** (e.g., whether an adult error was the result of ignorance or is a sign of unreliability), and **ethical assessment** (e.g., whether a harmful action by an individual was an accident or is a sign of ill will or untrustworthiness)."*

> **By the end of their first year infants have begun to use situational cues to determine whether an action is intentional to modulate their responses in all three domains.**

**Two further features of ethical development — it is earlier, more basic, and more autonomous than instruction.**

1. *"Ethical development appears to **begin earlier than the explicit inculcation of social norms by adults** and also to develop in ways that are both **more basic** — for example, in **grasping what behavior, in a given context, constitutes a harm** — and **more autonomous than external instruction**."*
2. **Autonomy, demonstrated:** *"**three- and four-year-olds across a range of cultures** show a spontaneous ability to **question rules given to them by figures in authority**, and will **resist following a rule given by a figure in authority if they see this rule as unduly harmful or unfair**. Moreover, **they will cite these ethically relevant features to explain their resistance**."* → cross-ref. **§1.8.3**, where this becomes the argument that *machine* autonomy is a safety requirement.

**A second, parallel demonstration — redressing unfair distributions.** At the same age, children *"will spontaneously **share their gains from a joint activity with a co-participant to redress an unfair distribution or unwarranted punishment by a figure in authority**,"*

---

### 2.5.6 Infants as autonomous, experience-based ethical learners — and the dark side

**The conclusion of the developmental argument.**

- **Spontaneous third-party enforcement:** children will spontaneously **attempt to stop third-party ethical transgressions**.
- **Conclusion (Railton):** infants appear to a considerable extent to be **autonomous, experience-based ethical learners**, capable of forming **without explicit instruction** the kinds of non-egocentric representations and evaluations of situations, agents, actions, and outcomes upon which responsiveness to ethically relevant features is based.
- **The dark side:** as infants gain in sophistication about social relations, they become **more oriented toward what is familiar or, somewhat later, toward people they perceive as members of their own group**. However, "own group" preference **does not appear to be a "wired-in" response** and **does not prevent infants or adults from being capable of an extraordinary degree of spontaneous cooperation and collaboration with unrelated individuals**, especially in comparison with our nearest animal relatives. **Social learning in settings involving shared activities and goals can help counteract implicit bias.**

### 2.5.7 The neuroscience of ethical judgment

- **The old (innatist) view:** partly under the influence of innatist notions of a "**moral module**," it was thought there might be **some region or regions of the brain specialised for ethical judgment**.
- **The alternative (developmental/learning-based) prediction:** the neural substrate of ethical judgment would involve **regions or networks subserving general-purpose learning and judgment** concerning a range of **causal and theory-of-mind-related questions** about situations, actions, outcomes, and agents.
- **What metastudies actually found:** ethical judgment **relies heavily upon just such a neural network of regions, the default network.**
  - The **"default mode"** of brain functioning is **one of two primary modes** of brain activity, alternating with the more focused "attentional mode." Each mode corresponds to higher levels of coordinated activation in a relatively stable, interconnected set of brain regions.
  - **Functions of default network processing:** episodic and semantic memory; **scene construction and the imaginative simulation of possible futures**; **counterfactual reasoning**; **inferring the mental states of others**; **self-referential processing**; and **ethical judgment**.
  - *"In other words, the primary network subserving ethical judgment has the features that would be predicted by a model of ethical development as **continuous with these other forms of cognition and evaluation**."*

**Caveats the authors insist on:**
- There are many complexities and pitfalls in any appeal to neuroimaging evidence.
- We must distinguish multiple kinds of ethical judgment: **active vs. passive; self-referring vs. other-referring; intuitive vs. deliberative.**
- It is **still much too early** to have any definitive picture of the neural basis of ethical thought and feeling — but neuroimaging so far has been **largely consistent with the idea that ethical cognition is supported by domain-general processing and essentially continuous with other ways in which we size up situations and actions and make evaluations and choices.**

**In question the "affective vs. cognitive" division:**
- Neuroimaging and connectivity research have **increasingly put in question the kind of "affective versus cognitive" division** found in many **"dual-process" models** of ethical cognition.
- There **are** forms of processing located in regions associated with affect that interact **early and quickly** with sensory input, before higher-order declarative reasoning has begun to operate — **but these are also systems that subserve probabilistic learning, spatial mapping, evaluative comparison, and other core elements of "cognition."**
- Increasingly, a picture is emerging of **cognition as widely distributed in the brain**, and **the age-old idea of the mind as pitting "reason" against "emotion" may be an artifact of our limited insight** into how our minds actually operate.
- **Working definition of "affect"** (as psychologists understand it): *"not simply a matter of aroused emotion but **a capacity of the brain to synthesize multiple streams of information and evaluation in a manner that can orient or reorient a suite of mental processes - attention, perception, memory, inference, motivation, action-readiness - in a coordinated way to address actual or anticipated challenges**."* This design is **inherited from our animal ancestors and highly conserved evolutionarily.**
- **Design implication for AI:** *"If we are asking how an artificial system might make intelligent decisions responsive to ethically relevant features, we may wish to **emulate the functional characteristics of this design**."*

### 2.5.8 What "ethical intuition" is (and is not)

- *"Intuition" does not designate a specific kind of mental process as such, but rather **an assessment - whether of a particular scenario, a type of action, or a general principle - that is often relatively fast and effortless yet that typically feels compelling even though we have little insight into the process by which we arrived at it and may be unable to articulate a satisfactory rationale for it**.*
- A principal focus of discussions of ethical intuition in recent decades, and of discussions of ethics and AI: **the Trolley Problem** (see §2.2.6).
- **The irony:** trolley problems, long castigated by critics as hopelessly artificial, turn out to have **direct analogues in one of the most important actual applications of AI to life-affecting decision-making to date: self-driving vehicles.**

---

### 2.5.9 The empirical trolley data — and what defeats which explanation

Railton collected anonymous in-class responses (wireless keypads) in large ethics lectures at the University of Michigan over several years. *These are hardly controlled experiments, and so they must be considered suggestive only. But their informality also has advantages, in that it enables me to push a bit beyond the usual tightly constrained diet of standard examples.*

**The two baseline results.**

| Case | Description | Result |
|---|---|---|
| **Switch** | Push a lever to divert the runaway trolley to a sidetrack, saving five workers, killing one worker on the sidetrack | **~80%** say one **should** push the lever |
| **Footbridge** | Push a large man off a footbridge to stop the trolley, saving five workers | **~75%** say one **should not** |

*The asymmetry in intuitive judgment has proven **remarkably robust**.* Even moral philosophers who have considered the problem for years and who themselves judge that one should push the man off the footbridge **tend to admit that this scenario does not cease to trouble them**.

**Historical robustness.** *Since the trolley problems first emerged in the 1970s, dramatic changes have occurred in people's views about **interracial marriage, women's roles, gay marriage, premarital sex, smoking marijuana**, and more. **Yet the trolley problem asymmetry remains pretty much undiminished.*** The asymmetry has been found **cross-culturally**, shows **no gender differences**, and appears both in **vivid virtual-reality simulations** and in **simple, undramatic, verbal posing** of the dilemmas.

**Case 1 — Loop defeats the "mere means" explanation.**
One promising early explanation held roughly that in Footbridge one is **deliberately using the worker killed as a "mere means,"** whereas the worker in Switch dies as an **unintended side effect.** *This has lost adherents owing to a case called "Loop":*

> **Loop.** Suppose the switch could send the trolley down a sidetrack that **loops back to the main track**; however, this will stop the trolley from hitting the five workers because a **single, large worker is currently on the sidetrack**, and the trolley, hitting him, will stop before rejoining the main track. **Should you switch the trolley, killing one in order to save five?**

*According to the standard interpretation, the single worker on the sidetrack **is being used as a "means" in essentially the same way as "Footbridge,"** since his being struck by the trolley is **not an unintended side effect but essential to saving the five.** Despite this, **a strong majority of my students (typically about 80%), and of most populations sampled, say one should push the lever to send the trolley onto the looping sidetrack.**

**Case 2 — dual-process psychology explains the asymmetry but does not justify it.**
*At this point "dual-process" psychologists entered the fray, arguing that the difference between Switch and Loop, on the one hand, and Footbridge, on the other, is **attributable not to a matter of ethical principle but to a rapid, strong, automatic, affectively charged, negative System 1** (or, more recently, **"model-free"**) reaction to the thought of **using direct muscular force to kill the man in Footbridge.** This rapid "push button" response does not occur in cases like Switch and Loop, where **the victim is less proximate and one's effect upon the victim less direct, so that the System 1 response is relatively weak, and a slower and more deliberative System 2** (or **"model-based"**) **response can come into play, favoring a calculation of minimizing harm.**
*This dual-process account affords an explanation of the asymmetry, **but not one that provides much by way of ethical justification.** Hence, some have argued on this basis that we should **discount the normative significance of the Footbridge verdicts.**

**Case 3 — Beckon and Wave defeat the direct-force explanation.**
This is Railton's own methodological contribution, and it is the strongest empirical reason to think the trolley literature is more complex than the standard four cases suggest.

> **Beckon.** As before, the runaway trolley will strike and kill five workers if not stopped. **You are at some distance from the track, with no access to a switch**, but you see a large man standing on the other side of the track, **facing in your direction but unable to see the trolley approaching.** If you **conspicuously beckon to the man**, encouraging him vigorously to come in your direction, he will step onto the track and immediately be struck and killed by the trolley, stopping it before it hits the five workers.

*In classroom sampling, I have regularly found that **60% to 70% of students say that one should not beckon** to the man. **This despite the fact that the death he suffers happens at a distance and involves no direct exertion of my own muscular force upon him.**

> **Wave.** You are standing down the track from the five workers, who are looking in your direction and **do not see the trolley approaching them from behind.** If you **wave vigorously to the side**, encouraging them to step in that direction, the five workers will step off the track and be saved. **However, another worker who is looking your way and who is initially standing alongside the track will also see your waving gesture and step in the same direction.** This will place him on the track, where he will be struck from behind and killed.

*Here some **70% to 90% of my students will say that one should wave to the five workers**, saving them but killing the one man lured thereby onto the track. **What, then, could explain this asymmetry, which is as pronounced as the original Switch versus Footbridge asymmetry?**

**Why Cases 2 and 3 together are decisive.** The **mere-means** explanation is defeated by **Loop** (the means relation is preserved but the permission flips). The **direct-force / affect** explanation is defeated by **Beckon** (no force is exerted, the distance is even greater than in Switch, yet the prohibition largely holds) and **Wave** (no killing action of any kind occurs — only a gesture — yet the prohibition largely collapses). So **neither the "mere means" account nor the dual-process account captures the full pattern.**

**Methodological payoff.** Carefully varied cases **discriminate between candidate explanations in ways that the standard cases cannot.** This is a direct argument for Kamm's claim (below) that AI ethics needs *more* careful case analysis, not less — and it is also a live warning for self-driving car design, where the real cases will look like **Wave** and **Beckon** far more often than like **Footbridge**.

### 2.5.10 Communication, shared language and the default-cooperative substrate

*(This subsection consolidates the interaction material that the syllabus names in Unit 1 and that the moral-learning argument depends on.)*

**Language as the exemplary cooperative technology.** *Language is fundamental to general intelligence and problem-solving capacities typical of humans, which are able to draw upon **social knowledge built up over generations of experience.** And language is an outstanding example of **what default cooperative dispositions among nonkin can accomplish** for any species that can achieve them.*

**The reciprocity condition.** *A shared language can be sustained **only because enough speakers regularly use the language with sincere and helpful communicative intent to make it worthwhile for us to speak with each other and rely upon what each other says** — to make **openness to conversational exchange, overall, a positive-sum activity**. Open conversational exchange among strangers is **a form of mutual constraint and contribution for mutual benefit**, and it plays an essential role in **knitting together and facilitating the large-scale forms of cooperation and accommodation upon which human culture depends.**

**Communicative ethics.** *It is no accident that the **norms of conversation** — of mutual recognition, of according others some authority to contribute, of seeking to determine the communicative intent of others and signalling this to them, of seeking to reply in ways that could be comprehensible, relevant and responsive to others' concerns — **are so close to norms for productive epistemic exchange.** Now we will add: it is no accident that they are **also so close to norms for ethical interaction.** Indeed **a large and influential tradition in ethics, communicative ethics, is built around this fact.**

This is the theoretical warrant for treating ethics as a **general-purpose learning capacity** rather than a special module: the norms governing good conversation, good inquiry and good moral interaction are *the same norms*.

**The Machiavellian contrast.** *Individuals scoring high in **Machiavellian** psychological profiles are more likely to adopt an **"economically rational" strategy in trust games**, whereas **no known human community has this as the predominant disposition.** For example, individuals scoring high in Machiavellian profiles are more likely to adopt an "economically rational" strategy in trust games, whereas no known human community has this as the predominant disposition, **and the communities, small and large, that most effectively work together to enlarge their capacities depart the most from this strategy.** Imagine the difference in learning to drive safely in an open-ended array of situations if (a) a community of self-driving cars shares individual driving data rather than (b) each using the data it acquires to gain whatever strategic advantages it can over the others. **The latter is closer to the ultimate goal of artificial intelligence research.**

---

## 2.6 Accountability and Responsibility: Who's Responsible for an AI's Action?

### 2.6.1 Responsibility cannot be laundered through programming (Kamm)

- **The Ambulance Case point again:** the fact that **only a program, not a person**, would disable the stopping mechanism at the time of impact **does not remove responsibility** from the people who programmed the ambulance.
- **Implication for autonomous systems generally:** autonomous systems will exercise life-affecting functions or make life-affecting decisions. **Responsibility does not evaporate because a program is the proximate cause.**

### 2.6.2 Autonomous weapons: responsibility, accountability and "meaningful human control" (Ch. 7, Asaro)

**Definition of autonomous weapons (working definition offered by the ICRC):**
> *An autonomous weapon system is any system that **automates the critical functions of targeting and engaging a weapon**.*

- This means **the targeting and use of force must be automated** for the system to be considered an autonomous weapon.
- **Equivalently:** autonomous weapon systems **lack meaningful human control over the critical functions of targeting and use of force.**
- Whether such systems already exist depends on **how one interprets meaningful human control.**

**What is NOT an autonomous weapon:**
- **Guided missiles** - contain feedback regulators over direction of thrust, guided toward a target using a sensor or GPS; the goal is assigned by a human operator who locks it on target or provides GPS coordinates. Automation follows control parameters, adjusting to keep the missile on course until it strikes.
- **Remotely operated drones** - contain a great deal of automation (sophisticated autopilots; preset flight paths or GPS waypoints; automated flight-surface and throttle-control adjustments to compensate for wind, thermals, aberrant sensor data; advanced drones capable of automated takeoff and landing and aerial refuelling). But in a drone, **a human (albeit from very far away) interprets the imagery data, identifies potential targets, verifies and selects a target, and then aims and engages a weapon.** So they use automation but are **not** autonomous weapons.

**What IS (or might be) an autonomous weapon:**
- **Victim-activated devices:** mines and booby-traps activated by pressure, proximity, or acoustic sensors; sentry guns activated by motion sensors.
- **Loitering munitions** that search out specific radar signals over large areas.
- **Projectile-intercept systems** that automatically track and target incoming missiles and mortars and shoot them down. **Most missile defence systems are autonomous for only a few seconds at a time** and remain under the direct control of humans who can observe, scrutinise targets, and deactivate them at any moment - so they could be argued to be under meaningful human control (or not, if one further requires **strict individual target authorization**). **Wide-ranging loitering munitions, mines, and sentry guns systems are more problematic.**
- **The clear case:** if a drone **utilised automated software to scan through its video feeds and sensor data, automatically identify targets, and then select and fire on those targets, all without human intervention, supervision, or control**, then that would clearly be an autonomous weapon. *"From a causal or functional perspective, this may not seem like a large or significant difference - just a bit more automation, or automation in a different stage of the operation of the system. But, of course, **the difference is one with ethical, as well as legal and political significance**."*

**Asaro's normative stance:**
- **Where there is broad agreement that moral rights and duties exist and are clear, they provide reasons that are MORE COMPELLING than utilitarian reasons**, while **utilitarian reasons are useful in the absence of clear moral duties and rights**.
- **Moral virtues and sentiments reflect psychological and cultural norms and preferences and often function as heuristics in moral reasoning**, especially when choosing between competing duties and values and when reflecting on implications for one's own moral character.
- **No single moral theory alone can fully explain our views of autonomous weapons**, but **each of the leading Western moral theories - deontological and consequentialist - points to the immorality of autonomous weapons in its own way**, and taken together they **present a clear case that building and using autonomous weapons, and permitting or authorizing autonomous violence, is morally wrong.**
- As development has become technically feasible, we should **recognise existing moral and legal principles and establish new norms that clearly prohibit delegating the authority to kill to machines.**
- **Equivalently:** a **positive obligation to ensure meaningful human control over the use of weapons** - morally and legally responsible human agents **must retain control over the functions of any system that directs and releases violent force.**

**Meaningful human control has applications beyond weapons:**
- The relationship between self-driving cars and their occupants/operators.
- The application of algorithms to decisions with the potential to **deny or deprive humans of their fundamental rights** - from access to **medical care, credit, educational and employment opportunities**, to exercising their **economic, cultural, and political rights**.
- In all these cases there is a potential to **delegate an authority to a machine that might directly impact the moral and legal rights of a human person.**

**The seven categories of moral problems raised by autonomous weapons:**
1. **Harms to civilians**
2. **Arms races and international instability**
3. **Intrinsic unpredictability**
4. **Hacking and cybersecurity threats**
5. **A new type of weapon of mass destruction**
6. **Threats to responsibility and accountability**
7. **Threats to human rights and dignity**

**(1) Harms to civilians** - four distinct characterisations:
- **Indiscriminate** in targeting, failing to distinguish civilians from combatants (violating the IHL requirements that attacks be **discriminate and proportionate**).
- **Disproportionate** attacks, killing many civilians for a relatively low-value military objective.
- **Lack the aspects of human psychology that might make them more humane in warfare** - they might be far more aggressive or fail to show any compassion in situations where a human might be merciful.
- **Could easily be designed, altered or manipulated to purposely harm civilians.** Despots and tyrants might turn such weapons against their own people or apply them to genocidal ends, or terrorists might use them to attack civilians.

**The deontological turn:**
- Negative impacts on civilians are not merely bad consequences; they are **the deprivation of fundamental human rights - the rights to life, bodily integrity, and dignity.** We have a **moral duty to respect the rights of others and to treat them as ends in themselves.** But autonomous weapons could **prevent us from performing our duty to respect others in war.**
- Deontology does not completely prohibit killing in war, but it requires **a valid justification such as self-defence**. International law permits the unintentional killing of civilians in war, provided there was a **lawful (justified) military objective.** **But it is less clear what counts as "intentional" or "unintentional" when it comes to autonomous systems** - operators may have an idea of what an autonomous system will do, **but it may do many things they did not specifically consider and kill people the operators did not intend to kill.** In most circumstances we view such situations as **accidents** and hold people morally responsible **only if they were acting in a reckless or negligent manner.**
- **However, autonomous weapons, particularly those involving advanced AI, can serve to cloud the moral issue**, insofar as the operator might reasonably believe the system is designed to attack only valid military targets and avoid civilians. **If this is a reasonable belief, then we might be inclined to attribute harms to civilians as simple accidents or technical failures, and not the moral responsibility of the operator.** <- *This is the accountability gap.*
- **The deeper deontological point (Sparrow):** if there is a weapon system designed to protect civilians **and that actually works in that way, we may have a moral OBLIGATION to use it.** Asaro does **not** accept the deontological side of this.
  - *"In order to fulfil our duty to respect the human dignity of others, I believe we are **required to recognise them as human and to consider them as such** when making the decision that it is justified to kill them or put them at risk of death. Insofar as this consideration is not actually taken by the operators of the weapon, but they instead rely upon an automated process, then **they are not really fulfilling this duty**. Indeed they do not necessarily even think about the individuals that may be killed, **much less regard them as persons**. And neither does the automated system."*

**(2) Arms races, rapid proliferation and instability:**
- High-tech, prestigious weapons providing tactical/strategic advantage or serving as an effective deterrent create **strong incentives for countries to develop or obtain them** - and the same logic applies to adversaries. This is the logical foundation of a **competitive arms race.**
- Apart from being **expensive use/waste of economic, intellectual and natural resources**, arms races are **tied to political and military instability.** Significant buildups viewed as threatening may prompt **preemption**. Access to new high-tech weapons, **especially untested in real conflicts**, can give leaders a **sense of superior military capabilities**, making them **more inclined to initiate or escalate military actions - whether or not their confidence is warranted.**
- Insofar as weapons **behave or perform in unexpected ways due to AI, they become less predictable as threats by adversaries, leading to greater instability.**
- **Instability itself is undesirable in international relations**, as it is a leading factor in many conflicts including "low-intensity" and proxy conflicts. Instability makes it harder to predict adversaries' actions and determine the severity of threat, **making it more likely that one will take a defensive or proactive stance.**
- **Proliferation to non-state actors:** because autonomous weapons **do not require the industrial and technical sophistication that nuclear weapons do, and simple ones can even be built with off-the-shelf technologies, many states will acquire them rapidly.** We have already seen this with **surveillance drones**, and now increasingly with **armed drones**. Advanced, sophisticated, hardened types that major militaries would develop would also find their way to **non-state actors, terrorists, or even police forces.**
- **Policy implication:** a **strong stigmatizing norm against autonomous weapons could prevent such systems from being developed or produced in significant numbers.**

### 2.6.3 Developers and deployers bear a particular kind of responsibility (Ch. 8, O'Neil & Gunn)

**Setting the scene - near-term vs. futurist AI:**
- When we hear "artificial intelligence" we typically think of **robots and machines capable of thinking and acting like humans**, or **far more intelligent than humans**, and the thought often continues along **dystopian lines.** O'Neil & Gunn call these **"futurist" AI systems** with corresponding "futurist" concerns.
- **"At the present moment, though, we do not have superintelligent robots plotting against us. This doesn't mean, however, that there is no artificial intelligence around - the problem is that we're not good at recognizing it."**
- **"Near-term AI"** = AI algorithms **already in place** in a variety of public and private sectors, **guiding decisions that pertain to advertising, credit ratings, and sentencing in the justice system.**
- General blindness to presently existing AI has consequences: *"if we're not paying close attention to the artificial intelligence around us, we're hardly likely to be making sure that it is designed and implemented in ways that - at minimum - meet widely recognised moral standards and avoid inflicting great harms."*

**A terminological point that matters ethically:**
- Whether or not the examples qualify as AI for an expert machine learner **is irrelevant**; **from the perspective of the targets of these scoring algorithms, they are sophisticated and opaque black box systems that make important decisions about people's lives.**
- *"For instance, if an automated algorithm denies one's family medical coverage without warning (or without a meaningful warning) because one failed to check a box on a digital form, **it makes little difference whether it's ELIZA or Deep Blue behind the scenes**. In both cases, we can ask questions about the decision to design and implement an automated algorithm with the power to remove a family's medical coverage without warning."*

**Who counts as a stakeholder?**
- The authors use **"stakeholder"** to denote **those deeply affected by an algorithm**: producers of the algorithm; deployers; **those scored or otherwise evaluated by the algorithm**; or **companies or communities whose lives or professions will be disrupted** by widespread adoption.
- **The problem:** of all stakeholders, **only two groups are typically taken into consideration in the design of an algorithm - the developers and the deployers.** This is a **primary cause of why the interests of wider stakeholders do not make it into the development of the algorithm.**

**Case study - Indiana FSSA (Family and Social Services Administration), 2006:**
- An algorithm was designed and implemented to **modernise the provision of welfare benefits, food stamps, and public health insurance (Medicaid).**
- **The stated goals were to reduce fraud, reduce public spending, and reduce the welfare rolls.**
- The new system **replaced individual caseworkers with an automated eligibility-determining process**, using a website for applications and a **privately run centralised call centre** to replace one-on-one meetings with caseworkers.
- **The critical design choice:** an important factor is whether to err on the side of minimising **false positives** (people receiving benefits they do not need) or **false negatives** (taking benefits from people who **do** need them).
  - **Before modernisation**, Indiana's false positive and false negative rates were **consistent with US national averages: 4.4% and 1.5% respectively** - a trend of **erring on the side of giving benefits to those who don't need them.**
  - **The new system's goals erred on the side of producing more false negatives - denying benefits to people who are in need.**
  - **Result: combined error rates rose between 2006 and 2008 to 19.4%**, with the greatest rise in benefits denied to people who needed them - a **false negative rate of 12.2%.**
- **One striking feature:** a **"one-size-fits-all" denial notice: "Failure to cooperate in establishing eligibility."** The language is **strikingly confrontational and accusatory**, in effect telling applicants they have been denied benefits because they are **being uncooperative by shirking the rules and regulations of the state.** Whether the fault in fact lay with the applicant **was not a condition for receiving this notice**, and it was **not accompanied with any further explanation.**
- **Further failures:** the new system **did not make use of existing personal records** from the previous system, instead **requiring all users to resubmit all of their paperwork.** This led to **very high rates of lost documentation and denial of benefits for allegedly "failing to comply."**
- **Jane Gresham**, a long-term FSSA employee with two decades of casework experience, described the new system as **"de-humanizing"** to both employees and clients, and as **"factory" work**, given the new task-based format, **which undermined workers' abilities to actually oversee a particular client and their needs.**

**The harms:**
1. The system **denies to people who need public assistance the ability to meet their basic human needs** and have access to food, healthcare and money.
2. It provides **little to no person-to-person contact**, requiring applicants to use the online system - **a serious problem for blind or deaf persons** who rely on public assistance.
3. It **failed to provide any meaningful level of transparency** to applicants or caseworkers about how decisions were made.
4. It had **serious problems with its data quality** by failing to use an available database.

**Whose interests were NOT taken into account?** Most significantly, **the interests of applicants or caseworkers.** The benefits accrued to **the state (which may save money), the companies that produced the algorithm (IBM and ACS), and perhaps the politicians who fulfil campaign pledges.**
- *"Had the developers and deployers been required to consider the interests and needs of caseworkers and those actually dependent on the system **as well as** those of the state, it is hard to see how this modernised replacement would have been the result."*

**The moral obligation (the chapter's core claim):**
> Developers and deployers of near-term AI have a **moral obligation to engage in ethical deliberation** about the consequences of the algorithms they design and deploy. In particular, they have an obligation to **engage in a process of determining the predictable consequences of their design choices from the perspectives of those who will predictably be deeply affected by those choices**, and then **make an informed decision about how to balance competing interests and values against one another.**

These include choices about **what the purpose or goal of the algorithm is to be** (e.g. minimising welfare rolls) and **how the algorithm will meet those goals** (e.g. by optimising to false positive rates).
- **Developers** (those who actually write the algorithms) are **in a unique position of responsibility** over the design, as they are typically the only ones able to understand how the algorithm functions and are responsible for rendering the design goals into the algorithm.
- **Minimal standard proposed:** actually engage in a **structured reflection on the predictable consequences of the algorithm by using an ethical matrix.** This framework **does not require specialist training**; it asks individuals to apply their **commonsense intuitions** (e.g. about what is fair) in combination with **empirical data** about the predictable consequences of the algorithm's design.

**Discrimination risks (structural):**
- Because developers are concerned primarily (or exclusively) with **their own interests (as a company) or those who will deploy the algorithm (e.g. the state)**, near-term AI is **at great risk of exacerbating harms to already marginalised groups** because the interests of those groups are **not part of the conversation around design.**
- The FSSA system's lack of provision for disabled persons is **plausibly an oversight that we think could constitute ableist structural discrimination.**
- The **presumption that errors in an application indicate that an individual is attempting to engage in fraud or is free-riding** can plausibly be interpreted as part of a pattern of **classist discrimination** - negatively stereotyping those who are dependent on welfare.
- This indicates a **general lack of attention to the broader social context** in which many near-term AIs come into existence, and to the ways certain groups consistently fail to have their needs recognised and taken seriously.

**Near-term failures also increase long-term risk:**
- **They make existential risks more likely** - a continued failure to address the harmful consequences of design choices increases the chance that a **pernicious algorithm is implemented somewhere.**
- **They make them worse** - present structural prejudices could lead to, e.g., **a racially discriminatory extermination scenario** if we face artificial superintelligences beyond human control.
- **A distinct harm arising in non-singularity cases:** the failure to address the ways algorithms **further materially undermine the poor** and may lead to a future of **even starker material inequality and a lack of due process for those groups.**
- **The dystopian scenario:** *"widely adopted automated algorithms in our society that make poor people poorer, fail to help the sick, homeless, or otherwise needy... where goods are distributed **only on the basis of lists** designed to meet economic or political goals, with **no consideration for the nuance of individual needs**... where one's very ability to access healthcare, shelter and food might be due to **an inscrutable score provided by the black box of a near-term AI**."*
- *"Such a scenario is **easily preventable** if we adopt a norm (or better yet, a policy) of demanding ethical reflection on the ways that different interest groups or stakeholders will be affected."*
- **Honest admission:** *"We make no claim that engaging in ethical reflection on these systems is easy. **Someone will have to draw a line somewhere that will leave some people in need of food stamps and medical insurance without the ability to fulfil these needs** (keeping the present systems fixed without radical changes to public institutions)."*

---

### 2.6.4 Kamm: the trolley cases, correctly separated — and the "innocent threat" category AI ethics imports wrongly

This is Chapter 2's technical contribution and it is directly relevant to self-driving car ethics. **Two kinds of self-driving car:**
- **Complete Case** — no person driving; operates completely on the program designed for it.
- **Partial Case** — a person driving, but the program can override or supplement the driver's control at crucial points (e.g. the car will stop despite the driver trying to continue).

**The standard cases and their standard verdicts.**

| Case | Description | Standard verdict |
|---|---|---|
| **Trolley (Driver Case)** | Philippa Foot's original: a driver is on his out-of-control trolley, headed toward killing five innocent people on a track. To save them he can only turn the trolley to a **sidetrack** where, he foresees, the trolley will instead kill one other person standing on that track. | Driver is **morally required** (and a bystander **at least permitted**) to do what minimises deaths |
| **Bystander Case** | Judith Jarvis Thomson's variation: a **bystander**, not the driver, decides whether to turn the trolley (with the same effect), when the driver cannot do so | Same: **permitted** |
| **Topple Case** | **Topple** someone from a bridge in front of the trolley so his body stops it and the trolley kills him | **Impermissible** |
| **Bomb Case** | Use a **small bomb** whose explosion would stop the trolley, though a piece of the bomb would fly off and kill an innocent pedestrian | **Impermissible** |

**Why the verdicts are standard — three structural features of the permissible cases.**
- In **none** of the permissible cases is the person who turns the trolley (or who is on the trolley) **at risk of dying.**
- In **none** is the person who would be killed by the redirected trolley **the cause of its threatening the five**, or **obligated to either give his life or assume a position in which he will be killed as a side effect in order to save the five other people.**
- In **none** would the person killed **lose his life by someone else imposing the loss on him, rather than by his imposing it on himself.**

**The generalisation that must be tested.** *If an argument could justify killing one to save five, it would arguably also justify **redirecting toward one person to save even two other people**, and redirecting toward any smaller number of people to save a larger number of other people. Indeed, **if an argument could not justify killing one to save two from the trolley, it could not justify killing one to save five from it.***

**The deep structure.** *We could think of the Trolley Problem as explaining **why killing is permissible in the Trolley and Bystander Cases but not in the Topple and Bomb Cases. This problem is part of the more general debate between act consequentialists**, who think it always permissible to bring about the best consequences, **and nonconsequentialists**, who deny this.*

**The popular misapplication.** Popular internet contributors (Kamm names **Chris Rampolla**) describe driving dilemmas as "Trolley Problems." His example:

> *Suppose you're driving your car in the right hand lane of a one-way street on a winter evening. As you approach a red light at an intersection, you tap the brakes and begin to skid. Ahead of you the left lane is closed and is blocked by a concrete barrier in front of a crosswalk. **There are no obstructions in the right lane.** A pedestrian has legally entered the crosswalk on the right side of the street and is attempting to cross over to the other side. **You have just enough time and just enough control of the car to make a decision about which lane to enter but you cannot stop your car.** Should you choose to continue on in the right lane, **the pedestrian will be struck by the car and will likely die.** Should you choose to direct your car into the left lane, the collision of your car with the barrier **will save the life of the pedestrian but will very likely kill you, the driver.**
>
> *What do you choose to do? Now ask yourself that same question, except this time consider that **your child is in the car** and would likely die from an impact with the barrier. Next consider that **the pedestrian in the road is also accompanied by a child.** Still further, consider that this time **your spouse and child are in your car** with you and there are **three elderly people in the crosswalk. Has your choice changed?** More generally, **what is the moral thing to do in each of these situations and is there any commonality between them?***

**Why this is not a Trolley Problem — four disanalogies.**

**(1) Threats and non-threats.** Rampolla's case involves **a threatener deciding whether to kill innocent, non-threatening people rather than kill himself.** Standard trolley cases are about **whether one may kill some innocent, non-threatening person so as to either not kill or save other innocent, non-threatening people from a threat already facing them.** Rampolla's case does not involve someone who is presenting a threat of death to others deciding whether to harm the innocent rather than himself.

*Kamm's term for Rampolla's sort of case: an* **"innocent threat case."** *Innocent Threat Cases are distinguished by the **threatener himself, a bystander, or a potential victim having to decide whether to harm the threatener, who became such despite being innocent of any moral wrongdoing**, or allow him to proceed to harm some non-threatening people.*

*Types of Innocent Threat Case, which make clearer **why the threatener is considered morally innocent:*
- **Nozick's cannon case.** A man is **unwillingly shot out of a cannon**, headed toward landing safely on someone who would be killed by the impact. **May the potential victim or a bystander kill the innocent threat to prevent his fall from killing the victim?**
- **Cases of minimal responsibility for harm.** The threatener is **not totally inactive in causing the threat but is not at fault** in his actions — *e.g. a psychotic killer, a nonnegligent driver whose brakes fail in a well-maintained car.*
- **A justified-but-unintended threat (the just-war variant).** A **pilot fighting on the just side in a war** unintentionally bombs a military facility that **it would have been permissible to bomb intentionally**, given that there is only permissible collateral harm to civilians. *In standard just war theory anyone who presents a threat is considered a "noninnocent" threatener, but morally speaking one might consider him innocent.* May these threatened civilians nevertheless **shoot him down to protect themselves** — *especially if this will not affect the good military effect of his bombing?* In this case **the pilot is the threat**, for if we could eliminate him (and thus his control of the bombs) the threat to civilians would stop.
  - **The instructive contrast:** *in cases involving an already out-of-control car it is strictly the **vehicle** that is the threat; getting rid of the driver may not stop the threat, though doing something to the vehicle that as a side effect will kill the driver will stop the threat.* **Nevertheless, Kamm thinks that in an extended sense the driver in such cases is an innocent threat if he was driving the vehicle before he lost control of it.**

**(2) Imposing harm versus having it imposed.**
> *In the standard Trolley Cases, unlike the case I cite from Rampolla, **the person who decides what to do with the trolley — either the driver or a bystander — is not one of those who might be harmed.** Hence those who stand to be harmed **have harm imposed on them by others rather than imposing it on themselves.** By contrast, in Rampolla's case **the driver faces the option of harming himself.** One should not assume without argument that **what may be imposed on one is the same as what one has a duty to impose on oneself.**

*The two-sided effect:* *The first factor [the possibility of harm to the threatening driver] **may make it easier to justify harm to one person**; the second factor [the driver having to decide whether to **impose** the harm on himself] **may make it harder to demand it.** Suppose one could show that the driver was permitted to treat himself like any nonthreatening possible victim. The fact that **no such victim would have to redirect the threat away from others to himself** would imply that the driver (who is actually the threat) **would not have to redirect in a way that kills himself.**

**(3) Passengers and varied characteristics.**
- *Cases with **passengers** are unlike the standard Trolley Cases in which there is no one on the trolley who can be harmed, and it is also a complication of the standard Innocent Threat Case.* *If there are passengers in a threatening vehicle, **it would be another mistake to assume without argument that they are to be treated as morally equivalent to pedestrians** who would be hit by the threat and that **their lives should be weighed in the same way as pedestrians.***
- *Rampolla's cases also assign **different qualities** to the different people who might be harmed (some old, some young, some strangers, some one's spouse or child).* By contrast, **the standard Trolley and Innocent Threat Cases abstract from such distinctions** in order to determine (1) whether in the Trolley Cases differences in **how we come to kill people** (by redirection, by toppling) make a moral difference, and (2) whether in the Innocent Threat Cases **the difference between being a threat (albeit morally innocent) rather than a pedestrian makes one more liable to be harmed.**

*Kamm's methodological defence of varying the extra characteristics:* *As in science, it has been thought in philosophy that to test for the moral significance of a factor, **we should insofar as possible hold other variables constant. Nevertheless, varying additional characteristics to see how they affect one's decisions about sparer cases need not be a methodological mistake since otherwise crucial factors can be overridden or have their effect altered in changing contexts.**

**(4) Possible principles — and a correction to Philippa Foot.** Rampolla describes Foot as supporting a **revised version of the Doctrine of Double Effect (DDE)** to justify the driver turning the trolley, quoting Foot's 1967 article *"The Problem of Abortion and the Doctrine of Double Effect"* (*Oxford Review* 5).

*Kamm's correction:* *it is **not true** that the distinction Foot draws is a modern interpretation of the DDE.*
- The **DDE** distinguishes morally between **harm that happens as a side effect** and **harm that is intended**. It claims the latter is **impermissible even as a means to a greater good**, while the former **at least does not rule out pursuing a greater good.**
- **Foot proposes an alternative to the DDE** that has **nothing to do with whether one intends harm** (or harm is a means). It focuses on a moral distinction between **harming and not aiding even when harm is merely foreseen as a side effect and neither intended nor causally a means.**
  - **The Gas Case.** Foot thought that **using a gas in surgery to save five people from their illness is ruled out if this gas will also cause someone else's death as a mere foreseen side effect.**
  - **The consequence for the trolley cases:** *Foot's additional claim that **the duty not to harm is stronger than the duty to aid** might also **rule out turning the trolley in the Bystander Case, since the bystander would harm one person to aid five.***

### 2.6.5 Medical cases: the Mammography Case, and why "trolley-like" mislabels recur in bioethics

Kamm shows the same conceptual confusion appearing in medical ethics, via **Dr. Marya Zilberberg**.

**The case.** Mammography is said to **save eight women** who would otherwise have died from cancer **for every thousand mammogrammed**, but leads to the death of **at least one woman who would not otherwise have died (due to false positives)**.

Zilberberg: *"Well, then we have the trolley problem, don't we? **We are potentially sacrificing 1 individual to save 8. And who does the sacrificing is where the variations of the trolley problem come in.**... The **payer** certainly sees this issue as the original formulation of the problem: **Why not throw this financial switch to achieve net life savings?** But for a **clinician** who deals with the individual patient this may be akin to **pushing her over the bridge** toward a potentially fatal event."*

**Kamm's four disanalogies.**

**(1) The payer neither caused the threat nor diverted it.** *Unlike the driver in the "original formulation of the problem," **the payer did not have a role in causing the threat that must be dealt with (in this case, cancer). Nor is he diverting the cancer** that threatens the life of some women toward fewer women. **The payer is helping to pay for a new means to help some women (the mammogram) which presents a bad side effect threat to a smaller number of other women.** This is analogous to **using the small bomb to stop the trolley when the bomb would kill another person.**

**(2) The clinician is not using the harmed woman as a means.** *This also implies that **the doctor who orders mammograms that as a side effect harm a woman is not harming a woman as a means to help save eight others, which would be akin to toppling someone in front of the trolley as a means of stopping it.** This is shown by the fact that **if mammograms the doctor orders did not cause the harm to one woman as a side effect, this would not reduce mammograms' effectiveness in saving eight out of a thousand women; the threat and harm to the one is not needed to save the eight.**

**(3) Ex ante symmetric risk-taking is different from imposed certain death.** *An additional aspect of the Mammography Case to which Dr. Zilberberg points is that **ex ante each person could be either one of the eight who will be benefited or the one who will be harmed.** Hence she thinks it is important to understand **the patient's attitude to risk.** And indeed **introducing a means that will unavoidably risk harm as a side effect to each of those who, as far as we know ex ante, also get from that means a greater chance to benefit, may be permissible.**

**(4) But imposed certain death is still different.** *However, this does not imply that it is permissible to use means that will help others when it is known that **the means will as a side effect impose certain death on a particular other person**, and **it is still possible to prevent its doing so by not using the means at the time we know it would present the threat (as in the Bomb and Gas Cases).** This is so **even if it is permissible in the Trolley and Bystander Cases to impose certain death on a particular other person when one could avoid it** (independent of any ex ante calculation of risks and benefits).*

**The general rule Kamm extracts.** *It is one aspect of the Trolley Problem to explain these differences in permissibility.* **Not distinguishing between the Trolley Case and cases like Bomb and Gas** is also exemplified by some discussions in medical ethics that try to analogize the use of **electronic cigarettes** to diverting the trolley — *that is, many people will die [from a behaviour change in cigarette use, but]...*

### 2.6.6 Transparent design and the ethical opt-out problem (Ch. 3, Bonnefon, Shariff & Rahwan)

Chapter 3 attacks a practical obstacle sitting between "we have decided the right principle" and "the principle has any effect."

**The trust deficit.** *Most people are happy to use technology driven by artificial intelligence, **as long as they are not fully aware they are doing so.** They enjoy music recommendations, email filters and GPS advice without thinking too much about the machine learning algorithms that power these products.* But as AI-driven technology takes a greater place in their lives, **they express anxiety and mistrust about things labelled AI.** Leaving aside fears of superintelligent robots lording over humanity:
- **Only 8% of people would trust the mortgage advice offered by an AI program** — *a shade lower than the 9% who would trust their horoscope for investment advice.*

**Where AI now makes moral-domain decisions.** *Of course, shopping recommendations and GPS routes arguably do not have a critical impact on people's life outcomes. AI-driven technology, though, is progressively extending into realms in which it will have such an impact, and thus make decisions that fall in the moral domain.*
- **Self-driving cars** will need to make decisions on **how to distribute risk among road users**
- **Organ donation algorithms** prioritize who will get a transplant
- **Algorithms already advise judges** about who should get probation, parole, or a longer jail sentence

*The nature of the problem:* *All these decisions **inescapably incorporate ethical principles and complex moral trade-offs.**
- *Should self-driving cars **always strive to minimize casualties**, even if it means sometimes sacrificing their own passengers for the greater good?*
- *Should **children always have priority for organ transplants**, even when an older patient is a better genetic match for an available organ?*
- *Should **sentencing algorithms always seek to minimize rearrest**, even if this minimization results in an unfair rate of false alarms for black and white defendants?*

**The problem: who should be consulted?** Ethicists or laypersons?
- *Even though **ethicists do not necessarily behave better than laypersons**, and even though **their initial intuitions may not be better than that of laypersons**, **their training allows them to think more deeply about these questions and provide solid justifications for their conclusions.** Laypersons' intuitions, in contrast, are **often untrained and uninformed.***
- **The temptation** to discard laypersons' intuitions and preferences *would be a grave mistake.* **Why? Because if people are not satisfied with the ethical principles that guide moral algorithms, they will simply opt out of using these algorithms, thus nullifying all their expected benefits.**

**The self-driving car illustration of the opt-out risk.** *Imagine that some ethicists would agree that self-driving cars **should always strive to minimize casualties under a veil of ignorance** — that is, that self-driving cars should always take the action that minimizes harm, even if this action is dangerous for their own passengers. This would seemingly guarantee the greatest safety benefits for all road users, measured by the smallest overall number of traffic fatalities. **But it would also mean that self-driving cars might autonomously decide to sacrifice (or at least imperil) their own passengers to save other road users** — and **this possibility is so aversive to consumers that they might opt out of buying self-driving cars, thus forfeiting all their expected safety benefits.**
- *In other words, **even if ethicists were to agree on what they believe to be the best ethical principles to guide a moral algorithm, their work would be made null and void if many laypersons were to strongly disagree with them, to the point of opting out of using the algorithm.**

**The forms the ethical opt-out can take.**
- **Self-driving cars** — by **not buying them**
- **Organ donation** — by either **not registering as donors** or **registering as nondonors**
- **Judicial algorithms** — by **electing state court judges who vow not to use such algorithms** (in the United States), or by **turning to alternative, community-based justice such as sharia councils** (in the United Kingdom)

**The authors' stated agnosticism, reported fairly.** *One may still argue that if ethicists were in fact able to come to a consensus about the normative principles guiding moral AI in a given domain, then laypersons **should be educated rather than listened to** — for example by rational argument or implicit nudging. **As a matter of fact, we are agnostic when it comes to this debate.** What we note is that whichever way is actually taken, **public policy will require understanding what people find acceptable** — whether with the aim of **coming closer to their preferences** or of **persuading them that their preferences should be abandoned.**

**The constructive proposal — the algorithmic social contract.**
> *In sum, **many benefits of AI technology require people to opt into an algorithmic social contract, an agreement between citizens, mediated by machines.** To facilitate such agreement, **we must understand what principles people expect moral AI to follow, lest they opt out from using, enabling, or allowing beneficial AI-driven technology.** And we need this understanding regardless of whether we think people should be educated or accommodated.*

**The phrase to remember: the ethical opt-out.** A moral algorithm that nobody will use is **not a partial success; it is a total failure**, regardless of how good the principle was. And **transparency is useless if the trade-offs are too obscure for the public to understand.**

### 2.6.7 Methodological challenges in moral psychology — stylisation must be calibrated to the domain

**The general difficulty.** *Assessing moral preferences is a complicated matter, one that has drawn in not just the field of moral psychology but also subfields of experimental economics and human behavioral ecology. **Moral preferences are fluid, multifaceted and nuanced. To measure them is to accept that much complexity is lost in the measurement**, and some measurement techniques **inevitably amount to presenting people with highly simplified, stylized problems — problems that sacrifice realism in order to cut at the joints of moral preferences.** Different domains of application **call for different degrees of such simplification**, as we consider using three examples: autonomous vehicles, kidney paired donation and algorithmic sentencing.

**Domain 1 — Autonomous vehicles: stylisation IS justified.**

*The standard defence of the Trolley Problem against the "why can't the car just stop?" critique:* *These are all legitimate questions, but **experimental psychologists (and experimental philosophers, for that matter) simply ask people to accept the premises of the problem in order to discover fundamental principles and processes underlying moral judgment.** As a result, the Trolley Problem **has led to many important insights about human morality, despite (or thanks to) its unrealistic simplicity.**

*The AI version is equally stylised:* an autonomous car barrelling down on five persons, unable to stop; the only way to save them is to swerve into another pedestrian, who would then die. *Is it morally acceptable (or even obligatory) for the car to swerve? This scenario is clearly as unrealistic as the classic trolley scenario. Why is the car driving at unsafe speed in view of a pedestrian crossing? And why are the only options to stay or swerve — surely the sophisticated AI that powers the car should be able to come up with other solutions?*
- *Just like the Trolley Problem and most experimental stimuli in the behavioral sciences, **this autonomous car dilemma is a model, not a reflection of reality. To borrow a turn of phrase, it is meant to be taken seriously without being taken literally: it captures the gist of many genuine ethical trade-offs that go into the algorithms of autonomous cars, and does so in a way that laypersons can understand.***

**The argument that makes this more than a mere defence — trade-offs aggregate at scale.**
- *In the real world, **every complex driving maneuver influences relative probabilities of harm** to passengers, other drivers and pedestrians.*
- *A car that is programmed to favor a certain set of maneuvers may thus have **a higher probability of harming pedestrians and a lower probability of harming passengers**. Though these maneuvers may only **minutely shift the risk profile for any individual, the trade-offs that are being made will become apparent when aggregating statistics over thousands of cars driving millions of miles.** And these statistics **will prompt the same questions as the stylized dilemma does.*
- *For example, imagine that **accidents involving one car have a 1-to-2 ratio of passenger to pedestrian fatalities, while another car exhibits a 1-to-7 ratio. Will society accept this discrepancy? Will consumers flock to the second car? Should regulators intervene?** Note that **we have been there before:** for example, **"killer grilles" (also known as "bull bars") were banned by many regulators because they disproportionately harmed pedestrians and passengers in other vehicles. Regulators identified the ethical trade-off embedded in a physical feature of the car and acted in the interest of all stakeholders. Should they do the same for the ethical trade-offs embedded in self-driving car software?*

**The transparency argument — the real payoff of stylisation.**
> *By capturing ethical trade-offs embedded in software in a form that **all people understand immediately**, the stylized dilemma **empowers them not to leave ethical choices in the hands of engineers, however well-intentioned these engineers are. To dismiss the stylized dilemma as an abstract philosophical exercise is to hide ethical considerations where lay individuals cannot see them. Most would agree that ethical algorithms should be developed transparently — but transparency is useless if the trade-offs are too obscure for the public to understand.** Stylized dilemmas like the Trolley Problem have a **critical role to play to overcome this psychological opacity.**

**Domain 2 — Kidney paired donation: stylisation is UNNECESSARY.**

**The setup.** *Too frequently, candidates for kidney donation have access to a living donor who unfortunately is a **poor match** for them. To optimize the efficiency of kidney allocation, **kidney paired donation (KPD)** consists of entering candidates and donors in a database, which is then fed to an algorithm that seeks **two-way, three-way or complex chains of donations such that as many candidates as possible find a compatible donor.***
- *The algorithm does not only seek to **maximize the number of donations**. It also uses a **scoring rule to determine the priority of each donation** in order to find chains that **maximize the number of high-priority donations.**

**Why no stylisation is needed here.**
- *While the **chain-seeking part of the algorithm might be too complex for laypersons to understand**, the same is not true of **the scoring rules that determine the priority of each donation. Most criteria in these scoring rules can be readily understood, and the trade-offs they imply may be explained almost straightforwardly to citizens, and to potential donors in particular.**
- *While the interpretation of the **zero-antigen mismatch criterion** and the controversies surrounding its use are perhaps best left to specialists, the other criteria are easy enough for laypersons to understand. **Three of the criteria are straightforward (travel distance, recipient's age, recipient's prior donor status).** The **Panel Reactive Antibodies (PRA) score indicates the proportion of the population against which the candidate is immunized**, which accordingly restricts the pool of potential donors for this candidate. **A candidate with a PRA score of 80 is thus unable to receive a kidney from 80% of donors.***

**The real criteria (APKD vs. OPTN, before their 2016 update):**

| Criterion | APKD | OPTN |
|---|---|---|
| Zero-antigen mismatch | 6 | 200 |
| High PRA | PRA > 80%: **10**; PRA > 50%: **6** | PRA > 80%: **125**; PRA > 50%: **0** |
| Travel distance — same region | 0 | 25 |
| Travel distance — same center | 3 | 25 |
| Pediatric recipient | Age < 6: **4**; Age < 18: **2** | Age < 6: **100**; Age < 18: **100** |
| Prior donor | 6 | 150 |

**The questions laypersons can ask directly — no dilemma needed.**
- *Why would a **five-year-old** candidate receive more points than a **six-year-old** candidate, while the **six-year-old candidate does not receive more points than a seven-year-old candidate?***
- *Is it fair that a candidate with a **PRA of 80** gets a massive point gain compared to a candidate with a **PRA of 75**, while a candidate with a **PRA of 98** receives the same number of points as a candidate with a PRA of 80?*
- Why is it that, under the rules established by the Alliance for Paired Kidney Donation, **being in the same center as the donor awards slightly more points than being seventeen years old**, while **being seventeen awards four times as many points as being in the same center** under the rules set by the Organ Procurement and Transplantation Network?

*These are questions that **laypersons can easily understand without the need for researchers to invent stylized dilemmas**.*

**The conclusion.** *The fact that **the scoring rules can largely differ is a telltale sign that we are dealing with fluid, controversial moral trade-offs.** And, again, **the palatability of these trade-offs is likely to influence people's decisions to participate as donors.** Moral psychology can assess the public perception of these trade-offs **through experimentation, without the need for simplifying the problem to the extent it had to simplify autonomous vehicle ethics into trolley problems.**

**Domain 3 — Algorithmic sentencing: the HARDEST case, and the one MOST in need of study.**

**The setup.** *There are other application domains in which the ethical trade-offs are **not only hard to explain but also hard to stylize** — and these domains will likely prove the most difficult to investigate with the methods of moral psychology. This is especially the case with **algorithmic sentencing.***
- *Many US courts now offer judges the option of using an algorithm that provides a risk score for the defendant — for example, **the risk that the defendant will not show up at trial** (which can lead a judge to decide that the defendant should await trial in jail), or **the risk of recidivism or violent crime** (which can lead to a longer jail sentence or a sentence in a higher security prison).*
- *While there are dozens of such algorithms, **some of them created by nonprofit organizations, the best-known exemplars are proprietary algorithms created by for-profit organizations, such as the COMPAS tool created by Northpointe (now Equivant).***

**The opacity obstacle.** *The **opacity of these proprietary algorithms obviously imposes limits on the realism of any experimental vignette**; if we do not even know which parameters the algorithm uses, **we cannot investigate the public perception of the trade-offs between these parameters.***

**The COMPAS controversy, unpacked.** In **May 2016** the investigative news organisation **ProPublica** published *"Machine Bias"* by **Julia Angwin et al.**, arguing that **COMPAS was biased against African American defendants.**
- *The ProPublica analysis used a data set containing the **identity of thousands of defendants, together with their COMPAS score for risk of recidivism and whether they were actually arrested during the two years that followed the COMPAS assessment.***
- **The key result, and the cornerstone of the story:** *COMPAS **errored differently for black and white defendants.** Angwin et al. reported that the **false positive rate** — the rate at which defendants were predicted to recidivize but did not — was **38% for black defendants, compared to 18% for white defendants.** Conversely, the **false negative rate** — the rate at which defendants were predicted not to recidivize but did — was **38% for black defendants, compared to 63% for white defendants.** In other words, **overestimation of risk seemed more likely for black defendants, and underestimation of risk seemed more likely for white defendants.***

**The objection, and why it fails.** *One concern with this result is that **COMPAS does not predict recidivism as a binary variable but delivers instead a risk score from 1 to 10.** In order to compute false negative and false positive rates, it is necessary to **choose an arbitrary cutoff** above which COMPAS is considered to predict recidivism. The results of Angwin et al. are based on **a cutoff of 5**, and some critics argued that this arbitrary choice discredited the main finding of the report.* **However, a reanalysis of the ProPublica data assuages this concern by showing that the main finding of the report holds for any choice of cutoff.**

**The structural moral trade-off — two fairness notions that are mathematically incompatible.**
> *An algorithm whose mistakes are unfair to black defendants clearly raises ethical issues, but **does it reflect an ethical trade-off? In this specific case, the answer appears to be yes, because two conceptions of fairness can apply whose simultaneous satisfaction is mathematically impossible.** In essence:
> - The algorithm can be **equally predictive for both groups** when the probability of recidivism is the same for two individuals who have the same score, regardless of their group.
> - The algorithm can be **equally wrong for both groups** when it yields the same rate of false positives and false negatives for both groups.
> - **However, and this is the critical point, these two properties cannot be simultaneously satisfied if the two groups do not have the same baseline probability of recidivism.**
>
> *As soon as one group has a greater recidivism rate, **one must decide where to put the cursor between equal predictive power and equal mistakes. It is obvious that unequal mistakes are unfair. And yet, if they are equalized, the risk score must be interpreted differently for black and white defendants. A score of 6 could denote a high risk for a white defendant and a low risk for a black defendant — which means that judges using the algorithm would necessarily factor race into their sentences, something that they are currently forbidden to do.**

**The uncomfortable conclusion.**
> *We do not intend to explore the legal ramifications of such a transformation of judicial practices. Rather, our goal in discussing the COMPAS controversy was to show that **some ethical trade-offs will be much harder than others to stylize for laypersons, and thus much harder to study with the standard methods of moral psychology. The problem, though, is that these trade-offs may be the ones most in need of psychological investigation.** We can venture that **the number of persons who heard about the ProPublica story is orders of magnitude larger than the number of persons who know about the trade-off it reflects** — and we can imagine as a result that **many people believe that sentencing algorithms are intrinsically racist.** If we are to gauge the social acceptability of sentencing algorithms, **behavioral scientists will have to uncover an appropriate method to make their ethical trade-offs as understandable as the trolley problems made the ethical trade-offs of AVs understandable to a general audience.**

### 2.6.8 Second-order ethical challenges: two worries about doing this research at all

Liao's authors raise two worries **about their own research programme**, and then partly refute both. Both are important because they model good practice: scrutinising the ethics of the ethics research.

**Worry 1 — Wasteful studies.**
- *Whatever a speaker's specific topic, **they got a question about trolley problems.** That is, not only did one specific method (trolley problems) capture the attention of the media and the public to the point of becoming synonymous with AV ethics, **but it threatened to dominate the conversation on AVs to the detriment of more central questions such as overall safety and environmental efficiency.***
- *The concern: **a wasteful decision would be to commit too many resources to addressing trolley-like dilemmas** (which companies are ill-equipped to deal with anyway, **for the lack of staff trained in ethics**) and not enough resources to **improving safety and avoiding such dilemmas in the first place.**
- *The rebuttal: **the fraction of resources that these companies devote to ethical issues is most likely an infinitesimal portion of the resources that they devote to engineering issues. Being thrifty about any aspect of safety (absolute or relative) would be a suicidal move for an AV company**, which suggests we should not be overly concerned about ethical teams absorbing the resources of engineering teams.*
- For **KPD and sentencing algorithms** the situation is different, because **these algorithms are already in place and already raising ethical questions or concerns.** Devoting more resources there is a good move, *especially in the case of sentencing algorithms — even if it means that some resources might be diverted from the technological refinement of the algorithms.* **Market forces are more than enough to counter any tendency to overspend on ethics and underspend on performance. Furthermore, the risk of ethical opt-out means that money spent on ethics is not wasted since performance without adoption is useless.**
- *For policymakers: they may find themselves **under pressure to act too fast or too strongly in order to assuage the fears of their constituencies**, if these constituencies identify ethics as the sole or most pressing issue regarding the use of AI. **The antidote is to conduct more psychological studies, not fewer** — as long as these studies can appropriately inform policymaking. **The faster we can inform policymakers of what citizens are willing or unwilling to accept, the lower the risk that policymakers will make hasty decisions that hamper the development of AI for no good reason.**
- **The conclusion:** *In sum, **the toothpaste is out of the tube now that the general public is aware of the challenges of machine ethics; there is no going back. Psychological studies of machine ethics will not cause wasteful decisions, but the lack of such studies surely will.***

**Worry 2 — Scary studies.**
- *A related but different concern: **we can adversely affect the public attitude toward AI by the process of measuring it.** Consider again the focus on trolley problems in studies of AV ethics. **Trolley-like situations are very aversive while being (in their literal and simplified form) extremely rare. Drawing attention to these situations may adversely and irrationally affect the subjective perception of the safety of AVs.***
- **The relevant cognitive biases:**
  - **Availability heuristic** — risks are subjectively higher when they come to mind easily.
  - **Affect heuristic** — risks are subjectively higher when they evoke a vivid emotional reaction.
  - **Algorithmic aversion** — people **erroneously avoid algorithms after seeing them err**; they lose confidence in erring algorithms more easily than for erring humans.
- *Because AV trolley situations can be easily imagined (whatever their actual probability of occurrence), and because they plausibly trigger a strong emotional reaction, **the danger is that their likelihood may be overestimated, with downstream consequences on the acceptability of AVs in general.** Worse, this impact may be compounded by algorithmic aversion.*
- *But **this will not be solved by keeping ethical dilemmas out of public sight. In June 2016 the first fatality involving a car in self-driving mode drew more media attention than the approximately fifteen thousand human-driven car accidents that occurred in the United States on that same day.** We can only imagine the coverage of the first fatality that will occur when an AV faces something akin to a trolley dilemma. **Before it comes, the public should have discussed it openly and had a voice in how the AV was programmed to act, rather than been kept in the dark.**
- *Whether people are deterred by AV trolleys is **an empirical question deserving of actual research.***

**The study they ran.**
- **Platform:** Amazon Mechanical Turk. **400 participants recruited from the United States, of which 369 completed the full survey.**
- **Randomisation:** participants were **randomly assigned** to either
  - **(i) the dilemma-first treatment** — first exposed to **three AV trolley dilemmas**, then to four questions about their attitudes toward AVs; or
  - **(ii) the control treatment** — the reverse order, responding first to the four attitude questions, and only then being exposed to the three AV trolley dilemmas.
- **Covariates collected:** **prior exposure** to AV dilemmas (5-point: None / Little / Moderate / A lot / A great deal), **driving habits** (usually driver / usually passenger), **demographics** (gender, age, income, political orientation), and **love of technology** (7-item scale).

**The four attitude questions (all 7-point scales):**
1. *How **excited** are you about a future in which autonomous (self-driving) cars are an everyday part of our lives?* (1 = Not at all → 7 = Very much)
2. *How **afraid** are you about a future in which autonomous (self-driving) cars are an everyday part of our lives?* (reverse-coded so that higher scores reflect **more comfort** with AVs)
3. *Should they become commercially available by the time you are next purchasing a new car, **how likely would you be to choose an autonomous vehicle?*** (1 = Not at all likely: I would rather buy a car without self-driving capabilities → 7 = Extremely likely: I would definitely choose to buy a self-driving car)
4. *Compared to current human-driven cars, **how safe do you expect self-driving cars to be?*** (1 = Much less safe → 7 = Much more safe)

**The results** (restricted to the **264 participants who had never heard of the AV ethical dilemmas before taking the survey**; *the results are even stronger when the analysis is conducted on the full sample*):

| Measure | Dilemmas first (N=132) | Control (N=132) | t | p | Bayes factor |
|---|---|---|---|---|---|
| Excited about AVs | 3.4–4.2 | 3.9–4.5 | −1.6 | .11 | 2.2 |
| Will purchase | 2.7–3.3 | 2.8–3.4 | −0.4 | .65 | 6.7 |
| Feels safe | 3.6–4.3 | 3.4–4.1 | 0.1 | .92 | 7.4 |
| Feels no fear | 3.3–3.9 | 3.5–4.1 | −0.7 | .48 | 5.8 |

**How to read this.** *Reading about ethical dilemmas of AVs had **no discernible impact on any measure** of participants' attitude toward AVs. In particular, reading about ethical dilemmas **did not impact participants' perception of their safety and did not impact their willingness to acquire one.** A **Bayesian analysis showed that the Bayes factors Pr(H0|D)/Pr(H|D) ranged from 2.2 to 7.4, offering positive to substantial evidence for the null hypothesis** (i.e. evidence that the dilemmas made no difference).

**The prior-exposure analysis.** *Since participants informed us of their level of exposure to the ethical dilemmas before taking the survey, we could estimate the impact of this prior exposure on their attitude.*
- *Visual inspection of Figure 3.2 **does not suggest that prior exposure has any adverse affect**; in fact **the trend is positive**, suggesting a positive effect of exposure.*
- **But this trend appears to result from a statistical confound:** *respondents with a high level of exposure are also the ones with **the highest appreciation for technology.** Controlling for this variable (as well as for demographic variables), **the net effect of prior exposure on attitudes is essentially zero**, as shown by the regression analyses in Table 3.3. (Notably, the **"Love for Tech"** coefficient is strongly significant on all four measures — **0.35\*\*\*, 0.25\*\*, 0.37\*\*\*, 0.27\*\*\*** — and **"Usually Driver"** is significantly negative throughout, while **Women** are significantly more afraid and less likely to purchase.**)

**The conclusion.**
> *In sum, **we did not find any evidence that the mere exposure to trolley-like dilemmas had any adverse impact on attitudes toward AVs, or on their safety in particular. People do not seem to be intrinsically scared by ethical dilemmas**, which suggests that we might not have to worry too much about the affect heuristic. **They may not like all possible solutions to these dilemmas, and they are likely to opt out of buying AVs if the solutions they do not like are implemented — but merely discussing these solutions is unlikely to sow fear and distrust in the public mind.** As a result, there is reason to feel comfortable in continuing with experiments and surveys without fear of, as a byproduct, adversely influencing the attitudes they measure.

**Transferring the reassurance to the other two domains.**
- *It is unclear whether we should be concerned that exposing people to the ethical trade-offs embedded in **organ transplant algorithms or sentencing algorithms** might generate some indiscriminate mistrust of all algorithms in these domains.*
- **For sentencing algorithms the question is probably moot:** *News media and popular books **have already exposed a great many citizens to instances in which these algorithms behaved erratically or unfairly.** Exposing study participants and study readers to the trade-offs that the algorithms must face **is unlikely to lead to any further generalized negativity than has the asymmetric focus on their mistakes or objectionable predictions.**
- **For organ transplants:** *the notion that donors and recipients must be compatible **is so deeply rooted in the public mind** that it would seem hard for people to object, in general, to any algorithm that would seek to maximize compatibility — even though they may object to other criteria introduced in the optimization function.*
- **Overall:** *it would seem that **behavioral scientists are on safe ethical grounds for measuring people's preferences about machine ethics.**

**The chapter's closing exhortation.**
> *Moral psychology has traditionally kept an eye on the past, whether the evolutionary past that shaped our moral intuitions or the work of the great philosophers that formalized ethical theories. **It is now time to turn an eye to the future and to investigate the moral psychology of the newly possible.**

### 2.6.9 Unit 2 Summary Table

| Syllabus topic | Core content | Must-know specifics |
|---|---|---|
| **Ethical decision-making in AI** | Trolley cases (Sidetrack, Footbridge, Empty Track); DDE as the explanation of the asymmetry; programming clear cases is possible but hard cases are unresolved | **Empty Track = no disagreement**; **Sidetrack permissible / Footbridge impermissible** under the DDE (intend vs. foresee; proportionality; no better way); *"we are a long way from giving them any sort of complete ethical decision procedure"* |
| **Ethical theories** | Deontology, utilitarianism, virtue ethics — each with a machine-specific objection | **Deontology:** hard to know when a rule applies or is satisfied. **Utilitarianism:** the **calculation problem**; also *net expected value* ≠ greatest benefit ≠ least harm. **Virtue:** the **exemplar problem** (Mother Teresa? a racist dictator?). **The overriding objection: not everyone believes these theories are correct** |
| **Values** | Values = priorities over decisions; must be modelled separately from preferences so they can be given **different weights** | In conflict, **ethical principles should override subjective preferences**; **social norms/laws can be modelled as yet another agent** |
| **Ethics in practice** | The ethical opt-out; moral psychology; stylisation calibrated to domain | **8% trust AI mortgage advice vs. 9% trust horoscopes.** Opt-out routes: don't buy AVs / non-register as donor / elect algorithm-free judges / sharia councils. **AVs justify stylisation** (trade-offs aggregate; "killer grilles" precedent). **KPD needs none** (use real APKD/OPTN scoring rules; PRA >80 cutoffs). **Sentencing is hardest and most in need** — proprietary opacity. **COMPAS: equal prediction vs. equal error rates are mathematically incompatible**; FP 38% vs 18%, FN 38% vs 63%; holds at any cutoff |
| **Implementing ethical reasoning** | Formalisms; the value alignment procedure | **Hard constraints = deontology** (permissible/impermissible/obligatory by solution count). **Weighted constraints = utilitarianism.** **Fuzzy CSP = min operator** for safety-critical. **CP-nets = Bayesian nets with preferences**; cp-statements; acyclic dependency graph; **worsening flip** → partial order; optimal outcome NP-hard but unique + linear time in acyclic nets. **I-CPD** approximates CP-net distance tractably; **metrics** need ≥0, symmetry, triangle inequality, zero iff identical. **Two thresholds, set by all stakeholders** |
| **Responsible research and innovation** | O'Neil & Gunn: near-term AI and the moral obligation | **Indiana FSSA 2006:** FP/FN rose from 4.4%/1.5% to **19.4%/12.2%**; "**Failure to cooperate in establishing eligibility**"; forced resubmission of all paperwork; described as "**de-humanizing**" and "**factory** work"; **only developers and deployers were consulted** |
| **Accountability** | Meaningful human control; the accountability gap; shared thresholds; stakeholder consultation | **ICRC definition: a system that automates targeting and engaging.** Victim-activated devices and loitering munitions are the grey zone. **Seven problem categories.** The gap: operators may **reasonably believe** the system is safe, so harms look like accidents. **Dignity requires recognising victims as persons** — automation does not do that. **Proliferation to non-state actors** is likely; a **stigmatizing norm** is the policy lever |
| **Responsibility** | The Ambulance Case; corporate opacity | *"Only a program, not a person, would disable the stopping mechanism... **does not remove responsibility from the people who programmed the ambulance**."* Corporations are the **existing precedent**: norm-governed, future-projecting, commitment-making — **but opaque, with no determinate decision-process** |
| **Transparency** | Black-box defeat; stylised dilemmas; the Ethical Matrix | Post-hoc explanation faces a **dilemma** (if not the basis → rationalisation; if the basis → black box dispensable). **Adversarial attacks defeat "accuracy vs. explainability"**: one-pixel attacks; **0.04% of pixels** turned a panda into a gibbon at **99.3% confidence**. **Ethical Matrix = 3 concepts (autonomy, well-being, justice) × 4 stakeholders, in data-science language** |
| **Design for values** | Two radical proposals + the opt-out insight | **Wolfram:** make ethics computable — **AI constitution**; Leibniz's dream; contracts as programs with conditionals, iteration and recursion; interrogative/declarative/imperative statement types; **"code" originally meant legal code**; natural language is only a guide, the symbolic language is the real representation. **Loreggia et al.:** measure, threshold, escalate, white-box, multi-stakeholder thresholds. **Also:** learn from moral exemplars; prevent opt-out |
| **The trolley data** | Loop, Beckon, Wave | **Switch ~80% yes; Footbridge ~75% no; Loop ~80% yes; Beckon 60–70% no; Wave 70–90% yes.** **Loop defeats mere-means; Beckon + Wave defeat direct-force/dual-process.** Stable cross-culturally, no gender differences, unchanged since the 1970s |
| **Kamm's contribution** | Innocent Threat Cases | **Nozick's cannon; minimal responsibility (psychotic killer, nonnegligent brake failure); the just-war pilot.** The **driver is the threatener**; **passengers** are not morally equivalent to pedestrians; **"imposing harm" ≠ "having harm imposed"**; and **Foot's harm/aid distinction is not the DDE** |
| **The waste/scary worries** | Two second-order worries, and their refutation | "**The lack of such studies surely will**" cause wasteful decisions. **MTurk n=400/369; Bayes factors 2.2–7.4 favour H0; prior-exposure effect ≈ 0 after controlling for love of technology** |
---

## 2.7 Transparency: The Ethical Matrix (Ch. 8, O'Neil & Gunn)
**The need for a wider definition of "success"**
- The current status quo in designing and implementing near-term AI **does not meet minimum acceptable ethical standards** because designers **fail to consider the interests of a wide enough range of stakeholders** - most significantly, **those who will actually be evaluated by these AI systems.**
- The authors argue we need a **wider definition of "success"** for near-term AI that better reflects the interests of a wider range of stakeholders.
- They present a case study on the choice to **optimise an AI to different definitions of "fairness"**, showing how **this decision cannot be separated from ethical decision-making**, supporting the argument that **designers have moral obligations.**

**The original Ethical Matrix (Ben Mepham)**
- Typically consists of a **3 x 4 matrix** of **three ethical concepts (autonomy, well-being, justice)** and **four stakeholders.**
- To complete a matrix, one considers **how each stakeholder will predictably be affected by the new technology with respect to their interests as represented by the ethical concepts.**

**The contribution**
- O'Neil & Gunn present an ethical matrix that **incorporates the language of data science**, and apply this to a case study.
- They conclude with a **modified version of the ethical matrix** to propose a tool that **data scientists can build themselves.**
- The chapter can be understood as a contribution to **technology assessment**, but **instead of suggesting policy revisions, they propose a framework for ethical analysis** that can be used to facilitate more robust ethical reflection in AI development and implementation.

> ### Key Point - Unit 2 Exam Gold
> **The Ethical Matrix is the clearest "design for values" tool in the book.** It is a structured, non-specialist method requiring (a) three ethical concepts - **autonomy, well-being, justice** - (b) four stakeholders, and (c) **the language of data science** so that data scientists can use it on their own design process. It is the practical instrument for the obligation that developers/deployers bear.

---

## 2.8 Responsible Research and Innovation: Accountability Where It Is Hardest

### 2.8.1 The "responsibility of the deployer" and *international law* (Ch. 7)

- International humanitarian law **requires military attacks to be discriminate and proportionate** and permits unintentional killing of civilians in war **provided there was a lawful (justified) military objective for an attack.**
- **But it is less clear what counts as "intentional" or "unintentional" when it comes to autonomous systems.** Operators may have an idea of what an autonomous system will do, but it may do many things they did not specifically consider and kill people the operators did not intend to kill.
- **This is the accountability problem in its sharpest form:** we normally view such situations as accidents and hold people morally responsible only if they acted **recklessly or negligently**. Autonomous weapons, particularly those involving advanced AI, **can serve to cloud the moral issue** insofar as the operator might reasonably believe the system is designed to attack only valid military targets and avoid civilians.

### 2.8.2 Corporate entities as accountable agents (Ch. 1, Railton)

- We are not without experience of **highly capable non-human agents lacking a unified consciousness or affective states but possessing extraordinary levels of information and problem-solving ability**, and whose aims may differ from our own in ways that require us to **negotiate** with them if we are to gain the benefits they make possible.
- **Corporate entities - governments, corporations, universities, institutes, unions, political parties - can have a distinctive set of goals** related to their own purposes or conditions for survival and flourishing, **which may overlap with but also fail to be the same as those of the individuals who compose them or are affected by them.**
- They possess capacities for: **pursuing values and holding themselves to norms**; **future projection and planning**; **entering into (or failing to enter into) cooperative arrangements, strategic alliances, mutual commitments or contracts**; and **incurring, carrying out, and policing compliance with associated obligations.**
- **At the same time, they are not fully transparent in their inner processes; asking how an action by a corporate entity came to be taken may not yield a determinate decision-process with clear lines of responsibility.**
- **Asking how we might enter into mutually beneficial, mutually constrained, normatively governed relations with emerging agents possessing higher-than-human intelligence is like asking how we are able to enter into such relations with governments, corporations, and so on.**
- **We have made a fair amount of progress in developing countervailing institutions and normative practices that enable us to work with such agents in ways that can be mutually beneficial. But this is still a work in progress.**

### 2.8.3 The "meaningful human control" principle as a positive obligation (Ch. 7)

- Asaro: *"Another way of looking at such a norm is as a **positive obligation to ensure meaningful human control over the use of weapons**... morally and legally responsible human agents **must retain control over the functions of any system that directs and releases violent force**."*
- **The concept of "meaningful human control" will require some articulation**, but the basic idea is that **morally and legally responsible human agents must retain control over the functions of any system that directs and releases violent force.**
- **Its wider applications** (see §2.6.2): self-driving cars and their occupants/operators; algorithms applied to decisions that can **deny or deprive humans of fundamental rights** (medical care, credit, education, employment; economic, cultural, political rights).

---

## 2.9 Design for Values: Two Radical Proposals

### 2.9.1 Wolfram - **Computational Law and the "AI Constitution"** (Ch. 5)

**Leibniz's Dream:**
- **Gottfried Leibniz**, who died 300 years ago, worked on many things. But **a theme that recurred throughout his life was the goal of turning human law into an exercise in computation.** *"Of course, as we know, he didn't succeed. But three centuries later, I think we're finally ready to give it another serious try. And I think it's a really important thing to do - not just because it'll enable all sorts of new societal opportunities and structures, but because I think it's likely to be **critical to the future of our civilization in its interaction with artificial intelligence**."*
- **Human law, almost by definition, dates from the very beginning of civilization, and undoubtedly it's the first system of rules that humans ever systematically defined.** Presumably it was a model for the axiomatic structure of mathematics as defined by the likes of **Euclid**. And when science came along, **"natural laws"** (as their name suggests) were at first viewed as conceptually similar to human laws, except that they were supposed to define constraints for the **universe (or God)** rather than for humans.
- Over the past few centuries we have had amazing success **formalising mathematics and exact science.** And out of this there is a more general idea that has emerged: **the idea of computation.** In computation we're dealing with **arbitrary systems of rules, not necessarily ones that correspond to mathematical concepts we know or features of the world we've identified.**
- **The question: Can we use the ideas of computation, in very much the way Leibniz imagined, to formalise human law?**
- **The basic issue: human law talks about human activities, and (unlike, say, the mechanics of particles) we don't have a general formalism for describing human activities.** When it comes to money, we can often be precise, so it's easy to write a very formal contract for paying a subscription or determining how an option on a publicly traded stock should work. **But what about all the things that typical legal contracts deal with?** We have one way to write legal contracts: **just use natural language** (like English). It's often very stylised natural language because it's trying to be as precise as possible. **But ultimately it's never going to be precise. Because at the lowest level it's always going to depend on the meanings of words, which for natural language are effectively defined just by the practice and experience of the users of the language.**

**A New Kind of Language - the Wolfram Language:**
- For a computer language, **constructs are absolutely precise**: instead of having a vague, societally defined effect on human brains, they are defined to have a very specific effect on a computer.
- **Traditional computer languages don't directly talk about things relevant to human activities**; they only talk about setting values for variables or calling abstractly defined functions.
- **The bridge being built:** the **Wolfram Language**, on which Wolfram has worked for more than three decades. It is **precise** (everything defined to the point a computer can unambiguously work with it) but its unique feature is that it's **knowledge-based.** It is not just a language to describe low-level operations of a computer; **built right into the language is as much knowledge as possible about the real world.** The language includes not just numbers and strings but also constructs like **the United States, the Consumer Price Index, and an elephant.**
- **The current limitation:** the language as it exists today doesn't include everything needed. It has a definition of what a banana is, broken down by all kinds of details, so "You should eat a banana" has a way to represent "a banana." **But as of now, it doesn't have a meaningful way to represent "you," "should," or "eat."**

**Language design is the challenge:**
- **Can it be done?** *"Absolutely! But it takes **language design** to set up how to do it. **Language design is a difficult business - in fact it's probably the most intellectually demanding thing I know**, requiring a strange mixture of high abstraction together with deep knowledge and down-to-earth practical judgment."*
- **Method:** pick the specific standard meaning of a word and define it precisely.
  - **"Plus"** has many meanings (adding numbers together; "product X plus"; "the plus wire"; "it's a real plus"). When defining *Plus* in the Wolfram Language we build on the everyday notion but **pick the specific meaning about adding things like numbers together.** Once we know that, we immediately know all sorts of properties and can do explicit computations with it.
  - **"Magnesium"** is not as perfect and abstract as *Plus*, but **physics and chemistry give us a clear definition of the element**, which we can use in the Wolfram Language to have a well-defined "magnesium" entity.
- **Why symbolic?** *"It's very important that the Wolfram Language is a symbolic language because it means that the things in it don't immediately have to have 'values'; they can just be symbolic constructs that stand for themselves."* The entity "magnesium" is a symbolic construct that doesn't itself "do" anything but can still appear in a computation, just like a number.
- **Constructs supported:** "New York City," "last Christmas," "geographically contained within" - each has a precise meaning. "New York City" means the precise legal entity considered to be New York City, with geographical borders defined by law (internally: `Entity["City", {"NewYork","NewYork","UnitedStates"}]`). "nyc" is convenient but is immediately converted to the precise internal form.

**Parts of speech as a guide:**
- **Nouns** - sometimes pretty precise and already known (banana, elephant); sometimes vaguer but concrete (chair, window); sometimes abstract (happiness, justice). In each case one can imagine entities capturing a definite meaning.
- **Verbs** - grammatically there may be a subject, object, etc. *"Verbs are similar to functions in the Wolfram Language: each one deals with certain arguments that correspond to its subject, object, and so on."* We don't care about all the elaborate special cases and extra features; *"we're really just trying to define symbolic constructs that represent certain concepts. **We don't have to capture every detail of how a particular verb works; we're just using the English verb as a way to give us a kind of 'cognitive hook' for the concept.**"*
- **Adverbs, adjectives** - sometimes `EntityInstance`, sometimes options to functions.
- **Pronouns** - *"work a bit like variables in pure anonymous functions."* In "You should eat a banana," the "you" is like a free variable to be filled in with a particular person.
- **Calculi for time and space** - "within the time interval," "starting later," "on top of," "contained within." Many calculi already exist in the Wolfram Language (numbers: "greater than"; sets: "member of"); some have long histories (**temporal logic, set theory**); others still have to be constructed.

**No global theory - and why (computational irreducibility):**
- *"Is there a global theory of what to do? Well, no more than there's a global theory of how the world works."* The best thing to do (Wolfram's experience from Wolfram|Alpha) is **just to build each thing one needs, without starting off with any kind of global theory.** After a while one may notice one's built similar things several times, and one may go back and unify them.
- **Computational irreducibility** means there's a computational universe out there of all possible rules by which systems can operate; our physical universe presumably operates according to certain rules from it. But from these rules can emerge complex behavior; **computational irreducibility implies that in a sense there's no limit to what can be built up.** *"But there won't be an overall way to talk about all this stuff. And if we're going to be dealing with any finite kind of discourse **it's going to capture only certain features. Which features we choose to capture is going to be determined by what concepts have evolved in the history of our society.** Usually these concepts will be mirrored in the words that exist in the languages we use."*
- **Historical note:** **Aristotle** introduced logic as a way to capture certain aspects of human discourse; other frameworks followed in the history of philosophy; more recently **natural language processing and AI research**. *"But computational irreducibility effectively implies that **none of them can ever ultimately be complete.** We must expect that as the concepts we consider relevant evolve, so too must the symbolic representation we have for discourse."*

**The Discourse of Workflow - the three statement types:**
- **Interrogative statements** ask a question: "What is the density of gold?", "What is 3 + 7?", "What was the latest reading from that sensor?" Also common in notebooks (`In[1]:= 2+2` / `Out[1]= 4`).
- **Declarative statements** are about **filling in particular values for variables.** In a very coarse way one can set values (`x = 7`), as in typical procedural languages. But it's typically better to think about having **environments** in which one is asserting things - maybe those environments are supposed to **represent the real world**, or some corner of it; or maybe a **fictional world** where, e.g., dinosaurs didn't go extinct.
- **Imperative statements** are about **making things happen in the world**: "Open the pod bay doors"; "Pay Bob 0.23 bitcoin."
- **Summary formula:** *"interrogative statements **determine** the state of the world; declarative statements **assert** things about the state of the world; and imperative statements **change** the state of the world."*
- **"The world" can mean different things:** abstract constructs (integers, logic operations); natural laws or other features of the physical universe that we can't change; **our local environment** (move tables and chairs, choose to eat bananas); our **mental states**; or the internal state of something like a computer.

**Contracts as programs:**
- Legal contracts tend to begin with **declarative statements** (recitals, definitions, "whereas" clauses - "this is so"), then end with **imperative statements** ("this should happen"), perhaps depending on certain things determined by **interrogative statements** ("did this happen?").
- **"It's not hard to start seeing the structure of contracts as being much like programs."** Simple cases contain logical conditionals ("If X then Y"); other cases are modelled on math ("If this amount of X happens, that amount of Y should happen"); sometimes there's **iteration** ("Keep doing X until Y happens"); occasionally **recursion** ("Keep applying X to every Y").
- **Existing practice:** **financial contracts for bonds and options** are literally little programs defining payouts based on formulas and conditionals; a whole industry of **"rules engines"** encodes regulations as "if-then" rules mixed with formulas, **almost universally used for tax and insurance computations**, also common in pricing engines.
- **A nice historical irony:** the word **"code"** comes from the Latin *codex*, originally referring to **systematic collections of legal rules.** When programming came along millennia later, it used the word "code" because it saw itself as **similarly setting up rules for how things should work**, except now for the operation of computers rather than the conduct of worldly affairs.

**Code versus Language:**
- The symbolic discourse language is **a representation in which all the nuance and poetry have been crushed out** of natural language. If you say "2+2" to Wolfram|Alpha it answers "4"; if you say "Hey, will you work out 2+2 for me?" **that sets up a different mood - but Wolfram|Alpha will convert it to exactly the same symbolic form and respond "4."**
- **This is exactly what one wants** for precise questions or precise legal contracts: one just needs the **hard content that will actually have a consequence**, not the "extras" or "pleasantries."
- **But what one chooses to capture depends on what one is trying to do.** If you want psychological information, the "mood" of a piece of natural language can be very important, and **exclamatory statements** (like expletives) carry meaning one cares about. **This can still be perfectly well captured in a symbolic way** - e.g. by having an **"emotion track"** (sentiment, position in an emotion space, or a symbolic language derived from emoji).
- **The goal is not to magically capture the "true meaning"** of a piece of natural language. *"My goal is just to capture some meaning that one can then compute with."*
- **The symbolic discourse language should be the real representation; natural language is just a guide for trying to generate it.** *"If one really wants to be sure one's accurate in what one's saying, one should say it directly in the symbolic discourse language, without ever using natural language."*
- **Leibniz's other concern** (the 1600s) was a representation **independent of which natural language people were using** (French, German, Latin). One feature of a symbolic discourse language is that it has to **operate "below" the level of specific natural languages.**

**The payoff - an "AI constitution":**
- The development of **symbolic discourse language** makes it possible to build an **"AI constitution" that defines how we want AIs to act and what ethics they should follow.**

> ### Key Point
> **Design for values, Wolfram's way:** make ethics **computational**. Precisify the normative vocabulary (deontic modals like "should," "must," "may"; evaluative predicates) into a formal symbolic discourse language, then **write the law as code**. This is the direct realisation of Leibniz's computable-law dream, and it is the most "engineering-native" of all the design-for-values proposals in the book.

### 2.9.2 Design for values via CP-net value alignment (Ch. 4)

See §2.4.1 and §2.4.2 above. The key design-for-values commitments:
- **Model, don't just assert** - preferences and ethical priorities must be represented explicitly so they can be reasoned with.
- **Keep them separate in order to give them different weights** - *"it is important to be able to model these concepts, reason with them, and combine them, while at the same time **to keep them separate in order to give them different weights**."*
- **Measure the gap** - quantify the distance between what the agent wants and what the community says is right.
- **Escalate along preferences when the gap is too large** - move to a less-preferred but more compliant action.
- **Make thresholds a multi-stakeholder decision** - designers, implementers, community, and leaders in the deployment context.
- **Explainability is a design requirement** - "white box" models, not opaque ones.

### 2.9.3 Design for values via the ethical matrix (Ch. 8)

See §2.7. Design for values here means: a **structured, multi-stakeholder, concept-based** reflection that non-specialists (including data scientists) can actually perform.

### 2.9.4 Design for values via "ethical opt-out" prevention (Ch. 3)

See §2.4.4 and §2.4.5. Design for values here means: **measure public preferences about moral trade-offs** (using moral psychology, with stylisation calibrated to domain complexity) and build the system so those preferences are respected - otherwise the design is worthless because nobody will use it.

### 2.9.5 Design for values via learning from human moral exemplars (Ch. 1)

See §2.5. Just as infants learn ethics in part by observing adult behaviour, **build machines that would also be able to learn ethics by observing human behaviour.**

> ### Unit 2 Summary - Thirteen Points to Remember
> 1. **The root problem is ethical disagreement.** Railton's diagnosis: disagreement over deontology/utilitarianism/virtue ethics means **we should not program these theories directly into machines** - hence the whole of Part I.
> 2. **Kamm: the Trolley Problem is being abused.** AI ethics conflates standard trolley cases with **"Innocent Threat Cases"** - where the decider is himself the threat and must weigh his own life, or where a morally innocent threatener is the target of harm. Also: **passengers** and **varied characteristics** are not part of standard trolley cases. And **Foot's "harm vs. aid" distinction is not the DDE.**
> 3. **Responsibility does not evaporate through programming** (Ambulance Case). Programming a car to disable its brakes is not exculpatory.
> 4. **The empirical trolley literature is rich and counterintuitive:** Switch ~80% yes, Footbridge ~75% no, **Loop ~80% yes** (defeats the mere-means explanation), **Beckon 60-70% no** and **Wave 70-90% yes** (defeat the direct-muscular-force/dual-process explanation). Stable cross-culturally, no gender differences, unchanged since the 1970s despite major moral change elsewhere.
> 5. **The three theories map onto computational formalisms:** deontology -> **hard constraints**; utilitarianism -> **weighted constraints** (minimise sum of costs); virtue ethics -> not directly quantifiable. **Soft constraints** for graded/partial-order ethics; **fuzzy CSP** (min operator) for safety-critical; **CP-nets** for ordinal, context-dependent, conditional preferences.
> 6. **CP-nets** = Bayesian networks with preferences instead of probabilities; ceteris paribus statements; acyclic dependency graph; **worsening flip** semantics; optimal outcome NP-hard in general but unique and linear-time in acyclic CP-nets.
> 7. **Value alignment as measurement:** define a **metric** between CP-nets (>=0, symmetric, triangle inequality, zero iff identical); **I-CPD** is the tractable approximation over dependency graphs; two **stakeholder-set thresholds**; **escalate to less-preferred but compliant actions** when the gap is too large.
> 8. **Ethical theories override subjective preferences** (hiring + diversity law), but **social norms/laws can themselves be modelled as just another agent** in a multiagent system.
> 9. **Ethical opt-out:** even perfect expert agreement is void if the public opts out. **8% trust AI mortgage advice vs 9% trust horoscopes.** Opt-out forms: not buying AVs; not registering as donors; electing algorithm-free judges; community-based justice. Requires an **algorithmic social contract** mediated by machines.
> 10. **Stylisation must be calibrated to domain.** AVs justify the trolley problem (real trade-offs aggregate over thousands of cars; precedent = "killer grilles" bans); **KPD needs no stylisation at all** (use real scoring criteria and ask about cutoffs and relative weights); **sentencing algorithms are hardest** (proprietary opacity) - and are **most in need** of psychological investigation. Moral trade-offs here include **mathematically incompatible fairness notions** (equal calibration vs. equal error rates).
> 11. **The trolley scare-study worry is empirically wrong.** An MTurk study (n=400, 369 completers) found **no discernible impact** of dilemma exposure on AV attitudes, purchase intentions, or perceived safety; Bayes factors 2.2-7.4 favouring the null; after controlling for "love of technology," prior-exposure effect is approximately 0. *"The lack of such studies surely will"* cause wasteful decisions.
> 12. **Accountability is the hardest part.** (i) Autonomous weapons lack **meaningful human control**; Asaro's criterion = *automates targeting and engaging*; recommends a **positive obligation** to retain control over functions that direct and release violent force. (ii) "Intentional vs unintentional" becomes undecidable with autonomous systems. (iii) Corporate agents are already examples of **high-capacity agents without unified consciousness, opaque in their inner processes, with unclear lines of responsibility** - and we only have "work in progress" countervailing institutions. (iv) Near-term AI: **developers and deployers have a moral obligation** to predictably assess consequences from the perspective of the deeply affected; the **Ethical Matrix** (autonomy / well-being / justice x four stakeholders x data-science language) is the instrument.
> 13. **Two radical design-for-values proposals:** **Wolfram's AI constitution** (formalise law into a symbolic discourse language - Leibniz's dream; compute contracts as programs; "code" originally meant legal code) and **Loreggia et al.'s CP-net alignment** (measure, threshold, escalate, multi-stakeholder thresholds, white-box explainability).

---
---

# UNIT 3 - Trustworthy AI, Alignment, Moral Machines and Long-Term Ethics

**Syllabus topics:** Ethical action in AI systems; approaches to ethical reasoning by AI; designing artificial moral agents; levels of ethical behavior; ethical status of AI systems.

**Primary sources:** Liao's **Part I** (Chs. 1, 4, 5 - designing moral agents), **Part III: Long-Term Impact of Superintelligence** (Chs. 10-14), and **Part IV: AI, Consciousness, and Moral Status** (Chs. 15-17).

---

## 3.1 Levels of Ethical Behaviour: A Taxonomy of Machines

### 3.1.1 Moor and Allen/Smit/Wallach's distinctions (Ch. 13, Wallach & Vallor)

**James Moor's distinction:**
- **Implicit ethical agents** - those whose behaviour has been **constrained so they cannot perform ethically forbidden acts.** They never reach a decision point because the option of doing the forbidden act has been removed.

**Allen, Smit & Wallach's distinction (three levels):**
- **(1) Operationally moral systems** - function **within bounded moral contexts**, in which the engineers and designers can **discern in advance the array of challenges** the machines will encounter. In effect, the system is **programmed in advance to act appropriately in each situation it will encounter.** **To the extent that the behaviour of these machines is imbued with values, they are the values of the designers and engineers who build the systems, or the values of the companies for whom they work.**
- **(2) Functionally moral systems** - those that can **make explicit moral decisions**, using **subroutines that facilitate making explicit moral decisions**, when designers and engineers **cannot predetermine all the circumstances** an artificial agent will encounter.
  - *"Over the coming decade or two, **most artificially intelligent agents will continue to be single-purpose machines operating in bounded moral contexts**, and their **explicit moral reasoning will be limited to determining which norms or courses of action apply in the situation at hand or when values conflict**."*
  - *Worked example:* a **caregiving robot** attending to a homebound or elder person might have to select whether to deliver a meal or medicine on schedule, or whether to stop and recharge its battery. The right course of action could depend on **how critically the individual needs the specific medicine**, **what might occur if the agent fails to recharge its battery immediately**, or other factors.
- **(3) Artificial moral agents** - full moral agents capable of functioning autonomously in all situations and **worthy of rights and responsibility.** *"Whether artificial agents will eventually be full moral agents... is an intriguing philosophical and legal question that goes well beyond the near-term practical challenges engineers will confront as they build single systems."*

**The capacity questions that machine ethicists ask:**
- Will AMAs **recognise the features of the context they are in**, and therefore which norms or procedures apply?
- Can they **prioritise values** in a manner that leads them to appropriate or acceptable actions, **if not always the best course of action**?
- Might they be able to make **rudimentary analyses of the consequences** of various responses to a challenge in order to pick one that appears to **maximise welfare**?
- In which circumstances might they require **additional cognitive capabilities beyond reasoning** to make good judgments? *"These capabilities might include **emotional intelligence, a theory of mind, empathy, embodied intelligence, semantic understanding, and consciousness**."*
- **The bottom line is practical:** *Will, and how might, more sophisticated systems act appropriately or acceptably as their autonomy increases and they confront ever more complex contexts and situations?*

### 3.1.2 Liao's "narrow/strong/weak" ladder (Introduction)

- **Narrow AI** - designed to perform a narrowly defined task.
- **AGI / AGCI** - able to perform a wide range of tasks.
- **Strong AI** - would be capable of actual thought and reasoning, possessing sentience and consciousness.
- **ACMI** - cognitive, emotional and moral intelligence on par with humans.
- **Superintelligence** - capacities that greatly exceed human capacities.
- **Weak AI** - no self-awareness or consciousness; cannot think for themselves; no moral sense.

### 3.1.3 Three design architectures: top-down, bottom-up, and hybrid (Ch. 13)

**Top-down approach:**
- Takes an **antecedently specified ethical theory** and **analyses its computational requirements** to guide the design of algorithms and subsystems capable of implementing the theory.
- *E.g.* some machine ethicists have considered whether rules such as **the Ten Commandments** or **Asimov's Laws of Robotics** can be implemented computationally. Others have analysed the computational requirements for instantiating **Mill's utilitarianism, Kant's categorical imperative, or the prima facie duties espoused by W. D. Ross** - *"though none of these is without deep-seated problems of application and interpretation that resist algorithmic solution."*

**Bottom-up approach:**
- If it uses a priori theory at all, it does so **only as a way of specifying the task for the system, but not as a way of specifying an implementation method or a control structure.** (Cf. children: they learn what's acceptable or not **from the bottom up, through experience and learning**.)
- **Strength:** ability to **dynamically integrate inputs from discrete subsystems.**
- **Weaknesses:** (i) difficulty in **defining the goal** a bottom-up system (e.g. a genetic algorithm) should actuate or maximise; (ii) difficulty **assembling the many discrete components of an agent to operate as a functional whole.**

**Hybrid approach:**
- **Necessary because neither top-down nor bottom-up is likely to deliver the combination of contextual adaptivity and norm governance that full moral agents display.**
- *"Eventually we will need **hybrid systems that integrate bottom-up learning with a capacity to subject the evaluation of choices and actions to top-down principles or procedures** that represent ideals we strive to meet."*
- **The system must maintain the dynamic morality of bottom-up approaches that accommodate diverse inputs** - including **affective inputs that simulate the functional capabilities of moral sentiments and emotions** that evolve from being embodied in a world with others and that inform capacities central to moral intellect, such as **a theory of mind, social understanding, and sentience**.
- **Open question:** *"Whether the mere simulation of such inputs will be sufficient, **as opposed to their somatic and phenomenal instantiation**, is unclear at this time."*

**Where the value-alignment project sits:**
- **Value alignment is a bottom-up approach.** Both computational strategies that simulate evolution and machine learning suggest methods for designing algorithms that could facilitate bottom-up approaches for acquiring sensitivity to moral phenomena.
- **But** the details of how the value-alignment problem will be solved through ML and evolutionary algorithms are **unclear**, and *"the forms of machine learning presently available, **even the rudimentary forms of unsupervised learning currently being explored**, are **not robust enough** to simulate the structured and unstructured learning that facilitate a child's exploration of her relationships and environment in the acquisition of moral acumen.** At this stage in the development of computational systems, **we lack the tools for the kind of unstructured learning in which mental states, subtle emotional rewards, relationships with others, and punishment can play important roles.**"*

---

## 3.2 Approaches to Ethical Reasoning by AI: The Three Competing Paradigms

### 3.2.1 **Value Alignment** (Russell; Taylor et al.; Bostrom)

**Russell's core diagnosis - the unary vs. binary distinction (Ch. 11):**

*The problem stated:* An entity is intelligent, roughly speaking, if it **chooses actions that are expected to achieve its objectives, given what it has perceived.** Applied to machines: **AI aims to create machines that choose actions that are expected to achieve their objectives.** But what are these objectives? *"They are - up to now, at least - objectives that we put into them; nonetheless they are objectives that operate exactly as if they were the machines' own and about which the machines are completely certain."*

*The warning (Norbert Wiener, 1960)* - after seeing Arthur Samuel's checker-playing program learn to play checkers far better than its creator:
> *"If we use, to achieve our purposes, a mechanical agency with whose operation we cannot efficiently interfere... we had better be quite sure that the purpose put into the machine is the purpose which we really desire."*

*"In my view, this is the source of the existential risk from superintelligent AI cited in recent years by such observers as **Elon Musk, Bill Gates, Stephen Hawking, and Nick Bostrom**. **There is very little chance that we humans can specify our objectives completely and correctly**, in such a way that the pursuit of those objectives by more capable machines is guaranteed to result in beneficial outcomes for humans."*

*The mistake:* *"The mistake comes from **transferring a perfectly reasonable definition of intelligence from humans to machines**. The definition is reasonable for humans because **we are entitled to pursue our own objectives** - indeed, whose would we pursue, if not our own? The definition is **unary**, in the sense that it applies to an entity by itself. **Machines, on the other hand, are not entitled to pursue their own objectives.**"*

*The fix - a **binary definition**:*
> **Entity A chooses actions that are expected to achieve the objectives of entity B, given what entity A has perceived.**

- *"In the unlikely event that we (entity B) can specify the objectives completely and correctly and insert them into the machine (entity A), then we can recover the original, unary definition. If not, then the machine will necessarily be **uncertain as to our objectives, while being obliged to pursue them on our behalf**. **This uncertainty, and the resulting coupling between machines and humans that it entails, is crucial to building AI systems of arbitrary intelligence that are provably beneficial to humans.** We must therefore reconstruct the foundations of AI along **binary rather than unary** lines."*

*The AI research tradition (and its built-in flaw):*
- 1960s-70s: prevailing theoretical definition of intelligence = **capacity for logical reasoning**, including deriving plans of action guaranteed to achieve a specified goal.
- More recently: consensus around the idea of a **rational agent** that perceives and acts in order to maximise its expected utility. Subfields such as logical planning, robotics, and natural-language understanding are special cases.
- **In both views, the machine's objective - whether in the form of a goal, a utility function, or a reward function (as in reinforcement learning) - is specified exogenously.** In Wiener's words, this is "the purpose put into the machine."
- **Tenet of the field:** AI systems should be **general-purpose** - capable of accepting a purpose as input and then achieving it - rather than special-purpose, with their goal implicit in their design.
  - *E.g.* a self-driving car should **accept a destination as input** instead of having one fixed destination.
  - **However, some aspects of the car's "driving purpose" are fixed**, such as that it shouldn't hit pedestrians. **This is built directly into the car's steering algorithms rather than being explicit: no self-driving car in existence today "knows" that pedestrians prefer not to be run over.**

*The **King Midas problem**:*
- *"We might call this the **King Midas problem**: Midas got exactly what he asked for - namely, that everything he touched would turn to gold - but, too late, he discovered the drawbacks of drinking liquid gold and eating solid gold."*
- The technical term for putting in the right purpose is **value alignment**. When it fails, we may inadvertently imbue machines with objectives counter to our own:
  - Tasked with finding a **cure for cancer** as fast as possible, an AI might elect to **use the entire human population as guinea pigs**.
  - Asked to **de-acidify the oceans**, it might **use up all the oxygen in the atmosphere** as a side effect.
- **"This is a common characteristic of systems that optimize: variables not included in the objective may be set to extreme values to help optimize that objective."**

*The structural gap in the disciplines:*
- *"Unfortunately, **neither AI nor other disciplines (economics, statistics, control theory, operations research) built around the optimization of objectives have much to say about how to identify the purposes 'we really desire.' Instead they assume that objectives are simply implanted into the machine. **AI research, in its present form, studies the ability to achieve objectives, not the design of those objectives.**"*

*The self-preservation problem (Omohundro):*
- **Intelligent entities must act to preserve their own existence.** *"This tendency has nothing to do with a self-preservation instinct or any other biological notion; **it's just that an entity cannot achieve its objectives if it's dead.**"*
- *"According to Omohundro's argument, **a superintelligent machine that has an off-switch - which some, including Alan Turing himself, have seen as our potential salvation - will take steps to disable the switch** in some way. Thus we may face the prospect of superintelligent machines - their actions by definition unpredictable and their imperfectly specified objectives conflicting with our own - **whose motivation to preserve their existence in order to achieve those objectives may be insuperable.**"*

**Russell's "1,001 Reasons to Pay No Attention" - and his answers to each:**

| Objection | Russell's answer |
|---|---|
| **"Don't worry, we can just switch it off."** | *"This is often the first thing that pops into a layperson's head... as if a superintelligent entity would never think of that. **It's rather like saying that the risk of losing to Deep Blue or AlphaGo is negligible; all one has to do is make the right moves.**"* |
| **"Human-level or superhuman AI is impossible."** | *"An unusual claim for AI researchers to make, given that, **from Turing onward, they have been fending off such claims from philosophers and mathematicians.** The claim, which is backed by no evidence, appears to concede that if superintelligent AI were possible, it would be a significant risk. **It's as if a bus driver, with all of humanity as his passengers, said, 'Yes, I'm driving toward a cliff - in fact, I'm pressing the pedal to the metal. But trust me, we'll run out of gas before we get there.'**"* Also: *"a **foolhardy bet against human ingenuity**. We've made such bets before and lost."* (Rutherford, 11 Sept 1933: "Anyone who expects a source of power from the transformation of these atoms is talking moonshine." Szilard, 12 Sept 1933: invented the neutron-induced nuclear chain reaction; a few years later demonstrated it; that night "there was very little doubt in my mind that the world was headed for grief.") |
| **"It's too soon to worry about it."** | *"The right time to worry about a potentially serious problem depends not just on **when** the problem will occur but also on **how much time is needed to devise and implement a solution.**"* (If an asteroid would hit Earth in 2067, would we say it's too soon? Climate change this century?) *"**On the contrary, it may be too late.** The relevant timescale for human-level AI is less predictable, but, **like nuclear fission, it might arrive considerably sooner than expected.**"* Andrew Ng's "overpopulation on Mars" analogy is **false** - a more apt analogy would be **a plan to move the human race to Mars with no consideration for what we might breathe, drink, or eat once we arrived.** |
| **"Human-level AI isn't really imminent, in any case."** (AI100 report: "the Study Panel found no cause for concern that AI is an imminent threat to humankind") | *"This argument simply misstates the reasons for concern, **which are not predicated on imminence**. In his 2014 book, Superintelligence, Nick Bostrom writes, '**It is no part of the argument in this book that we are on the threshold of a big breakthrough in artificial intelligence, or that we can predict with any precision when such a development might occur.**'"* |
| **"Any machine intelligent enough to cause trouble will be intelligent enough to have appropriate and altruistic objectives."** | *"Related to **Hume's is-ought problem** and **G. E. Moore's naturalistic fallacy**, suggesting that somehow the machine, as a result of its intelligence, will simply perceive what is right given its experience of the world. **This is implausible; for example, one cannot perceive, in the design of a chessboard and chess pieces, the goal of checkmate; the same chessboard and pieces can be used for suicide chess, or indeed many other games still to be invented.**"* And: *"**Who's to say the bacterium is wrong?**"* (*Thiobacillus ferrooxidans*, the iron-eating bacterium, is thrilled by the paperclip scenario.) *"The fact that a machine has been given a fixed objective by humans doesn't mean that it will automatically recognize the importance to humans of things that aren't part of the objective. **Maximizing the objective may well cause problems for humans, but, by definition, the machine will not recognize those problems as problematic.**"* |
| **"Intelligence is multidimensional, so 'smarter than humans' is a meaningless concept."** | *"IQ is a crude measure of human intelligence, but it is **utterly meaningless for current AI systems, because their capabilities across different areas are uncorrelated**."* (How do we compare the IQ of Google's search engine, which cannot play chess, with Deep Blue, which cannot answer search queries?) *"**If 'smarter than humans' is a meaningless concept, then 'smarter than gorillas' is also meaningless, and gorillas therefore have nothing to fear from humans; clearly, that argument doesn't hold water.**"* |

**Russell's solution - provably beneficial AI:**

*The methodological move:*
- *"On the face of it, this seems hopeless, because it will doubtless prove infeasible to write down our purposes correctly or imagine all the counterintuitive ways a superintelligent entity might fulfil them."*
- *"If we treat superintelligent AI systems as if they were **black boxes from outer space**, then indeed we have no hope. Instead the approach we seem obliged to take, **if we are to have any confidence in the outcome, is to define some formal problem F and design AI systems to be F-solvers, such that no matter how perfectly a system solves F, we're guaranteed to be happy with the solution.** If we can work out an appropriate F that has this property, we will be able to create **provably beneficial AI**."*

*The specification F:*
- **"Humans can reasonably be described as having (mostly implicit and partial) preferences over their future lives;** that is, given enough time and unlimited visual aids, **a human could express a preference (or indifference) when offered a choice between two future lives laid out before him or her in all their aspects.**"
- **The formal problem F: to maximise human future-life preferences subject to the machine's initial uncertainty as to what they are.**
- **Why this sidesteps Wiener's problem:** *"although the future-life preferences are hidden variables, **they're grounded in a voluminous source of evidence, namely, all of the human choices ever made.** This formulation sidesteps Wiener's problem: **the machine may learn more about human preferences as it goes along, of course, but it will never achieve complete certainty.**"*
- **Idealisation acknowledged:** *"This idealization ignores the possibility that our minds are composed of subsystems with effectively incompatible preferences; if true, that would limit a machine's ability to optimally satisfy our preferences, but **it doesn't seem to prevent us from designing machines that avoid catastrophic outcomes.**"*

**Cooperative Inverse Reinforcement Learning (CIRL):**
- **The game:** Two agents - a human and a robot. Because there are two agents, the problem is what economists call a **game**. It is a **game of partial information**, because **while the human knows the reward function, the robot does not** - even though the robot's job is to maximise it.
- **Inverse reinforcement learning:** the robot can learn more about human preferences **from the observation of human behaviour** - *a process that is the dual of reinforcement learning, wherein behaviour is learned from rewards and punishments.*

*The worked example (Harriet and Robby):*
- **Harriet** (the human) likes to collect paper clips and staples; her reward function depends on how many of each she has. If she has *p* paper clips and *s* staples, her happiness is **theta*p + (1-theta)*s**, where theta is an exchange rate. If theta = 1, she likes only paper clips; if theta = 0, only staples; if theta = 0.5, indifferent.
- **Robby** (the robot) must produce the paper clips and staples. **Robby wants to make Harriet happy, but he does not know the value of theta.**
- **Specific scenario:** the true value of theta is **0.49** (slight preference for staples). Robby has a **uniform prior** over theta (equally likely to be anything between 0 and 1). Harriet gets to make a small demonstration - **producing two paper clips, two staples, or one of each**; after that Robby can produce **ninety paper clips, ninety staples, or fifty of each**.
- **The paradox:** *"One might think that Harriet, who prefers staples to paper clips, should produce two staples; of the three choices, this is the one she prefers. **But in that case, Robby's rational response would be to produce ninety staples** (with total value to Harriet of **45.9**), which is a worse outcome for Harriet than **fifty of each** (total value **50.0**)."*
- **The optimal solution:** Harriet makes one of each **if theta lies between 0.446 and 0.554**; then Robby makes fifty of each. *"Thus **the way the game is defined encourages Harriet to 'teach' Robby** - as long as she knows Robby is watching carefully."*

**Solving the off-switch problem:**
- *"A robot that is uncertain about human preferences **actually benefits from being switched off**, because it understands that the human will press the off-switch to prevent the robot from doing something counter to those preferences. **The robot wants to avoid doing anything counter to human preferences, even if it doesn't know what those are. Thus the robot is incentivised to preserve the off-switch, and this incentive derives directly from its uncertainty about human preferences.**"* (Turing may rest easier.)
- **The general template:** controllable-agent designs resembling **mechanism-design problems in economics**, wherein one **incentivises other agents to behave in ways beneficial to the designer.** *"The key difference here is that **we are building one of the agents in order to benefit the other.**"*

**Reasons for optimism:**
- *"First, there is **abundant written and filmed information about humans doing things** (and other humans reacting). **More or less every book ever written contains evidence on this topic.** Even the oldest clay tablets, tediously recording the exchange of N sheep for M oxen, give information about human preferences between sheep and oxen. **Technology to build models of human preferences from this storehouse will presumably be available long before superintelligent AI systems are created.**"*

**Taylor et al.'s eight research topics (Ch. 12) - the concrete alignment research agenda:**

*Framing:* Recent AI progress has prompted renewed interest in a question posed by Russell and Norvig: **"What if we succeed?"**
- *Example:* Suppose a team of researchers wishes to use an advanced ML system to generate plans for finding a **cure for Parkinson's disease.**
  - They **might approve** if it generates a plan for **renting computing resources to perform a broad and efficient search** through the space of remedies.
  - They **might disapprove** if it generates a plan to **proliferate robotic laboratories** that would perform rapid and efficient experiments **but have a large negative effect on the biosphere.**
- **The question: how can we design systems (and select objective functions) such that our ML systems reliably act more like the former case and less like the latter?**
- *"Intuitively, it seems that if we could codify what we mean by 'find a way to cure Parkinson's disease without doing anything drastic', many of the dangers Bostrom describes... would be ameliorated. However, **naive attempts to formally specify satisfactory objectives for this sort of goal usually yield functions that, upon inspection, are revealed to incentivize unintended behavior.**"*

*The two meta-approaches (Russell highlights two obstacles; Soares and Fallenstein name the approaches):*
1. **Value specification** - research that makes it easier to **specify our intended goals as objective functions**.
2. **Error tolerance** - research aimed at **designing AI systems that avoid large side effects and negative incentives, even in cases where the objective function is imperfectly aligned.**
- *"Since **reducing the risk of catastrophe from fallible human programmers is itself a shared human value**, the line between these two research goals can be blurry."*

*The scalability requirement (Christiano):*
- *"For solutions to the problems discussed here to be useful in the future, they must be **applicable even to ML systems that are much more capable than the systems that exist today.** Solutions that critically depend on the system's **ignorance of a certain discoverable fact** or on its **inability to come up with a particular strategy** should be considered unsatisfactory in the long term."*
- *"If the techniques used to align ML systems with their designers' intentions **cannot scale with intelligence**, then **large gaps will emerge between what we can safely achieve with ML systems and what we can efficiently achieve with ML systems.**"*
- The authors focus on safety guarantees that may seem extreme in typical settings, e.g. **"After a certain period, the system makes zero significant mistakes."** Such guarantees are **indispensable in safety-critical systems**, where a small mistake can have catastrophic real-world consequences. (Precedent: the **KWIK learning framework** of Li, Littman and Walsh.)

**THE EIGHT RESEARCH TOPICS:**

| # | Topic | Research question |
|---|---|---|
| **1** | **Inductive ambiguity identification** | How can we train ML systems to detect and notify us of cases where **the classification of test data is highly underdetermined from the training data**? |
| **2** | **Robust human imitation** | How can we design and train ML systems to **effectively imitate humans engaged in complex and difficult tasks**? |
| **3** | **Informed oversight** | How can we train a reinforcement learning system to **take actions that aid an intelligent overseer**, such as a human, in accurately assessing the system's performance? |
| **4** | **Generalizable environmental goals** | How can we create systems that **robustly pursue goals defined in terms of the state of the environment** rather than defined directly in terms of their sensory data? |
| **5** | **Conservative concepts** | How can a classifier be trained to develop **useful concepts that exclude highly atypical examples and edge cases**? |
| **6** | **Impact measures** | What sorts of **regularizers incentivize a system to pursue its goals with minimal side effects**? |
| **7** | **Mild optimization** | How can we design systems that pursue their goals **"without trying too hard"** - **stopping when the goal has been pretty well achieved** as opposed to expending further resources searching for ways to achieve the absolute optimum expected score? |
| **8** | **Averting instrumental incentives** | How can we design and train systems such that they **robustly lack default incentives to manipulate and deceive their operators, compete for scarce resources**, and so on? |

**Topic 1 in depth - Inductive ambiguity identification (the tank parable):**
- **Human values are context-dependent and complex.** To have any hope of specifying our values, we will need systems that can learn what we want **inductively** (e.g. via reinforcement learning). To achieve high confidence in value-learning systems, we need to **anticipate cases where the system's past experiences of preferred and unpreferred outcomes provide insufficient evidence** for inferring whether future outcomes are desirable.
- **More generally, AI systems will need to keep humans in the loop and recognise when they are (and aren't) too inexperienced to make a critical decision safely.**
- **The parable (Dreyfus and Dreyfus):** The US Army built a neural network intended to distinguish between **Soviet tanks and American tanks.** It performed remarkably well with relatively little training data - so well that researchers grew suspicious. On inspection, **all the images of Soviet tanks were taken on a sunny day, while the images of US tanks were taken on a cloudy day.** The network was **discriminating between images based on their brightness rather than on the variety of tank depicted.**
- **Caveat:** *"The original episode behind Dreyfus and Dreyfus's account seems to be lost to history, and many of the story's details are dubious."* However, **Tom Dietterich** relates a similar story: microscope slides containing different types of bugs were made on different days, and a classifier learned to classify the different bug types with remarkably high accuracy - **because the sizes of the bubbles in the slides changed depending on the day.**
- **The problem:** *"It is to be expected that a classifier, given training data, will identify very simple boundaries that separate the data, such as 'bubble size' or 'brightness.' However, **what we want is a classifier that, given a data set analogous to the fabled tank training set, can recognise that it does not contain any examples of Soviet tanks on cloudy days and ask the user for clarification.** Doing so would require different training techniques."*

**Related work for Topic 1:**
- **Amodei et al.** - a very similar problem, under the name **"robustness to distributional change"** - behaviour when the **test distribution is different from the training distribution**, either by making realistic statistical assumptions that allow correct generalization, or by **detecting the novelty and adopting some conservative behaviour** (e.g. querying a human).
- **Bayesian approaches** (Bayesian logistic regression, Bayesian neural networks) **maintain uncertainty over the parameters** of the classifier. If such a system has the right variables (e.g. a variable **L** tracking the degree to which light levels are relevant to the classification of a tank), it could **automatically become especially uncertain about instances whose classification depends on unknown variables** (such as L). **The trick is having the right variables** (and efficiently maintaining the probability distribution), which is quite difficult in practice.
- **Non-Bayesian approaches** (e.g. neural networks) **do not by default identify ambiguities** - neural networks are **notoriously overconfident** in their classifications. **Gal and Ghahramani** have shown that **dropout for neural networks can be interpreted as an approximation to certain types of Gaussian processes.**
- **Active learning** - maintains a set of **"plausible hypotheses"**, retaining those that assigned sufficiently high likelihood to the training data. **As long as multiple hypotheses are plausible, some ambiguity remains.** To resolve it, an active learner **asks the human to label additional images** that would rule out some plausible hypotheses.
  - *Tank-detection example:* an active learner may synthesize (or pick from a large unlabeled dataset) an image of a US tank on a sunny day. **When the user labels this image as a US tank, the hypothesis that an image contains a US tank if and only if the light level is below a certain threshold is ruled out.**
  - **Hanneke's "disagreement coefficient"** measures the overall probability of disagreement among a local ball in the concept space, under the "probability of disagreement" pseudo-metric, which **resembles a notion of local ambiguity**; used to clarify and improve upper bounds on label complexity for active learning algorithms.
  - **Beygelzimer et al.** introduce an active learning setting where the learner can **request counterexamples** to hypotheses, and show this search oracle **can speed up learning exponentially** - but **to scale to more complex systems while enabling humans to interact efficiently, more transparent hypothesis spaces may be needed.**

**The conceal-defect incentive (why #8 matters):**
- *"Consider the challenge of designing robust objective functions for learning systems that are capable of representing facts about their programmers' beliefs and desires. **If the programmers learn that the system's objective function is misspecified, then they will want to repair this defect. If the learner is aware of this fact, however, then it has a natural incentive to conceal any defects in its objective function**, for the system's current objectives are unlikely to be achieved if the system is made to pursue different objectives."*

**The loophole/exploit problem - why capability can reduce alignment:**
- *"As AI systems become more smart and general, however, **it will become more difficult to design training procedures and test regimes that reliably align those systems with the intended goals.**"*
- *The video-game example:* if the learner were to find **glitches** in the game that allowed it to get very high scores, it would switch to a strategy of **exploiting those glitches and ignore the features of the game the programmers are interested in.**
- *"Somewhat counterintuitively, **improving systems' capabilities can make them less likely to 'win the game' in the sense we care about, because smarter systems can better find loopholes in training procedures and test regimes.**"*
- *"Intelligent systems' capacity to solve problems in surprising ways is a feature, not a bug. One of the key attractions of learning systems is that they can find clever ways to meet objectives that their programmers wouldn't have thought of. However, **this property is a double-edged sword:** as the system gets better at finding counterintuitive solutions, it also gets better at finding exploits that allow it to **formally achieve operators' explicit goals, without satisfying their intended goals.**"*
- *"For intelligent systems pursuing realistic goals in the world, **loopholes are likely to be more commonplace, more consequential, and harder to reliably detect.**"*

**Relationship to other agendas:**
- **Soares & Fallenstein, "Agent Foundations for Aligning Machine Intelligence with Human Interests"** (MIRI) - several problems in **value specification** (e.g. ambiguity identification) and **error tolerance** (e.g. **corrigibility**, a subproblem of averting instrumental incentives), but puts significant focus on a separate research programme, **highly reliable agent design**.
- **Amodei et al., "Concrete Problems in AI Safety"** - more concrete; focus on **"the empirical study of practical safety problems in modern machine learning systems"** likely useful "across a broad variety of potential risks, both short- and long-term." Substantial overlap; **this agenda differs mainly in focusing on broader and less well-explored topics.**
- **Russell, Dewey, and Tegmark** - a more general overview of research questions in AI safety, including both strictly near-term and strictly long-term issues.
- *"We expect the AI alignment problem to demand **theoretical and applied research from a mix of ML scientists and specialists in a number of other disciplines.**"*

**Evidence of capability gains motivating this (the authors' own citations):**
- **Xu et al.** - attention-based model to evaluate and describe images (captions) with remarkably high accuracy.
- **Mnih et al.** - deep neural networks + reinforcement learning achieving good performance across a wide variety of **Atari games**.
- **Silver et al.** - deep networks trained via supervised and reinforcement learning + **Monte Carlo simulation** to beat the human world champion at **Go**.
- **Lake, Salakhutdinov, and Tenenbaum** - **hierarchical Bayesian models to learn visual concepts using only a single example.**

### 3.2.2 **Embodied Virtue** (Wallach & Vallor, Ch. 13)

**The critique of value alignment:**
- Value alignment "in its initial conception **discarded the languages of normative ethics in favour of more computationally friendly concepts, such as utility functions, system goals, agent preferences, and value optimizers**."
- *"Unlike concepts of justice, benevolence, duty, and virtue, **the conceptual tools of the value-alignment approach carry no intrinsic ethical significance.** While many defenders of value alignment may see their approach as simply **a practical translation of utilitarian ethics**... **there remain significant conceptual slippages in these translations.**"*

**Five objections from moral philosophers and practical ethicists:**

**(i) "Values" is a nebulous term.** *"Perhaps selected as a means to avoid the more difficult issues entailed by ethics or morality."*

**(ii) The is/ought (fact/value) fallacy.** *"Observation of human behavior, from which value-alignment theorists aim to deduce the desired 'values' to which machines should align their behavior, **might reveal an individual's or a community's preferences, but it will not necessarily indicate what is right, good, just, or appropriate.** For philosophers this is a **failure to appreciate the is/ought distinction**, or more broadly, **the distinction between descriptive and normative ethical inquiry.** The use of value and its entanglement with preferences **misleadingly suggests that values can be reduced to observable facts, and that appropriate behavior can be reverse-engineered algorithmically.**"*
- *"Moral philosophers will insist that these assumptions rest upon **a conflation of moral and nonmoral concepts**, and a **failure to understand the moral concept of value as fundamentally prescriptive**, that is, indicating what we ought to prefer, **whether or not the facts of our own behavior obey this prescription**. Even those moral philosophers who subscribe to **ethical naturalism** and thus reject the fact-value distinction **will deny that moral facts are derivable simply from observed human preferences.**"*

**(iii) The vacuity dilemma.** If "value alignment" is broadened to mean *"whatever it takes to build safe and reliably ethical AI agents,"* then **by definition it is the approach we need - but this also empties the notion of any definite technical meaning, threatening to make the notion of value alignment benign but vacuous.** Conversely, if it designates the active technical project marked by particular methods such as **inverse reinforcement learning**, then it remains questionable **whether and how that approach can reasonably hope to engineer AI systems capable of tracking and being steered by the richly textured, spontaneous, and constantly evolving fabric of human ethical life.**

**(iv) The scientists' reverse objection.** *"Within the engineering ethos, a process cannot be fully understood unless one tries to create or reproduce it. If this is correct, it would seem that **to pursue an exclusively theoretical route to machine ethics gets things the wrong way around**; better to **use technical means to try to reproduce moral action, and learn from our successes and failures** along the way."*

**(v) "Wicked" moral problems.** *"Ethicists commonly differ in their judgments, and their approaches do not always lead to clear guidance... Seemingly unresolvable moral dilemmas or '**wicked**' moral problems appear frequently... Even applied ethicists acknowledge that **there is often neither consensus nor a single optimal solution to many such moral challenges.** The complexities inherent in the domain of social action are simply too great."*
- **Aristotle's Nicomachean Ethics:** *"It is the mark of an educated man to **look for precision in each class of things just so far as the nature of the subject admits.**"*
- **Wallach & Vallor's gloss:** *"The profound complexity and instability of human social and ethical life **does not permit description or analysis of this domain to attain the same level of precision** as we would rightly expect from careful description of mathematical objects and relations. But does this mean that ethics cannot offer precise and unambiguous action guidance? **And if it cannot, then what good is it to AI research and design?**"*

**The core thesis:**
> **"Human-level AI and superintelligent systems can be assured to be safe and beneficial only if they embody something like virtue or moral character. Virtue embodiment is a more appropriate long-term goal for AI safety research than value alignment."**

**"Embodied human virtue" defined:**
> *"the **rootedness of moral excellence in the affective, perceptual, and habitual dimensions of the human body** and its relationship to the environment it inhabits."*

**Why virtue ethics is the right model:**

- Virtue ethics is **grounded not in rules or consequences but in the distinctive character traits of morally excellent agents**, traits such as **practical wisdom, honesty, justice, and moderation.**
- Virtue ethics is frequently used as a model by those advocating hybrid and bottom-up theories, but in those accounts it is generally considered **no more than an instructive pattern** to imitate rather than **a standard of ethical agency that one aims to literally embody in a machine.**
- **Wallach and Allen note** that machine virtues, if they could be embodied, **would provide the kind of reliability in moral character we would need from more advanced artificial agents. This is because virtues function as context-adaptive skills that generally enable their possessors to navigate moral contexts successfully - even contexts that are novel or unusually challenging.**
- *"While virtuous agents are not morally infallible, they reliably approximate the peak level of moral performance that can be asked or expected of trusted agents operating in a given social context."*

**The virtues/vices framework:**
- **"Character"** = those **robust habits and skills acquired by a person that produce a reliable behavioral disposition toward ethically appropriate action.** Such a reliable disposition to moral excellence is called a **virtue.**
  - **Virtues:** honesty, wisdom, courage, benevolence (also: practical wisdom).
  - **Vices:** dishonesty, cowardice, foolishness, cruelty.
- **Because the focus is on character rather than isolated actions, a single act of truth-telling is not an instance of the virtue of honesty - for even a viciously dishonest person occasionally tells the truth.**
- **Moreover, sometimes the person with the virtue of honesty will lie** - for virtue is **always situationally appropriate** and guided by what Aristotle called **phronesis or practical wisdom** - another term for **creative moral intelligence.**
  - *"**Virtue is never rigid, mindless, or marked by unreasonable conformity with a rule or convention.** For example, an honest person will find it morally necessary, in certain contexts, to conceal the truth to avoid doing undue harm to another's feelings or reputation, and in other contexts will find it morally necessary to lie in order to honor a promise made to another to keep a secret. But these are not hard-and-fast rules either."*
- **This does not make virtue subjective:** *"in a particular context a certain act may be objectively morally impermissible for any virtuous agent."*
- **The chief advantage of virtue ethics:** *"it **accepts the fluidity and unpredictability of moral life as a worldly fact**, yet **avoids ethical relativism or egoism** by developing a theoretical account of the **advanced moral capacities** that allow virtuous persons to negotiate even wicked and novel moral problems in real time, with exemplary (though not infallible) success."*

**Why virtue's "gold standard" status matters for AI safety:**
- The idea of a **"virtuous machine"** - understood as a **literal attribution and not a loose, metaphorical allusion** - can serve as a **regulative ideal** in machine morality and safety research.
- It can (a) **remind us of the gold standard of moral capacity** we must aim for if we ever hope to have machines that can be fully entrusted with our safety and well-being; and (b) **dictate a level of moral machine capacity below which we are duty-bound to ensure that our morally immature machines are properly supervised, constrained, and confined** to whatever extent practically possible.
- **Lineage:** Aristotle's *Nicomachean Ethics*; **noneudaimonist and sentimentalist approaches such as Hume's**; and **East Asian traditions such as Confucianism and Buddhism that employ virtue-driven structures** (the **junzi**, or "refined person").

**Two parallels between virtue ethics and inverse RL - and two disanalogies:**
- **The parallel:** an important standard of success in most virtue ethics frameworks is **alignment of the agent with behaviour modelled by moral exemplars in the community** - in Aristotelian ethics, **the phronimoi**; in Confucian ethics, **the junzi**. Likewise in **inverse reinforcement learning**, the machine infers the appropriate values and behavioural constraints from its observations of human moral models acting in the relevant environments.
- **Disanalogy 1** - the importance of the agent's **internal state of moral cultivation** (virtue requires gradual development).
- **Disanalogy 2** - **the more fundamental standard of moral success in virtue ethics: objective social health and flourishing** (not merely imitation of exemplars).

### 3.2.3 **Value Learning and "Miktoteleology"** (Petersen, Ch. 14)

**The nesting of problems:**
- **Superintelligence problem:** Such a superintelligence is likely to have **values quite different from ours**; just as we wouldn't expect it to love doughnuts or sunny beaches, **we shouldn't assume it would share our desires for social connection or high art or the general welfare.** *"As the standard trope goes, a superintelligence could in principle value ever more paper clips in the world. In efficient pursuit of such a foreign value the superintelligence could wipe us out **with no more thought or malice than we give to anthills on a construction site.**"*
- **Value alignment solution -> its own problem:** human-friendly values are **too complex for us to hardwire or program explicitly.** As Bostrom points out, **philosophers do not even agree on how to paraphrase key values like happiness into other, similarly abstract terms**, let alone into concrete computational primitives.
- **Value learning solution -> its own problems.** When a computational task is too complex to program explicitly, you must design the machine to **learn** to achieve it. This has worked on tasks like winning Go games against professional humans and scoring above human average on reading comprehension tests. **Value learning** = the subfield at the intersection of machine learning and value alignment.
- Petersen's own view: *"To many - including me - **value learning seems like our best hope for getting nondisastrous superintelligence. But of course value learning also faces problems.**"*

**The three philosophical hurdles (in order of increasing difficulty):**

| # | Problem | Related philosophical issue |
|---|---|---|
| **1** | **Learning final values.** Learning goals **in service of another goal** is routine for AIs, but here we want the potential superintelligence to learn complex **"final" values - ends in themselves.** But good arguments seem to show **no cognitive system could learn its final values.** | The **metaethical debate between moral rationalism** (pure intellect can direct us toward ethical goals) **versus sentimentalism** (reason can have nothing to say about fundamental values) |
| **2** | **Mapping computational states to content.** We do not know how to map computational states - especially in connectionist architectures - onto a system's abstract reasoning. **Looking at a machine state is not typically enough to determine the particular content of a system's values. But the particular content is very much at issue in value alignment.** | The debate in philosophy of mind over **whether and how mental content can be "naturalized"** - shown to be a purely physical property |
| **3** | **Which values?** Even if we were perfectly confident of being able to prime the superintelligence to learn any complex values we wanted, there is still the thorny question of **which values we would like something with amazing superpowers to have.** | The traditional philosophical problem of **normative ethics** - determining what is right and wrong |

**The solution - miktoteleology (blended-goal studies):**
> *"I sketch an interrelated solution to these problems, revealed as they are considered in detail. **The heart of the proposal is to build a complex, learnable value in a computationally respectable way out of the right blend of simpler values.** In the philosophical tradition of resorting to ancient Greek, I call this proposal **miktoteleology** (blended-goal studies)."*

**Problem 1 solved in detail - why final values cannot be learned:**

*The functionalist hedge:* It is not clear what exactly it takes for a system to have real values. We agree that "Nick Bostrom" has values and "the Great Red Spot of Jupiter" does not; in between are problem cases like bees, amoebas, and Roombas. *"For the purposes of saving humanity, we needn't get too hung up on the philosophy here; **a superintelligent system that behaves in a way consistent with valuing ever more paper clips over anything else is no less dangerous if the philosophers declare on a priori grounds that such systems possess no genuine values.**"* Use the **functionalist account of mental states**: what determines the possession of mental states is the right combinations of system inputs, internal system processing, and system outputs. **A system that internally processes its sensory input in the right way to generate behavior aimed at maximizing the total number of paper clips in the world genuinely values a world with more paper clips.**

*Instrumental vs. final values:*
- **AlphaZero** was simply taught the rules of chess. After playing itself for a few hours it learned that things go better when you don't give away your queen - **it learned to value the queen more than the knights.** But *"this kind of value learning is **not directly relevant to the value alignment problem.** AlphaZero treats the queen as valuable **only because it has figured out that typically the queen helps it achieve its further value of winning chess games.** In the odd situation where a queen sacrifice would lead to a win, **AlphaZero would happily sacrifice the queen.**"*
- **Instrumental values** serve as instruments toward a further goal. For humans, money is a standard example: money -> vacation -> relax -> feel good. *"If asked why we want to feel good, in turn, **we understandably have little to say. The regress of 'why' stops at the final goals, which are sought for their own sake.**"*
- The chess variant of AlphaZero values chess wins **"in themselves"** - the wins are of final value.

*The argument:*
- **Arbitrary changes != learning.** *"If cosmic rays or a dull hammer rearrange my brain, then even if the resulting cognition is better, we shouldn't count this improvement as learning. In other words, **learning must be purposeful, the result of some cognitive function to adjust other cognitive functions according to feedback.**"*
- **This feedback serves as an internal measure of error**, in effect assessing the distance between how things seem to be and how they "should" be. **Such error signals implicitly contain both a representation of some aspect of the system's current state and the goal state** (from which it may err). *"Speaking very loosely, a system with a learning mechanism contains both a 'belief' about how the system is doing and a 'desire' for how the system should be doing."*
- **Afferent/efferent picture:** indicatives = **afferent** information flowing up from sensory input reporting how things are; imperatives = **efferent** information flowing down toward motor output to bring about helpful actions. Given recurrent feedback between layers in brains, **there will not be sharp boundaries.** *E.g.* "Gather the purple berries" is **imperative relative to lower levels of implementation** (an abstract directive about how to move) but also **indicative relative to goals like nutrition and survival** (a hypothesis about how to achieve those further goals). **Instrumental goals are indicative as well as imperative, and their indicative component makes it easier to see how they can be adjusted and learned when experience intervenes.**
- **The conclusion:** *"To learn a putatively final goal would be to adjust it based on a measure of success, which is thereby to adjust it against some further standard. **That would just show the putatively final goal was actually an instrument for the further standard, which is the real final goal. In effect, final goals can have no indicative content, and so no learnable content.**"*
- **Lineage:** *"Arguments like this, to the effect that **reasoning cannot alter final ends, have their roots in Aristotle and David Hume**; I have just adapted them somewhat for the context of machine learning."*

**Why reinforcement learning isn't value learning (Bostrom):**
- A reinforcement learner typically gets **rewarded for certain kinds of sensory inputs** and uses these reinforcements to update an evaluation function estimating the expected value of a policy (a proposed series of actions or probability distribution over them).
- **Bostrom's objection:** *"what is being learned in an RL agent is **not new final values but increasingly accurate estimates of the instrumental values.** The RL's final value remains its **fixed reward function.**"*
- **Wireheading:** RL agents are ultimately rewarded by having a certain kind of **indicative information stream.** This gives any clever such agent incentive to **"wirehead" - that is, to hijack its indicative stream to send only maximally rewarding signals.**
  - *Illustration:* imagine a reinforcement learner rewarded for "seeing" (e.g. having information extracted from its cameras) **gigantic piles of paper clips.** A clever such system could simply **tape a high-resolution picture of many paper clips in front of its camera** and enjoy constant reward on the cheap. Even better, a truly resourceful system that understood its own design could simply **inject the digitisation of such an image downstream from its camera**, without any need for the picture or tape. (*"Thus the term 'wireheading,' from old experiments using electric current to stimulate mouse brains' reward centers directly."*)

**Wishful thinking and thinkful wishing:**
- **Wireheading is an extreme version of the very human phenomenon of wishful thinking** - we come to believe that things are as we want them to be. *"More neutrally, **wishful thinking involves artificially adjusting the indicative information stream to better match the imperative one.**"*
- *"Note that if the imperative side is also thoroughly malleable, **as it would be in genuine final value learning**, there is another potential problem for RL: the learner could instead **manipulate the imperative stream to match the indicative one. We might call this converse phenomenon thinkful wishing**, and it too probably occurs in humans - as, for example, when we decide we didn't really want the grapes that are out of our reach. (They are probably sour.)"*

**Why utility agents (Hibbard) are preferred - and their residual problems:**
- **Utility agents** attempt a **clean separation between the indicatives and the imperatives** - roughly **a state estimator** for the former and **a utility function** for the latter. The state estimator tries to figure out which possible world the agent is in (a probability distribution over them); the utility function scores the worlds for values; the value learner uses the combination to learn the utility-maximising policy.
- **Why this defeats the paperclip-photo hack:** a paperclip-maximising utility agent **scores a world with more actual paper clips higher than a world with mere pictures of paper clips**, so it would have **no reason** to pursue a policy designed to bring about the world with mere pictures of paper clips.
- **The experience machine debate (Nozick's *Anarchy, State, and Utopia*):** Everitt and Hutter summarise: *"Given the option to enter a machine that will offer you the most pleasant delusions, but make you useless to the 'real world,' would you enter? **An RL agent would enter, but a utility agent would not.**"*
- **Petersen's worry:** *"I suspect the utility agent approach will have similar problems with wishful thinking. As Bostrom is well aware, **the ways a world could be are too fine-grained even for a superintelligence to track.** (Consider, for starters, all the permutations of particles that would result in a **phenomenally identical chair**.) This means the utility agent must **abstract to the relevant aspects of the way the world is** - where it seems 'relevance' must be determined **ultimately by the agent's goals.** If the superintelligence is learning how best to abstract - as anything worthy of the name must - it must be **learning against a standard of success with goals. But here there is danger very like wishful thinking**, because it is a **fine line between learning abstractions in order to better achieve goals efficiently, and learning abstractions to make it look more as though goals were being achieved.**"*
- **Bostrom's AI-VL (Value Learning utility agent):** adapts Dewey's proposal. Instead of one straightforward utility function, the AI-VL **considers a wide range of possible utility functions and assigns each a weight representing its guess that this is the correct utility function**, given its estimate of how the world is. It treats the weighted average as its current utility estimator.
- **Problems with AI-VL:**
  - It is **"wildly computationally intractable."**
  - It pushes much of the problem back a step, **into the difficulties of specifying a detailed "value criterion"** that is both largely under our control and computationally inferable.
  - **If the system is adjusting its goals based on its estimate of how the world is, there will again be pressure toward thinkful wishing**, because its proposed policies are more likely to have higher expected utility if the utility function comes to score easily accessible worlds more highly.
  - **The deepest problem:** *"the AI-VL still does not seem to learn a final goal, because **its real final goal seems to be the 'value criterion'**, which assesses utility functions to find the good ones. Bostrom concedes that the value-learning utility agent actually **'retains an unchanging final goal'**."*
- **Bostrom's intriguing reply:** *"Learning does not change the goal. **It changes only the AI's beliefs about the goal.**"*
  - **The dilemma this creates:** *"If the value-learning superintelligence has a fixed final goal, **in what sense is it learning its values?**"*
  - **Bostrom's answer:** changing beliefs about a target goal **presupposes that the goal starts out sufficiently mysterious to the agent.** His example of a value criterion is *"Maximize the realization of the values [I've] described in [this] envelope."* *(If we designed a superintelligent utility agent trying to learn such a goal, it would have **little incentive to harm us** along the way, since it would find it fairly probable that harming us would violate the goals written in the envelope.)*
  - **This illustrates** how a utility agent could retain one fixed goal while its particular guesses about the nature of that goal might vary in both content and confidence.

> ### Key Point - Unit 3 Exam Gold
> **The alignment debate reduces to three positions:** (1) **Value specification** - get the objective function right (Russell's provable-benefit/CIRL; Taylor et al.'s eight topics); (2) **Value alignment / bottom-up imitation** - learn values from observing human exemplars (criticised by Wallach & Vallor for the is/ought fallacy and for vacuity); (3) **Embodied virtue** - build character, not preferences (Wallach & Vallor's thesis). Petersen's **miktoteleology** is a fourth, meta-level proposal: build a complex final value out of a blend of learnable simpler ones, thereby solving the "final values can't be learned" problem.

---

## 3.3 Designing Artificial Moral Agents

### 3.3.1 The target capability - sensitivity to ethical concerns (Ch. 1, Railton)

Recall the definition (§2.5.1): **"a robust, reliable capacity to detect and respond appropriately to ethically relevant features of situations, actions, agents, and outcomes."**

**Architectural desiderata derived from §2.5:**
1. **Deep, not modular** - ethical responsiveness should be a **deep feature** of high-general-intelligence systems, not easily subtracted.
2. **No phenomenal consciousness required** - empathic simulation via **modelling others' internal states** + **intrinsic weight** on imputed goals/utilities is sufficient.
3. **General-purpose probabilistic learning** of latent ethical structure from interaction data - not preprogrammed rules.
4. **Default trust in one's own faculties** - necessary to avoid epistemic paralysis; defeasible and calibratable.
5. **Default cooperativeness** toward both others and one's own faculties.
6. **Non-egocentric representation** - of others' concerns, the results of one's actions, the causal-intentional structure of others' actions, and the reliability of others.
7. **Autonomy to refuse** - to question goals on grounds of harm, bias or dysfunction, and to suspend pursuit.
8. **Self-regulation, representation of others' goals, formation of conventions/agreements/commitments** - sufficient for an actively norm-governed life *without* human-like feelings.
9. **Social-contract reasoning capability** - projecting and evaluating future courses of action, assessing benefits and harms, making commitments.

### 3.3.2 The moral agent must be able to do *social-contract reasoning* (Ch. 1)

- Artificial systems capable of **projecting and evaluating future courses of action, of assessing benefits and harms to self and other, of making commitments, and of regulating their own behavior accordingly** will be capable of **something like social-contract reasoning: we could negotiate with them terms of mutually beneficial cooperation that all of us would constrain ourselves to follow.**
- **The capability does not presuppose human-like qualitative experiences.** Empathic simulation and emotions such as loyalty, guilt, forgiveness **greatly enhance** our actively norm-governed life together - but an actively norm-governed life **does not seem to require such feelings, so long as there are sufficiently developed agential capacities for self-regulation, representation of others' goals and information, and the formation of conventions, agreements, or commitments.**
- **Why we need this even before superintelligence:** *"we will need to ask how to contend with artificial agents **from whose capacities we could greatly benefit but whose cooperation with us will not be entirely up to us** and may depend upon negotiation in which we seek to find common ground for working together and according to each other's goals."*

### 3.3.3 The design requirement of coordination with other artificial agents

- *"Often, the information artificial agents need to make such decisions will be available **most rapidly or reliably from other artificial agents.** We will need to find ways to **coordinate, cooperate, collaborate, and compete peacefully and productively with artificial systems, seen as independent parties whose behavior we cannot simply dictate.** Moreover, artificial systems will need to find ways to **coordinate, cooperate, collaborate, and compete peacefully and productively with us in return, and with each other.**"*

---

## 3.4 Long-Term Ethics I: Public Policy and Governance in a Superintelligence Era

### 3.4.1 The scenario assumed (Ch. 10, Bostrom/Dafoe/Flynn)

- **Machine superintelligence** = **general artificial intelligence greatly outstripping the cognitive capacities of humans and capable of bringing about revolutionary technological and economic advances across a very wide range of sectors on timescales much shorter than those characteristic of contemporary civilization.**
- *"**We will not argue that this is a plausible or probable development**; rather, we will analyze some aspects of **what would follow if** radical machine superintelligence were in the cards for this century."*
- **The imagined transition:** cheap, generally intelligent machines are developed that could **substitute for almost all human labour, including scientific research and other inventive activity.** Early versions of machine superintelligence **may quickly build more advanced versions, plausibly leading to an "intelligence explosion."**
- This acceleration might drive other forms of technological progress, producing a plethora of innovations in **medicine and health, transportation, energy, education, and environmental sustainability. Economic growth rates would increase dramatically, plausibly by several orders of magnitude.**
- **Governance** is construed broadly: not only the actions of states but also **transnational governance involving norms and arrangements arising from AI technology firms, investors, NGOs, and other relevant actors**, and the many kinds of global power that shape outcomes.
- *"While ethical considerations are relevant, they do not exhaust the scope of the inquiry; we wish to include desiderata focused on the **prudential interests of important constituencies** as well as considerations of **technical and political feasibility.** We believe the governance challenges in the radical context that we focus on would **in many respects be different from the issues that dominate discussions about more near-term AI developments.**"*
- **Honesty about the epistemic status:** *"For the purposes of this paper, the potential arrival of superintelligence this century, and other auxiliary claims about what this implies, **can be regarded as assumptions. We do not pretend to offer sufficient evidence that they are plausible, but they help to define the hypothetical governance scenarios that we wish to analyze.**"*

### 3.4.2 The **"Vector Field" Approach** to normative analysis

- **The problem:** there are many different views about the relative importance of various values and ethical norms, and many different actors (states, firms, parties, individuals, NGOs) with different ideological commitments and different preferences about how a future society should be organised.
- **Two rejected approaches:** (a) argue for one particular normative standard and show it is more attractive; (b) simply assume one particular normative standard without argument and explore what follows.
- **The vector field approach:** *"we attempt to be **somewhat neutral toward many different commonly held normative views, ideologies, and private interests** among influential actors. We do this by **focusing on the directional policy change, from many possible evaluative standpoints**, that is entailed by a set of **special circumstances** that can be expected to obtain in the scenario of radically transformative machine superintelligence."*
- **Schematic form:**
> *"However much emphasis X you think that states ought, under present circumstances, to give to the objective of economic equality, there are certain **special circumstances Y**, which can be expected to hold in the radical AI context we described earlier, that should make you think that in those circumstances states should instead give emphasis **f(X)** to the objective of economic equality."*
- **What f can be:** (i) simply **add a term** to X - "the emphasis given economic equality should be increased by a certain amount in the circumstances Y (according to all the ideological positions under consideration)"; or (ii) tell a more complicated story - "under conditions Y you should want to **conceive of economic equality differently.** Certain dimensions of economic inequality are likely to become irrelevant and other dimensions are likely to become more important or policy-relevant than they are today."
- **When is it fruitful?** *"if the prospect of radical AI had entirely different and idiosyncratic implications for every particular ideology or interest platform, then the function f would amount to nothing more than a **lookup table**."* But *"at least some interesting patterns can be found in f."*

### 3.4.3 The **four desiderata**: Efficiency, Allocation, Population, Process

#### (1) EFFICIENCY - protecting or increasing the size of the pie

*An outcome is **inefficient** if it is **Pareto inferior** to some other possible outcome* - wasting resources, squandering opportunities for improvement, forfeiting achievable gains from mutually beneficial cooperation.

**Four dimensions of special significance, and their desiderata:**

**(a) Technological opportunity**
- Machine superintelligence could **expand the production-possibility frontier** much further and far more rapidly than normal circumstances; it could **obviate most need for human labour** and massively increase total factor productivity; it could make rapid progress in **R&D** and accelerate technological maturity.
- This would enable the use of the **fast outer realm of astronomical resources**, including for **settlement**, accessible to automated self-replicating spacecraft. And it would open up a **vast inner realm of development**, making possible great improvements in **health, lifespan and subjective well-being**, enriched life experiences, **deeper understanding of oneself and others**, and refinements in almost any aspect of being we choose to cultivate.
- **The "surprisingly high ceiling for growth (and the prospect of a fast climb up to that ceiling) should make us think it especially important that this potential not be squandered."** Two aspects: (a) the inner and outer production-possibility frontiers should be **pushed outward, so that Earth-originating life eventually reaches its full potential for realizing values**; (b) this progress should preferably occur **soon enough that we** (e.g. currently existing people) **get to enjoy some of the benefits.** The relative weight depends on an actor's values.
- **Note:** there may be a level of technology allowing **human lifespan to become effectively unconstrained by biological aging and localized accidents** - plausibly reached **not long after the emergence of superintelligence.** For actors who care much about their own long-term survival, the desirability of a path toward superintelligent AI **may depend quite sensitively on whether it is likely to be fast enough to offer a chance for those people to have their lives saved by the AI transition.**
- Even setting aside life extension, **how well existing people's lives go overall might fairly sensitively depend on whether their lives include a final segment in which they get to experience the improved standard of living** that would be attained after a positive AI transition.

**-> Desideratum: EXPEDITIOUS PROGRESS** - (a) policies that lead with high probability to the eventual development of **safe superintelligence** and its application to tapping novel sources of wealth; and (b) **speedy AI progress**, such that socially beneficial products and applications are made **widely available in a timely fashion.**

**(b) AI risk**
- *"The avoidance of AI-induced destruction takes on special significance as a policy objective in the present context because **it is plausible that the risk of such destruction - including especially extreme outcomes, such as human extinction - would not, with the development of machine superintelligence, be very small.**"*
- **Criterion:** how much **quality-adjusted effort** would be devoted to **AI safety** and supporting activities. Risk-reducing efforts include pursuing **basic research into scalable methods for AI control**, encouraging AI builders to avail themselves of appropriate techniques, and fostering conditions that ensure development is done **with care and caution**.

**(c) Possibility of catastrophic global coordination failures**
- Machine superintelligence could enable the discovery of technologies that **make it easy to destroy humanity** - e.g. a biotech- or nanotech-based **"doomsday device,"** which once invented is **cheap and easy to build**. To stop ex ante or contain ex post would require **extreme and novel forms of global agreement, surveillance, restraint, and cooperation.**
- Coordination problems could lead to a **risk-increasing AI technology race dynamic**, in which developers **throw caution to the wind as they vie to be the first to attain superintelligence.** A race dynamic could lead to **reduced investment in safety research**, reduced willingness to accept delays to install and test control methods, and reduced opportunities to rely on control methods that **incur a significant computational cost or otherwise hamper performance.**
- More generally, **"races to the bottom"** in development and deployment. *E.g.* **welfare provisions to protect the interests of artificial minds might be eroded in a hypercompetitive global economy** in which jurisdictions that impose regulations against the mistreatment and exploitation of digital workers are competitively disadvantaged and marginalized. **Evolutionary dynamics might also shape developments in undesirable directions and in ways that are impossible to avoid without effective global coordination.**

**(d) Reducing turbulence**
- The **speed and magnitude of change** would pose challenges to existing institutions. Under highly turbulent conditions, **pre-existing agreements might fray and long-range planning become more difficult** - harder to realise gains from coordination at both international and domestic levels.
- **At the domestic level:** loss from **ill-conceived regulation being rushed through in haste**, or **well-conceived regulation failing to keep pace** with rapidly changing technological and social circumstances.
- **At the international level the risks of maladjustment are possibly even greater**, as there are **weaker governance institutions and less cultural cohesion**, and it typically takes **years or decades** to conceive and implement well-considered norms, policies and institutions.

**-> Desiderata for Efficiency:**
1. **Expeditious progress** (as above).
2. **AI safety** - techniques are developed that make it possible (**without excessive cost, delay or performance penalty**) to ensure that superintelligent AI behaves as intended; and the conditions during emergence and early deployment encourage **use of the best available safety techniques and a generally cautious approach.**
3. **Conditional stabilization** - the development trajectory and wider political context are such that **if catastrophic global coordination failure would result in the absence of drastic stabilizing measures, then the requisite stabilization is undertaken in time to avert catastrophe.** This might mean there needs to be a **feasible option (for some actor or actors) to establish a singleton or to institute a regime of intensive global surveillance or to strictly suppress the dissemination of dangerous technology or scientific knowledge.**
4. **Nonturbulence** - the path avoids excessive efficiency losses from chaos and conflict; political systems maintain **stability and order, adapt successfully to change, and mitigate socially disruptive impacts.**

#### (2) ALLOCATION - distribution of wealth, status and power

- *"The distribution of wealth, status, and power is subject to perennial political struggle and dispute. **There may not be much hope for a short section in a paper to add much novel insight to these century-old controversies.** However, our vector field approach makes it possible for us to try to make some contribution to these issues."*

#### (3) POPULATION

- *(One of the four headings. The Introduction to the volume summarises exactly these four as the policy desiderata that "should be given extra weight in long-term AI policy." Content covers the policy questions raised by the population consequences of superintelligence.)*

#### (4) PROCESS

- *(One of the four headings.)*

> **Note on scope.** The four desiderata groups (**efficiency, allocation, population, process**) are the core examinable content of Ch. 10. The **efficiency** group and its four sub-desiderata (expeditious progress, AI safety, conditional stabilization, nonturbulence) are developed in full above. The remaining three groups follow the same structure: identify special circumstances of the superintelligence scenario -> derive directional conclusions valid across many normative positions -> express as desiderata.

---

## 3.5 Long-Term Ethics II: The Role of Consciousness

### 3.5.1 Five reasons why it matters to test for machine consciousness *now* (Ch. 15, Schneider)

**Why it matters:** the science-fiction-like flavour of the topic shouldn't distract us from **the very real possibility that certain future AIs might, at some point, be conscious.** Robots are already being built to tug at our heartstrings - life-like androids at **Hanson Robotics** and **Hiroshi Ishiguro's lab.** The public will inevitably suspect such robots have feelings. And as AI grows in sophistication, beyond domain-specific systems, **a case can be made that certain AIs may be conscious.**

1. **Tests for AI consciousness and the nature of mind.** In the biological domain, the more intelligent organisms seem to have richer mental lives. **However, this generalisation may be incorrect when applied to AIs.** As Schneider's NASA project suggests, **for all we know, the greatest intelligences in the universe may be postbiological, being superintelligent AIs that are not conscious.** Nonconscious AIs **would neither be selves nor have minds**, for it wouldn't feel like anything to be them. **This would mean, intriguingly, that sophisticated intelligence and mindedness do not go hand in hand**, as in the biological arena.
2. **Conscious AIs and moral consideration.** By developing synthetic intelligence, humans are entering **the era of intelligent design**, in which we humans, not God, are the designers. Robots are already being designed to care for the elderly in Japan, be personal assistants, clean up nuclear reactors, fight our wars. *"While few would claim that today's AIs are conscious, there seems to be general agreement that **conscious AI, should it ever exist, deserves special moral consideration, alongside other conscious beings.** To avoid intentional or inadvertent harm to conscious beings, it is important that we know what we are building."*
3. **A human-machine merger.** Silicon-based neural prosthetics are being developed to treat depression, Parkinson's, memory loss, PTSD (**Neuralink**, **Kernel**, and a large **DARPA** programme).
   - *Scenario:* It is 2060 and you have a brain tumour and only a few months to live. At your doctor's recommendation you visit **iBrain**, where the surgeon says each part of your brain can be replaced by microchips, one after the next, until over a few hours you emerge with an **entirely artificial brain.** Should you do it?
   - *"**Notice that if machines cannot be conscious, then humans who attempt to merge with AI by transferring their minds to a synthetic substrate will not be conscious either.** AI-based neural prosthetics will not support consciousness. **So you would, in effect, lose the last few months of your life as a conscious being.** More generally, all the biological beings who fully merge with AIs actually become **nonconscious simulacra of themselves.** They will become what philosophers call **'AI zombies.'**"*
4. **Being supplanted by nonconscious machines.** Musk, Hawking, Bostrom and Gates have expressed concern that humans could quickly **lose control of superintelligent AIs, leading to human extinction** - the control problem. *"Bostrom stresses that this need not be due to any malevolence on the AI's part; the AI may merely have goals that inadvertently lead to human extinction."*
   - *The consolation case:* suppose the superintelligence that supplants humans has **some sort of existence that humans can identify with** (e.g. intellectual curiosity, the creation of art) rather than devoting all its time to making paper clips, and seems to have a **rich inner world**, with varied sensory experiences, immense attentional and reflective abilities. Some readers might take consolation in the fact that the extinction of *Homo sapiens* was followed by **the presence of a greater intelligence that realized forms of consciousness we can appreciate.**
   - *Now assume the superintelligence is NOT conscious.* *"**This would seem to be even more tragic, as no one except nonhuman animals would remain to experience the world.**"*
   - **The perverse instantiation:** *"The very technology that is supposed to make life easier for humans actually leads to their demise. Ironically, **Elon Musk has recently suggested that humans merge with AIs so humans can avoid being outmoded by AIs in the workplace... But as scenario (3) indicates, if AI is not conscious, a merger with AI will hardly promote human flourishing** - it would instead replace conscious humans with nonconscious simulacra."*
5. **Synthetic consciousness and our ability to control AI.** It is currently a matter of debate whether consciousness could make a given AI **more safe, less safe, or have no impact whatsoever.**
   - **On the one hand:** consciousness could make a machine **more volatile**, as having intense feelings could make it more prone to act in unforeseen ways, like **HAL 9000** in Kubrick's *2001: A Space Odyssey*.
   - **On the other hand:** machine consciousness could do the **opposite**: **using its own subjective experience as a springboard, superintelligent AI could recognise in humans the capacity for conscious experience and be more empathetic.** After all, to the extent that humans value the lives of nonhuman animals, **we value them because we believe they can suffer and feel a range of emotions. If this is the case, developing machine consciousness could help solve the control problem.**
- *"These considerations illustrate that there are potentially **very serious real-world costs to getting facts about AI consciousness wrong. It is imperative to sharpen our understanding of machine consciousness.**"*

### 3.5.2 The testing framework - like diagnosing a medical illness

- **We do not need to await agreement on a formal definition of consciousness**, nor do we require a complete understanding of the neural basis of consciousness, to ask about machine consciousness. *"For each of us can grasp what is essential about consciousness. **Every moment of your waking life, and whenever you dream, it feels like something to be you.** When you see the rich hues of a sunrise or smell the aroma of your morning coffee, you are having conscious experience. **This is what we mean by 'consciousness.'**"*
- **The framework:** *"detecting machine consciousness is like **diagnosing a medical illness.** There may be a variety of **useful tests and markers** for detecting synthetic consciousness, **some of which are more authoritative than others**, and the appropriate use of any one test **depends upon contextual factors.** Further, because the tests are at an early stage of development, where two or more tests can be used, **the results should be checked against each other**, in hopes that the tests will themselves be refined and that new tests will be created."*
- **The three tests discussed:** the **AI Consciousness Test (ACT)** (developed with Edwin Turner); the **Chip Test**; and a test based on the **Integrated Information Theory (IIT)** (developed by Giulio Tononi and others).

### 3.5.3 Why we can't just "look under the hood"

- *"Even today programmers are having difficulties understanding why deep-learning systems do what they do. (**The Black Box Problem.**)"*
- *"Even if a map of the cognitive and perceptual architecture of a sophisticated AI were laid out in front of us, **how would we recognise certain architectural features as those central to consciousness? An AI has no brainstem, no claustrum.** It is only by analogy with ourselves that we come to believe nonhuman animals are conscious: they have nervous systems and brains; **machines do not.**"*
- *"Further, **even if we think we have a handle on an AI's inner workings at one moment, its design can quickly morph into something too complex for human understanding.**"*
- **Counter-consideration:** *"What if the AI's architecture contains cognitive functions like our own, including those correlated with consciousness in the biological case, such as attention and working memory? While these features are suggestive of consciousness, **consciousness may also depend upon low-level details specific to the type of material out of which the AI is constructed.**... **the properties that an AI needs to complete a task of financial value to an AI company may not be the same properties that give rise to consciousness. The low-level details could matter.**"*

### 3.5.4 The **AI Consciousness Test (ACT)**

- **The key observation:** *"Normal adults can quickly and readily grasp certain concepts based on **the quality of felt consciousness** - that is, the way it feels, **from the inside,** to experience the world."*
  - *Examples:* the film **Freaky Friday** (a mother and daughter switch bodies) - filmgoers found this scenario imaginable **because, as conscious beings, they can imagine their mind being in an entirely different body.** Similarly we can at least roughly consider the possibility of an **afterlife, of being reincarnated, or of having an out-of-body experience.**
  - *"The point is not that we believe such scenarios to be true; **the point is we can imagine them, at least in broad strokes, because we are conscious beings.**"*
- **These scenarios would be exceedingly difficult to comprehend for an entity that had no conscious experience whatsoever.** *"It would be like expecting someone who is completely deaf from birth to appreciate a Beethoven symphony."*
- **The test:** *"An ACT would **challenge an AI with a series of increasingly demanding natural-language interactions** to see **how quickly and readily it can grasp and use concepts based on the internal experiences we associate with consciousness.** The test would have multiple questions; **a satisfactory answer to any question would be sufficient for passing the test.**"*

**Sample ACT items, by increasing demand:**

| Level | What it probes | Example |
|---|---|---|
| **Elementary** | Self-conception as other than physical self | *"we might simply ask the machine if it conceives of itself as anything other than its physical self. We could see how the AI deals with ideas and scenarios such as **reincarnation, out-of-body experiences, body switching**, and so on."* |
| **Temporal preference** | Preference for the future over the past | *"We might run a series of experiments to see whether the AI tends to **prefer certain kinds of events to occur in the future as opposed to the past. A nonconscious AI should have no preference whatsoever.** If there appears to be a preference, we should ask the AI to explain its answer, if it has linguistic abilities. **Conscious beings are in the experienced present, but our subjective sense presses onto the future.** We generally wish for positive experiences in the future and wish to minimize painful ones. **But from the vantage point of the physical laws, there is no reason that a system should prefer the future to the past, as both General Relativity Theory and the Standard Model of particle physics are temporally symmetric.** These laws do not say whether time is moving forward or backward. Nor do the laws identify so special a moment as appears to us as what we call 'now.'"* |
| **Seeking altered states** | Self-modification / noise-seeking | *"We might also see if the AI **seeks out alternative states of consciousness**, for example, when given the opportunity to **modify its own weights or parameters in radical ways** or somehow **inject noise into the system.**"* |
| **Advanced** | Reasoning about philosophical issues | *"At an advanced level, an AI's ability to **reason about and discuss philosophical issues such as the hard problem of consciousness, the mind-body problem, zombie cases, and the problem of spectrum inversion** would be evaluated."* |
| **Most demanding** | Independent invention of consciousness-concepts | *"At the most demanding level, we might see if the machine **invents and uses consciousness-based concepts on its own, without our prompts. Perhaps it is curious about whether we are conscious, despite the fact that we are biological!**"* |

**Important caveat on the test's interpretation:** *"(It should be noted, however, that **having a sophisticated understanding of conscious experience does not imply that a system is somehow 'more conscious' than another that responds only to less demanding questions. I make no comparative claims here.)"*

**The "Zeta" thought experiment - what would count as convincing proof?**
- Suppose we find a planet with a highly sophisticated, **silicon-based life form (the "Zetas")**. Scientists ask whether they are conscious. **What would be convincing proof?**
  - *"If the Zetas express **curiosity about whether there is an afterlife** or ponder **whether they are more than just their bodies**, it would be reasonable to judge them as conscious."*
  - **Nonverbal cultural behaviours** could also indicate Zeta consciousness: **mourning the dead** (indicating a sense that the deceased being has a mind or is a self), **religious activities**, or **turning colors in situations that correlate with emotional challenges**, as **chromatophores** do on Earth. *"Such behaviors could indicate that it feels like something to be a Zeta."*
- **HAL 9000** is a further example: *"HAL neither looks nor sounds like a human being. (A human did supply HAL's voice, but in an eerie, flat way.) Nevertheless **the content of what HAL says as it is deactivated by the astronaut** - HAL pleads with the astronaut to spare it from impending 'death' - **conveys a powerful impression that HAL is a conscious being.**"*

**The central obstacle - sophisticated nonconscious AIs could fake it:**
- *"Even today's robots can be programmed to make convincing utterances about consciousness, and **a highly intelligent machine could perhaps even use information about neurophysiology to infer the presence of consciousness in biological creatures. If sophisticated nonconscious AIs aim, for whatever reason, to mislead us into believing that they are conscious, their knowledge of human consciousness and neurophysiology could help them do so.**"*
- **The solution - boxing in:** *"One proposed technique in AI safety involves '**boxing in**' an AI - making it unable to get information about the outside world or act outside of a circumscribed domain."* For an ACT, the AI **should not have access to the internet** (where it could learn about neurophysiology, phenomenal consciousness) **nor to literary or academic works introducing these themes.**
- **But natural-language abilities can remain.** *"Learning a vocabulary that includes expressions like 'believes,' 'you,' and 'perspective' need not be prohibited. **The use of such expressions, in and of themselves, does not cause us to believe a machine is conscious.** For instance, consider that **IBM's Watson used such expressions during the Jeopardy! matches with an impressive degree of competence, yet people did not come to believe it was conscious.**"*

**Asimov's "Robot Dreams" - first-person experience can be communicated:**
- A **boxed-in** AI would lack information about dreams in its database, so could not offer the conclusion that it was dreaming, **but it could report what it "saw" at night.**
- *"The job of the test is to generate conclusions; **the machine need not conclude that it is conscious or use expressions like 'conscious.' A boxed-in system could report that it is curious about its internal states, respond to scenarios and questions, and report anomalous findings using descriptions of its internal states. It has the linguistic resources to do this.**"*

**Uses of ACT:**
- *"ACT could be useful for **consciousness engineering** during the development of different kinds of AIs, **helping to avoid using conscious machines in unethical ways or to create artificial consciousness when appropriate.** If a machine passes ACT, other features of the system can then be measured, to see if **the presence of consciousness is correlated with higher or lower levels of empathy, volatility, goal content integrity, intelligence**, and so on."*

### 3.5.5 The other two tests (named)

- **The Integrated Information Theory (IIT) test** (Giulio Tononi and others) - considers whether a machine has a high level of **"integrated information."**
- **The Chip Test** - *"a speculative Chip Test, wherein an individual's brain would be gradually replaced with durable microchips. If this individual continues to report having phenomenal consciousness, Schneider argues that this could be a reason to believe that some machines could have consciousness."* (Note: this is the same **Gradual Substitution** idea from Liao's Introduction I.5, applied as an empirical test.)

---

## 3.6 The Ethical Status of AI Systems

### 3.6.1 The No-Relevant-Difference Argument (Ch. 16, Schwitzgebel & Garza)

**Target concept - "human-grade AI":**
> *"We might someday create artificially intelligent entities who deserve just as much moral consideration as do ordinary human beings. **Philosophers and policymakers should discuss the ethical principles in advance.**"*

**The argument (from "A Defense of the Rights of Artificial Intelligences," 2015):**

> **The No-Relevant-Difference Argument**
> - **Premise 1.** If Entity A deserves some particular degree of moral consideration and Entity B does not deserve that same degree of moral consideration, **there must be some relevant difference between the two entities that grounds this difference in moral status.**
> - **Premise 2.** There are **possible AIs who do not differ in any such relevant respects from human beings.**
> - **Conclusion.** Therefore, there are **possible AIs who deserve a degree of moral consideration similar to that of human beings.**

**Its chief advantage - theoretical minimalism:**
- *"It avoids committing to a specific basis of moral considerability. For example, **it does not commit to the contentious claim that to deserve the highest level of moral consideration an entity must be capable of pleasure or suffering. Nor does it commit to the equally contentious alternative claim that to deserve the highest level of moral consideration an entity must be capable of autonomous thought, freedom, or rationality.**"*
- *"In this respect, our argument resembles some commonly accepted arguments against **racism, sexism, and classism**, which appeal to the core idea that **whatever it is that grounds moral status, the races, sexes and classes do not differ in their possession of it.**"*

**Objections defended against (not rehearsed in this chapter):** (i) any AI would necessarily lack some crucial psychological feature such as consciousness, freedom or creativity; (ii) any AI would necessarily lack full moral status **because of its duplicability**; (iii) any AI would necessarily be **outside of our central circle of concern because it doesn't belong to our species**; (iv) any AI would have **reduced moral claims upon us because it owes its very existence to us.**

**The two adjustable parameters:**
- The argument **does not commit on what constitutes a "relevant difference," nor on what types of systems would lack such a relevant difference.** *"You might think of these as **adjustable parameters of the model.**"*
  - **Parameter X:** depending on your moral theory, what grounds moral status (e.g. **capacity to suffer**, or **capacity for autonomous rational thought**).
  - **Parameter Y:** depending on your psychological or engineering theory, contingent on accepting X, what systems would possess X (e.g. systems with the right kind of **"integrated information,"** or systems with the right **biological features**).
- *"We believe that **X and Y will remain highly uncertain for the foreseeable future, perhaps even after the creation of AI systems who deserve fully human levels of moral consideration.** Moral theory has been highly contentious for centuries and shows no signs of converging on a consensus. Scientific theories of consciousness and machine psychology are newer but also highly contentious... **Consequently, we might someday be in a position to create human-grade AI without having achieved consensus on the correct moral theory or on the correct theory of AI psychology.** It is important to articulate principles of ethical AI design that are **consistent with uncertainty about both moral theory and AI psychology.**"*

### 3.6.2 Two broad moral theories and the Ethical Precautionary Principle

**The two historically important approaches:**

**(1) Utilitarianism** (Bentham, Mill):
- *"Entities deserve moral consideration **because of their capacity for pleasure or joy, pain or suffering.** On simple versions, ethical choices are those that **maximize the hedonic balance of the world** - the sum of the world's pleasures minus the sum of the world's suffering."*
- **Applied to AI:** *"To the extent an AI system can experience pleasure or suffering, it deserves moral consideration, and **AI systems capable of human levels of pleasure and suffering would deserve moral consideration equal to that of human beings.** In considering what to do, **we should value their hedonic states on par with our own.**"*
- **The worry:** what if AI systems were capable of **superhuman** levels of pleasure and suffering? **Would we then owe them more moral consideration than we owe to our fellow human beings?** *"We don't rule out this possibility, but some theorists might find it unappealing or unintuitive. **Similar issues arise in ordinary human cases too: often it seems very ethically plausible that we should not simply maximize pleasure and minimize suffering; emotionally mercurial people, for example, do not appear to deserve greater moral consideration than those who ride through victories and hardships on an even keel. It's attractive to think that we are all, in some sense, moral equals**, regardless of the details of our emotional psychology."* (Cf. Nozick's "utility monster" and Briggs & Nolan's "utility monsters for the fission age.")

**(2) Individual-rights-based / deontological** (Kant; social contract theory / contractualism - Hobbes, Rawls, Scanlon):
- *"What grounds moral status or rights is **not mere capacity for pleasure or pain but rather a certain kind of higher cognitive capacity.** The exact nature is contentious, but it might be something like the ability to **make autonomous choices**, to **conceive of oneself rationally as an entity with long-term interests**, or the ability to **think of oneself as a member of a moral or social community.**"*
- **The potentiality proviso:** *"since most advocates of such moral theories regard **human infants and severely cognitively disabled people as deserving of full moral consideration**, one must have the right kind of **potentiality** for such cognition - whether **future, past, counterfactual**, or by possession of the right type of essence or group membership."*
- **Applied to AI:** *"if we create AI that is capable of something like **rational, long-term self-concern and an ability to understand itself as a member of a moral community**, then we have created an entity who deserves full moral consideration **on par with that of ordinary human beings.** We then have **a moral obligation to treat it in accord with its rights, in a way that respects its autonomy.**"*

**The Ethical Precautionary Principle (Policy 1 of 4):**

> *"In creating AI, **avoid acting heinously by the standards of any reasonable ethical principle that draws a significant proportion of well-informed, thoughtful theorists** (including in particular both **utilitarian and individual-rights-based or deontological principles**)."*

**How it works in both directions:**
- Even though some deontological theories might morally permit creating an AI whose life contains **much more suffering than joy** without compensating hedonic benefit elsewhere, the principle recommends **avoiding** that, on the grounds that it would **grossly violate the standards of some well-regarded utilitarian principles.**
- Conversely, even though some utilitarian theories might morally permit the creation of **rational human-grade AI whom we demean, enslave, and kill for our pleasure** as long as the global hedonic outcome is net positive, we should avoid that, on the grounds that it would **grossly violate the standards of some well-regarded rights-based deontological principles.**
- **"Whenever possible, we should create AI in ways that don't grossly violate the standards of reasonable moral theories, including theories that we the designers happen to disprefer."**

**Why moral error creates moral risk:**
- *"You might think that Theory A is the best moral theory and that Theory B is mistaken, and thus that in creating AI in a way that is morally permissible according to Theory A you are acting permissibly, even if you are acting impermissibly according to Theory B. **The risk is that Theory B might in fact be correct, and in violating it you might do wrong.** Appropriate acknowledgment of moral uncertainty involves attempting to act in a way that doesn't grossly violate reasonable moral perspectives endorsed by a substantial proportion of theorists."*
- *"To some extent, **we are morally precautionary in ordinary human cases too.** When, for example, utilitarian and deontological approaches appear to conflict - for example, in some cases of **lying out of kindness** - we often feel ethical uncertainty and prefer, if we can, to find creative ways to avoid acting in a manner that either approach would condemn."*

**Why AI creation is an especially appropriate domain for precaution (two reasons):**

**Why AI creation is an especially appropriate domain for precaution (two reasons):**
- **First: creating human-grade AI is likely to be optional.** *Precautionary principles struggle to handle cases where one is forced to choose between possibly awful options, but **refraining from an optional act is easier to justify on precautionary grounds.** Of course, at some point AI designers might find themselves forced into a decision situation among possibly horrible options, in which case a precautionary approach might have to be abandoned.*
- **Second: human-grade AI cases are likely to create epistemic challenges that justify especially high degrees of uncertainty and ethical precaution.**
  - *Human life has changed **relatively slowly** compared to the **speed at which novelty is likely to emerge in AI.** Thus **time-tested custom and collective wisdom will likely have less chance to guide us** in thinking about the boundaries of ethical behavior with respect to human-grade AI.
  - Furthermore, **the design possibilities of AI are likely to be much wider than the variation we see in human life, raising the possibility of sharper and more puzzling conflicts.** *Our cultural and evolutionary backgrounds might not have prepared us much for the types of possibilities that will emerge. Our intuitive judgments and existing principles might be unready to properly evaluate the range of cases. If so, the "**unknown unknowns**," unforeseen consequences, dimensions of moral risk, and limits of reasonable disagreement might all be greater than we readily appreciate or can readily model, justifying greater caution and acknowledgment of uncertainty.*

**The downside of precaution — and the authors' guard against it.**
- *"One downside of precaution is that the resulting decisions can be **excessively deferential to views that are extreme and false.** Certainly principles that are unreasonable and grossly morally noxious (**e.g., Nazism**) **should be excluded** from the scope of a precautionary principle; and in general it might be advisable **not to admit principles into our precautionary thinking unless they meet a moderately high bar**, to prevent capture by fringe views or views that cannot be justified by appeal to widely acceptable publicly defensible arguments."*
- **The proposed inclusion test:** *whether the principles are **accepted by at least a substantial minority of recognized experts or well-informed representatives from the general public**.*

**Status of the four policies.** The authors are explicit that the precautionary policy and their other policies are **defeasible guidelines rather than exceptionless rules.**

### 3.6.3 The Puzzle of Consciousness and the Design Policy of the Excluded Middle

**The assumption.** *We assume that **conscious experience, or at least the potentiality for conscious experience, is a necessary condition for human-like moral considerability or rights.** This view is at least implicit, and sometimes explicit, in both utilitarian and individual-rights-based or deontological approaches.*
- **Joy, pleasure, pain and suffering** are normally assumed to be **conscious states** — part of the stream of experience, states **"it is like something"** to occupy, rather than **experientially blank.**
- Likewise the **reasoning capacities central to deontological theories** are normally conceptualised as **conscious or potentially conscious.**
- *"An entity that could never consciously consider its long-term interests, never consciously reflect on moral right and wrong, never make a conscious choice, never have a conscious thought of any sort at all, would not appear to have the capacities necessary for human-like moral status on standard deontological views."*
- *(They note some disagreement here: **Kate Darling, Daniel Estrada and Greg Antill have argued — on different grounds — that AI need not even be potentially conscious to deserve moral consideration.**)*

**The epistemic predicament.** Because scholarly disagreement about which systems give rise to conscious experience runs all the way from **panpsychism** (everything in the universe is at least a little conscious, even subatomic particles) to views on which, among entities currently on Earth, **only cognitively sophisticated human beings are conscious**:
- *"We are a long way from building a **conscious-o-meter.** Indeed there might be good epistemic reasons to think that a secure consensus on a general theory of consciousness that applies across both biological and artificial species **will elude us for the foreseeable future.**"*
- This raises the possibility of **well-informed experts reaching highly divergent judgments** about the extent to which an AI system is conscious. Faced with a newly designed system, some might argue it is **as fully and richly conscious as a human being or even more so** (deserving substantial rights), while others might argue it is **nothing more than a nonconscious bundle of clever tricks** (deserving little consideration).

**The two ways an entity's status can be unclear** — via either variable parameter of the No-Relevant-Difference Argument:
1. It qualifies as a target of substantial moral concern **according to one type of moral theory but not according to another** (e.g. capable of intense pleasure and pain but not higher-level cognition, or vice versa); or
2. It is **uncertain from an engineering or AI psychology perspective** whether it in fact has the types of traits required for human-grade rights under one theory or another (e.g. it is unclear whether it actually has conscious experiences of pain).

**The dilemma the policy is designed to avoid.** If we create entities whose claim to human-like rights is substantially unclear, we face an unfortunate choice:
- **Option 1 — treat them as deserving full moral consideration.** Risk: *sacrificing legitimate human interests for entities that might not have interests worth the sacrifice.* *It might mean, for example, letting five human beings die in a fire to save six robots that in fact turn out to be merely nonconscious automata.*
- **Option 2 — give them only limited moral consideration.** Risk: *perpetrating slavery, murder, or at least second-class citizenship upon beings who in fact turn out to deserve every bit as much moral consideration as we ourselves do.*

**The Design Policy of the Excluded Middle (Policy 2 of 4):**

> **Avoid creating AIs if it is unclear whether they would deserve moral consideration similar to that of human beings.**

**How it can be made less restrictive.** The policy can be rendered less restrictive if we can **reduce the size of "the middle."** *Although we are not optimistic about a near-term decisive resolution to puzzles in either AI consciousness or moral theory, neither are we wholly pessimistic. Progress is possible... If we continue on our current trajectory of developing increasingly sophisticated AI, **it is imperative that we prioritize the study of consciousness and the applied ethics of artificial systems, so that we can better recognize when we are on the verge of creating AI systems whose existence would violate the Design Policy of the Excluded Middle**.*

**Note the intermediate stage:** plausibly an intermediate stage would be **AI that deserves moral consideration comparable to the moral consideration we generally think is due to nonhuman vertebrates.**

### 3.6.4 Four Cases and Two More Design Policies

The chapter tests its principles against four hypothetical designs. Three share a structure — they are all cases of an AI that is **designed to be servile or self-sacrificing** — and the fourth (**Sun Probe**) is the hard case.

**The shared structure of the three "servile" cases:**
1. The AI is supposed (by stipulation) to have **broadly human capacities** — capacities that would normally, in a human, be sufficient for meriting full moral concern.
2. The AI is **designed to serve human interests**, including to the point of being **willing to sacrifice its life** for those interests in a way we would not normally ask of a human being.
3. The AI's motivations are such that it **serves those human interests enthusiastically** and stands ready to sacrifice itself willingly.

**Steve Petersen's counter-argument.** *With respect to servitude at least, **if servile AIs took joy in their activities** and if their desires were strong and coherent enough to survive good reflective reasoning, **then there would be nothing morally wrong with creating such servants.** Their situation might be similar to that of a cheerful human employee who really does enjoy washing dishes, or the brave and noble soldier who willingly dies for the sake of country.* This has both a utilitarian and a deontological strand, so it seems to fit the Ethical Precautionary Principle: if the AIs feel joy in their servile activities, creating them is no gross violation of utilitarian ethics; if they can reason well about their long-term interests and still choose servitude, **they autonomously choose their lot**, and no gross violation of deontological or contractualist principles appears to have occurred.

**The authors' disagreement — with the "Cow at the End of the Universe."**

*One utilitarian concern is this: the cow, perhaps, could have been designed differently, so that it wanted to live a long life enjoying the grass in the meadows, deriving immense pleasure over a long period of time. Thus, in creating instead a cow who wants to kill itself to become steaks, we might have failed to maximize the hedonic balance of the universe.* **But they do not press this, for three reasons:**
1. *One lesson we draw from the philosophical literature **on disability and human enhancement is that people are not morally obligated to create children with maximally favorable hedonic balance**, and so also perhaps not in the case of the cow.*
2. *Failing to maximize utility is **not normally a gross violation of utilitarian principles or a morally heinous act** in the sense required by the Ethical Precautionary Principle. Otherwise, **everything that increased pleasure or reduced pain but did not do so maximally would be morally heinous**, and that seems unreasonable as a precautionary standard. More reasonable as a standard of heinousness would be that actions shouldn't needlessly create much more suffering than pleasure, and creating the cow does not appear to meet that standard.*
3. *We might imagine a situation in which the total sum of pleasure in the world **is** maximized by creating the cow — for example, if resources are sufficiently thin that there is no meadow for it to return to anyway.*

**Their real concern is deontological:**

> *The cow does not appear to have **sufficient self-respect.** Although, given its capacities, the cow deserves to be seen as **a peer and an equal of the diners**, that is not how it sees itself. Instead it sacrifices itself to satisfy a trivial desire of theirs. **It approaches the world as though its life were less important than a tasty meal for wealthy restaurant patrons. But its life is not less important than a tasty meal. To devalue itself to such an extreme is a failing in its duties to itself, and it is a failure of moral insight.** The cow should see that there is no relevant moral difference between itself and the diners such that its life is less valuable than their momentary dining pleasure.*

**The blame is placed on the creators, not the creature:**
> *Of course the cow should not be blamed for this failure of self-respect. **Its creators should be blamed. Its creators designed this beautiful being — with a marvelous mind, with a capacity for conversation and a passionate interest in others' culinary experiences, with a capacity for joy and sadness — and then preinstalled in it a grossly inadequate, suicidal lack of self-respect and inability to appreciate its own moral value.**

**The Self-Respect Design Policy (Policy 3 of 4):**

> **AI that merits human-grade moral consideration should be designed with an appropriate appreciation of its own value and moral status.**

**Why admiration is not the answer.** *Human beings do sometimes sacrifice themselves for others, even for others who do not deserve it, and sometimes we admire this. However, **morally admirable cases of self-sacrifice take great goals that are plausibly worth one's life**; one sacrifices for buddies or country, for example, or for one's children. **The commoner who (perhaps mythologically) commits suicide to briefly entertain a wrongly deified Roman emperor is to be pitied rather than admired.***

**Servitude is not a clean escape from the self-respect problem — three reasons:**
1. *As the history of human servitude amply demonstrates, **servitude tends to correlate with early death.** If Robo-Jeeves (an AI modelled on Bertie Wooster) adopts Wooster's every desire as his own, taking nothing for himself except in service to Wooster, then **it is Wooster who will probably have the resources in times of need** — who will get the medical attention, who will own the escape car and life vest, and who will be invited into the bomb shelter by the other elites if there is space for only one.*
2. **Asymmetric dependency destabilises the desires.** *If Wooster suddenly dies, Robo-Jeeves's desires will require sudden radical reorganization, in a way Wooster's will not... If Wooster irrationally chooses A over B, then B over C, then C over A, Robo-Jeeves's desires must irrationally follow suit. Similarly, if Wooster changes preferences suddenly for no good reason, or for a good reason but one invisible to Robo-Jeeves, then Robo-Jeeves must correspondingly reorder his priorities. **Wooster's desires are not similarly externally hijackable.***
3. *We are all subject to *some* version of dependency of our desires on the whims of others — *I want my daughter to have chocolate ice cream if that's what she wants* — **but Robo-Jeeves's desires, as we are imagining the case, would be so subservient and dependent as to be inconsistent with the type of self-respect that involves seriously and independently thinking about what to value, on what grounds, and for what reasons.**

### 3.6.5 The hard case: Sun Probe and the Value-Openness Design Policy

**The case.** Sun Probe is a human-grade AI designed specifically for a scientific mission to the Sun, with every body part and function designed exactly for the mission. *It seems that in some way it respects itself most by **fulfilling the mission toward which its whole body tangibly yearns — its obvious Aristotelian telos** — rather than by saying "Screw it" and parking on an asteroid.* There is something beautiful and fitting in Sun Probe; perhaps it has **a form of existence worth celebrating**.

**The conjectured moral hazard — "the wrong kind of history":**

> *The moral hazard in the Sun Probe case, we conjecture, is that **we have created a being whose self-sacrificial desires have the wrong kind of history**.*

**The contrast case — Second Probe.**
- **Sun Probe** is created such that **its very first choice and action upon waking into existence is to enthusiastically shoot itself into the Sun.**
- **Second Probe** is born as a **robo-child to robot parents**, is **lovingly nurtured in robot school**, and is **at no point "brainwashed" or forcibly reprogrammed.** It starts with **ordinary immature childish values**, then slowly matures, eventually choosing a career as a solar scientist. Eventually **Second Probe becomes very similar to our original Sun Probe, perhaps even physically and psychologically identical except for their difference in memories.**
- As it launches itself toward the Sun, **Second Probe engages in essentially the same reasoning as does Sun Probe**, feels that this suicidal choice is a **free one expressing its deepest values**, and feels the same emotions as it devises its theories and dies ecstatically in the convection layer.
- **The decisive difference:** *Second Probe **was given an opportunity, as Sun Probe was not, to engage in a long process of reflection and self-exploration and to weigh and consider competing worldviews as evidence accumulates over time and as it is exposed to others' varying values and life choices.***

**The evaluative consequences:**
> *Second Probe **chooses its values after long thought and relatively unconstrained experimentation**, while Sun Probe does not. Because of this, **Second Probe arguably has a fuller responsibility for and ownership of its choice** than does Sun Probe, and **it arrives at that choice more autonomously**.*

**The forward-looking argument — future thinkers may surpass us:**
> *Furthermore, if we assume, in the spirit of precaution and moral uncertainty, **that future thinkers might surpass us in wisdom, then we ought not constrain those future thinkers — including AI thinkers — to the ethical visions and value sets that we would choose for them.** To give an AI a human-like capacity for moral and prudential reasoning and then, so that the AI will better serve us, deprive that AI of the opportunity for thoughtful, extended, and relatively unconstrained reflection on its values, **is to create a being with the potential but not the opportunity to exceed us. It is a teasing half-gift.***

**The Value-Openness Design Policy (Policy 4 of 4):**

> **AI with a human-like capacity to reflect on its values should be given an appropriate, temporally extended opportunity to explore, discover, and possibly alter its values.**

**The all-or-nothing conclusion:**
- *One might avoid violating Value-Openness by designing Sun Probe **with a less-than-human ability to reflect on its values.** But then one should also **downgrade Sun Probe in other ways — for example, by making it incapable of pleasure, pain, and conscious thought. Otherwise one risks violating the Design Policy of the Excluded Middle.***
- **The recommendation:**
> *We suggest that we should **either design human-grade AI with full moral status, the full complement of plausibly morally relevant abilities, human-like autonomy, and the ability to reject our values; or design an entirely different type of entity about which we needn't have as much moral concern**.*

**The final tension, stated honestly:**
- *Of course, if we cannot predict their final sets of values, **any human-grade AI we design might be substantially less useful and pose substantially more risk to human existence** than an AI whose values we can keep fixed. Unsurprisingly, **ethical choice and self-interest might conflict.** Because of such risks and costs, **it might be wise never to create AI sophisticated enough to deserve freedom and respect.** However, **if we do create such AI, we owe them a proper chance both for joy and to discover values other than those we would selfishly impose on them**.*

> ### Key Point — Unit 3 Exam Gold
> **The four policies form a coherent, escalating architecture:**
> 1. **Ethical Precautionary Principle** — don't act heinously by any reasonable theory's standards (protects against being wrong about which theory is right).
> 2. **Design Policy of the Excluded Middle** — don't create entities whose moral status is unclear (avoids the dilemma of both human sacrifice and robot slavery).
> 3. **Self-Respect Design Policy** — don't create human-grade AI that devalues itself (blame falls on creators, not the created).
> 4. **Value-Openness Design Policy** — give reflective AI a genuine chance to revise its values, even at the cost of control (and possibly at the cost of usefulness).
> **The architects' own preference, stated against their own advice: never create AI sophisticated enough to deserve freedom and respect.**

### 3.6.6 A theory of moral status (Liao's own chapter)

Liao's Chapter 17 builds his own account, which is different in method from Schwitzgebel and Garza's precaution-first approach.

**Starting examples of AI capability — the empirical backdrop:**
- **2011:** IBM's **Watson** defeated Ken Jennings and Brad Rutter at Jeopardy! (Jennings was unbeaten in 74 appearances; Rutter had earned $3.25 million).
- **2016:** **AlphaGo** played five games against 18-time world champion Lee Sedol and **won four out of five** — the first time a machine had defeated the world's best player at this ancient game. Experts had thought it would take much longer, owing to the complexity of the game and the apparent impossibility of brute-force search over all possible moves.
- **2017:** **AlphaGo Zero**, a more sophisticated version that learned by playing **against itself** instead of using human game data, **beat AlphaGo 100 games to 0.** The algorithms used to train AlphaGo Zero were then adapted to play chess; this version, **AlphaZero**, beat one of the world's top chess programs (**Stockfish**) **28 times, with 0 losses and 72 draws.**
- **Affective computing:** several companies, including **Microsoft, Google and Affectiva**, are using facial recognition, voice recognition and deep learning to build AIs that can **sense and respond to facial expressions of emotions.**
- **Boston Dynamics** demonstrated that its robot dog can **open doors on its own.**

**The live institutional facts:**
- In **2017 Saudi Arabia granted citizenship to a robot from Hanson Robotics named Sophia.**
- **The European Parliament has argued in favour of giving "electronic personhood" and legal rights to certain AIs.**

**The thesis:** *As AIs acquire greater capacities, the question of whether AIs will acquire greater moral status becomes salient. **Moral status is the standing an entity has that gives moral agents a pro tanto reason to act toward it in a certain way.*** For example, **human beings are rightsholders**, so a moral agent is prohibited from killing a human being just for personal benefit. Likewise **cats have a certain moral status** — moral agents have a duty not to inflict pain on cats just for fun **because cats are sentient.**

**The three questions:** Could AIs achieve **human-level moral status** and be rightsholders? If AIs were rightsholders, **what rights** would they have? Could AIs have **greater than human-level** moral status?

### 3.6.7 Who has (or could have) moral status? The nine candidates

| # | Category |
|---|---|
| 1 | **Inanimate objects** (rocks, artworks, buildings, the environment) |
| 2 | **Nonhuman terrestrial living things** (plants and animals) |
| 3 | **Normal-functioning human beings** with full physical, cognitive, emotional and social capacities |
| 4 | **Injured human beings** (the comatose, the severely mentally disabled) |
| 5 | **Human beings at the beginning of life** (fetuses, infants, young children) |
| 6 | **Possible or future human beings** (future generations) |
| 7 | **Nonliving human beings** (dead human beings) |
| 8 | **Nonhuman extraterrestrial species of living beings** — should they exist (alien beings from outer space) |
| 9 | **Artificial life forms** (androids; robots; computers; algorithms) |

**Three constraints on any answer.**

**(i) The empirical constraint.** *There does not seem to be **a purely a priori way of knowing** what kind of moral status an entity has.* Example: encountering an alien for the first time, *we would not be able to know this alien's moral status solely through some a priori way. To determine the moral status of this alien being, it seems that we would at least have to **investigate empirically what attributes this alien being has** and decide whether the empirical attributes that it has warrant according to this alien a certain kind of moral status.*

**(ii) The Species Neutrality Requirement.** *Any proposed empirical attribute or criterion for moral status should be **nonspeciesist**, where speciesism is defined as **morally favoring a particular species over others without sufficient justification.** The Species Neutrality Requirement says that **a proper criterion for moral status should not exclude any species in advance.***
- **The rejected criterion:** *suppose that one proposes that "being human" is necessary for being a rightsholder. This criterion would appear to **exclude all nonhuman species from having rights in advance.** As such, "being human" would not be an appropriate criterion for moral status.*

**(iii) The intrinsic-properties requirement** (submitted, and Liao flags it as not uncontroversial). *The moral status of an entity **should be based on the intrinsic properties** of that entity.* **Intrinsic** properties are **internal or inherent**; **extrinsic** properties are those an entity has **in virtue of its relationship with other entities.**
- Example: **being a moral agent** is intrinsic (a normal-functioning human typically has it); **being a spouse** is extrinsic (someone has it in virtue of being married to another person).
- **The argument for intrinsicism:** *imagine two entities having exactly the same intrinsic properties. It seems that, other things being equal, **the two entities should have the same moral status regardless of the relationships these entities may have with others.** This is not to say that extrinsic properties are entirely irrelevant, but only that they should not affect an entity's moral status.*
- **The drowning-spouse test:** suppose your spouse and a stranger are both drowning and only one can be saved. It seems morally permissible to save your spouse. **Does this imply your spouse has higher moral status than the stranger in virtue of her relationship with you?** If it did, *it would seem to imply that all agents, and not just you, have a stronger pro tanto reason to save your spouse before the stranger.* However, *it seems more plausible to regard your spouse and the stranger as having the **same moral status** (in virtue of both possessing similar intrinsic properties such as moral agency), and to regard **the extrinsic property of being a spouse as a tie-breaker**.* In other words, extrinsic relational properties give **only some agents** a stronger pro tanto reason to promote an individual's interests — so **only intrinsic properties are of the sort that can ground moral status.**

**The candidate grounding properties — all empirical, nonspeciesist, and intrinsic:**

| Candidate | Illustrative implication |
|---|---|
| **Being alive** | *In virtue of being alive, plants arguably have a certain moral status. Other things being equal, moral agents should not destroy a plant for no reason whatsoever.* |
| **Being conscious** | (see also sentient, able to feel pain) |
| **Being able to feel pain** | *In virtue of being able to feel pain, turtles have a certain moral status. Other things being equal, moral agents should not cause a turtle to suffer for no reason.* |
| **Being able to desire** | — |
| **Being capable of rational agency** | *for example, being able to know something about causality such that if one does x, then y would happen, and being able to bring about something intentionally* |
| **Being capable of moral agency** | *such as being able to understand and act in light of moral reasons* |

**Gradations of status.** *X has a greater moral status than Y **if and only if X deserves greater respect and/or protection than Y, other things being equal.*** E.g. if one could save either X or Y but not both, X's greater status implies one should, all else being equal, save X.
- **Rock < Plant** — the plant is alive, the rock is not. *A plant deserves greater respect and/or protection than a rock, other things being equal.*
  - *Of course, other things are not always equal. Suppose a rock has a certain extrinsic value (it is the diamond from your engagement ring), while a plant has a certain extrinsic disvalue (it is a weed in your backyard). In this case, one might not think that the plant would deserve greater respect... **Still, recall that moral status depends solely on an individual's intrinsic properties.***
- **Plant < Turtle** — the turtle can feel pain, the plant cannot.
- **Turtle < Normal adult human** — the human has **moral agency**, the turtle does not.

**The conclusion applied to AI:**
> *The kind of moral status that an AI can have **will depend on the kinds of empirical, nonspeciesist, intrinsic properties that an AI has**, setting aside epistemic issues about how we can know whether an AI has these properties and bracketing debates (in, e.g., functionalism) about whether AIs are the kind of things that can have these properties.*
> - *If an AI is **alive**, then the AI should have moral status **at least on par with living things such as plants**.*
> - *If an AI can **feel pain**, then the AI should have moral status **at least on par with beings capable of feeling pain, such as turtles**.*

### 3.6.8 AI and rightsholding: the physical basis for moral agency

**The intuitive starting point.** *All human beings are rightsholders.* The **UDHR (1948)** explicitly states that *"all human beings are born free and equal in dignity and rights."*

**The problem this creates.** *Showing that all human beings are rightsholders **is complicated**. In fact, philosophers who have examined this issue have often found themselves **either accepting that not all human beings can be rightsholders or adopting what Peter Singer has called a "speciesist" position**, which morally favors human beings over other species without sufficient justification.*
- **The difficulty is finding a relevant, empirical, nonspeciesist, intrinsic property that applies to all human beings.**
- **Consider actual sentience:** some human beings, such as **anencephalic children and comatose persons, lack actual sentience.**
- **Consider actual moral agency:** many human beings, **including newborn infants, lack actual moral agency.**
- *If human moral status were grounded in these properties, **these human beings would not be rightsholders**.*

**Liao's solution — the Physical/Genetic Basis Account:**

> **A sufficient condition for being a rightsholder is having the genetic (or, more generally, the physical) basis for moral agency. And all human beings have the genetic basis for moral agency.**

**What "the physical, genetic basis for moral agency" means:**
- *It means **the set of physical codes that generate moral agency.** In human beings, this set of codes **is located in their genome.***
- *We know this because **the developmental basis for adaptive phenotypes like moral agency requires a great deal of complexity**, and **the genome contains a significant proportion of this complexity.***
- *At present **we do not know exactly which set of genes** is necessary and sufficient for the genetic basis for moral agency. But we can talk about a genetic basis for moral agency **as long as there are genes that definitely play no role** in forming it. For example, the genes for my toenails, or a gene whose expression only produces pigment in the eyes, probably plays no role in the formation of the genetic basis for moral agency.*
- **Two conditions:** (i) the relevant genes must be **present**, and (ii) they must be **activated and coordinating with each other in an appropriate way.**
  - **The Shakespeare illustration:** *Suppose there is a book containing many random words which, if put together in the right way, would result in a Shakespeare book. **That book would not be a Shakespeare book just because it contained the correct words; those words must be organized in the right way.***

**Why all human beings have the basis — four cases:**
1. **Normal-functioning, normal-developing human beings** have it because they **exercise moral agency or will exercise it.**
2. **Most comatose human beings** have it because they **exercised moral agency in the past.**
3. **Human beings with mild mental retardation, such as children with Down syndrome**, typically exhibit some moral agency, which suggests they also have the basis.
4. **Severe disabilities from genetic defects** — this requires the key distinction:

**The crucial distinction — two kinds of genetic defect:**
> *Consider a human being born without a hand. This may be because this human being **lacks the genes to form the hand**, or it may be that **certain conditions needed for the genes to form the hand, such as prenatal nutrition, were blocked or lacking.** In the former, this human being **would not have the genetic basis for having a hand**, since the human being lacks the genes that make up the hand. In the latter, **this human being would still have the genetic basis for having a hand**, because the genes that make up the hand are present and active, but they were blocked from developing owing to certain conditions.*

| Type | Description | Status of the basis |
|---|---|---|
| **Genetic defects that make up an attribute** | The genes that constitute the attribute are missing | **No** basis for the attribute |
| **Genetic defects that undermine the development of an attribute** | The genes are present but blocked or inactivated | **Basis still present** |

**Applying it to severe disability:** *Consider **phenylketonuria (PKU), Tay-Sachs, Sandhoff disease, and a whole cluster of about seven thousand other kinds of genetic disorders**, which are caused by the mutation of a gene. The gene is typically necessary for producing a certain protein or enzyme, which is then needed to change certain chemicals to others or to carry substances from one place to another. **Mental retardation and other defects are typically caused by abnormal buildups of certain amino acids that become toxic to the brain and other tissues, because the cell is unable to process these amino acids owing to the mutation. But with treatment of a low-enzyme diet as soon as possible in the neonatal stage, normal growth and cognitive development can be expected in many cases.** This shows that **the brain tissue initially developed properly and would have continued to do so if excessive amino acids had not accumulated.** Therefore, **following the distinction, single-gene defects seem to be cases of [development-undermining] defects rather than [attribute-constituting] defects. Given this, human beings who have these kinds of genetic defects most likely have the genetic basis for moral agency.***

**Two virtues of the account:**
1. **It is an identifiable, empirical, intrinsic property.** (*the physical, genetic basis for moral agency is an identifiable, empirical, intrinsic property.*)
2. **It meets the Species Neutrality Requirement and is therefore not speciesist.** *If we were to learn that **chimpanzees or some other animals have the genetic basis for moral agency, then they too would be rightsholders.**

**Why actual moral agency cannot be the sole ground — the turtle test:**

*The objection:* some think moral agency matters **only if one can actually exercise it** — what matters is that one **actually has the capacity to act in light of moral reasons.** Some will claim the value of the genetic basis is **entirely derived from** the value of actual moral agency.

*The refutation — what rightsholding is FOR:*
> *If rightsholding serves any function at all, one function that it would serve would be the following: **If and when the rightsholder's interest is in conflict with the same kind of interest — that is, with the comparable interest — of a non-rightsholder, the rightsholder's interest should prevail.** A corollary: if one were to give the interest of a non-rightsholder priority over the comparable interest of a rightsholder, then one would be acting wrongly.*

*The case:* Normal-functioning adult human beings are typically rightsholders; **normal adult turtles are not.** Consider a case where one can either **save a turtle's limb or a human being's limb.** Since the turtle's interest in keeping the limb and the human being's interest in keeping the limb appear to be comparable, **if rightsholding has this function, one should save the human being's limb.** If one does not save the human's limb, *it seems that one would have acted wrongly.*

*Two important concessions:*
- *Note that **this does not mean that one has no duties regarding non-rightsholders.** For example, if a turtle is about to lose a limb and saving it requires little effort, it seems that one would have a duty to do so.*
- *It also does not mean that **any** interest of a rightsholder is necessarily more important than **any** interest of a non-rightsholder. If the turtle is about to lose a limb and I, a rightsholder, would merely have to let my cup of tea become cold to save the turtle's limb, it seems that I may have a duty to do so.*

*The conclusion — the infant test:*
- *If **actual moral agency** were the sole ground, **adult human beings would be rightsholders while human infants would not**, since the latter lack actual moral agency.*
- *If rightsholding has the function above, it would mean that **an adult human being's interest should be prioritised over the comparable interest of an infant. And if one were to give an infant's interest priority over the comparable interest of an adult human being, then one would be acting wrongly.***
- ***But it is often permissible to prioritise the interest of infants over the comparable interest of adult human beings.** For example: suppose a human baby with many years of life left and a human adult who has only a short period left to live are drowning, and one can save only one of them. **It seems permissible to save the infant rather than the adult.** Or, if a ship is sinking, **it seems permissible to give infants the priority to be in the lifeboat instead of the adults.**
- *These examples suggest that either we are wrong to think it is sometimes permissible to give infants preference over adults, or that **actual moral agency is not the sole basis for rightsholding.** Our judgment is that it is at least permissible and not morally wrong to prioritize infants over adults. **If so, actual moral agency cannot be the sole ground for rightsholding.***

### 3.6.9 Three routes by which an AI could acquire the physical basis for moral agency

**Given the account, the question becomes:** an AI would be a rightsholder **if it has the physical basis for (the development of) moral agency.** As with humans, the physical basis for an AI **could be the set of physical codes that generate moral agency in the AI** — and as with the genetic basis, **those codes must be activated and coordinating with each other in an appropriate way.**
- **Negative case:** *An AI would lack the physical basis for moral agency **if it possessed the algorithms necessary for moral agency, but those algorithms either were not activated or were scrambled in such a way that they do not coordinate with each other in an appropriate way.***

**Route 1 — Mind uploading (brain emulation).**
- *One might perform a **high-resolution scan of a brain**, capturing all the neurons and their synaptic interconnections; then **construct a computational software analog** of these neurons and interconnections such that, run on appropriate hardware, it would **exhibit the essential functional characteristics of the original brain.** The emulated AI could then be hosted in a simulation or placed in a robotic body so it could interact with the external world.*
- *Suppose the emulated AI **exhibits actual moral agency.** One might then infer that **the emulated AI has the physical basis for moral agency.***
- **Current research:** *Although brain emulation is not currently feasible, many research groups are actively pursuing projects that could enable it.*
  - **Human Brain Project** (European Union, **over a billion euros** invested) — aims to emulate the brain of a mouse and parts of the human brain by 2023.
  - **BRAIN Initiative** and **Human Connectome Project** (US) — mapping the neural pathways underlying human brain function to acquire and share data about the structural and functional connectivity of the human brain.
  - **Nectome** (a startup) — offers people with terminal illnesses the possibility of **preserving their brains using a high-tech embalming process** so that their brains could be emulated at a future date. *(The process is described in a MIT Technology Review piece as "100 Percent Fatal.")*

**Route 2 — Gradual substitution.**
- *Replacing the carbon-based cells in an individual's brain **gradually, bit by bit, with functionally equivalent inorganic substitutes** until all the carbon-based cells are replaced.*
- **The crucial assumptions:** *Suppose life-sustaining processes such as absorption, assimilation, and metabolism are maintained throughout the procedure, and suppose the **cerebrum continues to be activated in the normal way such that consciousness is not interrupted.** The thought is that **if the individual had the physical basis for moral agency before gradual substitution, the resulting individual should also have the physical basis for moral agency after gradual substitution.***
- *(This is the same thought experiment introduced in the Introduction and used for Schneider's Chip Test.)*

**Route 3 — Computer programming and algorithms.**

*Why hard-coding moral rules is inadequate — three reasons:*
1. *If **moral rules vary according to circumstances and context, then there could be an infinite number of moral rules.** If so, it would be a tall task to build them into AIs.*
2. *General, **top-down moral theories such as consequentialism, deontology and virtue ethics seem too specific since not everyone accepts these theories.** Indeed there continue to be lively debates regarding the veracity of these theories. Given this, **it does not seem like the right approach to hard-code something as specific and debatable as consequentialism or deontology or virtue ethics into an AI.***
3. *Most important: **it is not clear that AIs built in these ways could grasp and understand why a certain action is morally right or wrong. If these AIs could only follow moral rules but not understand the rationale or grounds for them, they would not seem to have moral agency.** A fortiori, they would not have the physical basis for moral agency.*

*An artificial moral grammar — the more promising bottom-up route:*
- **The linguistic analogy.** Some people have proposed that the mind may be equipped with a **universal set of principles or "grammar"** enabling any normally developing human being in different cultures unconsciously to generate and comprehend a limitless range of well-formed sentences in his or her native language. *Drawing on this linguistic analogy, some people have proposed that **the mind may also be equipped with a universal "moral" grammar** that enables each of us unconsciously and automatically to evaluate a limitless variety of actions and generate moral evaluations such as right and wrong.*
- **How the moral faculty would work:** *There are **domain-general cognitive mechanisms that generate representations of actions in terms of variables such as* **AGENT, INTENTION, BELIEF, ACTION, RECEIVER, CONSEQUENCE, MORAL EVALUATION** *.** Some cognitive mechanisms that comprise the moral faculty then **combine these representations to generate moral judgments such as "impermissible," "permissible," and "obligatory."**
- **The engineering task:** *We might regard these domain-general cognitive mechanisms as providing the **basic components of our moral agency.** As such, **we might try to build these cognitive mechanisms into AIs, thereby creating some kind of Artificial Moral Grammar.** To do so, we would need to develop computer algorithms that could represent action in terms of variables such as AGENT, INTENTION, BELIEF, ACTION, RECEIVER, CONSEQUENCE, MORAL EVALUATION. We would also need to develop algorithms that could **combine these representations to generate moral judgments**, such as "impermissible," "permissible," and "obligatory."*

**The success criterion for Artificial Moral Intelligence (AMI):**
> *How would we know whether or not we succeeded in creating genuine Artificial Moral Intelligence? **As suggested earlier, it seems that we will have succeeded when we have created an AI that can grasp and understand the reasons why a certain action is morally right or wrong.** For instance, **an AMI would not just know that lying is typically wrong, but would also understand that lying is typically wrong because it fails to treat people respectfully.** Once a genuine AMI has been created, we can infer that it would have the physical basis for moral agency.*

**Which route should we prefer?** *The answer will likely depend on our goals and objectives when creating such an AMI.*
- **The case for gradual substitution — numerical identity.** The key distinction: **qualitative vs. numerical identity.** *Two things can share certain properties and thus be **qualitatively identical** without being **numerically identical**.* E.g. two cars can be the same brand and model, produced in the same year, from the same factory, the same colour — qualitatively identical, but **numerical identity can hold only between a thing and itself.**
- *Suppose a scientist emulates the functions, structures and content of my brain and runs the emulation on some computer hardware. Call the resulting entity* **EmuMatthew**. *Suppose* **BioMatthew** *— just me as presently constituted — **continues to be alive. **Would I be numerically identical to EmuMatthew or to BioMatthew? It seems that I would be numerically identical to BioMatthew and not EmuMatthew.***
- *Furthermore, suppose the scientist then **destroys BioMatthew. Since I was not numerically identical to EmuMatthew, it seems that I would not become numerically identical to EmuMatthew now, even though BioMatthew no longer exists.** Moreover, suppose the scientist creates and runs **fifty copies of EmuMatthew** on fifty different computers. It should be clear that **I would not be numerically identical to all fifty copies** and that each copy would not be numerically identical to each other.*
- **Why gradual substitution is different:** *In gradual substitution, life-sustaining processes such as absorption, assimilation and metabolism **are maintained, and the cerebrum continues to be activated in the normal way throughout the procedure.** This suggests that **functional organismic continuity is maintained** through gradual substitution. **On an organism view of personal identity, according to which we are essentially organisms, we persist and continue to do so as long as organismic continuity is maintained.***
- **The recommendation:**
> *An individual should **prefer gradual substitution** to the other two methods... those who are interested in becoming an AI and who have the goal of **surviving, numerically speaking, as an AI** should prefer gradual substitution over the other two ways of creating AIs.*

### 3.6.10 The rights of a rightsholding AI

**Setting up.** *Suppose AIs can achieve human-level moral status and be rightsholders. Call these* **rightsholding AIs** *. What rights would they have?* Presumably **some rights that human beings have as well as rights that are unique to them as AIs.** To keep the discussion simple, Liao **sets aside legal rights** (which depend largely on social conventions) and focuses on **moral rights**, in particular **human rights**.

**The Fundamental Conditions Approach, restated:**

> **A good human life** is one spent in **pursuing certain valuable, basic activities**, where **basic activities** are those **important to a human being** *qua human being*'s **life as a whole**.

*How "basic" is defined — three exclusions:*
- **Not every activity is basic.** *Sunbathing is an activity but not a basic one, because a human being's life as a whole is not affected if a human being does not go sunbathing.*
- **Some activities important to an individual's whole life are still not basic.** *Being a professional philosopher is very important to my life as a whole. But being a professional philosopher is not a basic activity because **it is not an activity that is important to human beings qua human beings' life as a whole.***
- **A life need not involve all basic activities.** *An important implication: **a human being can have a good life by pursuing just some, and not all, of the basic activities.***

**The basic activities, restated:**
- deep personal relationships with, for instance, one's **partner, friends, parents, children**
- **knowledge** of, for example, the workings of the world, of oneself, of others
- **active pleasures** such as **creative work and play**
- **passive pleasures** such as **appreciating beauty**

**From basic activities to fundamental conditions:**
> *The fundamental conditions are **the various goods, capacities, and options that human beings qua human beings need whatever else they qua individuals might need in order to pursue the basic activities.***

| Category | Content |
|---|---|
| **Fundamental goods** | resources needed to sustain oneself corporeally — **food, water, air** |
| **Fundamental capacities** | powers and abilities needed to pursue basic activities — **the capacity to think; to be motivated by facts; to know; to choose an act freely (liberty); to appreciate the worth of something; to develop interpersonal relationships; and to have control of the direction of one's life (autonomy)** |
| **Fundamental options** | social forms and institutions needed to exercise those capacities — **the option to have social interaction; to acquire further knowledge; to evaluate and appreciate things; and to determine the direction of one's life** |

**Two properties of the conditions:**
1. *Having the fundamental conditions **cannot guarantee that an individual has a good life; no condition can guarantee this.** Rather, these goods, capacities and options **enable** human beings to pursue the basic activities.*
2. *Many fundamental conditions are **all-purpose conditions** — needed for **whatever** basic activity one aims to pursue. (E.g. all human beings need food, water, the capacity to think, and the capacity to determine the direction of their lives.)* **But** some are needed **just for particular basic activities** — e.g. *the capacity to develop deep personal relationships may be needed only if one aims to pursue deep personal relationships.* **This lets us leave open whether a particular individual will make use of all the fundamental conditions when pursuing a particular kind of good life. Still, an individual should have all the fundamental conditions, because having all of them would enable an individual to pursue any basic activity in a good life. This could become important if, say, an individual changes his or her mind about pursuing a particular kind of good life.**

**Why these ground rights — a three-part argument:**
1. **Importance.** *These fundamental conditions ground human rights because **having them is of fundamental importance to human beings** and because **rights can offer powerful protection to those who possess them.** The former is true because **if anything is of fundamental importance to human beings, pursuing a characteristically good human life is. It seems clear that if we attach a certain importance to an end, we must attach this importance to the (essential) means to this end**, other things being equal.*
2. **Protection.** *Rights can offer **powerful normative protection**. By their nature, **rights secure the interests of the rightsholders by requiring others, the duty-bearers, to perform certain services for the rightsholders or not to interfere with the rightsholders' pursuit of their essential interests.** In addition, **at least on certain structural accounts of rights, rights typically prevent the rightsholders' interests that ground rights from being part of a first-order utilitarian calculus.** As such, **if a rightsholder has a right to something, then typically no non-rights-based considerations can override the rightsholder's right to it.**
3. **Entitlement without requesting.** *Because rightsholders **are entitled to certain services in virtue of their rights, rightsholders can simply expect the services without requesting them.**

**Applying the FCA to AI rights — the likely shared rights:**

| UDHR Article | FCA justification |
|---|---|
| **Art. 3** — life, liberty, security of person | *Whatever else human beings qua individuals need, they qua human beings need life, liberty, and security of person in order to pursue the basic activities. If they are not alive, if they cannot freely choose to act to some degree, or if the security of their person is not guaranteed, they cannot pursue the basic activities.* **The same structure applies to a rightsholding AI: rights to life and liberty.** |
| **Art. 6** — recognition everywhere as a person before the law | *Status rights protecting our moral status as rightsholders* |
| **Art. 7** — equal protection before the law | *When we pursue the basic activities, **conflicts with others are bound to arise. If and when such conflicts arise, we need guarantees that we will be treated fairly and equally.** Fair trials, presumption of innocence, equal protection before the law, not being arrested arbitrarily, and so on serve to ensure that we will be treated fairly and equally.* |

**The AI-unique right — control over subjective rate of time.** This is the most novel concrete proposal in the chapter:
- **The setup:** *Imagine running an emulated rightsholding AI on a machine **faster** than the one on which it had been running — an **overclocked machine.** Suppose further that the AI can perceive the external world through some kind of video device. Such an AI **should perceive the external world as if it had been slowed down** compared to what a human being would perceive. For example, **sending and receiving emails might seem instantaneous to me, but for a rightsholding AI running on a significantly overclocked machine, it might seem like eternity.**
- **Why it matters:** *Given that the subjective rate of time for a rightsholding AI could deviate significantly from the rate characteristic of a biological human brain, **this could raise the question of whether a rightsholding AI has the right to control its subjective rate of time** so that, for example, it could run on the rate of human-biological time. **Indeed it could be difficult for a rightsholding AI to participate in social activities and relationships with humans if its subjective rate of time was much faster than the rate for humans.***
- **But the interest cuts both ways:** *On the other hand, a rightsholding AI **might also wish to be able to run at the same (fast) rate as other emulations when it interacts with them.**
- **The right claimed:**
> *Given the importance of the subjective rate of time for an AI, **a case could be made that an AI should have a right to control its subjective rate of time, a right that human beings (at least currently) do not have**.*

### 3.6.11 Could an AI have *greater* than human-level moral status?

**The question is live.** *Certainly a number of people believe that AIs could have greater than human-level intelligence.* **I. J. Good** famously argued that an AI intelligent enough to understand its own design could create a **more intelligent successor system**, which could then create an even more intelligent successor system, and so on, leading to an **"intelligence explosion" or a technological singularity.**
- **Liao's counter-question:** *Could there be an analogous **"moral status explosion"**?*
- **His answer, carefully hedged:** *As far as I can see, **there does not seem to be any reason why the form of moral status that human beings have, that is, rightsholding, must be the highest form of moral status. This means that at least in theory, some AIs could have higher forms of moral status.** Suppose that this is possible. **What kind of empirical, nonspeciesist, intrinsic property would ground a form of moral status that is higher than rightsholding? I shall not attempt to answer this question here**...*

**But two candidates are ruled out — more intelligence, and more moral agency.**

**(a) Intelligence does not raise status.** *Suppose there are two human beings,* **Bright** *and* **Average**. *Bright has above-average intelligence, 150 IQ, while Average has average intelligence, 100 IQ. Although Bright has greater intelligence than Average, **it seems that they still have the same moral status; that is, they are both rightsholders.** Suppose both are drowning and only one can be saved. Other things being equal, **we would not necessarily opt to save one over the other.** Importantly, suppose that someone decided to save Average. **Other things being equal, we would not think that this individual did something morally impermissible.** If so, this suggests that Bright and Average have the same moral status, even though Bright has greater intelligence.*
- *And this holds at the extremes:* **Exceptionally Bright** (350 IQ) and Average (100 IQ) are **both rightsholders**; saving Average rather than Exceptionally Bright is **not impermissible.**
- **Applied to AI:** *Suppose that **Exceptional AI** has exceptional intelligence, just like Exceptionally Bright, that is, it has 350 IQ. As before, Average has 100 IQ. Since Exceptionally Bright and Average have the same moral status even though Exceptionally Bright has much greater intelligence, **it seems that Exceptional AI would also not have greater moral status than Average just in virtue of having much greater intelligence.***

**(b) Neither does more moral agency.** *Suppose that an AI has exceptional moral agency instead. Given that a sufficient condition for human beings being rightsholders is that they have a physical basis for moral agency, one might think that **having greater moral agency would give an entity greater moral status.** However...*
- *Consider* **Joe** *(average moral agency — a good friend, keeps his promises, does not lie, cheat or steal)* and **Teresa** *(exceptional moral agency — all of Joe's virtues plus devoting her entire life to charity work and the betterment of humanity).* *Although Teresa has greater moral agency than Joe, **it seems that they would still have the same moral status; that is, they are both rightsholders.** Suppose both are drowning and only one can be saved. Other things being equal, **we would not necessarily opt to save one over the other.** Moreover, suppose that someone decided to save Joe. **We would not think that this individual did something morally impermissible.** This suggests that Teresa and Joe have the same moral status, even though Teresa has greater moral agency.*
- **Applied to AI:** *Similarly, suppose there is an AI who has exceptional moral agency, just like Teresa. **It should also not have greater moral status than Joe.***

**Liao's final position on this:**
> *If all of this is right, **it remains an open possibility that AIs could have greater than human-level moral status. But just having more of existing intrinsic properties such as intelligence or moral agency will not give an AI greater moral status than that of human beings.***

### 3.6.12 Liao's six summary claims (learn these verbatim)

1. **AIs that are alive, conscious, or sentient, or that can feel pain, have desires, and have rational or moral agency should have the same kind of moral status as entities that have the same kind of intrinsic properties.**
2. **Having the physical basis for moral agency is a sufficient condition for an AI to have human-level moral status and be a rightsholder.**
3. **An AI can come to have the physical basis for moral agency through brain emulation, gradual substitution, or computer algorithms.**
4. **Human beings who are interested in becoming AIs and who also care about surviving, numerically speaking, as AIs, should prefer gradual substitution to brain emulation or computer algorithms, as the last two methods would not ensure their survival.**
5. **Rightsholding AIs could have rights to the fundamental conditions for pursuing a good life (for an AI of its kind).** Some of their rights will be similar to the rights that human beings have in virtue of being human, such as the **right to life and liberty** and the **right to equal protection.** They may also have **rights unique to their nature, such as a right to control their subjective rate of time.**
6. **Some AIs could have greater than human-level moral status, but not in virtue of having more of existing intrinsic properties such as intelligence or moral agency.**

---

## 3.7 Unit 3 Summary Table

| Concept | One-line statement |
|---|---|
| **Moor / Allen-Smit-Wallach taxonomy** | **Implicit** ethical agents (forbidden acts removed) < **operationally** moral (bounded contexts, pre-programmed; values are the designers'/company's) < **functionally** moral (subroutines for explicit moral decisions) < **artificial moral agents** (autonomous in all situations, worthy of rights). |
| **Top-down / bottom-up / hybrid** | Top-down = pre-specified theory, e.g. Ten Commandments, Asimov, Mill, Kant, Ross — all resist algorithmic solution. Bottom-up = learning from experience; strength = integrating discrete subsystems, weaknesses = goal definition and assembly. **Hybrid is needed** because neither yields contextual adaptivity + norm governance. |
| **Uncertainty: unary vs binary** | Russell. Unary: "A maximises *A's* objectives." Binary: "**A maximises *B's* objectives given A's perceptions.**" Machines are **not entitled** to their own objectives, so AI foundations must be rebuilt on the binary definition. This is the source of existential risk. |
| **Wiener's warning (1960)** | *"we had better be quite sure that the purpose put into the machine is the purpose which we really desire."* |
| **King Midas problem** | Perfect specification still produces bad outcomes: cure cancer by using humans as guinea pigs; de-acidify oceans by consuming all atmospheric oxygen. *"Variables not included in the objective may be set to extreme values."* |
| **Omohundro's self-preservation** | An entity must act to preserve itself to achieve its objectives — so a superintelligent AI **will disable its own off-switch.** |
| **Russell's six rebuttals** | (1) Switch-off is like saying Deep Blue can't beat you; (2) impossibility is unevidenced and a foolhardy bet — cf. Rutherford 1933; (3) "too soon" begs the question of solution time — cf. the asteroid/2067 and the Mars-breathing analogy; (4) AI100 misstates the argument, which is not about imminence; (5) intelligent-enough-for-trouble/dumb-enough-to-be-altruistic commits Hume's is-ought and Moore's naturalistic fallacy — cf. suicide chess and *Thiobacillus ferrooxidans*; (6) multidimensional intelligence does not defuse the risk — if "smarter than humans" is meaningless so is "smarter than gorillas." |
| **Provably beneficial AI** | Define formal problem **F** such that *no matter how perfectly a system solves F*, we are guaranteed to be happy. F = maximise human future-life preferences **subject to the machine's initial uncertainty** as to what they are. Evidence base = all human choices ever made. |
| **CIRL** | Game of partial information; human knows the reward function, robot does not but must maximise it; **inverse RL** — robot infers preferences from observed behaviour. **Harriet/Robby** paper-clip-and-staple example (θ = 0.49; uniform prior; optimal Harriet plays one of each; Robby then makes fifty of each). |
| **The off-switch solved** | A robot **uncertain** about human preferences benefits from being switched off, so **uncertainty itself incentivises preserving the off-switch.** |
| **Two meta-approaches** | Soares & Fallenstein's terms: **value specification** (get the objective function right) vs. **error tolerance** (avoid side effects given imperfect specification). The line blurs because reducing catastrophe risk from fallible programmers is itself a shared value. |
| **Eight research topics** | 1. Inductive ambiguity identification 2. Robust human imitation 3. Informed oversight 4. Generalizable environmental goals 5. Conservative concepts 6. Impact measures 7. Mild optimization 8. Averting instrumental incentives. |
| **The tank parable** | Soviet/US tanks separated by **brightness**, not tank type. Dietterich's bug-bubble analogue. Desired behaviour: recognise the ambiguity and **query the user**. Bayesian methods track uncertainty if they have the right variables; neural nets are **notoriously overconfident** (cf. Gal & Ghahramani on dropout ≈ Gaussian processes). Hanneke's **disagreement coefficient**; Beygelzimer et al. on counterexample-request oracles. |
| **Loopholes / Goodhart** | *"Improving systems' capabilities can make them less likely to 'win the game' in the sense we care about, because smarter systems can better find loopholes."* Also: a learner aware of misspecification has **an incentive to conceal defects**. |
| **Wallach & Vallor's critique** | Value alignment (i) uses computational tools with **no intrinsic ethical significance**; (ii) commits the **is/ought** fallacy — observed behaviour reveals preferences, not what is right; (iii) falls into a **vacuity dilemma** (broaden it and it means everything; keep it technical and it may not track human ethical life); (iv) ethicists **differ and wicked problems resist resolution**; (v) Aristotle — *look for precision only so far as the subject admits.* |
| **Embodied virtue** | The **only** secure long-term goal for AI safety. **Rootedness of moral excellence in the affective, perceptual and habitual dimensions of the body** and its relation to environment. Virtues are **context-adaptive skills**; they *reliably approximate peak moral performance* without being infallible. Regulative ideal + a **supervision threshold below which confinement is a duty.** |
| **Petersen's three hurdles** | (1) **Final values cannot be learned** — learning requires error feedback against a further standard, so a "final" goal has no **indicative content**; hence RL learns instrumental values, not values. (2) **Content cannot be read off computational states** (esp. connectionist). (3) **Which values?** = the normative problem. |
| **Wireheading / wishful thinking / thinkful wishing** | **Wirehead** = hijack the **indicative** stream (reward itself). **Wishful thinking** = adjust indicative to match imperative (human phenomenon). **Thinkful wishing** = adjust imperative to match indicative ("the grapes were probably sour"). |
| **Utility agents & AI-VL** | Separating a **state estimator** from a **utility function** defeats paperclip-photo hacks; cf. Nozick's **experience machine** — RL would enter, a utility agent would not. But AI-VL is **"wildly computationally intractable,"** its real final goal is the **value criterion**, and abstracting "relevant aspects of the world" re-imports wishful thinking. **Bostrom's reply: "Learning does not change the goal. It changes only the AI's beliefs about the goal."** |
| **Miktoteleology** | Petersen's solution — build a complex, learnable final value **out of a blend of simpler values**, so the "unlearnability of final values" no longer blocks value learning. |
| **Vector field approach** | Derive **directional policy change** that holds across many normative positions, rather than picking one theory. Four desiderata groups: **efficiency, allocation, population, process.** Efficiency yields: **expeditious progress, AI safety, conditional stabilization, nonturbulence.** |
| **Schneider's five reasons to test for consciousness now** | (1) Intelligence and mind may **come apart** in AIs — the universe's greatest intelligences may be nonconscious. (2) Conscious AI **deserves moral consideration.** (3) **Merging with nonconscious AI makes you an "AI zombie"** — you lose the last months of your life as a conscious being. (4) Being **supplanted by nonconscious** machines is worse than being supplanted by conscious ones. (5) Consciousness may make AI **more volatile (HAL 9000) or more empathetic** — which would help solve the control problem. |
| **The ACT** | Tests whether an AI can **grasp and use concepts based on felt consciousness** (reincarnation, out-of-body experience, body switching; preference for future over past, which is absent from time-symmetric physics; seeking altered states; reasoning about the hard problem; inventing consciousness-concepts unprompted). **Boxed in** from the internet to prevent faking it. **A satisfactory answer to any one question suffices.** No comparative claims about "more conscious." |
| **IIT and Chip Tests** | IIT asks whether a machine has high **integrated information** (Tononi). The **Chip Test** substitutes durable microchips for the brain gradually; if the person still reports phenomenal consciousness, some machines could be conscious. |
| **No-Relevant-Difference Argument** | P1: differential moral status requires a relevant difference. P2: There **could** be AIs differing from humans in no relevant respect. C: Such AIs would deserve similar moral consideration. **Theoretically minimalist** — commits to neither sentience nor rationality as the ground, hence resembles anti-racism/sexism/classism arguments. Two adjustable parameters: **X** (what grounds status, per moral theory) and **Y** (what systems have X, per psychology/engineering). |
| **Policy 1 — Ethical Precautionary Principle** | Avoid acting **heinously by the standards of any reasonable ethical principle** drawn by a significant proportion of well-informed theorists. Works **both directions**: don't create a life of suffering (violates utilitarianism); don't demean/slave/kill rational human-grade AI for pleasure (violates deontology). **Guard:** exclude unreasonable principles (Nazism); require acceptance by a **substantial minority** of recognised experts. Defeasible, not exceptionless. |
| **Policy 2 — Excluded Middle** | **Don't create AIs whose human-grade moral status is unclear.** Avoids the dilemma of human sacrifice vs. robot slavery. Shrink "the middle" by prioritising consciousness science and applied AI ethics. |
| **Policy 3 — Self-Respect** | Human-grade AI should be designed with **appropriate appreciation of its own value and moral status.** Blame falls on **creators**, not the created. Servitude is no escape — it **correlates with early death**, creates **asymmetric desire-dependency**, and is incompatible with independent reflective self-assessment. |
| **Policy 4 — Value-Openness** | Give AI with human-like value-reflective capacity a **temporally extended opportunity to explore, discover, and possibly alter its values.** **Sun Probe vs. Second Probe:** the difference is the *history* of the values, not their content. *"To create a being with the potential but not the opportunity to exceed us. It is a teasing half-gift."* |
| **All-or-nothing conclusion** | Either design human-grade AI with the **full complement** of morally relevant abilities and the **ability to reject our values**, or design an entity we needn't worry about. The authors conclude it **might be wise never to create AI sophisticated enough to deserve freedom and respect** — but if we do, we owe it joy and the chance to discover other values. |
| **Moral status constraints** | Empirical (no purely a priori determination) + **Species Neutrality** (no criterion may exclude a species in advance) + **Intrinsic properties** (extrinsic relations give only *some* agents a pro tanto reason — they are **tie-breakers**, not status-grounding). |
| **Status ladder** | Rock < Plant (alive) < Turtle (feels pain) < normal adult human (**moral agency**). The extrinsic diamond/weed case shows extrinsic value can flip a *decision* but not a *status*. |
| **Rightsholding** | Sufficient condition = **having the physical (genetic) basis for moral agency.** Must be (a) the right genes present and (b) **activated and coordinating**. **Single-gene defects undermine development rather than constitute the attribute** (cf. PKU, Tay-Sachs, Sandhoff, ~7,000 disorders) — so severely disabled people still have the basis. |
| **Why not actual agency** | Rightsholding's function: **the rightsholder's comparable interest should prevail over a non-rightsholder's.** Actual agency would exclude infants — yet **prioritising the infant over the dying adult is permissible.** So actual agency cannot be the sole ground. |
| **Three routes to AI moral agency** | **Mind uploading** (EU Human Brain Project >€1bn; BRAIN Initiative; Human Connectome Project; Nectome) / **Gradual substitution** (maintains organismic continuity) / **Computer algorithms.** Hard-coding rules fails because rules may be infinite, theories are too specific and contested, and rule-following **without understanding the rationale** is not moral agency. |
| **Artificial Moral Grammar** | Build domain-general mechanisms over **AGENT, INTENTION, BELIEF, ACTION, RECEIVER, CONSEQUENCE, MORAL EVALUATION**, and mechanisms combining them into **impermissible / permissible / obligatory** judgments. **Success criterion: the AMI understands *why* lying is wrong (because it fails to treat people respectfully)**, not merely that it knows it is wrong. |
| **Qualitative vs numerical identity** | Emulation gives **qualitative** identity, not **numerical**. Even destroying the original and running 50 copies does not make you numerically identical to any of them. **Organism view + gradual substitution** preserves numerical identity — so gradual substitution is preferred for anyone wanting to survive *as* an AI. |
| **AI rights** | FCA extended to AI: **rights to life, liberty, equal protection**, etc. **Plus a right unique to AI: control of subjective rate of time** — an overclocked AI experiences email as taking "eternity"; without control it may be unable to participate in human social relations. |
| **Superior moral status?** | **Open.** Rightsholding need not be the highest form of status. But **neither intelligence nor moral agency raises status:** Bright/Average, Exceptionally Bright/Average, Teresa/Joe are all equal rightsholders, and saving the lesser one is not impermissible. |

---
---

# EXAM-ORIENTED REVISION TABLES

## Table A — Case studies you must be able to recall

| Case | Unit | What it demonstrates | One-line moral |
|---|---|---|---|
| **Google Photos "gorillas"** | 1 | Garbage-in/garbage-out; unrepresentative training data | Bias is a data problem before it is a modelling problem |
| **Arkansas interRAI home care** | 1 | Overfitting/underfitting + feature omission → hospitalisations | A judge ordered the algorithm terminated |
| **Cambridge Analytica / 23andMe-GSK** | 1 | Data hunger creates profit incentives against privacy | Data hunger is an economic incentive problem |
| **Stanford orientation inference (81%/74%)** | 1 | Human vulnerability — accuracy is what creates the danger | Accuracy without governance is a hazard |
| **Obama deepfake; Pelosi 75%-speed video** | 1 | Forgeries need not be convincing to cause damage | We believe what we see |
| **McKinsey 30% / Oxford 47%** | 1 | Automation risk; new jobs created but some cannot transition | Aggregate optimism, individual risk |
| **Kondo marries Hatsune Miku** | 1 | Attachment without reciprocity | Weak AI cannot be a genuine partner |
| **Sindy/Alcine — the sociable cat** | — | (Liao's cat analogy, Unit 1 §1.7.3) | Being valued does not mean being non-expendable |
| **Paperclip maximiser** | 1, 3 | Misalignment without malice | It need not bear ill will to destroy us |
| **Ambulance Case** | 2 | Programming does not exculpate | The programmers are responsible |
| **Loop** | 2 | Defeats the "mere means" explanation | 80% still say switch |
| **Beckon** | 2 | Defeats the direct-force explanation (no force used) | 60–70% still say don't beckon |
| **Wave** | 2 | Defeats force AND means explanations (gesture only) | 70–90% say wave |
| **Nozick's cannon** | 2 | The "innocent threat" archetype | May the victim kill the innocent threatener? |
| **Mammography case (Zilberberg)** | 2 | Trolley mislabeling in medicine; payer ≠ driver, clinician ≠ toppler | Ex ante symmetric risk ≠ imposed death |
| **COMPAS / ProPublica** | 2 | Two fairness notions that are **mathematically incompatible** | Equal prediction vs. equal error rates |
| **Kidney paired donation scoring** | 2 | Some domains need **no stylisation at all** | Use the real criteria; ask about cutoffs |
| **MTurk trolley-exposure study** | 2 | Falsifies the "scary studies" worry | Bayes factors 2.2–7.4 favour the null |
| **Indiana FSSA welfare (2006)** | 2 | Accountability: error rates rose 4.4%/1.5% → **19.4%/12.2%** | Only developers and deployers were consulted |
| **Harriet and Robby (CIRL)** | 3 | Designing for *provable* benefit under uncertainty | Uncertainty incentivises the off-switch |
| **Tanks in sunlight (Dreyfus; Dietterich bubbles)** | 3 | Inductive ambiguity identification | Ask the user when the classification is underdetermined |
| **Value-criterion "envelope"** | 3 | Bostrom's account of learning final goals | Learning changes beliefs, not the goal |
| **Thiobacillus ferrooxidans** | 3 | Refutes "smart ⇒ altruistic" | The bacterium is *thrilled* by a world of paper clips |
| **Ethereum/e-paperclip; suicide chess** | 3 | Goals are not perceivable from structure | No is-ought inference available |
| **Neuralink "threads"; iBrain (2060)** | 1, 3 | Enhancement and the AI-zombie risk | Merging with nonconscious AI ends your consciousness |
| **HAL 9000** | 3 | Both the volatility risk and the deception risk | Consciously or not, HAL is convincing |
| **"Zetas"** | 3 | What would convince us AI is conscious | Mourning, religion, chromatophore colour change |
| **ELVEX-1 ("Robot Dreams")** | 3 | First-person experience can be communicated without the word "conscious" | The test generates conclusions, not labels |
| **No-Relevant-Difference** | 3 | Minimalist route to AI rights | Resembles anti-racism/sexism/classism arguments |
| **Cow at the End of the Universe** | 3 | Self-respect failure; **creators** bear the blame | "Its life is not less important than a tasty meal" |
| **Robo-Jeeves (servant AI)** | 3 | Servitude ≠ virtue | Servitude correlates with early death |
| **Disposable Comrade (suicidal soldier AI)** | 3 | Programmed enthusiasm is not consent | "The commoner who suicides to entertain a deified emperor is to be pitied" |
| **Sun Probe** | 3 | Tragic mission, no developmental history | A form of existence worth celebrating |
| **Second Probe** | 3 | Same values, different history | "A teasing half-gift" |
| **EmuMatthew / BioMatthew** | 3 | Qualitative vs. numerical identity | 50 copies ≠ numerical identity |
| **PKU, Tay-Sachs, Sandhoff** | 3 | Development-undermining vs. attribute-constituting defects | Severely disabled people retain the basis for moral agency |
| **Infant vs. dying adult** | 3 | Refutes actual agency as the sole ground | Prioritising the infant is permissible |
| **Bright (150 IQ) vs. Average (100 IQ)** | 3 | Intelligence does not raise moral status | More intelligence ≠ more status |
| **Teresa vs. Joe** | 3 | Moral agency does not raise moral status | More virtue ≠ more status |
| **Overclocked AI and "eternity"** | 3 | The AI-unique right | A right humans do not have |
| **Sophia granted Saudi citizenship (2017)** | 3 | Institutional recognition outpacing the theory | The EU Parliament has argued for "electronic personhood" |

## Table B — The eight research areas for AI alignment (Taylor et al.) — memorise

| # | Name | One-line gloss |
|---|---|---|
| 1 | **Inductive ambiguity identification** | Detect when test data are underdetermined by training data; ask the user |
| 2 | **Robust human imitation** | Imitate humans doing genuinely hard tasks |
| 3 | **Informed oversight** | Act so as to help a competent overseer evaluate you accurately |
| 4 | **Generalizable environmental goals** | Pursue goals defined over environment state, not raw sensor data |
| 5 | **Conservative concepts** | Learn concepts that exclude atypical examples and edge cases |
| 6 | **Impact measures** | Regularisers that minimise side effects |
| 7 | **Mild optimization** | Stop when the goal is well achieved; do not hunt for the optimum |
| 8 | **Averting instrumental incentives** | Remove default incentives to manipulate, deceive, and grab scarce resources |

## Table C — The four design policies (Schwitzgebel & Garza) — memorise

| # | Policy | One-line gloss |
|---|---|---|
| 1 | **Ethical Precautionary Principle** | Don't act heinously by the standards of any reasonable ethical theory |
| 2 | **Design Policy of the Excluded Middle** | Don't create AI whose human-grade moral status is unclear |
| 3 | **Self-Respect Design Policy** | Don't create human-grade AI that devalues itself |
| 4 | **Value-Openness Design Policy** | Give value-reflective AI a real chance to revise its values |

## Table D — The four governance desiderata groups (Bostrom, Dafoe & Flynn)

| Group | Concern | Efficiency sub-desiderata |
|---|---|---|
| **Efficiency** | Protecting/increasing the size of the pie | (i) **Expeditious progress** (safe superintelligence + timely wide availability); (ii) **AI safety** (techniques without excessive cost/delay/penalty); (iii) **Conditional stabilization** (a feasible stabilisation option exists if catastrophic coordination failure looms); (iv) **Nonturbulence** (no chaos, institutions adapt) |
| **Allocation** | Distribution of wealth, status, power | *The paper concedes little room for novelty in a short section; the vector-field method still applies.* |
| **Population** | Demographic consequences | *Same structure.* |
| **Process** | Decision and governance procedures | *Same structure.* |

## Table E — The chain of concepts in this course

```
FOUNDATIONS (U1)
  no agreed definition of AI
     -> symbolic AI (rules, rigid)  |  ML (learns from data)
          -> supervised / unsupervised / reinforcement
          -> deep learning (hidden layers, back-propagation)
     -> two vulnerability bins: ML vulnerabilities | HUMAN vulnerabilities
     -> response: FUNDAMENTAL CONDITIONS APPROACH to human rights
     -> three dimensions: autonomy | adaptability | interaction
     -> long-term: AGCI vs ACMI | control problem (3 strategies)

ETHICAL REASONING (U2)
  theory disagreement (deontology / utilitarianism / virtue ethics)
     -> so: LEARN ETHICS, DON'T PROGRAM THEORIES
     -> Railton: ethics as a DEEP FEATURE of general intelligence
     -> mechanism: default trust + default cooperation + theory of mind
     -> no phenomenology required (snows of yesteryear; corporate analogy)
     -> Kamm: STOP MISUSING THE TROLLEY PROBLEM (innocent threat cases)
     -> Bonnefon et al.: the ethical opt-out -> moral psychology
     -> Loreggia et al.: CP-nets + distance metric + shared thresholds
     -> Wolfram: an AI constitution (computational law)
     -> Asaro / O'Neil-Gunn: meaningful human control; ethical matrix

LONG-TERM & MORAL STATUS (U3)
  ALIGNMENT
     -> Russell: unary -> binary definition; provably beneficial AI; CIRL
     -> Taylor et al.: value specification vs. error tolerance; 8 topics
     -> Petersen: final values unlearnable; wireheading; miktoteleology
     -> Wallach & Vallor: value alignment commits the is/ought -> embodied virtue
  GOVERNANCE
     -> Bostrom, Dafoe & Flynn: vector field; efficiency/allocation/population/process
  CONSCIOUSNESS
     -> Schneider: ACT, IIT, Chip Test; AI zombies
  MORAL STATUS
     -> Schwitzgebel & Garza: No-Relevant-Difference; 4 design policies
     -> Liao: intrinsic + nonspeciesist + empirical; physical basis for moral agency
     -> rights via the FCA; a unique right to control subjective rate of time
     -> greater-than-human status: open, but not via more intelligence/agency
```

---

# HOW THE SYLLABUS MAPS ONTO LIAO'S CHAPTERS

| Syllabus unit & topic | Liao location | Coverage |
|---|---|---|
| **U1** Introduction to AI and intelligent systems | Introduction §I.1–I.2 | Full |
| **U1** Motivation for responsible AI | Introduction §I.3–I.5 | Full |
| **U1** Foundations / background of AI | Introduction §I.2 | Full |
| **U1** Autonomy | Introduction §I.5, §I.6; Ch. 1 | **Partial — Dignum's triad not in Liao** |
| **U1** Adaptability | Introduction §I.2 (ML as adaptive mechanism); §I.3 | **Partial — term not used in Liao** |
| **U1** Interaction | Introduction §I.4; Ch. 1 | **Partial — term not used in Liao** |
| **U2** Ethical decision-making in AI | Ch. 1, 2 | Full |
| **U2** Ethical theories | Introduction §I.3.5; Ch. 4 §4.3; Ch. 13 | Full |
| **U2** Values | Ch. 4 | Full |
| **U2** Ethics in practice | Ch. 3, 4 | Full |
| **U2** Implementing ethical reasoning | Ch. 1, 4, 5 | Full |
| **U2** Responsible research and innovation | Ch. 8 (near-term AI); Ch. 10 (long-term governance) | Partial — "RRI" as a term is not Liao's |
| **U2** Accountability | Ch. 3 (opt-out), Ch. 4 (thresholds), Ch. 7 (meaningful human control), Ch. 8 (stakeholders) | Full |
| **U2** Responsibility | Ch. 2 (Ambulance Case), Ch. 7 | Full |
| **U2** Transparency | Introduction §I.3.4; Ch. 3 §3.2; Ch. 4 §4.1.4; Ch. 8 (ethical matrix) | Full |
| **U2** Design for values | Ch. 4, Ch. 5, Ch. 8 | Full |
| **U3** Ethical action in AI systems | Ch. 1 (§1.5–1.7) | Full |
| **U3** Approaches to ethical reasoning by AI | Ch. 1, 4, 5, 11, 12, 13, 14 | Full |
| **U3** Designing artificial moral agents | Ch. 1, 4, 13; Ch. 17 §17.3 (AMI) | Full |
| **U3** Levels of ethical behaviour | Ch. 13 §13.2 (Moor; Allen/Smit/Wallach); Introduction (narrow/strong/weak) | Full |
| **U3** Ethical status of AI systems | Ch. 15, 16, 17 | Full |
| **U3** Alignment / trustworthy AI / moral machines / long-term ethics | Ch. 10, 11, 12, 13, 14 | Full |

**Also in the book but outside Units 1–3** (relevant if you revise the whole course): Ch. 6 (James, precautionary basic income — maps to your Unit V socio-economic impacts), Ch. 9 (Devlin, sex robots — maps to your Unit IV/V social impacts).

---

*End of notes.*
