# Fullstack-movie-app
آها 💡 كدا فهمت قصدك يا محمد.
انت عايز **README.md** يكون فيه كل الخطوات العملية اللي المدير أو أي حد يراجع الكود يقدر يمشي عليها خطوة بخطوة ويشغل المشروع بدون ما يسألك.

أنا هكتبلك ملف جاهز، مرتب، بالإنجليزي وبالتفاصيل (من أول ما يـ clone المشروع لحد ما يفتح الـ app في المتصفح).

---

````markdown
# 🎬 MovieApp

MovieApp is a Fullstack application built with **Spring Boot (Backend)** and **Angular (Frontend)**.  
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
   git clone https://github.com/USERNAME/movieapp.git
   ```
2. Navigate into the project folder:

   ```bash
   cd movieapp
   ```

The project structure looks like this:

```
movieapp/
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

## 🛠 Database Setup (if required)

* The backend is configured to use a database (e.g., MySQL/PostgreSQL).
* Update database credentials in:

  ```
  backend/src/main/resources/application.properties
  ```
* Example:

  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/movieapp
  spring.datasource.username=root
  spring.datasource.password=your_password
  ```

---

## ✅ Summary

* Clone the repo
* Run backend (`mvn spring-boot:run`)
* Run frontend (`ng serve`)
* Open [http://localhost:4200](http://localhost:4200)

```

---

تحب أزود في الملف ده كمان **Example accounts (admin/user login credentials)** لو عندك مستخدمين جاهزين للتست؟
```
