#  ChronosData AI — Metadata Governance Assistant

ChronosData AI is a lightweight AI-powered metadata governance assistant built using Spring Boot.

The project allows users to:
- ask questions about their data using natural language
- validate metadata before deployment
- detect missing governance information
- identify sensitive datasets
- generate metadata health scores

It is designed as a beginner-friendly backend + AI project inspired by modern data governance and observability platforms.

---

#  Features

##  AI Data Chat

Ask questions like:

> Who owns the orders table?

Example response:

```text
orders table is owned by data_team
```
The system extracts metadata-related information from user queries and returns readable answers.

### Metadata Validation

Validate metadata before deployment by entering:

table name
owner

The system checks for:

missing owner information
missing table name
sensitive table detection
deployment readiness

### Metadata Health Score

Every validation generates a metadata health score.

Example:

```text
 Metadata Health Score: 50/100

 Missing owner

 Sensitive data detected

 Deployment Blocked
```

### Sensitive Data Detection

ChronosData AI detects potentially sensitive datasets such as:

payment data
salary data
customer data

This simulates governance and compliance checks before deployment.

### Docker Support

The application is containerized using Docker.

Run with:

```text
docker compose up --build
```

### Tech Stack
Java
Spring Boot
HTML
CSS
JavaScript
Docker
REST APIs
OpenAI API (with fallback logic)

### Screenshots
Main UI

<img width="1366" height="768" alt="Screenshot (231)" src="https://github.com/user-attachments/assets/308fa818-3be7-4719-a37d-492f651e84b5" />



Metadata Validation

<img width="1366" height="768" alt="Screenshot (230)" src="https://github.com/user-attachments/assets/70f7c37f-d781-4f70-8330-4ce84b838a38" />
<img width="1366" height="768" alt="Screenshot (229)" src="https://github.com/user-attachments/assets/defc9a1d-b0ce-4dce-b631-3066fcb3b1e9" />


### Run Locally
Clone the repository

git clone https://github.com/shrutisharma-sh/ChronosData-AI.git

Run the project
mvn spring-boot:run

Open:

http://localhost:9090/index.html


### Project Goal

ChronosData AI was built to explore:

AI-assisted metadata systems
governance validation
backend engineering
observability concepts
Docker-based deployment

while keeping the project lightweight and beginner-friendly.

### Author

Shruti Sharma
