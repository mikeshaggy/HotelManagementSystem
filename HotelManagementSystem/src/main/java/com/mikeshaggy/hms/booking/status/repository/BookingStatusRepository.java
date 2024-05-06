package com.mikeshaggy.hms.booking.status.repository;

import com.mikeshaggy.hms.booking.status.entity.BookingStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "bookingstatus")
public interface BookingStatusRepository extends JpaRepository<BookingStatusEntity, Integer> {
}
