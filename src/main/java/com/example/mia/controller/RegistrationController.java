package com.example.mia.controller;

import com.example.mia.domain.Role;
import com.example.mia.domain.User;
import com.example.mia.repos.UserRepo;
import com.example.mia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.UUID;

@Controller
public class RegistrationController {
    private final UserRepo userRepo;

    private final UserService userService;

    public RegistrationController(UserRepo userRepo, UserService userService){
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Model model, User user){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb != null){
//            model.addAttribute("message", "")
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);

        userService.sendMessage(user);



        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = userService.activateUser(code);
        System.out.println("CODDDDDEEE:" + code);
        if(isActivated){
            model.addAttribute("message", "User successfully activated!");
        }
        else{
            model.addAttribute("message", "Activation code is not found!");
        }
        return "login";
    }
}
