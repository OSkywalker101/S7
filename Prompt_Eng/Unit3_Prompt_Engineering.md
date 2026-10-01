# Unit 3: Prompt Engineering

> Course: Prompt Engineering for Generative AI (CI72) | Main text: *Prompt Engineering for LLMs* — Berryman & Ziegler (O'Reilly, 2025); *Prompt Engineering for Generative AI* — Phoenix & Taylor (O'Reilly, 2024) | Sources: `Prompt Engineering LLMsBerryman.md`, `dokumen.pub_prompt-engineering-for-generative-ai-9781098153434.md`

---

## 1. Introduction to Prompt Engineering

### 1.1 What is prompt engineering?
- **Prompt engineering** = the art & science of **crafting input text (prompts)** to reliably steer an LLM's output toward the desired behaviour, format, and quality.
- It is the *only* "programming" interface for a frozen LLM (remember: LLMs cannot be retrained per-task; the prompt **conditions** them at inference).
- Recall from Unit II: **GPT-3's in-context learning** showed that few-shot examples/tasks embedded in the prompt are enough — **no gradient updates**. Prompt engineering exploits exactly this.

> **Exam-ready definition:** *"Prompt engineering is designing, optimizing and iteration-testing the input (prompt) to a generative model so that its outputs are accurate, formatted, honest, and aligned with the task."*

### 1.2 Why it matters
- Same model + different prompts → wildly different outputs (marketing plan example of Phoenix: generic vs product-specific).
- Reduces hallucinations (Unit II), controls token cost, and implements applications without fine-tuning.

---

## 2. The Basic Ingredients of a Prompt (MEMORIZE)

A well-formed prompt usually contains (Berryman's — "Anatomy of the ideal prompt"):

1. **Instruction / task**: what to do (the verb-first sentence: "Summarize…", "Translate…", "Extract…").
2. **Context**: background, constraints, audience, tone, domain, examples.
3. **Input data / question**: the specific data the instruction should operate on.
4. **Output format**: explicit structure (list, JSON, headings, "answer in one sentence").
5. **Persona / role**: "Act as a senior software engineer…" (system message for chat models).
6. **(Optional) few-shot examples**: demonstrations of the desired input→output mapping.

```
Role:            "You are a helpful assistant…"
Instruction:     "Summarize the following text into exactly 3 bullet points."
Context:         "Target audience: non-technical executives."
Input:           "<the text>"
Output format:   "3 bullets, each ≤ 12 words."
```

> **⚠ Key principle from Phoenix:** *"Give direction and specify format"* — a prompt that states the role, the budget, the audience and the required format produces **contextualised, relevant output** (their CoT marketing-plan example).

### 2.1 Explicit vs implicit instructions
- **Explicit instructions** (normally in the **system message**): "Don't say 'I can't'; answer in Spanish…" — RLHF-trained models (GPT-4, Claude) are *trained to obey* these especially well.
- **Implicit instructions** = few-shot examples (the *format* teaches the model).
- Rules of thumb (Berryman §Preamble Instructions):
  - Put the most important instructions **early**;
  - be **specific and non-contradictory**;
  - one clear task per prompt;
  - language/format consistency (sloppy grammar begets sloppy output).

### 2.2 System vs user vs assistant messages (chat models)
- **SystemMessage:** high-level instructions/role (persistent, obeyed strongly).
- **HumanMessage:** user's request/question.
- **AIMessage:** model's response (fed back for multi-turn).
*(This is the trisichotomy used in LangChain — Unit IV.)*

---

## 3. Instruction-Based Prompting vs Advanced Prompting (evolution tree)

### 3.1 Instruction-based (zero-shot)
- A single instruction with no examples:
  *"Classify this review as positive or negative: 'Great phone!'"* → model does the task directly.
- Best when the task is **clear and simple**; cheap (less tokens).

### 3.2 Advanced prompt engineering — the arsenal
| Technique | What it does | When to use |
|---|---|---|
| **In-context learning / Few-shot** | Give 2–10 examples in the prompt | Format/style teaching; classification; open tasks |
| **Chain prompting** | Break the problem into a sequence of chained prompts | Complex multi-stage tasks |
| **Reasoning (CoT)** | Ask the model to "think step by step" before answering | Math/logic/multi-step reasoning |
| **Self-consistency** | Sample CoT several times, take the majority answer | Uncertain reasoning; risk mitigation |
| **Tree of Thoughts (ToT)** | Explore multiple reasoning branches + evaluate/backtrack | Search/planning problems (game of 24, crosswords, writing) |
| **Output verification** | Ask the model to check/validate its own output (or a checker model) | High-stakes outputs (JSON validity, factual claims) |
| **Constrained sampling / grammar** | Restrict the decoding to a valid grammar/format | Guaranteed-valid structured output (JSON, code) |

---

## 4. The Potential Complexity of a Prompt ("puzzles" & pitfalls)

- Prompts can be deceptively simple yet require **ambiguity resolution**; the model inherits **cognitive biases** from human-written text (Berryman):
  - **Anchoring** (first-mentioned option dominates);
  - **truth bias** (assertions accepted as true);
  - **example bias** (few-shot examples skew the answer).
- Preview risk: **argument hallucination** — the model invents inputs/claims for the arguments it "reasons" about.
- Hence: *clarify your question, provide background, and optimize* — prompt design is iterative.

---

## 5. Few-Shot Prompting / In-Context Learning — in depth (Berryman Ch.5)

### 5.1 Structure
```
Zero-shot:   [Instruction] + [Question]
Few-shot:    [Instruction] + [Example1] + [Example2] + … + [Question]
```
- The 2020 paper *"Language Models are Few-Shot Learners"* is the formative reference; RLHF models are particularly good at using few-shot examples.
- Great for teaching the **format and style** (e.g., outputting a JSON object, an email tone, a table).

### 5.2 Three drawbacks of few-shotting (exam favourite — memorize Berryman's three)
1. **Few-shot scales poorly with context:** every example consumes context-window tokens (and costs money); too many examples crowd out the real question.
2. **Few-shot biases the model toward the examples (anchoring/oversampling):** e.g., a classifier trained with 10 negative and 2 positive examples will over-predict negative; keep the example distribution realistic.
3. **Few-shot suggests spurious patterns:** models are pattern-matchers; repetitive examples teach *patterns*, some irrelevant — can actively mislead; over-fitting to example format.

### 5.3 Best practice
- Use few-shot when the **format** is important and the task is easy to exemplify; otherwise zero-shot + system message suffices.
- **Select examples by length / fixed-length example selection** (LangChain `LengthBasedExampleSelector`, `MaxMarginalRelevanceExampleSelector`) to control token budget.
- **Formatting examples** matters: consistent separators/keywords that the tokenizer handles cleanly.

---

## 6. Chain Prompting: Breaking Up the Problem (Phoenix)

- Decompose a hard task into a **sequence of smaller prompts**, each consuming the previous output:
  *"create an outline" → "expand section 1" → "draft the intro" → …*
- Benefits: more controllable output, smaller per-prompt context, easier verification per stage.
- Relation to **agents & ReAct**: iterative thought→action→observation loops (reasoning strategies below) formalize chaining with tool use (see also Unit IV LangChain prompt chaining).

---

## 7. Reasoning with Generative Models

### 7.1 Chain-of-Thought (CoT): *think before answering* (Phoenix)
- **CoT** guides the LLM to reason through a **series of steps / logical connections** before the final answer.
- Trigger phrase: **"step-by-step"** (clearly identified in Phoenix).
- Ineffective CoT: *"Create a marketing plan"* → generic 5-item list (no reasoning).
- Effective: give **budget, product type, target market** + "step-by-step plan…" → market research → branding → email marketing… (a *contextualised* reasoning chain).
- Empirical anchor: paper (Jan 2022) that showed few-shot examples demonstrating explicit reasoning **boost accuracy dramatically** (e.g., 55% → 65% on arithmetic across PaLM, possibly up to ~60% gains; Phoenix notes small CoT gains but big help on harder problems).
- Techniques: CoT may be invoked by (a) **explicit instruction** ("think step by step"), (b) **few-shot examples containing reasoning**, (c) special tokens in some models.

### 7.2 Self-Consistency: sampling outputs
- Instead of one CoT path, **sample several independent CoT outputs** (different temperatures/seeds) and take the **majority vote / most consistent answer**.
- Fixes the variance of reasoning paths; significantly improves math & common-sense accuracy.
- Cost trade-off: multiplies inference tokens (fits the "n-shot sampling" economy).

### 7.3 Tree of Thoughts (ToT): exploring intermediate steps (Phoenix)
- Beyond CoT's single linear path; the model explores **multiple reasoning trajectories (thoughts)**, **self-evaluates** each intermediate step, can **backtrack & revisit**, and plans forward.
- Use when **initial decisions are crucial** / search-like problems.
- **Data point to quote (strong):** on the Game of 24, GPT-4 + CoT = **4%** success; GPT-4 + ToT = **74%**. Also improves creative writing & mini-crosswords.
- LangChain implementation exists (sudoku wildcard example).

### 7.4 ReAct (Reason + Act) — agentic reasoning (Phoenix)
- Improvement over CoT: after reasoning, the model **takes an action via a tool**, then **observes** the result, and **thinks again** — looping until a *Final Answer* or max iterations.
- Thought loop: Observe → Interpret (thought) → Decide action → Act → repeat.
- Foundation for agents (Unit IV: reasoning with language agents).

---

## 8. Output Verification

### 8.1 Why verify?
- LLM outputs can be **well-formed but wrong**; tasks where "verifying a solution is much easier than producing one" (Berryman) benefit from verification.
- Verification = have the model (or a second pass/checker) evaluate its own answer against constraints.

### 8.2 Techniques
- **Grounding & self-check prompts:** "Verify the claims against the given context."
- **Structured validation:** parse output (regex, JSON schema, output parsers in LangChain) and re-prompt on failure ("Return only valid JSON with keys…").
- **Consistency checks:** cross-example agreement; LLM-as-judge (pairwise comparisons — LangChain evals), string-distance metrics (Levenshtein), embedding distance.
- **DSPy-style optimization:** programmatically optimize few-shot examples/instructions against a metric (Phoenix Ch~9 mentions Dspy tests combinations of instructions and few-shot examples).

---

## 9. Grammar: Constrained (Structured) Sampling

- Problem: to reliably emit **valid JSON / code / tables**, sampling from the full vocab often produces syntax errors.
- **Constrained sampling:** restrict the decoding **per step** to only the tokens that keep the output valid w.r.t. a target **grammar/schema** (e.g., a JSON schema).
- Implementations: **outlines**, **guidance**, **Llama.cpp grammars**, JSON-mode/function-calling of model providers; LangChain output parsers + `with_structured_output`.
- Benefit: guaranteed **format validity** (not content truth) → enables downstream parsing without error handling.

> **Trick (exam):** contrast Finetune-free guarantees:
> *Few-shot teaches format by example; output parsers reformat post-hoc; grammar-constrained decoding guarantees syntactic validity at generation time.*

---

## 10. Prompt Design and Optimization (the loop)

```
PROMPT   →  MODEL  →  OUTPUT
   ↑                      │
   └──── eval (metric) ≤──┘   iterate
```
Pipeline practice (Phoenix):
1. **Design**: ingredients (§2) + select technique (few-shot? CoT? ToT?).
2. **Prototype**: quick tests (Jupyter/LLM playground).
3. **Eval**: define metrics (accuracy, format-validity, embedding similarity, LLM-as-judge); run variants (e.g., zero-shot vs few-shot CSV experiments in the book).
4. **Optimize**: change instructions/examples/schedule; use **DSPy** style automated optimization; track **token costs**.
5. **Monitor**: log inputs/outputs, feedback (thumbs up/down → scores per variant — Phoenix's real experiment).

---

## 11. Quick Revision & Exam Strategy

### One-liners
- Prompt = instruction + context + input + output format (+ persona + examples).
- System message = obey-me instructions; few-shot = teach by example.
- Few-shot drawbacks: context cost, bias/anchoring, spurious patterns.
- CoT: "think step by step"; Self-consistency: vote over sampled reasonings; ToT: branch + backtrack (4%→74% on Game of 24); ReAct: reason + tool + observe.
- Verification: parse → validate → regenerate; grammar sampling guarantees format.
- Prompt optimization is an **empirical, iterative** loop with evaluation.

### Likely exam questions
1. What are the basic ingredients of a prompt? Give a template. (10 marks)
2. Explain zero-shot vs few-shot (in-context) prompting with the three drawbacks of few-shotting.
3. Explain chain-of-thought prompting; why "step-by-step"? Give the marketing-plan example.
4. Distinguish CoT, Self-Consistency and Tree-of-Thoughts (with the Game of 24 numbers).
5. What is output verification and how is it implemented?
6. Explain constrained/grammar-based sampling for guaranteed-format output.
7. How do you design & optimize prompts at scale (evals, DSPy-style, token cost)?

### Tips & Tricks
- **Quote the Game-of-24 numbers (4% vs 74%)** for ToT — a concrete number beats adjectives.
- For "ingredients" questions, always finish with a fully worked prompt template (§2) — examiners want to *see* the structure.
- Mention **RLHF obedience** (Unit II link) when discussing why system-message instructions work.
- For verification vs grammar: state the 3-layer ladder — *post-hoc parse (cheap), regeneration, grammar-constrained decode (guaranteed)*.
- Cross-link to Unit IV (LangChain templates, output parsers, evals, prompt chaining) — the assignments explicitly run these.
- Practice the promptingguide.ai basics (course link) — "model = f(prompt)" mental model.

---
*Sources: syllabus.txt (Unit III); Prompt Engineering LLMsBerryman.md (Ch.5 few-shot, anatomy, instructions); dokumen.pub (CoT, Agents/ReAct, ToT, evals, DSPy).*