package implementation;

public abstract class Account {
	private int id;
	private String password;
	private String username;
	String shopperOrManager;
	boolean signedIn = false;
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
	
	public void accountSignIn(int id, String password) {
		if (systemInstance.accountSignIn(id, password) == true) {
			signedIn = true;
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
}