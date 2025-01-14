package com.convenience.convenience.control;

import com.convenience.convenience.domain.Product;
import com.convenience.convenience.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> findProducts() {
        return productService.findAll();
    }

//    @RequestMapping(value = "/products", method = RequestMethod.POST)
//    public Product createProduct(@RequestBody Product product) {
//        return product;
//    }

}
