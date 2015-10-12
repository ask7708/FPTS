package Release1;

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
   
   public Portfolio(User user) {
   
      this.user = user;
      this.holdings = new ArrayList<Equity>();
      this.accounts = new ArrayList<Account>();
   }
   
   public String getUsername() { return user.getUsername(); }
   
   public String getUserFName() { return user.getFirstName(); }
   
   public String getUserLName() { return user.getLastName(); } 
   
   /**
    * Returns a copy of the holding the portfolio has 
    * (I went with a copy so that holdings of the portfolio aren't affected when
    * simulations are being done)
    * @return a copy of the portfolio's holdings
    */
   public ArrayList<Equity> getHoldings() { 
      
      ArrayList<Equity> copy = new ArrayList<Equity>(holdings); 
      
      for(Equity obj: copy) {
         obj.setForSimulation();
      }
      
      return copy;
   }
   
   public void addHolding(Equity holding) { holdings.add(holding); }
   
   
}
