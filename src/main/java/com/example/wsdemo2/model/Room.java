package com.example.wsdemo2.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Room {
    private String roomId;
    private String name;

    public static Room create(String name) {
        Room room = new Room();
        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
