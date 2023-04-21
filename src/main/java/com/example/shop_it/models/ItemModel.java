package com.example.shop_it.models;

import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
@Table(appliesTo = "item_model")
public class ItemModel {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String name;

    @Column(name = "price")
    double price;

    @Column(name = "disc")
    private String disc;

    @Column(name = "url")
    private String url;

    @Column(name = "add_time")
    Long time;

    @Column(name = "type")
    private String type;

    private String timeFormat;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}