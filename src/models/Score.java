package models;

public class Score {
	 private int scoreId;
	    private int userId;
	    private int quizId;
	    private int score;
	    
	    // Constructor
	    public Score(int scoreId, int userId, int quizId, int score) {
	        this.scoreId = scoreId;
	        this.userId = userId;
	        this.quizId = quizId;
	        this.score = score;
	    }

	    // Getters and Setters
	    public int getScoreId() {
	        return scoreId;
	    }

	    public void setScoreId(int scoreId) {
	        this.scoreId = scoreId;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public int getQuizId() {
	        return quizId;
	    }

	    public void setQuizId(int quizId) {
	        this.quizId = quizId;
	    }

	    public int getScore() {
	        return score;
	    }

	    public void setScore(int score) {
	        this.score = score;
	    }
}
