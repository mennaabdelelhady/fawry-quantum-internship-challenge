package com.example.ecommerce;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create products
        PhysicalProduct cheese = new PhysicalProduct("Cheese", 100, 10, LocalDate.now().plusDays(30), 0.4);
        PhysicalProduct biscuits = new PhysicalProduct("Biscuits", 150, 5, LocalDate.now().plusDays(60), 0.7);
        DigitalProduct scratchCard = new DigitalProduct("Mobile Scratch Card", 50, 100);

        // Create customer
        Customer customer = new Customer("Ahmed", 1000);

        // Add to cart
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        // Checkout
        CheckoutSystem.checkout(customer, cart);
    }
}
