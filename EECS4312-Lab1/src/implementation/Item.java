package implementation;

public class Item {
	int ID;
	int price;
	String ingredients, allergens, nutrition, name;
	Size size = Size.MEDIUM;
	Category category;
	int dimensions;
	int quantity = 1;
	Order order;
	
	
//	public static void main(String[] args) {
//        //Instance 1
//		SystemCoordination instance1 = SystemCoordination.getInstance();
//
//        //Instance 2
//		SystemCoordination instance2 = SystemCoordination.getInstance();
//
//        //now lets check the hash key.
//        System.out.println("Instance 1 hash:" + instance1.hashCode());
//        System.out.println("Instance 2 hash:" + instance2.hashCode());  
//   }
}
