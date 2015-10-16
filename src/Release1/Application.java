package Release1;

public class Application {

	public static void main(String[] args) {
		
		ViewSelector vs = new ViewSelector();
		vs.setCurrent(new LoginView());
				
	}
}
