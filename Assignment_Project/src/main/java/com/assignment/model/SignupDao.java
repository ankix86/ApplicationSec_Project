package com.assignment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SignupDao {
	
	
	   private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Assign2_AnkitkumarSuthar";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "root1";
	    private static final String INSERT_USERS_SQL =
	        "INSERT INTO users (userName, userEmail, pass, preferredName, fullName) VALUES (?, ?, ?, ?, ?)";
	    
	    
	public int registerUser(Signup signup) throws ClassNotFoundException {

		// create SQL statement
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");

		  try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
		             PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
		            ps.setString(1, signup.getUserName());
		            ps.setString(2, signup.getUserEmail());
		            ps.setString(3, signup.getPassword());
		            ps.setString(4, signup.getPreferredName());
		            ps.setString(5, signup.getName());
		            ps.executeUpdate();
		  
			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
			
		}
		return result;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {

				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();

				}
			}

		}

	}
}