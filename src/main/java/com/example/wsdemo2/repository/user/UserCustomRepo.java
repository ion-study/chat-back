package com.example.wsdemo2.repository.user;

import com.example.wsdemo2.entity.User;

import java.util.List;

public interface UserCustomRepo {
    List<User> getCustom(String userId);
}
