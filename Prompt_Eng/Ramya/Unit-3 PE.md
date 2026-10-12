Unit-3
Prompt Engineering
Dr.ANRamyaShree
Dept.ofCSE(AI&ML)

Syllabus
• Prompt Engineering: Introduction to Prompt Engineering , The Basic
Ingredients of a Prompt , Instruction-Based Prompting , Advanced
Prompt Engineering , The Potential Complexity of a Prompt , In-
Context Learning: Providing Examples , Chain Prompting: Breaking
up the Problem , Reasoning with Generative Models , Chain-of-
| Thought: | Think | Before |     | Answering | , Self-Consistency: | Sampling |
| -------- | ----- | ------ | --- | --------- | ------------------- | -------- |
Outputs, Tree-of-Thought: Exploring Intermediate Steps , Output
Verification , Providing Examples , Grammar: Constrained Sampling.
| Prompt | design | and | Optimization. |     |     |     |
| ------ | ------ | --- | ------------- | --- | --- | --- |

| Comparison | of Top | LLMs |
| ---------- | ------ | ---- |
https://lmarena.ai/?leaderboard

| • At       | their |     | core, |       |     | LLMs |     |     | are   | capable |     | of    | one |     | thing—    |     |
| ---------- | ----- | --- | ----- | ----- | --- | ---- | --- | --- | ----- | ------- | --- | ----- | --- | --- | --------- | --- |
| completing |       |     |       | text. |     |      | The |     | input | into    | the | model |     |     | is called |     |
the
| • Prompt—it |     |        |     | is       | a        | document, |      |           |     | or         | block    | of  | text,        |     | that     | we  |
| ----------- | --- | ------ | --- | -------- | -------- | --------- | ---- | --------- | --- | ---------- | -------- | --- | ------------ | --- | -------- | --- |
| expect      |     | the    |     | model    |          |           | to   | complete. |     |            | Prompt   |     | engineering, |     |          |     |
| then,       |     | in     | its | simplest |          |           |      | form,     |     | is the     | practice |     |              | of  | crafting |     |
| the         |     | prompt |     |          | so       |           | that |           | its | completion |          |     | contains     |     |          | the |
| information |     |        |     |          | required |           |      |           | to  | address    |          | the | problem      |     |          | at  |
hand.

| •   | Prompt |          | engineering |     |       |        |     | is  | the | process |     |     | of       | discovering |     |     | prompts |     |     |
| --- | ------ | -------- | ----------- | --- | ----- | ------ | --- | --- | --- | ------- | --- | --- | -------- | ----------- | --- | --- | ------- | --- | --- |
|     | that   | reliably |             |     | yield | useful |     |     | or  | desired |     |     | results. |             |     |     |         |     |     |
•
|     | A prompt    |     |     | is  | the  | input |     |       | you |     | provide, |     |         | typically |                | text, |     | when |     |
| --- | ----------- | --- | --- | --- | ---- | ----- | --- | ----- | --- | --- | -------- | --- | ------- | --------- | -------------- | ----- | --- | ---- | --- |
|     | interfacing |     |     |     | with | an    | AI  | model |     |     | like     |     | ChatGPT |           | or Midjourney. |       |     |      |     |
•
|     | The        | prompt |      |       | serves    |          | as  |           | a set |        | of  | instructions |             |     | the  | model    |     | uses |     |
| --- | ---------- | ------ | ---- | ----- | --------- | -------- | --- | --------- | ----- | ------ | --- | ------------ | ----------- | --- | ---- | -------- | --- | ---- | --- |
|     | to predict |        |      | the   | desired   |          |     | response. |       |        |     |              |             |     |      |          |     |      |     |
| •   | Text       | from   |      | large |           | language |     |           |       | models |     |              | (LLMs)      |     | like | ChatGPT, |     |      | or  |
|     | images     |        | from |       | diffusion |          |     | models    |       |        |     | like         | Midjourney. |     |      |          |     |      |     |

The Five Principles of Prompting
1.Give Direction
Describe the desired style in detail, or reference a relevant persona
2.Specify Format
Define what rules to follow, and the required structure of the response
3.Provide Examples
Insert a diverse set of test cases where the task was done correctly
4.Evaluate Quality
Identify errors and rate responses, testing what drives performance.
5.Divide Labor
Split tasks into multiple steps, chained together for complex goals

Prompt Engineering
• Prompt engineering is more than designing effective prompts.
• It can be used as a tool to evaluate the output of a model as well as to
design safeguards and safety mitigation methods.
• This is an iterative process of prompt optimization and requires
experimentation.
• There is not and unlikely will ever be a perfect prompt design.

The Basic Ingredients of a Prompt
• An LLM is a prediction machine.
• Based on a certain input, the prompt, it tries to predict the words that might follow it.
• At its core , the prompt does not need to be more than a few words to elicit a response from the LLM.

Two components of a basic instruction prompt
• we generally approach prompt engineering by asking a specific
question or task the LLM should complete.
• To elicit the desired response, we need a more structured prompt.

• More complex use cases might require more components in a prompt.
• For instance, to make sure the model only outputs “negative” or
“positive” we can introduce output indicators that help guide the
model.
• We prefix the sentence with “Text:” and add “Sentiment:”
• To prevent the model from generating a complete sentence. Instead,
this structure indicates that we expect either “negative” or “positive.”
• Although the model might not have been trained on these components
directly, it was fed enough instructions to be able to generalize to this
structure.

Instruction-Based Prompting
| • Although |     | prompting |     |     | comes | in many         |     | flavors, | from | discussing |          |
| ---------- | --- | --------- | --- | --- | ----- | --------------- | --- | -------- | ---- | ---------- | -------- |
| philosophy |     | with      |     | the | LLM   | to role-playing |     |          | with | your       | favorite |
superhero, prompting is often used to have the LLM answer a specific
| question |             | or resolve |     | a certain            | task. |     |            |     |     |     |     |
| -------- | ----------- | ---------- | --- | -------------------- | ----- | --- | ---------- | --- | --- | --- | --- |
| • This   | is referred |            | to  | as instruction-based |       |     | prompting. |     |     |     |     |

Specificity
• Accurately describe what you want to achieve. Instead of asking the LLM to
“Write a description for a product” ask it to “Write a description for a
| product |     | in less | than | two sentences |     | and | use | a formal | tone.” |
| ------- | --- | ------- | ---- | ------------- | --- | --- | --- | -------- | ------ |
Hallucination
• LLMs may generate incorrect information confidently, which is referred to as
hallucination. To reduce its impact, we can ask the LLM to only generate an
answer if it knows the answer. If it does not know the answer, it can respond
| with | “I don’t | know.” |     |     |     |     |     |     |     |
| ---- | -------- | ------ | --- | --- | --- | --- | --- | --- | --- |
Order
• Either begin or end your prompt with the instruction. Especially with long
| prompts, |     | information |     | in the | middle | is  | often | forgotten. |     |
| -------- | --- | ----------- | --- | ------ | ------ | --- | ----- | ---------- | --- |
• LLMs tend to focus on information either at the beginning of a prompt
| (primacy |     | effect) | or  | the end | of a prompt |     | (recency |     | effect). |
| -------- | --- | ------- | --- | ------- | ----------- | --- | -------- | --- | -------- |

| Concept | of  | Prompt | Engineering |     |     |     |
| ------- | --- | ------ | ----------- | --- | --- | --- |
Large Language
AI generated response
| User |     |     | Prompt/Input |     |     |     |
| ---- | --- | --- | ------------ | --- | --- | --- |
Model
|     |     | Prompt | is the      | input given   | to anAI |     |
| --- | --- | ------ | ----------- | ------------- | ------- | --- |
|     |     | model  | that guides | its response. |         |     |
 Prompt engineering is the process of designing effective inputs for LLMs.
|  Better | prompts | lead    | to better | responses. |     |     |
| -------- | ------- | ------- | --------- | ---------- | --- | --- |
| Aprompt  | may     | include |           |            |     |     |
•Instructions
•Questions
Example
•Context
|     |     | Summarize |     | this article | in five | bullet points. |
| --- | --- | --------- | --- | ------------ | ------- | -------------- |
•Constraints
•Examples

| Why | Prompts | Matter? |     |     |     |     |     |     |     |
| --- | ------- | ------- | --- | --- | --- | --- | --- | --- | --- |
The prompt tells the model whether to summarize, translate, explain, classify,
Define the task
|     |     | generate | code, | or answer | a question. |     |     |     |     |
| --- | --- | -------- | ----- | --------- | ----------- | --- | --- | --- | --- |
Provide context Additional background information helps the model understand the situation
|     |     | and produce | more | relevant | responses. |     |     |     |     |
| --- | --- | ----------- | ---- | -------- | ---------- | --- | --- | --- | --- |
Specify the
|     |     | Indicating | the intended |     | audience | allows | the model | to adjust | the |
| --- | --- | ---------- | ------------ | --- | -------- | ------ | --------- | --------- | --- |
audience
|     |     | complexity | and | terminology. |     |     |     |     |     |
| --- | --- | ---------- | --- | ------------ | --- | --- | --- | --- | --- |
The prompt can request bullet points, tables, JSON, code, or essays, making
| Control | the output |              |        |         |     |     |     |     |     |
| ------- | ---------- | ------------ | ------ | ------- | --- | --- | --- | --- | --- |
|         | format     | the response | easier | to use. |     |     |     |     |     |
Clear and specific instructions minimize misunderstandings and improve the
| Reduce | ambiguity |          |        |          |     |     |     |     |     |
| ------ | --------- | -------- | ------ | -------- | --- | --- | --- | --- | --- |
|        |           | accuracy | of the | response |     |     |     |     |     |

Prompts
| Characteristics | of Good | Prompts |             |     |               |     |          |
| --------------- | ------- | ------- | ----------- | --- | ------------- | --- | -------- |
| Clear           |         |         | Unambiguous |     | Goal-oriented |     | Specific |
Context-rich
Things to avoid:
Vague
|     | Missing | context |     | Multiple | unrelated | questions |     |
| --- | ------- | ------- | --- | -------- | --------- | --------- | --- |
instructions

Vague Prompt
|     | Explain |     | machine |     | learning. |     |     |     |     |     |     |
| --- | ------- | --- | ------- | --- | --------- | --- | --- | --- | --- | --- | --- |
Prompt:
Possible Response Machine learning is a branch of artificial intelligence that
| enables      |          | computers |             |           | to learn | from          | data   | without    |           | being     |      |
| ------------ | -------- | --------- | ----------- | --------- | -------- | ------------- | ------ | ---------- | --------- | --------- | ---- |
| explicitly   |          |           | programmed. |           |          | It includes   |        | supervised |           | learning, |      |
| unsupervised |          |           | learning,   |           |          | reinforcement |        | learning,  |           | and       | many |
| algorithms   |          |           | such        | as        | decision | trees,        | neural |            | networks, |           | and  |
| support      |          | vector    |             | machines. |          |               |        |            |           |           |      |
| The          | response |           | is          | broad     | and      | may           | be too |            | detailed  | or        | too  |
Issue:
| technical |     | for | the | intended |     | audience. |     |     |     |     |     |
| --------- | --- | --- | --- | -------- | --- | --------- | --- | --- | --- | --- | --- |

Specific Prompt
Explain machine learning to a first-year engineering student in 150 words. Use simple
Prompt:
| language, | include one |     | real-world |               | example |              |     |                  |            |     |       |
| --------- | ----------- | --- | ---------- | ------------- | ------- | ------------ | --- | ---------------- | ---------- | --- | ----- |
| Machine   | learning    | is  | a type     | of artificial |         | intelligence |     | that enables     | computers  | to  | learn |
| patterns  | from data   | and | make       | predictions   |         | without      |     | being explicitly | programmed |     | for   |
every task. For example, an email application can learn to identify spam messages by
analyzing thousands of previous emails.As it processes more data, it becomes better
Possible Response
| at distinguishing |     | spam | from | legitimate emails. |     |     |     |     |     |     |     |
| ----------------- | --- | ---- | ---- | ------------------ | --- | --- | --- | --- | --- | --- | --- |
Key Points
| Learns   | patterns        | from | data |            |            |     |                |     |          |           |     |
| -------- | --------------- | ---- | ---- | ---------- | ---------- | --- | -------------- | --- | -------- | --------- | --- |
| Improves | performance     |      | with | experience |            |     |                |     |          |           |     |
| Used     | in applications |      | such | as spam    | filtering, |     | recommendation |     | systems, | and image |     |
recognition
Why it's better: The response matches the audience, length, and format requested.

Techniques of Prompting
|  Zero shot  | Prompting |           |
| ------------ | --------- | --------- |
|  One shot   | Prompting |           |
|  Few shot   | prompting |           |
|  Chain of   | thoughts. |           |
|  Structured | Output    | Prompting |
 Role Prompting

| Zero | Shot | Prompting |     |     |     |     |     |     |     |     |
| ---- | ---- | --------- | --- | --- | --- | --- | --- | --- | --- | --- |
 Aprompting technique where a Large Language Model (LLM) performs a task without being provided with any examples.
 The model relies solely on the instructions in the prompt and its pre-trained knowledge to generate the response.
How it works
 No training examples are included in the prompt. The prompt contains only the task description or question.

| The model | infers | the required |     | output | based | on its | learned | knowledge. |     |     |
| --------- | ------ | ------------ | --- | ------ | ----- | ------ | ------- | ---------- | --- | --- |
Example
Prompt:
| Classify    | the sentiment |          | of  | the following |     | sentence      | as  | Positive,           | Negative, | or Neutral: |
| ----------- | ------------- | -------- | --- | ------------- | --- | ------------- | --- | ------------------- | --------- | ----------- |
| "The movie  | had           | stunning |     | visuals,      | but | the storyline |     | was disappointing." |           |             |
| LLM Output: |               |          |     |               |     |               |     |                     |           |             |
Negative
| (The model | correctly |     | identifies |     | the overall | sentiment |     | without | seeing | any prior  |
| ---------- | --------- | --- | ---------- | --- | ----------- | --------- | --- | ------- | ------ | ---------- |
examples.)

| One | Shot |     | Prompting |     |     |     |     |     |     |     |     |     |     |
| --- | ---- | --- | --------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
 One-shot prompting is a prompting technique where a Large Language Model (LLM) is provided with exactly one
| example | of  | the | task before |     | being | asked | to  | perform it | on  | a new | input. |     |     |
| ------- | --- | --- | ----------- | --- | ----- | ----- | --- | ---------- | --- | ----- | ------ | --- | --- |
 The single example helps the model understand the expected format and behavior.
How it works
|  Provide |         | one | input–output |            | example. |          |      |              |        |             |           |     |     |
| --------- | ------- | --- | ------------ | ---------- | -------- | -------- | ---- | ------------ | ------ | ----------- | --------- | --- | --- |
|  The     | model   |     | identifies   | the        | pattern  |          | from | the example. |        |             |           |     |     |
|  It      | applies |     | the same     | pattern to |          | the      | new  | input.       |        |             |           |     |     |
| Example   |         |     | Prompt:      |            |          |          |      |              |        |             |           |     |     |
|           |         |     | Sentence:    |            | "The     | customer |      | support      | was    | excellent." |           |     |     |
|           |         |     | Sentiment:   |            | Positive |          |      |              |        |             |           |     |     |
|           |         |     | Sentence:    |            | "The     | laptop   |      | battery      | drains | very        | quickly." |     |     |
Sentiment:
|     |     |     | LLM | Output: |     |     |     |     |     |     |     |     |     |
| --- | --- | --- | --- | ------- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
Negative
|     |     |     | (The | model   |     | learns    | the sentiment |            | classification |     | task from | a single | example |
| --- | --- | --- | ---- | ------- | --- | --------- | ------------- | ---------- | -------------- | --- | --------- | -------- | ------- |
|     |     |     | and  | applies |     | it to the | new           | sentence.) |                |     |           |          |         |

| Few | Shot | Prompting |     |     |     |     |     |     |     |
| --- | ---- | --------- | --- | --- | --- | --- | --- | --- | --- |
 Few-shot prompting is a prompting technique where a Large Language Model (LLM) is given a small number of input–
| output | examples | before |     | the actual | task. |     |     |     |     |
| ------ | -------- | ------ | --- | ---------- | ----- | --- | --- | --- | --- |
 These examples help the model understand the desired format, style, and reasoning pattern, leading to more accurate
responses.
How it works?
|  Provide | 2–5          | examples |      | demonstrating |      | the           | task.  |     |     |
| --------- | ------------ | -------- | ---- | ------------- | ---- | ------------- | ------ | --- | --- |
|  The     | model        | learns   | the  | pattern       | from | the examples. |        |     |     |
|  It      | then applies | the      | same | pattern       |      | to the new    | input. |     |     |
Example
Prompt:
|     |     | Sentence:  |     | "I absolutely |         | loved | the food."      |              |         |
| --- | --- | ---------- | --- | ------------- | ------- | ----- | --------------- | ------------ | ------- |
|     |     | Sentiment: |     | Positive      |         |       |                 |              |         |
|     |     | Sentence:  |     | "The          | service | was   | very slow."     |              |         |
|     |     | Sentiment: |     | Negative      |         |       |                 |              |         |
|     |     | Sentence:  |     | "The          | phone   | has a | good camera but | poor battery | life."  |
Sentiment:

| Applications |     |     | of zero-shot, |     | one-shot, |     | and | few-shot | prompting |
| ------------ | --- | --- | ------------- | --- | --------- | --- | --- | -------- | --------- |
 Text summarization
 Translation
|     | Zero Shot | prompting |     |             |          |     |     |     |     |
| --- | --------- | --------- | --- | ----------- | -------- | --- | --- | --- | --- |
|     |           |           |     |  Sentiment | analysis |     |     |     |     |
 Question answering
|     |          |           |     |  Grammar         | correction          |          |        |     |     |
| --- | -------- | --------- | --- | ----------------- | ------------------- | -------- | ------ | --- | --- |
|     |          |           |     |  Teaching        | a specific          | response | format |     |     |
|     | One shot | prompting |     |  Maintaining     | a writing           | style    |        |     |     |
|     |          |           |     |  Explaining      | custom              | labeling |        |     |     |
|     |          |           |     |  Generating      | structured          | outputs  |        |     |     |
|     |          |           |     |  Custom          | text classification |          |        |     |     |
|     |          |           |     |  Information     | extraction          |          |        |     |     |
|     | Few shot | prompting |     |                   |                     |          |        |     |     |
|     |          |           |     |  Domain-specific |                     | tasks    |        |     |     |

|     |     |     |     | Reasoning | tasks          |     |     |     |     |
| --- | --- | --- | --- | --------- | -------------- | --- | --- | --- | --- |
|     |     |     |     |  Intent  | classification |     |     |     |     |

| Chain-of- |     | Thought | (CoT) | Prompting |     |     |     |     |     |
| --------- | --- | ------- | ----- | --------- | --- | --- | --- | --- | --- |
 Chain-of-Thought (CoT) prompting is a technique in which the model is encouraged to reason through a problem
|     | step | by step before | producing | the final answer. |     |     |     |     |     |
| --- | ---- | -------------- | --------- | ----------------- | --- | --- | --- | --- | --- |
 Instead of giving only the answer, the model breaks the problem into intermediate reasoning steps, making it more
|     | accurate | for complex | reasoning, | mathematics, | logic, and | decision-making | tasks. |     |     |
| --- | -------- | ----------- | ---------- | ------------ | ---------- | --------------- | ------ | --- | --- |
LLM Response
Prompt
|     |       |                  |     |                  |     | Step 1: Cost | of 3 notebooks | =     | 3 × $5 = $15 |
| --- | ----- | ---------------- | --- | ---------------- | --- | ------------ | -------------- | ----- | ------------ |
|     | Ashop | sells a notebook | for | $5 and a pen for |     |              |                |       |              |
|     |       |                  |     |                  |     | Step 2: Cost | of 4 pens      | = 4 × | $2 = $8      |
$2.
|     |           |           |             |               |     | Step 3: Total | cost = | $15 + $8 | = $23 |
| --- | --------- | --------- | ----------- | ------------- | --- | ------------- | ------ | -------- | ----- |
|     | Acustomer | buys      | 3 notebooks | and 4 pens.   |     |               |        |          |       |
|     | Calculate | the total | cost. Think | step by step. |     |               |        |          |       |
|     |           |           |             |               |     | FinalAnswer:  | $23    |          |       |

Role Prompting
Role prompting is a technique where the Large Language Model (LLM) is assigned a specific role, profession, or
| persona | before answering |     | a question. |     |     |     |     |     |     |     |     |     |
| ------- | ---------------- | --- | ----------- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
By defining a role (e.g., teacher, doctor, software engineer, financial advisor), the model adapts its tone, level of
| detail, | vocabulary, | and | perspective | to suit that | role. |     |     |     |     |          |     |     |
| ------- | ----------- | --- | ----------- | ------------ | ----- | --- | --- | --- | --- | -------- | --- | --- |
|         |             |     |             |              |       |     |     |     | LLM | Response |     |     |
Prompt
|          |                    |             |         |           |     | Newton's | Second   | Law        | states that | the              | force | acting on an object |
| -------- | ------------------ | ----------- | ------- | --------- | --- | -------- | -------- | ---------- | ----------- | ---------------- | ----- | ------------------- |
| You      | are an experienced |             | physics | professor |     |          |          |            |             |                  |       |                     |
|          |                    |             |         |           |     | equals   | its mass | multiplied | by          | its acceleration |       | (F = ma).           |
| teaching | first-year         | engineering |         | students. |     |          |          |            |             |                  |       |                     |
Explain Newton's Second Law in simple For example, pushing an empty shopping cart is easier than
|          |        |           |          |     |     | pushing        | a fully | loaded | cart. The  | heavier | cart | has greater mass, |
| -------- | ------ | --------- | -------- | --- | --- | -------------- | ------- | ------ | ---------- | ------- | ---- | ----------------- |
| language | with a | real-life | example. |     |     |                |         |        |            |         |      |                   |
|          |        |           |          |     |     | so it requires | more    | force  | to achieve | the     | same | acceleration.     |

| Structured |     | Output |     | Prompting |     |     |
| ---------- | --- | ------ | --- | --------- | --- | --- |
Structured Output Prompting is a prompting technique where the user specifies the exact format in which the Large Language
| Model | (LLM) should | return its | response. |     |     |     |
| ----- | ------------ | ---------- | --------- | --- | --- | --- |
LLM Response
Prompt
| Extract    | the information | from the | paragraph |     | {              |                    |
| ---------- | --------------- | -------- | --------- | --- | -------------- | ------------------ |
| below      | and return      |          |           |     | "Name":        | "John Smith",      |
| the output | as a JSON       | object.  |           |     | "Company":     | "ABCTechnologies", |
|            |                 |          |           |     | "Designation": | "Data Scientist",  |
| Text:      |                 |          |           |     | "Experience":  | "5 years",         |
"John Smith is a Data Scientist atABC "Specialization": "Machine Learning"
Technologies. }

Applications of Prompt Engineering
 Content generation
 Data analysis
 Programming assistance
 Education
 Healthcare
 Customer support
 Research
 Document summarization
 Translation

Advanced Prompt Engineering
Prompting can grow complex quite quickly and as a result is an often-underestimated component of leveraging LLMs.
The Potential Complexity of a Prompt

In-Context Learning: Providing Examples
Zero-shot prompting does not leverage examples, one-shot prompts use a single example, and few-shot prompts use two
or more examples.

Chain Prompting: Breaking up the Problem
• Instead of breaking the problem within a prompt, we can do so between prompts.
• Essentially, we take the output of one prompt and use it as input for the next, thereby creating a
| continuous | chain | of interactions | that solves | our problem. |
| ---------- | ----- | --------------- | ----------- | ------------ |
• We get a sequential pipeline that first creates the product name, uses that with the product features as
input to create the slogan, and finally, uses the features, product name, and slogan to create the sales
pitch.
• This technique of chaining prompts allows the LLM to spend more time on each individual question
| instead | of tackling | the whole | problem. |     |
| ------- | ----------- | --------- | -------- | --- |

| Prompt |        | is   | not | same  |      | as  | Google |             | Search String |     |     |
| ------ | ------ | ---- | --- | ----- | ---- | --- | ------ | ----------- | ------------- | --- | --- |
|        | •Input | text | to  | these | LLMs | is  | known  | as “Prompt” |               |     |     |
•Keep in mind that the quality of the results you receive is directly
|     | proportional |     |         | to the | quality |     | of the | prompt     | you | provide. |         |
| --- | ------------ | --- | ------- | ------ | ------- | --- | ------ | ---------- | --- | -------- | ------- |
|     | •“Chat-GPT   |     | Prompt” |        | is      | NOT | same   | as “Google |     | Search   | String” |
•Consider the prompt not merely as a query but more as a conversation
|     | with | Chat | GPT. |     |     |     |     |     |     |     |     |
| --- | ---- | ---- | ---- | --- | --- | --- | --- | --- | --- | --- | --- |
•Instead of treating it like a Google search, think of it as a robotic
assistant that needs clear, specific information to assist you effectively.
•Avoid the brief, small queries or phrases typically used in Google
searches
|     | •You | need | to  | structure | your |     | prompt |     |     |     |     |
| --- | ---- | ---- | --- | --------- | ---- | --- | ------ | --- | --- | --- | --- |

Prompt Engineering - Meticulously designing a prompt
•The process of meticulously designing a prompt by incorporating
all essential information and relevant elements is termed 'prompt
engineering'.
•This involves not only the inclusion of specific instructions and
questions but also carefully considering the context, intended
tone, and any examples that might guide the model more
effectively.
•Effective prompt engineering also requires anticipating potential
ambiguities and refining the prompt to be as clear and concise
as possible.

| • This | is known | as zero-shot  |     |     |     |
| ------ | -------- | ------------- | --- | --- | --- |
prompting
| • Asking | the model | directly,    |         |         |                   |
| -------- | --------- | ------------ | ------- | ------- | ----------------- |
| without  | examples  | or structure |         |         |                   |
|          |           |              | Usually | results | in a very generic |
output

| Zero-Shot |     |     |     | prompt |     | - Examples |
| --------- | --- | --- | --- | ------ | --- | ---------- |
•E-Learning
| • What | is NLP?  |            |     |     |     |     |
| ------ | -------- | ---------- | --- | --- | --- | --- |
| • How  | to learn | Generative |     |     | AI? |     |
•Coding
| • Python  | basic   |       | examples |     |           |         |
| --------- | ------- | ----- | -------- | --- | --------- | ------- |
| •Personal | Finance |       |          |     |           |         |
| • How     | to earn | money |          | in  | the stock | market? |
•Health
| • What | is a good |     | diet | plan? |     |     |
| ------ | --------- | --- | ---- | ----- | --- | --- |
•Business
| • Write | a deadline |     | extension |     | mail | to my client. |
| ------- | ---------- | --- | --------- | --- | ---- | ------------- |
•Literature
| • Write | a poem | for | my  | teacher |     |     |
| ------- | ------ | --- | --- | ------- | --- | --- |

| Zero-Shot |     | prompt |     | -   | Issues |     |     |
| --------- | --- | ------ | --- | --- | ------ | --- | --- |
•E-Learning
• Explain to me - NLP? - ChatGPT doesn’t know whether you are a beginner or an expert
| • How | to learn | Generative | AI? |     |     |     |     |
| ----- | -------- | ---------- | --- | --- | --- | --- | --- |
•Coding
• Python basic examples –is it for a developer and data scientist?
| •Personal | Finance |     |     |     |     |     |     |
| --------- | ------- | --- | --- | --- | --- | --- | --- |
• How to earn money in the stock market? – Very generic request
•Health
| • What | is a good | diet | plan? | – Depends | on Gender, | Location, | Age |
| ------ | --------- | ---- | ----- | --------- | ---------- | --------- | --- |
•Business
| • Write | a deadline | extension |     | mail to | my client. |     |     |
| ------- | ---------- | --------- | --- | ------- | ---------- | --- | --- |
•Literature
| • Write | a poem | for my | teacher |     |     |     |     |
| ------- | ------ | ------ | ------- | --- | --- | --- | --- |

| Structuring |                |     |     |              | the         |     | prompt |          |            |        | –        | 5   | Elements    |       |         |
| ----------- | -------------- | --- | --- | ------------ | ----------- | --- | ------ | -------- | ---------- | ------ | -------- | --- | ----------- | ----- | ------- |
|             | 1. Roleplaying |     |     |              | : Character |     |        | Insight/ |            |        | Persona/ |     |             | Field | Expert! |
|             | • Ask Chat     |     | GPT | to           | take        | the | role   | as       | an         | expert |          |     |             |       |         |
|             | 2. Examples    |     |     | : Exceptions |             |     |        | /        | Inclusions |        |          | and | Exclusions! |       |         |
• Give some examples of what need to be included and excluded
|     | 3. Domain |     | and     |     | the | Context   |     |     | : Background |            |     |     | /   | Setup/    | Context! |
| --- | --------- | --- | ------- | --- | --- | --------- | --- | --- | ------------ | ---------- | --- | --- | --- | --------- | -------- |
|     | • Explain | the | context |     |     | in depth, |     | set | the          | background |     |     |     | carefully |          |
4. Display of the output: Size, Structure, and Format of the output!
• Do you want the output in a tabular format or bullet points or code format
|     | 5. Iterations: |     |     | Refinements/ |     |     |     |     | Regenerations |     |     |     | /   | Improvements |     |
| --- | -------------- | --- | --- | ------------ | --- | --- | --- | --- | ------------- | --- | --- | --- | --- | ------------ | --- |
• Iteration for refining the AI's response to align more closely with the specific requirements

| Roleplaying |     | : Character |     |     | Insight/ |     | Persona/ Field |
| ----------- | --- | ----------- | --- | --- | -------- | --- | -------------- |
Expert!
|     | •Instruct | ChatGPT | to step | into | the shoes | of  | an expert. |
| --- | --------- | ------- | ------- | ---- | --------- | --- | ---------- |
•For instance, if your query pertains to coding, request that ChatGPT
immerse itself in the role of a seasoned software engineer with a
|     | decade | of experience. |     |     |     |     |     |
| --- | ------ | -------------- | --- | --- | --- | --- | --- |
•Similarly, if you seek advice on a diet plan, prompt ChatGPT to
|     | embody | the expertise |     | of a certified |     | nutritionist. |     |
| --- | ------ | ------------- | --- | -------------- | --- | ------------- | --- |

| Roleplaying |     | : Character |     | Insight/ | Persona/ Field |
| ----------- | --- | ----------- | --- | -------- | -------------- |
Expert!
| Basic | Prompts | After | adding | Roleplaying | part |
| ----- | ------- | ----- | ------ | ----------- | ---- |
Explain to me - NLP? Put yourself in the shoes of an NLP expert with extensive experience
|     |     | and provide | me  | with an explanation | of NLP. |
| --- | --- | ----------- | --- | ------------------- | ------- |
How to learn  Imagine you are an expert in GenerativeAI and related fields with
Generative AI? extensive knowledge. Share insights on how one can effectively learn
|     |     | Generative | AI. |     |     |
| --- | --- | ---------- | --- | --- | --- |
Python basic examples Put yourself in the shoes of a seasoned Python developer with
extensive knowledge. Share some foundational Python examples that
are essential for beginners to grasp the language effectively.

LAB: Roleplaying
| Basic | Prompts   |      | After | adding | Roleplaying | part |
| ----- | --------- | ---- | ----- | ------ | ----------- | ---- |
| What  | is a good | diet |       |        |             |      |
plan?
| Write     | a deadline  |        |     |     |     |     |
| --------- | ----------- | ------ | --- | --- | --- | --- |
| extension | mail        | to my  |     |     |     |     |
client.
| How | to earn money | in  |     |     |     |     |
| --- | ------------- | --- | --- | --- | --- | --- |
| the | stock market? |     |     |     |     |     |

LAB: Roleplaying
| Basic | Prompts | After | adding | Roleplaying | part |     |     |     |
| ----- | ------- | ----- | ------ | ----------- | ---- | --- | --- | --- |
What is a good diet Imagine you are a certified nutritionist with extensive expertise.
plan? Provide personalized guidance on what constitutes a highly effective
|     |     | and tailored | diet | plan |     |     |     |     |
| --- | --- | ------------ | ---- | ---- | --- | --- | --- | --- |
Write a deadline  Imagine you are a seasoned business communication expert with years
extension mail to my  of experience. Craft a professional and persuasive email to request a
| client. |     | deadline | extension | from | your client |     |     |     |
| ------- | --- | -------- | --------- | ---- | ----------- | --- | --- | --- |
How to earn money in  Imagine you are an experienced stock market expert with a proven
the stock market? track record. Provide valuable insights and strategies on how
|     |     | individuals | can | effectively | earn money | in the | stock | market. |
| --- | --- | ----------- | --- | ----------- | ---------- | ------ | ----- | ------- |

| Include | some |     | Examples |     |     |
| ------- | ---- | --- | -------- | --- | --- |
•Demonstrate to the ChatGPT a few examples as inputs and instruct it
| to use | these | examples | as a guide | to respond | to questions. |
| ------ | ----- | -------- | ---------- | ---------- | ------------- |
•This process, known as few-shot prompting, involves supplying the AI with a
limited number of examples or "shots" that illustrate the task you want it to
perform.
•Through this approach, the AI learns and adapts based on these
examples.
•For example, if we give two examples of the customer feedback and classify
them as positive or negative, the third example will be automatically
| classified | by  | ChatGPT |     |     |     |
| ---------- | --- | ------- | --- | --- | --- |

| Include |     | some | Examples |     | = few-shot  |
| ------- | --- | ---- | -------- | --- | ----------- |
prompting
Input- Overall okay. Biriyani was not as good. The rest of the items were good.
Kadai paneer we found it to be too high a price for the quantity served.
|     | Ambiance | is nice |     |     |     |
| --- | -------- | ------- | --- | --- | --- |
Two examples(shots) are
|     | Output | - Positive | - High | Price |     |
| --- | ------ | ---------- | ------ | ----- | --- |
given to chatGPT
Input- There's no menu card. staff to say the menu card so that the customer
feels uncomfortable asking for everything. Overall taste wise just average and
|     | overhyped | and on     | overpriced. |            |     |
| --- | --------- | ---------- | ----------- | ---------- | --- |
|     | Output    | - Negative | - Menu      | Card issue |     |
Input- I never leave this place disappointed. All the dishes are good and well
served. The staff is attentive and suggests good menu options
|     | What | is the Output | ?   |     |     |
| --- | ---- | ------------- | --- | --- | --- |

| Include | some | Examples |
| ------- | ---- | -------- |

|     | Few | Shots |     | - Example |     |     |     |     |
| --- | --- | ----- | --- | --------- | --- | --- | --- | --- |
1. Burger
Harmful Substances: Trans fats, high sodium, refined carbs, artificial flavors.
Average Calories: 300 - 600 calories (depending on size and ingredients)
|     | Steps   | to Burn:    | Steps | required: |          | 7,500       | - 15,000 | steps.        |
| --- | ------- | ----------- | ----- | --------- | -------- | ----------- | -------- | ------------- |
| 2.  | French  | Fries       |       |           |          |             |          |               |
|     | Harmful | Substances: |       | Trans     | fats,    | acrylamide, |          | high sodium.  |
|     | Average | Calories:   |       | 300 - 400 | calories |             | (medium  | serving)      |
|     | Steps   | to Burn:    | Steps | required: |          | 7,500       | - 10,000 | steps.        |
3. Pizza
| 4.  | Fried Chicken |            |        |     |     |     |     |     |
| --- | ------------- | ---------- | ------ | --- | --- | --- | --- | --- |
| 5.  | Sugary        | Soft Drink |        |     |     |     |     |     |
| 6.  | Potato Chips  |            |        |     |     |     |     |     |
| 7.  | Ice Cream     |            |        |     |     |     |     |     |
| 8.  | Deep Oil      | fried      | Samosa |     |     |     |     |     |

| Few | Shots | - Example |
| --- | ----- | --------- |

| LAB | -        | Few       | Shots  |            |          |        |        |
| --- | -------- | --------- | ------ | ---------- | -------- | ------ | ------ |
|     | Complete | the       | below  | workout    | plan for | 6 days | a week |
|     | Day-1:   | Chest     |        |            |          |        |        |
|     | Push-Ups | -         | 2 Sets | - 15 reps  |          |        |        |
|     | Chest    | Flyes     | - 2    | Sets - 15  | reps     |        |        |
|     | Bench    | Press     | - 2    | sets - 15  | reps     |        |        |
|     | Day-2:   | Shoulders |        |            |          |        |        |

| LAB | - Few         |           | Shots       |          |     |
| --- | ------------- | --------- | ----------- | -------- | --- |
|     | Complete      | the below | workout     | plan for | 6   |
|     | days a        | week      |             |          |     |
|     | Day-1:        | Chest     |             |          |     |
|     | Push-Ups      | - 2 Sets  | - 15 reps   |          |     |
|     | Chest Flyes   | -         | 2 Sets - 15 | reps     |     |
|     | Bench Press - |           | 2 sets - 15 | reps     |     |
|     | Day-2:        | Shoulders |             |          |     |

| Domain |              |           |            | and |           | Context  |        |      |
| ------ | ------------ | --------- | ---------- | --- | --------- | -------- | ------ | ---- |
|        | Put yourself |           |            | in  | the       | shoes    | of     | a    |
|        | seasoned     |           | Python     |     | developer |          | with   |      |
|        | extensive    |           | knowledge. |     |           | Give     | me     | the  |
|        | learning     |           | path       |     | for       | becoming |        | a    |
|        | Python       | developer |            |     |           | in five  | short  |      |
steps

| Domain |              |     |            | and       |        | Context |       |         |     |
| ------ | ------------ | --- | ---------- | --------- | ------ | ------- | ----- | ------- | --- |
|        | Put yourself |     |            | in        | the    | shoes   |       | of a    |     |
|        | seasoned     |     | Data       | Scientist |        |         | with  |         |     |
|        | extensive    |     | knowledge. |           |        | Give    |       | me the  |     |
|        | learning     |     | path       | for       | Python |         | to    |         |     |
|        | become       | a   | data       | scientist |        |         | in    | five    |     |
steps
|     |     |     |     |     |     | Compare |     | this output     | with the  |
| --- | --- | --- | --- | --- | --- | ------- | --- | --------------- | --------- |
|     |     |     |     |     |     |         |     | previous output |           |

| Domain |     |     | and  |     |     |     |     |     |     |     |     |     |     |     |
| ------ | --- | --- | ---- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
Asacertified nutritionist, Ican provideyouwithsomepersonalized guidance forahighly effective and tailored
diet planbasedonyourage,gender, locationinSouthIndia, height, andweight.However,please notethat it's
alwaysbestto consultwithahealthcare professionalorregistered dietitian foracomprehensive and
Context
|     |     |     |     |     |     | individualized | plan.Here'sageneraldiet |     |     |     | plantogetyoustarted: |     |     |     |
| --- | --- | --- | --- | --- | --- | -------------- | ----------------------- | --- | --- | --- | -------------------- | --- | --- | --- |
Breakfast:
|         |     |         |     |            |     | •Startyourdaywithanutritious                        |                                 |     |     | breakfast. |                                             |           |            |     |
| ------- | --- | ------- | --- | ---------- | --- | --------------------------------------------------- | ------------------------------- | --- | --- | ---------- | ------------------------------------------- | --------- | ---------- | --- |
|         |     |         |     |            |     | •Include                                            | optionslikeidli,dosa(preferably |     |     |            | whole-grain),poha,orupmamadewithminimaloil. |           |            |     |
|         |     |         |     |            |     | •Addasideofsambarorcoconutchutney forflavorandadded |                                 |     |     |            |                                             |           | nutrients. |     |
|         |     |         |     |            |     | •Incorporateaservingoffreshfruits,likeabanana       |                                 |     |     |            |                                             | orpapaya. |            |     |
| Imagine |     | you are | a   | certified  |     |                                                     |                                 |     |     |            |                                             |           |            |     |
Mid-MorningSnack:
nutritionist with extensive  •Haveasmallportionofnuts orseedsforahealthy snack.Almondsorwalnutsaregoodchoices.
|            |     |          |     |     |     | •Youcanalsoenjoy |     | acup | ofbuttermilk orcoconutwater. |     |     |     |     |     |
| ---------- | --- | -------- | --- | --- | --- | ---------------- | --- | ---- | ---------------------------- | --- | --- | --- | --- | --- |
| expertise. |     | Provide  |     |     |     |                  |     |      |                              |     |     |     |     |     |
Lunch:
| personalized |         | guidance |          | on      | what  |                                   |                             |           |                                           |     |                            |     |     |               |
| ------------ | ------- | -------- | -------- | ------- | ----- | --------------------------------- | --------------------------- | --------- | ----------------------------------------- | --- | -------------------------- | --- | --- | ------------- |
|              |         |          |          |         |       | •Optforabalanced                  |                             | lunchthat | includeswholegrains,leanprotein,andplenty |     |                            |     |     | ofvegetables. |
| constitutes  |         | a        | highly   |         |       |                                   |                             |           |                                           |     |                            |     |     |               |
|              |         |          |          |         |       | •Haveaservingofbrownriceormillets |                             |           |                                           |     | likeragiorbajra.           |     |     |               |
| effective    |         | and      | tailored | diet    |       |                                   |                             |           |                                           |     |                            |     |     |               |
|              |         |          |          |         |       | •Include                          | asourceofproteinlikelentils |           |                                           |     | (dal), fish,orleanchicken. |     |     |               |
| plan.        | I       | live in  | South    | India.  |       |                                   |                             |           |                                           |     |                            |     |     |               |
|              |         |          |          |         |       | •Loaduponvegetables,              |                             |           | suchasspinach,carrots,andcucumber.        |     |                            |     |     |               |
| I am         | a Male. | My       | age      | is 38.  | My    |                                   |                             |           |                                           |     |                            |     |     |               |
|              |         |          |          |         |       | •Useminimaloilandspices           |                             |           | inyourcooking.                            |     |                            |     |     |               |
height is 5.8 and My weight  •Finishyourmealwithaservingofyogurtorcurd.
AfternoonSnack:
is 73kg.
•Alightsnackcanhelpkeepyourenergylevelssteady.
|     |     |     |     |     |     | •Consider | havingafruitsalad,ahandful |     |     |     | ofroastedchickpeas, |     | oravegetable | soup. |
| --- | --- | --- | --- | --- | --- | --------- | -------------------------- | --- | --- | --- | ------------------- | --- | ------------ | ----- |
Dinner:
|     |         |      |        |           |     | •Keepyourdinnerrelatively   |              |              | light.           |                             |     |                   |     |     |
| --- | ------- | ---- | ------ | --------- | --- | --------------------------- | ------------ | ------------ | ---------------- | --------------------------- | --- | ----------------- | --- | --- |
|     |         |      |        |           |     | •Include                    | avariety     | ofvegetables | and              | asmallportionofwholegrains. |     |                   |     |     |
|     |         |      |        |           |     | •Optforoptionslikevegetable |              |              | currywithchapati |                             |     | orasimplekhichdi. |     |     |
|     |         |      |        |           |     | •Avoidheavy                 | orrichdishes |              | beforebedtime.   |                             |     |                   |     |     |
|     | Compare | this | output | with the  |     |                             |              |              |                  |                             |     |                   |     |     |
BeforeBed:
|     |     | previous | output |     |     |                  |     |                |     |                               |     |     |     |                   |
| --- | --- | -------- | ------ | --- | --- | ---------------- | --- | -------------- | --- | ----------------------------- | --- | --- | --- | ----------------- |
|     |     |          |        |     |     | •Ifyoufeelhungry |     | beforebedtime, |     | haveaglassofwarmmilkoraherbal |     |     |     | tealikechamomile. |

| Domain | and | Context |     |     |     |     |     |
| ------ | --- | ------- | --- | --- | --- | --- | --- |
Assume you're an experienced investment banker and stock analyst teaching a class on long-term investing.
Could you explain the key factors or ratios that are crucial for evaluating stocks for long-term
investment? List these in a short and an easy-to-understand format suitable for beginners.
Certainly!Herearethekeyfactorsandratiosforevaluating stocksforlong-terminvestment inaconciseand beginner-friendly format:
1.EarningsPerShare(EPS): Lookforgrowingandconsistentprofitspershare.
| 2.Price-to-EarningsRatio(P/ERatio):LowerP/Eratioscanindicate |     |     |                     |     | better | value. |     |
| ------------------------------------------------------------ | --- | --- | ------------------- | --- | ------ | ------ | --- |
| 3.DividendYield:Higheryieldsprovideregular                   |     |     | incomeforinvestors. |     |        |        |     |
4.Debt-to-EquityRatio:Lowerdebtlevelssuggestfinancialstability.
| 5.ReturnonEquity(ROE):                           | Higher | ROEreflects         | effectiveuseofshareholder |                  |                      | equity. |           |
| ------------------------------------------------ | ------ | ------------------- | ------------------------- | ---------------- | -------------------- | ------- | --------- |
| 6.MarketCapitalization:Consider                  |        | companies ofvarious |                           | sizes based      | onyourrisktolerance. |         |           |
| 7.CompetitiveAdvantage(Moat):Seekcompanies witha |        |                     |                           | sustainable      | edge                 | intheir | industry. |
| 8.ManagementQuality:Researchthe                  |        | leadership          | team's                    | trackrecord.     |                      |         |           |
| 9.IndustryandMarketTrends:Understand             |        |                     | theindustry's             | growthpotential. |                      |         |           |
10.Diversification:Spreadriskbyinvesting indifferentstocksandsectors.
| 11.Long-TermProspects:Consider                          |     | acompany's | ability | to adapt and | grow.           |     |     |
| ------------------------------------------------------- | --- | ---------- | ------- | ------------ | --------------- | --- | --- |
| 12.ValuationRelativetoPeers:Comparewithsimilarcompanies |     |            |         |              | inthe industry. |     |     |

Domain and Context
Certainly!Here'sanexplanation ofthe philosophy ofthe Bhagavad Gitain5simplepoints fora12-year-old
1.Duty and Responsibility: The Bhagavad Gita teaches us about the importance of doing our duties and
responsibilities sincerely, without worrying too much about the results. It's like doing your homework or
choresbecause it'stherightthingtodo,notjustforrewardsorpraise.
2.InnerPeace:TheGitatells usthat findinginnerpeaceandcalmnessisessential. Itteaches ustocontrolour
Explain the philosophy of mindandemotions,likehandling yourfeelings whenthings don'tgoyourway,andfindingbalance inlife.
BhagwatGeeta to a 12
3.Self-Discovery:Itencourages us tounderstand whoweareandwhatourtrue selfis.This means knowing
years old kid in 5 points yourstrengths, weaknesses,andvalues,whichhelps makebetter decisionsinlife.
4.EqualityandRespect:TheGitateaches that allpeopleareequal andshouldbetreated withkindness and
respect,regardless oftheirbackgroundorappearance. It'slikebeingfriendlytoeveryoneatschool.
5.Spirituality:Finally,theGitatalksaboutconnecting withahigherpowerorinnerspirituality. It'slikefeeling
asenseofwonderabouttheworldandunderstanding that there's something biggerthanourselves.
So,theBhagavad Gitateaches ustodoourbest,staycalm,understand ourselves,bekindtoothers,and
exploreourinnerworldandspirituality. It'slikeaguidetolivingagoodandmeaningful life.

| Display |            | the          |             | output     |       |         |           |         |
| ------- | ---------- | ------------ | ----------- | ---------- | ----- | ------- | --------- | ------- |
|         | •You Can   | display      |             | the output |       | in many | different | formats |
|         | • Bullet   | Points       | & Numbered  |            | Lists |         |           |         |
|         | • Tabular  | Values       |             |            |       |         |           |         |
|         | • Sections | and          | Subsections |            |       |         |           |         |
|         | • Code     | Blocks       | & Math      | Equations  |       |         |           |         |
|         | • Quotes   | or Dialogues |             |            |       |         |           |         |
|         | • Labels   | and          | Annotations |            |       |         |           |         |

| Display   |      | the              | output  | -     |     |        |        |
| --------- | ---- | ---------------- | ------- | ----- | --- | ------ | ------ |
|           |      |                  |         | Lists | and | Bullet | points |
| List      | the  | top attractions  |         |       |     |        |        |
| in Paris, |      | France,.         | Give    |       |     |        |        |
| the       | list | only.            | Do not  |       |     |        |        |
| include   | any  | explanations.    |         |       |     |        |        |

| Display | the             |         | output       |          | - Lists | and | Bullet | points |
| ------- | --------------- | ------- | ------------ | -------- | ------- | --- | ------ | ------ |
| List    | key personality |         |              | traits   |         |     |        |        |
| that    | contribute      |         | to success,  |          |         |     |        |        |
| and     | present         | them    | in a         | concise  |         |     |        |        |
| bullet  | point           | format. |              |          |         |     |        |        |

| Display    |             | the | output     |         | - Lists | and | Bullet | points |
| ---------- | ----------- | --- | ---------- | ------- | ------- | --- | ------ | ------ |
| List       | 5 effective |     | study      |         |         |     |        |        |
| techniques |             | for | improving  |         |         |     |        |        |
| memory     | retention   |     |            |         |         |     |        |        |
|            |             |     | This       | is what | I do..  |     |        |        |

| Display | the | output |        |
| ------- | --- | ------ | ------ |
| Lists   | and | Bullet | points |
• “List key personality traits that contribute to success, and present them in a
| concise | bullet | point | format.” |
| ------- | ------ | ----- | -------- |
•
"List 5 effective study techniques for improving memory retention."
• "Highlight the key advantages of 5G technology in a bullet-point list."
• "Summarize the main causes of air pollution in a bullet-point list.“
•
"Provide a bullet-point list of effective strategies for improving social
| media | engagement.“ |     |     |
| ----- | ------------ | --- | --- |
• “List the key safety features to consider when purchasing a family car.”

| Display |     | the | output | -        |     |     |             |
| ------- | --- | --- | ------ | -------- | --- | --- | ----------- |
|         |     |     |        | Sections |     | and | Subsections |
Create a structured essay with sections and subsections about Generative AI. Include applications and
| examples | to explain | a layman | with very | limited | knowledge. |     |     |
| -------- | ---------- | -------- | --------- | ------- | ---------- | --- | --- |

| Display |            | the       | output |        |          |
| ------- | ---------- | --------- | ------ | ------ | -------- |
| Tabular |            | Format    |        |        |          |
| Create  | 10 MCQ     | questions | on     | Python | pandas.  |
| Arrange | the        | questions | in a   | table  | format   |
| with    | 6 columns. | Question, |        | Option | A,       |
| Option  | b, Option  | C ,       | Option | D and  | the      |
Answer

| Display   |     | the          | output   |       |         |            |      |
| --------- | --- | ------------ | -------- | ----- | ------- | ---------- | ---- |
| Tabular   |     |              | Format   |       |         |            |      |
| What's    | the | study        | plan     | for   | someone |            | who  |
| wants     | to  | be a data    | analyst? |       |         | Note       | all  |
| important |     | fields       | and      | their |         | specific   |      |
| points,   |     | and organize |          | them  | in      | a tabular  |      |
format.

Iterations
| •Get      | the         | initial | response, |     | have           | a look  | at it  |         |
| --------- | ----------- | ------- | --------- | --- | -------------- | ------- | ------ | ------- |
| •Resubmit |             | to get  | better    |     | results        |         |        |         |
| •Adjust   | the         | prompt  |           | to  | get better     | results |        |         |
| •Add      | a condition |         | to        | get | better results |         |        |         |
| •Give     | some        | more    | context   |     | to get         | the     | better | results |

Iterations
•Most of the LLMs are chatbots- Use the Question and Answer Chat options
| iteratively |     | to improve |     | the | output |     |     |
| ----------- | --- | ---------- | --- | --- | ------ | --- | --- |
•Each iteration helps refine the response, making it more accurate and
| relevant | to  | the | user's | query | or requirement. |     |     |
| -------- | --- | --- | ------ | ----- | --------------- | --- | --- |
•Iterative prompting allows you to tailor the information to the specific
| user, | ensuring |     | it's understandable |     |     | and relevant | to them. |
| ----- | -------- | --- | ------------------- | --- | --- | ------------ | -------- |
•AI models, no matter how advanced, can sometimes provide incorrect or
| incomplete |     | information. |     |     |     |     |     |
| ---------- | --- | ------------ | --- | --- | --- | --- | --- |
•Through iterative prompting, you can correct these errors, ask for
clarifications, and ensure the accuracy of the information provided.

| Structuring |     | the | prompt |     | – 5 | Elements |
| ----------- | --- | --- | ------ | --- | --- | -------- |
R : Role-player or Expert : Persona/Roleplaying / Field Expert
E : Examples : Exclusions /Exceptions / Inclusions and Exclusions
| D : Domain | and | Context | : Background |     |     | / Setup |
| ---------- | --- | ------- | ------------ | --- | --- | ------- |
D : Display and Format: Size, Structure and Format of the output
| I : Iterations: |     | Refinements/ |     | Regenerations |     | / Improvements |
| --------------- | --- | ------------ | --- | ------------- | --- | -------------- |

| To change |          | the     | context   | – Ignore |     | previous chats |
| --------- | -------- | ------- | --------- | -------- | --- | -------------- |
| 1."Clear  | previous | context | and start | fresh."  |     |                |
2."Ignore previous messages and focus on the following instructions."
| 3."Begin | a new | conversation | with the | following | questions:" |     |
| -------- | ----- | ------------ | -------- | --------- | ----------- | --- |
4."Reset the chat and provide responses based on the following input:"
5."Let's start from scratch with the following discussion topics:"