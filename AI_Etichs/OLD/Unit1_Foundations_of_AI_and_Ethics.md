# Unit 1: Foundations of Artificial Intelligence and Ethics

> Course: AI Ethics and Sustainability (CIE734) | Texts: *Responsible Artificial Intelligence* — Virginia Dignum (Springer, 2019); *Ethics of Artificial Intelligence* — S. Matthew Liao (OUP, 2020)

---

## 1. Introduction to Artificial Intelligence and Intelligent Systems

### 1.1 What is AI?
There is **no single agreed definition** of AI. Definitions evolve along two axes:

| Dimension | Question Asked | Example Definition |
|---|---|---|
| **Thinking** (cognitive) | "Can machines think?" | Systems that engage in reasoning, problem-solving, learning (Turing) |
| **Behaviour** (acting) | "Can machines act intelligently?" | Systems that act rationally to achieve goals (Russell & Norvig) |

- **Turing Test (Imitation Game, 1950):** A machine is intelligent if a human interrogator, chatting with both a machine and a human through text, cannot reliably tell which is which.
- **Rational agent view (dominant in modern CS):** AI = the study of agents that perceive their environment and take actions that **maximize their expected utility/goal achievement**.

### 1.2 AI is NOT intelligence!
Dignum's key insight (from `ECSS2019_Dignum.md`): current AI is **pattern recognition + extrapolation + action**, not general intelligence.

**What AI systems CAN do (well):**
- Identify patterns in data (images, text, video)
- Extrapolate those patterns to new data
- Take actions based on those patterns

**What AI systems CANNOT do (yet):**
- Common-sense reasoning
- Understand context / understand meaning
- Learn from few examples
- Learn general concepts
- Combine learning and reasoning

> **Exam tip:** This "can vs. cannot" table is a favourite 5-mark question. Remember the trio: **Patterns → Extrapolate → Act** (what AI does) vs. **Common sense, Context, Few-shot, Concepts, Combine** (what AI lacks). Mnemonic for what AI lacks: **"3 C's + 2 F's"** — Common-sense, Context, Concepts, Few examples, combining learning & reasoning.

### 1.3 AI as a Socio-Technical System
Dignum's central claim: **AI is not just an algorithm, not just machine learning — it is a socio-technical system.**
- An AI system never operates alone; it is embedded in a web of **people, organizations, goals, laws, and physical infrastructure**.
- Consequences: responsibility cannot be assigned to the algorithm alone — **humans set the purpose**, therefore **"We are responsible!"**
- The system diagram: **Society ⇄ (Autonomy ⇄ AI system ⇄ Users/Stakeholders)**

> **Trick:** Whenever a question says "Who is responsible when AI harms someone?", start your answer with *"AI is a socio-technical system, not a standalone artefact"* — this framing itself earns marks because it shifts blame from machine to the human chain (developers, deployers, regulators).

---

## 2. Background & Foundations of AI (Historical Timeline)

| Era | Milestone | Why it matters |
|---|---|---|
| 1943 | McCulloch & Pitts neuron model | Mathematical model of a neuron |
| 1950 | Turing's "Computing Machinery and Intelligence" | Turing Test; "Can machines think?" |
| 1956 | **Dartmouth Workshop** (McCarthy, Minsky, Shannon) | Term "Artificial Intelligence" coined |
| 1956–74 | Golden years — Logic Theorist, GPS, ELIZA | Symbolic reasoning optimism |
| 1974–80 | **First AI Winter** | Funding collapse; overpromising (Perceptrons book, 1969) |
| 1980s | Expert systems boom (MYCIN, XCON) | Knowledge-based rules; Japan's Fifth Gen project |
| 1987–93 | **Second AI Winter** | Expert systems brittle & costly to maintain |
| 1997 | Deep Blue beats Kasparov | Brute-force search triumphs in chess |
| 2006 | Deep Learning revival (Hinton, DBNs) | Backprop at scale |
| 2012 | **AlexNet / ImageNet moment** | GPU + data + deep nets → computer vision revolution |
| 2016 | AlphaGo beats Lee Sedol | Reinforcement learning + search |
| 2017 | Transformer ("Attention Is All You Need") | Basis of GPT/LLM era |
| 2022+ | ChatGPT & generative AI | Foundation models; mainstream adoption |

**Three waves of AI (DARPA's framing — good for long answers):**
1. **Handcrafted knowledge** (rules, expert systems) — precise but brittle
2. **Statistical learning** (ML/DL today) — probabilistic, needs big data
3. **Contextual reasoning** (future) — human-like adaptation, explainability

---

## 3. Motivation for Responsible AI

### 3.1 Why do we need Responsible AI now?
- **Scale & speed:** Decisions affecting millions (credit, hiring, medical triage) are automated.
- **Opacity:** Deep models are black boxes; even designers cannot fully explain outputs.
- **Bias amplification:** Systems trained on historical data reproduce and scale historical discrimination (e.g., biased hiring data → biased CV-screening AI).
- **Feedback loops:** A predictive-policing system sends more patrols to an area → more recorded crime there → model becomes "more confident."
- **Autonomy & safety:** Self-driving cars, autonomous weapons.
- **Economic/power concentration:** A few companies control compute, data, and talent.

### 3.2 What is Responsible AI?
Dignum's four-part definition — **Responsible AI is AI that is:**

> **E**thical + **L**awful + **R**eliable + **B**eneficial

Responsible AI **recognises that AI systems are artefacts — we set the purpose — we are responsible!**

Core responsibility questions (memorize — they're exam gold):
- AI *can* potentially do a lot. **Should it?**
- **Who should decide?**
- **Which values** should be considered? **Whose values?**
- How do we deal with **dilemmas**?
- How should values be **prioritized**?

> **Trick:** Use these five questions as the skeleton for ANY essay-type answer on "motivation for responsible AI." Each question = one paragraph.

---

## 4. Core Properties of Intelligent Systems: Autonomy, Adaptability, Interaction

Dignum defines intelligent systems along three capability dimensions. **These three properties are the reason ethics enters the picture** — an inert tool with none of these properties raises few ethical questions.

### 4.1 Autonomy
- **Definition:** The capacity of a system to operate and make decisions **without constant human oversight**, selecting among alternatives to achieve goals.
- **Levels:** from low (thermostat) → medium (robo-advisors) → high (autonomous vehicles, weapons).
- **Two distinctions that examiners love:**
  - *Autonomy ≠ Independence*: an autonomous system is self-directed but still embedded in and dependent on its socio-technical context.
  - *Autonomy ≠ Automation*: automation repeats **predefined steps** deterministically; autonomy involves **choice among alternatives** in **uncertain situations**.
- **Why it matters ethically:** Who is responsible for an autonomous system's decision? More autonomy ⇒ more need for explicit ethical design (see Unit 3: moral agents).

### 4.2 Adaptability (Learning)
- **Definition:** The ability to **change behaviour based on experience/data** (machine learning).
- **Sources of adaptability:** training data, user interaction, feedback loops, environment shifts.
- **Why it matters ethically:**
  - **Behaviour drift:** the deployed system diverges from the tested/validated system.
  - Data quality/bias issues — learning from history reproduces history's injustices.
  - Difficult to certify/verify — you cannot test all future states of a system that keeps changing.

### 4.3 Interaction
- **Definition:** The capacity to **perceive and influence** other agents and the environment (users, other AI systems, institutions).
- **Why it matters ethically:**
  - **Manipulation & deception** (dark patterns, emotionally adaptive interfaces).
  - **Trust & expectations** — human-like interfaces (chatbots, robots) cause "mistaken identity", overtrust, vulnerable-user exploitation.
  - **Multi-agent effects** — individually safe agents may produce unsafe emergent group behaviour.

> **Mnemonic — "A-A-I"** (the three properties): *Autonomy* (self-governance), *Adaptability* (self-improvement), *Interaction* (self-embedding in society). Also mirrors the course name: AI!

> **Exam tip:** A classic question is "Explain how autonomy, adaptability and interaction in AI systems motivate the need for responsible AI." Structure: define each property → give an example system → state the ethical risk it creates → conclude that these properties make AI qualitatively different from classical software.

---

## 5. From Traditional Software Engineering to Responsible AI Engineering

| Aspect | Traditional SE | Responsible AI |
|---|---|---|
| Requirements | Functional + non-functional | **+ Values & norms** (fairness, privacy, human oversight) |
| Verification | Test against spec | Also validate against ethical principles & societal impact |
| Responsibility | Developer/organization | **Chain of actors** (researcher → developer → manufacturer → deployer → user → regulator) |
| Failure model | Bugs/crashes | Also *discriminatory outcomes, harm to fundamental rights, opacity* |
| Lifecycle | Ends at deployment | Continues post-deployment: **monitoring, auditing, redress** |

**Societal layers where AI acts (Dignum):** individual decisions → aggregates → social constructs (values, norms) — so AI's impacts occur at three levels: **individual, aggregate/group, and society**.

---

## 6. Quick Revision & Exam Strategy

### One-line definitions to memorize
- **AI (rationalist):** Study and construction of rational agents that maximize goal achievement through perception and action.
- **Socio-technical system:** A system whose behaviour emerges from the interaction of technical artefacts with people, organizations, and societal structures.
- **Responsible AI:** AI that is ethical, lawful, reliable and beneficial, developed so that humans remain accountable for its purpose and effects.

### Likely exam questions
1. Define AI. Explain why AI is considered a socio-technical system. (5–10 marks)
2. "AI is not intelligence." Critically comment with examples of what current AI can and cannot do.
3. Explain autonomy, adaptability and interaction as properties of intelligent systems and their ethical implications. **(most frequently asked)**
4. Distinguish automation vs. autonomy with examples.
5. Trace the history of AI with the two AI winters.
6. Why is responsible AI needed? Give real incidents (COMPAS recidivism bias, Amazon hiring tool, Tesla Autopilot crashes, Dutch childcare-benefits scandal).

### Tips & Tricks
- **Always name a real case study** in AI-ethics answers — COMPAS, Amazon's scrapped gender-biased hiring tool (2018), Microsoft's Tay (2016), Dutch *toeslagenaffaire* (2020, tax-authority bias), or GEICO/healthcare-cost discrimination. Cases convert a generic answer into a specific, high-scoring one.
- **Use the "can/cannot" contrast table** to demonstrate both knowledge and critical thinking.
- When short of content, expand on **feedback loops** (prediction → action → new data → stronger prediction) — an under-discussed point that examiners reward.
- Quote Dignum: *"AI can give answers, but we ask the questions."* — perfect closing line for essays.

---
*Sources: syllabus.txt (Unit I); ECSS2019_Dignum.md; ethics_of_ai_handbook.md (Weeks 1–2 context).*
