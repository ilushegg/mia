package com.example.mia.controller;

import com.example.mia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users")
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

}
