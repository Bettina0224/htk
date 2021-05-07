package com.example.beadando4.service;

import com.example.beadando4.model.User;
import com.example.beadando4.repository.UserRepository;
import com.example.beadando4.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getUserName(),
                registrationDto.getPassword());

        return userRepository.save(user);
    }

    public User loadUserByUsername(String username) throws Exception {
        User user = userRepository.findUsersByUserName(username);
        if (user == null) {
            throw new Exception("Nem megfelelo");
        }
        return (User) user;
    }

    public User save() {
        return null;
    }
}

