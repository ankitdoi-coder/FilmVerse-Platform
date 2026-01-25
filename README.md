# Ajay Movies Platform

[![GitHub stars](https://img.shields.io/github/stars/yourusername/ajay-movies.svg)](https://github.com/yourusername/ajay-movies/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/yourusername/ajay-movies.svg)](https://github.com/yourusername/ajay-movies/network)
[![GitHub issues](https://img.shields.io/github/issues/yourusername/ajay-movies.svg)](https://github.com/yourusername/ajay-movies/issues)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

> 🚧 **Currently in Active Development** - This project is being actively worked on and may undergo frequent changes.

## Overview

Ajay Movies Platform is a comprehensive full-stack web application designed for movie enthusiasts to discover, manage, and stream movies. Built with modern technologies, this platform offers a seamless experience for both administrators and users. As a seasoned developer with over a decade of experience in full-stack development, I've crafted this project to demonstrate best practices in scalable architecture, security, and user experience.

### Key Features

- **Movie Catalog Management**: Comprehensive CRUD operations for movie entries
- **User Authentication & Authorization**: Secure login system with role-based access
- **Admin Dashboard**: Powerful interface for content management
- **File Upload System**: Support for movie poster and video file uploads
- **Responsive Frontend**: Modern Angular UI with mobile-first design
- **RESTful API**: Well-documented backend endpoints
- **Database Integration**: MySQL with JPA for robust data persistence
- **Security**: Spring Security implementation with JWT authentication

## Tech Stack

### Backend
- **Java 17** - Modern Java runtime
- **Spring Boot 4.0.1** - Framework for rapid application development
- **Spring Data JPA** - ORM for database operations
- **Spring Security** - Authentication and authorization
- **MySQL** - Relational database
- **Maven** - Dependency management and build tool
- **Lombok** - Code generation library

### Frontend
- **Angular 20** - Modern web framework
- **TypeScript 5.9** - Typed JavaScript
- **RxJS** - Reactive programming library
- **SCSS** - Enhanced CSS preprocessing

## Prerequisites

Before running this application, ensure you have the following installed:

- **Java 17** or higher
- **Node.js 18+** and npm
- **MySQL 8.0+**
- **Maven 3.6+**
- **Git**

## Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/ajay-movies.git
cd ajay-movies
```

### 2. Backend Setup

Navigate to the backend directory:

```bash
cd ajayMoviesBackend
```

Update the database configuration in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ajay_movies_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Build and run the Spring Boot application:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The backend will start on `http://localhost:8080`.

### 3. Frontend Setup

Navigate to the frontend directory:

```bash
cd ../FrontEnd
```

Install dependencies:

```bash
npm install
```

Start the Angular development server:

```bash
npm start
```

The frontend will be available at `http://localhost:4200`.

## Usage

### For Users
1. Visit the home page to browse available movies
2. Register/Login to access premium features
3. Download or stream movies directly from the platform

### For Administrators
1. Access the admin dashboard at `/admin`
2. Add new movies with metadata and file uploads
3. Manage user accounts and permissions
4. Monitor platform analytics

## API Documentation

The backend provides RESTful endpoints for all operations:

- `GET /api/movies` - Retrieve all movies
- `POST /api/movies` - Add new movie (Admin only)
- `PUT /api/movies/{id}` - Update movie details
- `DELETE /api/movies/{id}` - Remove movie
- `POST /api/auth/login` - User authentication

For detailed API documentation, refer to the Swagger UI at `http://localhost:8080/swagger-ui.html` when the application is running.

## Project Structure

```
ajay-movies/
├── ajayMoviesBackend/          # Spring Boot backend
│   ├── src/
│   │   ├── main/java/com/ajayMovies/ajayMoviesBackend/
│   │   │   ├── Controller/     # REST controllers
│   │   │   ├── Entity/         # JPA entities
│   │   │   ├── Repository/     # Data access layer
│   │   │   ├── Services/       # Business logic
│   │   │   ├── Security/       # Authentication config
│   │   │   └── DTO/            # Data transfer objects
│   │   └── resources/
│   └── pom.xml
├── FrontEnd/                   # Angular frontend
│   ├── src/app/
│   │   ├── admin/              # Admin components
│   │   ├── home/               # Home page
│   │   ├── download-page/      # Download interface
│   │   └── Services/           # Angular services
│   └── package.json
├── uploads/                    # File storage
└── README.md
```

## Contributing

I welcome contributions from the community! As someone who's been actively contributing to open-source projects for over 10 years, I believe in collaborative development. Here's how you can contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines

- Follow the existing code style and conventions
- Write comprehensive unit tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting PRs

## Testing

Run backend tests:

```bash
cd ajayMoviesBackend
./mvnw test
```

Run frontend tests:

```bash
cd FrontEnd
npm test
```

## Deployment

### Backend Deployment
Build the JAR file:

```bash
cd ajayMoviesBackend
./mvnw clean package -DskipTests
```

Run with:

```bash
java -jar target/ajayMoviesBackend-0.0.1-SNAPSHOT.jar
```

### Frontend Deployment
Build for production:

```bash
cd FrontEnd
npm run build --prod
```

Deploy the `dist/` folder to your web server.

## Security Considerations

- Passwords are hashed using BCrypt
- JWT tokens for stateless authentication
- CORS configured for frontend-backend communication
- Input validation on all endpoints
- File upload restrictions for security

## Performance Optimizations

- Lazy loading in Angular for better initial load times
- Database indexing on frequently queried fields
- Caching strategies for static assets
- Optimized queries with JPA specifications

## Troubleshooting

### Common Issues

1. **Database Connection Failed**
   - Verify MySQL is running
   - Check credentials in `application.properties`

2. **Frontend Build Errors**
   - Clear node_modules: `rm -rf node_modules && npm install`
   - Update Angular CLI if needed

3. **CORS Errors**
   - Ensure backend CORS configuration allows frontend origin

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

**Ajay Kumar**
- GitHub: [@ankitdoi-coder](https://github.com/ankitdoi-coder)
- LinkedIn: [Ankit Kumar Gurjar](https://linkedin.com/in/ankit--gurjar)
- Email: ankitdoi82@gmail.com

---

*Built with ❤️ by a passionate full-stack developer with 10+ years of experience. Regular commits, clean code, and scalable architecture are my hallmarks. Star this repo if you find it useful!* 🚀