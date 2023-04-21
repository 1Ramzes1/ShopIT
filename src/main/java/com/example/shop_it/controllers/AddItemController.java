package com.example.shop_it.controllers;

import com.example.shop_it.models.ItemModel;
import com.example.shop_it.repos.ItemRepo;
import com.example.shop_it.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/addItem")
public class AddItemController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    FirebaseService firebaseService;

    @GetMapping
    public String getAddItem(){
        return "addItem";
    }

    @PostMapping
    public RedirectView addData(@RequestParam String name,
                                @RequestParam String price,
                                @RequestParam String disc,
                                @RequestParam MultipartFile file,
                                @RequestParam String type) throws Exception {
        ItemModel itemModel = new ItemModel();
        itemModel.setDisc(disc);
        itemModel.setName(name);
        try{
            itemModel.setPrice(Integer.parseInt(price));
        }catch (Exception e){
            itemModel.setPrice(-10);
        }

        itemModel.setUrl(firebaseService.save(file));
        itemModel.setTime(System.currentTimeMillis());
        itemModel.setType(type);
        itemRepo.save(itemModel);
        return new RedirectView("/");
    }
}
