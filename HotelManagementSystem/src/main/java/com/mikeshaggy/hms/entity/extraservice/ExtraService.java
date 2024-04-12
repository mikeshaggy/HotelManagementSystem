package com.mikeshaggy.hms.entity.extraservice;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name="extra_service")
@Data
public class ExtraService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;

    @Column(name="price_per_person")
    private boolean pricePerPerson;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="extra_service_category_id")
    private ExtraServiceCategoryEntity extraServiceCategory;

    public ExtraService() {
    }

    public ExtraService(String name, String description, Double price, boolean pricePerPerson, ExtraServiceCategoryEntity extraServiceCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pricePerPerson = pricePerPerson;
        this.extraServiceCategory = extraServiceCategory;
    }
}
