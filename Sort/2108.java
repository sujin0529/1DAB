import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

// [���� 2108] �����

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> number = new ArrayList<>();
		HashMap<Integer, Integer> fre = new HashMap<>();
		// �� ����ϱ� ����  ��
		
		int num = sc.nextInt(); // ���� ����
		int sum = 0;
		for(int i=0; i<num; i++) {
			int temp = sc.nextInt();
			sum += temp;
			number.add(temp);
			if(!fre.containsKey(temp)) {
				fre.put(temp, 1);
			}
			else {
				fre.put(temp, fre.get(temp)+1);
			}
		}
		System.out.println((int)Math.round((double)sum/num)); // ��� ���
		
		Collections.sort(number); // ����
		System.out.println(number.get((num-1)/2)); // �߾Ӱ� ���
		
		int max = 0;
		ArrayList<Integer> key_arr = new ArrayList<>();
		
		Iterator<Integer> iter = fre.keySet().iterator();
		while(iter.hasNext()) {
			int key = iter.next();
			if(fre.get(key)>max) {
				key_arr.clear(); // �迭 Ŭ�����ϰ�
				key_arr.add(key); // ���� �߰�
				max = fre.get(key);
			}
			else if(fre.get(key) == max) {
				key_arr.add(key);
			}
		}
		
		Collections.sort(key_arr);
		
		if(key_arr.size()>1) {
			System.out.println(key_arr.get(1)); // �ֺ� ��� -> �� ��°�� ���� �� ���
		}
		else {
			System.out.println(key_arr.get(0)); // �ֺ� ���
		}
		
		System.out.println(number.get(num-1) - number.get(0)); // ���� ��� 
	}
}
