package com.example.pizzashop.utils;

import com.example.pizzashop.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static CartService instance;

    private List<Product> cart;

    private CartService() {
        cart = new ArrayList<>();
    }

    public static CartService getInstance() {
        if (instance == null) {
            instance = new CartService();
        }
        return instance;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }
}
