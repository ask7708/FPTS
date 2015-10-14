/**
 * 
 */
package Release1;

/**
 * @author Arsh
 *
 */
public class ReadEquitiesRaw implements ReadHoldingsStrategy {

	@Override
	public Holdings readHolding(String[] temp) {
		double temp2 = Double.parseDouble(temp[2]);
		Equity EquityInfo = new Equity(temp[0], temp[1], temp2);
		for(int x = 3; x < temp.length; x++){
			EquityInfo.addIndexOrSec(temp[x]);
		}
		return EquityInfo;
	}
	
	

}
