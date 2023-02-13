import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 10;
		LinkedList<String> password = new LinkedList<String>();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i < N; i++) password.add(st.nextToken());
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			
			for(int i = 0; i < M; i++) {
				st.nextToken();
				int offset = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				for(int j = 0; j < K; j++) {
					password.add(offset+j,st.nextToken());
				}
			}
			
			sb.append("#"+test_case+" ");
			for(int i = 0; i < 10; i++)sb.append(password.get(i)).append(" ");
			sb.append("\n");
			
			password.clear();
		}
		System.out.println(sb);
	}
}