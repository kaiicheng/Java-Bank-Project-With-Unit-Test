package banking;

/*
 * represents a checking/saving bank account for a customer
 * @author Kai Cheng
 */

public class BankAccount {

	//instance variables
	
	/*
	 * type of account (checking/savings)
	 */
	String accountType;
	
	/*
	 * balance for bank account
	 */
	double balance;
	
	/*
	 * customer for this account 
	 */
	Customer customer;
	
	// 2.3 update
	/*
	 * Fixed amount for quick withdrawals.
	 */
	double fastCashAmount;
	
	//constructor
	
	/*
	 * creates a bank account of given type for given customer
	 * @param accountType for bank account
	 * @param customer for bank account
	 */
	
	public BankAccount(String accountType, Customer customer) {
		this.accountType = accountType;
		this.customer = customer;
		
		// 2.3 update
		// set initial default value for fast cash amount
		this.fastCashAmount = 60;
	}
	
	//method
	
	/*
	 * deposits the given amount, if greater than 0
	 * @param amount to add to balance
	 */
	public void deposit(double amount) {
		if (amount > 0 ) {
			this.balance += amount;
		}
	}
	
	/*
	 * withdraws the given amount from balance
	 * @param amount to withdraw
	 * @throw Exception if given amount is larger than available balance
	 */
	public void withdraw(double amount) throws Exception {
		if (amount > this.balance) {
			throw new Exception("Amount is greater than available balance.");
		}
		this.balance -= amount;
	}
	
	// 2.3 update
	/*
	 * Withdraws the fast cash amount
	 * @throws Exception if given fast cash amount is greater than available balance
	 */
	public void fastWithdraw() throws Exception {
		// withdraw the given fast cash amount
		this.withdraw(this.fastCashAmount);
	}
	
	// 2.3 update
	/*
	 * Sets the fast cash amount, if greater than 0.
	 * @param amount to set as fast cash
	 */
	public void setFastCashAmount(double amount) {
		if (amount > 0) {
			this.fastCashAmount = amount;
		}
	}
	
	/*
	 * returns account type and balance for this bank account
	 * @return string with all the info
	 */
	public String getAccountInfo() {
		return this.accountType + ": " + this.balance;
	}
	
	/*
	 * return the customer name and address for this bank account
	 * @return string with all the info
	 */
	public String getCustomerInfo() {
		return this.customer.getName() + " from " + this.customer.getAddress();
	}
}
