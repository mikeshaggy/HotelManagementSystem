package com.mikeshaggy.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("hotelName", "Example Hotel");
        model.addAttribute("occupancyRate", 85);
        model.addAttribute("totalRooms", 120);

        return "dashboard";
    }
}

