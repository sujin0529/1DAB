package stair;

import java.util.Scanner;

public class Main {
	static void max_score(int[][] arr, int[] stair, int index) {
		arr[index][1] = arr[index+1][0]+stair[index]; // �����ؼ� �ڽ� ����
		arr[index][0] = arr[index+1][2]+stair[index]; // �ϳ� �ǳʶٰ� �ڽ� ����
		arr[index][2] = Math.max(arr[index+1][0], arr[index+1][1]); // �ڽ� ���� x
		// �ڽ��� �������� ��������, �ڽ� ������ ���� �ݵ�� ��Ҿ�� ��. �� �� �� ū ���� �����Ѵ�.
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // ����� ����
		int stair[] = new int[num+1];
		for(int i=1; i<num+1; i++) {
			stair[i] = sc.nextInt();
		}
		
		
		int[][] max = new int[num+1][3];
		// �ڽ� ���� ��� 2����, �ڽ� ����x�� ��� 1���� ��� ����� �����ϱ� ���� �迭 ����
		
		max[num][0] = stair[num];
		max[num-1][1] = max[num][0]+stair[num-1]; // �����ؼ� �ڽ� ����
		max[num-1][0] = 0; // �ڽŸ� �ִ� ��찡 ����
		max[num-1][2] = max[num][0]; // �ڽ� ���� x		
		// ���� ������ �������� ���� ��ܿ� ���ؼ� �ʱ�ȭ ����
		
		for(int i=num-2; i>0; i--) {
			max_score(max, stair, i);
		}
		
		int score = max[1][0] > max[1][1] ? max[1][0] : max[1][1];
		score = score > max[1][2] ? score : max[1][2];
		// 3���� ��� �� ���� ū ���� ���� ���ھ�� ����
		
		System.out.println(score);
	}

}
