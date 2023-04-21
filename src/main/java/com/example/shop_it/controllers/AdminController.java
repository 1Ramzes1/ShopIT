package com.example.shop_it.controllers;

import com.example.shop_it.helpers.TimeHelper;
import com.example.shop_it.models.ItemModel;
import com.example.shop_it.models.RequestModel;
import com.example.shop_it.repos.ItemRepo;
import com.example.shop_it.repos.RequestRepo;
import com.example.shop_it.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    RequestRepo requestRepo;

    @Autowired
    ItemRepo itemRepo;
    @Autowired
    FirebaseService firebaseService;

    @GetMapping
    public String getAdmin(){
        return "admin";
    }

    @GetMapping("/edit")
    public String getAll(Model model){
        List<ItemModel> list = itemRepo.findAll();
        list = TimeHelper.getTime(list);
        list.stream().forEach(i -> i.setUrl(firebaseService.getUrl(i.getUrl())));
        model.addAttribute("items", list);
        return "editItems";
    }

    @GetMapping("/reg")
    public String getPage(Model model){
        List<RequestModel> list = requestRepo.findAll();
        model.addAttribute("reg", list);
        return "requests";
    }
}
