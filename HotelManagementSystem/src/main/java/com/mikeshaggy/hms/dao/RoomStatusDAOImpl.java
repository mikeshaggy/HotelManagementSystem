package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.room.RoomStatusEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoomStatusDAOImpl implements RoomStatusDAO {

    private EntityManager entityManager;

    public RoomStatusDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(RoomStatusEntity roomStatus) {
        entityManager.persist(roomStatus);
    }
}
