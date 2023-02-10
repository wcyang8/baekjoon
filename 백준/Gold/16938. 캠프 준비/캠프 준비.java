import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(sArr[0]);
		int L = Integer.parseInt(sArr[1]);
		int R = Integer.parseInt(sArr[2]);
		int X = Integer.parseInt(sArr[3]);
		
		sArr = br.readLine().split(" ");
		int[] problems = new int[N];
		for(int i = 0; i < N; i++) {
			problems[i] = Integer.parseInt(sArr[i]);
		}
		
		int cnt = 0;
		for(int mask = 1; mask < 1<<N; mask++) {
			int sum = 0;
			int min = 1000000000;
			int max = 0;
			for(int i = 0; i < N; i++) {
				if((mask & 1<<i) != 0) {
					sum += problems[i];
					if(min > problems[i]) min = problems[i];
					if(max < problems[i]) max = problems[i];
				}
			}
			if(sum >= L && sum <= R && max - min >= X) cnt++;
		}
		System.out.println(cnt);
	}

}
