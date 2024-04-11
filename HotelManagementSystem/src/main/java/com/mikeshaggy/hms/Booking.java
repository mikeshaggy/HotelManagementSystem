package com.mikeshaggy.hms;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Booking {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int people;
    private Set<Room> rooms = new HashSet<>();
    private Guest guest;
}
