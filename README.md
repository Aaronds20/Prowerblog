# ProwerBlog - A Blogging Website

## Introduction
ProwerBlog is a blog project developed using Spring Boot and Thymeleaf. It includes various functionalities such as login and registration, user-specific dashboards, and paginated blog posts. The project leverages multiple Spring modules along with Bootstrap for the frontend and MySQL for the database.

## Technologies Used
- Spring Boot
- Spring Security
- Thymeleaf
- Spring Data JPA
- Spring Data REST
- Bootstrap
- MySQL

## Features
- Login and Registration: Secure user authentication and registration functionality.
- User Dashboard: Each user has a personal dashboard to manage their blog posts and comments.
- Commenting: Authenticated users can comment on posts made by other users.
- Post Management: Users can edit and delete their blog posts and comments.
- Home Page: Displays a paginated list of all blog posts.
- Public Access: Non-authenticated users can view all blog posts but cannot add new posts or comment.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- MySQL

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/Prowerblog.git
    ```
2. Navigate to the project directory:
    ```sh
    cd Prowerblog
    ```

### Configure Database

1. Create a MySQL database named prowerblog.

2. Update the database configuration in application.properties:
   ```sh
    spring.datasource.url=jdbc:mysql://localhost:3306/prowerblog
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    ```

### Running the application

    mvn clean install
    mvn spring-boot:run
    
## Usage
  Once the application is running, navigate to http://localhost:8080 in your browser.
  
- Register: Create a new account.
- Login: Access your personal dashboard.
- Create Post: Authenticated users can add new blog posts.
- Comment: Authenticated users can comment on existing posts.
- Edit/Delete: Manage your own posts and comments from the dashboard.

## Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository.
2. Create a new branch:
    ```sh
    git checkout -b feature-branch
    ```
3. Make your changes and commit them:
    ```sh
    git commit -m "Description of your changes"
    ```
4. Push to the branch:
    ```sh
    git push origin feature-branch
    ```
5. Create a pull request.

## Acknowledgements
- Spring Boot
- Thymeleaf
- Bootstrap
- Font Awesome

## Contact

- For any questions or feedback, please contact us at aarondsouza04020@gmail.com.

![Web capture_11-12-2023_214625_localhost](https://github.com/Aaronds20/prowerblog/assets/105139489/db002a42-7237-4408-9934-032774663b46)


![Web capture_11-12-2023_214645_localhost](https://github.com/Aaronds20/prowerblog/assets/105139489/b7411c28-0289-4717-b508-255e5e24b502)

![Web capture_11-12-2023_21473_localhost](https://github.com/Aaronds20/prowerblog/assets/105139489/b9f18eca-b09e-42e3-bafe-577efc089dd6)

![Web capture_11-12-2023_214940_localhost](https://github.com/Aaronds20/prowerblog/assets/105139489/2b53b0e0-1067-4343-8ce0-444fc6fbbcbf)

![Web capture_11-12-2023_214837_localhost](https://github.com/Aaronds20/prowerblog/assets/105139489/4752e63c-72d3-4f49-a806-f6603ad158a1)

![Web capture_11-12-2023_214913_localhost](https://github.com/Aaronds20/prowerblog/assets/105139489/ed9d93df-2238-4d8b-82c2-0c2deb5a6629)

![Web capture_11-12-2023_214756_localhost](https://github.com/Aaronds20/prowerblog/assets/105139489/6d1aa8f3-948a-4e0e-a808-540904d3933a)






