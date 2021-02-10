import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// [���� 11652] ī��
// https://blog.naver.com/tnwls0529/221821567469

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); // ī���� ����
		HashMap<Long, Integer> card = new HashMap<Long, Integer>();
		
		for(int i=0; i<number; i++) {
			long input = sc.nextLong(); // �Է¹��� ����
			if(card.containsKey(input)) {
				// ���� �̹� �ִ� ���̶��
				card.put(input, card.get(input)+1); // 1��ŭ ���� �÷��ֱ�
			}
			else {
				card.put(input, 1); // ���� ����
			}
		}
		// �Է�
		
		long max_key = 0; // ���� ���� �ִ� ����
		int max_value = 0; // �� ������ ����
		
		Iterator<Long> iter = card.keySet().iterator();
		while(iter.hasNext()) {
			long temp_key = iter.next(); // Ű ��
			int temp_value = card.get(temp_key); // value
			if(temp_value > max_value) {
				max_key = temp_key;
				max_value = temp_value;
			}
			else if(temp_value == max_value) {
				// ���࿡ ���� ���� �����
				if(max_key > temp_key) {
					// key���� ���� ���� ����ؾ��ϹǷ�, �� ��쿡�� ���� �ٲ�
					max_key = temp_key;
				}
			}
		}
		
		System.out.println(max_key);

	}

}
