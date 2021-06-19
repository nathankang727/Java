package ACSL13_14;
import java.io.*;
public class AllStar3_Repeat {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1314AllStar3.in")));
		for(int i = 0; i < 20; i++) {
			String decimalPart = br.readLine().substring(2);
			int n = 0;
			for(int j = decimalPart.length() / 3; j > 0; j--) {
				String s = decimalPart.substring(decimalPart.length() - j);
				int part = decimalPart.indexOf(s) - j;
				if(part + j * 3 == decimalPart.lastIndexOf(s)) {
					n = j;
					break;
				}
			}
			int x = decimalPart.length() - n * 3;
			int numerator = Integer.parseInt(decimalPart.substring(0, x + n));
			if(x > 0)
				numerator -= Integer.parseInt(decimalPart.substring(0, x));
			int denominator = (int)(Math.pow(10, n + x) - Math.pow(10, x));
			int greatestCommonFactor = gcf(numerator, denominator);
			System.out.println(numerator / greatestCommonFactor + " / " + denominator / greatestCommonFactor);
		}
		br.close();
	}
	public static int gcf(int n1, int n2) {
		for(int i = n1; i > 1; i--)
			if(n1 % i == 0 && n2 % i == 0)
				return i;
		return 1;
	}
}