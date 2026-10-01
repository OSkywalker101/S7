# Unit 2: Ethical Decision-Making, Responsibility and Design for Values

> Course: AI Ethics and Sustainability (CIE734) | Texts: *Responsible AI* — Dignum; *Ethics of AI* — Liao | Sources: `ECSS2019_Dignum.md`, `ethics_of_ai_handbook.md`

---

## 1. Ethical Decision-Making in AI

### 1.1 Why decisions by AI are ethically special
Human-made routine decisions and AI-made decisions differ in **scale, speed, opacity and irreversibility**:

| Feature | Human decision | AI decision |
|---|---|---|
| Scale | One decision at a time | Millions simultaneously (banking, insurance, recruitment) |
| Speed | Slow, deliberative | Instant, at real-time |
| Opacity | Can usually be explained | Often a **black box** |
| Bias | Individual human bias | **Institutionalized, mass-replicated bias** |
| Reversibility | Often revisable | May auto-execute (loans denied, benefits blocked) |

**Key concept — the ethical significance is in the socio-technical context** (Dignum): the same algorithm gives different ethical meaning in different deployment contexts. An algorithm is not good or bad in itself; *how it is designed, deployed, and governed* creates the ethics.

### 1.2 Levels at which AI ethics decisions occur
- **Design level:** choices of data, features, objectives, proxies.
- **Deployment level:** where and for whom the system is used.
- **Societal level:** aggregate effects on norms, fairness, distribution of power.

> **Exam hook:** "Explain the levels of ethical decision-making in AI using a real example (e.g., an AI recruitment tool)." Structure: dataset choice (design) → CV screening for a firm (deployment) → gender-profiling societal effect (societal).

---

## 2. Ethical Theories (Philosophical Foundations)

These are the **three classic normative moral theories** every ethics-of-AI chapter opens with. Examiners ask you to *apply* them to AI cases, not just define them.

### 2.1 Consequentialism / Utilitarianism
- **Core idea:** *The right action is the one that produces the greatest good for the greatest number.* Judge acts by **outcomes**.
- **Variants:**
  - *Act utilitarianism:* evaluate each individual act.
  - *Rule utilitarianism:* follow rules that maximize overall good in general.
- **In AI:** cost-benefit analysis of deployment; welfare-function optimization; autonomous-vehicle trolley-style decision (maximise lives saved).
- **Strengths:** intuitive for engineering; quantitative (expected utility).
- **Weaknesses (critical for exams):**
  - Hard to measure/quantify all costs (dignity, rights, long-term).
  - Can justify harming minorities ("for the greater good").
  - Ignores **distribution** — a total-happiness increase can hide deep inequality.

### 2.2 Deontology (Kant)
- **Core idea:** *Act according to rules/duties that can be universalised.* Rightness depends on **intent and duty, not outcomes**.
- **Kant's Categorical Imperative:** "Act only according to that maxim whereby you can at the same time will that it should become a universal law." Second formulation: *treat humanity always as an end, never merely as a means.*
- **In AI:** "People should never be reduced to data points"; require consent; ban deceptive/manipulative AI; no surveillance that violates dignity even if "beneficial".
- **Strengths:** protects rights, dignity; gives firm prohibitions.
- **Weaknesses:** rigid; cannot resolve conflicts between two duties (e.g., privacy vs security).

### 2.3 Virtue Ethics (Aristotle)
- **Core idea:** Focus on the **character of the agent** rather than acts or rules. *A good agent possesses virtues: honesty, care, prudence, justice.*
- **In AI:** shifts attention to the moral character of **developers and organizations** — are the builders honest, careful, accountable? (Dignum: ethics of the people behind the machine.)
- **Strengths:** captures professional ethics, training, culture.
- **Weaknesses:** vague about what to do in specific cases.

### 2.4 Other theories you must know for exam completeness
- **Ethics of Care:** responsibilities to particular others, relationality — relevant to care robots (social robots unit) and medical AI.
- **Contractarianism / Social contract:** fairness as agreement among equals — relevant to design for fairness and to policy.
- **Machine/formal ethics (Anderson & Anderson):** encoding moral principles so machines compute right action — bridge between philosophy and CS.

| Theory | Unit of evaluation | AI-applied question | Key weakness |
|---|---|---|---|
| Utilitarian | Outcomes / happiness | Which action maximises welfare? | Sacrifices minority rights |
| Deontological | Duty / rule | Which duty is violated? | Conflicting duties |
| Virtue ethics | Character | Are the builders virtuous? | Vague in concrete cases |
| Care ethics | Relationships | Are relationships honoured? | Applicability ambiguity |

> **Mnemonic — "UDVC":** **U**tilitarian → outcomes; **D**eontological → duty; **V**irtue → character; **C**are → relations. Think *"U D V C = Every Decision Views Consequences."*

> **Trick:** When asked "Which ethical theory applies to AI?" don't give one — give all three and show trade-offs. Examiners reward a *comparison table* (like above) plus one real case (e.g., the **Trolley Problem / moral dilemma of AVs**: utilitarian kills 1 to save 5; deontologist would not deliberately kill).

---

## 3. Values: Concept and Role in AI Ethics

### 3.1 What is a value?
A **value** is a general, abstract standard of desirability (e.g., fairness, privacy, dignity, autonomy, sustainability, transparency). Values are **not** the same as:
- **Norms:** concrete rules/prescriptions that operationalize values ("don't collect location data" is a norm serving privacy).
- **Preferences:** personal tastes (maverick choices need not be universal).

**Dignum's chain (memorize this pipeline):**

```
Societal values → (interpretation) → norms → (concretization) → functionalities (design choices)
```

Example: value **Fairness** → interpretation → norm *"equal outcome for equal merit"* → concretization → functionality *"drop gender-sensitive features, use calibrated thresholds"*.

### 3.2 Whose values? Which values?
Key questions from Dignum's lecture:
- Which values should be considered? **Whose values?**
- How should values be **prioritized** when they conflict?
- Who gets a **say** (stakeholder inclusion)?

**Value conflicts (recurring exam theme):**
- **Fairness vs. Accuracy** (add fairness constraints → lose predictive accuracy).
- **Privacy vs. Utility/Personalisation**.
- **Transparency vs. Security/IP** (explainability can leak proprietary logic or enable gaming).
- **Innovation vs. Precaution/Regulation**.
- **Efficiency vs. Sustainability** (compute-heavy models vs. carbon footprint).

### 3.3 Value Sensitive Design (VSD)
Friedman & Nissenbaum's **Value Sensitive Design** is the canonical framework — a tripartite method:
1. **Conceptual investigations:** what values are at stake; who are stakeholders (direct + indirect).
2. **Empirical investigations:** study real usage, stakeholder experiences.
3. **Technical investigations:** how do system properties/methods support or undermine values?

> **Trick:** Quote VSD whenever a question asks "how do we embed ethics in design?" VSD is +2 marks of framing credit.

### 3.4 Design for Values (Dignum's framing)
Dignum's "By Design" approach: **integration of ethical reasoning into the behaviour of artificial autonomous systems**.
- Contrast **"In Design"** (process-level ethics: build with responsibility) with **"By Design"** (artefact-level: the system itself reasons ethically) with **"For Design(ers)"** (institution-level: regulation, certification, research-integrity of researchers/developers). *(These three appear again in Unit 3 / Unit 4 — introduce them here.)*

---

## 4. Ethics in Practice & Implementing Ethical Reasoning

### 4.1 Ethics in practice
- **Moral dilemmas:** situations where values/rules conflict and no option satisfies all (Trolley Problem, the doctor-duty vs privacy).
- **Ethical Matrix (O'Neil & Gunn-Hanna, in Vallor handbook Week 3):** a tool to map affected stakeholders × ethically relevant principles (well-being, autonomy, fairness, privacy) — used to expose harms before deployment.
- **SHOULD question:** "AI can do a lot — but *should* it?" e.g., emotional analysis of vulnerable children; deepfake memorials; nudging.

### 4.2 Implementing ethical reasoning in systems — five steps (elaborate; exam-favourite)
1. **Elicit** values from stakeholders (who is affected? what do they value?).
2. **Define** the values/requirements unambiguously (operational definitions).
3. **Agree** priorities and conflict-resolution rules with stakeholders.
4. **Describe/report** decisions, assumptions, and trade-offs transparently.
5. **Evaluate** system behaviour continuously against the agreed principles (monitor, audit, redress).

Dignum calls this the **"Glass Box" approach**: "Doing the right thing" (explicit values/elicitation, described above) + "Doing it right" (explicit interpretation, principles, evaluation of in/out against principles) → *transparent, auditable, contestable AI*.

> **Contrast term — "Black Box":** opaque, unexplainable. **"Open Box"/"Glass Box":** transparent by design. Examiners love this black/glass-box contrast; memorise the two phrases *"Doing the right thing"* and *"Doing it right."*

---

## 5. Responsible Research and Innovation (RRI)

RRI = ensuring that research & innovation processes are ethically acceptable, socially desirable and sustainable **by anticipating** impacts as innovation proceeds.

**Four dimensions (Stilgoe/Owen — memorize as "ARIR"):**
- **A**nticipation: imagine possible futures, risks, misuses (scenario planning).
- **Refle**ctivity (Reflection): researchers reflect on their own values/assumptions and limits.
- **I**nclusion: involve diverse publics/stakeholders in governance.
- **R**esponsiveness: adapt direction of research in light of new knowledge/stakeholder feedback.

> **Mnemonic — "ARIR" = "A Responsible Innovation Rod":** **A**nticipation, **R**eflection, **I**nclusion, **R**esponsiveness.

**Exam point:** Contrast RRI (process governance of *research*) with Design for Values (embedding values in the *artefact*); both are upstream (early-stage) approaches vs. downstream audit/regulatory approaches.

---

## 6. Accountability (A of ART)

### 6.1 Definition
A system/actor is **accountable** if they can be called on to **explain and justify** their decisions and answer for consequences.

### 6.2 Requirements for accountability (Dignum)
- **Explanation and justification:** the ability to explain *why* a decision was made, in terms meaningful to affected people.
- **Design for values** (see §3): accountability must be designed in from the start.
- **Traceability / audit trail:** record of data, models, decisions.

### 6.3 "No AI without explanation"
- Explanation is **for the user** — different users need different explanations: *just-in-time, clear, concise, understandable, correct*.
- Explanation must cover: individual decisions **and** the big picture; overall strengths/weaknesses; how the system will behave in the future; and **how to correct the system's mistakes** (feedback/redress loop).

### 6.4 Trade-off question (Dignum's dilemma — likely exam question)
> "95% accurate but no explanation, or 80% accurate with explanation?" / "Fairness or sustainability?"
- **Answer structure:** it depends on **domain risk** (medical diagnosis: explainability non-negotiable; low-stakes recommendations: accuracy may win); on stakeholder needs; on regulatory requirements (GDPR Art.22 right to explanation). Emphasize that these are **false dichotomies** — often you can design for both with effort (glass-box).

---

## 7. Responsibility (R of ART)

### 7.1 Definition
Being responsible = being *held liable/judged* for one's choices and their consequences, including through legal liability.

### 7.2 Chain of responsibility (Dignum's key diagram)
A single decision by an AI system rests on **many actors**:
`researchers → developers → manufacturers → users → owners → deployers → governments/regulators`

- **Liability and conflict-settlement mechanisms** must be able to find the responsible actor along this chain.
- **The "responsibility gap" (also known as the "moral accountability gap"):** when no human plausibly controlled the harmful outcome (highly autonomous systems), accountability becomes ambiguous. Examiners love this phrase — use it.

### 7.3 Human-like AI and responsibility (from Dignum slides)
- Robots/chatbots/voice assistants are **human-like** → create **expectations**, target **vulnerable users**, cause **mistaken identity** (elderly users treating chatbots as companions; children chatting to toys).
- Who is responsible when a chatbot drives a vulnerable user to harm? (e.g., 2024 character-ai teen suicide case, Elizabeth Shoaf case) → companies, designers, deployers.

### 7.4 Human-centred responsibility
Dignum: *"AI can give answers, but we ask the questions."* Humans remain the locus of moral responsibility; systems have **no moral responsibility** in the legal sense (see Unit 3: moral status).

---

## 8. Transparency (T of ART)

**Three objects of transparency (memorize all three):**
1. **Data and processes** — what data, how collected, how processed (datasheets, data-provenance).
2. **Algorithms** — model architecture, logic, limitations (not necessarily full source; an understandable explanation suffices — *"transparency ≠ full disclosure"*).
3. **Choices and decisions** — how specific decisions were reached; who made the design choices.

**Explainability techniques (enrich your answer):** LIME & SHAP (post-hoc explanations); feature-attribution; attention visualization; model cards & datasheets for models (documentation); counterfactual explanations ("you'd have gotten the loan if income were €5k higher").

> **Trick:** Distinguish **transparency** (information about the system is available) from **explainability** (a particular decision is understandable) from **interpretability** (how the mechanics map inputs to outputs). Conflating these is the #1 student error; defining all three precisely earns easy marks.

---

## 9. The ART Framework (Accountability, Responsibility, Transparency) — Integrated

**"AI needs ART"** (memorize as the thesis of the whole unit):

> Responsible AI requires **A**ccountability (explanation & justification, design for values), **R**esponsibility (autonomy, chain of responsible actors, human-like-AI care), and **T**ransparency (data/processes, algorithms, choices).

Further, Dignum's full framing is **Responsible AI in/by/for Design**:
- **In Design:** development processes consider ethical & societal implications (process ethics).
- **By Design:** ethical reasoning embedded **in** the system's behaviour (product ethics).
- **For Design(ers):** research integrity, regulation, certification, codes of conduct of the people/institutions.

Apply ART to any case: e.g., facial recognition → **Accountability** (who owns and can explain a misidentification?), **Responsibility** (chain from vendor to police), **Transparency** (was deployment data disclosed?).

---

## 10. Quick Revision

### One-liners
- **Value:** abstract standard of desirability; **Norm:** concrete rule operationalizing a value.
- **VSD:** conceptual + empirical + technical investigations.
- **RRI = ARIR:** Anticipation, Reflection, Inclusion, Responsiveness.
- **Accountability:** explain & justify; **Responsibility:** liability along the chain; **Transparency:** data, algorithms, choices.
- **Glass box:** elicit → define → agree → describe → evaluate ("doing the right thing, doing it right").
- **Responsibility gap:** the absence of any human plausibly in control of an autonomous harm.

### Likely exam questions
1. Compare utilitarianism, deontology and virtue ethics and apply each to an autonomous-vehicle dilemma. (8–10 marks)
2. Explain the **ART** framework with a real-world AI example.
3. What is the "responsibility gap" and how can governance address it?
4. Explain Value Sensitive Design and the value→norm→function pipeline.
5. How does Responsible Research & Innovation (RRI) differ from Design for Values?
6. "Explainability is for the user." Discuss.
7. Value conflicts: fairness vs accuracy — how would you resolve?

### Tips & Tricks
- **Always produce a comparison table** when philosophers are asked — instant structure.
- Connect to **real AI incidents** for every principle (COMPAS for fairness, Cambridge Analytica for transparency, Tesla for accountability, Tay for responsibility).
- Close essays with Dignum's line: *"AI systems are artefacts — we set the purpose, we are responsible."*
- Remember ART applies at **three levels**: process (in design), product (by design), people/institutions (for designers).

---
*Sources: syllabus.txt (Unit II); ECSS2019_Dignum.md; ethics_of_ai_handbook.md (Weeks 3, 5–7 on fairness, values, discrimination, relationships).*