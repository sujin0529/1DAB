import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [���� 5567] ��ȥ��
// https://blog.naver.com/tnwls0529/221782025006

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int same = sc.nextInt(); // ���� ��
		int list = sc.nextInt(); // �Է� �ݺ� Ƚ��
		int matrix[][] = new int[same+1][same+1];
		int wedding[] = new int[same+1];
		Queue q = new LinkedList<Integer>();
		int count = 0;
		for(int i=0; i<list; i++) {
			int _i = sc.nextInt();
			int _j = sc.nextInt();
			matrix[_i][_j] = 1;
			matrix[_j][_i] = 1;
			if(_i==1) {
				q.add(_j);
				wedding[_j] = 1; // ���� �ȴٸ� 1�� ǥ��
			}
		}
		
		while(!q.isEmpty()) {
			int friend = (int)q.remove();
			for(int i=2; i<same+1; i++) {
				if(matrix[friend][i]==1) {
					wedding[i] = 1;
				}
			}
		}
		for(int i=2; i<same+1; i++) {
			if(wedding[i]==1) {
				count++;
			}
		}
		
		System.out.println(count);
		

	}

}
