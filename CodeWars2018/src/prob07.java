import java.util.*;
import java.io.*;
public class prob07 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("input.txt"));
		boolean doBreak = false;
		while (!doBreak) {
			int n = in.nextInt();
			if (n == 0)
				doBreak = true;
			else {
				int[] arr = new int[n];
				ArrayList<Integer> negs = new ArrayList<Integer>();
				for (int i = 0; i < n; i++) {
					arr[i] = in.nextInt();
					if(arr[i] < 0)
						negs.add(arr[i]);
				}
				Arrays.sort(arr);
				Collections.sort(negs);
				if(negs.size() > 1) {
					System.out.println(Math.max(arr[arr.length - 3] * arr[arr.length - 2] * arr[arr.length - 1], arr[arr.length - 1] * negs.get(0) * negs.get(1)));
				}
				else
					System.out.println(arr[arr.length - 3] * arr[arr.length - 2] * arr[arr.length - 1]);
			}
		}
	}
}