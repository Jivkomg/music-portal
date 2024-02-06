## Project Structure

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
For more information checkout the [Secure Software Template pdf](https://github.com/Jivkomg/music-portal/blob/main/Secure_Software_Template.pdf) file in the repository.
