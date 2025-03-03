package services;

import db.DBConnection;
import models.Score;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreService {

    // Store user quiz score
    public boolean storeScore(int userId, int quizId, int score) {
        String query = "INSERT INTO scores (user_id, quiz_id, score) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, quizId);
            stmt.setInt(3, score);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get leaderboard data
    public List<Score> getLeaderboard(int quizId) {
        List<Score> leaderboard = new ArrayList<>();
        String query = "SELECT * FROM scores WHERE quiz_id = ? ORDER BY score DESC LIMIT 10";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, quizId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                leaderboard.add(new Score(
                        rs.getInt("score_id"),
                        rs.getInt("user_id"),
                        rs.getInt("quiz_id"),
                        rs.getInt("score")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaderboard;
    }

    // Get username by user ID
    public String getUsernameById(int userId) {
        String query = "SELECT username FROM users WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if not found
    }
}
