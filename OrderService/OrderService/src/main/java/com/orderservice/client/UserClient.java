package com.orderservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.SimpleTimeZone;

@FeignClient(name = "UserService")
public interface UserClient {

    @GetMapping("/users/{id}")
    public Map<String,Object> getUserById(@PathVariable Integer id);
}
