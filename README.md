# Student Management System (JDBC)

A simple Java console-based application built using JDBC and MySQL to manage student records.

## Features
- Add a new student
- View student by ID
- View all students
- Update student details
- Delete student records

## Technologies
- Java
- JDBC
- MySQL

## Prerequisites
- Java 8 or higher
- MySQL

## Database Setup
1. Create a MySQL database
2. Create a `students` table
		CREATE TABLE students (
		    id INT PRIMARY KEY AUTO_INCREMENT,
		    name VARCHAR(100),
		    email VARCHAR(100) UNIQUE,
		    age INT
		);
3. Update database credentials in the code

## How to Run
1. Clone the repository
2. Open the project in STS(Or any suitable IDE)
3. Configure database credentials
4. Run the `Main` class

## Project Structure
- src/
  - dao/
  - model/
  - util/
  - Main.java
  
## Future Improvements
- Use connection pooling
- Migrate to Spring Boot
- Add logging

## Author
Hirusha Silva


