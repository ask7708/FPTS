package Release1;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class View  {

   /**
    * the container holding everything (kind of represents the view)
    */
   protected JFrame screen;
   

   
   /**
    * Makes the view appear in the application 
    */
   public void show() { this.screen.setVisible(true); }
   
   /**
    * Hides the view away from the application
    */
   public void hide() { this.screen.setVisible(false); }
   
   // may be necessary to have all views to be set up in a default
   // kind of way (leaving blank for now until we know what should be set
   // for all Views when they are instantiated
   public View() {
      
      this.screen = new JFrame();
   }
   
   public static void main(String args[]){
	   
	   LoginView lg = new LoginView();
	   
	   /****************************/
	   User user = new User("itnks", "nasser");
	   Portfolio po = new Portfolio(user);
	   
	   DashboardView view= new DashboardView(po);
	   
	   boolean isDashboard = false;
	   
	   if(isDashboard==true){
	   lg.setVisible(true);
	   }else{
	   view.setVisible(true);
	   }
	   
	   
	   
   }


   
}
