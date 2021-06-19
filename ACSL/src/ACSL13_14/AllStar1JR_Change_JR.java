package ACSL13_14;
import java.util.*;
import java.io.*;
public class AllStar1JR_Change_JR {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1314AllStar1Jr.in"));
		for(int i = 0; i < 10; i++) {
			double price = sc.nextDouble();
			double payment = sc.nextDouble();
			int[] amountOfPayment = new int[10];
			double[] typesOfPayment = {100, 50, 20, 10, 5, 1, .25, .1, .05, .01};
			double change = addOrSubtract(payment, price);
			for(int j = 0; j < 10; j++) {
				while(addOrSubtract(change, typesOfPayment[j]) >= 0) {
					change = addOrSubtract(change, typesOfPayment[j]);
					amountOfPayment[j]++;
					if(String.valueOf(change).length() > 6)
						change += .000001;
				}
			}
			for(int j = 0; j < 10; j++)
				if(amountOfPayment[j] > 0)
					System.out.print(amountOfPayment[j]);
			System.out.println();
		}
		sc.close();
	}
	public static double addOrSubtract(double a, double b) {
		return ((a * 100) - (b * 100)) / 100;
	}
}