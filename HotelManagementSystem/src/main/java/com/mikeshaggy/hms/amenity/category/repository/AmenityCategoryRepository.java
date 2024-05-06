package com.mikeshaggy.hms.amenity.category.repository;

import com.mikeshaggy.hms.amenity.category.entity.AmenityCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "categories")
public interface AmenityCategoryRepository extends JpaRepository<AmenityCategoryEntity, Integer> {
}
