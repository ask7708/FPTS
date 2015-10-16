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
public class Market {

	
	private ArrayList<Equity> marketEquities = new ArrayList<Equity>();
	
	
	
	public ArrayList<Equity> getMarketEquities(){
		
		return this.marketEquities;
	}
	
	public void viewMarketEquities(){

			File data = new File("equities.txt");
			Scanner dataRead = null;
			try {
				dataRead = new Scanner(data);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String line;
			String[] temp;
			
			while (dataRead.hasNextLine())
			{
	      	line = dataRead.nextLine();
	      	line = line.replace("\"", "");
	      	line = line.replace(", ", "");
	      	temp = line.split(",");
	      	ReadHoldingsContext readOwnedEquity = new ReadHoldingsContext(new ReadEquitiesRaw());
	      	
	      	Equity OwnedEquityInfo = (Equity) readOwnedEquity.executeStrategy(temp);
	      	marketEquities.add(OwnedEquityInfo);
	      		
	      		
	      	}
			   
			dataRead.close();
		
		
	}
	
	public Equity getEquity(String tickSymbol){
		
		
		for(int i = 0; i<marketEquities.size(); i++){
			
			if(marketEquities.get(i).getTickSymbol().equals(tickSymbol)){
				
				return marketEquities.get(i);
			}
			
		}
		
		
		return null;
	}
	
	/*****TEST*************/
	public static void main(String[] args){
		
		Market m = new Market();
		m.viewMarketEquities();
		System.out.println(m.getMarketEquities());
		
		
	}
	
}
