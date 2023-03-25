import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] board;
	static Set<Integer> s = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 탐색
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				move(i, j, board[i][j], 1);
			}
		}
		System.out.println(s.size());
	}
	private static void move(int i, int j, int cur, int len) {
		if(len == 6) {
			s.add(cur);
			return;
		}
		for(int k = 0; k < 4; k++) {
			int ni = i + d[k][0];
			int nj = j + d[k][1];
			if(ni >= 0 && ni < 5 && nj >= 0 && nj < 5) {
				move(ni, nj, cur * 10 + board[ni][nj], len+1);
			}
		}
	}

}
