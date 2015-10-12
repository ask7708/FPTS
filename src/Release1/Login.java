package Release1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Login {
	
	
	
	public Login(){
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
	   // Scanner input = new Scanner(System.in);
		//String contents = FileUtils.readFileToString(new File("path/to/your/file.txt"));


 
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
