import java.util.*;
import java.io.*;
public class Problem10211 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n + 1];
			for(int j = 1; j <= n; j++)
				arr[j] = arr[j - 1] + Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			for(int j = 1; j <= n; j++)
				for(int k = 0; k < j; k++)
					max = max < arr[j] - arr[k] ? arr[j] - arr[k]: max;
			System.out.println(max);
		}
		br.close();
	}
}