package com.example.wsdemo2.model;

import lombok.Data;

@Data
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private String sessionId;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}