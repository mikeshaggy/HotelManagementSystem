package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.guest.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
