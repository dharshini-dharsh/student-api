# Student API

A Spring Boot REST API for managing student information.

## Technologies Used

* Java 21
* Spring Boot
* Maven
* REST API
* Spring Data JPA
* MySQL
* Git & GitHub

## Features

* Add a new student
* Get all students
* Get student by ID
* Update student details
* Delete a student

## Project Structure

```text
student-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.dharshu.studentapi
│   │   └── resources
│   │       └── application.properties
├── pom.xml
└── README.md
```

## API Endpoints

| Method | Endpoint         | Description       |
| ------ | ---------------- | ----------------- |
| GET    | `/students`      | Get all students  |
| GET    | `/students/{id}` | Get student by ID |
| POST   | `/students`      | Add a new student |
| PUT    | `/students/{id}` | Update a student  |
| DELETE | `/students/{id}` | Delete a student  |

## How to Run

### 1. Clone the repository

```bash
git clone <your-github-repository-url>
```

### 2. Open the project

Open the project in IntelliJ IDEA.

### 3. Build the project

```bash
mvn clean install
```

### 4. Run the application

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## Example Student JSON

```json
{
  "name": "Dharshu",
  "email": "dharshu@example.com",
  "course": "Artificial Intelligence and Machine Learning"
}
```

## Author

Dharshu

GitHub: https://github.com/dharshini-dharsh
