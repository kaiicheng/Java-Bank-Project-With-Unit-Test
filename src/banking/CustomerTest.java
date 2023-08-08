package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	// declare customer for testing
	Customer customer;
	
	@BeforeEach
	void setUp() throws Exception {
		// initialize customer here
		this.customer = new Customer("Alice");
	}

	@Test
	void testSetAddress() {
//		fail("Not yet implemented"); // TODO
		
		// confirm the initial value of address is null
		assertNull(this.customer.getAddress());
		
		// sets address for customer
		this.customer.setAddress("Brooklyn, NY");
		
		// checks that address was set correctly
		assertEquals("Brooklyn, NY", this.customer.getAddress());
		
		// resets address for customer
		this.customer.setAddress("Cambridge, MA");
		
		// checks that address was set correctly
		assertEquals("Cambridge, MA", this.customer.getAddress());
	}
}
