package main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileRead implements Action{


	public void execute(Scanner sc) {
		
		FileInputStream fi=null;
		InputStreamReader isr=null;
		BufferedReader bfr=null;
		StringTokenizer st=null;
		
//		WordVO unit=new WordVO(word,meaning);
		
		try {
			fi=new FileInputStream("JapanaseWords.txt");
			isr=new InputStreamReader(fi);
			bfr=new BufferedReader(isr);
			
			String str=null;
			while((str=bfr.readLine())!=null) {
		
				st=new StringTokenizer(str,",");
				
				String word= st.nextToken();
				String  meaning= st.nextToken();
				WordVO unit=new WordVO(word,meaning);
				addWord2(unit);
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
	
		private void addWord2(WordVO unit) {
			WordVO[]temp=new WordVO[WordMain.unit.length+1];
			for(int i=0;i<WordMain.unit.length;i++)
			{
				temp[i]=WordMain.unit[i];
				
			}
			temp[temp.length-1]=unit;
			WordMain.unit=temp;
		}

	}
	

