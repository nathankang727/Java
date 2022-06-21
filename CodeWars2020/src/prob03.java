import java.io.*;
public class prob03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 1; i <= Math.min(x, y); i++) {
			if(x % i == 0 && y % i == 0)
				ans = i;
		}
		System.out.println(ans);
		br.close();
	}
}