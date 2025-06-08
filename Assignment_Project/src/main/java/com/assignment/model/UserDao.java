package com.assignment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/week6";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root1";
    private static final String INSERT_USERS_SQL =
        "INSERT INTO users (userName, userEmail, password, preferredName, name) VALUES (?, ?, ?, ?, ?)";

    public void registerUser(Signup signup) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
            ps.setString(1, signup.getUserName());
            ps.setString(2, signup.getUserEmail());
            ps.setString(3, signup.getPassword());
            ps.setString(4, signup.getPreferredName());
            ps.setString(5, signup.getName());
            ps.executeUpdate();
        }
    }
}
