import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] fact = new long[N+1];
		
		fact[0] = 1;
		for(int i = 1; i <= N; i++) {
			fact[i] = (fact[i-1]*i) % 1_000_000_007;
		}
		long res = ((fact[N] * pow(fact[K] , 1_000_000_005)) % 1_000_000_007)*pow(fact[N-K], 1_000_000_005)%1_000_000_007;
		System.out.println(res);
	}
	static long pow(long x, long time) {
		if(time == 0) return 1;
		if(time == 1) return x;
		
		long half = time/2;
		long odd = time%2;
		long down = pow(x, half);
		
		return ((down * down) % 1_000_000_007)*pow(x,odd)%1_000_000_007;
	}
}
