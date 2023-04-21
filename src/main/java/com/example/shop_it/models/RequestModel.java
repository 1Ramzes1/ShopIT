package com.example.shop_it.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="request_model")
@Data
public class RequestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="p_name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "item_id")
    private Long itemId;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
