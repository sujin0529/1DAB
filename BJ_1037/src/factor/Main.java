package factor;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // ����� ����
		int factor[] = new int[N]; // ��� �Է� �ޱ�
		for(int i=0; i<N; i++) {
			factor[i] = sc.nextInt();
		}
		Arrays.sort(factor); // ����
		System.out.println(factor[0]*factor[N-1]);
		// N�� ����� ������ ǥ���� �� �ִµ�, ���� ���� ����� ���� ū ����� ������ ǥ���� �� ����.

	}

}
