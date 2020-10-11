package tst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import implementation.FoodItem;
import implementation.Order;
import implementation.Shopper;
import implementation.Size;
import implementation.SystemCoordination;

class DeleteOrderTest {
	SystemCoordination systemInstance = SystemCoordination.getInstance();
	
	@Test
	void test() {
		Shopper shopper = new Shopper();
		shopper.shopperSignUp("shopper1", "password");
		shopper.setId(123);
		
		shopper.accountSignIn("shopper1", "password");
		
		FoodItem foodItem = new FoodItem();
		shopper.addToCart(foodItem, Size.LARGE, 3);
		
		ArrayList<Order> orderHistory = new ArrayList<Order>();
		orderHistory = shopper.viewOrderHistory();
		assertEquals(1, orderHistory.size());
		
		shopper.deleteOrder(shopper.order);
		
		assertEquals(0, systemInstance.getShopperOrders(123).size());
	}

}
