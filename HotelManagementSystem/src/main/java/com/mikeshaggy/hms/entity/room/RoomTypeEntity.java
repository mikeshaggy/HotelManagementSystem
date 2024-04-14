package com.mikeshaggy.hms.entity.room;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name="room_type")
@Data
public class RoomTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private RoomType roomType;

    public RoomTypeEntity() {
    }

    public RoomTypeEntity(RoomType roomType) {
        this.roomType = roomType;
    }
}
