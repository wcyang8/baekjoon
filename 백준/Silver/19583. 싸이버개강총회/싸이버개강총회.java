import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> Name = new HashSet<String>();
		Set<String> before = new HashSet<String>();
		Set<String> after = new HashSet<String>();
		String s = br.readLine();
		String[] sArr = s.split(" ");
		String startTime = sArr[0];
		String endPTime = sArr[1];
		String endSTime = sArr[2];
		while((s = br.readLine()) != null) {
            if(s == null) break;
			sArr = s.split(" ");
			Name.add(sArr[1]);
			if(sArr[0].compareTo(startTime) <= 0) before.add(sArr[1]);
			if(sArr[0].compareTo(endPTime) >= 0 && sArr[0].compareTo(endSTime) <= 0) after.add(sArr[1]);
		}
		int count = 0;
		for(String n : Name) {
			if(before.contains(n) && after.contains(n)) {
				count++;
			}
		}
		System.out.println(count);
	}

}
