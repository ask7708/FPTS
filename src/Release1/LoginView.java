package Release1;

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
   public LoginView() {
      
      screen.setTitle("FPTS - Login");
      
      JPanel top = new JPanel();
      SpringLayout layout = new SpringLayout();
      top.setLayout(layout);
      
      JTextPane acronym = new JTextPane();
      acronym.setText("FPTS");
      acronym.setOpaque(false);
      acronym.setEditable(false);
      top.add(acronym);
      
      layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, acronym, 0, SpringLayout.HORIZONTAL_CENTER, top);
      
      JTextPane fullName = new JTextPane();
      fullName.setText("Financial Portfolio Tracking System");
      fullName.setOpaque(false);
      fullName.setEditable(false);
      top.add(fullName);
      
      layout.putConstraint(SpringLayout.NORTH, fullName, 10, SpringLayout.SOUTH, acronym);
      layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, fullName, 0, SpringLayout.HORIZONTAL_CENTER, top);
      
      JTextField username = new JTextField("Enter username here...");
      top.add(username);
      
      JPasswordField pswdField = new JPasswordField();
      pswdField.setEchoChar('*');
      top.add(pswdField);
      
      layout.putConstraint(SpringLayout.NORTH, username, 50, SpringLayout.SOUTH, fullName);
      layout.putConstraint(SpringLayout.NORTH, pswdField, 10, SpringLayout.SOUTH, username);

      layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, username, 0, SpringLayout.HORIZONTAL_CENTER, top);
      layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, pswdField, 0, SpringLayout.HORIZONTAL_CENTER, top);


      
      
      screen.add(top);
      screen.setSize(400, 600);
   }
   
  public static void main(String[] args) {
   
     LoginView login = new LoginView();
     login.show();
  }
  
}
