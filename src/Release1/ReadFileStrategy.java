package Release1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReadFileStrategy {

	public ReadFileStrategy(){
		
	}
	
	public Transaction TransactionRead(String[] temp, ArrayList<Equity> EquityData, ArrayList<Account> AccountData){
		Transaction transfers = null;
		if(temp.length == 8 ){
			int sharesPurchused = Integer.parseInt(temp[4]);
			double ShareValue = Double.parseDouble(temp[3]);
			String Ticker = temp[1];
			int RoutingNo = Integer.parseInt(temp[6]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate temp5 = LocalDate.parse(temp[5], formatter);
			Equity EquityTransaction = null;
			Account AccountTransaction = null;
			for(int x = 0; x >= EquityData.size(); x++){
				if(EquityData.get(x).getTickSymbol() == Ticker){
					EquityTransaction = EquityData.get(x);
				}
			}
			for(int y = 0; y >= AccountData.size(); y++){
				if(AccountData.get(y).getRoutingnum() == RoutingNo){
					AccountTransaction = AccountData.get(y);
				}
				
			}
			if(sharesPurchused > 0){
				Transaction transfer = new Transaction(temp5, (ShareValue*sharesPurchused), EquityTransaction, AccountTransaction);
				transfers = transfer;
			}
			else{
				Transaction transfer = new Transaction(temp5, (-ShareValue*sharesPurchused), AccountTransaction, AccountTransaction);
				transfers = transfer;
			}
		}
		else if(temp.length == 5){
			int num1 = Integer.parseInt(temp[1]);
			int num2 = Integer.parseInt(temp[2]);
			int amount = Integer.parseInt(temp[3]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate Time = LocalDate.parse(temp[5], formatter);
			Account AccountTransaction1 = null;
			Account AccountTransaction2 = null;
			
			for(int x = 0; x >= AccountData.size(); x++){
				if(AccountData.get(x).getRoutingnum() == num1){
					AccountTransaction1 = AccountData.get(x);
				}
			}
			for(int y = 0; y >= AccountData.size(); y++){
				if(AccountData.get(y).getRoutingnum() == num2){
					AccountTransaction2 = AccountData.get(y);
				}
				
			}
			Transaction transfer = new Transaction(Time, amount, AccountTransaction2, AccountTransaction1);
			transfers = transfer;
		}
		else{
			int num1 = Integer.parseInt(temp[1]);
			int amount = Integer.parseInt(temp[3]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate Time = LocalDate.parse(temp[5], formatter);
			Account AccountTransaction1 = null;
			
			for(int x = 0; x >= AccountData.size(); x++){
				if(AccountData.get(x).getRoutingnum() == num1){
					AccountTransaction1 = AccountData.get(x);
				}
			}
			if(amount < 0){
				Transaction transfer = new Transaction(Time, amount, "User", AccountTransaction1);
				transfers = transfer;
			}
			else{
				Transaction transfer = new Transaction(Time, amount, AccountTransaction1, "User");
				transfers = transfer;
			}
		}
		return transfers;
	}
	
	public Equity EquityRead(String[] temp){
		double temp2 = Double.parseDouble(temp[2]);
		Equity EquityInfo = new Equity(temp[0], temp[1], temp2);
		for(int x = 3; x < temp.length; x++){
			EquityInfo.addIndexOrSec(temp[x]);
		}
		return EquityInfo;
	}
	
	public Equity OwnedEquityRead(String[] temp){
		String temp1 = temp[1];
		String temp2 = temp[2];
		double temp3 = Double.parseDouble(temp[3]);
		int temp4 = Integer.parseInt(temp[4]);
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
	
	public Account AccountRead(String[] temp){
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
