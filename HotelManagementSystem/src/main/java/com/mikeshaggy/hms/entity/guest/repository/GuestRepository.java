package com.mikeshaggy.hms.entity.guest.repository;

import com.mikeshaggy.hms.entity.guest.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
