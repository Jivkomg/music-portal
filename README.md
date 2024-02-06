# Music Portal

Welcome to the Music Portal! This project is a web application that allows users to explore and purchase albums.

## Table of Contents
1. [Introduction](#introduction)
2. [Project Structure](#project-structure)
3. [Backend Overview](#backend-overview)
4. [Frontend Overview](#frontend-overview)
5. [Usage](#usage)

## Introduction
The Music Portal is a Spring Boot web application with Thymeleaf templates for server-side rendering. It provides functionalities for user registration, album exploration, purchasing albums, and managing user accounts.

## Project Structure
The project structure consists of backend Java classes and frontend HTML templates:

The Music Portal project is structured as follows:

- **Backend:**
  - `src/main/java`: Contains Java source code for backend development.
    - `com.example.musicportal.controller`: Controllers handling HTTP requests.
      - `AlbumController.java`: Manages endpoints related to album operations, such as fetching album details, buying albums, and downloading albums.
      - `RegistrationController.java`: Handles user registration requests.
      - `UserController.java`: Manages user account-related endpoints, including user registration, account details, and account recharge.
    - `com.example.musicportal.service`: Services implementing business logic.
      - `AlbumService.java`: Provides methods for fetching album details, buying albums, and getting user-related album information.
      - `UserService.java`: Manages user-related operations such as user registration, account details, and account recharge.
    - `com.example.musicportal.repository`: Repositories for database interaction.
      - `AlbumRepository.java`: Interface for accessing album data in the database.
      - `UserRepository.java`: Interface for accessing user data in the database.
    - `com.example.musicportal.entity`: Entity classes representing database tables.
      - `Album.java`: Represents album data including title, artist, price, and list of songs.
      - `User.java`: Represents user data including username, password, credit, and purchased albums.
    - `com.example.musicportal.security`: Security configurations.
      - `SecurityConfig.java`: Configures security settings such as authentication and authorization using Spring Security.
    - `application.properties`: Configuration properties for the Spring Boot application.

- **Frontend:**
  - `src/main/resources/templates`: Contains Thymeleaf HTML templates for server-side rendering.
    - `album-details.html`: Template for displaying album details including title, artist, price, songs, and buy/download options.
    - `registration.html`: Template for user registration form.
    - `user-account.html`: Template for displaying user account details including credit and purchased albums.
    - `recharge-page.html`: Template for recharging user account credit.
   
## Backend Overview
The backend is built using Spring Boot and consists of controllers, services, repositories, and entity classes. Key functionalities include security configuration, album management, user registration, and user account management.

## Frontend Overview
Thymeleaf templates are used for server-side rendering of HTML pages. Templates include pages for album details, registration form, user account, and recharge page.

## Usage
To use the Music Portal:
1. Run the Spring Boot application.
2. Access the application via the browser at `http://localhost:8080`.


For more information checkout the [Secure Software Template pdf](https://github.com/Jivkomg/music-portal/blob/main/Secure_Software_Template.pdf) file in the repository.
