/**
 * 
 */
package Release1;


/**
 * @author Arsh
 *
 */
public abstract class ReadHoldingsStrategy {
	
	
	
	/**
	 * Reads different types of holdings such
	 * as account, equities (raw), and equities owned 
	 * by the user
	 * 
	 * @param temp
	 * @return
	 */
	public abstract Holdings readHolding(String[] temp);

}
