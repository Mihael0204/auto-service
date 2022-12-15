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
## Quickstart
1. Clone repository
2. Download images from Docker 'docker pull mihael0204/postgres' and 'docker pull mihael0204/auto-service'
3. Set your own postgres properties in files application.properties and .env
4. Run project with command 'docker-compose up'
___
