package main;
import java.util.Scanner;

public class ListAction implements Action {

	public void execute(Scanner sc) {
		WordVO[]unit=WordMain.unit;
		if(unit.length>=1) {
			for(int i=0;i<unit.length;i++)
			{
				System.out.println("Word:"+unit[i].getWord()+" Meaning:"+unit[i].getMeaning());
			}
		}
		else {
			System.out.println("No exist Words");
		}
	}
}
