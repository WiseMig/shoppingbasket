package com.interview.shoppingbasket;

import java.util.List;

public class RetailPriceCheckoutStep implements CheckoutStep {
    private PricingService pricingService;
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService) {
        this.pricingService = pricingService;
    }
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;

        List<Promotion> applicablePromotions = checkoutContext.getApplicablePromotions(); // Get applicable promotions

        for (BasketItem basketItem : basket.getItems()) {
            int quantity = basketItem.getQuantity();
            double price = pricingService.getPrice(basketItem.getProductCode());

            for (Promotion promotion : applicablePromotions) {
                if (promotion.getApplicableProductCode().equals(basketItem.getProductCode())) {
                    price = applyPromotion(promotion, basketItem, price);
                }
            }

            basketItem.setProductRetailPrice(price);
            retailTotal += quantity * price;
        }

        checkoutContext.setRetailPriceTotal(retailTotal);
    }

    public double applyPromotion(Promotion promotion, BasketItem item, double price) {
        
        if (promotion.getDiscountValue() > 0) {
            double discount = (promotion.getDiscountValue() / 100) * price;
            retailTotal -= discount;
        }
        return retailTotal;
    }
}
