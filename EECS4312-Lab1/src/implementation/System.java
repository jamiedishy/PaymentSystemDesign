package implementation;

public class System {
	// creates shoppers and managers
	int uniqueIdNumber = 0; 
	
	public Manager createManagerObject() {
		Manager manager = new Manager();
		manager.setId(this.uniqueIdNumber);
		this.uniqueIdNumber++;
		return manager;
	}
	
	// delete manager
	
	public void updateOrderStatus(Order order, Status status) {
		order.status = status;
	}
	
	public Notification sendNotification() {
		Notification notification = new Notification();
		return notification;
	}
	
}
