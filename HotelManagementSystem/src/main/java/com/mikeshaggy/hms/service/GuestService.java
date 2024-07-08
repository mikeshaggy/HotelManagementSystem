package com.mikeshaggy.hms.service;

import com.mikeshaggy.hms.model.Guest;
import com.mikeshaggy.hms.repository.GuestRepository;
import com.mikeshaggy.hms.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class GuestService extends BaseService<Guest, Long> {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        super(guestRepository);
        this.guestRepository = guestRepository;
    }

    @Override
    protected Class<Guest> getEntityClass() {
        return Guest.class;
    }
}
