import java.util.Scanner;

// [���� 2458] Ű ����
// https://blog.naver.com/tnwls0529/222060118984

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int student = sc.nextInt();
		int compare = sc.nextInt();
		
		int height[][] = new int[student+1][student+1];
		
		for(int i=0; i<compare; i++) {
			int _s = sc.nextInt(); // Ű ���� ģ��
			int _l = sc.nextInt(); // Ű ū ģ��
			height[_s][_l] = 1;
		}
		
		// �ڽ��� �������� �ְų�, �ڽ����� ���ų� �ϴ� �� ��� vertex�� ���ؼ� ������
		// �ڽ��� Ű ������ �� �� ����.
		
		for(int i=1; i<=student; i++) {
			for(int j=1; j<=student; j++) {
				for(int k=1; k<=student; k++) {
					if(i==j) {
						// �ִ� 500*500 ���� ���� Ƚ�� ����
						break;
					}
					if(height[i][k] == 1 && height[k][j] == 1) {
						height[i][j] = 1; // i�� j���� ����
					}
					if(height[student-i+1][k] == 1 && height[k][student-j+1] == 1) {
						height[student-i+1][student-j+1] = 1;
					}
				}
			}
		}
		
		int count = 0;
		for(int i=1; i<=student; i++) {
			int connect = 0;
			for(int j=1; j<=student; j++) {
				if(height[i][j] == 1 || height[j][i] == 1) {
					// j�� ���ؼ� i�� �۰ų� ũ�ٴ� ���� �� �� ����
					connect++;
				}
			}
			if(connect == (student-1)) {
				// �ڽ��� ������ ������ �л��鿡 ���� �ڽ��� ��� ��ġ�ϴ����� �ȴٴ� �ǹ�
				count++;
			}
		}
		
		System.out.println(count);

	}

}
