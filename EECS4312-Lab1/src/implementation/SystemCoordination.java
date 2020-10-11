package implementation;

import java.util.ArrayList;

public class SystemCoordination {
	private static SystemCoordination sSoleInstance;
	int uniqueIdNumber = 0;  
	ArrayList<Account> accountList = new ArrayList<Account>();
	ArrayList<Order> orderList = new ArrayList<Order>(); 
	ArrayList<Food> foodList = new ArrayList<Food>();
	
	private SystemCoordination(){}  //private constructor... one instance of class
	
    public static SystemCoordination getInstance(){
        if (sSoleInstance == null){ //if there is no instance available... create new one
            sSoleInstance = new SystemCoordination();
        }
        return sSoleInstance;
    }
    
    // add Food
    public void addFood(Food Food) {
    	Food.ID = uniqueIdNumber;
    	uniqueIdNumber++;
    	foodList.add(Food);
    	sendNotification("Food added");
    }
    
    // delete Food
    public void deleteFood(Food Food) {
    	for (int i = 0; i < foodList.size(); i++) {
    		if (foodList.get(i).ID == Food.ID) {
    			foodList.remove(i);
    		}
    	}
    	sendNotification("Food deleted");
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
	
	public ArrayList<Food> getFoodItems(String foodName) {
		ArrayList<Food> foodListOfName = new ArrayList<Food>(); 
		
		for (int i = 0; i < foodList.size(); i++) {
			if (foodList.get(i).name == foodName) {
				foodListOfName.add(foodList.get(i));
			}
		}
		return foodListOfName;
	}
}
