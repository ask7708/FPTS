/**
 * 
 */
package Release1;

/**
 * @author Arsh
 *
 */
public class ReadEquitiesRaw extends ReadHoldingsStrategy {

	@Override
	/**
	 * ReadEquitiesRaw is used to create an Equity object that hasn't been personalized
	 * to a user (number of shares) so a market equity using an arraylist of parameters
	 * 
	 * String temp[] -> A string that contains the parameters for a Market Equity
	 */
	public Holdings readHolding(String[] temp) {
		double temp2 = Double.parseDouble(temp[2]); //value of Equity
		Equity EquityInfo = new Equity(temp[0], temp[1], temp2); //creating Equity
		for(int x = 3; x < temp.length; x++){ //loop to add index or Sectors
			EquityInfo.addIndexOrSec(temp[x]); //adds a sector as long as it's not out of bounce
		}
		return EquityInfo; //returns Equity Object
	}
	
	

}
