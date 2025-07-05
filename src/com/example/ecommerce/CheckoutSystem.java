package com.example.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CheckoutSystem {
    private static final int SHIPPING_FEE = 30;

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        int subtotal = 0;
        List<Shippable> shippables = new ArrayList<>();

        System.out.println("** Checkout receipt**");

        for (Map.Entry<Product, Integer> entry : cart.getItems()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            int itemPrice = product.getPrice() * quantity;
            subtotal += itemPrice;

            System.out.printf("%dx %s %d\n", quantity, product.getName(), itemPrice);

            if (product instanceof Shippable) {
                shippables.add((Shippable) product);
            }

            product.deductStock(quantity);
        }

        int shippingCost = shippables.isEmpty() ? 0 : SHIPPING_FEE;
        int total = subtotal + shippingCost;

        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        customer.deductAmount(total);

        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingCost);
        System.out.println("Amount " + total);
        System.out.println("Customer balance after payment: " + customer.getBalance());
        System.out.println("END.");

        if (!shippables.isEmpty()) {
            ShippingService.ship(shippables);
        }

        cart.clear();
    }
}
