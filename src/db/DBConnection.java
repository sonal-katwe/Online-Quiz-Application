package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/onlinequiz";
    private static final String USER = "root";  // 
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");  
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found. Add the MySQL Connector JAR.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
