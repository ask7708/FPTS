/**
 * 
 */
package Release1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Arsh
 *
 *
 */
public class ReadAccountHolding extends ReadHoldingsStrategy {

	@Override
	public Holdings readHolding(String[] temp) {
		String temp1 = temp[1];
		double temp2 = Double.parseDouble(temp[2]);
		int temp3 = Integer.parseInt(temp[3]);
		int temp4 = Integer.parseInt(temp[4]);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate temp5 = LocalDate.parse(temp[5], formatter);
		
		Account AccountInfo = null;
		if(temp[0] == "!MM"){
			AccountInfo = new MarketAccount(temp1, temp2, temp5, temp4, temp3);
			return AccountInfo;
		}
		else{
			AccountInfo = new BankAccount(temp1, temp2, temp5, temp4, temp3);
			return AccountInfo;
		}
	}

}


