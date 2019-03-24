package com.springclouddocker.config;

import feign.Contract;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Encoder;

@Configuration
public class FeignConfiguration {

    @Bean
    public Contract feignContract(){
        // user default feign contract
        // It could use custom annotation that providing from feign
        return new feign.Contract.Default();
    }

    @Bean
    public Encoder feignEncoder(){
        return new feign.codec.Encoder.Default();
    }

    @Bean
    public Decoder feignDecoder(){
        return new feign.codec.Decoder.Default();
    }
}
