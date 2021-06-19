package ACSL12_13;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class C1IN_TimeSheets {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1213C1In.in"));
		DecimalFormat money = new DecimalFormat("$##.00");
		for(int i = 0; i < 10; i++) {
			int location = sc.nextInt();
			int day = sc.nextInt();
			int half_hours = Math.abs(convert(sc.next()) - convert(sc.next()));
			int location2 = sc.nextInt();
			int day2 = sc.nextInt();
			int half_hours2 = Math.abs(convert(sc.next()) - convert(sc.next()));
			double salaries = 0;
			double salaries2 = 0;
			for(int j = 1; j <= half_hours; j++)
				salaries += salary(location, day, j);
			for(int j = 1; j <= half_hours2; j++)
				salaries2 += salary(location2, day2, j);
			if(String.valueOf(salaries2).length() == 6)
				salaries2 += .005;
			double total = salaries + salaries2;
			System.out.println(money.format(total));
		}
		sc.close();
	}
	public static int convert(String c) {
		if(c.equals("A"))
			return 10;
		else if(c.equals("B"))
			return 11;
		else if(c.equals("C"))
			return 12;
		else if(c.equals("D"))
			return 13;
		else if(c.equals("E"))
			return 14;
		else if(c.equals("F"))
			return 15;
		else if(c.equals("G"))
			return 16;
		else if(c.equals("H"))
			return 17;
		else
			return Integer.parseInt(c);
	}
	public static double salary(int l, int d, int h) {
		if(l >= 100 && l <= 199 & h <= 10)
			return 5;
		else if(l >= 100 && l <= 199 && h > 10)
			return 7.5;
		else if(l >= 200 && l <= 299 && h <= 12)
			return 3.75;
		else if(l >= 200 && l <= 299 && h > 12)
			return 7.5;
		else if(l >= 300 && l <= 399 && h <= 8)
			return 4.625;
		else if(l >= 300 && l <= 399 && h > 8)
			return 5.25;
		else if(l >= 400 && l <= 499 && (d == 1 || d == 7))
			return 6.75;
		else if(l >= 400 && l <= 499 && (d != 1 || d != 7))
			return 3.375;
		else if(l >= 500 && l <= 599 && h <= 12)
			return 4;
		else
			return 6;
	}
}