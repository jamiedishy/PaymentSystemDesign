package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import implementation.FoodItem;
import implementation.PhoneNumber;
import implementation.Shopper;
import implementation.Size;
import implementation.Status;
import implementation.SystemCoordination;

class ProceedToCheckoutTest {
	@Test
	void test() {
		Shopper shopper = new Shopper();
		PhoneNumber phoneNumber = new PhoneNumber();
		shopper.shopperSignUp("shopper1", "password", phoneNumber);
		shopper.accountSignIn("shopper1", "password");
		assertEquals(true, shopper.signedIn);
		shopper.setId(123);
		
		FoodItem foodItem1 = new FoodItem();
		FoodItem foodItem2 = new FoodItem();
		shopper.addToCart(foodItem1, Size.SMALL, 2);
		shopper.addToCart(foodItem2, Size.SMALL, 7);
		assertEquals(true, shopper.hasOrder);
		
		// shopper clicks proceed to checkout
		shopper.setDeliveryLocation(shopper.currentOrder, "postalcode", "city", "canada", 55);
		assertEquals("postalcode", shopper.currentOrder.locationToDelivery.getPoscalCode());
		// shopper submits payment to third party
		shopper.confirmOrder();
		assertEquals(Status.PAID, shopper.currentOrder.getStatus());
	}

}
