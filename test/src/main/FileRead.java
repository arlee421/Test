package main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FileRead implements Action{


	public void execute() {
		
		FileInputStream fi=null;
		InputStreamReader isr=null;
		BufferedReader bfr=null;
		StringTokenizer st=null;
		
		try {
			fi=new FileInputStream("JapanaseWords.txt");
			isr=new InputStreamReader(fi);
			bfr=new BufferedReader(isr);
			
			String str=null;
			while((str=bfr.readLine())!=null) {
		
				st=new StringTokenizer(str,".");
				
				String word= st.nextToken();
				String  meaning= st.nextToken();
				WordVO unit=new WordVO(word,meaning);
				addWord(unit);
				}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				fi.close();
				isr.close();
				bfr.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
		private void addWord(WordVO unit) {
			WordVO[]temp=new WordVO[MainApp.unit.length+1];
			for(int i=0;i<MainApp.unit.length;i++)
			{
				temp[i]=MainApp.unit[i];
				
			}
			temp[temp.length-1]=unit;
			MainApp.unit=temp;
		}

}
	

