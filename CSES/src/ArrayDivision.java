import java.util.*;
import java.io.*;
public class ArrayDivision {
	static int n, k, x[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			x[i] = Integer.parseInt(st.nextToken());
		long low = 1;
		long high = (long)(1000000000) * (long)(n);
		long mid = 0;
		long ans = 1;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				high = mid - 1;
			}
			else
				low = mid + 1;
		}
		System.out.println(ans);
		br.close();
	}
	public static boolean check(long mid) {
		int groups = 1;
		long sum = 0;
		for(int i = 0; i < n; i++)
			if(mid < x[i])
				return false;
		for(int i = 0; i < n; i++) {
			sum += x[i];
			if(sum > mid) {
				++groups;
				sum = x[i];
			}
		}
		return groups <= k;
	}
}