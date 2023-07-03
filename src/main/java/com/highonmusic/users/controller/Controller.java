package com.highonmusic.users.controller;

import com.highonmusic.users.dao.Testdao;
import com.highonmusic.users.dao.Usersdao;
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
    private final Usersdao usersdao;
    @Autowired
    private JwtService jwtService;

    @GetMapping("")
    public String getUsers(){
        return "Hello from users microservice";
    }

    @Autowired
    public Controller(Testdao testdao, Usersdao usersdao) {
        this.testdao = testdao;
        this.usersdao = usersdao;
    }

    @GetMapping("/getTest")
    public List<TestDto> getAllTestData() {
        return testdao.findAll();
    }

    @PostMapping("/getUsers")
    public String getAllUsersData(@RequestBody AuthenticationDto authenticationDto) {
        boolean is_authenticated = usersdao.existsByUsernameAndPassword(authenticationDto.getUsername(),authenticationDto.getPassword());
        if(is_authenticated){
            String token = jwtService.generateToken(authenticationDto.getUsername());
             if(token.length()>=10){
                 return "Token match";
             }
        }
        return "Token mismatch";
    }

//    @PostMapping("/authenticate")
//    public String authenticationAndGetToken(@RequestBody AuthenticationDto authenticationDto){
//        return jwtService.generateToken(authenticationDto.getUsername());
//    }
}
