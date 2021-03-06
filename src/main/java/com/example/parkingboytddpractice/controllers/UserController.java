package com.example.parkingboytddpractice.controllers;


import com.example.parkingboytddpractice.entities.User;
import com.example.parkingboytddpractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        String password = userService.createUser(user);
        if (password != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(password);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}


