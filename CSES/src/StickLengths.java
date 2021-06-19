import java.util.*;
import java.io.*;
public class StickLengths {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] lengths = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			lengths[i] = Long.parseLong(st.nextToken());
		Arrays.sort(lengths);
		int medianIndex = lengths.length / 2;
		long ans = 0;
		for(int i = 0; i < n; i++)
			ans += Math.abs(lengths[i] - lengths[medianIndex]);
		System.out.println(ans);
		br.close();
	}
}