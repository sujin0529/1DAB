import java.util.Scanner;

// [���� 1003] �Ǻ���ġ �Լ�
// https://blog.naver.com/tnwls0529/221839089827

public class Main {
	static void fibo(int count[][], int n) {
		if(n==0) {
			count[n][0] = 1;
			count[n][1] = 0;
		}
		else if(n==1) {
			count[n][0] = 0;
			count[n][1] = 1;

		}
		else if(count[n][0] != 0) {
			// ���� ������� �ʴٸ� �ƹ��͵� ���� �ʾƵ� ��.
		}
		else {
			// ���࿡ ����ִٸ� ä�������� �ؾ���.
			fibo(count, n-1);
			fibo(count, n-2);
			
			count[n][0] = count[n-1][0] + count[n-2][0];
			count[n][1] = count[n-1][1] + count[n-2][1];
		}			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int i=0; i<test_case; i++) {
			int N = sc.nextInt();
			int count[][] = new int[N+1][2];
			fibo(count, N);
			System.out.println(count[N][0]+" "+count[N][1]);
		}

	}

}
