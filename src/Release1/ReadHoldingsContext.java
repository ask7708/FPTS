/**
 * 
 */
package Release1;

/**
 * @author Arsh
 *
 */
public class ReadHoldingsContext {
	   private ReadHoldingsStrategy strategy; //Current Strategy being used
	   /**
	    * 
	    * @param strategy - this is used so that the strategy is linked to the context
	    * 
	    *ReadHoldingsContext is used to set the corresponding Strategy so that the proper
	    *holding will be created using the right arraylist
	    */
	   public ReadHoldingsContext(ReadHoldingsStrategy strategy){
	      this.strategy = strategy; //sets the method equal to the  parameter
	   }
	   /**
	    * 
	    * @param temp - the array being used in the strategy
	    * @return created holding due to the strategy
	    * 
	    * this executes the actual strategy and returns the corresponding holding
	    */
	   public Holdings executeStrategy(String[] temp){
	      return strategy.readHolding(temp);
	   }
	}