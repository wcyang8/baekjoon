import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");
		int N, M;
		
		N = Integer.parseInt(sArr[0]);
		M = Integer.parseInt(sArr[1]);
		
		Deque<Integer> deq = new ArrayDeque<Integer>();
		
		for(int i = 1; i <= N; i++) deq.add(i);
		
		sArr = br.readLine().split(" ");
		int[] remove = new int[M];
		
		for(int i = 0; i < M; i++) remove[i] = Integer.parseInt(sArr[i]);
		
		int cnt = 0;
		for(int i : remove) {
			int left = 0;					//2번 실행 횟수
			int size = deq.size();			//실행 이전 덱 size 저장
			
			int temp = deq.pollFirst();
			while(temp != i) {
				deq.addLast(temp);
				temp = deq.pollFirst();
				left++;
			}
			cnt += Math.min(left, size - left);
		}
		System.out.println(cnt);
	}

}