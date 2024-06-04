package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;


@SpringBootApplication
public class DemoApplication {
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/db-productos";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Hola squirtle");

        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlSelectAllPersons = "SELECT * FROM producto";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("nombre");
                System.out.println("Hola pika");

                System.out.println(name);
                // do something with the extracted data...
            }
        } catch (SQLException e) {
            // handle the exception
        }
        System.out.println("Hola charizard");





    }

}
