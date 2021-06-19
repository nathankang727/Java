package ACSL12_13;
import java.util.*;
import java.io.*;
import java.text.*;
public class AllStar1_ACSL_Gold {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1213AllStar1.in"));
		DecimalFormat money = new DecimalFormat("##.00");
		for(int i = 0; i < 2; i++) {
			double troyCost = sc.nextDouble();
			for(int j = 0; j < 5; j++) {
				double weight = sc.nextDouble();
				double unit = Double.valueOf(sc.next().replace("GN", "0.0021").replace("GM", "0.0321")
				.replace("PN", "0.05").replace("TR", "1").replace("ON", "0.9115"));
				String p = sc.next();
				double purity = pure(p);
				double percent = (100 - sc.nextDouble()) / 100;
				String res = money.format(troyCost * weight * unit * purity * percent / 100);
				System.out.println(res);
			}
		}
		sc.close();
	}
	public static double pure(String p) {
		if(p.equals("24"))
			return 100;
		else if(p.equals("22"))
			return 91.7;
		else if(p.equals("18"))
			return 75;
		else if(p.equals("14"))
			return 58.3;
		else if(p.equals("12"))
			return 50;
		else if(p.equals("8"))
			return 33.3;
		else if(p.equals("6"))
			return 25;
		else
			return 4.167;
	}
}