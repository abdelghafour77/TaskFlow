package com.example.taskflow.seeder.dbSeeder;

import com.example.taskflow.auth.AuthenticationRequest;
import com.example.taskflow.auth.AuthenticationService;
import com.example.taskflow.auth.RegisterRequest;
import org.springframework.stereotype.Component;


import static com.example.taskflow.entities.enums.Role.ADMIN;

@Component
public class AdminSeeder {
    private final AuthenticationService authenticationService;
    private final RegisterRequest admin = RegisterRequest.builder()
            .firstname("Admin")
            .lastname("Admin")
            .email("admin@mail.com")
            .password("password")
            .role(ADMIN)
            .build();

    public AdminSeeder(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private void log() {
        System.out.println("----------------------Admin----------------------");
    }

    public void seed() {
        this.log();
        if (authenticationService.existsByEmail("admin@mail.com")) {
//            AuthenticationRequest authenticationRequest = new AuthenticationRequest("admin@gmail.com", "password");
//            String a = authenticationService.authenticate(authenticationRequest).getAccessToken();
//            System.out.println(a);
        } else {
            System.out.println("Admin token: " + authenticationService.register(admin).getAccessToken());
        }
    }
}
