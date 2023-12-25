package com.example.taskflow.services;

import com.example.taskflow.entities.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User createUser(String user);
    public User updateUser(Long id, String user);
    public void deleteUser(Long id);
}
