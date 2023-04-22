package com.example.shop_it.controllers;

import com.example.shop_it.models.ItemModel;
import com.example.shop_it.repos.ItemRepo;
import com.example.shop_it.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/edit")
public class EditController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/{id}")
    public String edit(@PathVariable long id, Model model) {
        ItemModel itemModel = itemRepo.findById(id);
       model.addAttribute("items", itemModel);
        return "edit";
    }

    @PostMapping("/{id}")
    public RedirectView setChanges(@PathVariable long id, @RequestParam String name,
                             @RequestParam double price,
                             @RequestParam String type,
                             @RequestParam String url) {
        ItemModel itemModel = itemRepo.findById(id);
        itemModel.setType(type);
        itemModel.setPrice(price);
        itemRepo.save(itemModel);
        return new RedirectView("/");
    }
}
