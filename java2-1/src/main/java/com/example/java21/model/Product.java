package com.example.java21.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNM;

    private int price;

    private int amount;

    public Product(String productNM, int price, int amount) {
        this.productNM = productNM;
        this.price = price;
        this.amount = amount;
    }

    public void changeProduct(String productNM, int price, int amount){
        this.productNM = productNM;
        this.price = price;
        this.amount = amount;
    }
}
