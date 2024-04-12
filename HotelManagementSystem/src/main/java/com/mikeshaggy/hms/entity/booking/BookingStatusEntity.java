package com.mikeshaggy.hms.entity.booking;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name="booking_status")
@Data
public class BookingStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Setter(AccessLevel.NONE)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private BookingStatus bookingStatus;

    public BookingStatusEntity() {
    }

    public BookingStatusEntity(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}