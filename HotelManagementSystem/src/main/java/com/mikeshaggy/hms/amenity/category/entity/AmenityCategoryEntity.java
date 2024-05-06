package com.mikeshaggy.hms.amenity.category.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name="amenity_category")
@Data
public class AmenityCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private AmenityCategory category;

    public AmenityCategoryEntity() {}

    public AmenityCategoryEntity(AmenityCategory category) {
        this.category = category;
    }
}
