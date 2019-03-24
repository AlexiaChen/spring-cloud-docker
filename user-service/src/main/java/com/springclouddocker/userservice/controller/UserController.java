package com.springclouddocker.userservice.controller;

import com.springclouddocker.userservice.domain.User;
import com.springclouddocker.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 *  User Micro-Service
 *  Actually, In product enviroment. User Service is one process on a Server (separated from Movie Service with a process on a server)
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    private void printUserAuth(UserDetails userDetails){
        Collection<? extends GrantedAuthority> collection = userDetails.getAuthorities();
        for(GrantedAuthority c : collection){
            UserController.LOGGER.info("Current user is {}, Current role is {}", userDetails.getUsername(),
                    c.getAuthority());
        }
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            printUserAuth((UserDetails) principal);
        }

        User user = this.userRepository.findOne(id);
        return user;
    }

    /*
    * Input params is equal to Out Params
    */
    @GetMapping("/get")
    public User get(User user){
        return user;
    }

    /*
     * Input params is equal to Out Params
     */
    @PostMapping("/post")
    public User post(User user){
        return user;
    }
}
