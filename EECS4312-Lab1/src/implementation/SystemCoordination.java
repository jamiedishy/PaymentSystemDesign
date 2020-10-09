package implementation;

import java.util.ArrayList;

public class SystemCoordination {
	private static SystemCoordination sSoleInstance;
	int uniqueIdNumber = 0;  
	ArrayList<Account> accountList = new ArrayList<Account>();
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
	public Manager createManagerObject(String username, String password) {
		Manager manager = new Manager();
		manager.shopperOrManager = "M";
		manager.setUsername(username);
		manager.setPassword(password);
		manager.setId(this.uniqueIdNumber);
		this.uniqueIdNumber++;
		accountList.add(manager);
		return manager;
	}
	
	public Order createOrder() {
		Order order = new Order();
		order.ID = uniqueIdNumber;
		uniqueIdNumber++;
		orderList.add(order);
		return order;
	}
	
    public void deleteOrder(int orderID) {
    	for (int i = 0; i < orderList.size(); i++) {
    		if (orderList.get(i).ID == orderID) {
    			orderList.remove(i);
    		}
    	}
    	sendNotification("Order deleted");
    }
	
	// delete manager
	public void deleteManagerObject(Manager manager) {
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getId() == manager.getId()) {
				accountList.remove(i);
			}
		}
	}
	
	public void updateOrderStatus(Order order, Status status) {
		order.status = status;
	}
	
	public ArrayList<Order> getShopperOrders(int shopperID) {
		ArrayList<Order> shopperOrders = new ArrayList<Order>(); 
		
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).associatedToShopperId == shopperID) {
				shopperOrders.add(orderList.get(i));
			}
		}
		return shopperOrders;
	}
	
	public Notification sendNotification(String message) {
		Notification notification = new Notification();
		notification.content = message;
		return notification;
	}
	
	public void shopperSignUp(String username, String password) {
		Shopper shopper = new Shopper();
		shopper.setId(this.uniqueIdNumber);
		shopper.setUsername(username);
		shopper.setPassword(password);
		shopper.shopperOrManager = "S";
		this.uniqueIdNumber++;
		accountList.add(shopper);
	}
	
	public boolean accountSignIn(String accountUsername, String accountPassword) {
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getUsername().equals(accountUsername) && accountList.get(i).getPassword().equals(accountPassword)) {
				return true;
			}
		}
		return false;
	}
}
