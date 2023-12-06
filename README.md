# Library System

## Introduction
This project involves designing and implementing a library system using the Java programming language with a graphical user interface Java Swing. The goal is to support basic functionalities related to library management and user interactions. I designed and implemented the project architecture based on object-oriented programming principles.

## Library Operation Rules
- Only employees (administrators and librarians) can log in.
- Employee data includes name, surname, JMBG, address, gender, salary, username, and password.
- Administrators can register new employees and add new library members. Librarians can only add new library members.
- Library member data includes name, surname, JMBG, address, gender, membership number, type of membership fee, last payment date, number of months paid, and membership status.
- Monthly membership fees vary by type: 100 dinars for pensioners, 150 dinars for children up to 14 years, and 250 dinars for other members.
- Administrators have access to all entities and actions, while librarians have limited access.
- Book records include title, original title, writer's name, year of publication, language, description, and genre.
- Each book copy is recorded with page number, binding type, year of publication, language, and rental status.
- Individual book rentals include employee processing the rental, renting member, rental date, return date, and rented book copy.
- Library information includes name, address, telephone, and working hours.

## Technical Specification
- Storing data about all entities in text files in any format.
- Manually implemented methods for reading and writing data from/to the files.
- Implemented corresponding enumerations for data with predefined set values (language, binding type).
- Provided unique identifiers (IDs) for each entity, ensuring uniqueness and preventing duplicate entries.
- Implemented logical deletion for entities, keeping their data in files but hiding them from the system.

## Model- UML diagram
![diagram-library](https://github.com/anna02272/SR46-2021-UOP-projekat/assets/96575598/8bf73a5c-11e7-4757-a399-36dc1e0f2c40)

