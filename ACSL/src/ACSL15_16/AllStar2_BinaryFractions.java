package ACSL15_16;
import java.util.*;
import java.io.*;
import java.text.*;
public class AllStar2_BinaryFractions {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1516AllStar2.in")));
		DecimalFormat df = new DecimalFormat(".000000");
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double numerator = Integer.parseInt(st.nextToken());
			double denominator = Integer.parseInt(st.nextToken());
			double quotient = numerator / denominator;
			int intQuotient = (int)(numerator) / (int)(denominator);
			String intPart = Integer.toString(intQuotient, 2);
			double temp = Double.parseDouble(String.valueOf(quotient).substring(1));
			String fracPart = "";
			for(int j = 0; j < 6; j++) {
				temp *= 2;
				fracPart += String.valueOf(temp).substring(0, 1);
				temp = Double.parseDouble(String.valueOf(temp).substring(1));
			}
			double d = 0;
			for(int j = 0; j < fracPart.length(); j++)
				d += Integer.parseInt(fracPart.substring(j, j + 1)) * (1 / Math.pow(2, j + 1));
			System.out.println(intPart + "." + fracPart + ", " + intQuotient + df.format(d));
		}
		br.close();
	}
}