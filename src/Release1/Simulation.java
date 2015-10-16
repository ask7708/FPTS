package Release1;

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
      this.percentage = percent / 100.0;
      
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
   
   /**
    * Returns the day the simulation was started
    * @return the start date
    */
   public LocalDate getStartDate() { return this.startDate; }
   
   /**
    * Returns the day the simulation ended
    * @return the end date
    */
   public LocalDate getEndDate() { return this.endDate; }
   
   /**
    * Returns the type of simulation
    * @return the simulation type (BULL, BEAR, or NONE)
    */
   public SimulationType getSimType() { return this.simType; }
   
   /**
    * Return the type of time interval chosen
    * @return the interval type (DAY, MONTH, or YEAR)
    */
   public Interval getIntType() { return this.interval; }
   
   /**
    * Returns the percentage for the simulation given by the user
    * @return the annual percentage
    */
   public double getPercent() { return this.percentage; }
   
   /**
    * Returns the number of time intervals given by the user
    * @return the number of steps chosen
    */
   public int getAmount() { return this.amount; }
   
   /**
    * Sets the simulation's portfolio value before the simulation starts
    * @param pVal the portfolio value before starting the simulation
    */
   public void setOldPVal(double pVal) { this.pValBefore = pVal; }
   
   /**
    * Sets the simulation's portfolio value after the simulation ends
    * @param pVal the portfolio value after the simulation ends
    */
   public void setNewPVal(double pVal) { this.pValAfter = pVal; }
   
   /**
    * Returns the simulation's portfolio value before the simulation starts
    * @return the portfolio value before starting the simulation
    */
   public double getOldPVal() { return this.pValBefore; }
   
   /**
    * Returns the simulation's portfolio value after the simulation ends
    * @return the portfolio value after the simulation ends
    */
   public double getNewPVal() { return this.pValAfter; }
   
   /**
    * Adds the increase/decrease of the Equity being simulated 
    * @param holding the Equity being affected
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
