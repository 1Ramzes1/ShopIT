package com.example.shop_it.controllers;

import com.example.shop_it.helpers.ItemModelWithCurency;
import com.example.shop_it.models.ItemModel;
import com.example.shop_it.models.RequestModel;
import com.example.shop_it.repos.ItemRepo;
import com.example.shop_it.repos.RequestRepo;
import com.example.shop_it.services.CarencyService;
import com.example.shop_it.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/item")
public class DetailItemController {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    CarencyService carencyService;
    @Autowired
    RequestRepo requestRepo;
    @Autowired
    FirebaseService firebaseService;
//https://firebasestorage.googleapis.com/v0/b/javers-cb7ff.appspot.com/o/1682126487751?alt=media&token=756350a7-db05-42a1-b6fc-98adc5b4bb21

    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable long id, Model model){
        ItemModel itemModel = itemRepo.findById(id);
        ItemModelWithCurency itemModelWithCurency = new ItemModelWithCurency(itemModel);
        itemModelWithCurency.setEurPrice(carencyService.getEurPrice(itemModel.getPrice()));
        itemModelWithCurency.setUsdPrice(carencyService.getUsdPrice(itemModel.getPrice()));
        itemModelWithCurency.setUrl(itemModel.getImageLink());
        model.addAttribute("item", itemModelWithCurency);
        return "detailItem";
    }

    @PostMapping("/{id}")
    public RedirectView saveFata(@PathVariable long id, @RequestParam String name, @RequestParam String phoneNumber,
                                 @RequestParam int number){

        ItemModel itemModel = itemRepo.findById(id);
        itemModel.setNumber(itemModel.getNumber() - number);
        itemRepo.save(itemModel);
        return new RedirectView("/");
    }
}
