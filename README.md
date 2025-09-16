تمام ✅ خليني أعدل الملف بتاعك بحيث يكون متوافق مع اسم الريبو الجديد (`fawry-task`) وكمان أضيف المعلومة إن المشروع بيستخدم **in-memory database** مش MySQL/PostgreSQL.

أهو نسخة محدثة وجاهزة:

````markdown
# 🎬 Fawry Task

Fawry Task is a Fullstack application built with **Spring Boot (Backend)** and **Angular (Frontend)**.  
This guide explains how to set up and run the project step by step.

---

## 📌 Prerequisites
Before running the project, make sure you have installed:

- [JDK 17+](https://adoptium.net/)  
- [Maven 3+](https://maven.apache.org/)  
- [Node.js 18+](https://nodejs.org/)  
- [Angular CLI](https://angular.io/cli)  

To verify installation:
```bash
java -version
mvn -v
node -v
ng version
````

---

## 👥 Clone the Project

1. Open a terminal and run:

   ```bash
   git clone https://github.com/moAmer1468/fawry-task.git
   ```
2. Navigate into the project folder:

   ```bash
   cd fawry-task
   ```

The project structure looks like this:

```
fawry-task/
  ├── backend/   (Spring Boot)
  └── frontend/  (Angular)
```

---

## 🚀 Run the Backend (Spring Boot)

1. Navigate to the backend folder:

   ```bash
   cd backend
   ```
2. Build and run the application:

   ```bash
   mvn spring-boot:run
   ```
3. The backend will start at:

   ```
   http://localhost:8080
   ```

📌 **Note:** The project uses an **in-memory database (H2)**, so you don’t need to install MySQL or PostgreSQL.
The database is automatically created and populated at runtime.

---

## 💻 Run the Frontend (Angular)

1. Open a **new terminal** and navigate to the frontend folder:

   ```bash
   cd frontend
   ```
2. Install dependencies:

   ```bash
   npm install
   ```
3. Start the Angular development server:

   ```bash
   ng serve
   ```
4. Open the application in your browser:

   ```
   http://localhost:4200
   ```

---

## ⚡ Usage Flow

1. Start the **backend** first (Spring Boot).
2. Then start the **frontend** (Angular).
3. Access the app via your browser at [http://localhost:4200](http://localhost:4200).
4. The frontend communicates with the backend running on [http://localhost:8080](http://localhost:8080).

---

## 🔑 Test Users

You can log in with the following test accounts:

* **Admin Account**

  ```
  username: admin
  password: admin
  ```

* **User Account**

  ```
  username: user
  password: user
  ```

---

## ✅ Summary

* Clone the repo (`fawry-task`)
* Run backend (`mvn spring-boot:run`) → uses **H2 in-memory database**
* Run frontend (`ng serve`)
* Open [http://localhost:4200](http://localhost:4200)
* Use provided test accounts (admin/user) to log in
