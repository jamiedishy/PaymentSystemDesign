package implementation;

public class Manager extends Account {
	
	public Status getOrderStatus(Order order) {
		return order.status;
	}
	
	public Food[] getOrderFoods(Order order) {
		return order.getOrderFoods();
	}
	
	public int getOrderSubtotal(Order order) {
		return order.getSubTotal();
	}
	
	public Food addFood(String name, int price, String ingredients, String allergens, String nutrition, Category category) {
		FoodItem foodItem = new FoodItem();
		foodItem.name = name;
		foodItem.price = price;
		foodItem.ingredients = ingredients;
		foodItem.allergens = allergens;
		foodItem.nutrition = nutrition;
		foodItem.category = category;
		systemInstance.addFood(foodItem);
		return foodItem;
	}
	
	public void deleteFood(FoodItem foodItem) {
		systemInstance.deleteFood(foodItem);
	}

	
	public void updateFoodPrice(FoodItem foodItem, int price) {
		foodItem.price = price;
		systemInstance.sendNotification("Updated Food price!");
	}
	
	public void updateFoodIngredients(FoodItem foodItem, String ingredients) {
		foodItem.ingredients = ingredients;
		systemInstance.sendNotification("Updated Food ingredients!");
	}
	
	public void updateFoodAllergens(FoodItem foodItem, String allergens) {
		foodItem.allergens = allergens;
		systemInstance.sendNotification("Updated Food allergens!");
	}
	
	public void updateFoodNutrition(FoodItem foodItem, String nutrition) {
		foodItem.nutrition = nutrition;
		systemInstance.sendNotification("Updated Food nutrition!");
	}
	
	public void updateFoodName(FoodItem foodItem, String name) {
		foodItem.name = name;
		systemInstance.sendNotification("Updated Food name!");
	}
	
	public void updateFoodSize(FoodItem foodItem, Size size) {
		foodItem.size = size;
		systemInstance.sendNotification("Updated Food size!");
	}
	
	public void updateFoodCategory(FoodItem foodItem, Category category) {
		foodItem.category = category;
		systemInstance.sendNotification("Updated Food category!");
	}
	
	public void updateFoodDimensions(FoodItem foodItem, int dimensions) {
		foodItem.dimensions = dimensions;
		systemInstance.sendNotification("Updated Food dimensions!");
	}
	
	
}
