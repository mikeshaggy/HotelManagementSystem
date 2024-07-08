package com.mikeshaggy.hms.service;

import com.mikeshaggy.hms.model.Booking;
import com.mikeshaggy.hms.model.RoomType;
import com.mikeshaggy.hms.repository.BookingRepository;
import com.mikeshaggy.hms.repository.GuestRepository;
import com.mikeshaggy.hms.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;
    @Mock
    private GuestRepository guestRepository;
    @Mock
    private RoomRepository roomRepository;
    @InjectMocks
    private BookingService bookingService;

    public static Stream<Booking> overlappingDates() {
        return Stream.of(
                new Booking(LocalDate.of(2024, 6, 17), LocalDate.of(2024, 6, 19)),
                new Booking(LocalDate.of(2024, 6, 17), LocalDate.of(2024, 6, 22)),
                new Booking(LocalDate.of(2024, 6, 12), LocalDate.of(2024, 6, 17)),
                new Booking(LocalDate.of(2024, 6, 12), LocalDate.of(2024, 6, 22))
        );
    }

    @ParameterizedTest
    @MethodSource("overlappingDates")
    void bookingsDatesDoNotOverlap_shouldReturnFalse_whenDatesOverlap(Booking newBooking) {
        // Given
        // Existing booking from 2024-06-15 to 2024-06-20
        Booking existingBooking = new Booking(LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 20));
        // When
        // Expecting overlapping dates to return false
        boolean overlaps = bookingService.bookingsDatesDoNotOverlap(newBooking, existingBooking);
        // Then
        assertThat(overlaps).isFalse();
    }

    public static Stream<Booking> nonOverlappingDates() {
        return Stream.of(
                new Booking(LocalDate.of(2024, 6, 12), LocalDate.of(2024, 6, 15)),
                new Booking(LocalDate.of(2024, 6, 20), LocalDate.of(2024, 6, 22)),
                new Booking(LocalDate.of(2024, 6, 12), LocalDate.of(2024, 6, 14)),
                new Booking(LocalDate.of(2024, 6, 22), LocalDate.of(2024, 6, 24))
        );
    }

    @ParameterizedTest
    @MethodSource("nonOverlappingDates")
    void bookingsDatesDoNotOverlap_shouldReturnTrue_whenDatesDoNotOverlap(Booking newBooking) {
        // Given
        // Existing booking from 2024-06-15 to 2024-06-20
        Booking existingBooking = new Booking(LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 15));
        // When
        // Expecting non overlapping dates to return true
        boolean notOverlaps = bookingService.bookingsDatesDoNotOverlap(newBooking, existingBooking);
        // Then
        assertThat(notOverlaps).isTrue();
    }

    @Test
    void isAvailable_shouldReturnFalse_whenNoRoomAvailable() {
        // Given
        Booking newBooking = new Booking(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 2), RoomType.CLASSIC_DOUBLE);
        // When
        when(roomRepository.countByRoomType(RoomType.CLASSIC_DOUBLE)).thenReturn(1);
        when(bookingRepository.getBookingsByRoomTypeAndDateRange(newBooking.getRoomType(),
                newBooking.getStartDate(), newBooking.getEndDate()))
                .thenReturn(List.of(new Booking(LocalDate.of(2024, 9, 29), LocalDate.of(2024, 10, 3))));
        // Then
        assertThat(bookingService.isAvailable(newBooking)).isFalse();
    }

    @Test
    void isAvailable_shouldReturnTrue_whenRoomIsAvailable() {
        // Given
        Booking newBooking = new Booking(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 2), RoomType.CLASSIC_DOUBLE);
        // When
        when(roomRepository.countByRoomType(RoomType.CLASSIC_DOUBLE)).thenReturn(2);
        when(bookingRepository.getBookingsByRoomTypeAndDateRange(newBooking.getRoomType(),
                newBooking.getStartDate(), newBooking.getEndDate()))
                .thenReturn(List.of(new Booking(LocalDate.of(2024, 9, 29), LocalDate.of(2024, 10, 3))));
        // Then
        assertThat(bookingService.isAvailable(newBooking)).isTrue();
    }
}