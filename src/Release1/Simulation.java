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
   private Interval intervalType;
   
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
   private double portfolioValBefore;
   
   /**
    * the value of the portfolio after the simulation ends
    */
   private double portfolioValAfter;

   /**
    * Creates a Simulation object representing a user simulation request from the user.
    * A simulation is created when the user enters in the type of market they'd like to 
    * simulate, a time interval, the amount of those time intervals, and a percentage 
    * @param type the desired kind of market to simulate
    * @param length the amount of time intervals to pass
    * @param iType the kind of time interval selected (DAY, MONTH, YEAR)
    * @param percent the per annum percentage
    */
   public Simulation(SimulationType type, int length, Interval iType, double percent) {
      
      this.simType = type;
      this.amount = length;
      this.intervalType = iType;
      this.percentage = percent;
      
      this.startDate = null;
      this.endDate = null;
      
   }
   
   /**
    * 
    * @param pVal
    */
   public void setOldPVal(double pVal) { this.portfolioValBefore = pVal; }
   
   /**
    * 
    * @param pVal
    */
   public void setNewPVal(double pVal) { this.portfolioValAfter = pVal; }
}
