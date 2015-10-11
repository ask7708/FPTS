package Release1;
import java.util.Date;

public abstract class Transaction {

	/**
	 * the date and time the transaction was made
	 */
	private Date time;
	private int amount;
	private Object reciever;
	private Object transfer;
	
	public Transaction(Date time, int amount, Object reciever,Object transfer){
		time = this.time;
		amount = this.amount;
		reciever = this.reciever;
		transfer = this.transfer;
		
	}
	
	public Date getTime(){
		return time;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public Object getReciever(){
		return reciever;
	}
	
	public Object getTransfer(){
		return transfer;
	}
	

}