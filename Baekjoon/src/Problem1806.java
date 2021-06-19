import java.util.*;
import java.io.*;
public class Problem1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n + 1];
		for(int i = 1; i <= n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		int[] sums = new int[n + 1];
		for(int i = 1; i <= n; i++)
			sums[i] = sums[i - 1] + nums[i];
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++) {
			int check = sums[i];
			if(check < s)
				continue;
			int count = i;
			for(int j = 1; j <= i; j++) {
				if(check - nums[j] < s)
					break;
				check -= nums[j];
				--count;
			}
			if(count < min)
				min = count;
		}
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
		br.close();
	}
}