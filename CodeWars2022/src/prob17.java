import java.util.*;
import java.text.*;
import java.io.*;
public class prob17 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		int width = Integer.parseInt(st.nextToken()) * 12 + Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int length = Integer.parseInt(st.nextToken()) * 12 + Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int depth = Integer.parseInt(st.nextToken()) * 12 + Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int priceR = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int priceP = Integer.parseInt(st.nextToken());
		double total = length * width * depth / 46656.0;
		double r = (0.8 * total * 1000);
		r = Math.ceil(r) / 1000;
		double p = (0.2 * total * 1000);
		p = Math.ceil(p) / 1000;
		double t = ((priceR * r + priceP * p) * 100);
		t = Math.ceil(t) / 100;
		DecimalFormat df1 = new DecimalFormat("0.000");
		System.out.println("R " + df1.format(r) + " cu yd");
		System.out.println("P " + df1.format(p) + " cu yd");
		DecimalFormat df2 = new DecimalFormat("0.00");
		System.out.println("T " + df2.format(t) + " dollars");
		br.close();
	}
}