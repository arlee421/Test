package main;
import java.util.Scanner;
//요청을 제어 process메소드에서 execute메소드를 호출하여 각 요청을 처리하는 로직이 구현되어 있는 action class들의
//execute 메소드가 호출되면서 요청 처리가 됨. 
public class WordService {
	public static Object process;

	static void process(Action action,Scanner sc) {
		action.execute(sc);
	}
}
