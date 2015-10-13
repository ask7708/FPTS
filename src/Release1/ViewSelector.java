package Release1;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
import javax.swing.*;

public class ViewSelector extends JFrame {

//   Container c = testButton;
//
//   while(c.getParent() != null)
//       c = c.getParent();
//
//   ViewSelector vs = (ViewSelector)c;
//   vs.makeTransition("REGISTER");
   
	private Portfolio portfolio;
	private View currentView;
		
	public ViewSelector(Portfolio portfolio) {
		
		this.portfolio = portfolio;
	}
	
	public void makeTransition(String viewType) {
	   

	   currentView.hideScreen();
	   
	   switch(viewType) {
	   
	      case "LOGIN":
	         setCurrent(new LoginView());
	         break;
	      case "SIMULATION":
	         setCurrent(new SimulatorView(new Simulator(portfolio)));
	         break;
	      case "REGISTER":
	         setCurrent(new RegisterView());
	         break;
	      default:
	         setCurrent(new DashboardView(portfolio));
	         break;
	   }
	}
	
	public void setCurrent(View obj) {
	   
	   this.currentView = obj;
	   this.add(obj.screen);
	   obj.showScreen();
	   this.setVisible(true);
	}
}
