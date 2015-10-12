package Release1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
	/**
	 * EquityData - the arraylist of Equities in the file
	 * TransactionData- the arraylist of Transactions in the file
	 * AccountData - the arraylist of Accounts in the file
	 */
	ArrayList<Equity> EquityData = new ArrayList<Equity>();
	ArrayList<Transaction> TransactionData = new ArrayList<Transaction>();
	ArrayList<Account> AccountData = new ArrayList<Account>();
	
	/**
	 * textName - the name of the file that will be used as the database
	 * 
	 * The constructor takes all the lines from the text file and
	 * then converts them into a respective format and add them into an array
	 */
	public ReadFile(String textName) throws FileNotFoundException{
		File data = new File(textName);
		Scanner dataRead = new Scanner(data);
		
		String line;
		String[] temp;
		
		while (dataRead.hasNextLine())
		{
        	line = dataRead.nextLine();
        	temp = line.split(",");
        	if(temp[0].charAt(0) != '!'){
        		double temp2 = Double.parseDouble(temp[2]);
        		for(int y = 0; y >= EquityData.size(); y++){
        			if(EquityData.get(y).getTickSymbol() == temp[0]){
        				updateEquityPrice(temp2, temp[0]);
        			}
        		}
        		Equity EquityInfo = new Equity(temp[0], temp[1], temp2);
        		for(int x = 3; x >= temp.length; x++){
        			EquityInfo.addIndexOrSec(temp[x]);
        		}
        		EquityData.add(EquityInfo);        		
        		}
        	else{
        		if(temp[0].charAt(1) == 'T'){
        			
        		}
        		else{
        			
        		}
        	}
		   }
		dataRead.close();
	}
	
	/**
	 * 
	 * @param amount - the amount it will be changed too
	 * @param ticker - the ticker equity that will be changed
	 * 
	 * automatically updates the Equity with the most recent price
	 */
	public void updateEquityPrice(double amount, String ticker){
		for(int x = 0; x >= EquityData.size(); x++){
			if(EquityData.get(x).getTickSymbol() == ticker){
				EquityData.get(x).setSharePrice(amount);
			}
		}
		
	}
	/**
	 * 
	 * returns the array of Equities
	 */
	public ArrayList<Equity> getEquity(){
		return EquityData;
	}
	/**
	 * 
	 * routingNum - the number that links to the respective account
	 * returns the Transactions of a specific routingNum
	 */
	public ArrayList<Transaction> getTransaction(int routingNum){
		return TransactionData;
	}
	
	/**
	 * 
	 * @param routingNum - the number that links to the respective account
	 * returns the Accounts of a specific routingNum
	 */
	public ArrayList<Account> getAccount(int routingNum){
		return AccountData;
	}
	
	/**
	 * removes an Equity from the file
	 */
	public void RemoveEquity(){
		
	}
	/**
	 * removes a Transaction from the file
	 */
	public void RemoveTransaction(){
		
	}
	/**
	 * removes an Account from the file
	 */
	public void RemoveAccount(){
		
	}
	
	/**
	 * adds an Equity to the File
	 */
	public void AddEquity(){
		
	}
	/**
	 * adds an Account to the File
	 */
	public void AddAccount(){
		
	}
	/**
	 * Adds a Transaction to the File
	 */
	public void AddTransaction(){
		
	}
	
}