package Release1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends View {

	private static final long serialVersionUID = 1L;
	private JPanel cardPanel, loginPanel, registerPanel, mainPanel;
	private JLabel dahboardLabel;
	private JButton loginboardButton;
	private JButton registerButton;
	private CardLayout cardLayout = new CardLayout();

	
	User theUserModel;
	ViewSelector theViewSelector;
	private boolean userExists = false;
	
	private JTextField userText = new JTextField(20);
	final JPasswordField passwordText = new JPasswordField(20);
	
	
	/**
	 * Creates the login screen that will first be displayed when the
	 * application is first started. The user will have the option
	 * of register or logging in to the system. If the user doesn't exist
	 * and register they will be added otherwise prompted to try again.
	 */
	public LoginView() {

		/* Creates the different panel that are stacked on eachother*/
		cardPanel = new JPanel();
		mainPanel = new JPanel();
		cardPanel.setLayout(cardLayout);
		loginPanel = new JPanel();
		registerPanel = new JPanel();

		/*Add the card panel to the layout */
		cardPanel.add(loginPanel, "1");

		/* Creates the two button to be used in the login view i.e. register and login*/
		loginboardButton = new JButton("Login");
		registerButton = new JButton("Register");

		JLabel userLabel = new JLabel("User");
		loginPanel.add(userLabel);

		
		loginPanel.add(userText);
		JLabel passwordLabel = new JLabel("Password");
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordText);

		/**
		 * Checks for user authentication and logs them into the system
		 * if they exist otherwise prompts to try again.
		 */
		loginboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "1");
				String tempPassword = new String(passwordText.getPassword());
				String tempName = userText.getText();
				theUserModel = new User(tempName, tempPassword);
				try {
					if (theUserModel.auth(tempName, tempPassword) == true) {

						userExists = true;

						/**
						 * If port == exist ---> find portfolio if port != exist
						 * ---> create new text file for that user
						 * 
						 * 
						 * 
						 */
						System.out.println(tempName);
						User existingUser = new User(tempName, tempPassword);
						//DashboardView dv = new DashboardView(portObj);
					   Container c = loginboardButton;
						
						   while(c.getParent() != null)
						       c = c.getParent();
						
						   System.out.println("FOUND PARENT");
						   ViewSelector vs = (ViewSelector)c;
						   vs.makeTransition("", existingUser);

					}else{
						
						JOptionPane.showMessageDialog(null,
								"The username and password combination are incorrect. Please close this window and try again.");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		/**
		 * Checks to see if the user exists and if they don't
		 * they get the permission to be added into the system.
		 */
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "1");
				String tempPassword = new String(passwordText.getPassword());
				String tempName = userText.getText();
				theUserModel = new User(tempName, tempPassword);
				File file = new File("users.txt");
				if (file.exists()) {
				}
				try {
					if (theUserModel.userExists(tempName) == false) {
						PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.txt", true)));
						out.println(tempName + "," + tempPassword);
						out.close();
						JOptionPane.showMessageDialog(null,
								"Your account has been created. Please login with your new credentials.");
					} else {

						JOptionPane.showMessageDialog(null,
								"Username already exists. Please cancel out of this window and try again.");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}

			}
		});

		mainPanel.add(loginboardButton);
		mainPanel.add(registerButton);

		this.screen.add(cardPanel);
		this.screen.add(mainPanel, BorderLayout.SOUTH);
		this.screen.setSize(250, 250);
	}

	
	public String getEnteredUserName(){
		
		
		return userText.getText();
	}
	
	public String getEnteredPassword(){
		
		return new String(passwordText.getPassword());

	}
	

   @Override
   public void update(Observable o, Object arg) {
      // TODO Auto-generated method stub
      
   }

   @Override
   /**
    * Retrieves any relevant data passed to this View by
    * ViewSelector and takes it in as necessary
    */
   public void getData(Object sim) {
      // TODO Auto-generated method stub
      
   }

}