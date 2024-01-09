package com.interview.shoppingbasket;

public class Promotion {
    private String promotionCode;
    private String description;
    private String applicableProductCode;
    private double discountValue;


    public Promotion(String promotionCode, String description, String applicableProductCode, double discountValue) {
this.promotionCode = promotionCode;
this.description = description;
this.applicableProductCode = applicableProductCode;
this.discountValue = discountValue;
}

    public String getPromotionCode() {
        return promotionCode;
    }

    public String getDescription() {
        return description;
    }

    public String getApplicableProductCode() {
        return applicableProductCode;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setApplicableProductCode(String applicableProductCode) {
        this.applicableProductCode = applicableProductCode;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

}
