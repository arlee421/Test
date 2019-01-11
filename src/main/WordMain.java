package main;
import java.util.Scanner;


public class WordMain{
	static WordVO[]unit;
	
	public static void main(String args[]) {
		WordService wordService=new WordService();
		Scanner sc=new Scanner(System.in);
		unit=new WordVO[0];
		FileRead fileRead=new FileRead();
	    WordService.process(fileRead, sc);
//	    AddWord addWord=new AddWord();
//	    WordService.process(addWord, sc);
	    System.out.println("===Today's Words===");
	    RandomAction randomAction=new RandomAction();
	    WordService.process(randomAction, sc);
	    
	   
		boolean isStop=false;
		do {
		System.out.println("====Japanease word Study====");
		System.out.println("1. Whole Words");
		System.out.println("2. Add Words");
		System.out.println("3. Delete Words");
		System.out.println("4. End");
		
		String command=sc.next();
		switch(command) {
		case "1":
			ListAction listAction=new ListAction();
		    WordService.process(listAction, sc);
		    break;
		case "2":
			AddAction writeAction =new AddAction();
			WordService.process(writeAction,sc);
			break;
			
		case "3":	
			DeleteAction deleteAction=new DeleteAction();
			WordService.process(deleteAction, sc);
			break;
			
		case "4":	
		    FileWrite fileWrite=new FileWrite();
		    WordService.process(fileWrite, sc);
			isStop=true;
		}
	}
		while(!isStop);
	}

}