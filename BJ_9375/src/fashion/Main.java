package fashion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> clothes;
		
		int N = Integer.parseInt(sc.nextLine());
		for(int i=0; i<N; i++) {
			clothes = new HashMap<String, Integer>();
			int number = Integer.parseInt(sc.nextLine()); // �ǻ��� ��
			
			for(int j=0; j<number; j++) {
				// �ǻ� �Է¹ް� ���� �����ϴ� �ͱ���
				String s = sc.nextLine();
				String[] item = s.split(" ");
				if(clothes.containsKey(item[1])) {
					// ���� �̹� �ִ� �������
					clothes.put(item[1], clothes.get(item[1])+1);
					// �� 1 ����
				}
				else {
					clothes.put(item[1], 1);
				}
			}
			int size = clothes.size(); // �ǻ��� ���� ��
			int all_clothes[] = new int[size];
			Set<String> key = clothes.keySet();
			Iterator<String> iter = key.iterator();
			int index = 0;
			while(iter.hasNext()) {
				all_clothes[index] = clothes.get(iter.next());
				index++;
			}
			// �ǻ��� ������ ���� �� ������ ��� �迭�� �ű�
			
			int total = 0;
			int mul = 1;
			for(int j=0; j<size; j++) {
				mul *= (all_clothes[j]+1);
			}
			total = mul-1;
			
//			for(int s = 1; s<=size; s++) {
//				index = 0;
//				while(index < size) {
//					int mul = 1; // ����� �� ���ϴµ� ���� ���̱� ������ ����ϴ� ����
//					for(int k=index; k<s+index; k++) {
//						mul *= all_clothes[k];
//					}
//					index += s;
//					total += mul;
//				}
//				
//			}
			System.out.println(total);
		}

	}

}
