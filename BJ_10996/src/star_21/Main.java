package star_21;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int star = sc.nextInt();
		
		for(int i=1; i<=star*2; i++) {
			for(int j=1; j<=star; j++) {
				if(i%2==1 && j%2==1) {
					// Ȧ����° ��, Ȧ����° ���̶��
					System.out.print("*");
				}
				else if(i%2==0 && j%2==0) {
					// ¦����° ��, ¦����° ���̶��
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
