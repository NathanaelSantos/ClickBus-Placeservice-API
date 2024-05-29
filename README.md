
![clickbus-destaque](https://github.com/NathanaelSantos/placeservice/assets/45519156/38eaca87-95f7-4025-9dd3-e61025549a83)

---

# Backend Developer Challenge

This is a simple challenge to test your skills on building APIs.The ClickBus serivices use mainly Java and Springboot technologies.However, you can use language and framwork that you feel more confortable.

# What to do
```
Create a simple API to manage places (CRUD).This API should allow to:

- Create a place
- Edit a placa
- Get a specific place
- List places and filter them by name
```
```
A place must have the following fields:

- name
- slug
- city
- state
- created at
- update at
```

# Requirements
```
- All API responses must be JSON
- Provide a README.md file with usage instructions(how to run, endpoints etc)
- Provide a testing environment(docker, etc)
```
# Recommendations
```
- Tests, tests and tests
- SOLID
- Code and commits in english(methods, classes, variables, etc)
```
# Evaluation
```
- Project structure, architecturing and organization
- Programming good practices
- VCS practices
```
# Delivery
You musk fork this repository and commit the solution in the solution folder.Your repository must be public.After that, send the repository link on the kenoby platform

---


# 🚀 Technologies Used
This project was developed with the following technologies:

- Spring Boot
- Spring Webflux
- Spring Data + R2DBC

# 📚 Patterns Used
The following design patterns were used in this project:

- SOLID
- Integration tests

# 💻 How to Run the Project
To run this project locally, follow these steps:

1. Clone the git repository to your local machine using `git clone`.
2. Navigate to the project folder and run the command `mvn spring-boot:run` to start the application.
3. The API will be available at `localhost:8080`.

# 📝 API Endpoints
To make HTTP requests, you can use the httpie tool, Postman, or any other of your preference.

[api-docs-swagger](http://localhost:8080/webjars/swagger-ui/index.html)

![Screenshot 2024-05-28 213755](https://github.com/NathanaelSantos/ClickBus-Placeservice-API/assets/45519156/70b01625-70c0-402f-80c7-e235554f570a)


![Screenshot 2024-05-10 215951](https://github.com/NathanaelSantos/ClickBus-Placeservice-API/assets/45519156/98719d4a-2c7a-485c-822e-a19f7a8a3302)

Here is an example of how to make a POST request to the `/places` endpoint:

```bash
http POST :8080/places name="Place Name" state="State"
```

# 🧪 Testes do PlaceService
Os testes do PlaceService são escritos usando JUnit 5 e o WebTestClient do Spring Boot.

![Screenshot 2024-05-10 222445](https://github.com/NathanaelSantos/ClickBus-Placeservice-API/assets/45519156/a1b276f4-ffec-43cc-a320-7089a0167f9e)

# 🐋 Docker

1. **Project Compilation**

    The following command is used to compile the project and package the result into a JAR file:

    ```bash
    ./mvnw clean package
    ```

2. **Building the Docker Image**

    The following command is used to build a Docker image of the project using the Spring Boot:

    ```bash
    ./mvnw spring-boot:build-image
    ```

3. **Running the Docker Image**

    The following command is used to run the Docker image:

    ```bash
    docker run --name placeservice -p 8080:8080 -d placeservice:0.0.1-SNAPSHOT
    ```

    This will start a Docker container named `placeservice`, map the container's port 8080 to the host's port 8080, and run the container in the background.



![Screenshot 2024-05-10 225605](https://github.com/NathanaelSantos/ClickBus-Placeservice-API/assets/45519156/535b4e44-9ca5-4089-89f0-4bbd90b6fc0c)


