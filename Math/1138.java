import java.util.Scanner;

// [���� 1138] �� �ٷ� ����
// https://blog.naver.com/tnwls0529/222036371763

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] people = new int[N];
		for(int i=0; i<N; i++) {
			people[i] = sc.nextInt();
		}
		
		int[] line = new int[N]; // �� �ٷ� ���� �� ���ĵ� ��ġ
		// �� Ű�� ū �����״� ���� �ֵ��� ���� ������ ���� �����Ƿ�, ���������� �̵��ϸ� �ڸ��� ã�´�.
		
		for(int i=0; i<N; i++) {
			int index = people[i]; // ����� �������� �ϴ� ��ġ
			for(int j=0; j<index; j++) {
				if(line[j] != 0) {
					// ������ ���� �ְ� ������ �ִٴ� ����,
					// ���� ������ �� �з��� �Ѵٴ� ��
					index++;
				}
			}
			
			if(line[index] == 0) {
				// ���� �ش� �ڸ��� ���� �ʾҴٴ� �ǹ�
				line[index] = i+1; // ��� ��ȣ
			}
			else {
				while(line[index] != 0) {
					index++;
				}
				line[index] = i+1;
			}
		}
		for(int i=0; i<N; i++) {
			System.out.print(line[i]+" ");
		}
		

	}

}
