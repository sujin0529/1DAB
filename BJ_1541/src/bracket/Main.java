package bracket;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String temp = sc.nextLine(); // ���� �Է�
		int sum = 0;
		
		if(temp.contains("-")) {
			String[] s = temp.split("\\-"); // - �������� ������
			
			for(int i=0; i<s.length; i++) {
				if(s[i].contains("+")) {
					String[] adder = s[i].split("\\+");
					int add = Integer.parseInt(adder[0]);
					for(int j=1; j<adder.length; j++) {
						add += Integer.parseInt(adder[j]);
					}
					// A+B ���¸� C�� �ϳ� ������ �����
					s[i] = add+""; // ���� ���� ��Ʈ�� ���·� ����� �ٽ� ����
				}
			}
			
			sum = Integer.parseInt(s[0]);
			for(int i=1; i<s.length; i++) {
				sum -= Integer.parseInt(s[i]);
			}
		}
		else if(temp.contains("+")) {
			// ���� -�� �������� �ʰ�, +�� ������ ��
			String[] s = temp.split("\\+"); // - �������� ������
			
			sum = Integer.parseInt(s[0]);
			for(int i=1; i<s.length; i++) {
				sum += Integer.parseInt(s[i]);
			}
			
		}
		else {
			// �ƹ� ���굵 �������� �ʴ´ٸ�
			sum = Integer.parseInt(temp);
		}
		
		
		System.out.println(sum);

	}

}
