package com.mikeshaggy.hms.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String streetName;
    private String streetNumber;
    @Column(name="apt_number")
    private String apartmentNumber;
    private String postCode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String streetName, String streetNumber, String postCode, String city, String country) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }

    public Address(String streetName, String streetNumber, String apartmentNumber, String postCode, String city, String country) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }
}
