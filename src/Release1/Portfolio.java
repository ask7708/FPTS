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
   
   
   
}
