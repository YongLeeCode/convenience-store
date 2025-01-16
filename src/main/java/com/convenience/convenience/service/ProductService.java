package com.convenience.convenience.service;

import com.convenience.convenience.controller.product.ProductDto;
import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    List<ProductDto> findAllByProductName(String name);

    List<ProductDto> findAllByProductPromotion(String promotion);

    List<ProductDto> findAllByProductNameAndPromotion(String name, String promotion);

    String purchaseProduct(String name, Integer quantity);
}
