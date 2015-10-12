package Release1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Login {
	
	public static void main(String[] args) throws FileNotFoundException{
		
	   // Scanner input = new Scanner(System.in);
		//String contents = FileUtils.readFileToString(new File("path/to/your/file.txt"));


 
        String name = "itnks,12345";
        String pass = "12345";
        
        File f = new File("users.txt");
        Scanner numScan = new Scanner(f);
         
        String line;
         
        while (numScan.hasNext())
        {
            line = numScan.next();
            System.out.print(line);
         
            }
        }
		

}}
