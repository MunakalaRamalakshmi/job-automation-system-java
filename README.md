

# 🚀 Job Automation System (Spring Boot + Selenium)

## 📌 Overview

This project is a backend automation system built using Java, Spring Boot, Selenium, and Jsoup that:

- Fetches job postings from job portals
- Parses job details (title, description, skills)
- Calculates match score based on user profile
- Continuously monitors new job postings using a scheduler
- Helps identify best-fit jobs for quick application

This simulates a real-world job tracking and matching assistant used in QA Automation / SDET workflows.

---

## ⚙️ Features

### 🔍 Job Fetching
- Extracts job links from public job boards

### 🧾 Job Parsing
- Uses Selenium + Jsoup to extract:
  - Job title
  - Job description
  - Job URL

### 🧠 Job Matching Engine
- Keyword-based weighted scoring system
- Matches job description with user skills
- Generates match score (0–100%)

### ⏰ Scheduler
- Runs automatically at fixed intervals
- Continuously scans for new jobs

### 📢 Notification Layer (Console-based)
- Prints high match jobs for quick review

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Selenium WebDriver
- Jsoup (HTML parsing)
- Maven
- Spring Scheduler

---

## 📁 Project Structure
com.jobautomation
├── controller
├── service
│ ├── JobFetcherService
│ ├── SeleniumJobParserService
│ ├── JobMatcherService
│ ├── NotificationService
├── scheduler
├── model
└── JobAutomationApplication

## 🔄 Workflow
Scheduler Trigger
↓
Fetch Job Links
↓
Parse Job Details (Selenium/Jsoup)
↓
Match Against User Skills
↓
Generate Score
↓
Notify High-Match Jobs


---

## 🧠 Job Matching Logic

- Java → 30%
- Selenium → 30%
- API Testing → 20%
- SQL → 20%

Final score is calculated based on keyword presence in job description.

---

## ▶️ How to Run

### 1. Clone Repository

git clone https://github.com/your-username/job-automation-system.git

### 2. Navigate to Project

cd job-automation-system

### 3. Run Application

mvn spring-boot:run

---

## 🧪 Sample API Endpoints

### Test API

GET /hello

### Fetch Jobs

GET /fetch-jobs

### Job Matching

POST /match

---

## 🚀 Future Enhancements

- AI-based job matching using NLP (TF-IDF / embeddings)
- Resume auto-tailoring per job description
- Email/Telegram notifications
- Web dashboard UI
- Database integration (job history tracking)
- Docker deployment

---

## 🎯 Learning Outcomes

This project demonstrates:

- Backend automation design
- Web scraping using Selenium & Jsoup
- Scheduler-based systems
- REST API development
- Real-world QA automation workflows
- System design thinking

---

## 👨‍💻 Author

Built as a QA Automation / SDET portfolio project.

---

## ⚠️ Disclaimer

This project is for educational purposes only.
