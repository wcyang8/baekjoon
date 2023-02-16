import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");
		int[] di = { 0, 1, 0, -1 };
		int[] dj = { 1, 0, -1, 0 };

		int N = Integer.parseInt(sArr[0]);
		int M = Integer.parseInt(sArr[1]);
		int K = Integer.parseInt(sArr[2]);

		int[][] A = new int[N][M];

		for (int i = 0; i < N; i++) {
			sArr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(sArr[j]);
			}
		}

		String[] cal = new String[K];
		// K번 연산 입력
		for (int k = 0; k < K; k++) {
			cal[k] = br.readLine();
		}
		// 입력 완료

		// 0~K-1까지 입력된 배열 생성
		int[] perm = new int[K];
		for (int i = 0; i < K; i++) {
			perm[i] = i;
		}
		
		int[][] clone = new int[N][M];
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				clone[n][m] = A[n][m];
			}
		}
		int min = 1<<30;
		while (true) {
			// K번 돌리기
			for (int k = 0; k < K; k++) {
				sArr = cal[perm[k]].split(" ");
				int r = Integer.parseInt(sArr[0]);
				int c = Integer.parseInt(sArr[1]);
				int s = Integer.parseInt(sArr[2]);

				for (int layer = 0; layer < s; layer++) {
					int ti = r - s - 1 + layer;
					int tj = c - s - 1 + layer;
					int temp = A[ti][tj];
					for (int d = 0; d < 4; d++) {
						while (ti + di[d] < r + s - layer && ti + di[d] >= r - 1 - s + layer
								&& tj + dj[d] < c + s - layer && tj + dj[d] >= c - 1 - s + layer) {
							ti += di[d];
							tj += dj[d];
							int temp2 = A[ti][tj];
							A[ti][tj] = temp;
							temp = temp2;
						}
					}
				}
			}// K번 돌리기 끝
			
			int minRow = 1<<30;
			for(int[] a : A) {// 배열 값 구하기
				int sum = 0;
				for(int i : a) {
					sum += i;
				}
				if(minRow > sum) minRow = sum;
			}
			if(min > minRow) min = minRow;
			// 순열(다음순열)
			// 오른쪽부터 내림차순 검색
			int i;
			for (i = K - 1; i > 0; i--) {
				if (perm[i] > perm[i - 1])
					break;
			}
			if (i == 0)			//전부 내림차순 = 마지막 순열
				break;
			//내림차순 중 내림차순 왼쪽 수 보다 큰 수 중 가장 작은 수 찾기
			int minv = 1 << 30;
			int minj = 0;
			for(int j = i; j < K; j++) {
				if(perm[i-1] < perm[j]) {
					if(minv > perm[j]) {
						minv = perm[j];
						minj = j;
					}
				}
			}
			int temp = perm[minj];		//swap
			perm[minj] = perm[i-1];
			perm[i-1] = temp;
			
			Arrays.sort(perm, i, K);	//i 이후 오름차순 정렬
			
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					A[n][m] = clone[n][m];
				}
			}
		}
		System.out.println(min);
	}
}