package GraphTheory;
import java.util.*;
public class Problem6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int[] a = new int[m];
			int[] b = new int[m];
			for(int j = 0; j < m; j++) {
				a[j] = j + 1;
				b[j] = sc.nextInt();
			}
		}
		sc.close();
	}
}