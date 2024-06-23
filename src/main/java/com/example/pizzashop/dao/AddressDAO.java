package com.example.pizzashop.dao;

public class AddressDAO {
    private int address_id;
    private String address_street;
    private String address_zip_code;

    public AddressDAO(){

    }

    public AddressDAO(int address_id, String address_street, String address_zip_code) {
        this.address_id = address_id;
        this.address_street = address_street;
        this.address_zip_code = address_zip_code;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public String getAddress_zip_code() {
        return address_zip_code;
    }

    public void setAddress_zip_code(String address_zip_code) {
        this.address_zip_code = address_zip_code;
    }
}
