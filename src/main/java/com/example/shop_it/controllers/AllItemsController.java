package com.example.shop_it.controllers;


import com.example.shop_it.helpers.TimeHelper;
import com.example.shop_it.models.ItemModel;
import com.example.shop_it.repos.ItemRepo;
import com.example.shop_it.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/allItems")
public class AllItemsController {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping
    public String getAllItem(Model model){
        List<ItemModel> list = itemRepo.findAll();
        list = TimeHelper.getTime(list);
         model.addAttribute("items", list);
        return "allItems";
    }
}
