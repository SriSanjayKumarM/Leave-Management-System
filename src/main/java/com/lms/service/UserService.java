package com.lms.service;

import com.lms.model.User;
import com.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 1. Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 2. Get user by ID
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 3. Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 4. Update an existing user
    public User updateUser(int id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setRole(updatedUser.getRole());
        return userRepository.save(existingUser);
    }

    // 5. Delete a user
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
