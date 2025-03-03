package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import models.Question;
import models.Quiz;
import models.User;
import services.QuizService;
import services.ScoreService;

public class QuizScreen extends JFrame {
    private Quiz quiz;
    private User user;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private Timer timer;
    private int timeLeft = 30;
    private JLabel timerLabel, questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionGroup;
    private JButton nextButton;
    private QuizService quizService;
    private ScoreService scoreService;

    public QuizScreen(User user, Quiz quiz) {
        this.user = user;
        this.quiz = quiz;
        this.quizService = new QuizService();
        this.scoreService = new ScoreService();
        this.questions = quizService.getQuestionsForQuiz(quiz.getQuizId());

        setTitle("Quiz: " + quiz.getTitle());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1, 10, 10));

        timerLabel = new JLabel("Time left: " + timeLeft + "s");
        questionLabel = new JLabel();
        options = new JRadioButton[4];
        optionGroup = new ButtonGroup();

        add(timerLabel);
        add(questionLabel);

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            optionGroup.add(options[i]);
            add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> processAnswer());
        add(nextButton);

        // Initialize and reuse timer instance
        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time left: " + timeLeft + "s");
            if (timeLeft == 0) {
                processAnswer();
            }
        });

        if (questions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No questions available for this quiz!", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            new QuizSelection(user).setVisible(true);
        } else {
            loadQuestion();
            timer.start();
        }
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
            questionLabel.setText(question.getQuestionText());
            options[0].setText(question.getOptionA());
            options[1].setText(question.getOptionB());
            options[2].setText(question.getOptionC());
            options[3].setText(question.getOptionD());

            optionGroup.clearSelection(); // Clear previous selection
            timeLeft = 30;
            timer.start();
        } else {
            endQuiz();
        }
    }

    private void processAnswer() {
        timer.stop(); // Stop timer when processing answer

        if (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
            String selectedOption = getSelectedOption();

            if (selectedOption != null && selectedOption.equals(question.getCorrectOption())) {
                score++;
            }
        }

        currentQuestionIndex++;

        if (currentQuestionIndex < questions.size()) {
            loadQuestion();
        } else {
            endQuiz();
        }
    }

    private String getSelectedOption() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                return String.valueOf((char) ('A' + i)); // Convert index 0 -> 'A', 1 -> 'B', etc.
            }
        }
        return null;
    }

    private void endQuiz() {
        JOptionPane.showMessageDialog(this, "Quiz Over! Your Score: " + score);

        ScoreService scoreService = new ScoreService(); // Ensure ScoreService is initialized
        boolean isStored = scoreService.storeScore(user.getUserId(), quiz.getQuizId(), score);
        
        if (!isStored) {
            JOptionPane.showMessageDialog(this, "Failed to save score!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        dispose(); 
        new LeaderboardScreen(quiz.getQuizId()).setVisible(true); // Show leaderboard after quiz
    }

}
