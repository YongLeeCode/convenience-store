package com.convenience.convenience.repository;

import com.convenience.convenience.domain.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    List<Product> findAllByProductName(String name);

    List<Product> findAllByProductPromotion(String promotion);

    List<Product> findAllByProductNameAndPromotion(String name, String promotion);

}
