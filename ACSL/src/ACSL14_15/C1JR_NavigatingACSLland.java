/*
Start Time: 10:26
End Time: 11:10
*/
package ACSL14_15;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class C1JR_NavigatingACSLland {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1415C1Jr.in"));
		for(int i = 0; i < 2; i++) {
			int mileage = sc.nextInt();
			double price = sc.nextDouble();
			int mph = sc.nextInt();
			int[] distances = {450, 140, 120, 320, 250, 80};
			for(int j = 0; j < 5; j++) {
				double totalDistance = 0;
				String a = sc.next();
				String b = sc.next();
				int start = convert(a);
				int end = convert(b);
				for(int k = start; k < end; k++)
					totalDistance += distances[k];
				System.out.print((int)(totalDistance) + " ");
				String s = "";
				if(totalDistance / mph < 10)
					s += "0";
				s += String.valueOf((int)totalDistance / mph);
				System.out.print(s + ":");
				double z = totalDistance % mph / mph;
				z *= 60;
				String u = format2(z);
				System.out.print(u + " ");
				double y = totalDistance / mph;
				double o = y * price;
				double q = o * (double)mph;
				double f = q / (double)mileage;
				String w = format(f);
				if(w.indexOf(".") == w.length() - 2)
					w += "0";
				System.out.print(w);
				System.out.println();
			}
		}
		sc.close();
	}
	public static int convert(String city) {
		if(city.equals("A"))
			return 0;
		else if(city.equals("B"))
			return 1;
		else if(city.equals("C"))
			return 2;
		else if(city.equals("D"))
			return 3;
		else if(city.equals("E"))
			return 4;
		else if(city.equals("F"))
			return 5;
		else
			return 6;
	}
	public static String format(double money) {
		DecimalFormat currency = new DecimalFormat("$###.##");
		String output1 = currency.format(money);
		return output1;
	}
	public static String format2(double number) {
		DecimalFormat currency = new DecimalFormat("00");
		String output1 = currency.format(number);
		return output1;
	}
}