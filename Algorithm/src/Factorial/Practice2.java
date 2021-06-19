package Factorial;
import java.io.*;
public class Practice2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int res = 0;
		for(int i = 5; i <= number; i *= 5)
			res += number / i;
		System.out.println(res);
	}
}