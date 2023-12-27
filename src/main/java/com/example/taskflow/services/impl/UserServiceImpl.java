package com.example.taskflow.services.impl;

import com.example.taskflow.entities.User;
import com.example.taskflow.repositories.UserRepository;
import com.example.taskflow.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
//        TODO: Implement this method
        return null;
    }

    @Override
    public User getUserById(Long id) {
//        TODO: Implement this method
        return null;
    }

    @Override
    public User createUser(User user) {
//        TODO: Implement this method
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
//        TODO: Implement this method
        return null;
    }

    @Override
    public void deleteUser(Long id) {
//       TODO: Implement this method
    }
}
