package com.convenience.convenience.controller;

import com.convenience.convenience.domain.Product;

public class ProductDto {

    private String name;
    private Integer price;
    private String promotion;
    private Integer quantity;

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getPromotion() {
        return promotion;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
