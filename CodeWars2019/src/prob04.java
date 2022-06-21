import java.util.*;
import java.io.*;
import java.text.*;
public class prob04 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		DecimalFormat df = new DecimalFormat("$0.00");
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			double taxRate = sc.nextDouble() / 100;
			double purchase = sc.nextDouble();
			double pretaxPrice = purchase / (1.0 + taxRate);
			double taxAmount = pretaxPrice * taxRate;
			System.out.println("On your " + df.format(purchase) + " purchase, the tax amount was " + df.format(taxAmount));
		}
		sc.close();
	}
}