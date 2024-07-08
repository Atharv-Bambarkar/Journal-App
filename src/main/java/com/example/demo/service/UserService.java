package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

     public void saveEntry(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
           log.error("Error saving user", e);
        }
    }



    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getEntryById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteEntryById(ObjectId id) {
        userRepository.deleteById(id);
    }

public User findUserByUserName(String userName) {
    return userRepository.findByUserName(userName);
}
    
}
