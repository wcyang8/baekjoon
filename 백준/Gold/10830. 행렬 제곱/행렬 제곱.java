import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] A;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		A = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()) % 1000;		// 원소가 전부 1000인 케이스 때문에 미리 1000
			}
		}
		// A^B 각 원소 출력
		for(int[] t : pow(B)) {
			for(int i : t) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static int[][] pow(long B) {
		if(B == 1) return A;
		
		int[][] res = pow(B/2);
		res = mul(res,res);
		if(B % 2 == 1) {
			res = mul(res,A);
		}
		return res;
	}
	
	static int[][] mul(int[][] src, int[][] dest){
		int[][] result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					result[i][j] += src[i][k]*dest[k][j];
				}
				result[i][j] %= 1000;
			}
		}
		
		return result;
	}
}