package dna;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String[] tmp = s.split(" ");
		int num = Integer.parseInt(tmp[0]);
		int length = Integer.parseInt(tmp[1]);
		
		String[] dna = new String[num];
		char[] result_dna = new char[length];
		
		for(int i=0; i<num; i++) {
			dna[i] = sc.nextLine();
		}
		
		int[] nucle; // ������� A, C, G, T �� ������ ������ ��
		
		for(int i=0; i<length; i++) {
			nucle = new int[4];
			for(int j=0; j<num; j++) {
				char dna_nucle = dna[j].charAt(i);
				if(dna_nucle == 'A') {
					nucle[0]++;
				}
				else if(dna_nucle == 'C') {
					nucle[1]++;
				}
				else if(dna_nucle == 'G') {
					nucle[2]++;
				}
				else {
					nucle[3]++;
				}
			}
			int max_index = 0;
			for(int j=1; j<4; j++) {
				// ���� ���� ��Ŭ����Ƽ�� ���� ã��
				if(nucle[max_index] < nucle[j]) {
					max_index = j;
				}
			}
			
			if(max_index == 0) {
				result_dna[i] = 'A';
			}
			else if(max_index == 1) {
				result_dna[i] = 'C';
			}
			else if(max_index == 2) {
				result_dna[i] = 'G';
			}
			else {
				result_dna[i] = 'T';
			}
			
		}
		
		int hamming = 0;
		for(int i=0; i<num; i++) {
			for(int j=0; j<length; j++) {
				if(result_dna[j] != dna[i].charAt(j)) {
					hamming++;
				}
			}
		}
		
		for(int i=0; i<length; i++) {
			System.out.print(result_dna[i]);
		}
		System.out.println();
		System.out.println(hamming);

	}

}
