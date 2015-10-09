package Release1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
      //helloText.setBounds(150, 50, 80, 25);
      JButton logoutButton = new JButton("Log Out!");
      top.add(helloText);
      top.add(firstNameFaild);
      top.add(lastNameFalid);
      top.add(logoutButton);
      /**********************************************************************/
      Dimension d = new Dimension(100,100);
      JPanel center = new JPanel();
      
      JButton viewAccountButton  = new JButton("View Your Account");
      viewAccountButton.setSize(d);  
      JButton manageHoldingButton = new JButton("Manage Your Holding");
      manageHoldingButton.setSize(d);
      JButton managePortfolioButton = new JButton("Manage Your Portfolio");
      managePortfolioButton.setSize(d);
      center.add(viewAccountButton);
      center.add(manageHoldingButton);
      center.add(managePortfolioButton);
      
      viewAccountButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		    JFrame frame = new JFrame();
		    frame.setVisible(true);
			frame.setSize(400, 600);
		}
    	  
      });
      manageHoldingButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		    JFrame frame = new JFrame();
		    frame.setVisible(true);
			frame.setSize(400, 600);
		}
    	  
      });
      managePortfolioButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		    JFrame frame = new JFrame();
		    frame.setVisible(true);
			frame.setSize(400, 600);
		}
    	  
      });
      
      
      
   
   
    	  
      /***/
      
      /***/
      
      
       
      /**
      JPanel center = new JPanel();
      JLabel helloTex = new JLabel("Hello");
      center.add(helloTex);
      **/
      ////////////////////////////////////////////////////////
      JPanel bottom = new JPanel();
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
      JLabel dateNow = new JLabel(sdf.format(date));
      bottom.add(dateNow);
      ////////////////////////////////////////////////////////
      
      
	  Container pane = screen.getContentPane();
	  pane.add(top, BorderLayout.NORTH);
	  pane.add(center, BorderLayout.CENTER);
	  pane.add(bottom, BorderLayout.SOUTH);
	  
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
