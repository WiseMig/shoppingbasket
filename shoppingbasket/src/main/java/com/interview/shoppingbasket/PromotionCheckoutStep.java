package com.interview.shoppingbasket;

import java.util.List;

public class PromotionCheckoutStep implements CheckoutStep {
    private PromotionsService promotionService;

    public PromotionCheckoutStep(PromotionsService promotionService) {
        this.promotionService = promotionService;
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        
        List<Promotion> applicablePromotions = promotionService.getPromotions(basket);

        checkoutContext.setApplicablePromotions(applicablePromotions);
    }
}