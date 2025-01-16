package com.convenience.convenience.repository.promotion;

import com.convenience.convenience.domain.Promotion;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ListPromotionRepository implements PromotionRepository {
    private static final List<Promotion> PROMOTIONS = List.of(
            new Promotion("탄산2+1", 2, 1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)),
            new Promotion("MD추천상품", 1, 1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)),
            new Promotion("반짝할인", 1, 1, LocalDate.of(2024, 11, 1), LocalDate.of(2024, 11, 30))
    );

    public List<Promotion> findByPromotionName(String name) {
        return PROMOTIONS.stream()
                .filter(promotion -> promotion.getPromotionName().equals(name))
                .toList();
    }
}
