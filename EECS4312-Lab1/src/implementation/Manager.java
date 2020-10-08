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
	
	public void addItem(String name, int price, String ingredients, String allergens, String nutrition, Category category) {
		Item foodItem = new Item();
		foodItem.name = name;
		foodItem.price = price;
		foodItem.ingredients = ingredients;
		foodItem.allergens = allergens;
		foodItem.nutrition = nutrition;
		foodItem.category = category;
		systemInstance.addItem(foodItem);
	}
	
	public void deleteItem(Item item) {
		systemInstance.deleteItem(item);
	}

	
	public void updateItemPrice(Item item, int price) {
		item.price = price;
		systemInstance.sendNotification("Updated item price!");
	}
	
	public void updateItemIngredients(Item item, String ingredients) {
		item.ingredients = ingredients;
		systemInstance.sendNotification("Updated item ingredients!");
	}
	
	public void updateItemAllergens(Item item, String allergens) {
		item.allergens = allergens;
		systemInstance.sendNotification("Updated item allergens!");
	}
	
	public void updateItemNutrition(Item item, String nutrition) {
		item.nutrition = nutrition;
		systemInstance.sendNotification("Updated item nutrition!");
	}
	
	public void updateItemName(Item item, String name) {
		item.name = name;
		systemInstance.sendNotification("Updated item name!");
	}
	
	public void updateItemSize(Item item, Size size) {
		item.size = size;
		systemInstance.sendNotification("Updated item size!");
	}
	
	public void updateItemCategory(Item item, Category category) {
		item.category = category;
		systemInstance.sendNotification("Updated item category!");
	}
	
	public void updateItemDimensions(Item item, int dimensions) {
		item.dimensions = dimensions;
		systemInstance.sendNotification("Updated item dimensions!");
	}
	
	
}
