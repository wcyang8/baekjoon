import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int[] di = { 1, 0, -1, 0 };
		int[] dj = { 0, 1, 0, -1 };

		int N = Integer.parseInt(sArr[0]);
		int M = Integer.parseInt(sArr[1]);
		int R = Integer.parseInt(sArr[2]);

		int[][] A = new int[N][M];

		for (int i = 0; i < N; i++) {
			sArr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(sArr[j]);
			}
		}

		for (int r = 0; r < R; r++) {
			for (int layer = 0; layer < Math.min(M, N) / 2; layer++) {
				int ti = layer;
				int tj = layer;
				int temp = A[ti][tj];
				for (int d = 0; d < 4; d++) {
					while (ti + di[d] < N - layer && ti + di[d] >= layer && tj + dj[d] < M - layer
							&& tj + dj[d] >= layer) {
						int temp2 = A[ti + di[d]][tj + dj[d]];
						A[ti + di[d]][tj + dj[d]] = temp;
						temp = temp2;
						ti += di[d];
						tj += dj[d];
					}
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}