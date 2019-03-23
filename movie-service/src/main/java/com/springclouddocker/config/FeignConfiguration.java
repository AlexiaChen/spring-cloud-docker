package com.springclouddocker.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Contract feignContract(){
        // user default feign contract
        // It could use custom annotation that providing from feign
        return new feign.Contract.Default();
    }
}
