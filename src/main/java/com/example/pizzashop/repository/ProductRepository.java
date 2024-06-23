package com.example.pizzashop.repository;

import com.example.pizzashop.models.Product;

import java.util.List;

public class ProductRepository {

    public List<Product> getProducts(String category) {
        if (category.equalsIgnoreCase("drinks")) {
            return List.of(
                    new Product("Coke", "Fresh coke by coco cola", "Drinks", 1.25),
                    new Product("Coke", "Fresh coke by coco cola", "Drinks", 1.25),
                    new Product("Coke", "Fresh coke by coco cola", "Drinks", 1.25),
                    new Product("Coke", "Fresh coke by coco cola", "Drinks", 1.25),
                    new Product("Coke", "Fresh coke by coco cola", "Drinks", 1.25),
                    new Product("Coke", "Fresh coke by coco cola", "Drinks", 1.25)
            );
        }
        else if (category.equalsIgnoreCase("pizza")) {
            return List.of(
                    new Product("Pepperoni", "Nice Pizza with meat", "Pizza", 7.99),
                    new Product("Pepperoni", "Nice Pizza with meat", "Pizza", 7.99),
                    new Product("Pepperoni", "Nice Pizza with meat", "Pizza", 7.99),
                    new Product("Pepperoni", "Nice Pizza with meat", "Pizza", 7.99),
                    new Product("Pepperoni", "Nice Pizza with meat", "Pizza", 7.99),
                    new Product("Pepperoni", "Nice Pizza with meat", "Pizza", 7.99));
        }
        else if (category.equalsIgnoreCase("chicken")) {
            return List.of(
                    new Product("nuggets", "Nice nuggets with honey", "Chicken", 9.99),
                    new Product("nuggets", "Nice nuggets with honey", "Chicken", 9.99),
                    new Product("nuggets", "Nice nuggets with honey", "Chicken", 9.99),
                    new Product("nuggets", "Nice nuggets with honey", "Chicken", 9.99),
                    new Product("nuggets", "Nice nuggets with honey", "Chicken", 9.99),
                    new Product("nuggets", "Nice nuggets with honey", "Chicken", 9.99)
            );
        }

        else {
            return List.of(
                    new Product("ketchup", "ketchup", "Sauce", 0.99),
                    new Product("ketchup", "ketchup", "Sauce", 0.99),
                    new Product("ketchup", "ketchup", "Sauce", 0.99)

            );

        }
    }
}
