package com.example.ecommerce;

import java.util.*;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void add(Product product, int quantity) throws Exception {
        if (!product.isInStock(quantity)) {
            throw new Exception("Not enough stock for " + product.getName());
        }
        if (product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()) {
            throw new Exception(product.getName() + " is expired.");
        }

        items.put(product, quantity);
    }

    public Collection<Map.Entry<Product, Integer>> getItems() {
        return items.entrySet();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
