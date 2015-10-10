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
   
   private ArrayList<Holding> holdings;
   
   public Portfolio(User user) {
   
      this.user = user;
      this.holdings = new ArrayList<Holding>();
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
   public ArrayList<Holding> getHoldings() { return new ArrayList<Holding>(holdings); }
   
   
   
}
