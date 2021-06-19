import java.util.*;
import java.io.*;
public class Problem11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int m1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			System.out.println(arr[m2] - arr[m1 - 1]);
		}
		br.close();
	}
}