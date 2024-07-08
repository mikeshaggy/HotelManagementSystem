package com.mikeshaggy.hms.controller;

import com.mikeshaggy.hms.controller.base.BaseRestController;
import com.mikeshaggy.hms.model.Guest;
import com.mikeshaggy.hms.service.GuestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestRestController extends BaseRestController<Guest, Long> {

    private final GuestService guestService;

    public GuestRestController(GuestService guestService) {
        super(guestService);
        this.guestService = guestService;
    }
}
