package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
