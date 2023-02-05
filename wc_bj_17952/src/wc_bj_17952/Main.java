package wc_bj_17952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		int N;
		int score = 0;
		Stack<List<Integer>> hwSchedule = new Stack<>();
		try {	//BufferedReader를 사용해서 입력 받기
			s = br.readLine();	//예외 처리 필수
			N = Integer.parseInt(s);
			for(int i = 0; i < N; i++) {	//i분 경과
				s = br.readLine();
				String[] sArr = s.split(" ");
				if(Integer.parseInt(sArr[0]) == 1) {	//과제 정보 첫 칸 = 1 : 과제 삽입
					List<Integer> hw = new ArrayList<Integer>();
					hw.add(Integer.parseInt(sArr[1]));
					hw.add(Integer.parseInt(sArr[2]));
					hwSchedule.add(hw);
				}
				if(!hwSchedule.empty()) {						//과제 스케쥴 실행
					List<Integer> temp = hwSchedule.peek();
					hwSchedule.pop();
					if(temp.get(1) == 1) {		//과제가 이번 실행에 끝남
						score += temp.get(0);	//점수 획득
						continue;
					}
					temp.set(1, temp.get(1) - 1);	//과제 진행
					hwSchedule.add(temp);			//과제 스케줄에 다시 넣어줌.
				}
			}
		} catch (IOException e) {	//예외 처리
			e.printStackTrace();
		}
		System.out.println(score);
	}

}
