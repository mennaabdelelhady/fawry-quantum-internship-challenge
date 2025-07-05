package com.example.ecommerce;

public abstract class Product {
    protected String name;
    protected int price;
    protected int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public boolean isInStock(int requestedQty) {
        return requestedQty <= quantity;
    }

    public void deductStock(int qty) {
        quantity -= qty;
    }
}
