import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[] di = {0,-1,0,1};
	static int[] dj = {1,0,-1,0};
	static int[][] region;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr;
		N = Integer.parseInt(br.readLine());
		region = new int[N][N];
		visit = new boolean[N][N];
		
		int min = 100;
		int max = 0;
		for(int i = 0; i < N; i++) {
			sArr = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				region[i][j] = Integer.parseInt(sArr[j]);
				if(min > region[i][j]) min = region[i][j];
				if(max < region[i][j]) max = region[i][j];
			}
		}
		
		int maxSafeArea = 1;
		
		for(int s = min; s < max; s++) {
			int SafeArea = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(region[i][j] > s && !visit[i][j]) {				//수면보다 높고, 방문하지 않은 경우 bfs
						bfs(i,j,s);
						SafeArea++;
					}
				}
			}
			if(maxSafeArea < SafeArea) maxSafeArea = SafeArea;			//최대값 갱신
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visit[i][j] = false;								//fill 대신..
				}
			}
		}
		System.out.println(maxSafeArea);
	}
	public static void bfs(int i, int j, int s) {
		visit[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			if(i+di[k] < 0 || i+di[k] >= N || j+dj[k] < 0 || j+dj[k] >= N) continue;
			if(region[i+di[k]][j+dj[k]] > s && !visit[i+di[k]][j+dj[k]]) {
				bfs(i+di[k], j+dj[k], s);
			}
		}
	}

}