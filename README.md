# Employee Management System

A robust console-based Java application designed to manage employee records. This project demonstrates the integration of **Core Java** with a **MySQL Database** using **JDBC**, following the **Data Access Object (DAO)** design pattern.

---

## 📋 Table of Contents
- [Project Overview](#-project-overview)
- [Features](#-features)
- [Technical Architecture & Concepts](#-technical-architecture--concepts)
- [Database Connection Details](#-database-connection-details)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)

---

## 🚀 Project Overview
The Employee Management System allows users to interact with a database via a command-line interface (CLI). It acts as a complete backend solution for performing CRUD (Create, Read, Update, Delete) operations, serving as a practical example of persistent data management in Java.

---

## ✨ Features
The application provides a menu-driven interface for the following operations:
1.  **Add Employee**: Create a new record with ID, Name, Salary, and Age.
2.  **Show All Employees**: Retrieve and display a formatted list of all employees from the database.
3.  **Show Employee by ID**: Query the database for a specific employee using their unique ID.
4.  **Update Employee**: Modify details (e.g., Name) of an existing employee.
5.  **Delete Employee**: Permanently remove an employee record from the database.
6.  **Exit**: Terminate the application safely.

---

## 🧠 Technical Architecture & Concepts
This project is not just a coding exercise; it covers several key software engineering aspects:

### 1. The DAO Design Pattern
The project separates the business logic from the database logic using the **Data Access Object (DAO)** pattern.
* **`EmployeeDaoInterface`**: An interface that defines *what* operations the application supports (Abstraction).
* **`EmployeeDaoImp`**: The implementation class that defines *how* those operations are executed using SQL (Implementation).

### 2. Object-Oriented Programming (OOP)
* **Encapsulation**: The `Employee` class is a POJO (Plain Old Java Object) where data is protected via `private` fields and accessed via `public` getters and setters.
* **Polymorphism**: The `Main` class uses the Interface reference (`EmployeeDaoInterface`) to hold the Implementation object (`EmployeeDaoImp`), allowing for flexible code.

### 3. JDBC (Java Database Connectivity)
The application uses the `java.sql` package to:
* Load the JDBC Driver.
* Establish a connection via `DriverManager`.
* Create `Statement` and `PreparedStatement` objects to prevent SQL Injection.
* Process `ResultSet` data.

---

## 🔌 Database Connection Details
The logic for connecting Java to MySQL is isolated in `src/com/DBConnection.java`.

**How it works:**
1.  **Driver Loading**: The app loads the MySQL driver class into memory using `Class.forName("com.mysql.cj.jdbc.Driver")`.
2.  **Connection Object**: It uses `DriverManager.getConnection(url, user, pass)` to establish the link.
3.  **Connection String Structure**:
    * `jdbc:mysql://`: The protocol.
    * `localhost:3306`: The server host and port.
    * `employeeDB`: The specific database name.

**Key Code Snippet:**
```java
// Example logic found in DBConnection.java
public static Connection createDBConnection() {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/employeeDB";
    String username = "root";
    String password = "YOUR_PASSWORD"; // Replaced with actual DB password

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return con;
}
