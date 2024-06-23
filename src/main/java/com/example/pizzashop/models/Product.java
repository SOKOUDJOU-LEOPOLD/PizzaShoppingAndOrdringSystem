package com.example.pizzashop.models;


import java.util.Objects;

public class Product {
    private int product_id;
    private String product_name;
    private String product_desc;
    private String pizza_type;

    private double price;

    public Product(int product_id, String product_name, String product_desc, String pizza_type, double price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.pizza_type = pizza_type;
        this.price = price;
    }

    public Product(String product_name, String product_desc, String pizza_type, double price) {
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.pizza_type = pizza_type;
        this.price = price;
    }

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getPizza_type() {
        return pizza_type;
    }

    public void setPizza_type(String pizza_type) {
        this.pizza_type = pizza_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_desc='" + product_desc + '\'' +
                ", pizza_type='" + pizza_type + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getProduct_id() == product.getProduct_id() && Double.compare(getPrice(), product.getPrice()) == 0 && Objects.equals(getProduct_name(), product.getProduct_name()) && Objects.equals(getProduct_desc(), product.getProduct_desc()) && Objects.equals(getPizza_type(), product.getPizza_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_name());
    }
}
