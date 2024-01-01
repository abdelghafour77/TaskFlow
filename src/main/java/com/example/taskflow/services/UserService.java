package com.example.taskflow.services;

import com.example.taskflow.dto.requests.ChangePasswordRequest;
import com.example.taskflow.entities.User;


import java.security.Principal;

public interface UserService {

    void changePassword(ChangePasswordRequest request, Principal connectedUser);
    User getUserByEmail(String email);
}
