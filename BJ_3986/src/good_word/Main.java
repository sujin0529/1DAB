package good_word;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		Stack<String> stack;
		
		int count = 0;
		
		for(int i=0; i<num; i++) {
			stack = new Stack<>();
			String tmp = sc.nextLine();
			for(int j=0; j<tmp.length(); j++) {
				if(stack.isEmpty()) {
					// ������ ��������� �ֱ�
					stack.push(tmp.charAt(j)+"");
				}
				else if((stack.peek()).equals(tmp.charAt(j)+"") ) {
					// ������ top�� ���� ���ڸ� pop
					stack.pop();
				}
				else {
					// ���� ���� ���̹Ƿ� �ֱ�
					stack.push(tmp.charAt(j)+"");
				}
			}
			if(stack.isEmpty()) {
				// ������ ������� ���� �ܾ�
				count++;
			}
		}
		System.out.println(count);
	}
}