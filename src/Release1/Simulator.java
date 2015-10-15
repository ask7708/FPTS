package Release1;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

import javax.swing.text.NumberFormatter;

public class Simulator extends Observable {

   //protected Portfolio portfolio;
   protected ArrayList<Equity> holdings;
   protected ArrayList<Account> accounts;
   protected Stack<Simulation> simulations;
   protected String username;
   private double portfolioVal;
   private LocalDate currentDate;
   
   /**
    * 
    * @param portfolio
    */
   public Simulator(String username) {
      
      this.simulations = new Stack<Simulation>();
      this.username = username;

      String fName = username.concat(".txt");
      try {
         
         ReadFile fileReader = new ReadFile(fName);
         this.holdings = fileReader.getOwnedEquities();
         
         for(Equity obj: holdings)
              obj.putSimulationOn();
         
         this.accounts = fileReader.getAllAccounts();

      } catch(FileNotFoundException ex) {
         
         System.err.println("The file is not found");
         
      }
      
      this.portfolioVal = 0;
      this.currentDate = LocalDate.now();
   }
   
   /**
    * 
    * @return
    */
   public LocalDate getDate() { return this.currentDate; }
   
//   public Portfolio returnPortfolio() {
//   
//      for(Equity obj: portfolio.getHoldingsNew()) { obj.putSimulationOff(); }
//      return this.portfolio;
//      
//   }
   
   public ArrayList<String> getEquitiesShort() {
   
      ArrayList<String> strs = new ArrayList<String>();
      //NumberFormat formatter = NumberFormat.getCurrencyInstance();
      for(Equity obj: this.holdings) {
         
         String newS = new String();
         newS += obj.getTickSymbol();
         newS += " / $" + (String.format("%.02f", obj.getSimulationPrice()));
         
         ArrayList<String> sectors = obj.getIndexOrSec();
         
         if(!sectors.isEmpty()) {
            
            for(String o: sectors)
               newS += o + "/ ";
         }
         
         newS = newS.substring(0, newS.length()-3);
         strs.add(newS);
      }
      
      return strs;
   }
   
   public ArrayList<String> getEquitiesLong() {
      
      ArrayList<String> strs = new ArrayList<String>();
      
//      for(Equity obj: holdings)
      return strs;
   }
   
   public ArrayList<String> getSimulationsShort() {
   
      ArrayList<String> strs = new ArrayList<String>();
      DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
      
      for(int i = 0; i < simulations.size(); i++) {
      
         String newS = new String();
         newS += simulations.get(i).getSimType().toString();
         newS += " / " + simulations.get(i).getAmount() + " / ";
         
         switch(simulations.get(i).getIntType()) {
            
            case DAY:
               newS += "DAY @ " + (simulations.get(i).getPercent()*100) + "% / ";
               break;
            case MONTH:
               newS += "MONTH @ " + (simulations.get(i).getPercent()*100) + "% / ";
               break;
            case YEAR:
               newS += "YEAR @ " + (simulations.get(i).getPercent()*100) + "% / ";
               break;
         }
         
         newS += simulations.get(i).getStartDate().format(df);
         strs.add(newS);
      }
      
      return strs;
   }
   public ArrayList<String> getSimulationsLong() {
   
      ArrayList<String> strs = new ArrayList<String>();
      DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
      
      for(int i = 0; i < simulations.size(); i++){
      
         String newS = new String();
         
         switch(simulations.get(i).getSimType()) {
         
         case BULL:
            newS += "Bull Market Simulation\n";
            break;
         case BEAR:
            newS += "Bear Market Simulation\n";
            break;
         case NONE:
            newS += "No-Growth Market Simulation\n";
            break;
      }
         
         newS += simulations.get(i).getAmount() + " " + 
               simulations.get(i).getIntType().toString() + " @ " + (simulations.get(i).getPercent()*100)
               + "%\n";
         newS += simulations.get(i).getStartDate().format(df) + " to " + 
               simulations.get(i).getEndDate().format(df) + "\n";
         newS += "Portfolio Before: $" + simulations.get(i).getOldPVal() +"\n";
         newS += "Portfolio After: $" + simulations.get(i).getNewPVal() +"\n";
         
         strs.add(newS);
      }
      
      return strs;
   }
   
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
      
      for(Equity obj: this.holdings)
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
        
      for(Equity obj: this.holdings) { obj.removePriceChange(); }
      
      return true;  
   }
   
   public void resetAll() {   
      while(!simulations.empty()) { removeOneSimulation(); }
   }
   
   public double getPortfolioValue() { 
      // current value of each stock
	  //number of shares 
      //current price * number of shares
	   List<Double> totalList = new ArrayList<Double>();
	   Double oneStock = 0.0; 
	      if(!simulations.isEmpty()){
	    	  return this.simulations.peek().getNewPVal(); 
	      }else{
	   	   for(Equity obj: this.holdings){
	   		   oneStock = obj.getAcquiredShares() * obj.getSimulationPrice();
	   		  totalList.add(oneStock);
	   	   } 
	   	   double sum = 0;
	   	   for(Double d : totalList)
	   		   portfolioVal += d;
	   	   return portfolioVal;
	      }
   }
   
   public static void main(String[] args) {
//      
//      User me = new User("dxr5716", "me");
//      
//      Portfolio portfolio = new Portfolio(me);
//      
//      Equity e1 = new Equity("GOOG", "Google Inc.", 100.00);
//      e1.setAcquiredShares(50);
//      Equity e2 = new Equity("AAPL", "Apple Inc.", 500.00);
//      e2.setAcquiredShares(20);
//      
//      portfolio.addHolding(e1);
//      portfolio.addHolding(e2);
//      
      Simulator simulator = new Simulator("data");
      ArrayList<String> eq = simulator.getEquitiesShort();
            
      System.out.println("The value of the Portfolio is "  + simulator.getPortfolioValue());
      
      for(Equity obj: simulator.holdings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " is $" + 
               (String.format("%.02f", obj.getSimulationPrice())));
      }
      
      simulator.addNewSimulation(new Simulation(SimulationType.BULL, 1, Interval.YEAR, 5.00, simulator.getNextSimDate()));
      
      for(Equity obj: simulator.holdings) {
    	  
         System.out.println("The price of a share at " + obj.getTickSymbol() + " after 1 simulation is now $" + 
               (String.format("%.02f", obj.getSimulationPrice())));
      }

      simulator.addNewSimulation(new Simulation(SimulationType.BEAR, 2, Interval.MONTH, 10.00, simulator.getNextSimDate()));
      //System.out.println("The next simulation would start on: " + simulator.getNextSimDate().toString());
      
      for(Equity obj: simulator.holdings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " after 2 simulations is now $" + 
               (String.format("%.02f", obj.getSimulationPrice())));
      }
      
      ArrayList<String> sims = simulator.getSimulationsLong();
      
      for(String o: sims) 
         System.out.println(o);
      
      System.out.println("The value of the Portfolio is "  + simulator.getPortfolioValue());
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
      for(Equity obj: simulator.holdings) {
         
         System.out.println("The price of a share at " + obj.getTickSymbol() + " is now $" + 
               (String.format("%.02f", obj.getSimulationPrice())));
      }
      
   }   
}