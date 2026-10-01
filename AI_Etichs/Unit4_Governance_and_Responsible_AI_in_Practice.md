# Unit 4: Governance and Responsible AI in Practice

> Course: AI Ethics and Sustainability (CIE734) | Sources: `ECSS2019_Dignum.md`; `ethics_of_ai_handbook.md` (Weeks 5–6: power, global inequality, justice, human rights); syllabus Unit IV

---

## 1. What is AI Governance?

### 1.1 Definition
**AI governance** = the set of structures, processes, laws, norms, oversight and accountability mechanisms that steer the development and deployment of AI so that it aligns with human values, fundamental rights and societal well-being.

Governance operates at **multiple levels simultaneously** (remember all five):

| Level | Examples |
|---|---|
| **International** | OECD AI Principles, UNESCO Recommendation on AI Ethics (193 countries, 2021), G7/G20 processes, UN Secretary-General's advisory body |
| **Regional/Supra-national** | **EU AI Act** (first comprehensive binding AI law), Council of Europe Convention |
| **National** | India (NITI Aayog Responsible AI strategy), US (Executive Orders, NIST AI RMF), China (generative-AI rules), UK (pro-innovation framework), Japan (AI Guidelines) |
| **Industry/Organisational** | corporate ethics boards, internal AI principles, model risk management |
| **Technical/Engineering** | standards (ISO/IEC 42001 AI management system), audits, model cards, red-teaming |

> **Mnemonic — "I-R-N-I-T":** *International, Regional, National, Industry, Technical* — five rungs of the governance ladder. Draw the ladder for a 5-mark diagram question.

### 1.2 Why governance now?
- AI is **general-purpose** (affects everything: jobs, credit, health, speech).
- **Opacity + scale + autonomy** outpace existing sectoral regulators.
- Incremental, *ex post* liability doesn't prevent irreversible harm.
- Gap between **endorsing principles** (everyone signed nice checklists!) and **actual compliance/verification** — Dignum's warning: *"endorsement is not (yet) compliance."*

---

## 2. Guaranteeing Responsible AI in Practice (operational layer)

### 2.1 How to make responsibility real (contrast with slogans)
Principles are necessary but not sufficient. The practice layer needs **concrete artefacts**:
- **Model Cards** (documentation of model performance, biases, intended uses, limitations).
- **Datasheets for Datasets** (documentation of data provenance, collection, cleaning, biases).
- **Algorithmic/AI Impact Assessments** (risk screening before deployment — ethical-matrix style).
- **AI audits** (independent, technical+governance, on-demand & continuous).
- **Red-teaming & stress-testing** (adversarial probing for safety/security).
- **Human-in-the-loop / oversight mechanisms** (escalation paths).
- **Grievance & redress channels** (right to contest automated decisions; GDPR Art.22).
- **Traceability/audit logs** (data → model → decision reproducibility).

### 2.2 The "regulation gap"
Dignum's slide: principles lists from IEEE, EU, OECD are *endorsed* everywhere but *adherence is not compliance* — no teeth, few registries, little auditing. → Governance must translate principles into **coercive, verifiable requirements**.

> **Exam point:** When asked "why write laws if we have principles?" answer with two words: **verifiability** and **enforceability**.

---

## 3. The EU AI Act — the flagship regulation (exam-critical)

First comprehensive AI law (passed 2024; phased application). Its **risk-based taxonomy** is the single most-cited governance model:

| Risk tier | Examples | Obligation |
|---|---|---|
| **Unacceptable** | social scoring; real-time biometric ID in public spaces; manipulative/subliminal techniques | **Prohibited** outright |
| **High** | CV-screening tools, credit scoring, medical devices, critical-infra, education, law enforcement | Strict requirements: risk management, **data governance**, **human oversight**, **transparency**, **robustness**, registration in EU database, **conformity assessment** |
| **Limited** | chatbots, deepfakes, emotion recognition | Transparency duties (inform users they interact with AI / content is AI-generated). |
| **Minimal/None** | games, spam filters | No additional obligations (voluntary codes) |

**Key terms to remember:** *risk-based approach; conformity assessment; fundamental-rights impact assessment (FRIA); general-purpose AI (foundation models) obligations; post-market monitoring.*

> **Trick:** For any question on "regulation designs," anchor on the EU AI Act risk pyramid and contrast with the US (sectoral, voluntary, NIST RMF) and China (state-centric, content-control). One paragraph per jurisdiction = complete comparative answer.

---

## 4. Codes of Conduct & Standards

### 4.1 Definition and purpose
Codes of conduct are **voluntary, principle-based commitments** by professional bodies, companies, or communities. Legally weaker than statutes but important for:
- cultural norm-setting;
- early practice while law lags;
- professional identity & training.

### 4.2 Canonical codes/guidelines (memorize short names + years)
- **IEEE Ethically Aligned Design (EAD)** — IEEE's multi-volume framework; asks *"How can we ensure AI systems do not infringe human rights?"*; key requirements: human rights paramount, promote human well-being, accountability, transparency.
- **OECD AI Principles (2019)** — *"human-centred values", "transparent and explainable", "robust, secure and safe", "accountability", "inclusive growth/sustainable development"*. First intergovernmental consensus.
- **EU HLEG Ethics Guidelines for Trustworthy AI (2019)** — the **7 requirements** (see box below) + assessment checklist.
- **Asilomar AI Principles (2017)** — research values, ethics & values, longer-term issues.
- **Montreal Declaration (2018)** — well-being, dignity, autonomy, democratic participation, sustainability, prudence, solidarity.
- **ACM Code of Ethics** — computing professional's duties.
- **UNESCO Recommendation (2021)** — global ethics standard, 193 states.

### 4.3 EU HLEG — the SEVEN requirements for Trustworthy AI (biggest single list to memorize)
1. **Human agency and oversight** — humans decide, can halt/override.
2. **Technical robustness and safety** — resilience, security, fallback.
3. **Privacy and data governance** — rights-respecting data practices.
4. **Transparency** — traceability, communication, explainability.
5. **Diversity, non-discrimination and fairness** — bias avoidance, accessibility, stakeholder participation.
6. **Societal and environmental well-being** — sustainability, social impact.
7. **Accountability** — auditability, reporting, redress.

> **Mnemonic — "H-T-P-T-D-S-A":** *Humans, Tech, Privacy, Transparency, Diversity, Society, Accountability.* (Or "**H**appy **T**eens **P**lay **T**en **D**eep **S**ports **A**t night".)

---

## 5. Inclusion and Diversity

### 5.1 Why inclusion matters in AI
- **Epistemic:** diverse teams surface problems homogenous teams blind to (e.g., face-recognition bias on darker skin tones — Buolamwini & Gebru pilot-parliaments study: error rates up to 34.7% for darker-skinned women vs 0.8% for lighter-skinned men).
- **Ethical:** design for values requires knowing *whose* values (§ Unit 2); excluded groups are the usual victims of "dehumanizing defaults".
- **Legal/business:** non-discrimination laws; reputational/brand risk; failure-cases like the *Dutch childcare-benefits scandal* (algorithmic false accusations of fraud).

### 5.2 Inclusion along the pipeline (responsible-AI-in-practice checklist)
- **Data:** representative datasets; collect participation from affected communities.
- **Team:** gender, race, disability, geography, discipline (CS + law + social science + philosophy).
- **Process:** participatory design; impact assessments with community stakeholders.
- **Deployment & evaluation:** disaggregated performance metrics (by group); continuous monitoring for disparate impact.

### 5.3 Global inequality angle (from ethics handbook Week 5 readings)
- **Decolonial AI (Mohamed, Png & Isaac):** calls out colonialism-shaped concentration of AI power; calls for situating AI in historic power relations.
- **Algorithmic colonization (Birhane):** Africa as data/compute hinterland; extraction without benefit-sharing.
- **Gebru on race & gender:** datasets and discipline embed white-centric defaults; need inclusive research norms.

> **Trick:** For a "why does diversity matter" question, produce the **error-rate numbers from the Gender Shades study** — a statistic beats ten adjectives.

---

## 6. The AI Narrative (media & discourse)

### 6.1 What is "the AI narrative"?
The **ways society tells the story of AI** — through media headlines ("AI will take your job", "AI will save humanity"), industry marketing, science fiction, and myth (Terminator vs. helpful Jarvis).

### 6.2 Why narrative matters for governance
- **Sets expectations** → modulates investment, public trust, and acceptance.
- **Hyperbole (hype)** → over-trust, fragile disappointment, policy panic.
- **Fear/doomerism** → over-regulation or fatalism; distracts from present harms.
- **Narrative asymmetry:** industry often amplifies both miracle stories and sci-fi doom to deflect regulation ("why regulate chatbots when there will be AGI?").
- **Empirical fact:** media coverage is *disproportionately* about dystopia/utopia far-future and *scant* on solid present-day trade-offs — skews public deliberation.

### 6.3 Responsible narrative practices
- **Honest communication** from developers (no overclaiming "human-like" for LLM chatbots).
- **Media literacy / science communication** education.
- **Epidemiological approach:** report *rates and comparisons* (errors across groups) not single-attempt theatre.
- **Demystification** in policy: governance debates anchored on *actual capabilities*.

> **Exam point:** "Discuss the role of the AI narrative" → four sub-points: expectations, trust, regulation-dynamics, media-focus skew + recommendation paragraph.

---

## 7. Governance mechanisms in a company (practical: "ensuring responsible AI in practice")
1. **Establish an AI ethics board / review committee** with real veto power.
2. **Adopt a written AI principle + code of conduct** (board-approved, publicly available).
3. **Run mandatory impact assessments** before every high-risk deployment (risk tiering).
4. **Document models & data** (model cards, datasheets).
5. **Independent audits** at least annually; red-team high-risk systems.
6. **Establish human-oversight & escalation channels**; log decisions.
7. **Transparent internal reporting** and **redress mechanism** for affected users.
8. **Continuously train staff** on ethics and re-assess post-deployment (behaviour drift, feedback loops).

---

## 8. Quick Revision

### One-liners
- **AI governance:** multi-level steering (I–R–N–I–T) of AI for values/rights.
- **Problem:** principles-endorsement ≠ compliance ⇒ need verifiable law.
- **EU AI Act:** risk tiers (unacceptable/high/limited/minimal) + conformity assessment.
- **Codes:** IEEE EAD, OECD Principles, EU HLEG-7, Asilomar, Montreal, UNESCO.
- **EU HLEG 7 requirements → mnemonic "HTPT-DSA".**
- **Inclusion:** epithinkingly, biases & error disparity; delegate-community participation.
- **Narrative:** hype/fear skews trust, regulation, and policy; report honestly.

### Likely exam questions
1. Compare EU AI Act, OECD principles and national approaches (India/US) as governance mechanisms. (10 marks)
2. Explain the seven requirements of Trustworthy AI with examples of how to implement each.
3. "Endorsing principles is not the same as compliance." Discuss with reference to codes of conduct.
4. Why are inclusion and diversity essential for responsible AI? Use the Gender-Shades study.
5. Explain how the media/AI-narrative influences public trust and regulation.
6. Design a responsible-AI governance framework for a company selling hiring tools.

### Tips & Tricks
- Draw the **EU AI Act risk pyramid** and the **governance ladder (IRNIT)** in diagram questions — diagrams save words and earn method marks.
- Anchor every governance argument in one named mechanism: *EU AI Act*, *OECD*, *UNESCO*, *NIST AI RMF*, *model cards*, *impact assessments*.
- Use the *Gender Shades* numbers and *Dutch childcare-benefits scandal* for inclusion/bias; Cambridge Analytica for transparency; the *AI Now* report themes as a framing device.
- For "company framework" questions, give the 8-step checklist (§7) and claim it can be audited — examiners reward operationalised answers.
- Remember the whisper of the whole course: **accountable, responsible, transparent** — governance is simply making ART enforceable at scale.

---
*Sources: syllabus.txt (Unit IV); ECSS2019_Dignum.md (ART, codes, regulation, certification); ethics_of_ai_handbook.md (Weeks 5–6: inequality, fairness, justice, human rights, governance readings).*