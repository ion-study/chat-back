package com.example.wsdemo2.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Room {
    @Id
    private String roomId;
    private String name;

    public static Room create(String name) {
        Room room = new Room();
        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
