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
   
//	private Portfolio portfolio;
	private View currentView;
//	private PortfolioController portCont;
		
	public ViewSelector() {
		
		setSize(800, 500);
		setVisible(true);
	   setTitle("Financial Portfolio Tracking System - Login");

	}
	
	/*
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
	         setCurrent(new DashboardView());
	         break;
	   }
	}*/
	
//	public void makeTransition(String viewType, User someUser) {
//		   
//
//		   currentView.hideScreen();
//		   
//		   switch(viewType) {
//		   
//		      case "LOGIN":
//		         setCurrent(new LoginView());
//		         break;
//		      case "SIMULATION":
//		         setCurrent(new SimulatorView(new Simulator(portfolio)));
//		         break;
//		      case "REGISTER":
//		         setCurrent(new RegisterView());
//		         break;
//		      default:
//		         setCurrent(new DashboardView(someUser));
//		         break;
//		   }
//		}
	
	public void makeTransition(String viewType, Object data) {
	   
	   currentView.hideScreen();
	    
	   if(viewType.equals("LOGIN")) {
	      
	      LoginView lv = new LoginView();
	      lv.getData(data);
	      setCurrent(lv);
	   }
	   
	   else if(viewType.equals("SIMULATION")) {
	      
	      SimulatorView sv = new SimulatorView();
         this.setTitle("Financial Portfolio Tracking System - Simulation");
         sv.getData(data);
         setCurrent(sv);
	   }
	   
	   else if(viewType.equals("REGISTER")) {
	      
	      RegisterView rv = new RegisterView();
         this.setTitle("Financial Portfolio Tracking System - Register");
         rv.getData(data);
         setCurrent(rv);
	   }
	   
	   else {
	      
         DashboardView dv = new DashboardView();
         this.setTitle("Financial Portfolio Tracking System - Dashboard");
         dv.getData(data);
         setCurrent(dv);
	   }
	}
	
	public void setCurrent(View obj) {
	   
	   this.currentView = obj;
	   this.add(obj.screen);
	   obj.showScreen();
	   this.setVisible(true);
	}
}
