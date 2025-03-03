package models;

public class User {
	 private int userId;
	    private String username;
	    private String password;
	    private String role;
	    private int highestScore;

	    // Constructor
	    public User(int userId, String username, String password, String role, int highestScore) {
	        this.userId = userId;
	        this.username = username;
	        this.password = password;
	        this.role = role;
	        this.highestScore = highestScore;
	    }

	    // Getters and Setters
	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }

	    public int getHighestScore() {
	        return highestScore;
	    }

	    public void setHighestScore(int highestScore) {
	        this.highestScore = highestScore;
	    }
}
