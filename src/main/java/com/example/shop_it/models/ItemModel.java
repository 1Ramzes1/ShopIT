package com.example.shop_it.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
@Table(name = "item_model")
public class ItemModel {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "price")
    double price;

    @Column(name = "type")
    private String type;

    @Column(name = "number")
    private int number;

    @Column(name = "image_link")
    private String imageLink;

}