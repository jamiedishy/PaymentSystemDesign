package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import implementation.FoodItem;
import implementation.PhoneNumber;
import implementation.Shopper;
import implementation.Size;
import implementation.Status;
import implementation.SystemCoordination;

class UpdateOrderStatusTest {

	@Test
	void test() {
		SystemCoordination systemInstance = SystemCoordination.getInstance();
		
		Shopper shopper = new Shopper();
		PhoneNumber pN = new PhoneNumber();
		shopper.shopperSignUp("shopper1", "password", pN);
		shopper.accountSignIn("shopper1", "password");
		assertEquals(true, shopper.signedIn);
		shopper.setId(123);
		
		FoodItem foodItem1 = new FoodItem();
		FoodItem foodItem2 = new FoodItem();
		shopper.addToCart(foodItem1, Size.SMALL, 2);
		shopper.addToCart(foodItem2, Size.SMALL, 7);
		assertEquals(true, shopper.hasOrder);
		
		// shopper pays to external payment system
		// system receives prompt from external payment system
		
		systemInstance.updateOrderStatus(shopper.currentOrder, Status.PAID);
		assertEquals(Status.PAID, shopper.currentOrder.getStatus());
		
		// order is shipping
		// system receives prompt from shipping
		
		systemInstance.updateOrderStatus(shopper.currentOrder, Status.DELIVERING);
		assertEquals(Status.DELIVERING, shopper.currentOrder.getStatus());
		
		// order delivered and signed
		// system receives prompt
				
		systemInstance.updateOrderStatus(shopper.currentOrder, Status.PAID);
		assertEquals(Status.PAID, shopper.currentOrder.getStatus());
				
	}

}
