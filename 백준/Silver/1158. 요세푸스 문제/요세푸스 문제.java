import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(sArr[0]);
		int K = Integer.parseInt(sArr[1]);
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i = 0; i < K - 1; i++) q.add(q.poll());
			sb.append(q.poll());
			if(!q.isEmpty()) sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}

}
