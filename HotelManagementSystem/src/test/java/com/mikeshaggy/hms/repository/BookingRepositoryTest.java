package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Booking;
import com.mikeshaggy.hms.model.RoomType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    void shouldReturnBookingsByRoomTypeAndDates() {
        // Given
        List<Booking> mockedBookings = List.of(
                new Booking(LocalDate.of(2024, 6, 19), LocalDate.of(2024, 6, 20), RoomType.CLASSIC_DOUBLE),
                new Booking(LocalDate.of(2024, 6, 22), LocalDate.of(2024, 6, 23), RoomType.CLASSIC_DOUBLE),
                new Booking(LocalDate.of(2024, 6, 19), LocalDate.of(2024, 6, 21), RoomType.CLASSIC_DOUBLE),
                new Booking(LocalDate.of(2024, 6, 21), LocalDate.of(2024, 6, 23), RoomType.CLASSIC_DOUBLE),
                new Booking(LocalDate.of(2024, 6, 19), LocalDate.of(2024, 6, 23), RoomType.CLASSIC_DOUBLE),
                new Booking(LocalDate.of(2024, 6, 18), LocalDate.of(2024, 6, 19), RoomType.CLASSIC_DOUBLE),
                new Booking(LocalDate.of(2024, 6, 23), LocalDate.of(2024, 6, 24), RoomType.CLASSIC_DOUBLE)
        );
        bookingRepository.saveAll(mockedBookings);

        // When
        List<Booking> foundBookings = bookingRepository.getBookingsByRoomTypeAndDateRange(RoomType.CLASSIC_DOUBLE, LocalDate.of(2024, 6, 20), LocalDate.of(2024, 6, 22));

        // Then
        assertThat(foundBookings).hasSize(5);
    }
}