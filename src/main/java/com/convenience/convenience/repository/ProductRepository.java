package com.convenience.convenience.repository;

import com.convenience.convenience.domain.Product;
import java.util.List;

public interface ProductRepository {
    public List<Product> findAll();

    public List<Product> findAllByProductName(String name);
}
