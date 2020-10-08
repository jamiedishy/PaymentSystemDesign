package implementation;

import java.util.ArrayList;

public class SystemCoordination {
	private static SystemCoordination sSoleInstance;
	// creates shoppers and managers
	int uniqueIdNumber = 0; 
	ArrayList<Manager> managerList = new ArrayList<Manager>(); 
	ArrayList<Shopper> shopperList = new ArrayList<Shopper>(); 
	ArrayList<Order> orderList = new ArrayList<Order>(); 
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	private SystemCoordination(){}  //private constructor... one instance of class
	
    public static SystemCoordination getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new SystemCoordination();
        }
        return sSoleInstance;
    }
    
    // add item
    public void addItem(Item item) {
    	item.ID = uniqueIdNumber;
    	uniqueIdNumber++;
    	itemList.add(item);
    	sendNotification("Item added");
    }
    
    // delete item
    public void deleteItem(Item item) {
    	for (int i = 0; i < itemList.size(); i++) {
    		if (itemList.get(i).ID == item.ID) {
    			itemList.remove(i);
    		}
    	}
    	sendNotification("Item deleted");
    }
    
    // create manager
	public Manager createManagerObject() {
		Manager manager = new Manager();
		manager.setId(this.uniqueIdNumber);
		this.uniqueIdNumber++;
		managerList.add(manager);
		return manager;
	}
	
	public Order createOrder() {
		Order order = new Order();
		order.ID = uniqueIdNumber;
		uniqueIdNumber++;
		orderList.add(order);
		return order;
	}
	
	// delete manager
	public void deleteManagerObject(Manager manager) {
		for (int i = 0; i < managerList.size(); i++) {
			if (managerList.get(i).getId() == manager.getId()) {
				managerList.remove(i);
			}
		}
	}
	
	public void updateOrderStatus(Order order, Status status) {
		order.status = status;
	}
	
	public Notification sendNotification(String message) {
		Notification notification = new Notification();
		notification.content = message;
		return notification;
	}
	
}
