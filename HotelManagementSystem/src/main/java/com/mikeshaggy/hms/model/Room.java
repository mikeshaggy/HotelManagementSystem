package com.mikeshaggy.hms.model;

import com.mikeshaggy.hms.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Room extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String roomNumber;
    private Double basePrice;
//    @Enumerated(EnumType.STRING)
//    private RoomTypeEnum roomTypeEnum;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_type_id")
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

    public Room(RoomType roomType) {
        this.roomType = roomType;
    }
}
