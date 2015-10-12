package Release1;

import java.util.ArrayList;
import java.util.Stack;

public class Simulator {

   protected Stack<Simulation> simulations;
   protected String username;
   protected ArrayList<Equity> myHoldings;
   private double portfolioVal;
   
   public Simulator(Portfolio portfolio) {
      
      this.myHoldings = portfolio.getHoldings();
      this.simulations = new Stack<Simulation>();
      this.username = portfolio.getUsername();
      this.portfolioVal = 0;
   }
   
   /**
    * 
    * @param sim
    */
   public void addNewSimulation(Simulation sim) {
      
      simulations.push(sim);
      
      for(Equity obj: myHoldings)
         sim.addInterestEarned(obj);
   }
   
   public void removeOneSimulation() {
      
      Simulation undo = simulations.pop();
      
      if(simulations.size() >= 1)
         portfolioVal = simulations.peek().getNewPVal();
      else
         portfolioVal = undo.getOldPVal();
      
      double pct = undo.getPercent();
      double rate = 0;

      switch(undo.getIntType()) {
      
         case DAY:
            rate = (pct / 100.0) / 365;
            break;
         case MONTH:
            rate = (pct / 100.0) / 12;
            break;
         case YEAR:
            rate = (pct / 100.0);
            break;
      }
      
      SimulationType sType = undo.getSimType();
      
      for(Equity obj: myHoldings) {
         
         // Opposite of Bear Market = increase
         if(sType == SimulationType.BEAR) {
            
            int steps = undo.getAmount();
            
            while(steps != 0) {
               
               double p = obj.getSharePrice();
               double inc = p * rate;
               obj.setSharePrice(p + inc);
               steps--;
            }
         }
         
         else if(sType == SimulationType.BULL) {
            
            int steps = undo.getAmount();
            
            while(steps != 0) {
               
               obj.setSharePrice(obj.getSharePrice() / 
                  Math.pow((1 + rate), 1));
               steps--;
            }    
         }
         
         else
            continue;
      }  
   }
   
   public void resetAll() {   
      while(!simulations.empty()) { removeOneSimulation(); }
   }
   
   public static void main(String[] args) {
      
      User me = new User("dxr5716", "me");
      
      Portfolio portfolio = new Portfolio(me);
      portfolio.addHolding(new Equity("GOOG", "Google Inc.", 153.54));
      
      Simulator simulator = new Simulator(portfolio);
      
      for(Equity obj: simulator.myHoldings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " is $" + 
               (String.format("%.02f", obj.getSharePrice())));
      }
      
      simulator.addNewSimulation(new Simulation(SimulationType.BULL, 1, Interval.YEAR, 10.00));
      
      for(Equity obj: simulator.myHoldings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " is now $" + 
               (String.format("%.02f", obj.getSharePrice())));
      }
      
      simulator.addNewSimulation(new Simulation(SimulationType.BULL, 2, Interval.MONTH, 10.00));
      
      for(Equity obj: simulator.myHoldings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " is now $" + 
               (String.format("%.02f", obj.getSharePrice())));
      }
      
      simulator.resetAll();
//      
//      simulator.removeOneSimulation();
//      
//      for(Equity obj: simulator.myHoldings) {
//         
//         System.out.println("The price of a share at " + obj.getTickSymbol() + " is now $" + 
//               (String.format("%.02f", obj.getSharePrice())));
//      }
//      
//      simulator.removeOneSimulation();
      
      for(Equity obj: simulator.myHoldings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " is now $" + 
               (String.format("%.02f", obj.getSharePrice())));
      }
   }
   
}
