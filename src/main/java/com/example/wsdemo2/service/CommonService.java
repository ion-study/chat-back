package com.example.wsdemo2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public abstract class CommonService<T extends JpaRepository,E>{

    @Autowired
    private T repository;

    Logger logger = LoggerFactory.getLogger(CommonService.class);

    public Map create(E model) {
        Map<String, Object> result = new ConcurrentHashMap<>();
        E res;
        try {
            res = (E) repository.save(model);
            result.put("result","success");
            result.put("data",res);
        } catch (Exception e) {
            result.put("result","fail");
            logger.error("create error : ",e);
        }
        return result;
    }

    public Map list() {
        Map<String, Object> result = new ConcurrentHashMap<>();
        List<E> list;
        try {
            list = repository.findAll();
            result.put("result","success");
            result.put("data",list);
        } catch (Exception e) {
            result.put("result","fail");
            logger.error("create error : ",e);
        }
        return result;
    }

    public Map delete(long id) {
        Map<String, Object> result = new ConcurrentHashMap<>();
        Optional<E> data;
        try {
            result.put("result","success");
            data = repository.findById(id);
            if(data.isPresent()){
                repository.deleteById(id);
                result.put("data",data);
            } else {
                result.put("result","no data");
            }
        } catch (Exception e) {
            result.put("result","fail");
            logger.error("create error : ",e);
        }
        return result;
    }
}
