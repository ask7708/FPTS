package Release1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import java.util.Stack;

public class Simulator extends Observable {

   protected ArrayList<Equity> holdings;
   protected ArrayList<Account> accounts;
   protected Stack<Simulation> simulations;
   protected String username;
   private double portfolioVal;
   private LocalDate currentDate;

   /**
    * Constructor for the Simulator object which takes in a user's username
    * @param username the username of the user
    */
   public Simulator(String username) {

      this.simulations = new Stack<Simulation>();
      this.username = username;
      this.holdings = new ArrayList<Equity>();
      this.currentDate = LocalDate.now();
      this.portfolioVal = 0;

      String fName = username.concat(".txt");

      //
      File data = new File(fName);
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

         if(temp[0].equals("!OWNED")){
            Equity OwnedEquityInfo = (Equity) readOwnedEquity.executeStrategy(temp);
            holdings.add(OwnedEquityInfo);
         }


      }

      dataRead.close();

      for(Equity obj: holdings)
         obj.putSimulationOn();

   }

   /**
    * 
    * @return
    */
   public LocalDate getDate() { return this.currentDate; }

   public ArrayList<String> getEquitiesShort() {

      ArrayList<String> strs = new ArrayList<String>();
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

   public ArrayList<String> getSimulationsShort() {

      ArrayList<String> strs = new ArrayList<String>();
      DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");

      for(int i = 0; i < simulations.size(); i++) {

         String newS = new String();
         newS += simulations.get(i).getSimType().toString();
         newS += " / " + simulations.get(i).getAmount() + " ";

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

      setChanged();
      notifyObservers();
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

      setChanged();
      notifyObservers();

      return true;  
   }

   public void resetAll() {   
      while(!simulations.empty()) { removeOneSimulation(); }
   }
}