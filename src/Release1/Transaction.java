package Release1;
import java.util.Date;

public abstract class Transaction {
	/**
	 * Date - the date and time the transaction was made
	 * cash - the amount being transferred
	 * Receiver - the object that receives the money
	 * transfer - the object that gives the money
	 */
	private Date time;
	private int cash;
	private Object receiver;
	private Object transfer;
	
	/**
	 * 
	 * @param time - time of transaction
	 * @param amount - amount being transferred
	 * @param receiever - the object getting the money
	 * @param transfer - the object giving the money
	 * @throws CashException - not enough money 
	 * 
	 *Builder function of Transaction, uses the receiver and transfer object
	 *to figure out which function to run by finding the instance of the objects
	 *
	 *It also raises exceptions if there isn't enough in the account or equity
	 */
	
	public Transaction(Date time, int amount, Object receiver,Object transfer) throws CashException{
		time = this.time;
		amount = this.cash;
		receiver = this.receiver;
		transfer = this.transfer;
		
		if(transfer instanceof Account){
			if(((Account) transfer).getAmount() < cash){
				throw new CashException();
			}
			
			if(receiver instanceof Equity){
				AccountToEquity();
			}
			else if(receiver instanceof String){
				Withdraw();
			}
			else{
				AccountToAccount();
			}
		}
		else if(transfer instanceof String){
			Deposit();
		}
		else{
			Equity transfers = (Equity) transfer;
			double total = transfers.getAcquiredShares() * transfers.getSharePrice();
			if(total < cash){
				throw new CashException();
			}
			EquityToAccount();
		}
		
	}
	
	/**
	 * returns the time of transaction
	 */
	public Date getTime(){
		return time;
	}
	
	/**
	 * returns the amount being transferred
	 */
	
	public int getAmount(){
		return cash;
	}
	
	/**
	 * returns the object that receives the money
	 */
	public Object getReceiver(){
		return receiver;
	}
	
	/**
	 * returns the object that transfers the money
	 */
	public Object getTransfer(){
		return transfer;
	}
	
	/**
	 * takes the objects and makes sure that the monetary changes occur between
	 * account and Equity
	 */
	public void AccountToEquity(){
		Account transfers = (Account) transfer; //Transfers is the Account version of transfer
		Equity receivers = (Equity) receiver; //Receivers is the Equity version of Receiver
		double remainder = cash%receivers.getSharePrice();
		double total = cash/receivers.getSharePrice();
		transfers.setAmount((transfers.getAmount() - (total*receivers.getSharePrice()) + remainder));
		receivers.setAcquiredShares((int) (receivers.getAcquiredShares() + total));
		transfer = transfers;
		receiver = receivers;
		
	}
	
	/**
	 * takes the objects and makes sure that the monetary changes occur between
	 * Equity and Account
	 */
	public void EquityToAccount(){
		Equity transfers = (Equity) transfer; //transfers is the Equity version of transfer
		Account receivers = (Account) receiver; //receivers is the Account version of receiver
		int total = (int) (cash/transfers.getSharePrice());
		transfers.setAcquiredShares(transfers.getAcquiredShares() - total);
		receivers.setAmount(getAmount() + (total*transfers.getSharePrice()));
		transfer = transfers;
		receiver = receivers;
		
	}
	
	/**
	 * takes the objects and makes sure that the monetary changes occur
	 * between Equity and Account
	 */
	public void AccountToAccount(){
		Account transfers = (Account) transfer; //transfers is the account version of transfer
		Account recivers = (Account) receiver; //receivers is the account version of receivers
		recivers.setAmount(recivers.getAmount() + cash);
		transfers.setAmount(recivers.getAmount() - cash);
		transfer = transfers;
		receiver = recivers;
		
		
	}
	
	/**
	 * takes the objects and makes sure that the monetary changes occur between
	 * the account and user
	 */
	public void Withdraw(){
		Account transfers = (Account) transfer; //transfers is the account version of transfer
		transfers.setAmount(transfers.getAmount() - cash);
		transfer = transfers;
	}
	
	/**
	 * takes the objects and makes sure that the monetary changes occur between
	 * the user and account
	 */
	public void Deposit(){
		Account recivers = (Account) receiver; //receivers is the account version of receiver
		recivers.setAmount(recivers.getAmount() + cash);
		receiver = recivers;
	}
	

}