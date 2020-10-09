package implementation;

import java.util.ArrayList;

public class Shopper extends Account {
	Location location;
	Order order;
	boolean hasOrder = false;
	
	
	public void setItemSize(Item item, Size size) {
		item.size = size;
	}
	
	public void setItemQuantity(Item item, int quantity) {
		item.quantity = quantity;
	}
	
	public void addToCart(Item item) {
		if (this.order.associatedToShopperId == 0) { // create an order if no order associated with Shopper
			Order order = systemInstance.createOrder();
			order.addItemToOrder(item);
			order.setSubTotal();
			order.freeDelivery = true;
			item.order = order;
			this.order.associatedToShopperId = this.getId();
			hasOrder = true;
			systemInstance.sendNotification("Added item to cart.");
		}
		else if (this.order.getItemQuantity() < 10) {
			this.order.addItemToOrder(item);
			this.order.setSubTotal();
			item.order = this.order;
			systemInstance.sendNotification("Added item to cart with " + this.order.getItemQuantity() + " items.");
		}
		else {
			systemInstance.sendNotification("Cannot add to cart. Maximum items in order.");
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
	
	public ArrayList<Order> viewMyOrders() {
		if (this.signedIn) {
			return systemInstance.getShopperOrders(this.getId());
		}
		else {
			ArrayList<Order> empty = new ArrayList<Order>();
			return empty;
		}
	}
	
	public Notification shopperSignUp(String username, String password) { 
		systemInstance.shopperSignUp(username, password);
		return systemInstance.sendNotification("You've signed up!");
	}
}
