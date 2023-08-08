package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

	// declare objects for testin
	Customer customer;
	BankAccount myCheckingAccount;
	BankAccount mySavingsAccount;
	
	@BeforeEach
	void setUp() throws Exception {
		
		// initialize objects here for testing
		this.customer = new Customer("Alice");
		this.myCheckingAccount = new BankAccount("checking", this.customer);
		this.mySavingsAccount = new BankAccount("savings", this.customer);
	}

	@Test
	void testDeposit() {
//		fail("Not yet implemented"); // TODO
		
		// make deposit
		this.myCheckingAccount.deposit(100);
		
		// test that current balance is 100
		assertEquals(100, this.myCheckingAccount.balance);
		
		// make deposit of negative amount
		this.myCheckingAccount.deposit(-100);
		
		// balance should be the same
		assertEquals(100, this.myCheckingAccount.balance);
		
		// deposit 0
		this.myCheckingAccount.deposit(0);
		
		// balance should be the same
		assertEquals(100, this.myCheckingAccount.balance);
	}

	@Test
	void testWithdraw() {
//		fail("Not yet implemented"); // TODO
		
		// deposit initial 100 into savings
		this.mySavingsAccount.deposit(100);
		
		// assert current balance
		assertEquals(100, this.mySavingsAccount.balance);
		
		// try to make withdraw of 80
		try {
			this.mySavingsAccount.withdraw(80);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// balance should be 20
		assertEquals(20, this.mySavingsAccount.balance);
		
		// try to withdraw amount greater than available balance
		// expect an exception
		assertThrows(Exception.class, () -> {
			this.mySavingsAccount.withdraw(21);
		});
		
		// balance should be same
		assertEquals(20, this.mySavingsAccount.balance);
	
		// try to make withdrawal
		// does not throw exception
		assertDoesNotThrow(() -> {
			this.mySavingsAccount.withdraw(19);
		});
		
		// balance should be 20
		assertEquals(1, this.mySavingsAccount.balance);
	}

	@Test
	void testFastWithdraw() {
//		fail("Not yet implemented"); // TODO

		// initial deposit
		this.myCheckingAccount.deposit(100);
		
		// try to make fast withdrawal
		// default amount is 60
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// balance should be 40
		assertEquals(40, this.myCheckingAccount.balance);
		
		// reset the fast cash amount to 20
		this.myCheckingAccount.setFastCashAmount(20);
		
		// assert that an exception is not thrown when I make fast cash withdrawal
		assertDoesNotThrow(() -> {
			this.myCheckingAccount.fastWithdraw();
		});
		
		// check balance
		assertEquals(20, this.myCheckingAccount.balance);
		
		
		
		// set fast cash amount to negative value
		// should be ignored
		this.myCheckingAccount.setFastCashAmount(-50);
		
		// should still withdraw 20
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// balance should be 0 after fast withdrawal
		assertEquals(0, this.myCheckingAccount.balance);
		
		// expecting exception with I try to make fast withdrawal because of 0 balance
		assertThrows(Exception.class, () -> {
			this.myCheckingAccount.fastWithdraw();
		});
	}
}
