import java.util.Scanner;

// [���� 1904] 01Ÿ��

public class Main {
	
	static void make(int tile[], int n) {
		if(n<3) {
			tile[n] = n;
		}
		else {
			if(tile[n]==0) {
				// ���� ���� ����Ǿ����� �ʴٸ�
				make(tile, n-1);
				make(tile, n-2);
				tile[n] = (tile[n-1] + tile[n-2])%15746;
			}	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // ����� �� �ִ� Ÿ���� ����
		int tile[] = new int[N+1]; // ������ ����
		make(tile, N);
		System.out.println(tile[N]);
	}
}