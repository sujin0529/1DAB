import java.util.Scanner;

// [���� 2748] �Ǻ���ġ �� 2

public class Main {
	
	static void fibo(long _fibo[], int number) {
		if(number<2) {
			_fibo[number] = number;
		}
		else {
			if(_fibo[number]==0) {
				// ����ִ� ���
				fibo(_fibo, number-1);
				fibo(_fibo, number-2);
				_fibo[number] = _fibo[number-1] + _fibo[number-2];
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		long[] _fibo = new long[number+1];
		fibo(_fibo, number);
		System.out.println(_fibo[number]);
		

	}

}
