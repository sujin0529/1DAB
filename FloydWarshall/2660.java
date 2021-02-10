import java.util.Arrays;
import java.util.Scanner;

// [���� 2660] ȸ��̱�
// https://blog.naver.com/tnwls0529/222059745087

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int member = sc.nextInt();

		int membership[][] = new int[member + 1][member + 1];
		for (int i = 1; i <= member; i++) {
			Arrays.fill(membership[i], Integer.MAX_VALUE);
		}

		int first = sc.nextInt();
		int second = sc.nextInt();

		while (first != -1 && second != -1) {
			membership[first][second] = 1;
			membership[second][first] = 1;
			first = sc.nextInt();
			second = sc.nextInt();
		}

		for (int i = 1; i <= member; i++) {
			for (int j = 1; j <= member; j++) {
				for (int k = 1; k <= member; k++) {
					if (membership[i][k] != Integer.MAX_VALUE && membership[k][j] != Integer.MAX_VALUE) {
						if (membership[i][j] > (membership[i][k] + membership[k][j])) {
							// k�� ���� ģ��. ���� ����� ���̸� �������� ������ ���̹Ƿ�, �ּҰ����� �� ��
							membership[i][j] = (membership[i][k] + membership[k][j]);
							membership[j][i] = (membership[i][k] + membership[k][j]);
						}
					}

					if (membership[member - i + 1][k] != Integer.MAX_VALUE
							&& membership[k][member - j + 1] != Integer.MAX_VALUE) {
						if (membership[member - i + 1][member - j + 1] > (membership[member - i + 1][k]
								+ membership[k][member - j + 1])) {
							// k�� ���� ģ��. ���� ����� ���̸� �������� ������ ���̹Ƿ�, �ּҰ����� �� ��
							membership[member - i + 1][member - j + 1] = (membership[member - i + 1][k]
									+ membership[k][member - j + 1]);
							membership[member - j + 1][member - i + 1] = (membership[member - i + 1][k]
									+ membership[k][member - j + 1]);
						}
					}
				}
			}
		}

		int min_member = 0;
		int candidate_membership = Integer.MAX_VALUE; // ���� ������ ȸ�� �ĺ��� max_membership ��
		int max_membership = 0; // ���� ū ���谡 �� ����. ��, MAX_VALUE�� �ȵ�
		String result = ""; // ȸ�� �ĺ� ���� ����
		for (int i = 1; i <= member; i++) {
			max_membership = 0;
			for (int j = 1; j <= member; j++) {
				if (i == j) {
					continue;
				}
				if (max_membership < membership[i][j]) {
					max_membership = membership[i][j];
				}
			}
			if (candidate_membership > max_membership) {
				// �� ���� ���� ���, �ʱ�ȭ �� �� �ٽ� ��� �غ�
				min_member = 1;
				candidate_membership = max_membership;
				result = "";
				result += (i + " ");
			} else if (candidate_membership == max_membership) {
				min_member++;
				result += (i + " ");
			}

		}

		System.out.println(candidate_membership + " " + min_member);
		System.out.println(result);

	}

}
