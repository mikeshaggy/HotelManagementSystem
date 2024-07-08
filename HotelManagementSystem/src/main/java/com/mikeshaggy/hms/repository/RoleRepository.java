package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Role;
import com.mikeshaggy.hms.repository.base.BaseRepository;

import java.util.Optional;

public interface RoleRepository extends BaseRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
