package com.mikeshaggy.hms.service;

import com.mikeshaggy.hms.model.Booking;
import com.mikeshaggy.hms.repository.BookingRepository;
import com.mikeshaggy.hms.repository.GuestRepository;
import com.mikeshaggy.hms.repository.RoomRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
    void shouldReturnNotAvailable(Booking newBooking) {
        // Existing booking from 2024-06-15 to 2024-06-20
        Booking existingBooking = new Booking(LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 20));
        // Expecting overlapping dates to return false
        boolean overlaps = bookingService.bookingsDatesDoNotOverlap(newBooking, existingBooking);

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
    void shouldReturnAvailable(Booking newBooking) {
        // Existing booking from 2024-06-15 to 2024-06-20
        Booking existingBooking = new Booking(LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 15));
        // Expecting non overlapping dates to return true
        boolean notOverlaps = bookingService.bookingsDatesDoNotOverlap(newBooking, existingBooking);

        assertThat(notOverlaps).isTrue();
    }
}