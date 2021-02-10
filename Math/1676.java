import java.util.Scanner;

// [���� 1676] ���丮�� 0�� ����
// https://blog.naver.com/tnwls0529/222029722274

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] count = new int[6];
		// 2�� 5�� ������ 10�� ����ϱ� ���μ����ظ� �ϴµ�, 5������ �����غ���
		
		for(int i=N; i>1; i--) {
			int index = 2;
			int number = i;
			while(index < 6) {
				if(number%index == 0) {
					count[index]++;
					number /= index;
				}
				else {
					index++;
				}
			}
		}
		
		int min = count[2] > count[5] ? count[5] : count[2];
		
		System.out.println(min);

	}

}
