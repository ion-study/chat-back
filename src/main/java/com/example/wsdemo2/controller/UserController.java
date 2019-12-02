package com.example.wsdemo2.controller;

import com.example.wsdemo2.entity.User;
import com.example.wsdemo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends CommonController<UserService, User>{

    @Autowired
    UserService service;

    @RequestMapping("/list/{userId}")
    public Map customList(@PathVariable String userId) {
        return service.customList(userId);
    }

}
