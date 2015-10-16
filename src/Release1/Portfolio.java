package Release1;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * 
 * @author itnks
 *
 */

public class Portfolio extends Observable {

   private User user;
   
   private ArrayList<Holdings> userHoldings;
   private ArrayList<Equity> ownedEquities;
   private ArrayList<Account> accounts;
   private ArrayList<Transaction> transactions;
   
   public Portfolio(User user) {
   
      this.user = user;
      this.ownedEquities = new ArrayList<Equity>();
      this.accounts = new ArrayList<Account>();
      this.transactions = new ArrayList<Transaction>();
      this.userHoldings = new ArrayList<Holdings>();
      
      /**
       * If the file exists read in holdings and account if not do nothing 
       * 
       * 
       * 
       */
   }
   
   public String getUsername() { return user.getUsername(); }
   
   public String getUserFName() { return user.getFirstName(); }
   
   public String getUserLName() { return user.getLastName(); } 
   
//   /**
//    * Returns a deep copy of the holding the portfolio has 
//    * (I went with a copy so that holdings of the portfolio aren't affected when
//    * simulations are being done)
//    * @return a copy of the portfolio's holdings
//    */
//   public ArrayList<Equity> getHoldings() { 
//      
//      ArrayList<Equity> copy = new ArrayList<Equity>(holdings); 
//      
//      for(Equity obj: copy) {
//         obj.putSimulationOn();
//      }
//      
//      return copy;
//   }
   
   public ArrayList<Equity> getHoldingsNew() { return this.ownedEquities; }
      
   /**
    * Returns a deep copy of the accounts the portfolio has
    * @return a copy of the portfolio's accounts
    */
   public ArrayList<Account> getAccounts() { return new ArrayList<Account>(accounts); }
   
   public void addAccounts(Account newAccount) { accounts.add(newAccount); }
   
   
   
   public void addEquity(Equity holding) { ownedEquities.add(holding); }
   
   public void importEquity(File file){
	   
	   Scanner dataRead = null;
		try {
			dataRead = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line;
		StringBuffer sb = new StringBuffer();
		PrintWriter out;
		
		while (dataRead.hasNextLine())
		{
     	line = dataRead.nextLine();
     	//System.out.println(line);
     	if(line.startsWith("\"!OWNED\"")){
     		//sb.append(line+"\n");
     		
    		File writeFile = new File(getUsername()+".txt");
    		writeFile.setWritable(true);
    		try {
				out = new PrintWriter(new BufferedWriter(new FileWriter(getUsername()+".txt", true)));
				out.println(line);
				out.close();
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
     	}
     	
     		
     	}
		
		dataRead.close();
     	
 		
		   
		
	   
   }
 
   
	/**
	 * textName - the name of the file that will be used as the database
	 * 
	 * The constructor takes all the lines from the text file and
	 * then converts them into a respective format and add them into an array
	 * @return 
	 */
	public void importEquity(String textName, ArrayList<Holdings> holdingsArray) throws FileNotFoundException{

		//
		File data = new File(textName);
		Scanner dataRead = new Scanner(data);
		
		String line;
		String[] temp;
		
		while (dataRead.hasNextLine())
		{
       	line = dataRead.nextLine();
       	line = line.replace("\"", "");
       	line = line.replace(", ", "");
       	temp = line.split(",");
       	ReadFileStrategy Strategy = new ReadFileStrategy();
       	if(temp[0].charAt(0) != '!'){
       			Equity EquityInfo = (Equity) Strategy.EquityRead(temp);
       			holdingsArray.add(EquityInfo);
       		}
       	else{
       		
       	//	System.out.println("ENTER ELSE");
       		
       		if(temp[0].charAt(1) == 'T'){
       			//Transaction TransactionInfo = Strategy.TransactionRead(temp, EquityData,AccountData);
       			//TransactionData.add(TransactionInfo);
       		}
       		else if(temp[0].charAt(1) == 'O'){
       			System.out.println("OWNED");
       			Equity OwnedEquityInfo = (Equity) Strategy.OwnedEquityRead(temp);
       			holdingsArray.add(OwnedEquityInfo);
       		}
       		else{
       			Account AccountInfo = (Account) Strategy.AccountRead(temp);
       			holdingsArray.add(AccountInfo);
       		}
       	}
		   }
		dataRead.close();
	}
   
   
   public void viewOwnedEquities() {
	   		   
	   //
	   
		File data = new File(user.getUsername()+".txt");
		Scanner dataRead = null;
		try {
			dataRead = new Scanner(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line;
		String[] temp;
		
		while (dataRead.hasNextLine())
		{
      	line = dataRead.nextLine();
      	line = line.replace("\"", "");
      	line = line.replace(", ", "");
      	temp = line.split(",");
      	ReadHoldingsContext readOwnedEquity = new ReadHoldingsContext(new ReadOwnedEquities());
      	ReadHoldingsContext readOwnedAccount = new ReadHoldingsContext(new ReadAccountHolding());
      	System.out.println(temp[0]);
      	if(temp[0].equals("!OWNED")){
      			Equity OwnedEquityInfo = (Equity) readOwnedEquity.executeStrategy(temp);
      			ownedEquities.add(OwnedEquityInfo);
      		}
      	else if(temp[0].equals("!MM") || temp[0].equals("!BANK") ){
      		Account ownedAccount = (Account) readOwnedAccount.executeStrategy(temp);
      		accounts.add(ownedAccount);
      		
      	}
      		
      	}
		   
		dataRead.close();
	   
	   
}
   		
   public boolean checkAccount(String accountName){
	   
	   ReadHoldingsContext rhc = new ReadHoldingsContext(new ReadAccountHolding());
	   
	   accountName = accountName.replace(" ", "");
	    File data = new File(user.getUsername()+".txt");
		Scanner dataRead = null;
		try {
			dataRead = new Scanner(data);
			String line;
			String[] temp;
			
			while (dataRead.hasNextLine())
			{
	     	line = dataRead.nextLine();
	     	line = line.replace("\"", "");
	     	line = line.replace(", ", "");
	     	temp = line.split(",");
	     	System.out.println(temp[1]);
	     	if(temp[1].equals(accountName)){
	     			return true;
	     		}
	     		
	     	}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		   
		dataRead.close();
	    
	   return false;
   }
   
   
	/*************TEST*********************/
   public static void main(String[] args){
	   
	   User newUser = new User("arsh","123");
	   Portfolio portObj = new Portfolio(newUser);
	   portObj.viewOwnedEquities();
	   System.out.println(portObj.getAccounts().toString());
	   System.out.println(portObj.checkAccount("ArshBank "));
	   
	   
   }
   
   
}
   
   
   

