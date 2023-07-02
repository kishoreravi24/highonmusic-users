package com.highonmusic.users.controller;

import com.highonmusic.users.dao.Testdao;
import com.highonmusic.users.dto.AuthenticationDto;
import com.highonmusic.users.dto.TestDto;
import com.highonmusic.users.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@EnableDiscoveryClient
public class Controller {

    private final Testdao testdao;
    @Autowired
    private JwtService jwtService;

    @GetMapping("")
    public String getUsers(){
        return "Hello from users microservice";
    }

    @Autowired
    public Controller(Testdao testdao) {
        this.testdao = testdao;
    }

    @GetMapping("/getusers")
    public List<TestDto> getAllTestData() {
        return testdao.findAll();
    }

    @PostMapping("/authenticate")
    public String authenticationAndGetToken(@RequestBody AuthenticationDto authenticationDto){
        return jwtService.generateToken(authenticationDto.getUsername());
    }
}
