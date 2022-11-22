package com.lld.splitwise.services;

import com.lld.splitwise.models.User;
import com.lld.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String phoneNumber, String password, String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }
}
