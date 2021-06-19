package DivideAndConquer;
import java.util.*;
public class Problem3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int res = 0;
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		for(int i = n, j = 0; i >= 1; i--) {
			res += a[j] * i;
			j++;
		}
		System.out.println(res);
		sc.close();
	}
}