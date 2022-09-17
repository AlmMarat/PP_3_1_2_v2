package com.spring.security.pp_3_1_2_v2.services;

import com.spring.security.pp_3_1_2_v2.entities.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    void saveUser(User user);
    void deleteById(Long id);
    User findByUsername(String name);
    User findByEmail(String name);
}
