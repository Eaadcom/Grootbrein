package com.udemy.core;

import com.mysql.jdbc.Driver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getConnection() {
        Connection conn = null;
        try {

            //Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trip_db", "newuser", "password");
            //conn = DriverManager.getConnection("jdbc:mysql://ssh.strato.de:3850/DB3919273", "U3919273", "wachtwoord123");
            //DriverManager.registerDriver(new Driver());
            System.out.println("iam innnnn" + conn);

            return conn;
        }
        catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
