package gs;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int cityNum = sc.nextInt();
		int distance[] = new int[cityNum-1]; // ���ð� �Ÿ�
		int cost[] = new int[cityNum]; // ������ ���ʹ� ����
		
		for(int i=0; i<cityNum-1; i++) {
			distance[i] = sc.nextInt();
		}
		for(int i=0; i<cityNum; i++) {
			cost[i] = sc.nextInt();
		}
		
		long totalCost = 0;
		int gs = 0; // �鸱 ������
		
		for(int i=0; i<cityNum-1; i++) {
			if(cost[gs] > cost[i]) {
				gs = i;
			}
			totalCost += (long)distance[i] * cost[gs];
		}
		System.out.println(totalCost);
	}
}