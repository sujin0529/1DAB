import java.util.Scanner;

// [���� 1475] �� ��ȣ
// https://blog.naver.com/tnwls0529/222033557253

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String room = sc.nextLine();
		
		int number[] = new int[10];
		for(int i=0; i<room.length(); i++) {
			int num = Integer.parseInt((room.charAt(i))+"");
			number[num]++;
		}
		
		number[6] = (number[6]+number[9]+1)/2;
		// 6�� 9�� ���� ��� ����
		
		int max = 0; // ���� ���� �ʿ��� ���� ��Ʈ�� ������ ����
		for(int i=0; i<9; i++) {
			if(number[i]>max) {
				max = number[i];
			}
		}
		System.out.println(max);

	}

}
