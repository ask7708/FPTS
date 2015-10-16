/**
 * 
 */
package Release1;


/**
 * @author Arsh
 *
 */
public class ReadAccountHolding extends ReadHoldingsStrategy {

	@Override
	public Holdings readHolding(String[] temp) {
		String temp1 = temp[1];
		double temp2 = Double.parseDouble(temp[2]);
		int temp3 = Integer.parseInt(temp[3]);
		int temp4 = Integer.parseInt(temp[4]);
		String temp5 = temp[5];
		
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


