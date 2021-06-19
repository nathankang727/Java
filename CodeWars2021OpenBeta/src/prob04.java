import java.util.*;
import java.io.*;
import java.text.*;
public class prob04 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		DecimalFormat df = new DecimalFormat("#.0");
		while(!input.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input);
			double d1 = Double.parseDouble(st.nextToken());
			double d2 = Double.parseDouble(st.nextToken());
			System.out.println(d1 + " " + d2);
			double ans = d1 * d2;
			System.out.println(df.format(ans));
			input = sc.nextLine();
		}
		sc.close();
	}
}
