package implementation;

public abstract class Food {
	public int ID;
	public int price;
	public String ingredients, allergens, nutrition, name;
	public Size size = Size.MEDIUM;
	public Category category;
	public int dimensions;
	public int quantity = 1;
	public Order order;
	
	
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
