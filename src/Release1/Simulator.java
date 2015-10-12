package Release1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Stack;

public class Simulator {

   protected Stack<Simulation> simulations;
   protected String username;
   protected ArrayList<Equity> myHoldings;
   protected ArrayList<Account> myAccounts;
   private double portfolioVal;
   private LocalDate currentDate;
   
   /**
    * 
    * @param portfolio
    */
   public Simulator(Portfolio portfolio) {
      
      this.myHoldings = portfolio.getHoldings();
      this.simulations = new Stack<Simulation>();
      this.username = portfolio.getUsername();
      this.portfolioVal = 0;
      this.currentDate = LocalDate.now();
   }
   /**
    * 
    * @return
    */
   public LocalDate getDate() { return this.currentDate; }
   
   public LocalDate getNextSimDate() {
      
      if(!simulations.isEmpty()) {
         
         return simulations.peek().getEndDate().plusDays(1);
      }
      
      return currentDate.plusDays(1);
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
   
   public boolean removeOneSimulation() {
      
      Simulation undo = null;
      
      if(!simulations.isEmpty())
        undo = simulations.pop();
      else
         return false;
      
      if(!simulations.isEmpty())
         portfolioVal = simulations.peek().getNewPVal();
      else
         portfolioVal = undo.getOldPVal();
        
      for(Equity obj: myHoldings) { obj.removePriceChange(); }
      
      return true;  
   }
   
   public void resetAll() {   
      while(!simulations.empty()) { removeOneSimulation(); }
   }
   
   public double getPortfolioValue() { 
      
      if(!simulations.isEmpty())
         return this.simulations.peek().getNewPVal(); 
      else
         return portfolioVal;
   }
   
   public static void main(String[] args) {
      
      User me = new User("dxr5716", "me");
      
      Portfolio portfolio = new Portfolio(me);
      
      Equity e1 = new Equity("GOOG", "Google Inc.", 100.00);
      e1.setAcquiredShares(50);
      Equity e2 = new Equity("AAPL", "Apple Inc.", 500.00);
      e2.setAcquiredShares(20);
      
      portfolio.addHolding(e1);
      portfolio.addHolding(e2);
      
      Simulator simulator = new Simulator(portfolio);
      System.out.println(simulator.getDate());
      
      for(Equity obj: simulator.myHoldings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " is $" + 
               (String.format("%.02f", obj.getSimulationPrice())));
      }
      
      simulator.addNewSimulation(new Simulation(SimulationType.BULL, 1, Interval.YEAR, 5.00, simulator.getNextSimDate()));
      
      for(Equity obj: simulator.myHoldings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " after 1 simulation is now $" + 
               (String.format("%.02f", obj.getSimulationPrice())));
      }
      System.out.println(simulator.getNextSimDate().toString());
      simulator.addNewSimulation(new Simulation(SimulationType.BEAR, 2, Interval.MONTH, 10.00, simulator.getNextSimDate()));
      //System.out.println("The next simulation would start on: " + simulator.getNextSimDate().toString());
      
      for(Equity obj: simulator.myHoldings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " after 2 simulations is now $" + 
               (String.format("%.02f", obj.getSimulationPrice())));
      }
//      
//      simulator.resetAll();
//      
      simulator.removeOneSimulation();
//      
//      for(Equity obj: simulator.myHoldings) {
//         
//         System.out.println("The price of a share at " + obj.getTickSymbol() + " is now $" + 
//               (String.format("%.02f", obj.getSharePrice())));
//      }
//      
//      simulator.removeOneSimulation();
//      
      for(Equity obj: simulator.myHoldings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " is now $" + 
               (String.format("%.02f", obj.getSimulationPrice())));
      }
   }
   
}
