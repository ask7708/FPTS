package Release1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {

	/**
	 * the user's username
	 */
	private final String username;

	/**
	 * the user's password
	 */
	private String password;
	// might make a char array (for use with JPasswordField)
	// private char[] password;

	/**
	 * the user's first name
	 */
	private String fName;

	/**
	 * the user's last name;
	 */
	private String lName;

	/**
	 * the user's portfolio containing all of his or her's holdings
	 */
	private Portfolio portfolio;

	public User(String name, String password) {

		this.username = name;

		// add certain requirements for password length, strength, etc.
		this.password = password;

		this.portfolio = new Portfolio(this);
	}

	/**
	 * Sets the user's first name to the string being passed in
	 * 
	 * @param first
	 *            the first name
	 */
	protected void setFirstName(String first) {
		this.fName = first;
	}

	/**
	 * Sets the user's last name to the string being passed in
	 * 
	 * @param last
	 *            the last name
	 */
	protected void setLastName(String last) {
		this.lName = last;
	}

	/**
	 * Returns the user's first name
	 * 
	 * @return the user's first name
	 */
	protected String getFirstName() {
		return this.fName;
	}

	/**
	 * Returns the user's last name
	 * 
	 * @return the user's last name
	 */
	protected String getLastName() {
		return this.lName;
	}

	/**
	 * Returns the user's password
	 * 
	 * @return the user's password
	 */
	protected String getPassword() {
		return this.password;
	}

	/**
	 * Changes the user's password
	 * 
	 * @param newPassword
	 *            the new password
	 */
	protected void setPassword(String newPassword) {
		this.password = newPassword;
	}

	/**
	 * Returns the user's username
	 * 
	 * @return the user's username
	 */
	protected String getUsername() {
		return this.username;
	}

	public boolean auth(String username, String password) throws FileNotFoundException {

		File f = new File("users.txt");

		String tempName = "";
		String tempPass = "";

		Scanner numScan = new Scanner(f);
		numScan.useDelimiter(",");

		String line;
		String[] temp;

		while (numScan.hasNextLine()) {
			line = numScan.nextLine();
			temp = line.split(",");
			if (temp[0].equals(username)) {

				if (temp[1].equals(password)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public boolean userExists(String username) throws FileNotFoundException {

		File f = new File("users.txt");

		String tempName = "";

		Scanner numScan = new Scanner(f);
		numScan.useDelimiter(",");

		
		while (numScan.hasNext()) {
			tempName = numScan.next();
			if (tempName.equals(username)) {

				return true;
				
				
				}
			
		}
		return false;
	}
	
	/*
	 * public static void main (String args[]) throws FileNotFoundException{
	 * 
	 * User user = new User("itnks", null); user.setPassword("12345");
	 * 
	 * String username; String password; Scanner input = new Scanner(System.in);
	 * System.out.println("Log in:"); System.out.println("Indtast username: ");
	 * username = input.nextLine();
	 * 
	 * System.out.println("Indtast password: "); password = input.nextLine();
	 * 
	 * 
	 * if (user.auth(username, password)){ System.out.println("go to dashboard"
	 * ); }else{ System.out.println("go to dashboard"); }
	 * 
	 * }
	 */

}
