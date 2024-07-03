package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
