package factorization;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // ���μ������� ����
		int size = N; // �Ҽ��� �����ϱ� ������, ũ��� �״��
		
		int factorization[] = new int[size+1];
		
		int factor = 2;
		while(N != 1) {
			if(N % factor == 0) {
				N = N/factor;
				factorization[factor]++;
			}
			else {
				factor++;
			}
		}
		
		for(int i=2; i<size+1; i++) {
			
			for(int j=0; j<factorization[i]; j++) {
				System.out.println(i);
			}
		}

	}

}
