package com.mikeshaggy.hms.service.base;

import com.mikeshaggy.hms.exception.general.EntityNotFoundException;
import com.mikeshaggy.hms.model.base.BaseEntity;
import com.mikeshaggy.hms.repository.base.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseService<T extends BaseEntity<ID>, ID> {

    private final BaseRepository<T, ID> repository;

    public BaseService(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T getById(ID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException((Number) id, getEntityClass().getSimpleName()));
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public T update(ID id, T entity) {
        T existingEntity = getById(id);
        entity.setId(id);
        return repository.save(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    protected abstract Class<T> getEntityClass();
}
