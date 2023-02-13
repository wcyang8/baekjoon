import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> towers = new Stack<Integer>();
//		Stack<Integer> temp = new Stack<Integer>();
		int[] height = new int[N+1];
		
		String[] sArr = br.readLine().split(" ");
	
		for(int i = 0; i < N; i++) {
			height[i+1] = Integer.parseInt(sArr[i]);
		}
		height[0] = 100000001;
		towers.add(0);
//		
//		while(!towers.isEmpty()) {
//			int top = towers.pop();
//			if(towers.isEmpty()) {
//				sb.append(top);
//				continue;
//			}
//			while(towers.peek() < top) {
//				temp.add(towers.pop());
//			}
//			
//		}
//		
//
		
		
		int index = 0;
		for(int i = 1; i <= N; i++) {
			while(height[towers.peek()] < height[i]) {		//top < temp
				towers.pop();
			}
			sb.append(towers.peek() + " ");						//top > temp
			towers.add(i);
		}
		System.out.println(sb);
	}
}