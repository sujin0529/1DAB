package counting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int number = Integer.parseInt(br.readLine());
			int num[] = new int[10001]; // 10000������ ���ڿ� ���� ���� ����
			int data[] = new int[number]; // �Է¹��� ������
			int sort[] = new int[number]; // �����ؼ� ������
			
			for(int i = 0; i<number; i++) {
				int input = Integer.parseInt(br.readLine());
				data[i] = input;
				num[input]++; // �Է� �����͸� �ε����� �ϴ� ���� ���� 1����
			}
			
			int count = num[0]; // �̰� 0�̾�� ���x
			for(int i = 1; i<num.length; i++) {
				if(num[i] != 0) {
					// 0�� �ƴϸ� �Է¹��� ����� �ǹ�
					num[i] += count; // ī��Ʈ ����
					count = num[i]; // ī��Ʈ ����
				}	
			}
			
			for(int i=number-1; i>=0; i--) {
				num[data[i]]--; // �Է� �����Ͱ� �ִ� ���� ���� 1 ���̰�
				sort[num[data[i]]] = data[i];
				// �װ��� �ε����� �Ͽ� ������ ���� 
				
			}
			
			for(int i=0; i<number; i++) {
				bw.write(sort[i]+"\n");
			}			
			bw.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
