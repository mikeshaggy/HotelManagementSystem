package com.mikeshaggy.hms.service.entity;

import com.mikeshaggy.hms.model.Booking;
import com.mikeshaggy.hms.repository.BookingRepository;
import com.mikeshaggy.hms.repository.GuestRepository;
import com.mikeshaggy.hms.repository.RoomRepository;
import com.mikeshaggy.hms.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService extends BaseService<Booking, Long> {

    private final BookingRepository bookingRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository, GuestRepository guestRepository, RoomRepository roomRepository) {
        super(bookingRepository);
        this.bookingRepository = bookingRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    protected Class<Booking> getEntityClass() {
        return Booking.class;
    }

//    public Booking createBooking(RoomType roomType, LocalDate startDate, LocalDate endDate,
//                                 Integer people, Guest guest) {
//        Booking booking = new Booking(startDate, endDate, roomType);
//
//        if (!isAvailable(booking)) throw new NoRoomAvailableException(booking);
//
//        String guestIdCardNumber = guest.getIdCardNumber();
//
//        if (guestRepository.existsByIdCardNumber(guestIdCardNumber)) {
//            booking.setGuest(guestRepository.findGuestByIdCardNumber(guestIdCardNumber));
//        } else {
//            guestRepository.save(guest);
//            booking.setGuest(guest);
//        }
//        return null;
//    }

    protected boolean isAvailable(Booking newBooking) {

        int totalRoomsAvailable = roomRepository.countByRoomType(newBooking.getRoomType());
        int roomsNotAvailable = 0;

        List<Booking> bookingsBetweenDates = bookingRepository.getBookingsByRoomTypeAndDateRange(
                newBooking.getRoomType(), newBooking.getStartDate(), newBooking.getEndDate());

        for (Booking booking : bookingsBetweenDates) {
            if (!bookingsDatesDoNotOverlap(newBooking, booking)) {
                roomsNotAvailable++;
            }
        }

        return roomsNotAvailable != totalRoomsAvailable;
    }

    protected boolean bookingsDatesDoNotOverlap(Booking newBooking, Booking existingBooking) {

        LocalDate newBookingStartDate = newBooking.getStartDate();
        LocalDate newBookingEndDate = newBooking.getEndDate();
        LocalDate existingBookingStartDate = existingBooking.getStartDate();
        LocalDate existingBookingEndDate = existingBooking.getEndDate();

        if (dateIsBetween(existingBookingStartDate, existingBookingEndDate, newBookingStartDate)
                || dateIsBetween(existingBookingStartDate, existingBookingEndDate, newBookingEndDate)) {
            return false;
        }
        if (dateIsBetween(newBookingStartDate, newBookingEndDate, existingBookingStartDate)
                || dateIsBetween(newBookingStartDate, newBookingEndDate, existingBookingEndDate)) {
            return false;
        }
        return true;
    }

    private boolean dateIsBetween(LocalDate periodStart, LocalDate periodEnd, LocalDate checkedDate) {
        return (checkedDate.isAfter(periodStart) && checkedDate.isBefore(periodEnd));
    }
}
