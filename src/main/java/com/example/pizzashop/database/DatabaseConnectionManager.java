package com.example.pizzashop.database;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


public class DatabaseConnectionManager {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pizza_order_delivery_system?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    private Connection connection;

    public DatabaseConnectionManager() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("Connected successfully!!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnectionManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection(){
        return connection;
    }
}

