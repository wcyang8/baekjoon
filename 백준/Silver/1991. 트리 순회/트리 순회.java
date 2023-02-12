import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public class tree {
		public int value;
		public tree parent = null;
		public tree leftChild = null;
		public tree rightChild = null;
		public boolean visit = false;
	}
	
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
				trees[tempLC].parent = trees[tempP];
			}
			if (tempRC >= 0) {
				trees[tempP].rightChild = trees[tempRC];
				trees[tempRC].parent = trees[tempP];
			}
		}
		
		pre(trees[0]);
		System.out.println();
		in(trees[0]);
		System.out.println();
		post(trees[0]);
	}


	public static void pre(tree t) {
		System.out.print((char)('A'+t.value));
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
		System.out.print((char)('A'+t.value));
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
		System.out.print((char)('A'+t.value));
	}
}