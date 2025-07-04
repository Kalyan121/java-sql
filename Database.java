package com.secureapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/secure_app";
    private static final String USER = "root"; // change as needed
    private static final String PASS = "your_password"; // change as needed

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
