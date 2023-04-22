package com.example.shop_it.helpers;

import com.example.shop_it.models.ItemModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeHelper {
    public static List<ItemModel> getTime(List<ItemModel> list){
        for(ItemModel i : list){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm dd.MM");
           }
        return list;
    }
}
