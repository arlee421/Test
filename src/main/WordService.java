package main;
import java.util.Scanner;
//��û�� ���� process�޼ҵ忡�� execute�޼ҵ带 ȣ���Ͽ� �� ��û�� ó���ϴ� ������ �����Ǿ� �ִ� action class����
//execute �޼ҵ尡 ȣ��Ǹ鼭 ��û ó���� ��. 
public class WordService {
	public static Object process;

	static void process(Action action,Scanner sc) {
		action.execute(sc);
	}
}
