package com.example.pizzashop.repository;

import com.example.pizzashop.database.DatabaseConnectionManager;

import java.sql.*;

public class AddressRepository {

    DatabaseConnectionManager manager = new DatabaseConnectionManager();

    public int storeAddress(String address_street, String address_zip_code){
        Connection connection = manager.getConnection();

        String query = "INSERT INTO `address`(`ADDRESS_STREET`, `ADDRESS_ZIP_CODE`) VALUES(?,?);";
        String query2 = "SELECT `address_id` FROM `address` WHERE `ADDRESS_STREET` = '" +
                address_street+"' AND `ADDRESS_ZIP_CODE` = '"+ address_zip_code + "';";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, address_street);
            ps.setString(2, address_zip_code);
            ps.execute();

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query2);

            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
