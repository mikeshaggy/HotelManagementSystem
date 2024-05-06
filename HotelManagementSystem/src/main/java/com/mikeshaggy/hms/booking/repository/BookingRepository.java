package com.mikeshaggy.hms.booking.repository;

import com.mikeshaggy.hms.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
