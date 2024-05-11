
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

Here is an example of how to make a POST request to the `/places` endpoint:

```bash
http POST :8080/places name="Place Name" state="State"
```

# 🧪 Testes do PlaceService
Os testes do PlaceService são escritos usando JUnit 5 e o WebTestClient do Spring Boot.
```

