package com.mikeshaggy.hms.room.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String roomNumber;
    private Double basePrice;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    public Room() {
    }

    public Room(String roomNumber, Double basePrice, RoomType roomType, RoomStatus roomStatus) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }
}
