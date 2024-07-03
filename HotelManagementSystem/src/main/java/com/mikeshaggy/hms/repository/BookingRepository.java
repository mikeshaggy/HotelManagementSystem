package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
