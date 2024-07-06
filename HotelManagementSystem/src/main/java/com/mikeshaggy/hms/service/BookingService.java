package com.mikeshaggy.hms.service;

import com.mikeshaggy.hms.model.Booking;
import com.mikeshaggy.hms.model.RoomType;
import com.mikeshaggy.hms.repository.BookingRepository;
import com.mikeshaggy.hms.repository.GuestRepository;
import com.mikeshaggy.hms.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository, GuestRepository guestRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }



    public boolean isAvailable(Booking newBooking, RoomType roomType) {

        List<Booking> bookingsBetweenDates = bookingRepository.getBookingsByRoomTypeAndDateRange(roomType,
                newBooking.getStartDate(), newBooking.getEndDate());

        for (Booking booking : bookingsBetweenDates) {
            System.out.println(bookingsBetweenDates.size());
            if (bookingsDatesDoNotOverlap(newBooking, booking)) {
                return true;
            }
        }

        return false;
    }

    protected boolean bookingsDatesDoNotOverlap(Booking newBooking, Booking existingBooking) {

        LocalDate newBookingStartDate = newBooking.getStartDate();
        LocalDate newBookingEndDate = newBooking.getEndDate();
        LocalDate existingBookingStartDate = existingBooking.getStartDate();
        LocalDate existingBookingEndDate = existingBooking.getEndDate();

        if (isBetween(existingBookingStartDate, existingBookingEndDate, newBookingStartDate)
                || isBetween(existingBookingStartDate, existingBookingEndDate, newBookingEndDate)) {
            return false;
        }
        if (isBetween(newBookingStartDate, newBookingEndDate, existingBookingStartDate)
                || isBetween(newBookingStartDate, newBookingEndDate, existingBookingEndDate)) {
            return false;
        }
        return true;
    }

    private boolean isBetween(LocalDate periodStart, LocalDate periodEnd, LocalDate checkedDate) {
        return (checkedDate.isAfter(periodStart) && checkedDate.isBefore(periodEnd));
    }
}
