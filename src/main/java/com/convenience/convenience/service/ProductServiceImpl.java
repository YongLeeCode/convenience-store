package com.convenience.convenience.service;

import com.convenience.convenience.controller.ProductDto;
import com.convenience.convenience.domain.Product;
import com.convenience.convenience.repository.ListProductRepository;
import com.convenience.convenience.repository.ProductRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ModelMapper modelMapper;
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findAllByProductName(String name) {
        List<Product> products = productRepository.findAllByProductName(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findAllByProductPromotion(String promotion) {
        List<Product> products = productRepository.findAllByProductPromotion(promotion);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    public List<ProductDto> findAllByProductNameAndPromotion(String name, String promotion) {
        List<Product> products = productRepository.findAllByProductNameAndPromotion(name, promotion);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }
}
