package tst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import implementation.Category;
import implementation.Food;
import implementation.FoodItem;
import implementation.Manager;
import implementation.PhoneNumber;
import implementation.Shopper;
import implementation.Size;
import implementation.Status;
import implementation.SystemCoordination;

class ManagerCreateItemShopperSubmitOrderTest {

	@Test
	void test() {
		SystemCoordination systemInstance = SystemCoordination.getInstance();
		// system creates manager as specified in requirements 
		Manager manager = systemInstance.createManagerObject("manager1", "password");
		assertEquals("M", systemInstance.getAccountList().get(0).shopperOrManager);
		assertEquals("password", systemInstance.getAccountList().get(0).getPassword());
		assertEquals("manager1", systemInstance.getAccountList().get(0).getUsername());
		
		manager.accountSignIn("manager1", "password");
		assertEquals(true, manager.signedIn);
		
		manager.signOut(); // can't add food when signed out
		
		manager.addFood("pizza", 5, "cheese", "dairy", "not too healthy", Category.LUNCH);
		manager.addFood("sandwich", 10, "bread", "carbs", "healthier", Category.LUNCH);
		manager.addFood("pancakes", 8, "sugary", "dairy", "unhealthy", Category.BREAKFAST);
		manager.addFood("milkshake", 10, "milk", "dairy", "unhealthy", Category.BEVERAGES);
		
		for (int i = 0; i < systemInstance.getFoodList().size(); i++) {
			System.out.println("name and id " + systemInstance.getFoodList().get(i).name + " " + systemInstance.getFoodList().get(i).ID);
		}
		assertEquals(0, systemInstance.getFoodList().size());
		
		manager.accountSignIn("manager1", "password"); // may add food when signed in
		assertEquals(true, manager.signedIn);
		
		manager.addFood("pizza", 5, "cheese", "dairy", "not too healthy", Category.LUNCH);
		manager.addFood("sandwich", 10, "bread", "carbs", "healthier", Category.LUNCH);
		manager.addFood("pancakes", 8, "sugary", "dairy", "unhealthy", Category.BREAKFAST);
		manager.addFood("milkshake", 10, "milk", "dairy", "unhealthy", Category.BEVERAGES);
		
//		for (int i = 0; i < systemInstance.getFoodList().size(); i++) {
//			System.out.println("name and id " + systemInstance.getFoodList().get(i).name + " " + systemInstance.getFoodList().get(i).ID);
//		}
		assertEquals(4, systemInstance.getFoodList().size());
		
		Shopper shopper = new Shopper();
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setAreaCode(416);
		phoneNumber.setFourDigits(1111);
		phoneNumber.setThreeDigits(111);
		shopper.shopperSignUp("shopper1", "password", phoneNumber);
		
		shopper.accountSignIn("shopper1", "password");
		
		ArrayList<Food> searchResults = shopper.searchFoodByName("pancakes");
		assertEquals(1, searchResults.size());
		FoodItem food = (FoodItem) searchResults.get(0);
		
		shopper.setFoodQuantity(food, 11);
		assertEquals(11, food.quantity);
		
		shopper.addToCart(food, Size.SMALL, food.quantity);
		assertEquals(false, shopper.hasOrder);
		
		shopper.setFoodQuantity(food, 4);
		shopper.addToCart(food, Size.SMALL, food.quantity);
		assertEquals(true, shopper.hasOrder);
		
		assertEquals(32, shopper.currentOrder.getSubTotal()); // 4 pancakes * $8 each
		shopper.payOrder(shopper.currentOrder, shopper.currentOrder.getSubTotal()); 
		
		assertEquals(Status.PAID, shopper.currentOrder.getStatus());
		
	}

}
