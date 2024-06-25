**Overview**
This documentation outlines the structure and implementation of a microservice-based project using Spring Boot and Java. 
The project consists of multiple independent services that communicate with each other using RESTful APIs.

**Table of Contents**
Introduction
Project Structure
Microservices
Service Registry
API Gateway
Config Server
Question Service
Quiz Service
Development Environment Setup
Building and Running the Application
REST API Endpoints
Security
Testing
Deployment
Monitoring
Troubleshooting

**Introduction**
Microservices architecture allows for the development of small, independently deployable services that are loosely coupled and can be developed, tested, and deployed independently.
This project demonstrates how to build a microservices application using Spring Boot, a popular framework for building Java applications.

**Project Structure**
The project is organized into several microservices, each with its own Spring Boot application. Below is the structure of the project:
microservice-project/
├── config-server/
├── service-registry/
├── api-gateway/
├── Question Service/
└── Quiz Service/

**Microservices
Service Registry**
Description: The Service Registry is used for service discovery. It allows microservices to find and communicate with each other without hardcoding their locations.

Technology: Eureka Server

**Configuration:**
**application.properties:
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false**
========================================================================================
**Main Application Class:**

**@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }
}**

===============================================================================================

