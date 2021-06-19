import java.text.*;
import java.io.*;
public class prob06 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("0.0000");
		String s = br.readLine();
		while(!s.equals("0")) {
			double d = Double.parseDouble(s);
			System.out.println(df.format(Math.pow(d, 2.0 / 3.0)));
			s = br.readLine();
		}
		br.close();
	}
}