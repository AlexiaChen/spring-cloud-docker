package com.springclouddocker.userservice.controller;

import com.springclouddocker.userservice.domain.User;
import com.springclouddocker.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *  User Micro-Service
 *  Actually, In product enviroment. User Service is one process on a Server (separated from Movie Service with a process on a server)
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User user = this.userRepository.findOne(id);
        return user;
    }
}
