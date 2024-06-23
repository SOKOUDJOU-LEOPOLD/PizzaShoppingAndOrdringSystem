package com.example.pizzashop.utils;

import com.example.pizzashop.models.Address;

public class AddressService {

    private static AddressService instance;
    private String address;

    private AddressService(Address address) {
        this.address = address.toString();
    }

    private AddressService() {
        this.address = "";
    }

    public static AddressService getInstance() {
        if (instance == null) {
            instance =  new AddressService();
        }
        return instance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address.toString();
    }
}
