package com.springclouddocker.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient // Or you can use @EnableEurekaClient.  but @EnableDiscoveryClient is portable between Eureka, Zookeeper, Consul
@SpringBootApplication
public class UserServiceApplication {
	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);
	}

}
