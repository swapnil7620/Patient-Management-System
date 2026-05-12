# Patient-Management-System

A Spring Boot backend application for managing Patients, Doctors, and Prescriptions using RESTful APIs. The project follows a layered architecture and demonstrates backend development concepts such as authentication, validation, entity relationships, and CRUD operations.

---

# Project Overview

The Patient Management System is designed to manage patient records, doctor information, and prescription details efficiently. The application provides secure login functionality, request validation, and relational database management using Spring Data JPA and Hibernate.

The project follows a clean layered architecture:

* Controller Layer
* Service Layer
* Repository Layer
* Entity Layer

---

# Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman (API Testing)

---

# Features

## Patient Module

* Register patient with validation
* Patient login functionality
* Patient logout functionality
* Fetch patient details by email
* Delete patient by ID
* Prevent duplicate registration using email and phone number validation

---

## Doctor Module

* Register doctor with validation
* Doctor login functionality
* Fetch doctor details by ID
* Prevent duplicate registration using email and phone number validation

---

## Prescription Module

* Create prescriptions for patients by doctors
* Fetch prescriptions by patient
* Fetch prescriptions by doctor

---

# Entity Relationships

* One Doctor can write multiple Prescriptions
* One Patient can have multiple Prescriptions
* Each Prescription is associated with one Doctor and one Patient

---

# Authentication

* Simple login and logout functionality implemented
* Login time tracking for patients
* Session validation during login operations

---

# Project Architecture

The project is structured using layered architecture for better maintainability and scalability:

## Controller Layer

Handles HTTP requests and API endpoints.

## Service Layer

Contains business logic and validation handling.

## Repository Layer

Manages database interactions using Spring Data JPA.

## Entity Layer

Defines database entities and relationships.

---

# API Testing

All REST APIs were tested using Postman to verify:

* Request and response handling
* Authentication flow
* CRUD functionality
* Data validation

---

# Future Improvements

* JWT-based Authentication
* Role-Based Authorization
* Swagger/OpenAPI Documentation
* Exception Handling
* Docker Deployment
* Unit Testing with JUnit and Mockito

---

# Author

Swapnil Mahajan
