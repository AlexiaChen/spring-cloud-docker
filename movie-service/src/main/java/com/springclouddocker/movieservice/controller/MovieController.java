package com.springclouddocker.movieservice.controller;

import com.springclouddocker.movieservice.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


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


    @GetMapping("/user-service-instance/info/log")
    public void logUserServiceInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-user-service");

        // print which node of user-service
        MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(),
                serviceInstance.getPort());
    }
}
