package bind;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt(); // ������ ����
		int seq[] = new int[length];
		
		for(int i=0; i<length; i++) {
			seq[i] = sc.nextInt();
		}
		Arrays.sort(seq); // ������������ ����
		
		int sum = 0;
		int zero_count = 0;
		int negative = -1; // �߰��� ������ ���� ���, �� �ִ� �ε��� ǥ��
		for(int i=length-1; i>=0; i--) {
			if((seq[i] > 1) && (i-1 >= 0) && (seq[i-1] > 1)) {
				// ���� �ڽŵ�, �ڽź��� �ε�����  1 ���� ���� �ִ� ���� 1���� ū �������
				// �� ���� ��� �� ũ�� ����
				// 1�� �����ϴ� ������ 1�� �׵���̱� ������, �׳� ���� �� �̵�
				sum += (seq[i] * seq[i-1]);
				i--; // �ڽź��� �ε����� 2 ���� ������ �����ϰ� �� ��
			}
			else if(seq[i] == 0) {
				// ������ ���� ���, �ִ� zero_count��ŭ �������� �� �ֱ� ����
				zero_count++;
			}
			else if(seq[i] < 0) {
				// ���� �ڽ��� ������ �ش� �ε����� ǥ���ϰ� �ݺ��� ��������
				negative = i;
				break;
			}
			else {
				sum += seq[i];
			}
		}		
		
		for(int i=0; i<=negative; i++) {
			if((seq[i] < 0) && (i+1 <= negative) && (seq[i+1] < 0)) {
				// ���� �ڽŵ�, �ڽź��� �ε�����  1 ���� ���� �ִ� ���� ���� �������
				// �� ���� ��� ����� ����鼭 �� ũ�� ����
				sum += (seq[i] * seq[i+1]);
				i++; // �ڽź��� �ε����� 2 ū ������ �����ϰ� �� ��
			}
			else if(zero_count > 0) {
				zero_count--;
			}
			else {
				// ������Ű�ų� ����ų �� ���� ������ ���� �״�� ����
				sum += seq[i];
			}
		}
		
		System.out.println(sum);
	}
}