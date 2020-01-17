import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		String[] num = temp.split(" ");
		int user = Integer.parseInt(num[0]);
		int edge = Integer.parseInt(num[1]);
		int matrix[][] = new int[user+1][user+1]; // ���� ��Ʈ������ �����.
		// 0�� ģ���� �����ϱ� 0�� �κп��� �� �� ������ �Ѵ�.
		int visited[][] = new int[user+1][user+1]; // ���氪�� visited��
		
		for(int i=0;i<edge;i++) {
			temp = sc.nextLine();
			num = temp.split(" ");
			int _i = Integer.parseInt(num[0]);
			int _j = Integer.parseInt(num[1]);
			matrix[_i][_j] = 1;
			matrix[_j][_i] = 1;
			visited[_i][_j] = 1;
			visited[_j][_i] = 1;
			// ���谡 ������ ǥ��
		}
		// �Է�
		
		 
		
		for(int i=1; i<user+1; i++) {
			for(int j=1;j<user+1; j++) {
				if(matrix[i][j] != 1) {
					visited[i][j] = Integer.MAX_VALUE;
					visited[j][i] = Integer.MAX_VALUE;
				}
			}
		}
		// �ּҰ��� ã�� ���̱� ������, ���� ���谡 ���ٸ� �ִ밪�� ������ �Ѵ�.
		
		
		for(int k=1;k<user+1; k++) {
			for(int i=1; i<user+1; i++) {
				for(int j=1; j<user+1; j++) {
					if((visited[i][j] > visited[i][k] + visited[k][j]) && visited[i][k]!=Integer.MAX_VALUE && visited[k][j] != Integer.MAX_VALUE) {
						// �ִ밪�� �������� ������ ���� �� �ֱ� ������, �������� �� ���� ���� ��� Integer.MAX_VALUE�� �ƴϾ����.
						visited[i][j] = visited[i][k] + visited[k][j];
					}
				}
			}
		}
		
		int _index = 0;
		int min = Integer.MAX_VALUE;
		int min_arr[] = new int[user+1];
		for(int i = 1; i<user+1; i++) {
			for(int j = 1; j<user+1; j++) {
				min_arr[i] += visited[i][j];
			}
		}
		for(int i=1; i<user+1; i++) {
			if(min_arr[i]<min) {
				min = min_arr[i];
				_index = i;
			}
		}
		
		System.out.println(_index);
		
		

	}

}
