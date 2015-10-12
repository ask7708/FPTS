/**
 * 
 */
package Release1;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author Arsh
 *
 */
public abstract class Account {
	
	/**
	 * The name of an account
	 */
	private String accountName;
	
	/**
	 * The amount in the type of account
	 */
	private double amount;
	
	/**
	 * The date the type of account was added
	 */
	private LocalDate date;
	
	/**
	 * Creates an account object with the name, initial amount, 
	 * and the date it was added.
	 * 
	 * @param accountName
	 * @param amount
	 * @param date
	 */
	public Account(String accountName, int amount, LocalDate date){
		
		this.accountName = accountName;
		this.amount = amount;
		this.setDate(date);
		
	}

	/**
	 * Returns the account name of the 
	 * specified account
	 * 
	 * @return accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Set the name of an account
	 * 
	 * @param accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * Returns the amount in the type of account
	 * 
	 * @return amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount for the account
	 * 
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Returns the date the account was added 
	 * 
	 * @return date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Set the date the account was added
	 * 
	 * @param date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	/* Testing some methods within account class
	 * ***DO NOT ERASE***
	public static void main(String args[]){
		
		
		LocalDate randomDate = LocalDate.now();
		System.out.println(randomDate.getMonth()+" "+randomDate.getDayOfMonth()+" "+randomDate.getYear());
		
		
	}
	*/
}
