import java.util.Scanner;

// [���� 1149] RGB�Ÿ�
// https://blog.naver.com/tnwls0529/221840591418

public class Main {
	
	static void coloring(int [][] color, int[] input, int number) {
		// number : color �迭�� row
		// ����� �ּڰ��̱� ������, ������ ������ �����ؾ���. -> min ���
		
		color[number][0] = Math.min(color[number-1][1], color[number-1][2])+input[0];
		// ���簡 red�� �Ƿ��� ���� ���� green �Ǵ� blue.
		color[number][1] = Math.min(color[number-1][0], color[number-1][2])+input[1];
		// ���簡 green�� �Ƿ��� ���� ���� red �Ǵ� blue.
		color[number][2] = Math.min(color[number-1][0], color[number-1][1])+input[2];
		// ���簡 blue�� �Ƿ��� ���� ���� red �Ǵ� green.	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int house = sc.nextInt(); // ���� ����
		int[][] color = new int[house][3]; // RGB�� ���� ���� ����
		
		// red : 0, green : 1, blue : 2
		
		color[0][0] = sc.nextInt();
		color[0][1] = sc.nextInt();
		color[0][2] = sc.nextInt();
		// ù ��° ���� ���� ����. �ʱⰪ
		
		for(int i=1; i<house; i++) {
			int input[] = new int[3]; // rgb �Է� �޾� ������ �迭
			for(int j=0; j<3; j++) {
				input[j] = sc.nextInt();
			}
			coloring(color, input, i);
		}
		
		int min = color[house-1][0]>color[house-1][1] ? color[house-1][1] : color[house-1][0];
		min = min>color[house-1][2] ? color[house-1][2] : min;
		// �� ������ ������ ������ ��� �� ���� �� ã��
		
		System.out.println(min);

	}

}
