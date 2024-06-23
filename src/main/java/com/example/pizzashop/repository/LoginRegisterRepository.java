package com.example.pizzashop.repository;

import com.example.pizzashop.dao.PersonDAO;
import com.example.pizzashop.dao.RegisterDAO;
import com.example.pizzashop.database.DatabaseConnectionManager;

import java.sql.*;

public class LoginRegisterRepository {

    DatabaseConnectionManager manager = new DatabaseConnectionManager();

    public void registerCustomer(RegisterDAO registerDAO){
        Connection connection = manager.getConnection();
        String query = "INSERT INTO `person`(`PERSON_USERNAME`, `PERSON_PASSWORD`, `PERSON_TYPE`)" +
                "VALUES(?,SHA1(?),?);";

        String query2 = "SELECT `PERSON_ID` FROM `person` WHERE `PERSON_USERNAME` = '"+registerDAO.getFirst_name()
                + "' AND `PERSON_PASSWORD` = SHA1('" + registerDAO.getPassword() + "');";

        String query3 = "INSERT INTO `customer`(`PERSON_ID`, `CUS_FIRST_NAME`,`CUS_LAST_NAME`,`CUS_EMAIL`,`CUS_PHONE_NUM`)" +
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, registerDAO.getFirst_name());
            ps.setString(2, registerDAO.getPassword());
            ps.setString(3,registerDAO.getPerson_type());
            ps.execute();

            Statement s = connection.createStatement();
            ResultSet re = s.executeQuery(query2);

            re.next();
            System.out.println("re.getInt(): "+ re.getInt("PERSON_ID"));

            PreparedStatement ps2 = connection.prepareStatement(query3);
            ps2.setInt(1, re.getInt("PERSON_ID"));
            ps2.setString(2, registerDAO.getFirst_name());
            ps2.setString(3, registerDAO.getLast_name());
            ps2.setString(4, registerDAO.getEmail());
            ps2.setString(5, registerDAO.getPhone_number());
            ps2.execute();

            re.close();
            ps.close();
            ps2.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public PersonDAO customerLogin(String username, String password){
        Connection connection = manager.getConnection();

        String query = "SELECT * FROM `person` WHERE `PERSON_USERNAME` = '" +
                username + "' AND `PERSON_PASSWORD` = SHA1('"+ password +"');";


        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);
            if(rs.next()) {
                Statement s2 = connection.createStatement();
                ResultSet rs2 = s2.executeQuery("SELECT * FROM `customer` WHERE `customer`.`PERSON_ID` = '" +
                        rs.getInt("PERSON_ID") + "';");
                rs2.next();
                PersonDAO personDAO = new PersonDAO(rs.getString("PERSON_USERNAME"), rs.getString("PERSON_TYPE"),
                        rs2.getString("CUS_FIRST_NAME"), rs2.getString("CUS_LAST_NAME"),
                        rs2.getString("CUS_EMAL"),rs2.getString("CUS_PHONE_NUM"));

                return personDAO;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }


}
