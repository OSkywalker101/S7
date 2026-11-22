2. AI-Based Research Paper Summarization and Question Answering System



* Lowest effort of all: the arXiv API gives you papers instantly, and the core pipeline is standard RAG.


* Interesting if you add one twist: have every answer cite the exact section and page, or support comparing two or three papers side by side ("how do these papers differ in their evaluation method?"). Without a twist, it's as generic as the PDF chatbots.


* Relatable: every examiner reads papers, so the use case needs no explanation.


* Split: PDF parsing (sections, tables, references), retrieval, summarization and comparison prompts, and the UI.


* Risk: evaluation is softer. You'd rely on a small manually written set of questions or LLM-as-judge scoring.