package model;

public class User {
	private String username;
	private String password;
	private TYPE_OF_USER typeOfUser;
	
	public User(String username, String password, TYPE_OF_USER typeOfUser) {
		this.username = username;
		this.password = password;
		this.typeOfUser = typeOfUser;
	}
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public TYPE_OF_USER getTypeOfUser() { return typeOfUser; }
	public void setTypeOfUser(TYPE_OF_USER typeOfUser) { this.typeOfUser = typeOfUser; }

	public boolean equals(User user) { return username.equals(user.username) && password.equals(user.password); }
	public boolean equals(String u, String p) { return username.equals(u) && password.equals(p); }
	
	
	
}
