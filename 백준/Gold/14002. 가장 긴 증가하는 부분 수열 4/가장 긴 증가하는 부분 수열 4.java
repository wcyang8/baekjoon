import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] C = new int[N + 1];
		int[] index = new int[N];					// index : i번째 수가 C에 들어간 위치

		int len = 1;
		C[1] = A[0];
		for (int i = 0; i < N; i++) {
			if (A[i] > C[len]) {
				C[++len] = A[i];
				index[i] = len;
				continue;
			}
			int start = 1;
			int end = len;
			while (start < end) {
				int mid = (start + end) / 2;
				if (A[i] > C[mid]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
			C[start] = A[i];
			index[i] = start;
		}
		Stack<Integer> stack = new Stack<>();
		sb.append(len).append('\n');
		for (int i = N - 1; i >= 0; i--) {			// index 오른쪽부터 len 5, 4, 3, 2, 1 탐색
			if (index[i] == len) {
				stack.add(A[i]);
				len--;
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		System.out.println(sb);
	}

}
