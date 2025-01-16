package com.convenience.convenience.controller.product;

import com.convenience.convenience.service.ProductService;
import java.util.List;
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
    public List<ProductDto> findProducts(@RequestParam(required = false) String name,
            @RequestParam(required = false) String promotion) {
        if (name != null && promotion != null) {
            return productService.findAllByProductNameAndPromotion(name, promotion);
        } else if (name != null) {
            return productService.findAllByProductName(name);
        } else if (promotion != null) {
            return productService.findAllByProductPromotion(promotion);
        } else {
            return productService.findAll();
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public String purchaseProducts(
            @RequestParam String name,
            @RequestParam Integer quantity
    ) {
        return productService.purchaseProduct(name, quantity);
    }
}
