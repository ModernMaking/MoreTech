package com.example.vtb2;

import controller.UserController;
import model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import repo.UserRepository;

@EntityScan(basePackageClasses = {User.class})
@SpringBootApplication(scanBasePackageClasses = {UserRepository.class})
@ComponentScan(basePackageClasses = {UserController.class})
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
@Configuration
public class Vtb2Application {

    public static void main(String[] args) {
        SpringApplication.run(Vtb2Application.class, args);
    }

    @PostMapping("/postbody")
    public String postBody(@RequestBody String fullName) {
        return "Hello " + fullName;
    }

    @GetMapping("/getbody")
    public String getBody(@RequestBody String fullName)
    {
        return "Hello "+fullName;
    }

}
