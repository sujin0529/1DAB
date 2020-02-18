package robot;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextInt()) {
			// �׽�Ʈ ���̽� ���� ���� ����
			int w = 0;
			int number = 0;
			int check = 0; // �������� Ȯ���ϴ� ����
			
			w = sc.nextInt(); // �ʺ�. ������ͷ� ���߷��� 0 7��
			number = sc.nextInt(); // ����� ����
			
			int block[] = new int[number]; // ��� �Է�
			
			for(int i=0; i<number; i++) {
				block[i] = sc.nextInt();
			}
			
			if(number<2) {
				// ����� ������ 2���� �۴ٸ� ¦�� ���� �� ������ ����
				System.out.println("danger");
				continue;
			}
			
			Arrays.sort(block); // ��� ���̴�� ����
			
			int left = 0;
			int right = number-1;
			// left�� right�� �ε�����.
			
			w = w*10000000; // �ʺ� ���� ������ ���߱�
			
			while(left<right) {
				if(block[left]+block[right] == w) {
					// ���ٸ� ��
					check = 1;
					break;
				}
				else if(block[left]+block[right] < w) {
					// �۾����� left ���� Ű������
					left++;
				}
				else if(block[left]+block[right] > w) {
					right--;
				}
			}
			
			
			// ���
			if(check == 1) {
				System.out.println("yes "+block[left]+" "+block[right]);
			}
			else {
				System.out.println("danger");
			}
			
		}

	}

}
