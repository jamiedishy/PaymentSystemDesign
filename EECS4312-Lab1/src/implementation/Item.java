package implementation;

public abstract class Item {
	int ID;
	int price;
	String ingredients, allergens, nutrition, name;
	Size size = Size.MEDIUM;
	Category category;
	int dimensions;
	int quantity = 1;
}
