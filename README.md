# Patient-Management-System
A basic Spring Boot backend project implementing patient, doctor, and prescription management with REST APIs.
Patient Management System (Spring Boot)


Project Overview

This is a basic Spring Boot REST API project developed as part of a technical assignment. The application manages Patients, Doctors, and Prescriptions, including login/logout functionality and basic validations.

----------The project follows a layered architecture-----------

Controller Layer

Service Layer

Repository Layer

Entity Layer


------------Technology used --------


Java 17

Spring Boot

Spring Data JPA

Hibernate

MySQL

Maven

Postman (for API testing)




------------------Modeules ----------

------------Patient Module---------

Register patient (with validation)

Login patient

Logout patient

Get patient by Email

Delete patient by ID

Prevent duplicate registration (email & phone number)




----------Doctor Module-------

Register doctor (with validation)

Login doctor

Get doctor by Id

Delete doctor by ID

Prevent duplicate registration (email & phone number)



------Prescription Module----

Create prescription by doctor for patient

Fetch prescriptions by patient

Fetch prescriptions by doctor



-------------Entity Relationship-----

One Doctor can write multiple Prescriptions

One Patient can have multiple Prescriptions

Each Prescription is linked to one Doctor and one Patient


-------Authentication------

Simple login & logout implemented

Login time is stored for patient
