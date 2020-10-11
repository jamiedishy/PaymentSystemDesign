package implementation;

import java.util.ArrayList;

public abstract class Account{
	private int id;
	private String password;
	private String username;
	public String shopperOrManager;
	public boolean signedIn = false;
	SystemCoordination systemInstance = SystemCoordination.getInstance();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void accountSignIn(String username, String password) {
		if (systemInstance.accountSignIn(username, password) == true) {
			this.signedIn = true;
			systemInstance.sendNotification("Sign in successfull");
		}
		else {
			systemInstance.sendNotification("Sign in failed");
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public ArrayList<Food> searchFoodByName(String name) {
		return systemInstance.getFoodItems(name);
	}
	
	public ArrayList<Food> searchFoodByMenu(String name) {
		return systemInstance.getFoodList();
	}
	
}