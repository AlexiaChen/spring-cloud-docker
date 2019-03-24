package com.springclouddocker.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfiguration {

    @Bean
    Logger.Level feignLoggerLeve(){
        return Logger.Level.FULL;
    }
}
