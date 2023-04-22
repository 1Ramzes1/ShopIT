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

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/toys")
    public String getToys(Model model){
        List<ItemModel> list = itemRepo.findAllByType("Игрушки");
        list = TimeHelper.getTime(list);
        model.addAttribute("items", list);
        return "allItems";
    }
    @GetMapping("/forpc")
    public String getForPc(Model model){
        List<ItemModel> list = itemRepo.findAllByType("Для компьютера");
        list = TimeHelper.getTime(list);
        model.addAttribute("items", list);
        return "allItems";
    }
    @GetMapping("/foryou")
    public String getForYou(Model model){
        List<ItemModel> list = itemRepo.findAllByType("Для себя");
        list = TimeHelper.getTime(list);
       model.addAttribute("items", list);
        return "allItems";
    }
}
