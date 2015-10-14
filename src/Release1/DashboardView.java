package Release1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DashboardView extends View {

	
	/**
	 * Creates the application's dashboard view
	 * 
	 * @param portfolio
	 *            the user's portfolio
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel, dashPanel, accountPanel, mainPanel, portfolioPanel, holdingsPanel;
	private JLabel dahboardLabel, accountLabel, portfolioLabel, holdingsLabel, addHoldingsLabel;
	private JButton dashboardButton, accountButton, portfolioButton, holdingsButton, addHoldingsButton;
	private CardLayout cardLayout = new CardLayout();

	private User someUser;
	private Portfolio portfolio;
	
	public DashboardView() {
	   
	   super(); 
	   buildJFrame();
	}
	
	public DashboardView(User someUser) {

		super();

		//this.screen.setTitle("FPTS - " + portfolio.getUsername() + " - Home");

		this.someUser = someUser;
		
		cardPanel = new JPanel();
		mainPanel = new JPanel();
		cardPanel.setLayout(cardLayout);

		dashPanel = new JPanel();
		accountPanel = new JPanel();
		portfolioPanel = new JPanel();
		holdingsPanel = new JPanel();
		

		dahboardLabel = new JLabel("");
		accountLabel = new JLabel("Account Details");
		portfolioLabel = new JLabel("Manage Your Portfolio");
		holdingsLabel = new JLabel("Manage Your Holdings");
		addHoldingsLabel = new JLabel("Add Equities");

		dashPanel.add(dahboardLabel);
		accountPanel.add(accountLabel);
		portfolioPanel.add(portfolioLabel);
		holdingsPanel.add(holdingsLabel);

		cardPanel.add(dashPanel, "1");
		cardPanel.add(accountPanel, "2");
		cardPanel.add(portfolioPanel, "3");
		cardPanel.add(holdingsPanel, "4");

		dashboardButton = new JButton("Dash Board");

		// helloText.setBounds(150, 50, 80, 25);
		// JButton logoutButton = new JButton("Log Out!");

		dashPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		dashboardButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "1");
			}
		});
		accountButton = new JButton("View Your Account");
		accountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "2");
			}
		});

		portfolioButton = new JButton("View Your Portfolio");
		portfolioButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "3");
				Portfolio portObj = new Portfolio(getUserAfterLogin());
				portObj.viewPortfolio(); /*Show text file of portfolio to user*/

			}
		});
		

		holdingsButton = new JButton("Manage Your Holding");
		holdingsButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "4");
				/**
				 * Show the list of holdings the user currently has
				 * 
				 */

			}
		});

		/**
		 * Date date = new Date(; SimpleDateFormat sdf = new SimpleDateFormat(
		 * "yyyy/MM/dd HH:mm"); JLabel dateNow = new JLabel(sdf.format(date));
		 * mainPanel.add(dateNow);
		 **/

		mainPanel.add(dashboardButton);
		mainPanel.add(accountButton);
		mainPanel.add(portfolioButton);
		mainPanel.add(holdingsButton);
		this.screen.add(cardPanel, BorderLayout.NORTH);
		this.screen.add(mainPanel, BorderLayout.SOUTH);
		this.screen.setSize(600, 600);
	}


	
	
	public User getUserAfterLogin(){
		
		return this.someUser;
	}
	

	public void buildJFrame() {
		      
	      cardPanel = new JPanel();
	      mainPanel = new JPanel();
	      cardPanel.setLayout(cardLayout);

	      dashPanel = new JPanel();
	      accountPanel = new JPanel();
	      portfolioPanel = new JPanel();
	      holdingsPanel = new JPanel();

	      
	      dahboardLabel = new JLabel("");
	      accountLabel = new JLabel("Account Details");
	      portfolioLabel = new JLabel("Manage Your Portfolio");
	      holdingsLabel = new JLabel("Manage Your Holdings");
	      addHoldingsLabel = new JLabel("Add equity");
	      
	      dashPanel.add(dahboardLabel);
	      accountPanel.add(accountLabel);
	      portfolioPanel.add(portfolioLabel);
	      holdingsPanel.add(holdingsLabel);
	      
	      
	      cardPanel.add(dashPanel, "1");
	      cardPanel.add(accountPanel, "2");
	      cardPanel.add(portfolioPanel, "3");
	      cardPanel.add(holdingsPanel, "4");

	      dashboardButton = new JButton("Dash Board");

	      // helloText.setBounds(150, 50, 80, 25);
	      // JButton logoutButton = new JButton("Log Out!");

	      dashPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	      dashboardButton.addActionListener(new ActionListener() {

	         public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "1");
	         }
	      });
	      accountButton = new JButton("View Your Account");
	      accountButton.addActionListener(new ActionListener() {

	         public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "2");
	         }
	      });

	      portfolioButton = new JButton("View Your Portfolio");
	      portfolioButton.addActionListener(new ActionListener() {

	         public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "3");
	            Portfolio portObj = new Portfolio(getUserAfterLogin());
	            portObj.viewPortfolio(); /*Show text file of portfolio to user*/

	         }
	      });
	      

	      holdingsButton = new JButton("Manage Your Holding");
	      holdingsButton.addActionListener(new ActionListener() {

	         public void actionPerformed(ActionEvent e) {
	            cardLayout.show(cardPanel, "4");
	            /**
	             * Show the list of holdings the user currently has
	             * 
	             */

	         }
	      });


	      addHoldingsButton = new JButton("Add an equity");
	      addHoldingsButton.addActionListener(new ActionListener() {

	         public void actionPerformed(ActionEvent e) {
	            
	        	 int selectedOption = JOptionPane.showConfirmDialog(null, 
                         "Is your holding purchased from FPTS?", 
                         "Choose", 
                         JOptionPane.YES_NO_OPTION); 
	        	if(selectedOption == JOptionPane.NO_OPTION){
	        		
	        		WriteFile wf = new WriteFile();
	        		
	        		
	        	}else{
	        		
	        		JOptionPane.showMessageDialog(null,"The system does not currently support this Feature.");
	        	}
	        	 

	         }
	      });
	      
	      /**
	       * Date date = new Date(; SimpleDateFormat sdf = new SimpleDateFormat(
	       * "yyyy/MM/dd HH:mm"); JLabel dateNow = new JLabel(sdf.format(date));
	       * mainPanel.add(dateNow);
	       **/

	      mainPanel.add(dashboardButton);
	      mainPanel.add(accountButton);
	      mainPanel.add(portfolioButton);
	      mainPanel.add(holdingsButton);
	      mainPanel.add(addHoldingsButton);
	      this.screen.add(cardPanel, BorderLayout.NORTH);
	      this.screen.add(mainPanel, BorderLayout.SOUTH);
	      this.screen.setSize(600, 600);   
	}
	
   @Override
   public void update(Observable o, Object arg) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void getData(Object sim) {
      
      if(sim instanceof User){
         
         User usr = (User) sim;
         this.someUser = usr;
      }
      
      // if we need to send both the user object and the portfolio?
      else if(sim instanceof ArrayList){
         
         ArrayList<Object> objects = (ArrayList<Object>) sim;
         User usr = (User) objects.get(0);
         Portfolio p = (Portfolio) objects.get(1);
         
         this.someUser = usr;
         this.portfolio = p;
      }
      
      else {
         Portfolio pv = (Portfolio) sim;
         this.portfolio = pv;
      //this.
      }
      
   }
}