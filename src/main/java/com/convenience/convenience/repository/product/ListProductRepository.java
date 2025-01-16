package com.convenience.convenience.repository;

import com.convenience.convenience.domain.Product;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ListProductRepository implements ProductRepository {

    private static final List<Product> products = List.of(
            new Product("콜라", 1000, "탄산2+1", 5),
            new Product("콜라", 1000, null, 10),
            new Product("사이다", 1000, "탄산2+1", 8),
            new Product("사이다", 1000, null, 7),
            new Product("오렌지주스", 1800, "MD추천상품", 9),
            new Product("탄산수", 1200, "탄산2+1", 5),
            new Product("물", 500, null, 10),
            new Product("비타민워터", 1500, null, 6),
            new Product("감자칩", 1500, "반짝할인", 5),
            new Product("감자칩", 1500, null, 5),
            new Product("초코바", 1200, "MD추천상품", 5),
            new Product("초코바", 1200, null, 5),
            new Product("에너지바", 2000, null, 5),
            new Product("정식도시락", 6400, null, 8),
            new Product("컵라면", 1700, "MD추천상품", 1),
            new Product("컵라면", 1700, null, 10)
    );

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findAllByProductName(String name) {
        return products.stream()
                .filter(product -> product.containsName(name))
                .toList();
    }

    public List<Product> findAllByProductPromotion(String promotion) {
        return products.stream()
                .filter(product -> product.containsPromotion(promotion))
                .toList();
    }

    public List<Product> findAllByProductNameAndPromotion(String name, String promotion) {
        return products.stream()
                .filter(product -> product.containsName(name))
                .filter(product -> product.containsPromotion(promotion))
                .toList();
    }

}
