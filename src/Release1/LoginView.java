package Release1;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends View {
   
   /**
    * Creates the login screen that will first be displayed when the
    * application is first started
    */
   public LoginView() {
      
      //Font font = new Font
      //super();
      this.screen.setTitle("FPTS - Login");
      
      JPanel top = new JPanel();
      
      JTextField usernameField = new JTextField();
//      usernameField.setFont(Font.SANS_SERIF.);
      JPasswordField pswdField = new JPasswordField();
      
      pswdField.setEchoChar('*');
      top.add(pswdField);
      this.screen.add(top);
      
      screen.setSize(400, 600);
   }
   
  public static void main(String[] args) {
   
     LoginView login = new LoginView();
     login.show();
  }
  
}
