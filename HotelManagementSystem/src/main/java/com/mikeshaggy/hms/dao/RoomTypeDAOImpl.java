package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.room.RoomTypeEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoomTypeDAOImpl implements RoomTypeDAO {

    private EntityManager entityManager;

    public RoomTypeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(RoomTypeEntity roomType) {
        entityManager.persist(roomType);
    }
}
