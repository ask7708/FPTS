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
	private JPanel cardPanel, dashPanel, accountPanel, mainPanel, portfolioPanel, holdingsPanel, testPanel;
	private JLabel dahboardLabel, accountLabel, portfolioLabel, holdingsLabel, testLabel;
	private JButton dashboardButton, accountButton, portfolioButton, holdingsButton, testButton;
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
		testPanel = new JPanel();
		
		dahboardLabel = new JLabel("");
		accountLabel = new JLabel("Account Details");
		portfolioLabel = new JLabel("Manage Your Portfolio");
		holdingsLabel = new JLabel("Manage Your Holdings");
		testLabel = new JLabel("this is only test");
		
		dashPanel.add(dahboardLabel);
		accountPanel.add(accountLabel);
		portfolioPanel.add(portfolioLabel);
		holdingsPanel.add(holdingsLabel);
		testPanel.add(testLabel);
		
		
		cardPanel.add(dashPanel, "1");
		cardPanel.add(accountPanel, "2");
		cardPanel.add(portfolioPanel, "3");
		cardPanel.add(holdingsPanel, "4");
		cardPanel.add(testPanel, "5");
		
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
		
		testButton = new JButton("Test Button");

		// helloText.setBounds(150, 50, 80, 25);
		// JButton logoutButton = new JButton("Log Out!");

		testPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		testButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "6");
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
		mainPanel.add(testButton);
		this.screen.add(cardPanel, BorderLayout.NORTH);
		this.screen.add(mainPanel, BorderLayout.SOUTH);
		this.screen.setSize(600, 600);
	}


	
	
	public User getUserAfterLogin(){
		
		return this.someUser;
	}
	

	public void buildJFrame() {
		      
		
		//this.screen.setTitle("FPTS - " + portfolio.getUsername() + " - Home");

		this.someUser = someUser;
		
		cardPanel = new JPanel();
		mainPanel = new JPanel();
		cardPanel.setLayout(cardLayout);

		dashPanel = new JPanel();
		accountPanel = new JPanel();
		portfolioPanel = new JPanel();
		holdingsPanel = new JPanel();
		testPanel = new JPanel();
		
		dahboardLabel = new JLabel("");
		accountLabel = new JLabel("Account Details");
		portfolioLabel = new JLabel("Manage Your Portfolio");
		holdingsLabel = new JLabel("Manage Your Holdings");
		testLabel = new JLabel("this is only test");
		
		dashPanel.add(dahboardLabel);
		accountPanel.add(accountLabel);
		portfolioPanel.add(portfolioLabel);
		holdingsPanel.add(holdingsLabel);
		testPanel.add(testLabel);
		
		
		cardPanel.add(dashPanel, "1");
		cardPanel.add(accountPanel, "2");
		cardPanel.add(portfolioPanel, "3");
		cardPanel.add(holdingsPanel, "4");
		cardPanel.add(testPanel, "5");
		
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
		
		testButton = new JButton("Test Button");

		// helloText.setBounds(150, 50, 80, 25);
		// JButton logoutButton = new JButton("Log Out!");

		testPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		testButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "6");
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
		mainPanel.add(testButton);
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