package com.example.shop_it.helpers;

import com.example.shop_it.models.ItemModel;

import lombok.Data;

@Data
public class ItemModelWithCurency {

    private Long id;

    private String name;

    double price;

    private String disc;

    private String url;

    Long time;

    private String type;

    private String timeFormat;

    private double usdPrice;
    private double eurPrice;

    public ItemModelWithCurency() {
    }

    public ItemModelWithCurency(ItemModel itemModel) {
        this.id = itemModel.getId();
        this.price = itemModel.getPrice();
        this.type = itemModel.getType();
        this.url = itemModel.getImageLink();
    }
}
