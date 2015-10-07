/**
 * 
 */
package Release1;

/**
 * @author Arshdeep Khalsa, 
 *
 */
public abstract class Equity {
	
	private String name;
	private String tickSymbol;
	private double marketIndex;
	private String industrySec;
	
	
	public Equity(String name, String tickSymbol){
		
		this.name = name;
		this.tickSymbol = tickSymbol;
		this.marketIndex = -1;
		this.industrySec = null;
		
	}

	
	
	
	
	
}
