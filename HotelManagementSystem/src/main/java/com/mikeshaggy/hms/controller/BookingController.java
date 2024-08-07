package com.mikeshaggy.hms.controller;

import com.mikeshaggy.hms.model.Booking;
import com.mikeshaggy.hms.model.Guest;
import com.mikeshaggy.hms.model.RoomTypeEnum;
import com.mikeshaggy.hms.service.entity.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("guest", new Guest());
        model.addAttribute("roomTypes", RoomTypeEnum.values());
        return "createBooking";
    }
}
