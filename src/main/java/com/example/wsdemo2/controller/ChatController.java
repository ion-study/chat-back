package com.example.wsdemo2.controller;

import com.example.wsdemo2.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage,
                                   SimpMessageHeaderAccessor headerAccessor) {
        chatMessage.setSessionId(headerAccessor.getSessionId());
	    System.out.println("sendMessage: " + chatMessage.toString());

        messagingTemplate.convertAndSend("/topic/public/room/"+chatMessage.getRoomId(), chatMessage);
    }

    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        chatMessage.setSessionId(headerAccessor.getSessionId());
        System.out.println("addUser: " + chatMessage.toString());
        // System.out.println("addUser:" + chatMessage.getSender() + ", " + chatMessage.getContent() + ", " + chatMessage.getType());
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        if(chatMessage.getRoomId() != null) {
            headerAccessor.getSessionAttributes().put("roomId",chatMessage.getRoomId());
        }
        messagingTemplate.convertAndSend("/topic/public/room/"+chatMessage.getRoomId(), chatMessage);
    }
}