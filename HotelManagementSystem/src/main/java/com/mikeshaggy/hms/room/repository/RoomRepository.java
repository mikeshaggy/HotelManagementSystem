package com.mikeshaggy.hms.room.repository;

import com.mikeshaggy.hms.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
