package com.mikeshaggy.hms.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Booking {
    enum Status {
      PENDING, CONFIRMED, CANCELLED, CHECKED_IN, CHECKED_OUT, NO_SHOW
    }
    private LocalDate startDate;
    private LocalDate endDate;
    private int people;
    private Set<Room> rooms = new HashSet<>();
    private Guest guest;
    private Status status;
}
