package com.example.shop_it.controllers;

import com.example.shop_it.models.UserModel;
import com.example.shop_it.repos.ItemRepo;
import com.example.shop_it.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepo itemRepo;
    @PostMapping
    public RedirectView post(@RequestParam String name, @RequestParam String password) {
        UserModel userModel = itemRepo.findByLoginAndPassword(name, password);
        if (userModel != null) {
            if (userModel.getRole().equals("admin")) {
                return new RedirectView("/admin");
            }
            return new RedirectView("/");
        }else {
            return new RedirectView("/login");
        }
    }
    @GetMapping
    public String getLoginPage(){

        return "login";
    }

}
