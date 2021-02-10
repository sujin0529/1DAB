import java.util.Scanner;
import java.util.Stack;

// [���� 10773] ����

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt(); // ���� ���� �Է�
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<num; i++) {
			int temp = sc.nextInt();
			if(temp==0) {
				stack.pop(); // 0�� �Է¹����� ����
			}
			else {
				stack.push(temp);
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);

	}

}
