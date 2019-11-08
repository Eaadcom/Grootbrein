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
        String[] arr = ReadFile();

        Connection conn = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + arr[0]+"?user="+arr[1]+"&password="+ arr[2] + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
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
        String[] ret = new String[3];
        try {
            reader = new BufferedReader(new FileReader("SQLValues.txt"));
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                ret[i] = line;
                i++;
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
