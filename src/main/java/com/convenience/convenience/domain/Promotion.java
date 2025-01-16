package com.convenience.convenience.domain;

import java.time.LocalDate;

public class Promotion {

    private String promotionName;
    private Integer buy;
    private Integer get;
    private LocalDate start_date;
    private LocalDate end_date;

    public Promotion(
            String promotionName,
            Integer buy,
            Integer get,
            LocalDate start_date,
            LocalDate end_date
    ) {
        this.promotionName = promotionName;
        this.buy = buy;
        this.get = get;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public boolean isApplicable(String promotion) {
        this.promotionName.equals(promotion);
        return true;
    }
}
