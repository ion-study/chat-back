package com.example.wsdemo2.controller;

import com.example.wsdemo2.entity.Room;
import com.example.wsdemo2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping("/create")
    public Map create(@ModelAttribute Room room) {
        Map result = roomService.create(room);
        return result;
    }

    @RequestMapping("/list")
    public Map list() {
        Map result = roomService.list();
        return result;
    }

    @RequestMapping("/delete")
    public Map delete(@RequestParam int id) {
        Map result = roomService.delete(id);
        return result;
    }




}
