package com.convenience.convenience.domain;

public class Product {

    private String name;
    private Integer price;
    private String promotion;
    private Integer quantity;

    public Product(String name, int price, String promotion, int quantity) {
        this.name = name;
        this.price = price;
        this.promotion = promotion;
        this.quantity = quantity;
    }

    public Boolean containsName(String name) {
        return this.name.contains(name);
    }
}
