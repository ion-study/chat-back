package com.example.wsdemo2.repository;

import com.example.wsdemo2.model.Room;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class RoomRepo {

    private Map<String, Room> roomMap;

    @PostConstruct
    private void init() {
        roomMap = new LinkedHashMap<>();
    }

    public List<Room> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List chatRooms = new ArrayList<>(roomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public Room findRoomById(String id) {
        return roomMap.get(id);
    }

    public Room createChatRoom(String name) {
        Room room = Room.create(name);
        roomMap.put(room.getRoomId(), room);
        return room;
    }
}
