//package com.mikeshaggy.hms.dao;
//
//import jakarta.persistence.EntityManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.Serializable;
//
//@Repository
//public class GenericDAOImpl<T extends Serializable> implements GenericDAO<T> {
//
//    private Class<T> entityClass;
//    private EntityManager entityManager;
//
//    @Autowired
//    public GenericDAOImpl(Class<T> entityClass, EntityManager entityManager) {
//        this.entityClass = entityClass;
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    @Transactional
//    public void create(T t) {
//        entityManager.persist(t);
//    }
//
//    @Override
//    public T findById(int id) {
//        return entityManager.find(entityClass, id);
//    }
//}
