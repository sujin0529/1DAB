package history;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // ����� ����
		int relation = sc.nextInt(); // ����� ���� ���� ��
		
		int history[][] = new int[num+1][num+1];
		
		for(int i=0; i<relation; i++) {
			int front = sc.nextInt(); // ���� �Ͼ ���
			int rear = sc.nextInt(); // �Ŀ� �Ͼ ���
			history[front][rear] = 1;
		}
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num; j++) {
				for(int k=1; k<=num; k++) {
					if(history[i][k] == 1 && history[k][j] == 1) {
						history[i][j] = 1;
					}
					if(history[num-i+1][k] == 1 && history[k][num-j+1] == 1) {
						history[num-i+1][num-j+1] = 1;
					}
				}
			}
		}
		
		int question = sc.nextInt(); // ���� ���踦 �˰� ���� ��� ���� ��
		for(int i=0; i<question; i++) {
			int front = sc.nextInt();
			int rear = sc.nextInt();
			
			if(history[front][rear] == 1) {
				// �տ� �ִ� ����� ���� �Ͼ
				System.out.println(-1);
			}
			else if(history[rear][front] == 1) {
				// �ڿ� �ִ� ����� ���� �Ͼ
				System.out.println(1);
			}
			else {
				// ������ �� ����
				System.out.println(0);
			}
		}
	}
}