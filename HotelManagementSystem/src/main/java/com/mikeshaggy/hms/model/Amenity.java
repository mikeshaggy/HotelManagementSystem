package com.mikeshaggy.hms.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String name;
    private Double price;
    private boolean pricePerPerson;
    @Enumerated(EnumType.STRING)
    private AmenityCategory category;

    public Amenity() {
    }

    public Amenity(String name, Double price, boolean pricePerPerson, AmenityCategory category) {
        this.name = name;
        this.price = price;
        this.pricePerPerson = pricePerPerson;
        this.category = category;
    }
}
