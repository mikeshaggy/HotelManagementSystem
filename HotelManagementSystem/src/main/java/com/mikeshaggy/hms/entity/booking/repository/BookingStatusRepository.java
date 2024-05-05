package com.mikeshaggy.hms.entity.booking.repository;

import com.mikeshaggy.hms.entity.booking.BookingStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "bookingstatus")
public interface BookingStatusRepository extends JpaRepository<BookingStatusEntity, Integer> {
}
