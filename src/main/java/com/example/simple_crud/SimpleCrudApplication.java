package com.example.simple_crud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        tags = @Tag(name = "Main tag"),
    info = @Info(
            version = "3.0.8",
            description = "this is the simple_crud project",
            title = "simole_crud project",
            contact = @Contact(
                    name = "hasanboy",
                    url = "hgfdsqwer6543",
                    email = "hasanboyjorayev122@gmail.com"
            ),
            license = @License(
                    name = "simple project",
                    url = "jhgfdsqwerty765"
            )


    ),
        servers = {@Server(url = "localhost:7171")}
)



@SpringBootApplication
public class SimpleCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCrudApplication.class, args);
    }

}
