package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "amenities")
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
