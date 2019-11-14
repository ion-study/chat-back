package com.example.wsdemo2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ChattingRoom")
public class Room {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
