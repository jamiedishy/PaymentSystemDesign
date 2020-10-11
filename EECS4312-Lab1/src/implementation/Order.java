package implementation;

public class Order {
	private int ID;
	public int associatedToShopperId = 0;
	private FoodItem[] listOfFoods = new FoodItem[10];
	private int FoodQuantity = 0;
	private int subTotal = 0;
	Status status = Status.UNPAID;
	public Location locationToDelivery;
	PhoneNumber clientPhoneNumber;
	boolean freeDelivery = false;
	
	public int getSubTotal() {
		this.subTotal = 0;
		for(int i = 0; i < this.listOfFoods.length; i++) {
		    if(this.listOfFoods[i] != null) {
		    	this.subTotal += this.listOfFoods[i].price * this.listOfFoods[i].quantity;
		    }
		}
		return this.subTotal;
	}
	
	public void setSubTotal() {
		this.subTotal = 0;
		for(int i = 0; i < this.listOfFoods.length; i++) {
		    if(this.listOfFoods[i] != null) {
		    	this.subTotal += this.listOfFoods[i].price;
		    }
		}
	}
	
	public void paySubTotal(int payment, Shopper shopper) {
		this.clientPhoneNumber = shopper.phoneNumber;
		this.subTotal -= payment;
		this.setStatus(Status.PAID);
	}

	public void setFreeDelivery() {
		if (FoodQuantity > 0) {
			this.freeDelivery = true;
		}
		else {
			this.freeDelivery = false;
		}
	}
	
	public int getFoodQuantity() {
		this.FoodQuantity = 0;
		for(int i = 0; i < this.listOfFoods.length; i++) {
		    if(this.listOfFoods[i] != null) {
		    	this.FoodQuantity += this.listOfFoods[i].quantity;
		    }
		}
		return this.FoodQuantity;
	}
	
	public Status getStatus() {
		return this.status;
	}
	public void setStatus(Status newStatus) {
		this.status = newStatus;
	}
	
	public Food[] getOrderFoods() {
		return this.listOfFoods;
	}
	public void addFoodToOrder(FoodItem foodItem) {
		for(int i = 0; i < this.listOfFoods.length; i++) {
		    if(this.listOfFoods[i] == null) {
		    	this.listOfFoods[i] = foodItem;
		        break;
		    }
		}
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
