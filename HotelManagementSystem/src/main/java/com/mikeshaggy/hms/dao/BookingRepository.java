package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
