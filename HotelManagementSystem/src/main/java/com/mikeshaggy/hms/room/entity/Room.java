package com.mikeshaggy.hms.room.entity;

import com.mikeshaggy.hms.room.status.entity.RoomStatusEntity;
import com.mikeshaggy.hms.room.type.entity.RoomTypeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name="room")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name="room_number")
    private String roomNumber;

    @Column(name="base_price")
    private Double basePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_type_id")
    private RoomTypeEntity roomType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="room_status_id")
    private RoomStatusEntity roomStatus;

    public Room() {
    }

    public Room(String roomNumber, Double basePrice, RoomTypeEntity roomType, RoomStatusEntity roomStatus) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }
}
