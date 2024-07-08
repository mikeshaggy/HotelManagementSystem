package com.mikeshaggy.hms.controller;

import com.mikeshaggy.hms.controller.base.BaseRestController;
import com.mikeshaggy.hms.model.Role;
import com.mikeshaggy.hms.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleRestController extends BaseRestController<Role, Integer> {

    private final RoleService roleService;

    public RoleRestController(RoleService roleService) {
        super(roleService);
        this.roleService = roleService;
    }
}
