package ACSL20_21;
import java.io.*;
class C1IN_2021Result {
	public static int sumOfLastRow(int s, int d, int r) {
		int base10Num = Integer.parseInt(String.valueOf(s), 8);
		int base10Delta = Integer.parseInt(String.valueOf(d), 8);
		int loops = 0;
		for(int i = 1; i <= r - 1; i++)
			loops += i;
		--loops;
		base10Num += base10Delta * loops;
		int res = 0;
		for(int i = 1; i <= r; i++) {
			base10Num += base10Delta;
			res += sumDigits(Integer.toOctalString(base10Num));
		}
		return res;
	}
	public static int sumDigits(String s) {
		int sum = 0;
		for(int i = 0; i < s.length(); i++)
			sum += Integer.parseInt(s.substring(i, i + 1));
		return sum;
	}
}
public class C1IN_NumeralTriangles {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine().trim());
        int d = Integer.parseInt(br.readLine().trim());
        int r = Integer.parseInt(br.readLine().trim());
        int result = C1IN_2021Result.sumOfLastRow(s, d, r);
        System.out.println(String.valueOf(result));
        br.close();
	}
}