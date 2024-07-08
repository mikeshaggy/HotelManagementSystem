package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Room;
import com.mikeshaggy.hms.model.RoomType;
import com.mikeshaggy.hms.repository.base.BaseRepository;

public interface RoomRepository extends BaseRepository<Room, Integer> {
    Integer countByRoomType(RoomType roomType);
}
