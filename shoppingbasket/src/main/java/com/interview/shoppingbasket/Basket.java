package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems( ) {
         Map<String, BasketItem> consolidatedItems = new HashMap<>();
        for (BasketItem basketItem : items) {
            String productCode = basketItem.getProductCode();

            if(consolidatedItems.containsKey(productCode)){
               BasketItem existingItem = consolidatedItems.get(productCode);
               int totalQuantity = existingItem.getQuantity() + basketItem.getQuantity();
               existingItem.setQuantity(totalQuantity);
            } else{
                BasketItem newItem = new BasketItem();
                newItem.setProductCode(basketItem.getProductCode());   
                newItem.setProductName(basketItem.getProductName());
                newItem.setQuantity(basketItem.getQuantity());
                newItem.setProductRetailPrice(basketItem.getProductRetailPrice());

                consolidatedItems.put(productCode, newItem);

            }
            
        }

        items.clear();
        items.addAll(consolidatedItems.values());
    }
}
