import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s;
		int[] alter = new int[26];
		
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				int alphabet = s.charAt(j) - 'A';
				alter[alphabet] += Math.pow(10,s.length()-j - 1);
			}
		}
		
		Arrays.sort(alter);
		int sum = 0;
		for(int i = 25; i >= 0; i--) {
			sum += alter[i]*(i-16);
		}
		System.out.println(sum);
	}
}