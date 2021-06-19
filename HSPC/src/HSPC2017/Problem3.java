package HSPC2017;
import java.io.*;
public class Problem3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String equation = br.readLine();
		int ans = Integer.parseInt(equation.substring(0, 1));
		if(equation.length() > 1) {
			int index = 1;
			while(!equation.substring(index, index + 1).equals("=")) {
				char c = equation.charAt(index);
				int n = Integer.parseInt(equation.substring(index + 1, index + 2));
				if(c == '+')
					ans += n;
				else
					ans -= n;
				index += 2;
			}
		}
		System.out.println(ans);
	}
}