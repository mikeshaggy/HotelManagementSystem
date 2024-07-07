package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Booking;
import com.mikeshaggy.hms.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b from Booking b where b.roomType = :roomType and b.startDate <= :endDate and b.endDate >= :startDate")
    List<Booking> getBookingsByRoomTypeAndDateRange(@Param("roomType") RoomType roomType,
                                           @Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate);
}
