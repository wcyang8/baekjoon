import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");

		int N = Integer.parseInt(sArr[0]);
		int M = Integer.parseInt(sArr[1]);
		List<int[]> ch = new ArrayList<int[]>();
		List<int[]> h = new ArrayList<int[]>();

		int[][] city = new int[N][N];

		for (int i = 0; i < N; i++) {
			sArr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(sArr[j]);
				if (city[i][j] == 1)
					h.add(new int[] { i, j });
				if (city[i][j] == 2)
					ch.add(new int[] { i, j });
			}
		}

		int[] nextP = new int[ch.size()];		// 조합 : 다음 순열로 구현

		for (int i = ch.size() - 1; i >= ch.size() - M; i--) {		// 첫번째 조합 초기화
			nextP[i] = 1;
		}

		int minCCD = 1<<31-1;
		while (true) {
			//각 조합의 도시의 치킨 거리 구하기
			int CCD = 0;				//City Chicken Distance
			for(int[] hcoor : h) {
				int CD = 1<<30;			//Chicken Distance
				for(int i = 0; i < ch.size(); i++) {
					if(nextP[i] != 1) continue;
					int dist = Math.abs(hcoor[0] - ch.get(i)[0]) + Math.abs(hcoor[1] - ch.get(i)[1]);
					CD = Math.min(CD, dist);
				}
				CCD += CD;
			}
			minCCD = Math.min(minCCD, CCD);
			// 다음순열
			// 1. 뒤에부터 오름차순 구하기
			int index; // 뒤에부터 오름차순 깨지기 전 index
			for (index = ch.size() - 1; index > 0; index--) {
				if (nextP[index] > nextP[index - 1])
					break;
			}
			if (index <= 0)
				break;
			// 2. index부터 끝까지 nextP[index-1] 보다 큰 수 중 가장 작은 수 찾기
			int min = 1 << 30;
			int swapIndex = -1;
			for (int i = index; i < ch.size(); i++) {
				if (nextP[index - 1] < nextP[i]) {
					if (min > nextP[i]) {
						min = nextP[i];
						swapIndex = i;
					}
				}
			}
			// 3. index-1과 swapIndex 교체
			int temp = nextP[index-1];
			nextP[index-1] = nextP[swapIndex];
			nextP[swapIndex] = temp;
			// 4. index부터 끝까지 sort
			Arrays.sort(nextP, index, ch.size());
		}
		System.out.println(minCCD);
	}

}