package sequence_sum;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int number[] = new int[N];
		
		String s = sc.nextLine();
		String tmp[] = s.split(" ");
		
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(tmp[i]);
		}
		
		int max = number[0];
		int sum = max;
		
		for(int i=1; i<N; i++) {
			if(number[i] < 0) {
				// �̹� ���� ������

				if(max < sum) {
					// ���� ���� �� �Ǵٸ�, max ����
					max = sum;	
				}
						
				if(sum < number[i]) {
					// ���� ���� �� ���� �� ũ�ٸ�, ������ �ʰ�, ���� �� �״�� ���
					sum = number[i];
				}
				else if(sum+number[i] > 0){
					sum = sum + number[i]; // ���Ѱ�	
				}
				else {
					// ���� �ƴ϶��, �Է¹��� �� ���� �� �� ���� ���� ������ �ʱ�ȭ
					sum = -1001;
				}
				
			}
			else {
				if(sum < 0) {
					sum = 0;
				}
				sum = sum+number[i];
			}
		}
		
		if(max < sum) {
			// max�� ������ �� �ִٸ� ����
			max =sum;
		}
		
		System.out.println(max);

	}

}
