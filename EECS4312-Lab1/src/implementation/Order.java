package implementation;

public class Order {
	int ID;
	private Item[] listOfItems = new Item[10];
	private int itemQuantity = 0;
	private int subTotal = 0;
	Status status = Status.UNPAID;
	Location locationToDelivery;
	PhoneNumber clientPhoneNumber;
	boolean freeDelivery = false;
	
	public int getSubTotal() {
		this.subTotal = 0;
		for(int i = 0; i < this.listOfItems.length; i++) {
		    if(this.listOfItems[i] != null) {
		    	this.subTotal += this.listOfItems[i].price;
		    }
		}
		return this.subTotal;
	}
	public void setSubTotal(int payment) {
		this.subTotal -= payment;
	}

	public void setFreeDelivery() {
		if (itemQuantity > 0) {
			this.freeDelivery = true;
		}
		else {
			this.freeDelivery = false;
		}
	}
	
	public int getItemQuantity() {
		return this.itemQuantity;
	}
	public void setItemQuantity() {
		this.itemQuantity = 0;
		for(int i = 0; i < this.listOfItems.length; i++) {
		    if(this.listOfItems[i] != null) {
		    	this.itemQuantity += this.listOfItems[i].quantity;
		    }
		}
	}
	
	public Status getStatus() {
		return this.status;
	}
	public void setStatus(Status newStatus) {
		this.status = newStatus;
	}
	
	public Item[] getOrderItems() {
		return this.listOfItems;
	}
	public void addItemToOrder(Item item) {
		for(int i = 0; i < this.listOfItems.length; i++) {
		    if(this.listOfItems[i] == null) {
		    	this.listOfItems[i] = item;
		        break;
		    }
		}
	}
}
