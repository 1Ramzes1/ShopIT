package com.example.shop_it.controllers;

import com.example.shop_it.models.UserModel;
import com.example.shop_it.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/reg")
public class RegController {
    @Autowired
    UserRepo itemRepo;
    @PostMapping
    public RedirectView post(@RequestParam String firstName, @RequestParam String name, @RequestParam String password) {
        UserModel userModel = new UserModel();
        userModel.setName(firstName);
        userModel.setLogin(name);
        userModel.setPassword(password);
        userModel.setRole("user");
        itemRepo.save(userModel);
        if (userModel != null) {
            return new RedirectView("/");
        }else {
            return new RedirectView("/reg");
        }
    }
    @GetMapping
    public String getLoginPage(){

        return "reg";
    }

}
