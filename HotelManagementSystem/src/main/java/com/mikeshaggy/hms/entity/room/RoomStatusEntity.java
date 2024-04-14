package com.mikeshaggy.hms.entity.room;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name="room_status")
@Data
public class RoomStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private RoomStatus roomStatus;

    public RoomStatusEntity() {
    }

    public RoomStatusEntity(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
