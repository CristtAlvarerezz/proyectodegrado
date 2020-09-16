package com.example.lambda;

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

class connection {
    Connection Splice = null;
    public static int block = 0;

    public static String mistake = "";

    public Connection database_connection(String Address) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Splice = DriverManager.getConnection("jdbc:mysql://" + Address + "", "root", "12345678");
            //System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException | SQLException e) {

        }
        return (Connection) Splice;
    }
}