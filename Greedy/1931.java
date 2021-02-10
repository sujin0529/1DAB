import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// [���� 1931] ȸ�ǽ� ����
// https://blog.naver.com/tnwls0529/221799975842

public class Main {
	
	static class Time{
		
		int start;
		int end;
		
		Time(int _start, int _end){
			start = _start;
			end = _end;
		}
	}
	
	static class EndComparator implements Comparator<Time>{

		@Override
		public int compare(Time o1, Time o2) {
			// TODO Auto-generated method stub

			if(o1.end>o2.end) {
				return 1;
			}
			else if(o1.end==o2.end) {
				return 0;
			}
			else {
				return -1;
			}
		}
		
	}
	
	static class StartComparator implements Comparator<Time>{

		@Override
		public int compare(Time o1, Time o2) {
			// TODO Auto-generated method stub

			if(o1.start>o2.start) {
				return 1;
			}
			else if(o1.start==o2.start) {
				return 0;
			}
			else {
				return -1;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		Time meeting[] = null;
		try {
			num = Integer.parseInt(br.readLine());
			meeting = new Time[num];
			for(int i=0; i<num; i++) {
				String temp = br.readLine();
				String token[] = temp.split(" ");
				meeting[i] = new Time(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
			}
			Arrays.sort(meeting, new StartComparator()); // ���� �ð��� ���ؼ� ����
			Arrays.sort(meeting, new EndComparator()); // �� �ð��� ���ؼ� ����
			br.close();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int count = 0; // ������ ȸ�� ��
		int last = 0; // ������ ȸ�� �ð�
		
		for(int i=0; i<num; i++) {
			if(meeting[i].start>=last) {
				// ȸ�� ���۽ð��� ������ ȸ�� �ð����� ũ�ų� ���ٸ�
				last = meeting[i].end; // ������ ȸ�� �ð��� �����ϰ�
				count++; // ȸ�� �� ����
			}
		}
		
		System.out.println(count);

	}

}
