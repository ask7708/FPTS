/**
 * 
 */
package Release1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Arsh
 *
 */
public abstract class Account implements Holdings {
	
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
	 * The account number for this account
	 */
	private int accountNo;
	
	/**
	 * The routing number for this account
	 */
	private int routingNo;
	
	/**
	 * Creates an account object with the name, initial amount, 
	 * and the date it was added.
	 * 
	 * @param accountName
	 * @param amount
	 * @param date
	 */
	public Account(String accountName, double amount, LocalDate date, int accountNum, int routingNum){
		
		this.accountName = accountName;
		this.amount = amount;
		this.setDate(date);
		this.accountNo = accountNum;
		this.routingNo = routingNum;
		
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
	 * gets the routing number of the
	 * specified int
	 */
	public int getRoutingnum(){
		return routingNo;
	}
	/**
	 * sets the routingno for the specified int
	 */
	public void setRoutingnum(int setNumber){
		routingNo =  setNumber;
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
	
	
	   /**
	    * this method takes an account file and update it with a unique routing number. 
	    * @param user - gets the user file 
	    * @throws FileNotFoundException
	    * @throws UnsupportedEncodingException
	    */
	   public void getRoutingNumber(String user) throws FileNotFoundException, UnsupportedEncodingException {
			   
		   //
		   
	    	File data = new File("test.txt");
			Scanner dataRead = null;
			try {
				dataRead = new Scanner(data);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//PrintWriter writer = new PrintWriter(data, "UTF-8");
			//writer.println("hello");
			//String bank  ("!BANK","Test Bank of Testville","12345.67","123456789","987654321","20151013");
			//writer.print("hello!");
			String line;
			String[] temp = null;
			String rNumber = "";
			while (dataRead.hasNextLine())
			{
	      	line = dataRead.nextLine();
	      	line = line.replace("\"", "");
	      	line = line.replace(", ", "");
	      	temp = line.split(",");
	      	//ReadHoldingsContext readAccount = new ReadHoldingsContext(new ReadAccountHolding());
	      	
	      	if(temp[0].equals("!BANK")){
	      				System.out.println("this is good");
	      				if (temp[4].length() != 9){
	      				temp[4] = genretNumber();
	      				System.out.println(Arrays.toString(temp));
	      				
	      				}
	      	}
	      		
	      	}
			PrintWriter writer = new PrintWriter(data, "UTF-8");
			writer.println(Arrays.toString(temp));
			writer.close();
		   
	}  
	/**
	 * validate the routing number.
	 * @param string 
	 * @return true if has 9 numbers. 
	 */
	public boolean validateRNumber(String string) {
		if(string.length() != 9){
			return false;
		}else{
			return true;
		}	
	}
	/**
	 * 
	 * @return string that has a unique number in string data; 
	 */
	public static String genretNumber(){
        long timeSeed = System.nanoTime(); 
        double randSeed = Math.random() * 1000; 
        long midSeed = (long) (timeSeed * randSeed); 
        String s = midSeed + "";
        String rNumber = s.substring(0, 9);
		return rNumber;        
	}

	
	
	/* Testing some methods within account class
	 * ***DO NOT ERASE*
	public static void main(String args[]){
		
		
		LocalDate randomDate = LocalDate.now();
		//System.out.println(randomDate.getMonth()+" "+randomDate.getDayOfMonth()+" "+randomDate.getYear());

		
	}
	**/
	
}
