package com.example.pizzashop.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderReceipt {
    private static int receiptCounter = 0;

    private final String receiptNumber;
    private final Date date;
    private final List<Product> products;

    public OrderReceipt(List<Product> products) {
        this.receiptNumber = "#001" + String.valueOf(++receiptCounter);
        this.products = products;
        date = new Date();
    }

    public String generateReceipt(String cardNumber) {
        StringBuilder bill = new StringBuilder();
        bill.append("-------------------------------\n");
        bill.append("Mom and Pops Pizza\n");
        bill.append("-------------------------------\n");
        bill.append("Receipt #: ").append(String.format("%s", receiptNumber)).append("\n");
        bill.append("Date: ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date)).append("\n");
        bill.append("Item            Quantity   Price\n");
        bill.append("--------------------------------\n");

        double subtotal = 0;
        for (Product product : products) {
            bill.append(String.format("%-15s%-11d$%.2f%n", product.getProduct_name(), 1, product.getPrice()));
            subtotal += product.getPrice();
        }

        double taxRate = 0.07;
        double tax = subtotal * taxRate;
        double total = subtotal + tax;

        bill.append("--------------------------------\n");
        bill.append(String.format("Subtotal:                   $%.2f%n", subtotal));
        bill.append(String.format("Tax (%.0f%%):                  +$%.2f%n", taxRate * 100, tax));
        bill.append(String.format("Total:                      $%.2f%n", total));
        bill.append("Payment Method: Credit Card\n");
        bill.append("Card Number: **** **** **** ").append(getLastFourDigits(cardNumber)).append("\n");
        bill.append("Authorization Code: 987654\n");
        bill.append("--------------------------------------------\n");
        bill.append("Thank you for dining with us!\n");
        bill.append("--------------------------------------------\n");

        return bill.toString();
    }

    private String getLastFourDigits(String cardNumber) {
        if (cardNumber.isEmpty()) {
            return "";
        }
        return cardNumber.substring(cardNumber.length() - 4);
    }

}

