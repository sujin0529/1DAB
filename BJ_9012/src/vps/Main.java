package vps;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test_case = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<test_case; i++) {
			String s = sc.nextLine(); // ��ȣ ���ڿ� �Է�
			Stack<Integer> stack = new Stack<>();
			// �׳� ���� ���� ������ Ȯ���ϸ� �Ǳ� ������ integer�� ��.
			
			int check = 0; // 1�̶�� �߸��� ��
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j)=='(') {
					// ���� ��ȣ��
					stack.push(1);
				}
				else {
					// �ݴ� ��ȣ��
					if(stack.isEmpty()) {
						// �ݴ� ��ȣ�ε� ����ִٸ� �߸��� ��.
						check = 1;
						break;
					}
					stack.pop();
				}
			}
			
			if(check == 1) {
				System.out.println("NO");
			}
			else if(stack.isEmpty()) {
				// check�� 1�� �ƴϸ鼭 ��������� vps
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}

	}

}
