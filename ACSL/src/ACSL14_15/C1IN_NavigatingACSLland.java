package ACSL14_15;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class C1IN_NavigatingACSLland {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1415C1In.in"));
		DecimalFormat hoursOrMinutes = new DecimalFormat("00");
		DecimalFormat money = new DecimalFormat("$##.00");
		int[] cityDistances = {450, 140, 120, 320, 250, 80};
		for(int i = 0; i < 10; i++) {
			int startCity = Integer.parseInt(sc.next().replace("A", "0").replace("B", "1").replace("C", "2").replace("D", "3").replace("E", "4").replace("F", "5"));
			int endCity = Integer.parseInt(sc.next().replace("B", "1").replace("C", "2").replace("D", "3").replace("E", "4").replace("F", "5").replace("G", "6"));
			double mpg = Integer.parseInt(sc.next().replace("C", "28").replace("M", "25").replace("F", "22").replace("V", "20"));
			double mph = Integer.parseInt(sc.next().replace("I", "65").replace("H", "60").replace("M", "55").replace("S", "45"));
			double ppg = sc.nextDouble();
			double distance = 0;
			for(int j = startCity; j < endCity; j++)
				distance += cityDistances[j];
			System.out.print((int)(distance) + " ");
			String hours = "";
			String minutes = "";
			hours = hoursOrMinutes.format((int)(distance / mph));
			minutes = hoursOrMinutes.format((distance % mph / mph * 60));
			System.out.print(hours + ":" + minutes + " ");
			double p = distance / mph * ppg * mph / mpg;
			String price = money.format(p);
			System.out.print(price);
			System.out.println();
		}
		sc.close();
	}
}