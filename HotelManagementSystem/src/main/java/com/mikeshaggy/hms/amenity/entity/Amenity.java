package com.mikeshaggy.hms.amenity.entity;

import com.mikeshaggy.hms.amenity.category.entity.AmenityCategoryEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name="amenity")
@Data
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Double price;

    @Column(name="price_per_person")
    private boolean pricePerPerson;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="amenity_category_id")
    private AmenityCategoryEntity amenityCategory;

    public Amenity() {
    }

    public Amenity(String name, Double price, boolean pricePerPerson, AmenityCategoryEntity amenityCategory) {
        this.name = name;
        this.price = price;
        this.pricePerPerson = pricePerPerson;
        this.amenityCategory = amenityCategory;
    }
}
