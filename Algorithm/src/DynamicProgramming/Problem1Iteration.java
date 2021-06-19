package DynamicProgramming;
import java.util.*;
public class Problem1Iteration {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] d = new int[n + 1];
		for(int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + 1;
			if(i % 2 == 0 && d[i] > d[i / 2] + 1)
				d[i] = d[i/ 2] + 1;
			if(i % 3 == 0 && d[i] > d[i / 3] + 1)
				d[i] = d[i / 3] + 1;
		}
		System.out.println(d[n]);
		in.close();
	}
}