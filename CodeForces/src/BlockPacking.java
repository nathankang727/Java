import java.util.*;
import java.io.*;
public class BlockPacking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if(n == 1 || m == 1)
			System.out.println(0);
		else
			System.out.println(Math.max((n / a) * (m / b), (n / b) * (m / a)));
		br.close();
	}
}