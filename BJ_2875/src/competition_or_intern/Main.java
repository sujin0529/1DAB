package competition_or_intern;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int female = sc.nextInt(); // ���� ��
		int male = sc.nextInt(); // ���� ��
		int intern = sc.nextInt(); // ���Ͻ� ������ ��
		
		int team = 0;
		
		if(female/2 < male) {
			team = female/2;
		}
		else {
			team = male;
		}
		female = female - (team*2);
		male = male - team;
		
		if(intern <= female+male) {
			// team �״�� ���
		}
		else {
			intern = intern - (female+male);
			int minus = 0;
			if(intern%3==0) {
				// �������� 0�̸� 1���� �� �� �ʿ䰡 ���� ������ 3���� ���� ��ŭ�� team���� ���� ���� �ִ��� ���� �� ����
				minus = intern/3;
			}
			else {
				// 3���� �� ���̱� ������ 3���� ���� �� 1�� ���� ��ŭ�� team���� ���� ���� �ִ��� ���� �� ����
				minus = intern/3 + 1;
			}
			
			team = team - minus;
		}
		System.out.println(team);
	}

}
