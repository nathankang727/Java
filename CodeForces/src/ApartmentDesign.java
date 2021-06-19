import java.util.*;
import java.io.*;
public class ApartmentDesign {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] h = new int[n];
		long[] sums = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			h[i] = Integer.parseInt(st.nextToken());
		sums[0] = h[0];
		for(int i = 1; i < n; i++)
			sums[i] = (long)(h[i]) + sums[i - 1];
		for(int i = 0; i < q; i++) {
			long query = Integer.parseInt(br.readLine());
			int ans = Arrays.binarySearch(sums, query);
			if(ans < 0)
				ans = -(ans + 1);
			System.out.println(ans + 1);
		}
	}
}