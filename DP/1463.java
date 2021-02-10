import java.util.Scanner;

// [���� 1463] 1�� �����
// https://blog.naver.com/tnwls0529/221833770207

public class Main {
	
	static void make_number(int[] cnt, int number) {
		
		if(number%3==0) {
			// 3���� ������ ������
			cnt[number] = cnt[number/3]+1<cnt[number] ? cnt[number/3]+1 : cnt[number];
		}
		if(number%2==0) {
			// 2���� ������ ������
			cnt[number] = cnt[number/2]+1<cnt[number] ? cnt[number/2]+1 : cnt[number];
		}
		
		// 1�� ���� �� �� �پ�� ���� �����Ƿ� Ȯ��
		cnt[number] = cnt[number-1]+1<cnt[number] ? cnt[number-1]+1 : cnt[number];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		int[] cnt = new int[number+3];
		// 1�� �Է����� ���͵� ������ ����� �ʵ��� �ϱ� ���� ũ�� ����.
		
		for(int i=1; i<number+1; i++) {
			cnt[i] = Integer.MAX_VALUE;
			// ���� ���� ã�� ���� �ϱ� ���� �迭 �ʱ�ȭ
		}
		
		cnt[1] = 0;
		cnt[2] = 1;
		cnt[3] = 1;
		
		for(int i=4; i<number+1; i++) {
			make_number(cnt, i);
		}
		
		System.out.println(cnt[number]);
		
		

	}

}
