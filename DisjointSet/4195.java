import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// [���� 4195] ģ�� ��Ʈ��ũ
// https://blog.naver.com/tnwls0529/221809454390

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test_case;
		Map<String, Integer> management;
		Map<String, Integer> list[];

		try {
			test_case = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ���� �Է�
			for (int i = 0; i < test_case; i++) {
				// ���̽� �ݺ���
				int number = Integer.parseInt(br.readLine()); // ���� ��
				management = new HashMap<String, Integer>(); // �̸��� �ε����� ¦ ���� map
				list= new HashMap[number]; // ����鿡 ���� map�� ������ �迭
				int count = 0; // ���� ������ map�� �ε���

				for (int j = 0; j < number; j++) {
					String tmp = br.readLine();
					String token[] = tmp.split(" ");
					int index = 0; // ����� �� ������ �ε���

					if (!management.containsKey(token[0]) && !management.containsKey(token[1])) {
						// �� �� map�� ���� �̸�
						management.put(token[0], count);
						management.put(token[1], count);
						// �� �� count�� list�� �ε����� �� �� �ֵ��� ¦�� ������
						list[count] = new HashMap<String, Integer>();
						list[count].put(token[0], count);
						list[count].put(token[1], count);
						// list�� count �ε����� �߰�
						index = count; // ����� �ε��� ����
						count++; // count������ ������ ������ ��ġ�� ����Ű�� ���̱� ������ 1���� 
					}
					else if (!management.containsKey(token[0])) {
						// token[0]�� map�� ���� �̸�
						management.put(token[0], management.get(token[1])); // token[1]�� ���� �ε����� ������ ��
						list[management.get(token[1])].put(token[0], management.get(token[1])); // list���� �߰�
						index = management.get(token[1]); // ����� �ε��� token[1]�� �ε����� ����

					}
					else if (!management.containsKey(token[1])) {
						// token[1]�� map�� ���� �̸�
						management.put(token[1], management.get(token[0])); // token[0]�� ���� �ε����� ������ ��
						list[management.get(token[0])].put(token[1], management.get(token[0])); // list���� �߰�
						index = management.get(token[0]); // ����� �ε��� token[0]�� �ε����� ����
					}
					else {
						int x = management.get(token[1]); // ���� token[0]�� [1]�� �ε����� �ٸ� ��� ������ �� ����� �� �ֵ��� �̸� ������ �����س���.
						if(management.get(token[0]) == management.get(token[1])) {
							// ���� ��� �ƹ� ó�� x
						}
						else{
							// �ٸ� ���
							Iterator<Map.Entry<String, Integer>> iter = list[x].entrySet().iterator(); 
							while(iter.hasNext()) {
								Map.Entry<String, Integer>s = iter.next();
								if(s.getValue() == x) {
									management.put(s.getKey(), management.get(token[0]));
									list[management.get(token[0])].put(s.getKey(), management.get(token[0]));
								}
								//list[x] = null; // ������ ���ϴ� �κ��̶�� �����ߴµ�, �̺κ� ������ ��Ÿ�� ������ �߻���.
							}
							// token[1]�� ���� �ε����� ���鼭 value�� �������� ����. list���� �߰�
						}

						index = management.get(token[0]); // ����� �ε��� ����
					}
					bw.write(list[index].size()+"\n"); // list�� index���� ���� ����� �̸��� ����Ǿ� �����Ƿ�, size�� ������ָ� ��.

				}
			}

			br.close();
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
