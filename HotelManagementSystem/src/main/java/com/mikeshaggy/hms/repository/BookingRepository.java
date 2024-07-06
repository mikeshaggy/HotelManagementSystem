package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Booking;
import com.mikeshaggy.hms.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.roomType = :roomType AND b.startDate <= :endDate AND b.endDate >= :startDate")
    List<Booking> getBookingsByRoomTypeAndDateRange(@Param("roomType") RoomType roomType,
                                           @Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate);

}
