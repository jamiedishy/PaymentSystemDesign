package tst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import implementation.FoodItem;
import implementation.Order;
import implementation.Shopper;
import implementation.Size;

class OrderHistoryTest {

	@Test
	void test() {
		Shopper shopper = new Shopper();
		shopper.setId(123);
		
		FoodItem foodItem1 = new FoodItem();
		FoodItem foodItem2 = new FoodItem();
		shopper.addToCart(foodItem1, Size.SMALL, 2);
		shopper.addToCart(foodItem2, Size.SMALL, 7);
		assertEquals(true, shopper.hasOrder);
		
		shopper.shopperSignUp("shopper1", "password");
		shopper.accountSignIn("shopper1", "password");
		assertEquals(true, shopper.signedIn);
		
		ArrayList<Order> orderHistory = new ArrayList<Order>();
		orderHistory.add(shopper.order);
		assertEquals(orderHistory, shopper.viewOrderHistory());
		assertEquals(1, shopper.viewOrderHistory().size());
		assertEquals(9, shopper.viewOrderHistory().get(0).getFoodQuantity());
	}

}


