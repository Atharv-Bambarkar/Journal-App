package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
public class UserEntryController {

    @Autowired
    private  UserService userService;

    @GetMapping() 
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @PostMapping()
    public void saveEntry(@RequestBody User user) {
        userService.saveEntry(user);
    }


    @PutMapping("/{userName}")
public ResponseEntity<?> updateEntry(@PathVariable String userName, @RequestBody User user) {
       User userInDb= userService.findUserByUserName(userName);
        if(userInDb!=null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        } 
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }







}
