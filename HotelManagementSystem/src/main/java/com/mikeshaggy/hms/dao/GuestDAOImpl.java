package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.address.Address;
import com.mikeshaggy.hms.entity.guest.Guest;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GuestDAOImpl implements GuestDAO {

    private EntityManager entityManager;

    @Autowired
    public GuestDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(Guest guest) {
        entityManager.persist(guest);
    }

    @Override
    public Guest findById(long id) {
        return entityManager.find(Guest.class, id);
    }
}
