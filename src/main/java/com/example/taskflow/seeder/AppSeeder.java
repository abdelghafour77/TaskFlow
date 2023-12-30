package com.example.taskflow.seeder;


import com.example.taskflow.seeder.dbSeeder.AdminSeeder;
import com.example.taskflow.seeder.dbSeeder.UserSeeder;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AppSeeder {
    private final UserSeeder userSeeder;
    private final AdminSeeder adminSeeder;


    public AppSeeder(UserSeeder userSeeder, AdminSeeder adminSeeder) {
        this.userSeeder = userSeeder;
        this.adminSeeder = adminSeeder;
    }

    @PostConstruct
    public void init() {
       adminSeeder.seed();
        userSeeder.seed();

    }
}

