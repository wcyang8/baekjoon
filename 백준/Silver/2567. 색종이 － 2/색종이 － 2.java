import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean[][] white = new boolean[100][100];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine());
			int ci = Integer.parseInt(st.nextToken());
			int cj = Integer.parseInt(st.nextToken());
			for(int i = ci; i < ci+10; i++) {
				for(int j = cj; j < cj+10; j++) {
					white[i][j] = true;
				}
			}
		}	//입력 완료
		
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			if(white[i][0]) cnt++;
			if(white[i][99]) cnt++;
			for(int j = 1; j < 100; j++) {
				if(white[i][j-1] != white[i][j]) cnt++;
			}
		}
		for(int j = 0; j < 100; j++) {
			if(white[0][j]) cnt++;
			if(white[99][j]) cnt++;
			for(int i = 1; i < 100; i++) {
				if(white[i-1][j] != white[i][j]) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
