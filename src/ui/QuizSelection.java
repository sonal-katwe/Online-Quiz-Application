package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Quiz;
import models.User;
import services.QuizService;
import java.util.List;


public class QuizSelection extends JFrame{
	private QuizService quizService;
    private User user;

    public QuizSelection(User user) {
        this.user = user;
        quizService = new QuizService();

        setTitle("Select Quiz");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(quizService.getAllQuizzes().size() + 2, 1, 10, 10));

        JLabel titleLabel = new JLabel("Select a Quiz");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        List<Quiz> quizzes = quizService.getAllQuizzes();
        for (Quiz quiz : quizzes) {
            JButton quizButton = new JButton(quiz.getTitle());
            quizButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new QuizScreen(user, quiz).setVisible(true);
                }
            });
            add(quizButton);
        }
    }
}
