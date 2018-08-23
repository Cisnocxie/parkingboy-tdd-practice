package com.example.parkingboytddpractice.services;

import com.example.parkingboytddpractice.entities.User;
import com.example.parkingboytddpractice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(User user) {
        try {
            String password = UUID.randomUUID().toString().substring(0, 7);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String encodedPassword = new BigInteger(1, md5.digest(password.getBytes("utf-8"))).toString(16);
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return password;
        } catch (Exception e) {
            return null;
        }
    }

}