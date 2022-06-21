import java.util.*;
import java.io.*;
import java.text.*;
public class prob21 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		DecimalFormat df = new DecimalFormat("$#.00");
		while(sc.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			st.nextToken();
			String employee = st.nextToken();
			st = new StringTokenizer(sc.nextLine());
			st.nextToken();
			double rate = Double.parseDouble(st.nextToken());
			st = new StringTokenizer(sc.nextLine());
			st.nextToken();
			String in1 = st.nextToken();
			st = new StringTokenizer(sc.nextLine());
			st.nextToken();
			String out1 = st.nextToken();
			st = new StringTokenizer(sc.nextLine());
			st.nextToken();
			String in2 = st.nextToken();
			st = new StringTokenizer(sc.nextLine());
			st.nextToken();
			String out2 = st.nextToken();
			int shift1 = convert(out1) - convert(in1);
			int shift2 = convert(out2) - convert(in2);
			System.out.println(employee + " earned " + df.format((double)(shift1 + shift2) * (rate / (double)(60))));
		}
	}
	public static int convert(String time) {
		int hours = 60 * Integer.parseInt(time.substring(0, 2));
		int minutes = Integer.parseInt(time.substring(2));
		return hours + minutes;
	}
}