import java.util.*;
import java.io.*;
import java.text.*;
public class prob03 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		double r = sc.nextDouble();
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(df.format(3.14159 * r * r * 0.75));
		sc.close();
	}
}