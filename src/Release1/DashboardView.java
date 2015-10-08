package Release1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DashboardView extends View {
   
   /**
    * Creates the application's dashboard view 
    * @param portfolio the user's portfolio
    */
   public DashboardView(Portfolio portfolio) {
      
      super();
      
      this.screen.setTitle("FPTS - "+ portfolio.getUsername() +  " - Home");
      
      JPanel top = new JPanel();
  
      JLabel helloText = new JLabel("Hello");
      JLabel firstNameFaild = new JLabel(portfolio.getUserFName());
      JLabel lastNameFalid = new JLabel(portfolio.getUserLName());
      //helloText.setHorizontalAlignment(10);;
      helloText.setBounds(30,40,280,30);
      top.add(helloText);
      top.add(lastNameFalid, BorderLayout.WEST);
      

      
      
      /**
      JPanel center = new JPanel();
      JLabel helloTex = new JLabel("Hello");
      center.add(helloTex);
      **/
      
      this.screen.add(top); 
     // this.screen.add(center);
      screen.setSize(400, 600);

   }
   public static void main(String[] args) {
	   //creat a port
	     User user = new User("itnks", "nasser");
	     user.setFirstName("Talal");
	     user.setLastName("Alsarrani");
	     Portfolio po = new Portfolio(user);
	     DashboardView dash= new DashboardView(po);
	     dash.show();
	   
   }
}
