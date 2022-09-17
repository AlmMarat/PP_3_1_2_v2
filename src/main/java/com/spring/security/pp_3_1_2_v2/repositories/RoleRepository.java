package com.spring.security.pp_3_1_2_v2.repositories;

import com.spring.security.pp_3_1_2_v2.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Override
    List<Role> findAll();

    Role findByName(String name);
}