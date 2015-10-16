package Release1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Login {
		
	public Login(){}
	
	public static void main(String[] args) throws FileNotFoundException{
		 
        String name = "itnks";
        String pass = "12345";
        
        File f = new File("users.txt");
       
        String tempName = "";
        String tempPass = "";
        
        Scanner numScan = new Scanner(f);
        numScan.useDelimiter(",");
         
        String line;
        String[] temp;
        
        while (numScan.hasNextLine())
		{
        	line = numScan.nextLine();
        	temp = line.split(",");
        	if(temp[0].equals(name)){

        			if(temp[1].equals(pass)){
        			System.out.print(line+"\n");
        			}
        	}
		   }
        }
		

}
