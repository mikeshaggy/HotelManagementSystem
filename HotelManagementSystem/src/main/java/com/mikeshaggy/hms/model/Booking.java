package com.mikeshaggy.hms.model;

import com.mikeshaggy.hms.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Booking extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer people;
    private Double totalPrice;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToMany
    @JoinTable(
            name = "amenity_booking",
            joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id", referencedColumnName = "id")
    )
    List<Amenity> amenities;

    public Booking() {
    }

    public Booking(LocalDate startDate, LocalDate endDate, Integer people, Double totalPrice, BookingStatus bookingStatus, Room room, Guest guest, List<Amenity> amenities) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.people = people;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
        this.room = room;
        this.guest = guest;
        this.amenities = amenities;
    }

    public Booking(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking(LocalDate startDate, LocalDate endDate, RoomType roomType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomType = roomType;
    }
}
