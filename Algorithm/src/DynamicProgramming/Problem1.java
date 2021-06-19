package DynamicProgramming;
import java.io.*;
public class Problem1 {
	private static int[] d = new int[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(comp(n));
	}
	public static int comp(int n) {
		if(n == 1)
			return 0;
		if(d[n] > 0)
			return d[n];
		d[n] = comp(n - 1) + 1;
		if(n % 2 == 0) {
			int temp = comp(n / 2) + 1;
			if(d[n] > temp)
				d[n] = temp;
		}
		if(n % 3 == 0) {
			int temp = comp(n / 3) + 1;
			if(d[n] > temp)
				d[n] = temp;
		}
		return d[n];
	}
}