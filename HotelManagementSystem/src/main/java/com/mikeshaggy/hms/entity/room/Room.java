package com.mikeshaggy.hms.entity.room;

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
    private Long id;

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
