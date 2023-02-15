import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] paper = new boolean[100][100];
		
		int cnt = 0;
		for(int k = 0; k < N; k++) {
			String[] sArr = br.readLine().split(" ");
			
			int ci = Integer.parseInt(sArr[0]);
			int cj = Integer.parseInt(sArr[1]);
			
			for(int i = ci; i < ci+10; i++) {
				for(int j = cj; j < cj+10; j++) {
					if(!paper[i][j]) {
						paper[i][j] = true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}