package com.example.ecommerce;

import java.util.List;

public class ShippingService {
    public static void ship(List<Shippable> shippables) {
        double totalWeight = 0.0;
        System.out.println("** Shipment notice**");
        for (Shippable item : shippables) {
            System.out.printf("%s %.0fg\n", item.getName(), item.getWeight() * 1000); // kg -> g
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
