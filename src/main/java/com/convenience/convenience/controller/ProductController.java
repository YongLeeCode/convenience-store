package com.convenience.convenience.controller;

import com.convenience.convenience.domain.Product;
import com.convenience.convenience.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDto> findProducts(@RequestParam(required = false) String name) {
        if (name == null) {
            return productService.findAll();
        }
        return productService.findAllByProductName(name);
    }

//    @RequestMapping(value = "/products", method = RequestMethod.POST)
//    public Product createProduct(@RequestBody Product product) {
//        return product;
//    }

}
