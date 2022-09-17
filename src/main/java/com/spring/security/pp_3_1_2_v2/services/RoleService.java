package com.spring.security.pp_3_1_2_v2.services;

import com.spring.security.pp_3_1_2_v2.entities.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> findAll();
    Role findByName(String name);
    void save(Role role);
}
