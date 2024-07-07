package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Room;
import com.mikeshaggy.hms.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Integer countByRoomType(RoomType roomType);
}
