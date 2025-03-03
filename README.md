# Online-Quiz-Application
Online Quiz Application

📌 Project Description

The Online Quiz Application is a Java-based desktop application built using Swing and JDBC. It allows users to select quizzes, answer multiple-choice questions, track their scores, and view leaderboards. The application interacts with a MySQL database to store user details, questions, and scores.

🚀 Features

User Authentication: Register and log in securely.

Quiz Selection: Choose from multiple quiz topics (Java Basics, OOP, Data Structures, etc.).

Timed Questions: Each question has a countdown timer.

Score Tracking: Stores and displays quiz scores in the database.

Leaderboard: Displays the top scores for each quiz.

Swing-based UI: Simple and user-friendly graphical interface.

🛠️ Technologies Used

Java (Swing for UI)

JDBC (Database Connectivity)

MySQL (Database Storage)

Eclipse (IDE for Development)

GitHub (Version Control)

📂 Project Structure

Online-Quiz-Application/
│── src/
│   ├── ui/               # User Interface (Swing)
│   ├── models/           # Data Models
│   ├── services/         # Database Services
│   ├── db/               # Database Connection
│── resources/
│── README.md            # Project Documentation
│── Quiz.sql             # Database Schema
│── OnlineQuiz.jar       # Runnable JAR File

🏗️ Setup & Installation

1️⃣ Clone the Repository

git clone https://github.com/sonal-katwe/Online-Quiz-Application.git
cd Online-Quiz-Application

2️⃣ Set Up the Database

Open MySQL Workbench or any MySQL client.

Create a database:

CREATE DATABASE quiz_app;

Import the database schema from Quiz.sql:

mysql -u root -p quiz_app < Quiz.sql

Update the database configuration in DBConnection.java:

private static final String URL = "jdbc:mysql://localhost:3306/quiz_app";
private static final String USER = "root";
private static final String PASSWORD = "your_password";

3️⃣ Run the Application

Open Eclipse and import the project.

Run the main class: QuizMain.java

OR Run the JAR file:

java -jar OnlineQuiz.jar

📊 How to Use

Register/Login into the application.

Select a Quiz from the available topics.

Answer Questions within the given time limit.

View Your Score at the end of the quiz.

Check the Leaderboard to see top scores.

🎯 Future Enhancements

Convert to Web Application (Spring Boot + React)

Add More Quiz Categories

User Progress Tracking

Mobile App Integration

📌 Contributing

Contributions are welcome! To contribute:

Fork the repository

Create a new branch (feature-xyz)

Commit changes and push

Open a pull request


📞 Contact

👩‍💻 Sonal D Katwe📧 Email: sonalkatwe83@gmail.com🔗 GitHub: sonal-katwe
