/**
 * 
 */
package Release1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Arsh
 *
 */
public class ReadOwnedEquities extends ReadHoldingsStrategy {

	@Override
	public Holdings readHolding(String[] temp) {
		String temp1 = temp[1];
		String temp2 = temp[2];
		double temp3 = Double.parseDouble(temp[3]);
		double temp4 = Double.parseDouble(temp[4]);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate Time = LocalDate.parse(temp[5], formatter);
		Equity EquityInfo = new Equity(temp1, temp2, temp3);
		for(int x = 6; x < temp.length; x++){
			EquityInfo.addIndexOrSec(temp[x]);
		}
		EquityInfo.setAcquiredShares(temp4);
		EquityInfo.setDate(Time.toString());
		return EquityInfo;
	}
	
	

}
