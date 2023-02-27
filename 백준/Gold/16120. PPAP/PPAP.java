import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		Stack<Character> st = new Stack<Character>();

		int Pcnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'P') {
				if(!st.isEmpty() && st.peek() == 'A') {
					if(Pcnt >= 2) {
						for(int k = 0; k < 3; k++) st.pop();
						Pcnt--;
					}
				}
				else Pcnt++;
			}
			if(s.charAt(i) == 'A') {
				if(Pcnt < 2) Pcnt = 0;
				if(!st.isEmpty() && st.peek() == 'A') {
					System.out.println("NP");
					return;
				}
			}
			st.add(s.charAt(i));
		}
		if(st.size() == 1 && st.peek() == 'P') System.out.println("PPAP");
		else System.out.println("NP");
		return;
	}

}