package com.spring.security.pp_3_1_2_v2.controllers;

import com.spring.security.pp_3_1_2_v2.entities.User;
import com.spring.security.pp_3_1_2_v2.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String viewUser(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "viewUser";
    }
}
