package Release1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

/**
 * 
 * @author itnks
 *
 */

public class Portfolio extends Observable {

   private User user;
   
   private ArrayList<Equity> holdings;
   private ArrayList<Account> accounts;
   private ArrayList<Transaction> transactions;
   
   public Portfolio(User user) {
   
      this.user = user;
      this.holdings = new ArrayList<Equity>();
      this.accounts = new ArrayList<Account>();
      this.transactions = new ArrayList<Transaction>();
      
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
   
   public ArrayList<Equity> getHoldingsNew() { return this.holdings; }
      
   /**
    * Returns a deep copy of the accounts the portfolio has
    * @return a copy of the portfolio's accounts
    */
   public ArrayList<Account> getAccounts() { return new ArrayList<Account>(accounts); }
   
   public void addHolding(Equity holding) { holdings.add(holding); }
 
   
   public void viewPortfolio(){
	   	
	   System.out.println("ENTERED VIEW PORTFOLIO");
	   File file = new File(getUsername()+".txt");
   	
	   file.setReadOnly();
	   Desktop desktop = Desktop.getDesktop();

	   
	   if(file.exists()){
		   System.out.println("FILE EXISTS");
		   try {
			desktop.open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }else{
		
		   
	   }
	   }
	   
   }
   
   
   

