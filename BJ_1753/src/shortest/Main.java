package shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	
	static class Pair implements Comparable{
		int v;
		int cost;
		public Pair(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			Pair o1 = (Pair)arg0;
			if(this.cost < o1.cost) {
				return -1;
			}
			else if(this.cost > o1.cost) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String st = br.readLine();
			String[] token = st.split(" ");
			int vertices = Integer.parseInt(token[0]);
			int edges = Integer.parseInt(token[1]);
			// ������ ������ ���� �Է�
			
			int start = Integer.parseInt(br.readLine()); // ���� ���� �Է�
			
			LinkedList[] matrix = new LinkedList[vertices+1];
			for(int i=1; i<=vertices; i++) {
				matrix[i] = new LinkedList<Pair>();
			}
			
			for(int i=0; i<edges; i++) {
				// cost �Է�
				st = br.readLine();
				token = st.split(" ");
				int s = Integer.parseInt(token[0]); // ������
				int f = Integer.parseInt(token[1]); // ����
				int cost = Integer.parseInt(token[2]); // ����ġ
				
				matrix[s].add(new Pair(f, cost));
			}
			
			PriorityQueue<Pair> queue = new PriorityQueue<>();
			
			int cost[] = new int[vertices+1]; // cost�� ������ �迭
			boolean visited[] = new boolean[vertices+1]; // �湮 ���θ� ������ �迭
			
			for(int i=1; i<=vertices; i++) {
				// cost �迭 �ʱ�ȭ
				cost[i] = Integer.MAX_VALUE;
			}
			
			Iterator<Pair> iter = matrix[start].iterator();
			while(iter.hasNext()) {
				Pair pair = iter.next();
				if(cost[pair.v] > pair.cost) {
					cost[pair.v] = pair.cost;
					queue.add(pair);
				}
			}
			cost[start] = 0;
			visited[start] = true;
			// �ڽ��� ����� �ʿ䰡 ����
			
			while(!queue.isEmpty()) {
				Pair temp = queue.remove();
				int minCost = temp.cost;
				int minIndex = temp.v;
				visited[minIndex] = true;
				iter = matrix[minIndex].iterator();
				while(iter.hasNext()) {
					Pair pair = iter.next();
					if(visited[pair.v] != true) {
						if(pair.cost + cost[minIndex] < cost[pair.v]) {
							cost[pair.v] = pair.cost + cost[minIndex];
							queue.add(new Pair(pair.v, cost[pair.v]));		
						}
					}	
				}
				// cost �缳��
			}
			
			for(int i=1; i<=vertices; i++) {
				if(cost[i] == Integer.MAX_VALUE) {
					System.out.println("INF");
				}
				else {
					System.out.println(cost[i]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
