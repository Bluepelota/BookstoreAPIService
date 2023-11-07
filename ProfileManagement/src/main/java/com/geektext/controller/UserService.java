package com.geektext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Geektext.repository.UserRepository;
import profilemanagement.demo.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(profilemanagement.demo.User user) {
        return userRepository.save(user); 
    }

    public profilemanagement.demo.User getUserByUsername(String username) {
        // User retrieval logic
        return userRepository.findByUsername(username); // Find user by username
    }

    public User updateUser(String username, User updatedUser) {
        profilemanagement.demo.User existingUser = userRepository.findByUsername(username);

        if (existingUser != null) {
            // Update user fields except for email
            if (updatedUser.getName() != null) {
                existingUser.setName(updatedUser.getName());
            }
            if (updatedUser.getHomeAddress() != null) {
                existingUser.setHomeAddress(updatedUser.getHomeAddress());
            }

            // Save the updated user to the database
            return userRepository.save(existingUser);
        } else {
            // Handle user not found
            return null;
        }
    }

    public org.springframework.boot.autoconfigure.security.SecurityProperties.User createUser(
            org.springframework.boot.autoconfigure.security.SecurityProperties.User user) {
        return null;
    }

    public org.springframework.boot.autoconfigure.security.SecurityProperties.User updateUser(String username,
            org.springframework.boot.autoconfigure.security.SecurityProperties.User updatedUser) {
        return null;
    }
}
