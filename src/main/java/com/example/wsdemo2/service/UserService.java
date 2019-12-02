package com.example.wsdemo2.service;

import com.example.wsdemo2.entity.User;
import com.example.wsdemo2.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CommonService<UserRepo, User> {
}
