package services;
import db.DBConnection;
import models.User;
import java.sql.*;
public class UserService {

	 // Method to register a new user
	public boolean registerUser(String username, String password, String role, String email) {
	    String query = "INSERT INTO users (username, password, role, email, highest_score) VALUES (?, ?, ?, ?, 0)";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        stmt.setString(1, username);
	        stmt.setString(2, password);
	        stmt.setString(3, role);
	        stmt.setString(4, email);  // Added email parameter

	        int rowsInserted = stmt.executeUpdate();
	        return rowsInserted > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
    }

    // Method to validate user login
    public User loginUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getInt("highest_score")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
