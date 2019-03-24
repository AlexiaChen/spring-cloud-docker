package com.springclouddocker.movieservice.controller;

import com.springclouddocker.movieservice.domain.User;
import com.springclouddocker.movieservice.feign.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
*  Movie Micro-Service
*  Actually, In product enviroment. Movie Service is one process on a Server (separated from User Service with a process on a server)
*/

@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    private UserFeignClient userUserFeignClient;
    private UserFeignClient adminUserFeignClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user", "user123")).target(UserFeignClient.class, userServiceUrl);
        this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin", "admin123"))
                .target(UserFeignClient.class, userServiceUrl);
    }

    @GetMapping("/user-user/{id}")
    public User findByUserId(@PathVariable Long id){

        // movie service call user service findById API. User service in another process in distributed env
        return this.userUserFeignClient.findById(id);
    }

    @GetMapping("/user-admin/{id}")
    public User findByAdminId(@PathVariable Long id){

        // movie service call user service findById API. User service in another process in distributed env
        return this.adminUserFeignClient.findById(id);
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
