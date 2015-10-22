package ch.makery.login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JOptionPane;

//import ch.makery.login.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginOverviewController implements Initializable {

	  

	
	public LoginOverviewController() {
		// TODO Auto-generated constructor stub
		

	    
	}
	

	@FXML private TextField usernameText;
	@FXML private PasswordField passwordText;
	private Scanner numScan;

	public boolean userExists(String usernamem, String password) throws FileNotFoundException {

		File f = new File("users.txt");

		numScan = new Scanner(f);
		numScan.useDelimiter(",");
		String line;
		String[] temp;

		while (numScan.hasNextLine()) {
			line = numScan.nextLine();
			temp = line.split(",");
			if (temp[0].equals(usernamem)) {

				if (temp[1].equals(password)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	public void registerHandler(ActionEvent even) throws IOException{
		System.out.println("yes1");
		String tempPassword = passwordText.getText().toString() ;
		String tempName = usernameText.getText().toString();
		User theUserModel = new User(tempName, tempPassword);
		File file = new File("users.txt");
		if (!theUserModel.userExists(tempName)) {
			//System.out.println("there no one with this username " + tempName);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.txt", true)));
			out.println(tempName + "," + tempPassword);
			out.close();
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Information Dialog");
    		alert.setContentText("you have registered successfully!/n Now,hit the login button.");
    		alert.showAndWait();
			
		}else{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Information Dialog");
    		alert.setContentText("The username is alreay taken");
    		alert.showAndWait();
			System.out.println("there somone with this username " + tempName);
		}
		

	}
	
	
    public void loginHandler(ActionEvent even ) throws FileNotFoundException{
    	System.out.println("again!");
 
    	try{
        	if(userExists(usernameText.getText().toString(),passwordText.getText().toString() ) == true){
        		System.out.println("we got it");
        		Alert alert = new Alert(AlertType.CONFIRMATION);
        		alert.setTitle("Information Dialog");
        		alert.setContentText("It Looks like you are in the system!");
        		alert.showAndWait();
        		
        	}else{
        		Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Information Dialog");
        		alert.setContentText("Invalid Password or Username");
        		alert.showAndWait();
        	System.out.println("we did not get " +  usernameText.getText());
    		
    	}

    	}catch(Exception e){
    		System.out.println(e.toString());
    		
    	}
    	
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    
   
    

}
