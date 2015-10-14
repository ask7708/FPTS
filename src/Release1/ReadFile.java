package Release1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReadFile {
	/**
	 * EquityData - the arraylist of Equities in the file
	 * TransactionData- the arraylist of Transactions in the file
	 * AccountData - the arraylist of Accounts in the file
	 */
	ArrayList<Equity> EquityData = new ArrayList<Equity>();
	ArrayList<Transaction> TransactionData = new ArrayList<Transaction>();
	ArrayList<Account> AccountData = new ArrayList<Account>();
	ArrayList<Equity> OwnedEquityData = new ArrayList<Equity>();
	
	/**
	 * textName - the name of the file that will be used as the database
	 * 
	 * The constructor takes all the lines from the text file and
	 * then converts them into a respective format and add them into an array
	 */
	public ReadFile(String textName) throws FileNotFoundException{
		//
		File data = new File(textName);
		Scanner dataRead = new Scanner(data);
		
		String line;
		String[] temp;
		
		while (dataRead.hasNextLine())
		{
        	line = dataRead.nextLine();
        	temp = line.split("\",\"");
        	ReadFileStrategy Strategy = new ReadFileStrategy();
        	if(temp[0].charAt(0) != '!'){
        			Equity EquityInfo = Strategy.EquityRead(temp);
        			EquityData.add(EquityInfo);
        		}
        	else{
        		if(temp[0].charAt(1) == 'T'){
        			Transaction TransactionInfo = Strategy.TransactionRead(temp, EquityData,AccountData);
        			TransactionData.add(TransactionInfo);
        		}
        		else if(temp[0].charAt(1) == 'O'){
        			Equity OwnedEquityInfo = Strategy.OwnedEquityRead(temp);
        		}
        		else{
        			Account AccountInfo = Strategy.AccountRead(temp);
        			AccountData.add(AccountInfo);
        		}
        	}
		   }
		dataRead.close();
	}
	/**
	 * 
	 * returns the array of Equities
	 */
	public ArrayList<Equity> getEquities(){
		return EquityData;
	}
	
	public ArrayList<Transaction> getAllTransactions(){
		return TransactionData;
	}
	
	public ArrayList<Account> getAllAccounts(){
		return AccountData;
	}

	public static void main(String[] args){
		
		ReadFile rf;
		try {
			rf = new ReadFile("data.txt");
			System.out.println(rf.getEquities().toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}