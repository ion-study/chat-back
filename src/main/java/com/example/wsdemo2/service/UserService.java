package com.example.wsdemo2.service;

import com.example.wsdemo2.entity.User;
import com.example.wsdemo2.repository.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService extends CommonService<UserRepo, User> {

    @Autowired
    UserRepo userRepo;

    public Map customList(String userId) {
        Map<String, Object> result = new ConcurrentHashMap<>();
        List<User> list;
        try {
            list = userRepo.getCustom(userId);
            result.put("result","success");
            result.put("data",list);
        } catch (Exception e) {
            result.put("result","fail");
            logger.error("create error : ",e);
        }
        return result;
    }
}
