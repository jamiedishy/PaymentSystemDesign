package implementation;

public class Shopper extends Account {
	Location location;
	
	
	public void setItemSize(Item item, Size size) {
		item.size = size;
	}
	
//	public void addToCart(Item item) {
//		
//	}
	
	public void payOrder(Order order, int payment) { // assuming full amount is paid
		order.setSubTotal(payment); // order.subTotal = 0 now
		// send notification to singleton system
	}
	
	public void setDeliveryLocation(String postalCode, String city, String country, int addressNumber) {
		this.location.setPoscalCode(postalCode);
		this.location.setAddressNumber(addressNumber);
		this.location.setCountry(country);
		this.location.setCity(city);
	}
	
}
