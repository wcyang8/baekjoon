package wc_bj_14713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		Queue<String>[] parrot = null;
		Queue<String> L = null;
		
		int N;
		try {
			s = br.readLine();
			N = Integer.parseInt(s);
			parrot = new LinkedList[N];		//앵무새 N마리에 넣어줄 문장의 단어들을 넣을 큐의 배열
			L = new LinkedList<String>();		//문장 L의 단어들을 넣어줄 큐
			
			for(int i = 0; i < N; i++) {
				s = br.readLine();
				String[] word = s.split(" ");
				parrot[i] = new LinkedList<String>();
				for(String w : word) {
					parrot[i].add(w);
				}
			}
			s = br.readLine();
			String[] word = s.split(" ");
			for(String w : word) {
				L.add(w);
			}												//입력 완료
		} catch (IOException e) {
			e.printStackTrace();
		}							//예외 처리
		for(String w : L) {			//문장 판별 시작 : 문장 L의 단어 w를 하나씩 검사.
			boolean flag = false;				//for문을 2개 빠져나와야 하므로 flag 생성
			for(Queue<String> q : parrot) {		//w와 같은 단어가 각 parrot의 peek에 있는 단어와 같아야 함. why?
												//w는 w를 가지는 parrot의 단어들 중 가장 먼저 오는 단어일 수 밖에 없기 때문.
				if(!q.isEmpty()) {			//각 parrot의 peek와 같은지 체크하는 과정
					if(w.equals(q.peek())) {
						q.remove();
						flag = true;
						break;
					}
				}
			}
			if(!flag) {		//만약 peek들 중 w와 일치하는 단어가 없으면? Impossible
				System.out.println("Impossible");
				return;
			}
		}
		boolean checkEmpty = true;			//parrot의 문장이 전부 empty여야 함. why?
		for(Queue<String> q : parrot) {		//조건에 "앵무새는 자신이 기억하고 있는 문장을 끝까지 말함"
			if(!q.isEmpty()) {
				checkEmpty = false;		//하나라도 empty가 아니면 false
				break;
			}
		}
		if(checkEmpty)
			System.out.println("Possible");		//전부 통과했으면 Possible
		else
			System.out.println("Impossible");	//아니라면 Impossible
	}

}
