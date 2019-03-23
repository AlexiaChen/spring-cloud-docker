package com.springclouddocker.movieservice.config;

import com.springclouddocker.config.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "microservice-user-service", configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
