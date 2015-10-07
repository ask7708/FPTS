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
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String tickSymbol;
	
	/**
	 * 
	 */
	private double marketIndex;
	
	/**
	 * 
	 */
	private String industrySec;
	
	
	/**
	 * 
	 * 
	 * @param name
	 * @param tickSymbol
	 */
	public Equity(String name, String tickSymbol){
		
		this.name = name;
		this.tickSymbol = tickSymbol;
		this.marketIndex = -1;
		this.industrySec = null;
		
	}

	/**
	 * 
	 * 
	 * @return name
	 */
	public String getName(){
		
		return this.name;
	}
	
	/**
	 * 
	 * 
	 * @return tickSymbol
	 */
	public String getTickSymbol(){
		
		return this.tickSymbol;
	}
	
	/**
	 * 
	 * 
	 * @return marketIndex
	 */
	public double getMakrketIndex(){
		
		return this.marketIndex;
	}
	
	/**
	 * 
	 * 
	 * @return industrySec
	 */
	public String getIndustrySec(){
		
		
		return this.industrySec;
	}
}
