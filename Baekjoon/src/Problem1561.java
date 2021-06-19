import java.util.*;
import java.io.*;
public class Problem1561 {
	static int n, m;
	static int[] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		a = new int[m];
		for(int i = 0; i < m; i++)
			a[i] = Integer.parseInt(st.nextToken());
		long low = 0;
		long high = (long)(30) * (long)(2000000000);
		long mid = 0;
		long ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				high = mid - 1;
				ans = mid;
			}
			else
				low = mid + 1;
		}
		if(n <= m)
			System.out.println(n);
		else {
			long sum = (long)(m);
			for(int i = 0; i < m; i++)
				sum += (ans - 1) / a[i];
			for(int i = 0; i < m; i++) {
				if(ans % a[i] == 0)
					++sum;
				if(sum == n) {
					System.out.println(i + 1);
					break;
				}
			}
		}
		br.close();
	}
	public static boolean check(long time) {
		long sum = (long)(m);
		for(int i = 0; i < m; i++)
			sum += time / a[i];
		return sum >= n;
	}
}