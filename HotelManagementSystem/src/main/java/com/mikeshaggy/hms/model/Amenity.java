package com.mikeshaggy.hms.model;

import com.mikeshaggy.hms.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Amenity extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String name;
    private Double price;
    private boolean pricePerPerson;
    @Enumerated(EnumType.STRING)
    private AmenityCategory amenityCategory;

    public Amenity() {
    }

    public Amenity(String name, Double price, boolean pricePerPerson, AmenityCategory amenityCategory) {
        this.name = name;
        this.price = price;
        this.pricePerPerson = pricePerPerson;
        this.amenityCategory = amenityCategory;
    }
}
