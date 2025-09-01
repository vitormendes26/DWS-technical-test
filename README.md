# Technical Test - Isobar.fm Backend

Technical backend test for DWS Brazil.

## General Set Up

1: Navigate to the root directory of the project and run docker-compose up.

2: After the containers are up and running, launch the application by executing the BandsApplication class.

3: Swagger UI = http://localhost:8080

## **Project folder structure**

```
      📦
      ├── 📁 src                                      # Application source code
      │   ├── 📁 main                                 # Main codebase, where business logic is applied
      │   │   ├── 📁 java/com/dws/isobar/fm/bands     # Application domain package path
      │   │   │   ├── 📁 adapter                      # Anti-Corruption Layer (ACL)
      │   │   │   ├── 📁 api                          # Application layer, acts as the backend entry point, handling requests and returning responses
      │   │   │   │   ├── 📁 controller               # Handles incoming HTTP requests via endpoints
      │   │   │   │   ├── 📁 doc                      # Documentation for the endpoints defined in the controller
      │   │   │   │   ├── 📁 handler                  # Handles exceptions and system errors
      │   │   │   │   └── 📁 model                    # Data Transfer Object (DTO) definitions
      │   │   │   ├── 📁 domain                       # Core domain logic and structure
      │   │   │   │   ├── 📁 enums                    # Enums used throughout the application
      │   │   │   │   ├── 📁 exception                # Custom business exceptions
      │   │   │   │   ├── 📁 model                    # Entity definitions and database structure
      │   │   │   │   ├── 📁 service                  # Domain services containing business interfaces
      │   │   │   ├── 📁 infrastructure               # Configuration and support resources for the entire application
      │   │   │   │   ├── 📁 client                   # External API integrations
      │   │   │   │   ├── 📁 config                   # Project configurations such as Beans, Properties, etc.
      │   │   │   │   └── 📁 service                  # Implementation of domain logic
      │   │   │   ├── 📄 BandsApplication.java        # Main application class
      ├── 📁 target                                   # Directory for compiled and packaged files
      ├── 📄 README.md
      └── 📄 pom.xml
```

## **Composição**

- [x] [Java 21](https://docs.oracle.com/en/java/javase/21/)
- [x] [Springboot 3](https://spring.io/projects/spring-boot)

##  Setting Up Postman Requests for All Created Endpoints

- Open Postman and create a GET request to the following URL: http://localhost:8080/api-docs, then execute the request.
- In the response section, click the three dots in the upper-right corner of the Body tab and select Save response to file. Save the response body as a JSON file in your preferred location. This file will contain all available backend requests for the Technical Test.
- In the upper-left corner of Postman, click Import. In the window that opens, choose the Files option and select the JSON file saved in the previous step.
- Click Import to complete the process. This will load all available backend requests into Postman for testing.
- Create a new Environment in Postman and define a variable called baseUrl with the string value of the host address to be used. For local execution, the value should be 'http://localhost:8080'.
- You now have a fully configured Postman environment with all backend endpoints ready for testing.
