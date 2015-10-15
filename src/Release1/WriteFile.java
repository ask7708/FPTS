package Release1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class WriteFile {
	
	public WriteFile(){
		
	}
	
	public void removeText(String line, File data) throws IOException{
		File inputFile = data;
		File tempFile = new File("myTempFile.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = line;
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.equals(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		boolean successful = tempFile.renameTo(inputFile);
	}
	
	public void writeFileToPortfolio(String line, File data, String userName) throws IOException {

		File fout = data;
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(userName+".txt", true)));
		out.println(line+",");
		out.close();
		
		
	 
		bw.close();
	}
}
