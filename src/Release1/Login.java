package Release1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Login {
	
	public static void main(String[] args) throws FileNotFoundException{
		
	   // Scanner input = new Scanner(System.in);
		//String contents = FileUtils.readFileToString(new File("path/to/your/file.txt"));


 
        String name = "itnks,12345";
        String pass = "12345";
        String[][] account;
        List<String> where = new ArrayList<String>();
        
        
        
        File f = new File("users.txt");
        Scanner numScan = new Scanner(f);
         
        String line;
         
        while (numScan.hasNext())
        {
            line = numScan.nextLine();
            line.split(",");
            where.add(line);
         }
        String listString="";

        for (String s : where)
        {
            listString += s + ",";
        }
        
        String str = "...";
        List<String> elephantList = Arrays.asList(listString.split(","));
        System.out.println(elephantList);
        String[] names;
        String[] passwords;
        
        for(int i = 0; i < elephantList.length(); i++ ){
        	if((i%2)==0){
        		names.add(elephantList.get(i));
        		
        	}
        }
        
        
                
	}
		

}
