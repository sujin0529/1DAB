package age;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int number = Integer.parseInt(s); // ȸ�� ��
		int age[] = new int[number+1]; // ���� ���� �迭
		String name[] = new String[number+1]; // �̸� ���� �迭
		// sentinel ���� ���� ũ�� 1 ����
		
		for(int i=1; i<number+1; i++) {
			// �Է�
			s = sc.nextLine();
			String token[] = s.split(" ");
			age[i] = Integer.parseInt(token[0]);
			name[i] = token[1];
		}
		
		int min = age[1]; // ���� �ּڰ� ������ ����
		int index = 1;
		
		for(int i=2; i<number+1; i++) {
			// sentinel �� ã��
			if(age[i]<min) {
				// ���� ��쿡�� min ���� �ٲ�. => ���� ��� ���� �տ� �ִ� ��
				min = age[i];
				index = i;
			}
		}
		age[0] = age[index];
		name[0] = name[index];
		// sentinel �� ��ġ
		
		for(int i=1; i<number+1; i++) {
			int j = i-1;
			int _age = age[i];
			String _name = name[i];
			// ��ġ ������ �ε����� ���̿� �̸� ����
			while(_age<age[j]) {	
				age[j+1] = age[j];
				name[j+1] = name[j];
				j--;
			}
			age[j+1] = _age;
			name[j+1] = _name;
		}
		// ���� ���� ����
		
		// ���
		for(int i=1; i<number+1; i++) {
			System.out.println(age[i]+" "+name[i]);
		}
	}
}
