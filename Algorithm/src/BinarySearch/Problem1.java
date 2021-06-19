package BinarySearch;
import java.util.*;
public class Problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[] a = new int[k];
		long r = 0;
		for(int i = 0; i < k; i++) {
			a[i] += sc.nextInt();
			r += a[i];
		}
		r = r / n;
		int u = 0;
		long res = 0;
		for(long i = r; i >= 1; i--) {
			for(int j = 0; j < k; i++)
				u += a[j] / i;
			if(u == n) {
				res = i;
				break;
			}
		}
		System.out.println(res);
		sc.close();
	}
}
//4 11
//802
//743
//457
//539