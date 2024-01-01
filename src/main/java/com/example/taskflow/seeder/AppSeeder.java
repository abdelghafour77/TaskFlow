package com.example.taskflow.seeder;


import com.example.taskflow.seeder.dbSeeder.AdminSeeder;
import com.example.taskflow.seeder.dbSeeder.TagSeeder;
import com.example.taskflow.seeder.dbSeeder.TaskSeeder;
import com.example.taskflow.seeder.dbSeeder.UserSeeder;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AppSeeder {
    private final UserSeeder userSeeder;
    private final AdminSeeder adminSeeder;
    private final TagSeeder tagSeeder;
    private final TaskSeeder taskSeeder;


    public AppSeeder(UserSeeder userSeeder, AdminSeeder adminSeeder, TagSeeder tagSeeder, TaskSeeder taskSeeder) {
        this.userSeeder = userSeeder;
        this.adminSeeder = adminSeeder;
        this.tagSeeder = tagSeeder;
        this.taskSeeder = taskSeeder;
    }

    @PostConstruct
    public void init() {
        adminSeeder.seed();
        userSeeder.seed();
        tagSeeder.seed();
        taskSeeder.seed();

    }
}

