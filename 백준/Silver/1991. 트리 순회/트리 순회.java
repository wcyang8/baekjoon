import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public class tree {
		public int value;
		public tree leftChild = null;
		public tree rightChild = null;
	}
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr;
		int N = Integer.parseInt(br.readLine());
		Main m = new Main();
		
		tree[] trees = new tree[N];
		
		for(int i = 0; i < N; i++) {
			trees[i] = m.new tree();
			trees[i].value = i;
		}
		for (int i = 0; i < N; i++) {
			int tempP, tempLC, tempRC;
			sArr = br.readLine().split(" ");

			tempP = sArr[0].charAt(0) - 'A';
			tempLC = sArr[1].charAt(0) - 'A';
			tempRC = sArr[2].charAt(0) - 'A';

			if (tempLC >= 0) {
				trees[tempP].leftChild = trees[tempLC];
			}
			if (tempRC >= 0) {
				trees[tempP].rightChild = trees[tempRC];
			}
		}
		
		pre(trees[0]);
		sb.append('\n');
		in(trees[0]);
		sb.append('\n');
		post(trees[0]);
		System.out.println(sb);
	}


	public static void pre(tree t) {
		sb.append((char)('A'+t.value));
		if(t.leftChild != null) {
			pre(t.leftChild);
		}
		if(t.rightChild != null) {
			pre(t.rightChild);
		}
	}
	public static void in(tree t) {
		if(t.leftChild != null) {
			in(t.leftChild);
		}
		sb.append((char)('A'+t.value));
		if(t.rightChild != null) {
			in(t.rightChild);
		}
	}
	public static void post(tree t) {
		if(t.leftChild != null) {
			post(t.leftChild);
		}
		if(t.rightChild != null) {
			post(t.rightChild);
		}
		sb.append((char)('A'+t.value));
	}
}