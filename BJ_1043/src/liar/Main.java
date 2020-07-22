package liar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int party = sc.nextInt();
		
		int fact = sc.nextInt();
		Queue<Integer> fact_num = new LinkedList<>(); // ������ ���� ����� ��� ť
		int visited[] = new int[people+1]; // �ߺ��� ������ �ϱ� ���� üũ
		
		for(int i=0; i<fact; i++) {
			// �ʱ⿡ ������ �ƴ� ���
			int tmp = sc.nextInt();
			fact_num.add(tmp);
			visited[tmp] = 1;
		}
		
		int party_num[][] = new int[party][people+2];
		// ������ �̸� ��Ƶΰ�, ũ�⵵ ���� + ����� �̾߱⸦ �� �� �ִ� ��Ƽ���� ǥ��
		for(int i=0; i<party; i++) {
			int attend = sc.nextInt();
			party_num[i][0] = attend; // 0��°�� �� �� ����
			for(int j=1; j<=attend; j++) {
				party_num[i][j] = sc.nextInt();
			}
		}
		
		while(!fact_num.isEmpty()) {
			int fact_person = fact_num.remove();
			for(int i=0; i<party; i++) {
				int count = 0;
				for(int j=1; j<=party_num[i][0]; j++) {
					if(party_num[i][j] == fact_person) {
						// ������ �ƴ� ����� ���Ե� ��Ƽ���, �����ִ� ������� ��� ť�� �߰��� �Ǿ�� ��.
						party_num[i][party_num[i][0]+1] = 1; // ������ ����ؾ��ϴ� ��Ƽ
						count = 1;
						break;
					}
				}
				if(count == 1) {
					for(int j=1; j<=party_num[i][0]; j++) {
						// ��� ť�� �߰��ϴµ�, �ߺ��� �ּ�ȭ�ϱ� ���� ť�� ���� ����鸸 �߰�
						if(visited[party_num[i][j]] == 0) {
							fact_num.add(party_num[i][j]);
							visited[party_num[i][j]] = 1;
						}
					}
				}
					
			}
		}
		
		int count = 0;
		for(int i=0; i<party; i++) {
			int attend = party_num[i][0];
			if(party_num[i][attend+1] == 0) {
				// ����� �̾߱⸦ �� �� �ִ� ��Ƽ��� ��
				count++;
			}
		}
		System.out.println(count);
	}
}