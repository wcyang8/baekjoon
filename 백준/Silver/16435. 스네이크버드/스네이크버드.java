import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(sArr[0]);
		int L = Integer.parseInt(sArr[1]);
		PriorityQueue<Integer> fruits = new PriorityQueue<Integer>();
		
		sArr = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			fruits.add(Integer.parseInt(sArr[i]));
		}
		
		while(!fruits.isEmpty()) {
			if(L < fruits.poll()) break;
			L++;
		}
		System.out.println(L);
	}

}
