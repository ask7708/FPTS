package Release1;
import java.util.Date;

public abstract class Transaction {
	/**
	 * the date and time the transaction was made
	 */
	private Date time;
	private int cash;
	private Object reciever;
	private Object transfer;
	
	public Transaction(Date time, int amount, Object reciever,Object transfer) throws CashException{
		time = this.time;
		amount = this.cash;
		reciever = this.reciever;
		transfer = this.transfer;
		
		if(transfer instanceof Account){
			if(((Account) transfer).getAmount() < cash){
				throw new CashException();
			}
			if(reciever instanceof Equity){
				AccountToEquity();
			}
			else{
				AccountToAccount();
			}
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
	
	public Date getTime(){
		return time;
	}
	
	public int getAmount(){
		return cash;
	}
	
	public Object getReciever(){
		return reciever;
	}
	
	public Object getTransfer(){
		return transfer;
	}
	
	public void AccountToEquity(){
		Account transfers = (Account) transfer;
		Equity recievers = (Equity) reciever;
		double remainder = cash%recievers.getSharePrice();
		double total = cash/recievers.getSharePrice();
		transfers.setAmount((transfers.getAmount() - (total*recievers.getSharePrice()) + remainder));
		recievers.setAcquiredShares((int) (recievers.getAcquiredShares() + total));
		transfer = transfers;
		reciever = recievers;
		
	}
	
	public void EquityToAccount(){
		Equity transfers = (Equity) transfer;
		Account recievers = (Account) reciever;
		int total = (int) (cash/transfers.getSharePrice());
		transfers.setAcquiredShares(transfers.getAcquiredShares() - total);
		recievers.setAmount(getAmount() + (total*transfers.getSharePrice()));
		transfer = transfers;
		reciever = recievers;
		
	}
	
	public void AccountToAccount(){
		Account transfers = (Account) transfer;
		Account recievers = (Account) reciever;
		recievers.setAmount(recievers.getAmount() + cash);
		transfers.setAmount(recievers.getAmount() - cash);
		transfer = transfers;
		reciever = recievers;
		
		
	}
	

}