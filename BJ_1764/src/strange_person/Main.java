package strange_person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> strange_person = new HashMap<>(); // �赵 ���� ����� �̸� ��Ƶ� map
		ArrayList<String> sort = new ArrayList<>(); // �躸�⿡ ���ϴ� ��� ������ ���ؼ�
		
		
		String s = sc.nextLine();
		String[] sp = s.split(" ");
		int first = Integer.parseInt(sp[0]); // �赵 ���� ��� ��
		int second = Integer.parseInt(sp[1]); // ���� ���� ��� ��
		
		
		for(int i=0; i<first; i++) {
			String tmp = sc.nextLine();
			strange_person.put(tmp, 1);
		}
		
		for(int i=0; i<second; i++) {
			String tmp = sc.nextLine();
			if(strange_person.containsKey(tmp)) {
				sort.add(tmp);
			}
		}
		
		Collections.sort(sort);
		System.out.println(sort.size());
		for(int i=0; i<sort.size(); i++) {
			System.out.println(sort.get(i));
		}

	}

}
