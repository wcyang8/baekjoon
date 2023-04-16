import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] f = new int[N + 1];

		// 표 생성
		for (int i = 1; i <= N; i++) {
			f[i] = Integer.parseInt(br.readLine());
		}

		// 정답 리스트
		List<Integer> ans = new ArrayList<>();

		// 1번부터 탐색
		for (int i = 1; i <= N; i++) {
			boolean[] visited = new boolean[N + 1];
			int t = f[i];
			visited[t] = true;
			while (true) {
				if (f[t] == i) {
					ans.add(i);
					break;
				}
				if(visited[f[t]])break;
				visited[f[t]] = true;
				t = f[t];
			}
		}

		sb.append(ans.size()).append("\n");
		for(int i : ans) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

}
