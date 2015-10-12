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
      this.interval = iType;
      this.percentage = percent;
      
      this.startDate = null;
      this.endDate = null;
      
   }
   
   public SimulationType getSimType() { return this.simType; }
   
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
   public void setOldPVal(double pVal) { this.portfolioValBefore = pVal; }
   
   /**
    * 
    * @param pVal
    */
   public void setNewPVal(double pVal) { this.portfolioValAfter = pVal; }
   
   /**
    * 
    * @return
    */
   public double getOldPVal() { return this.portfolioValBefore; }
   
   /**
    * 
    * @return
    */
   public double getNewPVal() { return this.portfolioValAfter; }
   
   /**
    * 
    * @param holding
    */
   public void addInterestEarned(Equity holding) {
      
      double rate = 0;
      
      switch(interval) {
      
         case DAY:
            rate = (percentage / 100.0) / 365;
            break;
         case MONTH:
            rate = (percentage / 100.0) / 12;
            break;
         case YEAR:
            rate = (percentage / 100.0);
            break;  
      }
      
      if(simType == SimulationType.NONE)
         return;
      
      else if(simType == SimulationType.BULL) {
         
         int steps = amount;
         
         while(steps != 0) {
            
            double p = holding.getSharePrice();
            double inc = p * rate;
            holding.setSharePrice(p + inc);
            steps--;
         }
      }
      
      else {
         
         int steps = amount;
         
         while(steps != 0) {
            
            double p = holding.getSharePrice();
            double dec = p * rate;
            holding.setSharePrice(p - dec);
            steps--;
         }
      }
   }
   
}
