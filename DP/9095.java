import java.util.Scanner;

// [���� 9095] 1, 2, 3 ���ϱ�
// https://blog.naver.com/tnwls0529/221835698479

public class Main {
	
	static int adder(int[] num, int index) {
		if(num[index]!=0) {
			// ������� ������ ���� �� �״�� ��ȯ
			return num[index];
		}
		else if(index == 1) {
			return 1;
		}
		else if(index == 2) {
			return 2;
		}
		else if(index == 3) {
			return 4;
		}
		else {
			return (num[index] = adder(num, index-1)+adder(num, index-2)+adder(num, index-3));
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		int [] integer = new int[11]; // 11�̸�
		
		for(int i=0; i<test_case; i++) {
			int number = sc.nextInt();
			System.out.println(adder(integer, number));
		}

	}

}
