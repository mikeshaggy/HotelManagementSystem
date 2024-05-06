package com.mikeshaggy.hms.guest.repository;

import com.mikeshaggy.hms.guest.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
