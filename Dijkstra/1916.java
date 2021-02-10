import java.util.Arrays;
import java.util.Scanner;

// [���� 1916] �ּҺ�� ���ϱ�
// https://blog.naver.com/tnwls0529/222069483823

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int city = sc.nextInt();
		int bus = sc.nextInt();

		int matrix[][] = new int[city + 1][city + 1];
		boolean visit[] = new boolean[city + 1];
		int cost[] = new int[city + 1];

		for (int i = 1; i <= city; i++) {
			Arrays.fill(matrix[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < bus; i++) {
			int head = sc.nextInt();
			int tail = sc.nextInt();
			int weight = sc.nextInt();

			if (weight < matrix[head][tail]) {
				// �̹� ���� �뼱�� �� ���� weight�� �Է¹޾��� ���
				matrix[head][tail] = weight;
			}

		}

		int source = sc.nextInt();
		int dest = sc.nextInt();

		visit[source] = true;

		for (int i = 1; i <= city; i++) {
			// cost �ʱ�ȭ
			cost[i] = matrix[source][i];
		}

		for (int i = 1; i < city; i++) {
			// Ƚ�� ����
			int min_city = minCity(city, cost, visit);
			visit[min_city] = true; // �湮���� �ٲٱ�
			for (int j = 1; j <= city; j++) {
				if (visit[j]) {
					// �̹� �湮�ߴٸ�, �ǳʶپ ��.
					continue;
				}
				if (matrix[min_city][j] != Integer.MAX_VALUE && cost[j] > cost[min_city] + matrix[min_city][j]) {
					// j�� ���µ� min_city�� ���� ���� ���� �� �����ٸ�
					cost[j] = cost[min_city] + matrix[min_city][j];
				}
			}
		}

		System.out.println(cost[dest]);

	}

	static int minCity(int city, int cost[], boolean visit[]) {
		int min = Integer.MAX_VALUE; // ���� ���� cost ã�� ��
		int index = 0;

		for (int i = 1; i <= city; i++) {
			if (!visit[i]) {
				// ���� �湮���� ����
				if (min > cost[i]) {
					// �� ���� ���
					min = cost[i];
					index = i;
				}
			}
		}

		return index;
	}

}
