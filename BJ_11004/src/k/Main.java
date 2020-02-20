package k;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			
			StringTokenizer st;
			String s = br.readLine();
			st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken()); // ���� ����
			int K = Integer.parseInt(st.nextToken()); // ã�ƾ� �ϴ� ���� ��ġ
			
			List<Integer> number = new ArrayList<>();
			
			s = br.readLine();
			st = new StringTokenizer(s);
			
			while(st.hasMoreTokens()) {
				number.add(Integer.parseInt(st.nextToken()));
			}

			br.close();
						
			Collections.sort(number);
			
			bw.write(number.get(K-1)+"\n");
			// �ε����� ������ ���̱� ������, K������ 1����
			bw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
