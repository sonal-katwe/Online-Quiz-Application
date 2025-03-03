package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import models.Score;
import services.ScoreService;

public class LeaderboardScreen extends JFrame {
    private ScoreService scoreService;
    private JTable leaderboardTable;
    private DefaultTableModel tableModel;

    public LeaderboardScreen(int quizId) {
        scoreService = new ScoreService(); // Initialize ScoreService

        setTitle("Leaderboard");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Leaderboard - Top Scores", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // Table setup
        String[] columnNames = {"Rank", "Username", "Score"};
        tableModel = new DefaultTableModel(columnNames, 0);
        leaderboardTable = new JTable(tableModel);
        add(new JScrollPane(leaderboardTable), BorderLayout.CENTER);

        // Load leaderboard data
        loadLeaderboardData(quizId);

        setVisible(true);
    }

    private void loadLeaderboardData(int quizId) {
        List<Score> leaderboard = scoreService.getLeaderboard(quizId);

        tableModel.setRowCount(0); // Clear previous data
        int rank = 1;
        for (Score entry : leaderboard) {
            String username = scoreService.getUsernameById(entry.getUserId()); // Fetch username
            tableModel.addRow(new Object[]{rank++, username, entry.getScore()});
        }
    }
}
