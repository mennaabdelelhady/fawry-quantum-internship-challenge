package com.example.ecommerce;

import java.time.LocalDate;

public class ExpirableProduct extends Product {
    private LocalDate expirationDate;

    public ExpirableProduct(String name, int price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}
