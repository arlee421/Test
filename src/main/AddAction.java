package main;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
public class AddAction implements Action{


	public void execute(Scanner sc) {
		System.out.println("Input Word Information");
		System.out.println("Word:");
		String word=sc.next();
		System.out.println("Meaning:");
		String meaning=sc.next();
		
		WordVO unit=new WordVO(word,meaning);
//		String s=word+","+meaning;
		addWord(unit);	
//		fileAppend(s);
	}

	private void addWord(WordVO unit) {

		WordVO[]temp=new WordVO[WordMain.unit.length+1];
	
		for(int i=0;i<WordMain.unit.length;i++)
		{
			temp[i]=WordMain.unit[i];
		}
		temp[temp.length-1]=unit;
		WordMain.unit=temp;	
	}

//	private void fileAppend(String s)
//	{
//		File file = new File("JapanaseWords.txt");
//		  try {
//	            FileWriter fw = new FileWriter(file, true);
//	            fw.write("\r\n");
//	            fw.write(s);
//	            fw.close();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	}
	
}