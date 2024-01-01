package com.example.taskflow.seeder;


import com.example.taskflow.seeder.dbSeeder.AdminSeeder;
import com.example.taskflow.seeder.dbSeeder.TagSeeder;
import com.example.taskflow.seeder.dbSeeder.UserSeeder;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AppSeeder {
    private final UserSeeder userSeeder;
    private final AdminSeeder adminSeeder;
    private final TagSeeder tagSeeder;


    public AppSeeder(UserSeeder userSeeder, AdminSeeder adminSeeder, TagSeeder tagSeeder) {
        this.userSeeder = userSeeder;
        this.adminSeeder = adminSeeder;
        this.tagSeeder = tagSeeder;
    }

    @PostConstruct
    public void init() {
        adminSeeder.seed();
        userSeeder.seed();
        tagSeeder.seed();

    }
}

