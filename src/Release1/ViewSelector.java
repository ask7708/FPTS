package Release1;

import javax.swing.JFrame;

public class ViewSelector extends JFrame {
   
   private static final long serialVersionUID = 1L;
   private View currentView;
		
	public ViewSelector() {
		
		setSize(800, 800);
		setVisible(true);
	   setTitle("Financial Portfolio Tracking System - Login");

	}
		
	/**
	 * Transitions to a different View object when moving to a different part
	 * of the application 
	 * @param viewType the type of view to transition to
	 * @param data any data that may be necessary for the View
	 */
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
	
	/**
	 * Sets the passed in View object as the current View the application is to use 
	 * @param obj the selected View
	 */
	public void setCurrent(View obj) {
	   
	   this.currentView = obj;
	   this.add(obj.screen);
	   obj.showScreen();
	   this.setVisible(true);
	}
}
