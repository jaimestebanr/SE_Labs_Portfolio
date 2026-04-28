# Gym Management System - TDD Lab

This repository contains the Test-Driven Development lab for the Software Engineering course.

The project is based on the Gym Management System described in the Software Requirements Specification. The objective is not to build a complete web application, but to implement and test the main business rules of the system using TDD.

## TDD approach

The project follows the Red-Green-Refactor cycle:

1. Red: write a failing test for a small requirement.
2. Green: write the minimum code needed to make the test pass.
3. Refactor: improve the code while keeping all tests passing.

## Implemented features

### Booking management

The booking service allows a member to book a gym class only when:

- the member has an active membership,
- the class has available places.

When a booking is successful, the number of available places is reduced.

### Attendance management

The system allows attendance to be recorded for an existing booking.

### Trainer schedule management

The trainer schedule service allows administrators to assign trainers to classes.

The system prevents assigning the same trainer to overlapping class sessions.

### Payment and membership control

The payment service allows administrators to register payments.

When a valid payment is registered, the member membership becomes active.

Invalid payment amounts are rejected.

## Project structure

```text
src/main/java/com/gym/model