import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [���� 4963] ���� ����
// https://blog.naver.com/tnwls0529/221776621440

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int w;
		int h;
		int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
		int map[][];
		int visited[][];
		w = sc.nextInt();
		h = sc.nextInt();
		
		while(w!=0 || h!=0) {
			int count = 0; // �ݺ��� Ƚ�� ī��Ʈ�� ���� land ���� ����
			int land = 0;
			Queue q_i = new LinkedList<Integer>(); // y
			Queue q_j = new LinkedList<Integer>(); // x

			map = new int[h][w];
			visited = new int[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1) {
						count++;
					}
						
				}
			}
			// �Է� �� �ʱ�ȭ ��
			while(count>0) {
				for(int i=0;i<h;i++) {
					// queue�� ����ִٸ�, �� ���� �־� �ʱ�ȭ ��Ų��.
					for(int j=0;j<w; j++) {
						if(map[i][j]==1 && visited[i][j]!=1) {
							q_i.add(i);
							q_j.add(j);
							break;
						}
					}
					if(!q_i.isEmpty()) {
						break;
					}
				}
				if(q_i.isEmpty()) {
					break;
				}
				
				while(!q_i.isEmpty()) {
					int _i = (int)q_i.remove();
					int _j = (int)q_j.remove();
					visited[_i][_j] = 1;
					for(int k=0;k<8; k++) {
						int _dx = _j+dx[k];
						int _dy = _i+dy[k];
						if(_dx>=0 && _dx<w && _dy>=0 && _dy<h) {
							if(map[_dy][_dx]==1 && visited[_dy][_dx] != 1) {
								visited[_dy][_dx] = 1;
								q_i.add(_dy);
								q_j.add(_dx);
								count--;
							}
						}
					}
				}
				land++;
			}
			System.out.println(land);
			
			w = sc.nextInt();
			h = sc.nextInt();
			// w, h �Է��� ���� �� �ٽ� �������ν� 0 0 Ȯ���� �� �ֵ��� ��.
		}
	}

}
