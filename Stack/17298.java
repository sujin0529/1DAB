import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// [���� 17298] ��ū��
// https://blog.naver.com/tnwls0529/222220586594

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int count = Integer.parseInt(br.readLine());
			int[] num = new int[count];
			int[] result = new int[count]; // �ش� ���� �ε���
			Stack<Integer> stack = new Stack<>();
			String[] token = br.readLine().split(" ");
			
			for(int i=0; i<count; i++) {
				int tmp = Integer.parseInt(token[i]);
				stack.add(tmp);
				num[i] = tmp;
			}
			
			for(int i=0; i<count; i++) {
				// ��ū���� ��ã�� ��� ����� -1�̹Ƿ�, ��� ����� -1�� �ʱ�ȭ
				result[i] = -1;
			}
			

			while(stack.size() > 1) {
				int top = stack.pop();
				int index = stack.size() - 1;
				int topIndex = stack.size();
				
				if(num[index] < top) {
					result[index] = topIndex;
				}
				else {
					while(result[topIndex] >= 0) {
						if(num[index] < num[result[topIndex]]) {
							result[index] = result[topIndex];
							break;
						}
						else {
							topIndex = result[topIndex];
						}
					}
				}	
			}
			for(int i=0; i<count; i++) {
				if(result[i] == -1) {
					bw.write(-1+" ");
				}
				else {
					bw.write(num[result[i]]+" ");
				}
			}
			bw.write("\n");
			
			br.close();
			bw.close();
		}catch(Exception e) {
			
		}
	}
}