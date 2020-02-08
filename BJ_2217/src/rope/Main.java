package rope;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); // ������ ����
		int[] rope = new int[number];
		for(int i=0; i<number; i++) {
			rope[i] = sc.nextInt(); // ������ �ִ� �߷� �Է�
		}
		
		Arrays.sort(rope); // ������������ ����
		int max_weight = 0; // �ִ� �߷�
		int count = 1; // ���� ����
		
		// ���� ���� ���Ը� ��ƿ �� �ִ� ������ ���ؼ� ������ŭ ���� ���� �ִ� �߷���.
		
		for(int i=number-1; i>=0; i--) {
			// ���������̾����ϱ� �ں���
			if((rope[i]*count)>max_weight) {
				max_weight = rope[i]*count;
			}
			count++;
		}
		System.out.println(max_weight);
	}
}
