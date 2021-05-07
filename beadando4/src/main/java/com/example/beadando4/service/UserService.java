package com.example.beadando4.service;
import com.example.beadando4.model.User;
import com.example.beadando4.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
