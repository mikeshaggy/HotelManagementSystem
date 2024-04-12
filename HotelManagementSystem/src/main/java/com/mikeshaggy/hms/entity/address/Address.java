package com.mikeshaggy.hms.entity.address;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Entity
@Table(name="address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name="street_name")
    private String streetName;

    @Column(name="street_number")
    private String streetNumber;

    @Column(name="apt_number")
    private String apartmentNumber;

    @Column(name="post_code")
    private String postCode;

    @Column(name="city")
    private String city;

    @Column(name="country")
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
