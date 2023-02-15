import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[][] A;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] sArr = br.readLine().split(" ");

		N = Integer.parseInt(sArr[0]);
		M = Integer.parseInt(sArr[1]);
		int R = Integer.parseInt(sArr[2]);

		A = new int[N][M];

		for (int i = 0; i < N; i++) {
			sArr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(sArr[j]);
			}
		}

		sArr = br.readLine().split(" ");
		int time = 1;
		for (int i = 0; i < R; i++) {
//			if(i < R-1 && sArr[i].equals(sArr[i+1])) {
//				time++;
//				continue;
//			}
			int calNum = Integer.parseInt(sArr[i]);
			switch (calNum) {
			case 1:
				cal1(time);
//				time = 1;
				break;
			case 2:
				cal2(time);
//				time = 1;
				break;
			case 3:
				cal3(time);
//				time = 1;
				break;
			case 4:
				cal4(time);
//				time = 1;
				break;
			case 5:
				cal5(time);
//				time = 1;
				break;
			case 6:
				cal6(time);
//				time = 1;
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void cal1(int R) {
		if (R % 2 == 0)
			return;
		int temp;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				temp = A[i][j];
				A[i][j] = A[N - i - 1][j];
				A[N - i - 1][j] = temp;
			}
		}
	}

	public static void cal2(int R) {
		if (R % 2 == 0)
			return;
		int temp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp = A[i][j];
				A[i][j] = A[i][M - j - 1];
				A[i][M - j - 1] = temp;
			}
		}
	}

	public static void ijswap() {
		int[][] temp = new int[M][N];
		for (int i = 0; i < N; i++) { // i=j 대칭
			for (int j = 0; j < M; j++) {
				 temp[j][i] = A[i][j];
			}
		}
		A = temp;
		int t = N;
		N = M;
		M = t;
	}

	public static void cal3(int R) {
		switch (R % 4) {
		case 0:
			return;
		case 1:
			ijswap();
			cal2(1);
			break;
		case 2:
			cal1(1);
			cal2(1);
			break;
		case 3:
			ijswap();
			cal1(1);
			break;
		}
	}

	public static void cal4(int R) {
		cal3(4 - R);
	}

	public static void cal5(int R) {
		int[][] temp;
		int[] ti = { 0, 0, N / 2, N / 2 };
		int[] tj = { 0, M / 2, M / 2, 0 };
		switch (R % 4) {
		case 0:
			return;
		case 1:
			temp = new int[N][M];

			for (int k = 0; k < 4; k++) {
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						temp[i + ti[(k+1)%4]][j+tj[(k+1)%4]] = A[i + ti[k%4]][j + tj[k%4]];
					}
				}
			}
			A = temp;
			break;
		case 2:
			cal5(1);
			cal5(1);
			break;
		case 3:
			temp = new int[N][M];
			ti[1] = N / 2;
			tj[1] = 0;
			ti[3] = 0;
			tj[3] = M / 2;

			for (int k = 0; k < 4; k++) {
				for (int i = 0; i < N/2; i++) {
					for (int j = 0; j < M / 2; j++) {
						temp[i + ti[(k+1)%4]][j+tj[(k+1)%4]] = A[i + ti[k%4]][j + tj[k%4]];
					}
				}
			}
			A=temp;
			break;
		}
	}

	public static void cal6(int R) {
		cal5(4 - R);
	}
}