package friend;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		char friend[][] = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String tmp = sc.nextLine();
			for(int j=0; j<N; j++) {
				friend[i][j] = tmp.charAt(j);
			}
		}
		
		int friend_2[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(friend[i][j]=='N') {
					// �ٷ� ����Ǿ� ������ ���� ��
					if(i==j) {
						// ���� ��쿡�� ģ���� �ƴ�
					}
					else {
						for(int k=0; k<N; k++) {
							if(friend[i][k]=='Y' && friend[k][j]=='Y') {
								// ���� �߰��ٸ� ������ �ִٸ�
								friend_2[i][j] = 1;
								friend_2[j][i] = 1;
							}
						}
					}
				}
				else {
					// �ٷ� ����Ǿ� ���� ��
					friend_2[i][j] = 1;
					friend_2[j][i] = 1;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				sum += friend_2[i][j];
			}
			if(max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}