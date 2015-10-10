/**
 * 
 */
package Release1;

/**
 * @author Arshdeep Khalsa, 
 *
 */
public abstract class Equity {
	
	/**
	 * Equity Name
	 */
	private String name;

	/**
	 * The ticker symbol for an equity
	 */
	private String tickSymbol;
	
	/**
	 * The market index (if an equity has one)
	 */
	private String marketIndex;
	
	/**
	 * The industry sector (if an equity has one)
	 */
	private String industrySec;
	
	
	/**
	 * The non-default constructor. Creates an equity with a name
	 * and ticker symbol.
	 * 
	 * @param name
	 * @param tickSymbol
	 */
	protected Equity(String name, String tickSymbol, String marketIndex, String industrySec){
		
		this.name = name;
		this.tickSymbol = tickSymbol;
		this.marketIndex = marketIndex;
		this.industrySec = industrySec;
		
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
	 * Returns the market index of a stock
	 * 
	 * @return marketIndex
	 */
	protected String getMakrketIndex(){
		
		return this.marketIndex;
	}
	
	/**
	 * Returns the industry sector of the stock
	 * 
	 * @return industrySec
	 */
	protected String getIndustrySec(){
		
		
		return this.industrySec;
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
	 * Sets the market index of a stock
	 * 
	 * @return marketIndex
	 */
	protected void setMakrketIndex(String marketIndex){
		
		this.marketIndex = marketIndex;
		
	}
	
	/**
	 * Sets the industry sector of the stock
	 * 
	 * @return industrySec
	 */
	protected void setIndustrySec(String industrySec){
		
		
		this.industrySec = industrySec;
	}
	
	
	
}
