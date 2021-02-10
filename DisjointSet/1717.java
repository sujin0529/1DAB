import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [���� 1717] ������ ǥ��
// https://blog.naver.com/tnwls0529/221803389383

public class Main {
	
	static int find(int[] set,int element) {
		// �θ� ã�Ƽ� ��ȯ�ϴ� �޼ҵ�. ������ ��ȯ�ϸ� �ڱ��ڽ��� ��Ʈ
		int parent = set[element];
		while(parent >= 0) {
			if(set[parent]<0) {
				// parent�� �θ� -1�̸� parent�� root��� �ǹ��̹Ƿ� break
				break;
			}
			else {
				set[element] = find(set, parent);
				element = parent;
				parent = set[parent];
				
				// -1�� �ƴ϶�� ���� parent�� root�� �ƴ϶�� �ǹ��̹Ƿ� parent ����
			}
			
		}
		return parent;
	}
	
	static void combine(int[] set, int element1, int element2) {
		// ����� ����ϵ��� �ؾ߰ڳ�
		int parent1 = find(set, element1);
		int parent2 = find(set, element2);
		if(parent1<0 && parent2<0) {
			// �� �� ��Ʈ�� ���
			if(parent1<parent2) {
				// parent1�� �� ���� �ڽ�
				set[element2] = element1; // �θ� ����
				set[element1] += parent2; // ������ ����
			}
			else {
				set[element1] = element2; // �θ� ����
				set[element2] += parent1; // ������ ����
			}
		}
		else if(parent1<0) {
			// ù��°�� ��Ʈ�� ���
			int size2 = find(set, parent2); // �ι�° �� ������ �������
			if(element1 == parent2) {
				// �̹� ���� �����ΰ�
			}
			else if(parent1<size2) {
				// parent1�� �� ���� �ڽ�
				set[parent2] = element1; // �θ� ����
				set[element1] += size2; // ������ ����
			}
			else {
				set[element1] = parent2; // �θ� ����
				set[parent2] += parent1; // ������ ����
			}
		}
		else if(parent2<0) {
			// �ι�°�� ��Ʈ�� ���
			int size1 = find(set, parent1); // ù��° �� ������ �������
			if(parent1 == element2) {
				// �̹� ���� �����ΰ�
			}
			if(size1<parent2) {
				// parent1�� �� ���� �ڽ�
				set[element2] = parent1; // �θ� ����
				set[parent1] += parent2; // ������ ����
			}
			else {
				set[parent1] = element2; // �θ� ����
				set[element2] += size1; // ������ ����
			}
		}
		else if(parent1 == parent2) {
			// �θ� ������ -> �ƹ� �͵� ���� ����
		}		
		else {
			// �θ� ���� �ʰ� �� �� ��Ʈ�� �ƴ� ���
			int size1 = find(set, parent1); // ù��° �� ������ ���� ����
			int size2 = find(set, parent2); // �ι�° �� ������ �������
			if(size1<size2) {
				// parent1�� �� ���� �ڽ�
				set[parent2] = parent1; // �θ� ����
				set[parent1] += size2; // ������ ����
			}
			else {
				set[parent1] = parent2; // �θ� ����
				set[parent2] += size1; // ������ ����
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		String[] temp;
		try {
			s = br.readLine();
			temp = s.split(" ");
			
			int number = Integer.parseInt(temp[0]); // 0 - number ���� ������ �̷�
			int line = Integer.parseInt(temp[1]); // ������ ��
			
			int set[] = new int[number+1];
			for(int i=0; i<number+1; i++) {
				set[i] = -1; // ��� �ڽ��� ��Ʈ�� ������ �ʱ�ȭ
			}
			
			
			for(int i=0; i<line; i++) {
				s = br.readLine();
				temp = s.split(" ");
				int operator = Integer.parseInt(temp[0]); // 0�̸� ��, 1�̸� Ȯ��
				int operand_1 = Integer.parseInt(temp[1]); // ù ��° ����
				int operand_2 = Integer.parseInt(temp[2]); // �� ��° ����
				String result = ""; // ����� ���
				
				if(operator == 0) {
					if(operand_1 != operand_2) {
						combine(set, operand_1, operand_2);
					}
					// ���� �� operand�� ���ٸ� �θ� ������ �ʿ䰡 ����
				}
				else if(operator == 1) {
					int parent_1 = find(set, operand_1);
					int parent_2 = find(set, operand_2);
					if(parent_1<0 && parent_2<0) {
						// �� �� ��Ʈ
						if(operand_1 == operand_2) {
							result = "YES";
						}
						else {
							result = "NO";
						}
					}
					
					else if(parent_1<0) {
						// ù ��°�� ��Ʈ
						if(operand_1 == parent_2) {
							result = "YES";
						}
						else {
							result = "NO";
						}
					}
					else if(parent_2<0) {
						// �� ��°�� ��Ʈ
						if(parent_1 == operand_2) {
							result = "YES";
						}
						else {
							result = "NO";
						}
					}
					else {
						// �� �� ��Ʈ �ƴ�
						if(parent_1 == parent_2) {
							result = "YES";
						}
						else {
							result = "NO";
						}
					}
					
					System.out.println(result);
				}			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
