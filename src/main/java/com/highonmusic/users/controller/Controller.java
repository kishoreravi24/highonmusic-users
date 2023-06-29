package com.highonmusic.users.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@EnableDiscoveryClient
public class Controller {
    @GetMapping("")
    public String getUsers(){
        return "Hello from users microservice";
    }
}
