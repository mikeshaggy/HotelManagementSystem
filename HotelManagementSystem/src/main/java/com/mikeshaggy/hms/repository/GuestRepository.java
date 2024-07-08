package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Guest;
import com.mikeshaggy.hms.repository.base.BaseRepository;

public interface GuestRepository extends BaseRepository<Guest, Long> {
    Guest findGuestByIdCardNumber(String idCardNumber);
    Boolean existsByIdCardNumber(String idCardNumber);
}
