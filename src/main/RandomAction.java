package main;
import java.util.Random;
import java.util.Scanner;

public class RandomAction implements Action{

	public void execute(Scanner sc) {
		Random ran=new Random();
		WordVO[] unit=WordMain.unit;
		 
		int count = 3;
		for(int i = 0; i< count; ++i)
		{
			int r=ran.nextInt(unit.length);
			
		
			System.out.println("Word:"+unit[r].getWord()+" Meaning:"+unit[r].getMeaning());
		} 
	}
}

