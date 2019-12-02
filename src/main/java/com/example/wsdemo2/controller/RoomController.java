package com.example.wsdemo2.controller;

import com.example.wsdemo2.entity.Room;
import com.example.wsdemo2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController extends CommonController<RoomService, Room> {
    @Autowired
    private RoomService service;
}
