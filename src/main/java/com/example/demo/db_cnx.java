package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_cnx {
    public static Connection cnxLink;

    public static Connection getCnx() throws SQLException {
        String dbName = "mini_projet_java";
        String dbUser = "root";
        String dbPassword = "3743@Hrn";
        String url = "jdbc:mysql://localhost/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnxLink = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cnxLink;
    }
}

