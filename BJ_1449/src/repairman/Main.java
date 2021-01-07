package repairman;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int leakCount = sc.nextInt();
		int tapeLength = sc.nextInt();
		
		int[] location = new int[leakCount]; // ���� ���� ��ġ ����
		
		for(int i=0; i<leakCount; i++) {
			location[i] = sc.nextInt();
		}
		Arrays.parallelSort(location);
		
		int count = 1; // �ʿ��� �������� ���� + �ּ� 1�� �ʿ�
		int index = 1;
		int startIndex = 0; // �ִ� Ŀ�� ���� ������ ���� �� ���� ��ġ �ε���
		
		while(index < leakCount) {
			int diff = location[index] - location[startIndex];
			if(diff >= tapeLength) {
				// ���ο� ������ ����ؾ� ��.
				count++;
				startIndex = index;
			}
			index++;
		}
		System.out.println(count);
	}
}