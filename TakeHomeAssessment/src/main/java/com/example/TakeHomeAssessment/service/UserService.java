package com.example.TakeHomeAssessment.service;

import com.example.TakeHomeAssessment.domain.User;
import com.example.TakeHomeAssessment.error.ResourceNotFoundException;
import com.example.TakeHomeAssessment.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        user.setGender(userDetails.getGender());
        return userRepository.save(user);
    }
}
