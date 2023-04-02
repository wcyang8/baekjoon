import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static List<int[]>[] edges;
	static int[] sum;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		
		sum = new int[N];
		
		edges = new ArrayList[N];
		
		// 간선 배열 초기화
		for(int v = 0; v < N; v++) {
			edges[v] = new ArrayList<int[]>();
		}
		
		// 간선 입력
		for(int e = 0; e < M; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			edges[from].add(new int[] {to,cost});
		}
		
		dijkstra(X,N);
		for(int i = 0; i < N; i++) {
			dijkstra(i,X);
		}
		
		Arrays.sort(sum);
		
		System.out.println(sum[N-1]);
	}
	private static void dijkstra(int start, int end) {
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		
		dist[start] = 0;
		pq.add(new int[] {start,0});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[0] == end) {
				sum[start] += cur[1];
				return;
			}
			for(int[] next : edges[cur[0]]) {
				if(dist[next[0]] > dist[cur[0]] + next[1]) {
					dist[next[0]] = dist[cur[0]] + next[1];
					pq.add(new int[] {next[0],dist[next[0]]});
				}
			}
		}
		for(int i = 0; i < N; i++) {
			sum[i] += dist[i];
		}
	}

}
