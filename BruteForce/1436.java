import java.util.Scanner;

// [���� 1436] ��ȭ���� ��
// https://blog.naver.com/tnwls0529/221845076616

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N��° ������ ��
		
		String number = "666";
		int int_num = 0;
		
		for(int i=2; i<=N; i++) {
			
			// �켱 ���ϰ� ����ؾ� �� ��
			int_num = Integer.parseInt(number); // ���� ��
			int_num += 1000;
			number = int_num+""; // string ���·� ��ȯ�Ͽ� �ٽ� ����
			
			
			int six = 0;
			int index = 0; // ���ӵ� 6�� ������
			for(int j=0; j<number.length(); j++) {
				if(six==0 && number.charAt(j)=='6') {
					// ������ ���
					index = j;
					six++;
				}
				else if(number.charAt(j)=='6') {
					six++;
				}
				else if(six<4 && number.charAt(j) !='6'){
					six = 0;
					// six �� �ʱ�ȭ (���ӵ� 4�� �̻��� 6�� �ִ����� ã���� �ϴ� ���̹Ƿ�)
				}
				
			}
			if(six>3) {
				// 4�� �̻��̶��
				String temp = number.substring(index);
				int_num = Integer.parseInt(temp); // ���������� ��ȯ
				int sub = int_num/1000; // �� �� ���ϱ�
				int_num = Integer.parseInt(number); // ���� ��
				int_num -= sub; // ���ӵ� 666�� �����
				
				int iter = 0;
				while(sub>10) {
					sub/= 10;
					iter++;
				}
				// 6�� ���� ������ ����� ���ؼ� ��ŭ�� �ݺ��ؾ��ϴ����� �����
				
				iter = 10*((int)Math.pow(10, iter));
				// ���� 6�� ��쿡�� 0~9, 66�� ��쿡�� 0~99���� �ݺ��ؾ� �ϱ� ������.

				for(int k=0; k<iter; k++) {
					if(N==i) {
						// ���� ã���� �ϴ� ��ȣ�� ������ ���ڶ��
						System.out.println(int_num);
						System.exit(0);
					}
					int_num++;
					i++;
				}
				
				int_num = Integer.parseInt(number); // ���� ��
				int_num += 1000;
				number = int_num+""; // string ���·� ��ȯ�Ͽ� �ٽ� ����
				// 1000�� �������� 6�� �����ؼ� 4�� �̻� ���� ����� ����  ���ڸ� ã���ֱ� ������.
			}
		}
		System.out.println(number);
		

	}

}
