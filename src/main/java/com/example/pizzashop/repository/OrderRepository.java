package com.example.pizzashop.repository;

import com.example.pizzashop.dao.OrderDAO;
import com.example.pizzashop.database.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderRepository {

    DatabaseConnectionManager manager = new DatabaseConnectionManager();

    public void storeOrder(OrderDAO orderDAO){
        Connection connection = manager.getConnection();

        String query = "INSERT INTO `order`(`ORDER_STATUS`, `ORDER_DATE`, `ORDER_TIME`, `ORDER_DELIVERY_METHOD`,`ORDER_TOTAL`, `PERSON_ID`,`ADDRESS_ID`) " +
                "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, orderDAO.getOrder_status());
            ps.setDate(2, orderDAO.getOrder_date());
            ps.setTime(3, orderDAO.getOrder_time());
            ps.setString(4, orderDAO.getOrder_delivery_method());
            ps.setInt(5, orderDAO.getOrder_total());
            ps.setInt(6, orderDAO.getPerson_id());
            ps.setInt(7, orderDAO.getAddress_id());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
