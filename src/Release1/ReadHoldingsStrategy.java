/**
 * 
 */
package Release1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
