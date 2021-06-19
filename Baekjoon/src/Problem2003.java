import java.util.*;
import java.io.*;
public class Problem2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n + 1];
		for(int i = 1; i <= n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		int[] sums = new int[n + 1];
		for(int i = 1; i <= n; i++)
			sums[i] = sums[i - 1] + nums[i];
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(sums[i] < m)
				continue;
			int check = sums[i];
			int index = 1;
			while(check > m) {
				check -= nums[index];
				++index;
			}
			if(check == m)
				++count;
		}
		System.out.println(count);
		br.close();
	}
}