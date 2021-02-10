import java.util.Scanner;
import java.util.Stack;

// [���� 4949] �������� ����
// https://blog.naver.com/tnwls0529/221851825703

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		while(!s.equals(".")) {
			int check = 0; // 1�̸� no
			Stack<Integer> stack = new Stack<>();
			
			for(int i=0; i<s.length(); i++) {
				char ch = s.charAt(i);
				if(ch == '(') {
					stack.push(0); // �Ұ�ȣ�� 0
				}
				else if(ch == ')') {
					
					if(stack.isEmpty() || stack.peek()!=0) {
						// ������ ����ְų�, ���� ����� ��ȣ�� (�� �ƴ϶��
						check = 1;
					}
					else {
						// �װ� �ƴ϶�� �ϳ� ���ֱ�
						stack.pop();
					}	
				}
				else if(ch == '[') {
					stack.push(1); // ���ȣ�� 1
				}
				else if(ch == ']') {
					if(stack.isEmpty() || stack.peek()!=1) {
						// ������ ����ְų�, ���� ����� ��ȣ�� [�� �ƴ϶��
						check = 1;
					}
					else {
						// �װ� �ƴ϶�� �ϳ� ���ֱ�
						stack.pop();
					}
				}
			}
			
			if(check == 1 || !stack.isEmpty()) {
				System.out.println("no");
			}
			else {
				System.out.println("yes");
			}
			s = sc.nextLine();
			
		}

	}

}
