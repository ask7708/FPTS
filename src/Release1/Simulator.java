package Release1;

import java.util.ArrayList;
import java.util.Stack;

public class Simulator {

   private Stack<Simulation> simulations;
   
   private ArrayList<Holding> myHoldings;
   
   public Simulator(Portfolio portfolio) {
      
      this.myHoldings = portfolio.getHoldings();
      this.simulations = new Stack<Simulation>();
   }
}
