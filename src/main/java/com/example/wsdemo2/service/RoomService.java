package com.example.wsdemo2.service;

import com.example.wsdemo2.entity.Room;
import com.example.wsdemo2.repository.RoomRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RoomService {

    Logger logger = LoggerFactory.getLogger(RoomService.class);
    Map<String, Object> result = new ConcurrentHashMap<>();

    @Autowired
    private RoomRepo roomRepository;

    public Map create(Room room) {
        Room resRoom;
        try {
            resRoom = roomRepository.save(room);
            result.put("result","success");
            result.put("data",resRoom);
        } catch (Exception e) {
            result.put("result","fail");
            logger.error("Insert Error",e);
        }
        return result;
    }

    public Map list() {
        List<Room> roomlist;
        try {
            roomlist = roomRepository.findAll();
            result.put("result","success");
            result.put("data",roomlist);
        } catch (Exception e) {
            result.put("result","fail");
            logger.error("Insert Error",e);
        }
        return result;
    }

    public Map delete(int id) {
        Optional<Room> room;
        try {
            result.put("result","success");
            room = roomRepository.findById(id);
            if(room.isPresent()){
                roomRepository.deleteById(id);
                result.put("data",room);
            } else {
                result.put("result","no data");
            }
        } catch (Exception e) {
            result.put("result","fail");
            logger.error("Insert Error",e);
        }
        return result;
    }
}
