import java.util.*;
import java.io.*;
public class MaximumMedian {
	static int n, k, nums[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		long low = (long)(nums[nums.length / 2]);
		long high = (long)(nums[nums.length - 1]) + (long)(k);
		long mid = 0;
		long ans = 0;
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
	public static boolean check(long mid) {
		long cnt = 0;
		for(int i = (n - 1) / 2; i < n; i++)
			cnt += Math.max(0, mid - (long)(nums[i]));
		return cnt <= k;
	}
}