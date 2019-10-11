package com.example.wsdemo2.controller;

import com.example.wsdemo2.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage,
                                   SimpMessageHeaderAccessor headerAccessor) {
        chatMessage.setSessionId(headerAccessor.getSessionId());
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        chatMessage.setSessionId(headerAccessor.getSessionId());
        System.out.println("addUser:" + chatMessage.getSender() + ", " + chatMessage.getContent() + ", " + chatMessage.getType());
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        System.out.println("headerAccessor:" + headerAccessor);
        return chatMessage;
    }
}