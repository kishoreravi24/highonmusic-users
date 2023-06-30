package com.highonmusic.users.controller;

import com.highonmusic.users.dao.Testdao;
import com.highonmusic.users.model.Testmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@EnableDiscoveryClient
public class Controller {

    private final Testdao testdao;

    @GetMapping("")
    public String getUsers(){
        return "Hello from users microservice";
    }

    @Autowired
    public Controller(Testdao testdao) {
        this.testdao = testdao;
    }

    @GetMapping("/getusers")
    public List<Testmodel> getAllTestData() {
        return testdao.findAll();
    }
}
