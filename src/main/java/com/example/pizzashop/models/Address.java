package com.example.pizzashop.models;

import java.util.Objects;

public class Address {
    private int id;
    private String street;
    private String zipCode;

    public Address(int id, String street, String zipCode, String state) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
    }

    public Address(String street, String zipCode, String state) {
        this.street = street;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return getId() == address.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return street;
    }
}
