package com.mikeshaggy.hms.entity;

public class Address {
    private String streetName;
    private String streetNumber;
    private String apartmentNumber;
    private String postCode;
    private String city;
    private String country;

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
