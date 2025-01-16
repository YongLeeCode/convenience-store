package com.convenience.convenience.repository.promotion;

import com.convenience.convenience.domain.Promotion;
import java.util.List;

public interface PromotionRepository {
    List<Promotion> findByPromotionName(String name);
}
