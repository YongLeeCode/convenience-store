package com.convenience.convenience.service;

import com.convenience.convenience.controller.product.ProductDto;
import com.convenience.convenience.domain.Product;
import com.convenience.convenience.domain.Promotion;
import com.convenience.convenience.repository.product.ProductRepository;
import com.convenience.convenience.repository.promotion.PromotionRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ModelMapper modelMapper;
    private ProductRepository productRepository;
    private PromotionRepository promotionRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper,
            PromotionRepository promotionRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.promotionRepository = promotionRepository;
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

    public String purchaseProduct(String name, Integer quantity) {
        List<Product> products = productRepository.findAllByProductName(name);

        int totalAvailableQuantity = products.stream().mapToInt(product -> product.getQuantity()).sum();
        if (totalAvailableQuantity < quantity) {
            return name + "의 수량이 부족하여 구매에 실패하였습니다.";
        }

        int price = 0;
        int remainingQuantity = quantity;
        for (Product product : products) {
            int productQuantity = product.getQuantity();
            System.out.println(quantity);
//            if(product.getPromotion() != null && productQuantity > 0) {
                List<Promotion> promotions = promotionRepository.findByPromotionName(product.getPromotion());
                if (promotions.stream()
                        .anyMatch(promotion -> promotion
                                .getPromotionName()
                                .equals(product.getPromotion()))) {
                    quantity = quantity - quantity / 3;
                    System.out.println(quantity);
                }
//            }

            if (remainingQuantity <= productQuantity) {
                product.decreaseQuantity(remainingQuantity);
                break;
            } else {
                remainingQuantity -= productQuantity; // 부족한 수량 계산
                product.decreaseQuantity(productQuantity); // 현재 상품 모두 소진
            }
        }
        price = quantity * products.get(0).getPrice();
        System.out.println("price: " + price);

        // 차감 후 확인용 출력
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        productDtos.forEach(t -> System.out.println(t.getName() + " | " + t.getQuantity() + " | " + t.getPromotion()));
        System.out.println(quantity);
        return "구매가 완료되었습니다.";
    }
}
