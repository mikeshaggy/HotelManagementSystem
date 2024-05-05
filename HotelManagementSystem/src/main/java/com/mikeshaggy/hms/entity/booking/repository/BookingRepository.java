package com.mikeshaggy.hms.entity.booking.repository;

import com.mikeshaggy.hms.entity.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
