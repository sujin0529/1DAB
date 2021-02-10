import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// [���� 1874] ���� ����
// https://blog.naver.com/tnwls0529/221853287187

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt(); // 1 ~ number����
		
		int sequence[] = new int[number]; // �������� ����
		int made_sequence[] = new int[number]; // ���� ����
		
		ArrayList<String> oper = new ArrayList<>(); // ������ ������ ����Ʈ
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<number; i++) {
			sequence[i] = sc.nextInt();
		}
		// �������ϴ� ���� �Է�
		
		int index = 0; // ���� ���;��ϴ� ������ ���� ���ϱ� ���� �ε���
		for(int i=1; i<=number; i++) {
			
			stack.add(i); // �켱�� push
			oper.add("+");
			
			while(!stack.isEmpty() && sequence[index] == stack.peek()) {
				// ������ �� �� ���̶� ���� ���ȿ�
				made_sequence[index] = stack.pop(); // �ϳ� ��
				oper.add("-");
				index++;
			}
		}
		
		while(!stack.isEmpty()) {
			made_sequence[index] = stack.pop();
			oper.add("-");
			index++;
		}
		
		int check = 0; // ������ �ٸ��� 1
		
		for(int i=0; i<number; i++) {
			if(sequence[i] != made_sequence[i]) {
				check = 1;
				break;
			}
		}
		
		if(check==1) {
			System.out.println("NO");
		}
		else {
			for(int i=0; i<oper.size(); i++) {
				System.out.println(oper.get(i));
			}
		}
	}
}
