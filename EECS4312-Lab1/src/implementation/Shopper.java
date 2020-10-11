package implementation;

import java.util.ArrayList;

public class Shopper extends Account {
	public Order currentOrder;
	public boolean hasOrder = false;
	public PhoneNumber phoneNumber;
//	public static void main(String[] args) {
//      //Instance 1
//		SystemCoordination instance1 = SystemCoordination.getInstance();
//
//      //Instance 2
//		SystemCoordination instance2 = SystemCoordination.getInstance();
//
//      //now lets check the hash key.
//      System.out.println("Instance 1 hash:" + instance1.hashCode());
//      System.out.println("Instance 2 hash:" + instance2.hashCode());  
// }
	
	public void setFoodSize(FoodItem food, Size size) {
		food.size = size;
	}
	
	public void setFoodQuantity(FoodItem food, int quantity) {
		food.quantity = quantity;
	}
	
	// don't have to be signed in to add to cart
	public void addToCart(FoodItem foodItem, Size size, int quantity) {
		if (!hasOrder && foodItem.quantity < 10) { // create an order if no order associated with Shopper
			Order order = systemInstance.createOrder();
//			order.clientPhoneNumber = phoneNumber;
			order.addFoodToOrder(foodItem);
			order.setSubTotal();
			if (order.getFoodQuantity() > 1 && order.getFoodQuantity() < 10) {
				order.freeDelivery = true;
			}
			foodItem.order = order;
			foodItem.size = size;
			foodItem.quantity = quantity;
			order.associatedToShopperId = this.getId();
			hasOrder = true;
			if (this.signedIn) {
				order.clientPhoneNumber = this.phoneNumber;
			}
			this.currentOrder = order;
			systemInstance.sendNotification("Added food item to cart.");
		}
		else if (hasOrder && this.currentOrder.getFoodQuantity() < 10) {
			this.currentOrder.addFoodToOrder(foodItem);
			this.currentOrder.setSubTotal();
			foodItem.order = this.currentOrder;
			foodItem.size = size;
			foodItem.quantity = quantity;
			if (this.signedIn) {
				this.currentOrder.clientPhoneNumber = this.phoneNumber;
			}
			systemInstance.sendNotification("Added food item to cart with " + this.currentOrder.getFoodQuantity() + " Foods.");
		}
		else {
			systemInstance.sendNotification("Cannot add to cart. Maximum food items in order.");
		}
	}
	
	public void payOrder(Order order, int payment) { // assuming full amount is paid
		if (this.signedIn) {
			order.paySubTotal(payment, this); // assume order.subTotal = 0 now
			systemInstance.sendNotification("Payment complete");
		}
		else {
			systemInstance.sendNotification("Must sign in to pay.");
		}
	}
	
	public void setDeliveryLocation(Order order, String postalCode, String city, String country, int addressNumber) {
		Location location = new Location();
		location.setPostalCode(postalCode);
		location.setAddressNumber(addressNumber);
		location.setCountry(country);
		location.setCity(city);
		order.locationToDelivery = location;
	}
	
	public Status checkOrderStatus(int orderNumber, PhoneNumber phoneNumber, Shopper shopper) {
		if (shopper.signedIn) {
			ArrayList<Order> orderHistory = this.viewOrderHistory();
			for (int i = 0; i < orderHistory.size(); i++) {
				if (orderHistory.get(i).getID() == orderNumber && orderHistory.get(i).clientPhoneNumber == phoneNumber) {
					return orderHistory.get(i).status;
				}
			}
			return Status.UNKNOWN;
		}
		return Status.UNKNOWN;
	}
	
	public Order getOrderGivenOrderNumber(int orderNumber) {
	
		for (int i = 0; i < this.viewOrderHistory().size(); i++) {
			if (this.viewOrderHistory().get(i).getID() == orderNumber) {
				return this.viewOrderHistory().get(i);
			}
		}
		return null;
	}
	
	
	public boolean deleteOrder(int orderNumber, PhoneNumber phoneNumber) {
		Order order = this.getOrderGivenOrderNumber(orderNumber);
		if (orderNumber == this.currentOrder.getID()) {
			this.currentOrder = order; // reinitialized
			this.hasOrder = false;
		}
		
		if (this.signedIn == true && order.status != Status.SIGNEDFOR) { // signed in and order hasn't delivered yet
			systemInstance.deleteOrder(order.getID());
			order.associatedToShopperId = 0;
			return true;
		} 
		else {
			systemInstance.sendNotification("Cannot delete order. Order already delivered.");
			return false;
		}
	}
	
	public ArrayList<Order> viewOrderHistory() {
		if (this.signedIn) {
			return systemInstance.getShopperOrders(this.getId());
		}
		else {
			ArrayList<Order> empty = new ArrayList<Order>();
			return empty;
		}
	}
	
	public Notification shopperSignUp(String username, String password, PhoneNumber phoneNumber) { 
		systemInstance.shopperSignUp(this, username, password, phoneNumber);
		return systemInstance.sendNotification("You've signed up!");
	}
	
	public void confirmOrder() {
		systemInstance.updateOrderStatus(this.currentOrder, Status.PAID);
	}
	
	public void signOut() {
		Order order = new Order();
		this.currentOrder = order; // reinitialize current order
		this.signedIn = false;
		this.hasOrder = false;
	}
}
