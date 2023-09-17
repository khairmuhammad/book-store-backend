package com.khair.bookstorebackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.khair.bookstorebackend.dto.enums.Role;
import com.khair.bookstorebackend.dto.requests.RegisterRequest;
import com.khair.bookstorebackend.service.AuthenticationService;


@SpringBootApplication
public class BookStoreBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(Role.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("Manager")
                    .lastname("Manager")
                    .email("manager@mail.com")
                    .password("password")
                    .role(Role.MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

            var student = RegisterRequest.builder()
                    .firstname("Student")
                    .lastname("Student")
                    .email("student@mail.com")
                    .password("password")
                    .role(Role.STUDENT)
                    .build();
            System.out.println("Student token: " + service.register(student).getAccessToken());
        };
    }
}
