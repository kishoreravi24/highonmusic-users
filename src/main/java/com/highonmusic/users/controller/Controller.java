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

    private String token="";
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

    @GetMapping("/getUsers")
    public List<AuthenticationDto> getAllUsersData(){
        return usersdao.findAll();
    }

    @GetMapping("/getToken/{username}/{password}")
    public String getAllUsersData(@PathVariable String username,@PathVariable String password) {
        boolean is_authenticated = usersdao.existsByUsernameAndPassword(username,password);
        if(is_authenticated){
            token = jwtService.generateToken(username);
            if(token.length()>=10) {
                return "Logged In success";
            }
        }else{
            token="";
        }
        return "Failed";
    }

    @GetMapping("/passToken")
    public String passToken(){
        return token;
    }
}
