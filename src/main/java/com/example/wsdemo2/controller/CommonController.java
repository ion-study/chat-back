package com.example.wsdemo2.controller;

import com.example.wsdemo2.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public abstract class CommonController<T extends CommonService, E> {

    @Autowired
    private T service;

    @RequestMapping("/create")
    public Map create(@ModelAttribute E model) {
        return service.create(model);
    }

    @RequestMapping("/list")
    public Map list() {
        return service.list();
    }

    @RequestMapping("/delete/{id}")
    public Map delete(@PathVariable int id) {
        return service.delete(id);
    }
}
