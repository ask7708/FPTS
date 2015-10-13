package Release1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;

public class LoginView extends View {

	/**
	 * Creates the login screen that will first be displayed when the
	 * application is first started
	 */
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel, loginPanel, registerPanel, mainPanel;
	private JLabel dahboardLabel;
	private JButton loginboardButton;
	private CardLayout cardLayout = new CardLayout();

	User theUserModel;
	
	public LoginView() {

		cardPanel = new JPanel();
		mainPanel = new JPanel();
		cardPanel.setLayout(cardLayout);

		loginPanel = new JPanel();
		registerPanel = new JPanel();

		cardPanel.add(loginPanel, "1");

		loginboardButton = new JButton("Login");

		JLabel userLabel = new JLabel("User");
		loginPanel.add(userLabel);

		final JTextField userText = new JTextField(20);
		loginPanel.add(userText);
		JLabel passwordLabel = new JLabel("Password");
		loginPanel.add(passwordLabel);
		final JPasswordField passwordText = new JPasswordField(20);
		loginPanel.add(passwordText);
		
		
		
		loginboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "1");
				String tempPassword = new String(passwordText.getPassword());
				String tempName = userText.getText();
				System.out.println(tempName);
				//theUserModel.auth(tempName, tempPassword);
				
			}
		});

		mainPanel.add(loginboardButton);

		this.screen.add(cardPanel);
		this.screen.add(mainPanel, BorderLayout.SOUTH);
		this.screen.setSize(250, 250);
	}

	public static void main(String[] args) {

		LoginView login = new LoginView();
		login.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}