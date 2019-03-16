# Movie Collection App

Movie Collection App gives you opportunity to explore Spring Boot, Spring Security and JPA! You can use CRUD operations and see how ManyToMany relationship works with Thymeleaf!

**IMPORTANT:** ManyToMany relationship is not working for now. It will work in a few days I hope. Stars will be replaced with Actors.

## Technologies

Sprint Boot  
Maven  
Thymeleaf  
Spring Data JPA  
Spring Security
JUnit

## Manage Settings

in src/main/resources we have application.properties file.

**application.properties**

    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/movieapp
    spring.datasource.username=root
    spring.datasource.password=123

Change this file for your database connection.

If you want to change initialization of the database for changing genres, languages or user credentials you can do it with;

    vi /src/main/resources/db/migration

## Install & Run

Use these commands.

    mvn clean install && mvn spring-boot:run

Then go to the localhost:8080.

If you just want to run tests then;

    mvn test

**Admin e-mail and password:** admin@movieapp.com:admin

**Normal user e-mail and password:** mail@fatihkoc.net:fatih

If you want to create new user just use **Register** button in the login page!

## Why Used This Technologies

**Sprint Boot:** Spring library is one of the best known libraries in Java world and I can find a lot of information about it. That is why I chose Spring for my project.

**Maven:** My project needs to be run without IDE configurations. It also work fine with Spring Boot

**Spring Security:** Spring Security is fundamental for login-register system. I can manage which roles can access which pages. Using Spring Security is very simple and this is the main security library for Spring.

**Thymeleaf:** Thymeleaf was not my first decision but Thymeleaf have a lot of tutorials in the internet. I tried VueJS but Thymeleaf have better integration with Spring library.

**JUnit:** It is coming with "spring-boot-starter-test". I prefer built-in solution while I am learning new technologies.
