package baekjoon.wc_bj_10972.wc_bj_10972_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public int N;
	public int[] input;
	public int[] last;
	public boolean flag;
	
	public static void main(String[] args) {
		Main m = new Main();
		
		List<Integer> state = new ArrayList<Integer>();
		
		if(m.input.equals(m.last)) {
			System.out.println(-1);
			return;
		}
		//m.perm(0, state);
	}
	public Main(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		last = new int[N];
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		for(int i = N; i >= 1; i--) {
			last[i] = i;
		}
		flag = false;
	}

	public void perm(int cur, int[] state) {
		if(cur == N) {
			if(flag == false)
				if(input.equals(state)) flag = true;
		}
		for(int i = 0; i < N; i++) {
			if(state[i] == 0) {
				int[] temp = state.clone();
				temp[cur] = i+1;
				perm(cur+1,temp);
			}
		}
		
	}
}
