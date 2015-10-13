package Release1;

public class Application {

	public static void main(String[] args){
		
		User me = new User("ask","me");
		Portfolio portfolio = new Portfolio(me);
		
		ViewSelector vs = new ViewSelector(portfolio);
		vs.setCurrent(new LoginView());
		
		
	}
	
}
