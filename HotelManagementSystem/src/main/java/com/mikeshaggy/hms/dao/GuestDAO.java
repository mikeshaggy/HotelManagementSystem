package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.guest.Guest;

public interface GuestDAO {
    void create(Guest guest);
    Guest findById(long id);
}
