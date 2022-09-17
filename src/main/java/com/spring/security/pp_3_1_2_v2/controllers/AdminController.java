package com.spring.security.pp_3_1_2_v2.controllers;

import com.spring.security.pp_3_1_2_v2.entities.Role;
import com.spring.security.pp_3_1_2_v2.entities.User;
import com.spring.security.pp_3_1_2_v2.services.RoleService;
import com.spring.security.pp_3_1_2_v2.services.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String showAllUsers(@NotNull Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/admin/addUserForm")
    public String addUserForm(@ModelAttribute("newUser") User user, @NotNull Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "newUser";
    }

    @PostMapping("/admin/addUser")
    public String addUser(@ModelAttribute("newUser") @NotNull User user,
                          @RequestParam(value = "roles", required = false) Set<Role> roles) {
        user.setRoleSet(roles);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/deleteUser/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/update/{id}")
    public String update(@NotNull Model model, @PathVariable("id") Long id) {
        User user = userService.findById(id);
        model.addAttribute("userToUpdate", user);
        model.addAttribute("roles", roleService.findAll());
        return "updateUser";
    }
    @PatchMapping("/admin/updateUser")
    public String updateUser(@NotNull User user, @RequestParam(value = "roles", required = false) Set<Role> roles) {
        user.setRoleSet(roles);
        userService.saveUser(user);
        return "redirect:/admin";
    }
}