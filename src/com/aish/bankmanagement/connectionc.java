package com.aish.bankmanagement;

import java.sql.*;

public class connectionc {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    private static final String url = "jdbc:mysql://127.0.0.1:3306/bank_mgnt_system";
    private static final String username = "root";
    private static final String password = "Aish@2004";


    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException c){
            System.out.println(c);
            c.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

}
