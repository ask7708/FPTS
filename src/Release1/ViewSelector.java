package Release1;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

public class ViewSelector implements Observer {

   /**
    * the view that is currently being displayed
    */
   private View current;
   
   /**
    * Just an idea (don't hesitate to shoot me down if you disagree)
    * a container holding all the previously shown views in a stack
    * I was thinking that if we are done with whatever we need to do on
    * one view, we could just pop it off and have the previous view reappear 
    * by making it the current
    */
   private Stack<View> previousViews;
   
   /**
    * Returns the current View object that is presently being displayed
    * @return the current view
    */
   public View getCurrent() { return this.current; }

   @Override
   public void update(Observable o, Object arg) {
      // TODO Auto-generated method stub
      
   }
}
