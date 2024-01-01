package com.example.taskflow.services.impl;

import com.example.taskflow.dto.requests.ChangePasswordRequest;
import com.example.taskflow.entities.User;
import com.example.taskflow.repositories.UserRepository;
import com.example.taskflow.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor

public class UserServiceImpl  implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    @Override
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        repository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow();
    }

    @Scheduled(cron = "${application.schedule.refresh.test-cron}")
    public void test() {
        System.out.println("test schedule");
    }

    @Scheduled(cron = "${application.schedule.refresh.change-cron}")
    public void resetChangeCard() {
        System.out.println("resetChangeCard");
        List<User> users=repository.findAll();
        for(User user:users){
            user.setChangeCard(0);
            repository.save(user);
        }
    }

    @Scheduled(cron = "${application.schedule.refresh.delete-cron}")
    public void resetDeleteCard() {
        System.out.println("resetDeleteCard");
        List<User> users=repository.findAll();
        for(User user:users){
            user.setDeleteCard(0);
            repository.save(user);
        }
    }
}
