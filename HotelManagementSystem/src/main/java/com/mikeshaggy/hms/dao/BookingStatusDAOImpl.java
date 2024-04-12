package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.booking.BookingStatusEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookingStatusDAOImpl implements BookingStatusDAO {

    private EntityManager entityManager;

    public BookingStatusDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(BookingStatusEntity bookingStatus) {
        entityManager.persist(bookingStatus);
    }
}
