package tournament;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int participants = sc.nextInt(); // ��ȸ �������� �� ��
		int Kim = sc.nextInt(); // �������� ��ȣ
		int Lim = sc.nextInt(); // ���Ѽ��� ��ȣ
		
		int round = 1;

		while(participants>1) {
			Kim--;
			Lim--;
			if(Kim/2 == Lim/2) {
				// ���� ���� ���ٸ�
				System.out.println(round);
				System.exit(0);
			}
			Kim = (Kim/2)+1;
			Lim = (Lim/2)+1;
			// ��ȣ ���� �Ҵ�
			round++;
		}
		System.out.println(-1); // ������ ���ϴ� ���̹Ƿ�
		

	}

}
