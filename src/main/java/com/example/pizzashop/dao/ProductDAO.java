package com.example.pizzashop.dao;

public class ProductDAO {
    private int product_id;
    private String product_name;
    private String product_description;
    private String product_type;


    public ProductDAO(){

    }

    public ProductDAO(int product_id, String product_name, String product_description, String product_type) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_type = product_type;
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

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
}
