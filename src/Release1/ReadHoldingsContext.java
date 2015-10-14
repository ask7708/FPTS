/**
 * 
 */
package Release1;

/**
 * @author Arsh
 *
 */
public class ReadHoldingsContext {

	   private ReadHoldingsStrategy strategy;

	   public ReadHoldingsContext(ReadHoldingsStrategy strategy){
	      this.strategy = strategy;
	   }

	   public Holdings executeStrategy(String[] temp){
	      return strategy.readHolding(temp);
	   }
	}