import java.util.Scanner;

// [���� 1932] ���� �ﰢ��
// https://blog.naver.com/tnwls0529/221843748015

public class Main {
	
	static void triangle_sum(int[][] sum, int[][] triangle, int line) {
		sum[line][0] = sum[line-1][0]+triangle[line][0];
		// �� ���� �� ����
		for(int i=1; i<line; i++) {
			sum[line][i] = Math.max(sum[line-1][i-1], sum[line-1][i])+triangle[line][i];
			// �� ���� ���� �� �� �� �� �� ū �Ͱ� �ڱ� �ڽ��� ���� ���� sum�� ����
		}
		sum[line][line] = sum[line-1][line-1]+triangle[line][line];
		// �� ������ �� ����
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt(); // �ﰢ���� ����
		int[][] triangle = new int[size][size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<=i; j++) {
				triangle[i][j] = sc.nextInt();
			}
		}
		// ���� �ﰢ�� �Է�

		int[][] sum = new int[size][size]; // ���� ���� ������ �迭
		sum[0][0] = triangle[0][0];
		for(int i=1; i<size; i++) {
			triangle_sum(sum, triangle, i);
		}

		int max = sum[size-1][0];
		for(int i=1; i<size; i++) {
			if(max<sum[size-1][i]) {
				max = sum[size-1][i];
			}
		}
		System.out.println(max);
	}
}
