package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import implementation.Manager;
import implementation.PhoneNumber;
import implementation.Shopper;
import implementation.SystemCoordination;

class UniqueIDTest {

	@Test
	void test() {
		SystemCoordination systemInstance = SystemCoordination.getInstance();
		// system creates manager as specified in requirements 
		Manager manager1 = systemInstance.createManagerObject("manager1", "password");
		assertEquals(0, manager1.getId());
		Manager manager2 = systemInstance.createManagerObject("manager1", "password");
		assertEquals(1, manager2.getId());
		Shopper shopper = new Shopper();
		PhoneNumber pN = new PhoneNumber();
		shopper.shopperSignUp("shopper1", "password", pN);
		assertEquals(2, shopper.getId());
		Shopper shopper2 = new Shopper();
		shopper2.shopperSignUp("shopper2", "password", pN);
		assertEquals(3, shopper2.getId());
	}

}
