# **Smart Job Recommendation Portal**

*An end-to-end application built with **React**, **Java Spring Boot**, **MySQL**, and **Machine Learning** for intelligent job matching.*

## 📌 **Project Overview**

The **Smart Job Recommendation Portal** is a platform where:

* **Job Seekers** can create profiles, upload resumes, and receive **AI-powered job recommendations**.
* **Employers** can post jobs and manage applicants.
* **Machine Learning** algorithms match candidates with jobs based on skills, experience, and preferences.

This project is designed as a **learning-focused, full-stack application** to master:

* React Frontend Development
* Spring Boot Backend Development
* MySQL Database Design
* JWT Authentication & Authorization
* Machine Learning Model Integration
* Deployment to Cloud

---

## 🎯 **Goals of the Project**

* Learn **React + Spring Boot integration**
* Implement **REST APIs with Spring Data JPA**
* Understand **JWT-based authentication**
* Practice **database design in MySQL**
* Implement a **basic ML recommendation engine**
* Gain experience in **full-stack deployment**

---

## 🏗 **Tech Stack**

**Frontend**:

* React.js (with Hooks, Axios, React Router)
* Tailwind CSS / Bootstrap (UI styling)

**Backend**:

* Java 17 / 21
* Spring Boot 3.x
* Spring Data JPA
* Spring Security (JWT Authentication)

**Database**:

* MySQL 8.x

**Machine Learning**:

* Python (Scikit-learn / Pandas / Flask API for ML service)

**Others**:

* Maven (Build Tool)
* Lombok (Reduce Boilerplate Code)
* Postman (API Testing)

---

## 📂 **Project Structure**

```
smart-job-portal/
│
├── backend/                # Spring Boot Backend
│   ├── src/main/java/...
│   ├── src/main/resources/
│   └── pom.xml
│
├── frontend/               # React Frontend
│   ├── src/
│   ├── public/
│   └── package.json
│
├── ml-service/             # Python ML Service
│   ├── app.py
│   ├── model.pkl
│   └── requirements.txt
│
└── README.md
```

---

## 📅 **Project Roadmap (Epics)**

1. **Epic 1**: User Management (Signup, Login, JWT Auth)
2. **Epic 2**: Job Posting & Management (Employer side)
3. **Epic 3**: Candidate Profile Management
4. **Epic 4**: Job Search & Filtering
5. **Epic 5**: Machine Learning Job Recommendation Engine
6. **Epic 6**: Notifications & Communication
7. **Epic 7**: Deployment (Frontend + Backend + ML service)

---

## ⚙ **Installation & Setup**

### 1️⃣ Backend Setup

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### 2️⃣ Frontend Setup

```bash
cd frontend
npm install
npm start
```

### 3️⃣ ML Service Setup

```bash
cd ml-service
pip install -r requirements.txt
python app.py
```

---

## 🔑 **Environment Variables**

Create `.env` files for each module:

**Backend `.env` (or in `application.properties`):**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/job_portal_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
jwt.secret=YOUR_SECRET_KEY
```

**Frontend `.env`:**

```env
REACT_APP_API_URL=http://localhost:8080/api
```

---

## 🧪 **Testing**

* Use **Postman** to test APIs
* Unit tests with **JUnit & Mockito** for backend

---

## 🚀 **Deployment**

* Backend → Deploy to **Heroku / AWS Elastic Beanstalk**
* Frontend → Deploy to **Vercel / Netlify**
* ML Service → Deploy to **Render / AWS Lambda**

---

## 📖 **Learning Notes**

This project is intentionally structured to **learn and apply** key concepts step-by-step.
Each Epic is broken into **stories** and implemented in **small commits** for easy tracking.
