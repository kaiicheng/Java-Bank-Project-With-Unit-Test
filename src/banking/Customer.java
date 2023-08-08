package banking;

/*
 * represents a customer of a bank
 * @author Kai Cheng
 */

public class Customer {
	
	// instance variables
	
	/*
	 * name of customer
	 */
	String name;
	
	/*
	 * address of customer
	 */
	String address;
	
	//constructor
	
	/*
	 * creates a customer with the given name
	 * @param name of customer
	 */
	public Customer(String name) {
		//sets instance var name to given name
		this.name = name;
	}
	
	//methods
	
	/*
	 * sets the address of customer to be given address
	 * @param address for customer
	 */
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	/*
	 * returns customer's name
	 * @return name of customer
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * returns customer's address
	 * @return address of customer
	 */
	public String getAddress() {
		return this.address;
	}
}


