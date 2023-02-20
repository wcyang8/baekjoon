import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static String tank = "^v<>";
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static char[][] map;
	static int H, W, cur_i, cur_j, cur_d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		String[] sArr;
		String s;

		for (int test_case = 1; test_case <= T; test_case++) {
			sArr = br.readLine().split(" ");
			H = Integer.parseInt(sArr[0]);
			W = Integer.parseInt(sArr[1]);

			map = new char[H][W];

			cur_i = -1;
			cur_j = -1;
			cur_d = -1;
			for (int h = 0; h < H; h++) {
				s = br.readLine();
				for (int w = 0; w < W; w++) {
					map[h][w] = s.charAt(w);
					if (tank.indexOf(map[h][w]) != -1) {
						cur_i = h;
						cur_j = w;
						cur_d = tank.indexOf(map[h][w]);
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			s = br.readLine();

			for (int k = 0; k < N; k++) {
				command(s.charAt(k));
			}
			sb.append('#').append(test_case).append(' ');
			for(char[] m : map) {
				for(char c : m)
					sb.append(c);
				sb.append('\n');
			}
		}
        System.out.println(sb);
	}

	static void command(char c) {
		int d = 0; // tank.charAt(0) = '^', 1 : 'v', 2 : '<', 3 : '>'
		switch (c) {
		case 'R':
			d++;
		case 'L':
			d++;
		case 'D':
			d++;
		case 'U':
			move(d);
			break;
		case 'S':
			shoot();
		}
	}

	static void move(int d) {
		cur_d = d;
		int next_i = cur_i + di[cur_d];
		int next_j = cur_j + dj[cur_d];
		if ((next_i >= 0 && next_i < H) && (next_j >= 0 && next_j < W) && map[next_i][next_j] == '.') {
			map[cur_i][cur_j] = '.';
			cur_i = next_i;
			cur_j = next_j;
		}
		map[cur_i][cur_j] = tank.charAt(cur_d);
	}

	static void shoot() {
		int bomb_i = cur_i + di[cur_d];
		int bomb_j = cur_j + dj[cur_d];
		while ((bomb_i >= 0 && bomb_i < H) && (bomb_j >= 0 && bomb_j < W)) {
			if (map[bomb_i][bomb_j] == '*') {
				map[bomb_i][bomb_j] = '.';
				break;
			}
			if (map[bomb_i][bomb_j] == '#') {
				break;
			}
			bomb_i += di[cur_d];
			bomb_j += dj[cur_d];
		}
	}
}