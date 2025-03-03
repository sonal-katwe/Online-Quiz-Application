package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import services.UserService;

public class RegisterScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;  // Added email field
    private UserService userService;

    public RegisterScreen() {
        userService = new UserService();

        setTitle("Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));  // Increased rows to 5

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JLabel emailLabel = new JLabel("Email:");  // Added email label
        emailField = new JTextField();            // Added email input field

        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();  // Capture email input

                boolean success = userService.registerUser(username, password, "user", email); // Updated method call
                if (success) {
                    JOptionPane.showMessageDialog(null, "Registration successful! Please login.");
                    dispose();
                    new LoginScreen().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginScreen().setVisible(true);
            }
        });

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(emailLabel);   // Added email field to UI
        add(emailField);
        add(registerButton);
        add(backButton);
    }
}
