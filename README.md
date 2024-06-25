# Spring Boot RESTful Service with OpenAPI Documentation

This is a sample Spring Boot RESTful service demonstrating the use of springdoc-openapi to document APIs using Swagger. The service provides endpoints to manage users and their associated accounts, showcasing CRUD operations and relational data handling with JPA and H2 database.

## Technologies Used

- Java
- Spring Boot
- Swagger
- H2 Database
- Docker

## Docker

A Docker image for this project is available on Docker Hub. You can pull it using the following command:

```bash
docker pull edclagg/webapi:1.0
```
## Features

- **User Management**:
  - Create, retrieve, update, and delete users.
  - Add and remove accounts for users.

- **Account Management**:
  - Create, retrieve, update, and delete accounts.

## Usage

Explore the API documentation at http://localhost:8080/swagger-ui/index.html

## API Endpoints

### Users

- `GET /api/users`: Get all users.
- `POST /api/users`: Create a new user.
- `GET /api/users/{userId}`: Get user by ID.
- `PUT /api/users/{userId}`: Update user by ID.
- `DELETE /api/users/{userId}`: Delete user by ID.
- `POST /api/users/{userId}/accounts`: Add account to user.
- `DELETE /api/users/{userId}/accounts/{accountId}`: Remove account from user.

### Accounts

- `GET /api/accounts`: Get all accounts.
- `POST /api/accounts`: Create a new account.
- `GET /api/accounts/{accountId}`: Get account by ID.
- `PUT /api/accounts/{accountId}`: Update account by ID.
- `DELETE /api/accounts/{accountId}`: Delete account by ID.


