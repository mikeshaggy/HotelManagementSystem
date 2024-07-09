package com.mikeshaggy.hms.service.entity;

import com.mikeshaggy.hms.model.Room;
import com.mikeshaggy.hms.repository.RoomRepository;
import com.mikeshaggy.hms.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends BaseService<Room, Integer> {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        super(roomRepository);
        this.roomRepository = roomRepository;
    }

    @Override
    protected Class<Room> getEntityClass() {
        return Room.class;
    }
}
