# Auto-service
___
## Description
This project is a simple auto service system. It allows you to register your car for repair work and complete orders with some products and services!
___
## Project features
1. Registration of user, worker, tasks and products
2. Start and finish repairing orders
___
## Project structure
This project has an 3-tier architecture
+ DAO - all communication with databases happens here
+ Service - all business logic on this level
+ Controller - this level allows the user to work with our application
___
## Technologies
+ Java 17
+ Maven
+ Spring Boot
+ PostgreSQL
___
## Instruction to run this project
1. Fork this repository
2. Open IntelliJ IDEA and write git clone <SSH link> in console
3. Configure application.properties - set necessary parameters:
```java
        spring.datasource.username=YOUR_NAME
        spring.datasource.password=YOUR_PASSWORD
```
4. Run the project
___
