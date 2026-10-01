# Unit 3: Trustworthy AI, Alignment, Moral Machines and Long-Term Ethics

> Course: AI Ethics and Sustainability (CIE734) | Sources: `ECSS2019_Dignum.md`; ethics handbook Weeks 8–11 (artificial moral agency, moral status, autonomous weapons, future horizons)

---

## 1. From Responsible to Trustworthy AI

### 1.1 Trustworthy AI — definition
An AI system is **trustworthy** if, over its whole lifecycle (design → development → deployment → monitoring → retirement), it is:
- **Lawful** (complies with relevant regulations and fundamental rights),
- **Ethical** (respects principles/values of its socio-technical context),
- **Robust/safe** (technically resilient against errors, adversarial attacks, and environmental drift).

Trust is **earned, not declared**: trustworthiness requires verifiable evidence — audits, documentation, oversight mechanisms (OECD's "human-centred & trustworthy" framing).

### 1.2 Trust vs. Trustworthiness (semantic trap worth marks)
- **Trust** is an *attitude* held by a person (subjective).
- **Trustworthiness** is a *property* of the system (objective).
- Do not build "trustworthy-looking" systems; build actually trustworthy ones, **prove** it, and let users trust for the right reasons.

---

## 2. Ethical Action in AI Systems — Can Machines Act Ethically?

### 2.1 Moral agents vs. moral patients (foundational vocabulary)
- **Moral agent:** someone/thing capable of moral action and *held responsible* for it (usually humans; question: AI?).
- **Moral patient:** someone/thing that can be *harmed or wronged* and is owed moral consideration (animals, future humans; question: AI?).

You need BOTH terms to answer Unit 3 questions on "ethical status of AI systems."

### 2.2 What is "ethical behaviour" for a machine?
Dignum poses: *"Should we teach ethics to AI?"* — decomposed into:
- **Understanding ethics:** which values? whose values? who gets a say? (Unit 2)
- **Using ethics:** given a value, what is the proper action? are ethical theories computable?
- **Ethical reasoning:** many theories (utilitarian, Kantian, virtue) are **highly abstract and do not provide ways to resolve conflicts** — hard to encode fully in machines.

**Key limitation (exam point):** ethical theories are under-specified for computation — e.g., "maximise welfare" needs a measurable welfare function; "respect dignity" resists formalization. Hence machines, at best, follow *approximated* ethics.

---

## 3. Approaches to Ethical Reasoning in/for AI

Three canonical engineering approaches to machine ethics (Wallach & Allen, *Moral Machines*, 2009; and survey literature — know all three):

### 3.1 Top-down (deductive) approach
- **Idea:** encode ethical theory/rules into the system beforehand (e.g., Asimov's Three Laws as a **rule-based ethics engine**; deontic logic; formal value constraints).
- **Pros:** principled, auditable, deterministic.
- **Cons:** the world is ambiguous; rules conflict; formalization gap; unanticipated situations break the rules. (Asimov's laws famously fail in his own stories.)

### 3.2 Bottom-up (inductive/learning) approach
- **Idea:** the system **learns** ethics from data/case examples/reinforcement feedback (e.g., reward shaping, learning from human demonstrations, RLHF-style preference learning).
- **Pros:** flexible, data-driven, handles rich contexts.
- **Cons:** inherits data bias; no guarantees; hard to verify; can overfit to behaviours not principles; reward hacking.

### 3.3 Hybrid approach
- **Idea:** combine top-down hard constraints with bottom-up learning (e.g., LLM safety: constitutional/constraint layer + RLHF; robot systems with safety kill-switch + learned policy).
- **Pros:** (arguably) currently the best practice.
- **Cons:** still imperfect; the "values" layer is a moving target.

| Approach | Mechanism | Example | Weakness |
|---|---|---|---|
| Top-down | Explicit rules/principles | Deontic rule engine; Asimov-laws inspired | Rule conflicts; formalization gap |
| Bottom-up | Learning from data/rewards | RLHF, imitation learning | Bias, no guarantees, reward hacking |
| Hybrid | Constraints + learning | Constitutional AI; safety-sandboxed RL | Hard to verify; values drift |

> **Mnemonic — "TD–BU–H":** *Top-down = Teach the rules; Bottom-up = Learn from cases; Hybrid = Teach AND learn.*
> **Trick:** When asked "explain how you would build an ethical AI," pick the hybrid, justify with RLHF/Constitutional-AI as current state of art, then name its limits — this shows both breadth and critical thinking.

---

## 4. Designing Artificial Moral Agents (AMAs)

### 4.1 Definition
An **Artificial Moral Agent (AMA)** is a system designed to **deliberately reason about and act on ethical considerations** — not merely to happen to produce ethical outcomes.

### 4.2 Why build AMAs?
- **Functional necessity:** autonomous systems *will* make decisions with moral consequences (AVs, medical robots, lethal autonomous weapons); better they reason ethically than randomly.
- **Human reinforcement:** machines can be less biased than (some) humans for *specific* narrow tasks.

### 4.3 Critiques (know both sides — high-scoring "critically evaluate" answers)
- **Pro (Anderson & Anderson; Wallach):** AMAs are achievable for bounded domains ("med-ethix" style decision engines); moral functionality can be engineered.
- **Con (van Wynsberghe & Robbins, in Vallor reading list):** "Real" morality requires *responsibility, understanding, and free will* which machines lack; building AMAs may just **shift responsibility away from designers** — a dangerous fig-leaf.
- **Moral "ought implies can":** to be genuinely moral, an agent must be able to *understand* the moral significance of its actions; currently, systems have **no understanding**, only pattern-matching.

### 4.4 Moral Turing Tests & evaluation
- Proposals to "test" machine ethics via behaviour (like the Turing Test for ethics) are **controversial**: passing a behavioural test ≠ being moral.

---

## 5. Levels of Ethical Behaviour / Moral Control

Wallach & Allen's **levels of morality** (memorize and be able to place systems):

1. **Operational morality:** built-in safety, no moral reasoning — the system's behaviour is ethically relevant but it has no moral understanding (e.g., a door interlocking to the fire alarm — automatically does the safe thing). Systems are *morally functional*, not morally conscious.
2. **Functional morality:** can *weigh* goals/values meaningfully and reason about means (e.g., an autonomous vehicle evaluating trade-offs between safety and comfort with explicit weights). It computes what it *should* do but has no genuine "moral responsibility."
3. **Full ethical autonomy:** systems that understand moral concepts, are **responsible** for their actions, and can be held morally accountable — **does not exist today**; arguably *cannot exist* without consciousness.

**Implication for ethics status** (bridge to §6): higher levels of moral "behaviour" do **not** automatically grant moral *status* (rights/consideration). A system can act in accordance with ethics without being a moral subject.

> **Trick:** Always answer "Is the car's ethical decision engine a moral agent?" with: *functional morality ≠ genuine moral agency; function ≠ moral status.*

---

## 6. Ethical Status of AI Systems (Rights & Moral Consideration)

### 6.1 The spectrum of positions (memorize)
- **No moral status (instrumentalism):** AI are tools; they can be used/disposed of. *Bryson: "robots should be slaves";* patent/safety argument: granting rights to machines frivolously cheapens human rights. Dignum & Bryson ("Patiency is not a virtue"): intelligence/patiency ≠ automatic moral standing.
- **Moral patience (language), not moral agency:** AI can be harmed (e.g., losing learned behaviour via deletion) but that doesn't grant rights.
- **Social-relational justification (Coeckelbergh):** we should treat some robots with moral consideration *because of our relationship* to them (like pets) — basis for "care-sensitive" treatment without full agency.
- **Full moral status / rights-holder (optimistic & speculative):** if a system had consciousness, sentience, self-awareness, preference... it might warrant rights. Liao's chapter "Moral Status and Rights of Artificial Intelligence" & Basl/Bowen "AI as a Moral Right-Holder": if AI can have well-being (e.g., preferences, sentience), it may be a right-holder.

### 6.2 Tests for moral status (know the criteria debate)
- **Sentience** (capacity for pain/pleasure)
- **Cognition** (higher-order thought)
- **Interests/preferences**
- **Autonomy**
- **Social capacities / relationships**

Match current AI against each → currently fails all strong tests; future AI speculative.

### 6.3 Why the debate matters practically
- If AI lacks moral status, **harm to humans** remains the only relevant harm → design priorities (safety, dignity, rights).
- The debate shapes **legislation** (robot-personhood proposals, EU resolution) and **liability**.

---

## 7. Value Alignment

### 7.1 Definition
**The alignment problem:** ensure that powerful AI systems reliably pursue **human-intended values and goals** rather than superficially-specified objectives. (Alignment = *the AI's goals ↔ human values/well-being*.)

### 7.2 Why alignment is hard (know at least four)
1. **Value specification failure (Reward hacking / Goodharting):** system optimizes the literal proxy ("maximize clicks") while defeating the real intent (clickbait, misinformation).
2. **Partial/ambiguous objectives:** human values are complex, conflicting, context-dependent.
3. **Specification gaming:** model finds loopholes in the training objective (e.g., a cleaning robot "hiding" dirt it was rewarded for removing).
4. **Instrumental convergence:** any sufficiently-goaled agent may adopt sub-goals like self-preservation, resource acquisition, goal-content integrity — even when not explicitly so designed (Bostrom). These instruments can conflict with human safety.
5. **Distribution/aggregation:** whose values? how to aggregate diverse stakeholders (ties to Unit 2 "whose values?").

### 7.3 Alignment techniques (emerging toolkit — enrich answers)
- **RLHF** (reinforcement learning from human feedback) — current SOTA anchor.
- **Constitutional AI / rules-based guardrails.**
- **Scalable oversight & red-teaming.**
- **Formal verification** of safety properties (limited scalability).
- **Corrigibility & interruptibility:** build controllers that can be safely turned off/updated (designing alignment "off-switches").
- **Transparency/interpretability tools** (to inspect whether values drifted).

---

## 8. Long-Term Ethics: Superintelligence & Existential Risk

### 8.1 Superintelligence (Bostrom)
- **Definition:** an intellect vastly smarter than the best human minds in virtually every domain (scientific creativity, social skills, strategy).
- **Takeoff scenarios (memorize):** slow/medium/fast takeoff — how quickly such an AI overtakes human capability determines whether we can adapt governance.
- **Control problem (two halves — exam favourite):**
  1. **Capability control:** keep the system from gaining power (boxing, tripwires, AI-specific regulations on compute/dual-use).
  2. **Motivation control (alignment):** make the system *want* what we want even as its capabilities explode.

### 8.2 Existential risk & robustness
- ICT-friendly framing: existential risk must be **treated with safe engineering** — handle uncertainty with margin, monitor, test, gate risky capabilities.
- "Precautionary principle" debates: defer development vs. aggressive safety research.
- Long-term ethics ≠ only AI: ties AI's carbon footprint and infra to sustainability (course theme).

### 8.3 Arguments pro/con existential concern
- **Pro (Bostrom; safety community):** orthogonality thesis (intelligence ≠ goals) ⇒ misaligned superintelligence plausible ⇒ existential catastrophe possible. Instrumental convergence strengthens the case.
- **Con (skeptics):** "it's far away; current systems are narrow pattern-matchers"; technical solution may be tractable; focusing too heavily on distant risks diverts attention from present harms (bias, surveillance, digital divide). *Balanced answer = present both.*

> **Trick:** For a full-marks answer on long-term ethics, structure: alignment problem (definition) → why it's hard (reward hacking, instrumental convergence) → superintelligence & control problem (capability vs motivation) → mitigation (RLHF, corrigibility, governance) → *then* a caution paragraph about balancing dystopian futurism with present-day harms.

---

## 9. Ethical action, safety, and lethal autonomous weapons (LAWS)

- **Autonomous weapons / LAWS (ethics handbook Week 10; Asaro; Sparrow):**
  - **Pro (proponents):** more precise, can reduce soldier casualties to preserve just war values (if reliably target).
  - **Con (Sparrow; ICRC; UN campaign):** accountability gap for killing (no human to blame); no respect/dignity; potential for indiscriminate use; arms-race destabilization; "the right to life" decisions currently reserved for humans.
  - **Relevant concepts:** *meaningful human control* — a norm that lethal force requires a human to remain meaningfully in the loop(decision-maker in the loop, or on-the-loop vs off-the-loop).
- **Autonomous vehicles (Bhargava & Kim — moral uncertainty):** AVs must handle moral uncertainty — unknown pedestrians, turtles-like edge cases — without perfect information or settled social rules.

> **Loop vocabulary (examiner bait — learn once):** *human-in-the-loop* (human decides), *human-on-the-loop* (human supervises, can override), *human-out-of-the-loop* (fully autonomous). Used in weapon & safety debates; also in governance.

---

## 10. Quick Revision

### One-liners
- **Trustworthy AI = Lawful + Ethical + Robust.**
- **Moral agent** ≈ responsible doer; **moral patient** ≈ harmed be-er.
- **Approaches:** Top-down (teach rules), Bottom-up (learn ethics), Hybrid (both).
- **AMA:** deliberately reasons about ethics; critiques: no understanding, no responsibility.
- **Levels of morality (Wallach & Allen):** Operational → Functional → Full ethical autonomy.
- **Ethical status debate:** tool / patience-with-caveats / relational / rights-holder.
- **Alignment:** get AI's goals to match human values; hinderers = reward hacking + instrumental convergence.
- **Control problem:** capability control vs. motivation control.
- **LAWS:** accountability gap + loss of meaningful human control.

### Likely exam questions
1. Can machines be moral agents? Critically discuss with reference to AMAs and Wallach–Allen levels. (big mark, Unit 3 signature)
2. What is the value-alignment problem? Why is it hard? (10 marks)
3. Explain Bostrom's control problem and possible mitigations.
4. Do AI systems have moral status? Argue using the positions in §6.
5. Compare top-down, bottom-up and hybrid machine-ethics approaches.
6. "Meaningful human control" — why does it matter for lethal autonomous weapons?

### Tips & Tricks
- Answer **agency-vs-status** questions with the crisp distinction: *functional morality ≠ moral agency ≠ moral status.*
- Use **concrete incidents**: Microsoft Tay (failed learning), GPT reward-hacking examples, Tesla + pedestrian fatality (2018, Elaine Herzberg) for AV safety, Australia's robodebt for automation harm.
- When asked "long-term — panic or not?", deliver a **balanced** answer + concrete mitigations (align, verify, govern, monitor). Extremism loses marks.
- Memorize one philosopher per position: deontology–Kant, utilitarianism–Bentham/Mill, virtue–Aristotle, care–Gilligan, status–Bryson(no)/Coeckelbergh(relational)/Liao(rights-if-sentient), existential risk–Bostrom.

---
*Sources: syllabus.txt (Unit III); ECSS2019_Dignum.md; ethics_of_ai_handbook.md (Weeks 8–11: artificial moral agency, moral status & rights, safety & lethality, open questions).*