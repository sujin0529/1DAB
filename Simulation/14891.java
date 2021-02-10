import java.util.Scanner;

// [���� 14891] ��Ϲ���
// https://blog.naver.com/tnwls0529/221828067499

public class Main {
	
	static void rotate(int[] first, int[] second, int[] third, int[] fourth, int num, int direc) {
		if(num==1) {
			int check = 0; // 1�� ȸ��
			if(first[2]!=second[6]) {
				check = 1; // 1-2�� ȸ��
			}
			if(check==1 && second[2]!=third[6]) {
				check = 2; // 1-2-3�� ȸ��
			}
			if(check==2 && third[2]!=fourth[6]) {
				check = 3; // ���� ȸ��
			}
			// ȸ�� ���� ������
			
			clockOrAnticlock(first, direc);
			if(check == 1) {
				clockOrAnticlock(second, -direc);
			}
			else if(check == 2) {
				clockOrAnticlock(second, -direc);
				clockOrAnticlock(third, direc);
			}
			else if(check == 3) {
				clockOrAnticlock(second, -direc);
				clockOrAnticlock(third, direc);
				clockOrAnticlock(fourth, -direc);
			}
			
		}
		else if(num==2){
			int check = 0; // 2�� ȸ��
			int last_check = 0; // 3-4 ȸ�� üũ
			if(first[2]!=second[6] || second[2]!=third[6]) {
				if(first[2]!=second[6] && second[2]!=third[6]) {
					check = 3; // 1-2, 2-3 ȸ��
				}
				else if(first[2]!=second[6]) {
					check = 1; // 1-2�� ȸ��
				}
				else {
					check = 2; // 2-3�� ȸ��
				}
			}
			if(check > 1 && third[2]!=fourth[6]) {
				last_check = 1;
			}
			// ȸ�� ���� ������
			
			clockOrAnticlock(second, direc);
			if(check == 1) {
				clockOrAnticlock(first, -direc);
			}
			else if(check == 2) {
				clockOrAnticlock(third, -direc);
			}
			else if(check == 3) {
				clockOrAnticlock(first, -direc);
				clockOrAnticlock(third, -direc);
			}
			
			if(last_check == 1) {
				clockOrAnticlock(fourth, direc);
			}
		}
		else if(num==3) {
			int check = 0; // 3�� ȸ��
			int last_check = 0; // 1-2 ȸ�� üũ
			
			if(second[2]!=third[6] || third[2]!=fourth[6]) {
				if(second[2]!=third[6] && third[2]!=fourth[6]) {
					check = 3; // 2-3, 3-4 ȸ��
				}
				else if(third[2]!=fourth[6]) {					
					check = 1; // 3-4�� ȸ��
				}
				else {
					check = 2; // 2-3�� ȸ��
				}
			}
			if(check > 1 && first[2]!=second[6]) {
				last_check = 1;
			}
			// ȸ�� ���� ������
			
			clockOrAnticlock(third, direc);
			if(check == 1) {
				clockOrAnticlock(fourth, -direc);
			}
			else if(check == 2) {
				clockOrAnticlock(second, -direc);
			}
			else if(check == 3) {
				clockOrAnticlock(second, -direc);
				clockOrAnticlock(fourth, -direc);	
			}
			
			if(last_check == 1) {
				clockOrAnticlock(first, direc);
			}
		}
		else {
			int check = 0; // 4�� ȸ��
			if(third[2]!=fourth[6]) {
				check = 1; // 3-4�� ȸ��
			}
			if(check==1 && second[2]!=third[6]) {
				check = 2; // 2-3-4 ȸ��
			}
			if(check==2 && first[2]!=second[6]) {
				check = 3; // ���� ȸ��
			}
			// ȸ�� ���� ������
			
			clockOrAnticlock(fourth, direc);
			if(check == 1) {
				clockOrAnticlock(third, -direc);
			}
			else if(check == 2) {
				clockOrAnticlock(third, -direc);
				clockOrAnticlock(second, direc);
			}
			else if(check == 3) {
				clockOrAnticlock(third, -direc);
				clockOrAnticlock(second, direc);
				clockOrAnticlock(first, -direc);
			}
		}
	}
	
	static void clockOrAnticlock(int[] wheel, int direc) {
		// 1�� ��� �ð�, -1�� ��� �ݽð�
		if(direc == 1) {
			// call by value �����̱� ������, wheel �迭 ���� ������ ��������� ��.
			// clone�� �ȵ�
			int temp = wheel[7];
			for(int i=7; i>0; i--) {
				wheel[i] = wheel[i-1];
			}
			wheel[0] = temp;
			
		}
		else if(direc == -1) {
			int temp = wheel[0];
			for(int i=0; i<7; i++) {
				wheel[i] = wheel[i+1];
			}
			wheel[7] = temp;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int wheel[][] = new int[4][8]; // 4���� ��Ϲ����� ���� ����� ���� ������ �迭
		
		for(int i=0; i<4; i++) {
			String temp = sc.nextLine();
			for(int j=0; j<8; j++) {
				wheel[i][j] = Integer.parseInt(temp.charAt(j)+"");
			}
		}
		
		int K = Integer.parseInt(sc.nextLine()); // ȸ�� Ƚ��
		for(int i=0; i<K; i++) {
			String s = sc.nextLine();
			String[] token = s.split(" ");
			int number = Integer.parseInt(token[0]); // ȸ����ų ���� ��ȣ
			int direction = Integer.parseInt(token[1]); // ���� -> 1 : �ð�, -1 : �ݽð�
			rotate(wheel[0], wheel[1], wheel[2], wheel[3], number, direction);
		}
		
		int score = 0;
		if(wheel[0][0] == 1) {
			score += 1;
		}
		if(wheel[1][0] == 1) {
			score += 2;
		}
		if(wheel[2][0] == 1) {
			score += 4;
		}
		if(wheel[3][0] == 1) {
			score += 8;
		}

		System.out.println(score);
	}
}