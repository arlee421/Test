package main;
import java.util.Scanner;

public class DeleteAction implements Action{
	public void execute(Scanner sc) {
		System.out.println("Input deleting words");
		System.out.println("Word:");
		String word=sc.next();
		deleteWord(word);
	}
	private void deleteWord(String word) {
		int deleteIndex=-1;
		WordVO[]unit=WordMain.unit;
		WordVO[]temp=null;
		for(int i=0;i<unit.length;i++)
		{
			if(unit[i].getWord().equals(word)) {
				deleteIndex=i;
			}
		}
			if(deleteIndex==-1) {
				System.out.println("No exist Word Information");
				return;
			}
		if(unit.length>=1) {
			temp= new WordVO[unit.length-1];
			for(int i=0;i<unit.length;i++)
			{
				if(i==deleteIndex) {
					continue;
				}
				else if(i>deleteIndex) {
					temp[i-1]=unit[i];
				}
					temp[i]=unit[i];
			}
		}
		WordMain.unit=temp;
	}
}
