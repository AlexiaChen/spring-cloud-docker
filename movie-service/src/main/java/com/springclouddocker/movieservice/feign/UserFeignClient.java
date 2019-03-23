package com.springclouddocker.movieservice.feign;

import com.springclouddocker.config.FeignConfiguration;
import com.springclouddocker.movieservice.domain.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name="microservice-user-service", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
