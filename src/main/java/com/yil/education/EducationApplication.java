package com.yil.education;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.yil"})
@OpenAPIDefinition(info = @Info(title = "Education Api", version = "1.0", description = "Yıldırım Information"))
@SpringBootApplication
public class EducationApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EducationApplication.class, args);
        context.start();
    }
}
