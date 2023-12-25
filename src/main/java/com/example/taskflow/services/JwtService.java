package com.example.taskflow.services;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    public String extractUserEmail(String jwt);


    Boolean isTokenValid(String token, UserDetails userDetails);

    String generateToken(UserDetails userDetails);
}
