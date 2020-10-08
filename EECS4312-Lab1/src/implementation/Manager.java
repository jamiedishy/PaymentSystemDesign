package implementation;

public class Manager extends Account {
	
	public Status getOrderStatus(Order order) {
		return order.status;
	}
	
	public Item[] getOrderItems(Order order) {
		return order.getOrderItems();
	}
	
	public int getOrderSubtotal(Order order) {
		return order.getSubTotal();
	}
	
	public Wrap addWrapItem() {
		Wrap wrap = new Wrap();
		// send notification to singleton system
		return wrap;
	}
	
	public Salad addSaladItem() {
		Salad salad = new Salad();
		// send notification to singleton system
		return salad;
	}
	
	public void setItemPrice(Item item, int price) {
		item.price = price;
		// send notification to singleton system
	}
	
	public void setItemIngredients(Item item, String ingredients) {
		item.ingredients = ingredients;
		// send notification to singleton system
	}
	
	public void setItemAllergens(Item item, String allergens) {
		item.allergens = allergens;
		// send notification to singleton system
	}
	
	public void setItemNutrition(Item item, String nutrition) {
		item.nutrition = nutrition;
		// send notification to singleton system
	}
	
	public void setItemName(Item item, String name) {
		item.name = name;
		// send notification to singleton system
	}
	
	public void setItemSize(Item item, Size size) {
		item.size = size;
		// send notification to singleton system
	}
	
	public void setItemCategory(Item item, Category category) {
		item.category = category;
		// send notification to singleton system
	}
	
	public void setItemDimensions(Item item, int dimensions) {
		item.dimensions = dimensions;
		// send notification to singleton system
	}
	
//  I didnt create Food --> FoodItem. I just created Item, assuming there're unlimited amounts of food items	
//	public void setItemQuantity(Item item, int quantity) {
//		item.quantity = quantity;
//	}
	
	
}
