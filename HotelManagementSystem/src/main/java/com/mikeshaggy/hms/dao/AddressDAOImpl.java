package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.address.Address;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AddressDAOImpl implements AddressDAO {

    private EntityManager entityManager;

    @Autowired
    public AddressDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(Address address) {
        entityManager.persist(address);
    }

    @Override
    public Address findById(long id) {
        return entityManager.find(Address.class, id);
    }
}
