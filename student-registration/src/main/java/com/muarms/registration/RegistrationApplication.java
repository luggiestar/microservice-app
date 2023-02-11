package com.muarms.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class RegistrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }
}
