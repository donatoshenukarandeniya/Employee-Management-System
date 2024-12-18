package com.shadex.zoologix.employee_management_system.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class MySql {
    private static Connection connection;

    public static void createConnection() throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system", "root", "Admin");
        }
    }

    public static ResultSet executeSearch(String query) throws Exception {
        createConnection();
        return connection.createStatement().executeQuery(query);
    }

    public static Integer executeIUD(String query) throws Exception {
        createConnection();
        return connection.createStatement().executeUpdate(query);
    }
}
