
package main;
import java.io.FileWriter;
import java.io.IOException;

import start.ObjectProperty;

public class FileWrite implements Action {
	
	public void execute() {
		FileWriter fw=null;
		try {
			fw=new FileWriter("JapanaseWords.txt",false);
	        			
			{
				int word_count = MainApp.wordTable.size();
				int idx=  0;
				ObjectProperty op = null;
				for (idx = 0; idx < word_count; ++idx)
				{
					op = MainApp.wordTable.get(idx);
								
					String data=op.getWord()+"."+op.getMeaning()+"\r\n";
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



