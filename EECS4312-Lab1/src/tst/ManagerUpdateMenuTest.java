package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import implementation.Category;
import implementation.Food;
import implementation.FoodItem;
import implementation.Manager;
import implementation.Order;
import implementation.Size;
import implementation.SystemCoordination;

class ManagerUpdateMenuTest {

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
		
		FoodItem foodItem = (FoodItem) manager.addFood("Pizza", 5, "ingredients", "allergens", "nutrition", Category.LUNCH);
		foodItem.ID = 123;
		foodItem.price = 5;
		foodItem.name = "Pizza";
		
		manager.updateFoodPrice(foodItem, 10);
		manager.updateFoodName(foodItem, "Pasta");
		
		assertEquals(10, foodItem.price);
		assertEquals("Pasta", foodItem.name);

	}


}
