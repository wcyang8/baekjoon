package wc_bj_1182_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		int N = 0;
		int S = 0;
		int[] arr = null;

		// 입력 시작
		try {
			s = br.readLine();
			String[] sArr = s.split(" ");
			N = Integer.parseInt(sArr[0]);
			S = Integer.parseInt(sArr[1]);
			arr = new int[N];
			s = br.readLine();
			sArr = s.split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(sArr[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 입력 완료
		//카운팅 시작
		int count = 0;
		for (int i = 1; i <= N; i++) {		//원소가 i개인 부분집합
			int[] comb = new int[i];		//i개를 뽑는 조합
			int j;
			for (j = 0; j < i; j++) {		//초기값 세팅
				comb[j] = j;
			}
			j--;
			while (j >= 0) {			//i개 뽑기 시작
				int sum = 0;		//원소 총합
				for (int k : comb) {
					sum += arr[k];
				}
				if (sum == S)		//총합이 S면 카운팅
					count++;
				//다음 조합
				comb[j]++;
				while (comb[j] >= N + j - i + 1) {	//각 자리수의 최대값(=N+j-i+1)을 넘길 경우 carry 처리
					if (--j < 0)			//j : 현재 가리키는 자리수. j가 0 이하의 자리수로 내려가면 break
						break;				//--j : 한칸 왼쪽으로.
					comb[j]++;				//왼쪽 칸 1증가
				}
				if (j >= 0) {	//j가 0 미만이면 원소 개수 i+1 부분집합으로 넘어감.
					while(j < i - 1) {		//j가 가리키는 자리수가 끝 자리가 아니라면; carry가 생긴 경우
						comb[j + 1] = comb[j] + 1;		//마지막으로 carry를 넘긴 자리 수부터 다음 조합 세팅.
						j++;				//가리키는 자리수도 같이 1증가
					}
				}
			}
		}
		System.out.println(count);
	}

}
