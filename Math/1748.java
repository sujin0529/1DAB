import java.util.Scanner;

// [���� 1748] �� �̾� ���� 1
// https://blog.naver.com/tnwls0529/222065055807

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); // number���� �̾ �� ��
		int init = 9; // �ʱ� ���� ��
	
		int new_number = 0;
		int expr = 0; // ������
		
		while(number >= init) {
			
			int change = 9*(int)Math.pow((double)10, (double)expr); // �ڸ����� �޶����� �� �� ���� ����
			
			new_number += ((expr+1)*change);

			init = (init*10)+9;
			expr++;
		}
		
		init /= 10;
		// ������ �� init���ٴ� ������, ���� �� init���ٴ� ū ��� ���� �ڸ����� �� ����.
		
		if((number-init) > 0) {
			new_number += ((expr+1)*(number-init));
		}
		
		System.out.println(new_number);
		

	}

}
