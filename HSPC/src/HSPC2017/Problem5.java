package HSPC2017;
import java.io.*;
public class Problem5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 1;
		for(int i = 2; i <= n / 2; i++)
			if(n % i == 0)
				ans += i;
		System.out.println(ans == n ? "1" : "0");
	}
}