/**
 * 
 */
package Release1;

import java.util.ArrayList;

/**
 * @author Arshdeep Khalsa, 
 *
 */
public class Equity {
	
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
	private int acquiredShares;
	
	/**
	 * The price of the equity
	 */
	private double eqPrice;
	
	/**
	 * The non-default constructor. Creates an equity with a name
	 * and ticker symbol.
	 * 
	 * @param name
	 * @param tickSymbol
	 */
	protected Equity(String tickSymbol, String name, double eqPrice ){
		
		this.name = name;
		this.tickSymbol = tickSymbol;
		this.eqPrice = eqPrice;
		
		this.indexOrSec = new ArrayList<String>();
		
	}

	/**
	 * Returns the name of the Holding
	 * 
	 * @return name
	 */
	protected String getName(){
		
		return this.name;
	}
	
	/**
	 * Returns the ticker symbol of an equity
	 * 
	 * @return tickSymbol
	 */
	protected String getTickSymbol(){
		
		return this.tickSymbol;
	}
	
	
	/**
	 * Sets the name of the Holding
	 * 
	 * @return name
	 */
	protected void setName(String name){
		
		this.name = name;
	}
	
	/**
	 * Sets the ticker symbol of an equity
	 * 
	 * @return tickSymbol
	 */
	protected void setTickSymbol(String tSymbol){
		
		this.tickSymbol = tSymbol;
		
	}
	
		/**
	 * Gets the price of the market 
	 * @return
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
	 * @return
	 */
	public ArrayList<String> getIndexOrSec() {
		return indexOrSec;
	}

	/**
	 * Add a new index or sector
	 * 
	 * @param indexOrSec
	 */
	public void addIndexOrSec(String indexOrSec) {
		this.indexOrSec.add(indexOrSec);
	}

	/**
	 * Returns the number of shares acquired
	 * @return
	 */
	public int getAcquiredShares() {
		return acquiredShares;
	}

	/**
	 * Sets the number of shares acquired
	 * @param acquiredShares
	 */
	public void setAcquiredShares(int acquiredShares) {
		this.acquiredShares = acquiredShares;
	}
	
	
	
}
