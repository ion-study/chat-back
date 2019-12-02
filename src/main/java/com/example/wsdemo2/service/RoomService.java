package com.example.wsdemo2.service;

import com.example.wsdemo2.entity.Room;
import com.example.wsdemo2.repository.room.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends CommonService<RoomRepo, Room> {

    @Autowired
    private RoomRepo roomRepository;
}
