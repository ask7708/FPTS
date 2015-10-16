/**
 * 
 */
package Release1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Arshdeep Khalsa, 
 *
 */
public class Equity implements Holdings {
	
	/**
	 * Equity Name
	 */
	private String name;

	/**
	 * The ticker symbol for an equity
	 */
	private String tickSymbol;
	
	/**
	 * The market index and industry sector (if an equity has one)
	 */
	private ArrayList<String> indexOrSec;
	
	/**
	 * Number of shares the user holds 
	 * 
	 */
	private double acquiredShares;
	
	/**
	 * The price of the equity
	 */
	private double eqPrice;
	
	/**
	 * The date the Equity was acquired
	 */
	private String date;
	
	/**
	 * A stack used to simulate price changes
	 */
	private Stack<Double> priceChanges;
	
	/**
	 * Represents an Equity object passing in a company's ticker symbol,
	 * the company's name, and the price per share
	 * @param tickSymbol the company's ticker symbol
	 * @param name the company's name
	 * @param eqPrice the price per share of the company
	 */
	protected Equity(String tickSymbol, String name, double eqPrice ){
		
		this.name = name;
		this.tickSymbol = tickSymbol;
		this.eqPrice = eqPrice;
		
		this.date = null;
		this.acquiredShares = 0;
		this.indexOrSec = new ArrayList<String>();
		this.priceChanges = null;
	}

	/**
	 * Returns the name of the Holding
	 * @return name
	 */
	protected String getName(){
		
		return this.name;
	}
	
	/**
	 * Returns the ticker symbol of an equity
	 * @return tickSymbol
	 */
	protected String getTickSymbol(){
		
		return this.tickSymbol;
	}
	
	
	/**
	 * Sets the name of the Holding
	 * @return name
	 */
	protected void setName(String name){
		
		this.name = name;
	}
	
	/**
	 * Sets the ticker symbol of an equity
	 * @return tickSymbol
	 */
	protected void setTickSymbol(String tSymbol){
		
		this.tickSymbol = tSymbol;
		
	}
	
	/**
	 * Gets the price of the market 
	 * @return the price per share
	 */
	public double getSharePrice() {
		return eqPrice;
	}

	/**
	 * Sets the price of the market
	 * @param thePrice
	 */
	public void setSharePrice(double thePrice) {
		this.eqPrice = thePrice;
	}

	/**
	 * Return the complete array list of index or sectors
	 * @return a list of the equity's market indices and sectors (if applicable)
	 */
	public ArrayList<String> getIndexOrSec() {
		return this.indexOrSec;
	}

	/**
	 * Add a new index or sector
	 * @param indexOrSec the market sector or index
	 */
	public void addIndexOrSec(String indexOrSec) {
		this.indexOrSec.add(indexOrSec);
	}

	/**
	 * Returns the number of shares acquired
	 * @return the number of acquired shares
	 */
	public double getAcquiredShares() {
		return acquiredShares;
	}

	/**
	 * Gives the equity its price changes Stack so that it could be used for Simulation
	 */
	public void putSimulationOn() { this.priceChanges = new Stack<Double>(); }
	
	/**
	 * Removes the equity's price changes Stack so that the portfolio (and its equities)  
	 * can be sent back to DashboardView (or any other view for that matter) in the same 
	 * state that it came in
	 */
	public void putSimulationOff() { 
	   
	   this.priceChanges.removeAllElements(); 
	   this.priceChanges = null; 
	}
	
	/**
	 * Used to add a price change to its Stack 
	 * @param newPrice the new price as a result of a simulation
	 */
	public void addPriceChange(double newPrice) {
	   
	   this.priceChanges.push(newPrice);
	}
	
	/**
	 * Used to remove a price change from its Stack
	 * (It's safe enough that it won't break if called outside of the simulator)
	 */
	public void removePriceChange() { 
	   
	   if(this.priceChanges != null) {
	      
	      if(!this.priceChanges.empty())
	         this.priceChanges.pop(); 
	   }
	}
	
	/**
	 * Used to get the price per share of an Equity in the simulator
	 * (It's safe enough that it won't break and would return the Equity's initial price
	 * if called outside of the simulator)
	 * @return either the initial price or the newly made simulation price
	 */
	public double getSimulationPrice() {
	   Double simPrice = new Double(eqPrice);
	   
	   if(this.priceChanges != null) {
	      
	      if(!this.priceChanges.empty())
	         simPrice = priceChanges.peek();
	   }
	   
	   return simPrice;
	}
	
	/**
	 * Sets the number of shares acquired
	 * @param acquiredShares the new amount of acquried shares
	 */
	public void setAcquiredShares(double acquiredShares) {
		this.acquiredShares = acquiredShares;
	}
	
	/**
	 * Sets the date the Equity was acquired
	 * @param date the new acquired date
	 */
	public void setDate(String date){
		this.date = date;
	}
	
	/**
	 * Returns the date the Equity was acquired
	 * @return the date acquired
	 */
	public String getDate(){
		return this.date;
	}
		
	/**
	 * Creates a toString method to print out an Equity Object
	 * @param the String representation of Equity
	 */
	public String toString(){
		
		 String newS = new String();
         newS += this.getTickSymbol();
         newS += " , " + this.getName();
         newS += " , $" + (this.getSharePrice() +" , ");
         if(this.getAcquiredShares() != 0.0){
        	 newS += "$" + (this.getAcquiredShares() +" , ");
         }
         if(this.getDate() != null){
        	 newS += (this.getDate() +" , ");
         }
         
         ArrayList<String> sectors = this.getIndexOrSec();
         
         if(!sectors.isEmpty()) {
            
            for(String o: sectors){
               newS += o + ", ";
            }
         }
         
         newS += "\n";
         newS = newS.substring(0, newS.length()-2);
         return newS;
	}
}