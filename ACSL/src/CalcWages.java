import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
public class CalcWages {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("CalcWages.in")));
		DecimalFormat df = new DecimalFormat("####.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		for(int i = 0; i < 3; i++) {
			String s = br.readLine().replace(",", "");
			StringTokenizer st = new StringTokenizer(s);
			double[] hours = new double[5];
			for(int j = 0; j < 5; j++)
				hours[j] = Double.parseDouble(st.nextToken());
			double rate = Double.parseDouble(st.nextToken());
			double total = 0;
			for(int j = 0; j < 5; j++)
				total += hours[j] * rate;
			System.out.println(df.format(total));
		}
		br.close();
	}
}