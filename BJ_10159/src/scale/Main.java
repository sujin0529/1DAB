package scale;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int object = sc.nextInt();
		int compare = sc.nextInt();
		
		int weight[][] = new int[object+1][object+1];
		
		for(int i=0; i<compare; i++) {
			int _s = sc.nextInt(); // �� ���ſ� ��
			int _l = sc.nextInt(); // �� ������ ��
			weight[_s][_l] = 1;
		}
		
		// �ڽ��� �������� �ְų�, �ڽ����� ���ų� �ϴ� �� ��� vertex�� ���ؼ� ������
		// �ڽ��� ������� ���Ը� �� �� ����.
		
		for(int i=1; i<=object; i++) {
			for(int j=1; j<=object; j++) {
				for(int k=1; k<=object; k++) {
					if(i==j) {
						// �ִ� 100*100 ���� ���� Ƚ�� ����
						break;
					}
					if(weight[i][k] == 1 && weight[k][j] == 1) {
						weight[i][j] = 1; // i�� j���� ���ſ�
					}
					if(weight[object-i+1][k] == 1 && weight[k][object-j+1] == 1) {
						weight[object-i+1][object-j+1] = 1;
					}
				}
			}
		}
		
		for(int i=1; i<=object; i++) {
			int connect = object-1;
			// �켱 ��� �� �� ���ٰ� �����ϰ�, �� �� ���� �� 1�� ���� 
			for(int j=1; j<=object; j++) {
				if(weight[i][j] == 1 || weight[j][i] == 1) {
					// j�� ���ؼ� i�� ���̰ų� �����ٴ�  ���� �� �� ����
					connect--;
				}
			}
			System.out.println(connect);
		}
	}
}