package com.example.taskflow.controllers;

import com.example.taskflow.entities.User;
import com.example.taskflow.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    final private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(User user) {
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, User user) {
        return ResponseEntity.ok().body(userService.updateUser(id, user));
    }


}
