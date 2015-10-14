/**
 * 
 */
package Release1;

/**
 * @author Arsh
 *
 */
public interface ReadHoldingsStrategy {
	
	/**
	 * Reads different types of holdings such
	 * as account, equities (raw), and equities owned 
	 * by the user
	 * 
	 * @param temp
	 * @return
	 */
	public Holdings readHolding(String[] temp);

}
