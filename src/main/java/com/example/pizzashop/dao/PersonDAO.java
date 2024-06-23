package com.example.pizzashop.dao;

public class PersonDAO {

    private String person_username;
    private String person_type;
    private String person_first_name;
    private String person_last_name;
    private String person_email;
    private String person_phone_number;

    public PersonDAO(){

    }

    public PersonDAO(String person_username, String person_type, String person_first_name, String person_last_name, String person_email, String person_phone_number) {
        this.person_username = person_username;
        this.person_type = person_type;
        this.person_first_name = person_first_name;
        this.person_last_name = person_last_name;
        this.person_email = person_email;
        this.person_phone_number = person_phone_number;
    }

    public String getPerson_username() {
        return person_username;
    }

    public void setPerson_username(String person_username) {
        this.person_username = person_username;
    }

    public String getPerson_type() {
        return person_type;
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }

    public String getPerson_first_name() {
        return person_first_name;
    }

    public void setPerson_first_name(String person_first_name) {
        this.person_first_name = person_first_name;
    }

    public String getPerson_last_name() {
        return person_last_name;
    }

    public void setPerson_last_name(String person_last_name) {
        this.person_last_name = person_last_name;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public String getPerson_phone_number() {
        return person_phone_number;
    }

    public void setPerson_phone_number(String person_phone_number) {
        this.person_phone_number = person_phone_number;
    }
}
