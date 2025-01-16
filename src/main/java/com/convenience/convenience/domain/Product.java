package com.convenience.convenience.domain;

import java.util.Objects;

public class Product {

    private String name;
    private Integer price;
    private String promotion;
    private Integer quantity;

    public Integer getPrice() {
        return price;
    }

    public Product(String name, int price, String promotion, int quantity) {
        this.name = name;
        this.price = price;
        this.promotion = promotion;
        this.quantity = quantity;
    }

    public String getPromotion() {
        return promotion;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Boolean containsName(String name) {
        return this.name.contains(name);
    }

    public Boolean containsPromotion(String promotion) {
        if (this.promotion == null || promotion == null) {
            return false;
        }
        if (this.quantity <= 0) {
            return false;
        }
        return this.promotion.contains(promotion);
    }

    public int decreaseQuantity(Integer quantity) {
        if (this.quantity > quantity) {
            this.quantity -= quantity;
            return 0;
        } else {
            int remain = quantity - this.quantity;
            this.quantity = 0;
            return remain;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }
}
