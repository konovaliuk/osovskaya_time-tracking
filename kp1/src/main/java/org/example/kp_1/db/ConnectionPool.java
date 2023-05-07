package org.example.kp_1.db;

import java.sql.Connection;
import java.sql.DriverManager;


//Класс, который может использоватсья для подключения к базе данных
public class ConnectionPool {

    private static Connection connection = null;

    static {
        try {
            String url = "jdbc:mysql://localhost:3306/kp1?useSSL=false";
            String username = "root";
            String password = "pass1234";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to Store DB succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public static Connection getConnection(){
        return connection;
    }


}
