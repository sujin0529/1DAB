import java.util.Scanner;

// [���� 11047] ���� 0
// https://blog.naver.com/tnwls0529/221796317469

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ������ ��ġ
		int K = sc.nextInt(); // �ݾ�
		int value[] = new int[N];
		for(int i=N; i>0; i--) {
			value[i-1] = sc.nextInt();
			// ������ ��ġ�� ������������ �Է��ϵ��� ��.
		}
		int coin = 0; // ������ ����
		for(int i=0; i<N; i++) {
			if(K/value[i]>0) {
				coin += K/value[i];
				K %= value[i];
			}
			if(K==0) {
				break;
			}
		}
		System.out.println(coin);
	}
}
