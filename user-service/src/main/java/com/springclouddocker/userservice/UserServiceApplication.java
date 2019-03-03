package com.springclouddocker.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Or you can use @EnableEurekaClient.  but @EnableDiscoveryClient is portable between Eureka, Zookeeper, Consul
public class UserServiceApplication {
	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);
	}

}
