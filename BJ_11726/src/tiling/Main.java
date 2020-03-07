package tiling;

import java.util.Scanner;

public class Main {
	
	static void tiling(int tile[], int n) {
		if(n==1) {
			tile[1] = 1;
		}
		else if(n==2) {
			tile[2] = 2;
		}
		else {
			if(tile[n]==0) {
				// �Է¹��� �� �ƴ϶��
				tiling(tile, n-1);
				tiling(tile, n-2);
				tile[n] = (tile[n-1] + tile[n-2])%10007;
				
				/* ��¿��� 10007�� ���� �������� ����϶�� �߱� ������,
				 * n�� �����ϱ� ����, ������ ������ ������ ��, �����Ѵ�. */
				 
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 2*n���� n �Է¹���
		int tile[] = new int[n+1]; // n���� Ÿ�ϸ� ����� ������ �迭
		tiling(tile, n);
		System.out.println(tile[n]);
		

	}

}
