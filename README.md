<div align="center">

# 🔐 SmartAuthify

**A secure, stateless authentication & authorization backend built with Spring Boot, Spring Security and JWT.**

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-6DB33F?logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-JWT-6DB33F?logo=springsecurity&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8-4479A1?logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white)

</div>

---

## 📖 About

**SmartAuthify** is a backend authentication service that handles user registration and login using **JSON Web Tokens (JWT)**. It follows a stateless, token-based approach, so it can be plugged into any frontend (React, Angular, mobile apps) or used as a starter for your own secured REST APIs.

## ✨ Features

- 🔑 User registration & login with **JWT** authentication
- 🛡️ **Spring Security** based request filtering and protected routes
- 🔒 Secure password hashing
- ✅ Request validation using **Jakarta Bean Validation**
- 🗄️ Persistence with **Spring Data JPA** + **MySQL**
- 🧩 Clean, layered architecture (Controller → Service → Repository)
- ⚡ Less boilerplate with **Lombok**

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java 21 |
| Framework | Spring Boot 4.1.2 |
| Security | Spring Security, JJWT 0.13.0 |
| Database | MySQL |
| ORM | Spring Data JPA (Hibernate) |
| Validation | Spring Boot Starter Validation |
| Build Tool | Maven |
| Utilities | Lombok, Spring Boot DevTools |

## 📂 Project Structure

```
smartAuthify
├── src
│   ├── main
│   │   ├── java/in/pranjal/smartAuthify   # Application source code
│   │   └── resources                      # application.properties & configs
│   └── test                               # Unit / integration tests
├── pom.xml                                # Maven dependencies & build config
├── .gitignore
└── .gitattributes
```

## 🚀 Getting Started

### Prerequisites

- **JDK 21** or higher
- **Maven 3.9+** (or use the Maven wrapper if present)
- **MySQL 8+** running locally or remotely

### 1. Clone the repository

```bash
git clone https://github.com/Pranjal9182/smartAuthify.git
cd smartAuthify
```

### 2. Create the database

```sql
CREATE DATABASE smartauthify;
```

### 3. Configure the application

Edit `src/main/resources/application.properties`:

```properties
spring.application.name=smartAuthify

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/smartauthify
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT
jwt.secret=YOUR_BASE64_ENCODED_SECRET_KEY
jwt.expiration=86400000
```

> ⚠️ **Never commit real credentials or your JWT secret.** Use environment variables or a local, git-ignored config file in production.

### 4. Run the application

```bash
mvn spring-boot:run
```

The server starts at **http://localhost:8080**

### 5. Build a JAR (optional)

```bash
mvn clean package
java -jar target/smartAuthify-0.0.1-SNAPSHOT.jar
```

## 🔐 How Authentication Works

1. The user registers or logs in with valid credentials.
2. The server verifies them and returns a signed **JWT**.
3. The client sends the token with every protected request:

   ```
   Authorization: Bearer <your_jwt_token>
   ```

4. A security filter validates the token and grants access to the requested resource.

## 🧪 Running Tests

```bash
mvn test
```

## 🗺️ Roadmap

- [ ] Refresh tokens
- [ ] Role-based access control (RBAC)
- [ ] Email verification & password reset
- [ ] Swagger / OpenAPI documentation
- [ ] Docker support

## 🤝 Contributing

Contributions, issues and feature requests are welcome!

1. Fork the project
2. Create your feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m "Add amazing feature"`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

## 👨‍💻 Author

**Pranjal**

- GitHub: [@Pranjal9182](https://github.com/Pranjal9182)
- LinkedIn: [Pranjal Maurya](https://linkedin.com/in/pranjal-maurya-b09086327)

---

<div align="center">

⭐ If you found this project useful, consider giving it a star!

</div>
