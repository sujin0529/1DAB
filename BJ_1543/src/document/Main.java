package document;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String document = sc.nextLine();
		String find = sc.nextLine();

		int count = 0;
		int compare = 0; // 1�̸� ��� �̾ ��
		int find_index = 0; // find ���ڿ��� �ε���
		int return_index = 0; // ���� ��ġ���� ���� ��� ���ư� �ε���

		int i = 0;
		while (i <= document.length()) {			
			if (compare == 0) {
				// ù ��° ���ڰ� ������ Ȯ��
				if(i == document.length()) {
					break;
				}
				if (find.charAt(find_index) == document.charAt(i)) {
					compare = 1;
					find_index++;
					i++;
					return_index = i; // ���� �߰��� Ʋ���� �Ǹ� ���ư��� �ϴ� ��ġ ����
				} else {
					i++;
					return_index = i; // ���� ��ġ�� ���ư� �ʿ䰡 ���� ������, ������ġ�� ����
					
				}
			} else {
				if (find_index == find.length()) {
					// find ���ڿ��� ã�� => �ʱ� ���·�
					count++;
					find_index = 0;
					compare = 0;
					return_index = i; // �ش� ��ġ�� �Ѿ���ϱ� ����
					
				} else if(i == document.length()) {
					break;
				} else if (find.charAt(find_index) == document.charAt(i)) {
					find_index++;
					i++;
				} else {
					// ���� �ʴٴ� �ǹ�
					compare = 0;
					find_index = 0;
					i = return_index;
				}
			}
			

		}
		System.out.println(count);
	}
}
