# PollingApp

## Overview

PollingApp is a full stack project built with Spring Boot and Angular that allows users to create and participate in polls. The application provides a RESTful API for managing polls and votes, making it easy to integrate with the Angular frontend.

## Features

- Create polls with multiple options
- Vote on existing polls
- Retrieve all polls and specific poll details

## Technologies Used

- **Backend**: Spring Boot, JPA, MySQL
- **Frontend**: Angular
- **Build Tool**: Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- MySQL Database
- Node.js and npm (for Angular)

### Screenshots 

#### Create Poll
![image](https://github.com/user-attachments/assets/dcdd1316-aa61-47b3-be05-2ec1f700d5ab)
#### Available Polls
![image](https://github.com/user-attachments/assets/7b00e892-1661-438b-b56e-d25a3cae3ab9)


### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/rathore-nikhil/Polling-App.git
   cd Polling-App/backend/pollingapp
   
2. Configure the database connection in `src/main/resources/application.properties`:

   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/pollingapp
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword

3. Build the backend project using Maven:
   ```bash
   mvn clean install

4. Run the backend application:
   ```bash
   mvn spring-boot:run

5. Navigate to the frontend directory:
   ````bash
   cd ../frontend/poll-app

6. Install the Angular dependencies:
   ```bash
   npm install

7. Run the Angular application:
   ```bash
   ng serve

The application will be available at `http://localhost:4200`.

### API Endpoints
- **Create Poll**: `POST /api/polls`
- **Get All Polls**: `GET /api/polls`
- **Get Poll by ID**: `GET /api/polls/{id}`
- **Vote on Poll**: `POST /api/polls/vote`

### Example Request
To create a poll, send a POST request to `/api/polls` with the following JSON body:
```bash
{
  "question": "What is your favorite programming language?",
  "options": [
    {"optionText": "Java"},
    {"optionText": "Python"},
    {"optionText": "JavaScript"}
  ]
}
