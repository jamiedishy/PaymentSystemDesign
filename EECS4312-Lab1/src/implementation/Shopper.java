package implementation;

import java.util.ArrayList;

public class Shopper extends Account {
	Location location;
	Order order;
	boolean hasOrder = false;
	
	
	public void setFoodSize(Food Food, Size size) {
		Food.size = size;
	}
	
	public void setFoodQuantity(Food Food, int quantity) {
		Food.quantity = quantity;
	}
	
	public void addToCart(FoodItem foodItem, Size size, int quantity) {
		if (this.order.associatedToShopperId == 0) { // create an order if no order associated with Shopper
			Order order = systemInstance.createOrder();
			order.addFoodToOrder(foodItem);
			order.setSubTotal();
			order.freeDelivery = true;
			foodItem.order = order;
			foodItem.size = size;
			foodItem.quantity = quantity;
			this.order.associatedToShopperId = this.getId();
			hasOrder = true;
			systemInstance.sendNotification("Added food item to cart.");
		}
		else if (this.order.getFoodQuantity() < 10) {
			this.order.addFoodToOrder(foodItem);
			this.order.setSubTotal();
			foodItem.order = this.order;
			foodItem.size = size;
			foodItem.quantity = quantity;
			systemInstance.sendNotification("Added food item to cart with " + this.order.getFoodQuantity() + " Foods.");
		}
		else {
			systemInstance.sendNotification("Cannot add to cart. Maximum food items in order.");
		}
	}
	
	public void payOrder(Order order, int payment) { // assuming full amount is paid
		order.paySubTotal(payment); // assume order.subTotal = 0 now
		order.setStatus(Status.PAID);
		systemInstance.sendNotification("Payment complete");
	}
	
	public void setDeliveryLocation(Order order, String postalCode, String city, String country, int addressNumber) {
		location.setPoscalCode(postalCode);
		location.setAddressNumber(addressNumber);
		location.setCountry(country);
		location.setCity(city);
		order.locationToDelivery = location;
	}
	
	
	public void deleteOrder(Order order) {
		if (order.status != Status.SIGNEDFOR) { // order hasn't delivered yet
			systemInstance.deleteOrder(order.ID);
			order.associatedToShopperId = 0;
		} 
		else {
			systemInstance.sendNotification("Cannot delete order. Order already delivered.");
		}
	}
	
//	public ArrayList<Order> viewMyOrders() {
//		if (this.signedIn) {
//			return systemInstance.getShopperOrders(this.getId());
//		}
//		else {
//			ArrayList<Order> empty = new ArrayList<Order>();
//			return empty;
//		}
//	}
	
	public Notification shopperSignUp(String username, String password) { 
		systemInstance.shopperSignUp(username, password);
		return systemInstance.sendNotification("You've signed up!");
	}
}
