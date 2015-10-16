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
	/**
	 * String[] temp -> the array of Strings that contian the parameters to create an owned Equity
	 * 
	 * creates an Equity object that has been made for a user (number of shares is there)
	 * using an array list that contains its parameters
	 */
	public Holdings readHolding(String[] temp) {
		String temp1 = temp[1]; //ticker Symbol
		String temp2 = temp[2]; //name
		double temp3 = Double.parseDouble(temp[3]); //Number of shares
		double temp4 = Double.parseDouble(temp[4]); //Price of Shares
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd"); //Type of date format
		LocalDate Time = LocalDate.parse(temp[5], formatter); //time in the corresponding format
		Equity EquityInfo = new Equity(temp1, temp2, temp3); //creating Equity
		for(int x = 6; x < temp.length; x++){
			EquityInfo.addIndexOrSec(temp[x]); //adding the number of Sec according the length of the Equity
		}
		EquityInfo.setAcquiredShares(temp4); //Setting number of shares
		EquityInfo.setDate(Time.toString()); //Setting the date 
		return EquityInfo;  //returning Equity
	}
	
	

}
