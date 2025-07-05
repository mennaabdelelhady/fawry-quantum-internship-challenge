package com.example.ecommerce;
import java.time.LocalDate;

public class PhysicalProduct extends ExpirableProduct implements Shippable {
    private double weight;

    public PhysicalProduct(String name, int price, int quantity,
                           LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
