import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// [���� 1976] ���� ����
// https://blog.naver.com/tnwls0529/221805489573

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ������ ��
		int country[][] = new int[N][N];
		
		int M = sc.nextInt(); // ���� ��ȹ�� ���� ������ ��
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				country[i][j] = sc.nextInt();
			}
		}
		// 1 ����, 0 ���� x
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) {
					country[i][j] = 1;
				}
				
			}
		}
		// i->i �� ��� �ݵ�� ����
		
		Set<Integer> same = null;
		Set<Integer> management[] = new HashSet[N];
		
		int size = 0; // ó�� ���� �� ������ ����
			
		for(int i=0; i<N; i++) {
			
			same = new HashSet<Integer>();
			for(int j=0; j<N; j++) {
				if(country[i][j]==1) {
					// ���� ���� �Ǿ��ִٸ�
					same.add(i);
					same.add(j);
					// �� �� ���տ� �߰�
				}
			}
			if(!same.isEmpty()) {
				// same�� ������� �ʴٸ� ���� �������� ������� ���� �ִٴ� �ǹ�
				management[size] = same;
				size++;
				// size�� ���� ������ ������ ������ �ǹ��ϸ�, ���� ������ ��ġ�� �ε��� ���� �ǹ���
			}
			
		}

		for(int i=0; i<size-1; i++) {
			if(management[i]==null) {
				// null�� ��� �������� ���ϵ��� ��
				continue;
			}
			for(int j=i+1; j<size; j++) {
				if(management[j]==null) {
					// null�� ��� �������� ���ϵ��� ��.
					continue;
				}
				Set<Integer> temp = new HashSet<Integer>(management[i]); // management[i] ���� ����
				temp.retainAll(management[j]); // ������ Ȯ��
				if(!temp.isEmpty()) {
					// �������� �ִٴ� �ǹ�
					management[i].addAll(management[j]); // ������
					management[j] = null; // management[j]�� null�� ����� ������ ���� ǥ��
				}
			}
		}

		Set<Integer> visit_country = new HashSet<Integer>();
		for(int i=0; i<M; i++) {
			// �湮�Ϸ��� ���� �Է� �ޱ�
			visit_country.add(sc.nextInt()-1);
		}
		
		String result = "NO";
		for(int i=0; i<size; i++) {
			if(management[i] == null) {
				// null�� ��� �������� ���ϵ��� ��.
				continue;
			}
			else if(management[i].containsAll(visit_country)) {
				// ���� management[i]�� visit_country ������ �����Ѵٸ� �����η� �����ϴٴ� �ǹ�
				result = "YES";
			}
		}
		
		System.out.println(result);

	}

}
