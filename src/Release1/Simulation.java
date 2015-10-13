package Release1;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Simulation {

   /**
    * the day the simulation is going to start
    */
   private LocalDate startDate;
   
   /**
    * the day the simulation is going to end on
    */
   private LocalDate endDate;
   
   /**
    * the type of interval the user selects to simulate (DAY, MONTH, YEAR)
    */
   private Interval interval;
   
   /**
    * the interval amount (ex. 7 days, 3 months, 4 years)
    */
   private int amount;
   
   /**
    * the type of market being simulated
    * BULL - Bull market
    * BEAR - Bear market
    * NONE - No-growth-market  
    */
   private SimulationType simType;
   
   /**
    * the per annum percentage given by the user 
    */
   private double percentage;
   
   /**
    * the value of the portfolio before the simulation begins
    */
   private double pValBefore;
   
   /**
    * the value of the portfolio after the simulation ends
    */
   private double pValAfter;

   /**
    * Creates a Simulation object representing a user simulation request from the user.
    * A simulation is created when the user enters in the type of market they'd like to 
    * simulate, a time interval, the amount of those time intervals, and a percentage 
    * @param type the desired kind of market to simulate
    * @param length the amount of time intervals to pass
    * @param iType the kind of time interval selected (DAY, MONTH, YEAR)
    * @param percent the per annum percentage
    */
   public Simulation(SimulationType type, int length, Interval iType, double percent, LocalDate startDate) {
      
      this.simType = type;
      this.amount = length;
      this.interval = iType;
      this.percentage = percent / 100;
      
      this.startDate = startDate;
      
      switch(iType) {
      
      case DAY:
         this.endDate = startDate.plusDays(length);
         break;
      case MONTH:
         this.endDate = startDate.plusMonths(length);
         break;
      case YEAR:
         this.endDate = startDate.plusYears(length);
         break;
      }      
   }
   
   public LocalDate getStartDate() { return this.startDate; }
   
   public LocalDate getEndDate() { return this.endDate; }
   
   /**
    * 
    * @return
    */
   public SimulationType getSimType() { return this.simType; }
   
   /**
    * 
    * @return
    */
   public Interval getIntType() { return this.interval; }
   
   /**
    * 
    * @return
    */
   public double getPercent() { return this.percentage; }
   
   /**
    * 
    * @return
    */
   public int getAmount() { return this.amount; }
   
   /**
    * 
    * @param pVal
    */
   public void setOldPVal(double pVal) { this.pValBefore = pVal; }
   
   /**
    * 
    * @param pVal
    */
   public void setNewPVal(double pVal) { this.pValAfter = pVal; }
   
   /**
    * 
    * @return
    */
   public double getOldPVal() { return this.pValBefore; }
   
   /**
    * 
    * @return
    */
   public double getNewPVal() { return this.pValAfter; }
   
   /**
    * 
    * @param holding
    */
   public void addInterestEarned(Equity holding) {
      
      double time = 0;
      double intrst = 0;
      double price = holding.getSimulationPrice();
      double newPrice = price;
      int steps = amount;
      
      switch(interval) {
      
         case DAY:
            time = amount / 365.0;
            break;
         case MONTH:
            time = amount / 12.0;
            break;
         case YEAR:
            time = amount;
            break;
      }
      
      switch(simType) {
         
         case NONE:
            holding.addPriceChange(newPrice);
            return;
            
         case BEAR:
            intrst = price * percentage * time;
            steps = amount;
            
            while(steps != 0) { 
               
               newPrice -= ((1.0/amount) * intrst);
               steps--;
            }
            
            holding.addPriceChange(newPrice);
            break;
            
         case BULL:
            intrst = price * percentage * time;
            steps = amount;
            
            while(steps != 0) {
               
               newPrice += ((1.0/amount) * intrst);
               steps--;
            }
            
            holding.addPriceChange(newPrice);
            break;
      }
   }
}
