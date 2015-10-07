package Release1;

import javax.swing.JFrame;

public abstract class View {

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
   public View() { }
   
}
