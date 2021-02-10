import java.util.Scanner;

// [���� 14503] �κ� û�ұ�
// https://blog.naver.com/tnwls0529/221823159392

public class Main {
	static int N;
	static int M;
	static int count; // û���� ������ ���� -> ������ �� ������ �ϴ� �� �� ��Ȯ�ؼ� static���� ��
	
	static int[] cleaning(int matrix[][], int x, int y, int dir, int clear) {
		// �迭�� ���� �ٶ󺸴� ������ �Ķ���ͷ� ����. (+ ���� ��ǥ)
		// �� ���� ��� �̵��� �� ���� ��쿡�� clear ������ 1�� ����
		
		int[] clean = new int[4]; // x, y, dir, û�� ���� ���θ� ���� �迭
		
		if(clear == 0) {
			if(matrix[y][x]==0) {
				count++;
			}
			matrix[y][x] = 2; // 1. ���� ��ġ û�� (û�ҵ� ���� 2�� ǥ��)
			
			// 2-a üũ
			if(dir == 0) {
				// �����̶��
				if(x>0 && matrix[y][x-1]==0) {
					// û���� �� ������
					clean[0] = x-1; // x��ǥ
					clean[1] = y; // y��ǥ
					clean[2] = 3; // ����
					clean[3] = 1; // ���� ���� û�� ����
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 3;
					clean[3] = 0; // ���� û�� ���ؼ� ȸ���� ��.
				}
			}
			else if(dir == 1) {
				// �����̶��
				if(y>0 && matrix[y-1][x]==0) {
					// û���� �� ������
					clean[0] = x; // x��ǥ
					clean[1] = y-1; // y��ǥ
					clean[2] = 0; // ����
					clean[3] = 1; // ���� ���� û�� ����
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 0;
					clean[3] = 0; // ���� û�� ���ؼ� ȸ���� ��.
				}
				
			}
			else if(dir == 2) {
				// �����̶��
				if(x<(M-1) && matrix[y][x+1]==0) {
					// û���� �� ������
					clean[0] = x+1; // x��ǥ
					clean[1] = y; // y��ǥ
					clean[2] = 1; // ����
					clean[3] = 1; // ���� ���� û�� ����
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 1;
					clean[3] = 0; // ���� û�� ���ؼ� ȸ���� ��.
				}
			}
			else {
				// �����̶��
				if(y<(N-1) && matrix[y+1][x]==0) {
					// û���� �� ������
					clean[0] = x; // x��ǥ
					clean[1] = y+1; // y��ǥ
					clean[2] = 2; // ����
					clean[3] = 1; // ���� ���� û�� ����
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 2;
					clean[3] = 0; // ���� û�� ���ؼ� ȸ���� ��.
				}
			}
		}
		else if(clear == 1) {
			// �� ���� ��� û�Ұ� �Ǿ��ų� 1�̶�� �ǹ�
			if(dir == 0) {
				// �����̶��
				if(y<(N-1) && matrix[y+1][x]!=1) {
					// ���� �� �� ������
					clean[0] = x; // x��ǥ
					clean[1] = y+1; // y��ǥ
					clean[2] = 0; // ����
					clean[3] = 2; // ������ ���� -> clear 0���� �ΰ� �ٽ� ���� �����ϸ� �� ��
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 0;
					clean[3] = 3; // ���̶� ���� �Ұ��� -> �۵� ����
				}
			}
			else if(dir == 1) {
				// �����̶��
				if(x>0 && matrix[y][x-1]!=1) {
					// û���� �� ������
					clean[0] = x-1; // x��ǥ
					clean[1] = y; // y��ǥ
					clean[2] = 1; // ����
					clean[3] = 2; // ������ ����
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 1;
					clean[3] = 3; // ���̶� ���� �Ұ��� -> �۵� ����
				}
				
			}
			else if(dir == 2) {
				// �����̶��
				if(y>0 && matrix[y-1][x]!=1) {
					// û���� �� ������
					clean[0] = x; // x��ǥ
					clean[1] = y-1; // y��ǥ
					clean[2] = 2; // ����
					clean[3] = 2; // ������ ����
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 2;
					clean[3] = 3; // ���̶� ���� �Ұ��� -> �۵� ����
				}
			}
			else {
				// �����̶��
				if(x<(M-1) && matrix[y][x+1]!=1) {
					// û���� �� ������
					clean[0] = x+1; // x��ǥ
					clean[1] = y; // y��ǥ
					clean[2] = 3; // ����
					clean[3] = 2; // ������ ����
				}
				else {
					clean[0] = x;
					clean[1] = y;
					clean[2] = 3;
					clean[3] = 3; // ���̶� ���� �Ұ��� -> �۵� ����
				}
			}
			
		}

		// ���� û���� ���� �ִ����� Ȯ���ϰ� ��ȯ������.
		return clean;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int matrix[][] = new int[N][M];
		
		int y = sc.nextInt(); // y��ǥ �Է� -> N��ġ
		int x = sc.nextInt(); // x��ǥ �Է� -> M��ġ
		
		int dir = sc.nextInt(); // ����
		// 0 : �� / 1 : �� / 2 : �� / 3 : ��/
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int[] clean = cleaning(matrix, x, y, dir, 0);
		
		while(clean[3] != 3) {
			int impossible = 0; // 4���� ���Ƽ� �Ұ����̸� �ٸ� ��� ã�ƾ� �ϴϱ�
			while(impossible < 4) {
				clean = cleaning(matrix, clean[0], clean[1], clean[2], 0);
				
				if(clean[3]==0) {
					// ȸ���� ����
					impossible++;
				}
				else {
					impossible = 0;
				}
			}
			clean = cleaning(matrix, clean[0], clean[1], clean[2], 1); // ����
		}
		
		// �۵� ����Ǹ� ����
		System.out.println(count);
	}

}
