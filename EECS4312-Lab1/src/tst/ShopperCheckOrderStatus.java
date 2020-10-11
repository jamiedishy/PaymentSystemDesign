package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import implementation.FoodItem;
import implementation.PhoneNumber;
import implementation.Shopper;
import implementation.Size;
import implementation.Status;

class ShopperCheckOrderStatus {

	@Test
	void test() {
		Shopper shopper = new Shopper();
		PhoneNumber phoneNumber = new PhoneNumber();
		shopper.shopperSignUp("shopper1", "password", phoneNumber);
		shopper.accountSignIn("shopper1", "password");
		assertEquals(true, shopper.signedIn);
		assertEquals(phoneNumber, shopper.phoneNumber);
		shopper.setId(123);
		
		FoodItem foodItem1 = new FoodItem();
		FoodItem foodItem2 = new FoodItem();
		shopper.addToCart(foodItem1, Size.SMALL, 2);
		shopper.addToCart(foodItem2, Size.SMALL, 7);
		assertEquals(true, shopper.hasOrder);
		
		// shopper signed in and checking order
		assertEquals(Status.UNPAID, shopper.checkOrderStatus(shopper.currentOrder.getID(), shopper.phoneNumber, shopper));
		
		shopper.signOut();
		FoodItem foodItem3 = new FoodItem();
		shopper.addToCart(foodItem3, Size.SMALL, 2);
		assertEquals(true, shopper.hasOrder);
		
		// shopper not signed in and checking order
		assertEquals(Status.UNKNOWN, shopper.checkOrderStatus(shopper.currentOrder.getID(), shopper.phoneNumber, shopper));
		
		
	}

}
