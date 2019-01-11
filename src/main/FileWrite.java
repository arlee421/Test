
package main;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileWrite implements Action {

	public void execute(Scanner sc) {
		FileWriter fw=null;
		try {
			fw=new FileWriter("JapanaseWords.txt",false);
	        WordVO[]unit=WordMain.unit;
	        if(unit.length>=1) {
	        	for(int i=0;i<unit.length;i++)
	        		{
			   String data = unit[i].getWord()+","+unit[i].getMeaning()+"\r\n";
			   fw.write(data);
	        		}
	        	}
			}	
	catch(IOException e) {
		e.printStackTrace();
	}
	finally {
		try {
			fw.close();
			}
		catch(IOException e) {
			e.printStackTrace();
			}
		}
	}	
}


