# Aircraft Maintenance Tracking System - Backend

## Overview

This repository contains the backend code for an Aircraft Maintenance Tracking System. The system is designed to manage and track information related to flights, maintenance records, and the status of maintenance activities for aircraft.

## Technologies Used

- **Spring Boot**: The backend is implemented using the Spring Boot framework, providing a robust and scalable foundation for building Java-based applications.

- **RESTful API**: The application exposes a set of RESTful APIs to perform CRUD (Create, Read, Update, Delete) operations on flight and maintenance data.

- **JPA (Java Persistence API)**: JPA is used for managing the persistence of Java objects to the database. It simplifies database interactions and allows for easy integration with various databases.

- **H2 Database**: The H2 database is used as an in-memory database for development and testing purposes. It provides a lightweight and fast database solution.

## API Endpoints

The following API endpoints are available:

- **GET /flights**: Retrieve a list of flight information.
- **GET /maintenance**: Retrieve a list of maintenance records.
- **GET /flightdamaged**: Retrieve a list of flights requiring maintenance.
- **GET /flightsstatus/{status}**: Retrieve a list of maintenance records based on status.
- **POST /newflight**: Add a new flight record.
- **POST /newmaintenance**: Add a new maintenance record.
- **PUT /updateflight/{aid}**: Update flight information.
- **PUT /updateDamage/{mid}**: Update maintenance information.
- **DELETE /deleteFlight/{aid}**: Delete a flight record.
- **DELETE /deleteRecord/{mid}**: Delete a maintenance record.
- **GET /flightsbyid/{aid}**: Retrieve a specific flight record by ID.
- **GET /maintenancebyid/{mid}**: Retrieve a specific maintenance record by ID.

## Setup Instructions

1. Clone the repository: `git clone https://github.com/BonifaceNoel/Aircraft-Maintenance-System-Backend.git`
2. Navigate to the project directory: `cd Aircraft-Maintenance-System-Backend`
3. Build the project: `./mvnw clean install`
4. Run the application: `./mvnw spring-boot:run`

Make sure you have Java and Maven installed on your machine.

## Configuration

- The application is configured to allow cross-origin requests from `http://localhost:5173`.
- The H2 database console is accessible at `http://localhost:8090/h2-console` with JDBC URL `jdbc:mysql://localhost:3306/aircraft_maintenance_system`.

## Contributing

If you would like to contribute to the development of this project, please follow the [contribution guidelines](CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE).

## Author

[Boniface Noel]

Feel free to reach out if you have any questions or feedback!
