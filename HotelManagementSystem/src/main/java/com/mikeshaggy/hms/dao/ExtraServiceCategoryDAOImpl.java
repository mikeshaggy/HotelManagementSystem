package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.extraservice.ExtraServiceCategoryEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ExtraServiceCategoryDAOImpl implements ExtraServiceCategoryDAO {

    private EntityManager entityManager;

    public ExtraServiceCategoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void create(ExtraServiceCategoryEntity extraServiceCategory) {
        entityManager.persist(extraServiceCategory);
    }
}
