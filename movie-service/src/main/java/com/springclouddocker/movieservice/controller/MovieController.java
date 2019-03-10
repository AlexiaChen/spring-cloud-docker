package com.springclouddocker.movieservice.controller;

import com.springclouddocker.movieservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
*  Movie Micro-Service
*  Actually, In product enviroment. Movie Service is one process on a Server (separated from User Service with a process on a server)
*/

@RestController
public class MovieController {

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){

        // movie service call user service findById API. User service in another process in distributed env
        return this.restTemplate.getForObject(this.userServiceUrl + id, User.class);
    }

    @GetMapping("/user-service-instance/info")
    public List<ServiceInstance> showInfo(){
        // you will find your metadata define in user-service from returned json
        return this.discoveryClient.getInstances("microservice-user-service");
    }
}
