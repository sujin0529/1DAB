import java.util.Scanner;

// [���� 1120] ���ڿ�
// https://blog.naver.com/tnwls0529/222040867793

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String[] tmp = s.split(" ");
		
		String compare = tmp[0]; // ���ذ� �񱳰� �Ǵ� ���ڿ�
		String standard = tmp[1]; // ������ �Ǵ� ���ڿ�
		
		int diff = standard.length() - compare.length();
		int max = 0; // ���� ���ڰ� ���� ���� ��� ����
		
		for(int i=0; i<=diff; i++) {
			int same = 0; // ���� ������ ���� ī��Ʈ
			for(int j=0; j<compare.length(); j++) {
				if(compare.charAt(j) == standard.charAt(i+j)) {
					// ���� ���ڰ� ���ٸ�
					same++;
				}
			}
			if(max < same) {
				max = same;
			}
		}
		
		/*
		 * ���� max�� ���� ���� ��ġ�� ���
		 * compare���� ������ ���ڴ� ��� standard�� ���� ��ġ�� ���� ���ڸ� �����ٰ� �� ��
		 * ���� compare�� ���̿��� max�� �� ���� ����ϸ� ��.
		*/
		
		diff = compare.length() - max;
		System.out.println(diff);
	}

}
