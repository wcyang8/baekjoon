import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, camNum;
	static int[][] office;
	static int[][] temp;
	static List<Integer> camera;
	static int[][][] camDir;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		//앞에 int 붙이는 실수 조심
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		temp = new int[N][M];
		camera = new ArrayList<Integer>();
		
		camDir = new int[5][][];
		camDir[0] = new int[][]{{0,1}};
		camDir[1] = new int[][] {{0,1},{0,-1}};
		camDir[2] = new int[][] {{0,1},{-1,0}};
		camDir[3] = new int[][] {{0,1},{-1,0},{0,-1}};
		camDir[4] = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
		
		int zero = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if(office[i][j] == 6) continue;
				if(office[i][j] > 0) {
					camera.add(i);					//카메라 위치와 종류 저장
					camera.add(j);
					camera.add(office[i][j]);
				}
				else zero++;						//office 안의 0 개수
			}
		}
		camNum = camera.size() / 3;					//3칸을 쓰므로 3으로 나누면 사이즈
		
		int max = 0;								//각 조합별 감시중인 구역(-1) 최대값
		for(int state = 0; state < (1<<(2*camNum)); state++){
			reset();
			max = Math.max(max,simul(state));
		}
		System.out.println(zero - max);
	}
	static void reset() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				temp[i][j] = office[i][j];
			}
		}
	}
	static int simul(int state) {					//시뮬레이션
		int result = 0;
		for(int cam = 0; cam < camNum; cam++) {
			int ci = camera.get(cam*3 + 0);
			int cj = camera.get(cam*3 + 1);
			int type = camera.get(cam*3 + 2) - 1;
			int rot = (((state & (1<<(2*cam))) != 0)?1:0) + (((state & (1<<(2*cam + 1))) != 0)?2:0);
			for(int[] d: camDir[type]) {
				int di = d[0];
				int dj = d[1];
				for(int r = 0; r < rot; r++) {		//회전
					int tmp = di;
					di = dj;
					dj = -tmp;
				}
				for(int s = 1; ci + di*s >= 0 && ci + di*s < N && cj + dj*s >=0 && cj + dj*s < M;s++) {
					if(temp[ci+di*s][cj+dj*s] == 6) break;
					if(temp[ci+di*s][cj+dj*s] == 0) {
						result++;
						temp[ci+di*s][cj+dj*s] = -1;
					}
				}
			}
		}
		return result;
	}
}