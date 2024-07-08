package com.mikeshaggy.hms.service;

import com.mikeshaggy.hms.model.Role;
import com.mikeshaggy.hms.repository.RoleRepository;
import com.mikeshaggy.hms.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role, Integer> {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
