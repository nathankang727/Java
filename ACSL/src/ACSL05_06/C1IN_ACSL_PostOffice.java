package ACSL05_06;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class C1IN_ACSL_PostOffice {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0506C1IN.in"));
		for(int i = 0; i < 10; i++) {
			DecimalFormat num = new DecimalFormat("##.00");
			double length = sc.nextDouble();
			double width = sc.nextDouble();
			double thickness = sc.nextDouble();
			double weight = sc.nextDouble();
			double n = 1;
			if(length >= 3.5 && length <= 4.25 && width >= 3.5 && width <= 6 && thickness >= .007 && thickness <= .016) {
				n += (int)(weight / .0625);
				if(weight % .0625 == 0)
					n--;
				n *= .2;
			}
			else if(length >= 4.25 && length <= 6 && width >= 6 && width <= 11.5 && thickness >= .007 && thickness <= .016) {
				n += (int)(weight / .0625);
				if(weight % .0625 == 0)
					n--;
				n *= .3;
			}
			else if(length >= 3.5 && length <= 6.125 && width >= 5 && width <= 11.5 && thickness >= .016 && thickness <= .25) {
				n += (int)(weight / .0625);
				if(weight % .0625 == 0)
					n--;
				n *= .47;
			}
			else if(length >= 6.125 && length <= 24 && width >= 11 && width <= 18 && thickness >= .25 && thickness <= .5) {
				n += (int)(weight / .0625);
				if(weight % .0625 == 0)
					n--;
				n *= .56;
			}
			else if((length + width + thickness) * 2 <= 84 && (length > 24 || width > 18 || thickness > .5)) {
				n += (int)(weight / .5);
				if(weight % .5 == 0)
					n--;
				n *= 1.50;
			}
			else if((length + width + thickness) * 2 > 84 && (length + width + thickness) * 2 < 130) {
				n += (int)(weight / .5);
				if(weight % .5 == 0)
					n--;
				n *= 1.75;
			}
			if(n != 1)
				System.out.println(num.format(n));
			else
				System.out.println("UNMAILABLE");
		}
		sc.close();
	}
}