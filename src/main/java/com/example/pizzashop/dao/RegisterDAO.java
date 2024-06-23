package com.example.pizzashop.dao;

public class RegisterDAO {
    private int person_id;
    private String username;
    private String password;

    private String person_type;

    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String car_brand;
    private String car_plate;

    public RegisterDAO(){}

    public RegisterDAO(int person_id, String username, String password, String person_type, String first_name, String last_name, String email, String phone_number, String car_brand, String car_plate) {
        this.person_id = person_id;
        this.username = username;
        this.password = password;
        this.person_type = person_type;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.car_brand = car_brand;
        this.car_plate = car_plate;
    }

    //for customer registration
    public RegisterDAO(String username, String password, String person_type, String first_name, String last_name, String email, String phone_number) {
        this.username = username;
        this.password = password;
        this.person_type = person_type;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerson_type() {
        return person_type;
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }
}
