package com.mikeshaggy.hms;

import com.mikeshaggy.hms.dao.*;
import com.mikeshaggy.hms.entity.address.Address;
import com.mikeshaggy.hms.entity.booking.BookingStatus;
import com.mikeshaggy.hms.entity.booking.BookingStatusEntity;
import com.mikeshaggy.hms.entity.extraservice.ExtraServiceCategory;
import com.mikeshaggy.hms.entity.extraservice.ExtraServiceCategoryEntity;
import com.mikeshaggy.hms.entity.guest.Guest;
import com.mikeshaggy.hms.entity.room.RoomStatus;
import com.mikeshaggy.hms.entity.room.RoomStatusEntity;
import com.mikeshaggy.hms.entity.room.RoomType;
import com.mikeshaggy.hms.entity.room.RoomTypeEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.EnumSet;
import java.util.Set;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookingStatusDAO bookingStatusDAO) {
        return args -> {
//            createAddress(genericDAO);
//            createGuest(guestDAO, addressDAO);
//            getFullAddress(guestDAO, addressDAO);
            create(bookingStatusDAO);
        };
    }

    private void createGuest(GuestDAO guestDAO, AddressDAO addressDAO) {
        System.out.println("Creating guest...");
        Guest guest = new Guest("Michał", "Bagan", "michalbagan@icloud.com",
                "+48 574 861 847", "DBG012304",
                addressDAO.findById(1));

        System.out.println("Created guest: " + guest);
        guestDAO.create(guest);
        System.out.println("Saved guest. Guest's ID" + guest.getId());
    }

    private void getFullAddress(GuestDAO guestDao, AddressDAO addressDAO) {
        System.out.println("Finding guest with id 1...");
        Guest guest = guestDao.findById(1);
        System.out.println("Found guest: " + guest);
    }

    private void create(BookingStatusDAO bookingStatusDAO) {
        Set<BookingStatus> statuses = EnumSet.allOf(BookingStatus.class);
        statuses.forEach(t -> {
            System.out.println("Creating booking status: " + t.toString());
            bookingStatusDAO.create(new BookingStatusEntity(t));
        });
    }
}
