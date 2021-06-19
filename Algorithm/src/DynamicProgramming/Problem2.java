package DynamicProgramming;
import java.io.*;
public class Problem2 {
	private static int[] dp = new int[10007];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		System.out.println(op(number));
	}
	public static int op(int n) {
		if(n == 0) {
			dp[0] = 1;
			return dp[0];
		}
		else if(n == 1) {
			dp[1] = 1;
			return dp[1];
		}
		else {
			if(dp[n] != 0)
				return dp[n];
			dp[n] = (op(n - 1) + op(n - 2)) % 10007;
			return dp[n];
		}
	}
}