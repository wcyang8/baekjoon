import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		int i;
		for (i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		// 입력 완료
		// 1. 오른쪽 내림차순 찾기
		for (i = N - 2; i >= 0; i--) {
			if (input[i + 1] > input[i]) { // 찾기 완료 : i+1~N-1 까지가 내림차순
				int minIndex = -1; // 2. minIndex 찾기 : input[i+1~N-1] 에서 input[i]보다 큰 최소값 input을 가지는 index
				int min = N; // min : min = input[j]가 목표. input의 모든 값이 N보다 작거나 같으므로 N부터 시작.
				for (int j = i + 1; j < N; j++) {
					if (input[i] < input[j]) {
						min = Math.min(min, input[j]); // input[i]보다 크고, min보다 작은 input[j]가 있으면 갱신
						minIndex = j;
					}
				}
				int temp = input[i]; // 3. i와 minIndex값 swap
				input[i] = input[minIndex];
				input[minIndex] = temp;
				Arrays.sort(input, i + 1, N); // 4. i+1~n-1까지 오름차순으로 재정렬
				break;
			}
		}
		if (i == -1) {				// 5. i == -1 ; 오른쪽 내림차순 순열 중 input[i]보다 더 작은 값이 없음
			System.out.println(-1); // ; 이미 input 순열 전체가 내림차순; 마지막 순열
			return;
		}
		for (int in : input)
			System.out.print(in + " ");
		System.out.println();
	}

}