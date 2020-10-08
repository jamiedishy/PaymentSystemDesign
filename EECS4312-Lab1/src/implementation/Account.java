package implementation;

public abstract class Account {
	private int id;
	private String password;
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
}