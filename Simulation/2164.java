import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [���� 2164] ī��2
// https://blog.naver.com/tnwls0529/221832080702

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // ��ȣ �Է�
		
		Queue<Integer> card = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			// ť�� 1���� ���������� ����
			card.add(i); 
		}
		
		while(card.size()>1) {
			// size�� 2�̻��� ���̱� ������ 1���� �����ص� ������ �Ȼ��� 
			card.remove(); // �� ���� �ִ� ���� ������
			int back = card.remove(); 
			card.add(back);
			// �� ������ �ִ� ���� ť�� �ٽ� ����
		}
		
		System.out.println(card.remove());
		// �� ���� ���ұ� ������, �̸� �����.

	}

}
