package ACSL21_22;
import java.util.*;
import java.math.*;
import java.text.*;
public class C4IN_FibonacciAndMandelbrot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float r = sc.nextFloat();
		float i = sc.nextFloat();
		System.out.println(cycleLength(r, i));
		sc.close();
	}
	public static String cycleLength(double realPartC, double imagPartC) {
		DecimalFormat df = new DecimalFormat("0.0000");
		DecimalFormat df2 = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		double fReal = realPartC;
		double fImag = imagPartC;
		ArrayList<Complex> list = new ArrayList<Complex>();
		boolean escape = false;
		int cnt = 1;
		while(list.isEmpty() || fReal != realPartC || fImag != imagPartC) {
			double tempR = fReal * fReal - fImag * fImag + realPartC;
			double tempI = 2 * fReal * fImag + imagPartC;
			fReal = Double.parseDouble(df2.format(Double.parseDouble(df.format(tempR))));
			fImag = Double.parseDouble(df2.format(Double.parseDouble(df.format(tempI))));
			++cnt;
			boolean contains = false;
			int index = -1;
			for(Complex c : list) {
				++index;
				if(c.r == fReal && c.i == fImag) {
					contains = true;
					break;
				}
			}
			list.add(new Complex(fReal, fImag));
			if(contains) {
				++index;
				cnt = cnt - index;
				break;
			}
			if(Math.sqrt(fReal * fReal + fImag * fImag) > 4) {
				escape = true;
				break;
			}
		}
		return escape ? "ESCAPES " + cnt : "" + (cnt - 1);
    }
	static class Complex {
		public double r;
		public double i;
		public Complex(double real, double imaginary) {
			r = real;
			i = imaginary;
		}
	}
}