import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [���� 1966] ������ ť
// https://blog.naver.com/tnwls0529/221826077179

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt(); // �׽�Ʈ ���̽� ����
		
		for(int i=0; i<test_case; i++) {
			int N = sc.nextInt(); // ������ ����
			int M = sc.nextInt(); // ã���� �ϴ� ������ ���� ť ��ġ
			Queue<Integer> document = new LinkedList<Integer>();
			int importance[] = new int[N]; // �߿䵵 ������ ��
			for(int j=0; j<N; j++) {
				int temp = sc.nextInt(); // ������ �߿䵵 �Է�
				document.add(temp);
				importance[j] = temp;
			}
			// �Է�
			
			Arrays.sort(importance);
			
			int index = N-1; // �߿䵵 �迭���� ����� �ε���
			int count = 0; // ã���� �ϴ� ���� �μ� ����
			
			while(!document.isEmpty()) {
				int temp = document.remove();
				if(temp<importance[index]) {
					document.add(temp);
					if(M==0) {
						// ã���� �ϴ°� ù��°�� �־��� �Ŷ��
						M = document.size()-1; // �� ���� �ε����� �缳��
					}
					else {
						M--;
					}
				}
				else {
					// �μ�
					count++;
					if(M==0) {
						// ã���� �ϴ°� ù��°�� �־��� �Ŷ��
						break;
					}
					else {
						M--; // �μ�Ǵ� ������ �ϳ� ����
						index--; // ���� ū ���� �������Ƿ�, �� ���� �߿䵵�� �����Ѿ� ��.
					}
				}
			}
			System.out.println(count);
		}

	}

}
