# Task Management & Authentication API

This project is a Spring Boot application that provides a REST API for task management and user authentication. The application supports operations such as creating, reading, updating, and deleting tasks, along with user registration, login, and password management.

## Table of Contents
- [Technologies Used]
- [Features]
- [API Endpoints]
- [Setup Instructions]
- [Usage]
- [Error Handling]
- [License](

## Technologies Used

- Java 17
- Spring Boot
- Hibernate
- MySQL
- Maven
- Lombok
- Postman (for API testing)

## Features

### Task Management
- Create new tasks
- Retrieve all tasks or a specific task by ID
- Update task details
- Delete a task

### User Authentication
- Register a new user
- User login
- Change user password

## API Endpoints

### Task Management Endpoints

- **Create a Task**
  - `POST /tasks`
  - Request Body:
    ```json
    {
      "title": "Task Title",
      "description": "Task Description",
      "date": "2024-09-30",
      "status": "Pending"
    }
    ```
  - Response: `201 Created` or `500 Internal Server Error`

- **Get All Tasks**
  - `GET /tasks`
  - Response: `200 OK`
  
- **Get Task by ID**
  - GET /tasks/{id}
  - Response: `200 OK` or `404 Not Found`

- **Update a Task**
  - `PUT /tasks`
  - Request Body:
    
    {
      "id": 1,
      "title": "Updated Title",
      "description": "Updated Description",
      "date": "2024-10-01",
      "status": "Completed"
    }
    
  - Response: `200 OK` or `404 Not Found`

- **Delete a Task**
  - `DELETE /tasks/{id}`
  - Response: `200 OK` or `404 Not Found`

### User Authentication Endpoints

- **Register User**
  - `POST /user/register-user`
  - Request Body:
    ```json
    {
      "username": "johndoe",
      "password": "password123",
      "email": "johndoe@example.com"
    }
    ```
  - Response: `201 Created` or `409 Conflict`

- **Login User**
  - `POST /user/login-user`
  - Request Body:
    
    {
      "username": "johndoe",
      "password": "password123"
    }
   
  - Response: `200 OK` or `401 Unauthorized`

- **Change Password**
  - `PUT /user/change-password`
  - Request Body:
    
    {
      "username": "johndoe",
      "newPassword": "newpassword123"
    }
  - Response: `200 OK` or `404 Not Found`

## Setup Instructions

### Prerequisites
- Install Java 17 or higher
- Install MySQL and create a database
- Install Maven
- Set up your IDE (e.g., IntelliJ, Eclipse)
- Install Postman for testing API requests

### Project Setup

1. **Clone the repository:**
  
   git clone https://github.com/abhimanyu0008/TaskHub.git
