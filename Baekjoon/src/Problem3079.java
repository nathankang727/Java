import java.util.*;
import java.io.*;
public class Problem3079 {
	static int n, m;
	static int[] desk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		desk = new int[n];
		for(int i = 0; i < n; i++)
			desk[i] = Integer.parseInt(br.readLine());
		Arrays.sort(desk);
		long low = 0;
		long high = (long)(1000000000) * (long)(1000000000);
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
		System.out.println(ans);
		br.close();
	}
	public static boolean check(long time) {
		long maxPeople = 0;
		for(int i = 0; i < n; i++) {
			maxPeople += time / (long)(desk[i]);
			if(maxPeople >= m)
				return true;
		}
		return false;
	}
}