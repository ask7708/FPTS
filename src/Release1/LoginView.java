package Release1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;

public class LoginView extends JFrame {
   
   /**
    * Creates the login screen that will first be displayed when the
    * application is first started
    */
    private static final long serialVersionUID = 1L;
    private JPanel cardPanel, loginPanel, registerPanel, mainPanel;
    private JLabel dahboardLabel, registerLabel;
    private JButton loginboardButton, registerButton;
    private CardLayout cardLayout = new CardLayout();
   public LoginView() {
	      
	      cardPanel = new JPanel();
	      mainPanel = new JPanel();
	      cardPanel.setLayout(cardLayout);
	      
	      loginPanel = new JPanel();
	      registerPanel = new JPanel();
	    
	      dahboardLabel = new JLabel("");
	      registerLabel = new JLabel("Register");

	      
	      loginPanel.add(dahboardLabel);
	      registerPanel.add(registerLabel);


	      cardPanel.add(loginPanel, "1");
	      cardPanel.add(registerPanel, "2");
	      
	      loginboardButton = new JButton("Login");
	      
	     
 
			JLabel userLabel = new JLabel("User");
			loginPanel.add(userLabel);

			JTextField userText = new JTextField(20);
			loginPanel.add(userText);

			JLabel passwordLabel = new JLabel("Password");
			loginPanel.add(passwordLabel);

			JPasswordField passwordText = new JPasswordField(20);
			loginPanel.add(passwordText);

			JButton loginButton = new JButton("login");
			loginPanel.add(loginButton);
	      
			loginboardButton.addActionListener(new ActionListener() {
	    	  
	          public void actionPerformed(ActionEvent e) {
	              cardLayout.show(cardPanel, "1");
	          }
	      });
	      
	      
	      
	      
	      
	      registerButton = new JButton("Register");
	      registerButton.addActionListener(new ActionListener() {

	          public void actionPerformed(ActionEvent e) {
	              cardLayout.show(cardPanel, "2");
	          }
	      });
	      
	      
	      mainPanel.add(loginboardButton);
	      mainPanel.add(registerButton);
	      add(cardPanel);
	      add(mainPanel, BorderLayout.SOUTH);
	      setSize(600, 600);
   }
   
  public static void main(String[] args) {
   
     LoginView login = new LoginView();
     login.setVisible(true);
  }
  
}
