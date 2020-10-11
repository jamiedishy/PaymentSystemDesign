package tst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import implementation.FoodItem;
import implementation.Order;
import implementation.PhoneNumber;
import implementation.Shopper;
import implementation.Size;
import implementation.Status;
import implementation.SystemCoordination;

class DeleteOrderTest {
	SystemCoordination systemInstance = SystemCoordination.getInstance();
	
	@Test
	void test() {
		Shopper shopper = new Shopper();
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setAreaCode(416);
		phoneNumber.setFourDigits(1111);
		phoneNumber.setThreeDigits(111);
		shopper.shopperSignUp("shopper1", "password", phoneNumber);
//		shopper.setId(123);
		
		shopper.accountSignIn("shopper1", "password");
		
		FoodItem foodItem = new FoodItem();
		foodItem.price = 10;
		shopper.addToCart(foodItem, Size.LARGE, 3);
		
		ArrayList<Order> orderHistory = new ArrayList<Order>();
		orderHistory = shopper.viewOrderHistory();
		assertEquals(1, orderHistory.size());
		
		shopper.deleteOrder(shopper.currentOrder.getID(), shopper.phoneNumber);
		assertEquals(0, systemInstance.getShopperOrders(shopper.getId()).size());

		shopper.addToCart(foodItem, Size.MEDIUM, 2);
		ArrayList<Order> orderHistory2 = new ArrayList<Order>();
		orderHistory2 = shopper.viewOrderHistory();
		assertEquals(1, orderHistory2.size());

		shopper.payOrder(shopper.currentOrder, 90);
		// order delivers
		systemInstance.updateOrderStatus(shopper.currentOrder, Status.SIGNEDFOR);
		assertEquals(Status.SIGNEDFOR, shopper.currentOrder.getStatus());
		
		// shopper fails to delete order
		assertEquals(false, shopper.deleteOrder(shopper.currentOrder.getID(), shopper.phoneNumber));
		
		
	}

}
