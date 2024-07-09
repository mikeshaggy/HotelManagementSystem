package com.mikeshaggy.hms.controller;

import com.mikeshaggy.hms.controller.base.BaseRestController;
import com.mikeshaggy.hms.model.Booking;
import com.mikeshaggy.hms.service.entity.BookingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingRestController extends BaseRestController<Booking, Long> {

    private final BookingService bookingService;

    public BookingRestController(BookingService bookingService) {
        super(bookingService);
        this.bookingService = bookingService;
    }
}
