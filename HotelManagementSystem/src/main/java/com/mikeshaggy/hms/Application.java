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
}
