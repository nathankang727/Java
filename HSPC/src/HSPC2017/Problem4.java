package HSPC2017;
import java.io.*;
public class Problem4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = "";
		for(int i = 0; i < n; i++)
			s += Integer.parseInt(br.readLine());
		System.out.println(Integer.parseInt(s) + 1);
	}
}
