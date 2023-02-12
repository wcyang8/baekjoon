import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * 완전 탐색 1)한 칸에서 시작. 
 * 2) 4칸을 어떻게든 간다. 
 * 3) max 갱신 
 * 4) 출력 예상 시간 복잡도 : O(N x M x 10?)
 * -> 최대 50만~100만
 * 
 * 문제점) ㅜ 모양 해결이 안됨.
 * 
 * @author SSAFY *
 */

public class Main {
	static boolean[][] visit;
	static int[][] paper;
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1};
	static int N, M;
	static int max = 0;
	static int maxI, maxJ;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read = br.readLine().split(" ");

		N = Integer.parseInt(read[0]);
		M = Integer.parseInt(read[1]);

		visit = new boolean[N][M];
		paper = new int[N][M];

		for (int i = 0; i < N; i++) {
			read = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(read[j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//System.out.println("------시작------");//check
				visit[i][j] = true;
				search(i, j, 0, 0);
				visit[i][j] = false;
			}
		}
		System.out.println(max);
	}

	public static void search(int x, int y, int cnt, int sum) {
		sum += paper[x][y];
		//System.out.println(x+" "+y+" "+cnt+" "+sum);//check
		if (cnt == 3) {
			if (max < sum) {
				//System.out.println("------최대-------");//check
				max = sum;
			}
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M && !visit[x + dx[i]][y + dy[i]]) {
				boolean flag = false;
				for(int j = 0; j < 8; j+=2) {
					if(x + dx[i]+dx[j] < 0 || x+dx[i]+dx[j] >= N || y+dy[i]+dy[j] < 0 || y+dy[i]+dy[j] >= M) continue;
					if(visit[x+dx[i]+dx[j]][y+dy[i]+dy[j]]) flag = true;
				}
				if(!flag) continue;
				visit[x + dx[i]][y + dy[i]] = true;
				search(x + dx[i], y + dy[i], cnt + 1, sum);
				visit[x + dx[i]][y + dy[i]] = false;
			}
		}
	}
}