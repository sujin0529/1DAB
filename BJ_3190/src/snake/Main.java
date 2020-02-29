package snake;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // ������ ũ�� �Է�
		int board[][] = new int[N+2][N+2]; // �� �������� ����� �Ҵ�
		
		for(int i=0; i<N+2; i++) {
			board[0][i] = 4;
			board[i][0] = 4;
			board[N+1][i] = 4;
			board[i][N+1] = 4;
		}
		// �� �����
		
		int K = sc.nextInt(); // ����� ����
		
		for(int i=0; i<K; i++) {
			int y = sc.nextInt(); // ��
			int x = sc.nextInt(); // ��
			board[y][x] = 1; // ����ִ� ĭ�� 1�� ǥ��
		}
		
		int L = sc.nextInt(); // ���� ��ȯ Ƚ��
		int remember[][] = new int[L+1][2];
		// ��, ���⿡ ���� �ε��� ����� �迭 <- �Ӹ��� �������� ������ �ð��� �޶�� ��.
		// ������ ���� ����� �ʿ䰡 ����
		
		int dx[] = {1,0,-1,0};
		int dy[] = {0,-1,0,1};
		// left ȸ���� �������� dx, dy �����ص� (�ε����� �����ϰ� �ϱ� ����)
			
		int X=0;
		int direc = 0; // ���������� �����ϰ�, �񱳴� char������ �� �� ����
		int direc_index = 0; // ���� ���ư��� ����
		
		for(int i=0; i<L; i++) {
			X = sc.nextInt();
			direc = sc.next().charAt(0); // String���� char�� �ٷ� ��ȯ
			if(direc=='L') {
				// ���� ȸ���̸�
				direc_index = (direc_index+1)%4;
			}
			else if(direc=='D') {
				// ������ ȸ���̸�
				direc_index = (direc_index+3)%4;
				// -1+4 = 3 -> ���� �ȳ����� �Ϸ���
			}
			remember[i][0] = X;
			remember[i][1] = direc_index;
			// ��, �ε��� ������ ����
		}
		remember[L][0] = Integer.MAX_VALUE;
		// �迭 ���� �Ѿ�� ���� ���� ������.
		
		direc_index = 0;
		int direc_x = dx[direc_index];
		int direc_y = dy[direc_index];
		// �ʱ� ���� ���ϴ� ����
		
		int time = 0;
		int tail_time = time; // ���� ���� �ð��� ���� ��.
		
		board[1][1] = 2; // �� ��ġ �ʱ����
		
		
		int snakeHead_x = 1;
		int snakeHead_y = 1;
		// �ʱ� ���� �Ӹ� ��ġ
		
		int snakeTail_x = 1;
		int snakeTail_y = 1;
		// �ʱ� ���� ���� ��ġ
		
		int r_index = 0; // remember �迭 �ε���
		X = remember[r_index][0];
		
		int r_tail = 0; // tail�� ���� remember �迭 �ε���
		int direc_tail = direc_index; // �ʱ� ������ ����
		
		while(true) {
			
			if(tail_time==remember[r_tail][0]) {
				// �������� �����ؾ��ϴ� �ð� ����
				direc_tail = remember[r_tail][1];
				r_tail++;
			}
			
			if(time<X) {
				time++;
				tail_time++;
				if(board[snakeHead_y+direc_y][snakeHead_x+direc_x]==1) {
					// ���� ����� ������
					tail_time--; // ������ �ð��� ������ ����
					
					snakeHead_y = snakeHead_y+direc_y;
					snakeHead_x = snakeHead_x+direc_x;
					// �Ӹ� ��ġ ����
					board[snakeHead_y][snakeHead_x] = 2;		
				}
				else if(board[snakeHead_y+direc_y][snakeHead_x+direc_x]==4) {
					// ���� ��������
					break;
				}
				else if(board[snakeHead_y+direc_y][snakeHead_x+direc_x]==2) {
					// �ڱ� �ڽŰ� �ε�����
					break;
				}
				else {
					// �ƹ��͵� ������
					snakeHead_y = snakeHead_y+direc_y;
					snakeHead_x = snakeHead_x+direc_x;
					// �Ӹ� ��ġ ����
					
					board[snakeHead_y][snakeHead_x] = 2;		
					board[snakeTail_y][snakeTail_x] = 0;
					// �� �̵������Ƿ� board���� �ݿ�
					
					snakeTail_y = snakeTail_y+dy[direc_tail];
					snakeTail_x = snakeTail_x+dx[direc_tail];
					// ���� ��ġ�� ����
					
				}
			}
			else if(time==X) {
					direc_index = remember[r_index][1]; // ������ �ٲٰ�
					direc_y = dy[direc_index];
					direc_x = dx[direc_index];
					r_index++;	
					X = remember[r_index][0]; // �ð��� �� ���� �ð����� �ٲ���
			}	
		}
		
		System.out.println(time);
	}
}
