# Secure User Authentication System in Java + MySQL

A simple and secure user login and registration CLI system using Java, MySQL, JDBC, and BCrypt.

## 🔧 Tech Stack
- Java 17+
- MySQL 8
- Maven
- JDBC
- BCrypt for password hashing

## 📦 Setup Instructions

1. **MySQL Setup**
```sql
CREATE DATABASE secure_app;
USE secure_app;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

2. **Update Database Credentials**
Edit `Database.java` and update the `USER` and `PASS` variables to match your MySQL credentials.

3. **Build and Run**
```bash
mvn clean install
mvn exec:java
```

## 🚀 Features
- Secure password hashing with BCrypt
- SQL Injection prevention via prepared statements
- CLI-based registration and login

## 📜 License
MIT
