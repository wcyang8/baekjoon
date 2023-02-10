import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> testcase = new ArrayList<int[]>();
		String s = null;
		while (!(s = br.readLine()).equals("0")) {
			String[] sArr = s.split(" ");
			int N = Integer.parseInt(sArr[0]);
			int[] temp = new int[N];
			for (int i = 0; i < N; i++) {
				temp[i] = Integer.parseInt(sArr[i + 1]);
			}
			testcase.add(temp);
		}
		for (int[] iArr : testcase) {
			m.printComb(iArr);
			System.out.println();
		}
	}

	public void printComb(int[] arr) {
		int[] comb = new int[6]; // i개를 뽑는 조합
		int j;
		for (j = 0; j < 6; j++) { // 초기값 세팅
			comb[j] = j;
		}
		j--;
		while (j >= 0) { // i개 뽑기 시작
			for (int k : comb) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
			// 다음 조합
			comb[j]++;
			while (comb[j] >= arr.length + j - 5) { // 각 자리수의 최대값(=N+j-i+1)을 넘길 경우 carry 처리
				if (--j < 0) // j : 현재 가리키는 자리수. j가 0 이하의 자리수로 내려가면 break
					break; // --j : 한칸 왼쪽으로.
				comb[j]++; // 왼쪽 칸 1증가
			}
			if (j >= 0) { // j가 0 미만이면 원소 개수 i+1 부분집합으로 넘어감.
				while (j < 5) { // j가 가리키는 자리수가 끝 자리가 아니라면; carry가 생긴 경우
					comb[j + 1] = comb[j] + 1; // 마지막으로 carry를 넘긴 자리 수부터 다음 조합 세팅.
					j++; // 가리키는 자리수도 같이 1증가
				}
			}
		}
	}

}