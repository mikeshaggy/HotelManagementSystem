package com.mikeshaggy.hms.amenity.repository;

import com.mikeshaggy.hms.amenity.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "amenities")
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
