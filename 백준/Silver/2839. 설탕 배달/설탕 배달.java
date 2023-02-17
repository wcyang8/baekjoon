import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int result;
		int cnt5 = N / 5;
		int R = N - cnt5 * 5;
		while (R % 3 != 0) {
			cnt5--;
			R += 5;
		}
		if (N >= R) {
			int cnt3 = R / 3;
			result = cnt3 + cnt5;
		}
		else result = -1;
		
		System.out.println(result);
	}

}
