package com.example.pizzashop.dao;

import java.sql.Date;
import java.sql.Time;

public class OrderDAO {
    private String order_status;
    private Date order_date;
    private Time order_time;
    private String order_delivery_method;
    private int order_total;

    private int person_id;
    private int address_id;

    public OrderDAO(){}

    public OrderDAO(String order_status, Date order_date, Time order_time, String order_delivery_method, int order_total, int person_id, int address_id) {
        this.order_status = order_status;
        this.order_date = order_date;
        this.order_time = order_time;
        this.order_delivery_method = order_delivery_method;
        this.order_total = order_total;
        this.person_id = person_id;
        this.address_id = address_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Time getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Time order_time) {
        this.order_time = order_time;
    }

    public String getOrder_delivery_method() {
        return order_delivery_method;
    }

    public void setOrder_delivery_method(String order_delivery_method) {
        this.order_delivery_method = order_delivery_method;
    }

    public int getOrder_total() {
        return order_total;
    }

    public void setOrder_total(int order_total) {
        this.order_total = order_total;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }
}
