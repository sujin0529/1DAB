package star_9;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int star = sc.nextInt();
		int star2 = star*2 - 1;
		int blank = 0; // ������ ����
		int check = 0; // ���� ������ �����ؾ��ϴ� �κ����� üũ
		
		for(int i=0; i<star2; i++) {
			for(int j=0; j<blank; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<star-1; j++) {
				System.out.print("*");
			}
			System.out.print("*");
			for(int j=0; j<star-1; j++) {
				System.out.print("*");
			}
//			for(int j=0; j<blank; j++) {
//				System.out.print(" ");
//			}
			// �������� ���ʿ��� ���� �����϶�� ��.
			
			if(check==1 && star*2-1==star2) {
				
			}
			else {
				System.out.println();
			}
			
			if(star==1) {
				// star�� ������ 1�� �پ��ٸ�
				check = 1;
			}
			if(check == 1) {
				blank--;
				star++;
			}
			else {
				blank++;
				star--;
			}
				
		}

	}

}
