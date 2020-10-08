package implementation;

public class Shopper extends Account {
	Location location;
	Order order;
	
	
	public void setItemSize(Item item, Size size) {
		item.size = size;
	}
	
	public void setItemQuantity(Item item, int quantity) {
		item.quantity = quantity;
	}
	
	public void addToCart(Item item) {
		if (this.order == null) { // create an order if no order associated with Shopper
			Order order = systemInstance.createOrder();
			order.addItemToOrder(item);
			order.setSubTotal();
			order.freeDelivery = true;
			item.order = order;
			this.order = order;
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
	
}
