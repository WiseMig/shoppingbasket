package com.interview.shoppingbasket;

import java.util.List;

class CheckoutContext {
    private Basket basket;
    private double retailPriceTotal = 0.0;
    private List<Promotion> applicablePromotions;


    public void setRetailPriceTotal(double retailPriceTotal) {
        this.retailPriceTotal = retailPriceTotal;
    }

    CheckoutContext(Basket basket) {
        this.basket = basket;
    }

    public PaymentSummary paymentSummary() {
        return new PaymentSummary(retailPriceTotal);
    }


    public Basket getBasket() {
        return basket;
    }
    
       public List<Promotion> getApplicablePromotions() {
        return applicablePromotions;
    }

    public void setApplicablePromotions(List<Promotion> applicablePromotions) {
        this.applicablePromotions = applicablePromotions;
    }
}
