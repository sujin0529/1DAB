package staff;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt(); // �������ϴ� ����
		
		int total = 64; // ���� ���� 
		int short_staff = 64; // ���� ª�� ����� ����
		int count = 0; // ������� ����
		// �ʱ� ����
		
		while(total > X) {
			// total�� X���� ���� ���ȿ� �ݺ�
			total -= short_staff; // ���� ª�� ����⸦ �ϳ� ����
			short_staff /= 2; // ������ �ɰ���
			total += short_staff; // �ϳ��� ����
			if(total < X) {
				// ã���� �� ���̺��� ���� ���
				count++; 
				total += short_staff;
				// �� ��쿡�� �ϳ��� �ݵ�� ���ؾ��ϴϱ�
			}
			else if(total == X) {
				// ã���� �� ���̿� ��ġ�ϴ� ���
				count++; // ������ �ɰ� ����� �ϳ��� ������ ���ؾ��ϱ� ����
				break; // �� �̻� ã�� �ʿ䰡 ���� ������ ����
			}
		}
		
		if(X==64) {
			// X�� ���� 64�� ���� ��, count�� 1�� ��.
			count = 1;
		}
		System.out.println(count);

	}

}
