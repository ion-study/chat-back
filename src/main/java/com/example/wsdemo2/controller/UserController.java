package com.example.wsdemo2.controller;

import com.example.wsdemo2.entity.User;
import com.example.wsdemo2.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends CommonController<UserService, User>{
}
