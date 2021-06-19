package HSPC2017;
import java.io.*;
public class Problem2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0; i < num; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > 0)
				ans += n;
		}
		System.out.println(ans);
	}
}