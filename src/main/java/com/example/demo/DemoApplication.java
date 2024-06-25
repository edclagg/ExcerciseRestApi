package com.example.demo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api REST catalog")
                        .version("1.0")
                        .description("A sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3 for documenting APIs. The service includes CRUD operations for managing users and their accounts with H2 DB and JPA "));
    }


}
