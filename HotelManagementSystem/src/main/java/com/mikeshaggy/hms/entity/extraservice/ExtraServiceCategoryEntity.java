package com.mikeshaggy.hms.entity.extraservice;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name="extra_service_category")
@Data
public class ExtraServiceCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private ExtraServiceCategory category;

    public ExtraServiceCategoryEntity() {}

    public ExtraServiceCategoryEntity(ExtraServiceCategory category) {
        this.category = category;
    }
}
