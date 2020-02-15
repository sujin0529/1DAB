package airport;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int gate = sc.nextInt(); // ����Ʈ ��
		int airplane = sc.nextInt(); // ����� ��
		int docking[] = new int[gate+1]; // ����Ʈ ��ȣ�� ���߱� ���ؼ� +1
		
		for(int i=0; i<airplane; i++) {
			int _gate = sc.nextInt();
			int check = 0; // �ִ� �Ϳ� �����ߴ��� �ƴ����� Ȯ��
			for(int j=_gate; j>0; j--) {
				// �ڿ������� Ȯ���ϸ鼭 ��ŷ���� ���� ����Ʈ�� �ִ����� Ȯ���ϱ� ����
				if(docking[j]==0) {
					// ��ŷ���� ���� ����Ʈ
					docking[j] = 1; // ��ŷ
					check = 1; // �ִ� �Ϳ� ����
					break;
				}
			}
			if(check==0) {
				// ���� �ִ� �Ϳ� �������� ���ߴٸ�, �� �̻� ����Ⱑ ��ŷ�� �� �����Ƿ� break
				break;
			}
		}
		
		int count = 0;
		for(int i=1; i<=gate; i++) {
			// ��ŷ�� ������ ������� �� ī��Ʈ
			count += docking[i];
		}
		
		System.out.println(count);
	}
}
