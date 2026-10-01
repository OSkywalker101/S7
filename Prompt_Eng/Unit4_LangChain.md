# Unit 4: LangChain — Building LLM Applications

> Course: Prompt Engineering for Generative AI (CI72) | Main source: *Prompt Engineering for Generative AI* — Phoenix & Taylor (O'Reilly) Ch.4 (extracted in `dokumen.pub_prompt-engineering-for-generative-ai-9781098153434.md`); plus `Large Language Models ConceptsAtkinson.md` (LangChain QA examples)

---

## 1. Introduction to LangChain

### 1.1 What is LangChain?
- **LangChain** = a versatile **framework for building LLM applications** (Python & TypeScript) that go beyond a single API call.
- Two central tenets (MEMORIZE):
  1. **Enhance data awareness** — seamlessly connect the language model to **external data sources**.
  2. **Enhance agency** — equip the model to **engage with and influence its environment** (call tools/APIs).

### 1.2 The six core modules (exam favourite — draw the module map)
| Module | Purpose |
|---|---|
| **Model I/O** | Handle input/output with models (prompts, chat models, parsers) |
| **Retrieval** | Retrieve relevant text for the LLM (vector stores, retrievers) |
| **Chains (Runnables)** | Construct sequences of LLM ops / function calls (`|`-pipelined) |
| **Agents** | Let chains **decide which tools to use** based on high-level directives |
| **Memory** | Persist state between runs of a chain (chat history) |
| **Callbacks** | Hook extra code onto events (e.g., each generated token, token counting) |

### 1.3 Setup
```bash
pip install langchain langchain-openai
```
- Requires a model-provider integration (`pip install openai`); use a virtual environment.
- **Security best practice:** put the API key in an environment variable (`OPENAI_API_KEY`) or `.env` file — never hardcode keys in scripts.

### 1.4 Why LangChain?
- **Model-agnostic**: consume OpenAI, Anthropic, Vertex AI, Bedrock, Mistral via one interface — no prompt/code rewrite when switching providers; rapid experimentation & evaluation.

---

## 2. Chat Models

- Chat models (e.g., GPT-4) exchange **messages**, not plain text.
- **Message types (LangChain schema):**
  - **SystemMessage** — instructions/behavioural guidance for the AI.
  - **HumanMessage** — user input (question/command).
  - **AIMessage** — model output (always the response type).
- **NOTE (Phoenix):** leverage **SystemMessage for the explicit instructions** — OpenAI fine-tuned GPT-4 to pay particular attention to guidance given in the system message.
- Example (joke generator):
```python
from langchain_openai.chat_models import ChatOpenAI
from langchain.schema import AIMessage, HumanMessage, SystemMessage
chat = ChatOpenAI(temperature=0.5)
messages = [SystemMessage(content="Act as a senior software engineer at a startup."),
            HumanMessage(content="Give a funny joke about software engineers.")]
response = chat.invoke(input=messages)
print(response.content)
```

### 2.1 Streaming Chat Models
```python
for chunk in chat.stream(messages):
    print(chunk.content, end="", flush=True)
```
- Tokens arrive sequentially (like ChatGPT's typewriter effect).
- **Benefits:** drastically lowers perceived latency & increases interactivity.
- **Challenge:** parsing/handling partially formed output streams.

### 2.2 Creating Multiple LLM Generations
```python
results = chat.batch([messages]*2)          # parallel request; list of message-lists
config  = RunnableConfig(max_concurrency=5) # cap concurrency
results = chat.batch([messages, messages], config=config)
```
- `.batch()` parallelizes API requests (good for dynamic content like social posts).
- **Async API:** `ainvoke`, `abatch` (prefix `a`) — run several requests concurrently, reduce latency in complex workflows.

---

## 3. LangChain Prompt Templates

- **Why templates?** — building **reproducible prompts** with parameters instead of hardcoded strings.
- vs f-strings, LangChain templates let you:
  - **validate inputs**, **compose prompts**, **inject k-shot examples** via custom selectors, **save/load prompts to/from .yml/.json**, **run extra code on creation** (custom templates).

### 3.1 PromptTemplate (classic)
```python
from langchain_core.prompts import PromptTemplate
prompt = PromptTemplate(template="You translate {input_language} to {output_language}.",
                        input_variables=["input_language","output_language"])
```

### 3.2 ChatPromptTemplate (with system message)
```python
from langchain_core.prompts import (SystemMessagePromptTemplate, ChatPromptTemplate)
template = "You are a creative consultant ... {principles} ... for the {industry} industry ... {context} ..."
system_prompt = SystemMessagePromptTemplate.from_template(template)
chat_prompt   = ChatPromptTemplate.from_messages([system_prompt])
```

### 3.3 Using PromptTemplate with Chat Models
```python
system_message_prompt = SystemMessagePromptTemplate(prompt=prompt)
chat.invoke(system_message_prompt.format_messages(input_language="English", output_language="French"))
```
- Produce well-formed message lists from parameterized templates — the standard chat-model pattern.

---

## 4. LangChain Expression Language (LCEL)

- **LCEL** chains components/runnables into pipelines using the **`|` operator** (like the Unix pipe).
- Output of one runnable → input of the next:
```python
chain = chat_prompt | model | StrOutputParser()
result = chain.invoke({"industry":"medical","context":"...","principles":"..."})
```
- `order matters`: `model | prompt` fails because the model output isn't a valid prompt input.
- `RunnablePassthrough()` passes data through unchanged (used for the user question in RAG, Unit V).
- LCEL is declarative, trivially testable, and supports `.invoke/.stream/.batch/.ainvoke/.abatch`.

---

## 5. Output Parsers

- High-level abstraction for turning the LLM's **free-text string into structured objects** (replaces hand-written regex).
- Available parsers (current list):
  - **List parser** — comma-separated items → list.
  - **Datetime parser** — parses output into datetime.
  - **Pydantic (JSON) / Structured output parsers** — validate output against a **schema** (returns dicts / typed objects).
- Usage: `PydanticOutputParser(...)` → attach via `| parser` at the end of the LCEL chain.
- Pair with **few-shot examples** written in the target format to reduce parse failures.

---

## 6. LangChain Evals

- **Evaluate LLM outputs** programmatically. Metrics/techniques:
  - **Embedding distance** — semantic similarity of output vs reference.
  - **String-distance metrics** (Levenshtein edits) — exactness.
  - **Pairwise comparisons** — use another LLM (or LLM-as-judge, e.g., comparing Mistral outputs) to rank outputs.
  - **Token counting** — `get_openai_callback()` measures usage/cost per run.
- Evals feed the **prompt optimization loop** (Unit III): generate variants → score → keep the best.

---

## 7. OpenAI Function Calling (and in LangChain)

### 7.1 Concept
- Alternative to output parsers: **fine-tuned models identify when a function must run** and return a **JSON response with the function name + arguments** (validated by a JSON schema).
- Use cases (MEMORIZE): building **sophisticated chatbots** (schedule meetings), **natural-language → API calls** ("Turn on hallway lights" → `control_device(device, action)`), **structured data extraction** (`extract_contextual_data(...)`).

### 7.2 The JSON schema "blueprint"
```json
{"type":"function","function":{"name":"schedule_meeting",
  "description":"…","parameters":{"type":"object",
   "properties":{"date":{"type":"string","format":"date"},
                 "time":{"type":"string","format":"time"},
                 "attendees":{"type":"array","items":{"type":"string"}}},
   "required":["date","time","attendees"]}}}
```
- **Tip (Phoenix):** always write a detailed schema (name + description) — it guides *when/how* the model invokes the function.

### 7.3 The calling loop
```
user msg → model(tools=functions) → model returns tool_calls
→ parse name+args → EXECUTE real function
→ append function result as role:"function" message
→ call model again → user-friendly summary
```
- In LangChain, `bind_tools`/`bind_functions` + `ToolNode`/`StructuredTool` wrap the same pattern; **parallel function calling** lets the model emit several tool calls in one response (run several tools concurrently).

---

## 8. Extracting Data, Query Planning & Few-Shot Templates

### 8.1 Extracting Data with LangChain
- Combine **function calling or structured output parsers (Pydantic)** with prompt templates to pull entities/fields from documents (e.g., `name`, `age`, `company` from text) into typed structures.

### 8.2 Query Planning
- Have the model **decompose a complex user query** into sub-queries / a plan (e.g., multiple searches, conditionals), then execute the plan (builds on chain-prompting / CoT from Unit III).

### 8.3 Creating Few-Shot Prompt Templates
- **k-shot / fixed-length examples:** inject a fixed set of example input→output pairs into the prompt.
- **Selecting few-shot examples by length:** `LengthBasedExampleSelector` — picks examples whose token length budget fits the remaining context (controls cost, avoids blowing the context window).
- **Limitations with few-shot examples (carry-over from Unit III):** context-window cost; anchoring/oversampling biases; overfit to example patterns. Selectors mitigate cost; realistic-balanced example sets mitigate bias.

---

## 9. Saving & Loading LLM Prompts

- Serialize prompt templates to **.yml / .json** (LangChain `save`/`load_prompt`) so prompts are **versionable, shareable, and reusable** across environments — a production prompt-engineering discipline.

---

## 10. Prompt Chaining (with LangChain)

- Chain multiple prompts/runnables: output of Prompt1 (| model | parser) feeds Prompt2 … (compose `LCEL` chains or `SequentialChain`).
- Use for **multi-stage generation** (outline → expand → edit) and for **verification passes** (generate → check). Ties directly to "chain prompting" (Unit III).
- `RunnableLambda` lets you run **arbitrary Python** between stages (e.g., format, clean, call non-LLM tools).

---

## 11. Memory in LangChain

- **Memory** = persisting state between chain runs (chat history) — the conversational "context".
- Memory types (MEMORIZE the family):
  - **ConversationBufferMemory** — store entire full history.
  - **ConversationBufferWindowMemory** — keep only the latest k turns (limits tokens).
  - **ConversationSummaryMemory** — LLM summarises old turns.
  - **ConversationSummaryBufferMemory** — keep recent turns verbatim until threshold, then summarize.
  - **ConversationTokenBufferMemory** — cap by **token count**, dropping/summarizing oldest.
- Select based on **token budget vs recall needs**.

---

## 12. Reasoning with Language Agents

- **Agent loop:** `next_action = agent.get_action(...)` → run it → observe → repeat until `AgentFinish`.
- **ReAct** (Reason + Act): CoT + tool actions + observations; loop until "Final Answer" or max iterations.
- **LangChain parts:** `AgentExecutor`, `initialize_agent(AgentType.…, tools, llm)`, `StructuredTool.from_function()`, `load_tools` (e.g., search, calculator, SQL, Google).
- **Tool/retriever/memory integration:** vector databases (Chroma/Weaviate) as memory, `RetrievalQA` for QA, `SelfQueryRetriever` for query understanding.
- **Advanced agent types (Phoenix):** `plan-and-execute` (plan ahead, then execute), **ToT-style agents** (Tree of Thoughts as agent strategy), **BabyAGI** (autonomous task-decomposition agent), **ReAct & Multiagent** patterns.
- **Callbacks** hook token streaming, **token counting** (`get_openai_callback`) and monitoring.

### Example (Atkinson — LangChain QA agent building blocks)
```python
from langchain.document_loaders.unstructured import ...
from langchain.text_splitter import CharacterTextSplitter
from langchain.embeddings import OpenAIEmbeddings
from langchain.vectorstores import Chroma
from langchain.chains import RetrievalQA
from langchain.chat_models import ChatOpenAI
# load → split → embed → Chroma store → RetrievalQA chain over the store
```
- Atkinson's worked case: **LangChain + SQL/Google search agents** generate step-by-step reasoning chains for high-level questions.

---

## 13. Quick Revision & Exam Strategy

### One-liners
- LangChain = data-aware + agency LLM apps; 6 modules (Model I/O, Retrieval, Chains, Agents, Memory, Callbacks).
- Messages: System / Human / AI; always put explicit instructions in the System message.
- LCEL: `prompt | model | parser` pipeline (`RunnablePassthrough`, `RunnableLambda`).
- Parsers: List / Datetime / Pydantic-structured; function calling returns name+args JSON via `tools=tools`.
- Few-shot templates + `LengthBasedExampleSelector` manage budget; save prompts to yml/json.
- Memory: Buffer / Window / Summary / SummaryBuffer / TokenBuffer.
- Agents: ReAct loop; plan-and-execute, ToT, callbacks, evals.

### Likely exam questions
1. Explain the six major modules of LangChain. (10 marks)
2. What are chat models and message types? Write a joke-generator snippet.
3. Explain LCEL with an example chain; why does `model | prompt` fail?
4. Output parsers vs OpenAI function calling; explain the JSON-schema blueprint and calling loop.
5. Explain few-shot prompt templates, length-based selection, and their limitations.
6. Explain memory types in LangChain with trade-offs.
7. Explain prompt chaining and how language agents (ReAct) reason.

### Tips & Tricks
- **Write real (minimal) code snippets** for each concept — the course link (`benman1` repo) expects hands-on; examiners reward compilable-looking code.
- Always mention **env-var API key** security hygiene and `get_openai_callback()` cost tracking.
- Link chains → Unit III (chain/CoT) and parsers → Unit III grammar sampling; memory/retriever → Unit V (RAG).
- For "function calling" explain the **full loop** (message→tool_calls→execute→function-message→summary), not just the schema.
- Distinguish open-source vector stores (FAISS, Chroma) from hosted ones (Pinecone, Weaviate) — introduces Unit V.

---
*Sources: syllabus.txt (Unit IV); dokumen.pub Ch.4 (LangChain/LCEL/function calling/evals/memory/agents); Large Language Models ConceptsAtkinson.md (LangChain QA agent examples).*