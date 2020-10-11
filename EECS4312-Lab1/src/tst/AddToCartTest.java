package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import implementation.FoodItem;
import implementation.Shopper;
import implementation.Size;

class AddToCartTest {

	@Test
	void test() {
		Shopper shopper = new Shopper();
		shopper.setId(123);
		FoodItem foodItem = new FoodItem();
		shopper.addToCart(foodItem, Size.LARGE, 3);
		assertEquals(true, shopper.hasOrder);
		assertEquals(123, shopper.currentOrder.associatedToShopperId);
	}

}