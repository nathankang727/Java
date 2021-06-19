import java.util.*;
import java.io.*;
public class Problem2805 {
	static int n, m;
	static int[] trees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		trees = new int[n];
		for(int i = 0; i < n; i++)
			trees[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(trees);
		int low = 0;
		int high = trees[n - 1];
		int mid = 0;
		int ans = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(check(mid)) {
				ans = mid;
				low = mid + 1;
			}
			else
				high = mid - 1;
		}
		System.out.println(ans);
		br.close();
	}
	public static boolean check(int num) {
		long sum = 0;
		for(int i = 0; i < n; i++)
			sum += (long)(trees[i]) - (long)(num) >= 0 ? (long)(trees[i]) - (long)(num) : 0;
		return sum >= (long)(m);
	}
}