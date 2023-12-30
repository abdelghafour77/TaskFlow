package com.example.taskflow.seeder.dbSeeder;

import com.example.taskflow.auth.AuthenticationRequest;
import com.example.taskflow.auth.AuthenticationService;
import com.example.taskflow.auth.RegisterRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.example.taskflow.entities.enums.Role.ADMIN;
import static com.example.taskflow.entities.enums.Role.USER;

@Component
public class UserSeeder {
    private final AuthenticationService authenticationService;
    private final RegisterRequest[] users = {
            RegisterRequest.builder()
                    .firstname("Abdelghafour")
                    .lastname("Aouad")
                    .email("abdelghafour.aouad0@gmail.com")
                    .password("password")
                    .role(USER)
                    .build(),
            RegisterRequest.builder()
                    .firstname("Mouad")
                    .lastname("Amraoui")
                    .email("mouad@gmail.com")
                    .password("password")
                    .role(USER)
                    .build(),

    };

    public UserSeeder(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private void log() {
        System.out.println("----------------------Users----------------------");
    }

    public void seed() {
        this.log();
        if (authenticationService.existsByEmail("abdelghafour.aouad0@gmail.com")) {
//            System.out.println("Abdelghafour Token: " + authenticationService.authenticate(
//                    new AuthenticationRequest("abdelghafour.aouad0@gmail.com", "password")).getAccessToken()
//            );
        } else {
            System.out.println("Abdelghafour token: " + authenticationService.register(users[0]).getAccessToken());
        }
        if (authenticationService.existsByEmail("mouad@gmail.com")) {
//            System.out.println("Mouad Token: " + authenticationService.authenticate(
//                    new AuthenticationRequest("mouad@gmail.com", "password")).getAccessToken()
//            );
        } else {
            System.out.println("Mouad token: " + authenticationService.register(users[1]).getAccessToken());
        }
    }
}
