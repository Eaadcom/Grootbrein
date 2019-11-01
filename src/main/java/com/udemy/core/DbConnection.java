package com.udemy.core;

import com.mysql.cj.jdbc.Driver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DbConnection {

    public static Connection getConnection() {
        ReadFile();

        Connection conn = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grootbrein", "root", "root");
            //conn = DriverManager.getConnection("jdbc:mysql://ssh.strato.de:3850/DB3919273", "U3919273", "wachtwoord123");
            //DriverManager.registerDriver(new Driver());
            System.out.println("iam innnnn" + conn);

            return conn;
        }
        catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    public static String[] ReadFile() {
        BufferedReader reader;
        String[] ret = new String[2];
        try {
            reader = new BufferedReader(new FileReader("SQLValues.txt"));
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                System.out.println(line);
                ret[i] = line;
                line = reader.readLine();
                i++;
            }
            reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ret[0]);
        System.out.println(ret[1]);
        System.out.println(ret[2]);
        return ret;
    }
}
