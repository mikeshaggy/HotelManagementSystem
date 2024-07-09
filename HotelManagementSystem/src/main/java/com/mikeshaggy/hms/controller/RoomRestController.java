package com.mikeshaggy.hms.controller;

import com.mikeshaggy.hms.controller.base.BaseRestController;
import com.mikeshaggy.hms.model.Room;
import com.mikeshaggy.hms.service.entity.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomRestController extends BaseRestController<Room, Integer> {

    private final RoomService roomService;

    public RoomRestController(RoomService roomService) {
        super(roomService);
        this.roomService = roomService;
    }
}
