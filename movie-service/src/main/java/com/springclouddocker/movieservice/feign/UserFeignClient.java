package com.springclouddocker.movieservice.feign;

import com.springclouddocker.movieservice.domain.User;
import feign.Param;
import feign.RequestLine;

public interface UserFeignClient {

    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
